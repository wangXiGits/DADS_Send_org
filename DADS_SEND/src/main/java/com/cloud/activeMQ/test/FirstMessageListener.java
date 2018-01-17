package com.cloud.activeMQ.test;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
/**
 * 
 *   @author sxy
 *
 *  订阅/分发        第一个接收者
 *  
 *  实现了MessageListener接口
 */
public class FirstMessageListener implements MessageListener{

	@Override
	public void onMessage(Message msg) {
		if (msg instanceof MapMessage)
		{
			MapMessage message = (MapMessage) msg;
			try {    
			 
				System.out.println("--订阅者一 FirstMessageListener收到消息：" +  message.getString("name"));
				}
			catch (JMSException e) {
				e.printStackTrace();
				}
			}
		}
		
	}
 
