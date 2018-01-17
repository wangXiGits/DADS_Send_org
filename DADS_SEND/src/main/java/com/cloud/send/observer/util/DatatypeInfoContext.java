package com.cloud.send.observer.util;

import java.util.HashMap;
import java.util.List;

public class DatatypeInfoContext {
	public static HashMap<String,String> info = new HashMap<String, String>();
	static{
		initDatatypeInfo();
	}
	public static void initDatatypeInfo() {
		info.clear();
		String sql="SELECT dataTypeName as dataType, tableName FROM datatype";
		List<HashMap<String, String>> list = C3P0Util.getData(sql);
		if(list != null && list.size() >0){
			for (HashMap<String, String> map : list) {
				info.put(map.get("dataType"), map.get("tableName"));
			}
		}
	}
	public static String getTableNameByDatatype(String dataType){
		return info.get(dataType);
	}
}
