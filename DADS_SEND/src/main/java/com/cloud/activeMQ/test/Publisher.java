package com.cloud.activeMQ.test;

import java.util.Date;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Publisher {
	
	public static void main(String[] args) {
		String user = ActiveMQConnection.DEFAULT_USER;
		String password = ActiveMQConnection.DEFAULT_PASSWORD;
		String url = "tcp://localhost:61616";
		String subject = "myMessageListenerTopic";
		ActiveMQConnectionFactory factory  = new ActiveMQConnectionFactory(user,password,url);
		Connection connection;
		try {
			connection = factory.createConnection();
			connection.start();
			Session session = connection.createSession(Boolean.TRUE,  Session.AUTO_ACKNOWLEDGE);
			
			  
			  
			Topic topic = session.createTopic(subject);
			MessageProducer producer = session.createProducer(topic); 
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);
			for (int i = 1; i <= 1; i++) { 
				MapMessage message = session.createMapMessage();
				Date date = new Date();
				message.setLong("count",2132323232 );
				message.setString("name", "liuxueyaoyao");
				message.setStringProperty("bai", "du");
				Thread.sleep(1000);
				producer.send(message);
				System.out.println("--发送消息：" + date);
				session.commit();
			}
			session.close(); 
			connection.close(); 
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) 
		{ 
			e.printStackTrace(); 
		}
		
		
		
		
 	}

	
}
