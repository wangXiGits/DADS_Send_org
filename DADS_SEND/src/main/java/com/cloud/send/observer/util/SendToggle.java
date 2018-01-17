package com.cloud.send.observer.util;

import org.apache.log4j.Logger;

import com.cloud.send.observer.impl.SubjectFactory;

public class SendToggle {
	private static Logger log = Logger.getLogger(SubjectFactory.class);
	/**
	 * 判断应用类型对应的开关是否开启
	 * <br>若开启返回true;
	 * <br>否则返回false
	 * @param appType
	 * @return
	 */
	public static boolean isOpen(String appType){
		boolean isOpen = true;
		if(!"on".equals(AppInfoContext.getPropertyByApp(appType, "appToggle"))){
			log.info(appType+" toggle is not on");
			isOpen = false;
		}
		return isOpen;
	}
}
