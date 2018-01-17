package com.cloud.activeMQ;

import java.net.URLEncoder;

import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.jms.JmsException;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.cloud.send.observer.util.PropertiesReader;

/**
 * 用于在观察者模式中发送JMS消息的,手动管理对象
 * <br>项目名称：DADS   
 * <br>类名称：ObsDataMsgPublisher   
 * <br>类描述：暂无 
 * <br>创建人：RCM
 * <br>创建时间：2014-5-29 下午03:26:01   
 * <br>修改人：
 * <br>修改时间：
 * <br>修改备注： 
 * @version
 */
public class ObsDataMsgPublisher implements MessagePublisher{
  
	private static ObsDataMsgPublisher _instance = null;
	private static JmsTemplate jmsTemplate;
	private ObsDataMsgPublisher(){};
	
	public static synchronized ObsDataMsgPublisher getInstance()
	{
		if(_instance==null)
		{
			_instance = new ObsDataMsgPublisher();
			ActiveMQConnectionFactory mqFactory = new ActiveMQConnectionFactory();
			mqFactory.setBrokerURL(PropertiesReader.getProp("jms.dads.url"));
			CachingConnectionFactory cachFactory = new CachingConnectionFactory(mqFactory);
			cachFactory.setSessionCacheSize(Integer.parseInt(PropertiesReader.getProp("jms.cachSessionNum")));
			jmsTemplate = new JmsTemplate(cachFactory);
			jmsTemplate.setPubSubDomain(false);//p2p方式
			jmsTemplate.setDeliveryMode(DeliveryMode.PERSISTENT);//采用持久化方式
		}
		return _instance;
	}
	@Override
	public synchronized boolean sendByQuene(final String msg, final String queueName) {
		boolean ret = false;
		try {
			
			log.info(this.getClass().getSimpleName()+"--准备发送JMS消息，queueName："+queueName);
			log.info(this.getClass().getSimpleName()+"--msg ："+msg);
			jmsTemplate.setDefaultDestinationName(queueName);
			jmsTemplate.send( new MessageCreator() {
				@Override
				public Message createMessage(Session session) throws JMSException {
						try {
							return  session.createTextMessage(URLEncoder.encode(msg,"utf-8"));
						} catch (Exception e) {
							e.printStackTrace();
						}
						return null;
				}
			});
			ret = true;
			log.info(this.getClass().getSimpleName()+"--JMS消息发送成功");
		} catch (JmsException e) {
			e.printStackTrace();
		}
		return ret;
	}

	//一下两种方式可以用来发送主题或者队列消息，注意这里因为改变了jmsTemplate的状态，所以需要进行同步控制
	@Override
	public synchronized void sendTopic(final String msg) {
		jmsTemplate.setPubSubDomain(true);
		jmsTemplate.send(new ActiveMQTopic(PropertiesReader.getProp("jms.topic.EMRTOPIC")),new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(msg);
			}
		});
		System.out.println("成功发送一条JMS topic 消息！");
	}

	@Override
	public synchronized void sendQueue(final String msg) {
		jmsTemplate.setPubSubDomain(true);
		jmsTemplate.send(new ActiveMQQueue(PropertiesReader.getProp("jms.queue.EMRQUEUE")),new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(msg);
			}
		});
	}

	@Override
	public void sendQueue4(String msg) {
		
	}
}
