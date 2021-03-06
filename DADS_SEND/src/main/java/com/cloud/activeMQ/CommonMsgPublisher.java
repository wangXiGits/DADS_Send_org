package com.cloud.activeMQ;

import java.net.URLEncoder;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
/**
 * 用于发送JMS消息的通用方法,通过spring管理对象
 * 项目名称：DADS   
 * 类名称：CommonMsgPublisher   
 * 类描述：暂无 
 * 修改备注： 
 * @version
 */
@Component
public class CommonMsgPublisher implements MessagePublisher{
	private static Logger log = Logger.getLogger(CommonMsgPublisher.class);
	@Autowired
	private JmsTemplate jmsTemplate;
	/**
	 * 
	 */
	@Override
	public synchronized boolean sendByQuene(final String msg, final String queneName) {
		boolean ret = false;
		try {
			
			jmsTemplate.setDefaultDestinationName(queneName);
			jmsTemplate.send( new MessageCreator() {
				@Override
				public Message createMessage(Session session) throws JMSException {
						try {
							log.info("准备发送JMS消息，queneName："+queneName);
							return  session.createTextMessage(URLEncoder.encode(msg,"utf-8"));
						} catch (Exception e) {
							e.printStackTrace();
						}
						return null;
				}
			});
			ret = true;
			log.info("JMS消息发送成功,msg ："+msg);
		} catch (JmsException e) {
			e.printStackTrace();
		}
		return ret;
	}
	@Override
	public synchronized void sendQueue(final String msg) {
		jmsTemplate.setPubSubDomain(false);
		jmsTemplate.send(new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				
				Queue queue = session.createQueue("myQueue22");
				jmsTemplate.setDefaultDestination(queue);
				return session.createTextMessage(msg);
			}
		});
	}
	@Override
	public synchronized void sendTopic(final String msg) {
		jmsTemplate.setPubSubDomain(false);
		jmsTemplate.send(new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				
				Queue queue = session.createQueue("myQueue33");
				jmsTemplate.setDefaultDestination(queue);
				
				return session.createTextMessage(msg);
			}
		});
	}
	@Override
	public synchronized void sendQueue4(final String msg) {
		jmsTemplate.setPubSubDomain(false);
		ConnectionFactory connFactory = jmsTemplate.getConnectionFactory();
		Session session;
        // Destination ：消息的目的地;消息发送给谁.
        Destination destination1;
        Destination destination2;
        // MessageProducer：消息发送者
        MessageProducer producer1;
        MessageProducer producer2;
		try {
			Connection connection = connFactory.createConnection();
			connection.start();
            // 获取操作连接
            session = connection.createSession(Boolean.TRUE,
                    Session.AUTO_ACKNOWLEDGE);
            // 获取session注意参数值xingbo.xu-queue是一个服务器的queue，须在在ActiveMq的console配置
            destination1 = session.createQueue("myQueue44");
            destination2 = session.createQueue("myQueue55");
            // 得到消息生成者【发送者】
            producer1 = session.createProducer(destination1);
            // 设置不持久化，此处学习，实际根据项目决定
            producer1.setDeliveryMode(DeliveryMode.PERSISTENT);
            // 构造消息，此处写死，项目就是参数，或者方法获取
            sendMessage(session, producer1);
            
            producer2 = session.createProducer(destination2);
            producer1.setDeliveryMode(DeliveryMode.PERSISTENT);
            // 构造消息，此处写死，项目就是参数，或者方法获取
            sendMessage(session, producer2);
            session.commit();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public static void sendMessage(Session session, MessageProducer producer) {
		TextMessage message;
		try {
			message = session.createTextMessage("ActiveMq 发送的消息");
			// 发送消息到目的地方
			System.out.println("发送消息：" + "ActiveMq 发送的消息");
			producer.send(message);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}