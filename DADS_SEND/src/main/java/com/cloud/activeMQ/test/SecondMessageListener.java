package com.cloud.activeMQ.test;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * 
 *   @author sxy
 *
 *   订阅/分发        第一个接收者
 *  
 *    实现了MessageListener接口
 */
public class SecondMessageListener implements MessageListener{

	@Override
	public void onMessage(Message msg) {
		if (msg instanceof MapMessage)
		{
			MapMessage message = (MapMessage) msg;
			try {    
				System.out.println("--订阅者二  SecondMessageListener收到消息 ：" +  message.getLong("count")); 
				}
			catch (JMSException e) {
				e.printStackTrace();
				}
			}
		}
		
	}
 
