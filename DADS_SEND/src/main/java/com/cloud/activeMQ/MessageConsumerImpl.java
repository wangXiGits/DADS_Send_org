package com.cloud.activeMQ;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
@Component
public class MessageConsumerImpl implements MessageListener {
	@Autowired
	JmsTemplate jmsTemplate;

	@Override
	public void onMessage(Message message) {
		MapMessage message2 = (MapMessage)jmsTemplate.receive();
		try {
			System.out.println("--收到消息："+(message2.getLong("count")));
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

}
