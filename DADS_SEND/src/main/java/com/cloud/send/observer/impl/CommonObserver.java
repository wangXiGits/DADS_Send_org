package com.cloud.send.observer.impl;

import java.util.HashMap;

import com.cloud.send.observer.Subject;
import com.cloud.send.observer.util.CommonThread;

public class CommonObserver extends AbstractObserver {
	private String sendFlag = null;
	private String appType = null;
	private String sendPath = null;

	//static属性，先于对象存在，放在方法区（共享）,用来存储已启动的线程，防止线程重复启动
	private static HashMap<String, CommonThread> threadMap = new HashMap<String, CommonThread>();

	public CommonObserver(String sendFlag, String appType, String sendPath) {
		this.sendFlag = sendFlag;
		this.appType = appType;
		this.sendPath = sendPath;
	}

	@Override
	public void update(Subject subject) {
		commonUpdate(subject, sendFlag, appType, sendPath, threadMap);
	}
}
