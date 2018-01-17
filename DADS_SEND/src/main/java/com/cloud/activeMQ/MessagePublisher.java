package com.cloud.activeMQ;

import org.apache.log4j.Logger;


public interface MessagePublisher {
	public static Logger log = Logger.getLogger(MessagePublisher.class);
	public boolean sendByQuene(String msg, String queneName);
	public void sendTopic(String msg);
	public void sendQueue(String msg);
	void sendQueue4(String msg);

}
