package com.cloud.send.observer.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.cloud.send.observer.Observer;
import com.cloud.send.observer.Subject;
import com.cloud.send.observer.util.AppDatatypeInfoContext;
import com.cloud.send.observer.util.AppInfoContext;
import com.cloud.send.observer.util.C3P0Util;

/**
 * 简单工厂+反射+配置文件
 * 主题工厂，为了方便通过反射技术实例化观察者类，故将主题工厂与观察者放在同一个包下，不可分离
 * <br>项目名称：DADS   
 * <br>类名称：SubjectFactory   
 * <br>类描述：暂无 
 * <br>创建人：RCM
 * <br>创建时间：2014-5-27 下午03:10:58   
 * <br>修改人：
 * <br>修改时间：
 * <br>修改备注： 
 * @version
 */
public class SubjectFactory {
	private static Logger log = Logger.getLogger(SubjectFactory.class);

	/**
	 * 根据appType,dataType获得包含相应观察者的主题
	 * @param appType
	 * @param dataType
	 * @return
	 */
	public static Subject getSubject(String appType, String dataType) {
		DataSaveSubject subject = new DataSaveSubject();
		subject.setAppType(appType);
		subject.setDataType(dataType);
		if (appType != null && !"".equals(appType)) {
			String[] apps = appType.split(",");
			//兼容以"," 和 ";" 两种分割方式
			if (appType.contains(";"))
				apps = appType.split(";");

			for (String app : apps) {
				//判断指定app类型是否开启状态
				if (!"on".equals(AppInfoContext.getPropertyByApp(app, "appToggle"))) {
					log.info(app + " toggle is not on");
					continue;
				}

				//判断指定app下能否接受这种数据类型
				if (!AppDatatypeInfoContext.isDataTypeOpenForAppType(app, dataType)) {
					log.info(app + "_" + dataType + " is not open");
					continue;
				}
				//创建观察者
				Observer observer = new CommonObserver(AppInfoContext.getPropertyByApp(app, "sendFlag"), app,
						AppInfoContext.getPropertyByApp(app, "sendPath"));
				//将观察者放到list集合中
				subject.attach(observer);
			}
		}
		return subject;
	}

	public static boolean isAppOpen(String appName) {
		String sql = "SELECT p.appToggle FROM product p WHERE p.appName='" + appName + "'";
		List<HashMap<String, String>> list = C3P0Util.getData(sql);
		boolean ret = false;
		if (list != null && list.size() > 0) {
			if ("on".equals(list.get(0).get("appToggle"))) {
				ret = true;
			}
		}
		log.debug("appName: " + appName + ", ret: " + ret);
		return ret;
	}

	public static boolean isDatatypeOpen(String AppType, String dataType) {
		String sql = "SELECT pd.toggle FROM product p JOIN product_datatype pd ON p.appID=pd.productID JOIN datatype d ON pd.dataTypeID=d.datatypeID WHERE p.appName='"
				+ AppType + "' AND d.dataTypeName='" + dataType + "'";
		List<HashMap<String, String>> list = C3P0Util.getData(sql);
		boolean ret = false;
		if (list != null && list.size() > 0) {
			if ("on".equals(list.get(0).get("toggle"))) {
				ret = true;
			}
		}
		log.debug("AppType: " + AppType + "dataType" + "dataType" + ", ret: " + ret);
		return ret;
	}

	@Test
	public void test() {
		System.out.println(isDatatypeOpen("WSYD", "bloodPressure"));
	}
}
