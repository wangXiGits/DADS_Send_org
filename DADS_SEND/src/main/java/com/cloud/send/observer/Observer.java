package com.cloud.send.observer;

import org.apache.log4j.Logger;

public interface Observer {
	public static Logger log = Logger.getLogger(Observer.class);
	public void update(Subject subject);
	
}
