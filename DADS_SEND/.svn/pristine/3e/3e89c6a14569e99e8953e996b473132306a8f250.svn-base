package com.cmcc.monitor.test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

public class TestJsonArray {
	@Test
	public void testjsonArray(){
		String str = "[{'phone':'123'},{'phone':'456'},{'phone':'789'}]";
		JSONArray jsonArr = JSONArray.fromObject(str);
		for(int i=0;i<jsonArr.size();i++){
			System.out.println(JSONObject.fromObject(jsonArr.get(i)).get("phone"));
		}
		
	}
}
