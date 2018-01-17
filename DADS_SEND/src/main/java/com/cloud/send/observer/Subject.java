package com.cloud.send.observer;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


public abstract class Subject {
	public static Logger log = Logger.getLogger(Subject.class);
	/**
	 * 观察者集合
	 */
	private List<Observer> observers = new ArrayList<Observer>();
	protected String dataType;
	protected String appType;
	/**
	 * 注册观察者对象
	 */
	public void attach(Observer observer){
		this.observers.add(observer);
	}
	/**
	 * 通知所有观察者
	 */
	public void notifyObserver(){
		for (Observer observer : observers) {
			observer.update(this);
		};
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getAppType() {
		return appType;
	}
	public void setAppType(String appType) {
		this.appType = appType;
	}
}
