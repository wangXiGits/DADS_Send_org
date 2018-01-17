package com.cloud.send.main;

import java.util.HashMap;
import java.util.List;

import com.cloud.send.observer.impl.SubjectFactory;
import com.cloud.send.observer.util.C3P0Util;
import com.cloud.send.observer.util.ValidateUtil;

public class StartSend {

	public static void main(String[] args) {
		String tablename = "sports";
		String sql = "select dataType,appType from " + tablename
				+ "  where sendFlag='0' limit 200";

		String dataType = "";
		String appType = "";

		// 用来存放apptype和datatype的map集合
		HashMap<String, String> params = new HashMap<String, String>();

		// 查询出已经发送的运动数据
		List<HashMap<String, String>> datas = C3P0Util.getData(sql);
		System.out.println(datas);
		

		for (HashMap<String, String> data : datas) {
			dataType = data.get("dataType");
			appType = data.get("appType");
			if (ValidateUtil.paramCheck(dataType, appType)) {
				SubjectFactory.getSubject(appType, dataType).notifyObserver();
			}
		}

	}
}
