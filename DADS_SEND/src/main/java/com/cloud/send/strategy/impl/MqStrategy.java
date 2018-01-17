package com.cloud.send.strategy.impl;

import com.cloud.activeMQ.ObsDataMsgPublisher;
import com.cloud.send.observer.util.PropertiesReader;
import com.cloud.send.strategy.SendStrategy;

public class MqStrategy implements SendStrategy {
	static ObsDataMsgPublisher publisher = null;
	static{
		publisher = ObsDataMsgPublisher.getInstance();
	}
	@Override
	public boolean send(String data, String url, String appType) {
		if(publisher==null){
			log.error(this.getClass().getSimpleName()+" ObsDataMsgPublisher==null，无法发送JMS消息！");
			return false;
		}
		String queueName = PropertiesReader.getProp("jms.queue."+appType);
		if(queueName==null || "".equals(queueName)){
			log.error(this.getClass().getSimpleName()+" 未找到属性：jms.queue."+appType);
			log.error(this.getClass().getSimpleName()+" queueName为空， 无法发送JMS消息！");
			return false;
		}
		return publisher.sendByQuene(data, queueName);
	}

}
