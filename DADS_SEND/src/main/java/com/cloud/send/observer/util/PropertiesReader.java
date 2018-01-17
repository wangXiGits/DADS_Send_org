package com.cloud.send.observer.util;

import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.ClassPathResource;

public class PropertiesReader {

	private static Properties prop = new Properties();//java.util.Properties专门用于读取配置文件对象

	private static Properties prop_db = new Properties();

	static {
		try {
			//读取配置文件
			InputStream SystemIn = new ClassPathResource("com/Config/SysConf.properties").getInputStream();
			prop.load(SystemIn);
			InputStream db_config = new ClassPathResource("com/Config/database.properties").getInputStream();
			prop_db.load(db_config);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getProp(String name) {
		if (prop != null) {
			if (StringUtils.isNotBlank(prop.get(name).toString())) {
				return prop.get(name).toString();
			}
			return null;
		}
		return null;
	}

	public static String getDbProp(String name) {
		if (prop_db != null) {
			if (StringUtils.isNotBlank(prop_db.get(name).toString())) {
				return prop_db.get(name).toString();
			}
			return null;
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(PropertiesReader.getProp("jms.queue.EMRTOPIC"));
	}
}
