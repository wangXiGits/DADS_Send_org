package com.cmcc.monitor.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.junit.Test;

public class TestPost {
	@Test
	public void ecgdata() {
		String value = "{'company':'cmcc','password':'MHealthV1','data':{'appType':'WSXD','deviceId':'0800018','collectDate':'2013-01-01','dataType':'ECG','dataValue':[{'measureTime':'2014-04-02 08:00:00'},{'rawData':'3008,3008,3026,3056,3081,3111,3136,3104,3071,3042,3010,2992,2985,2976,2960,2944,2934,2929,2930,2932,2927,2920,2912,2904,2906,2915,2922,2924,2915,2907,2914,2930,2930,2937,2942,2927'},{'hr':'60'},{'waveForm':'波形质量过差'},{'heartRate':'心率正常'},{'isArrhythmia':'心律失常'},{'stIsNormal':'ST段正常'},{'isAF':'房颤'},{'detailedResults':'12608,20728,AF;'},{'simpleResult':'正常窦性心律'}]}}";
		boolean gwPushResult = httpClientPost("http://localhost:8080/DADS/service/uploadEcgDatas", "datas", value);
		System.out.println("gwPushResult="+gwPushResult);
	}
	@Test
	public void stepDetaildata() {
		String value = "{'company':'cmcc','password':'MHealthV1','data':{'appType':'ws','deviceId':'DS2013110000001','collectDate':'2013-01-01','dataType':'stepDetail','dataValue':[[{'snp5':'1,0,0,0,0,0,0,1,0,0,0,0'},{'knp5':'0,0,0,0,0,0,0,0,0,0,0,0'},{'level2p5':'0,0,0,0,0,0,0,0,0,0,0,0'},{'level3p5':'0,0,0,0,0,0,0,0,0,0,0,0'},{'level4p5':'0,0,0,0,0,0,0,0,0,0,0,0'},{'hour':0}],[{'snp5':'0,0,1,0,0,0,0,0,0,1,0,0'},{'knp5':'0,0,0,0,0,0,0,0,0,0,0,0'},{'level2p5':'0,0,0,0,0,0,0,0,0,0,0,0'},{'level3p5':'0,0,0,0,0,0,0,0,0,0,0,0'},{'level4p5':'0,0,0,0,0,0,0,0,0,0,0,0'},{'hour':'1'}]]}}";
//		String value = "{'company':'cmcc','password':'MHealthV1','data':{'appType':'ws','deviceId':'DS2013110000001','collectDate':'2013-01-01','dataType':'stepDetail','dataValue':[{'snp5':'1,0,0,0,0,0,0,1,0,0,0,0'},{'knp5':'0,0,0,0,0,0,0,0,0,0,0,0'},{'level2p5':'0,0,0,0,0,0,0,0,0,0,0,0'},{'level3p5':'0,0,0,0,0,0,0,0,0,0,0,0'},{'level4p5':'0,0,0,0,0,0,0,0,0,0,0,0'},{'hour':0}]}}";
		boolean gwPushResult = httpClientPost("http://localhost:8080/DADS/service/uploadSportsDatas", "datas", value);
		System.out.println("gwPushResult="+gwPushResult);
	}
	@Test
	public void stepEffectivedata() {
		String value = "{'company':'cmcc','password':'MHealthV1','data':{'appType':'ws','deviceId':'DS2013110000001','collectDate':'2013-01-01','dataType':'stepEffective','dataValue':[{'measureTime':'2013-01-01 08:00:00'},{'rawData':'3008,3008,3026,3056,3081,3111,3136,3104,3071,3042,3010,2992,2985,2976,2960,2944,2934,2929,2930,2932,2927,2920,2912,2904,2906,2915,2922,2924,2915,2907,2914,2930,2930,2937,2942,2927'},{'hr':'60'},{'waveForm':'波形质量过差'},{'heartRate':'心率正常'},{'isArrhythmia':'心律失常'},{'stIsNormal':'ST段正常'},{'isAF':'房颤'},{'detailedResults':'12608,20728,AF;'},{'simpleResult':'正常窦性心律'}]}}";
		boolean gwPushResult = httpClientPost("http://localhost:8080/DADS/service/uploadSportsDatas", "datas", value);
		System.out.println("gwPushResult="+gwPushResult);
	}
	@Test
	public void stepCountdata() {
		String value = "{'data':{'appType':'cd','deviceId':'DS2013110000001','collectDate':'2014-05-13 15:50:21','dataType':'stepCount','dataValue':[{'stepSum':'264'},{'calSum':'7100'},{'distanceSum':'158'},{'yxbsSum':'0'},{'weight':'60'},{'stride':'60'},{'degreeOne':'1'},{'degreeTwo':'2'},{'degreeThree':'3'},{'degreeFour':'4'},{'uploadType':'1'},{'measureTime':'2014-05-13 15:50:21'}]},'password':'123','company':'mljb'}";
		boolean gwPushResult = httpClientPost("http://localhost:8080/DADS/service/uploadSportsDatas", "datas", value);
		System.out.println("gwPushResult="+gwPushResult);
	}
	@Test
	public void bloodpressuredata() {
		String value = "{'company':'cmcc','password':'MHealthV1','data':{'appType':'wsecg','deviceId':'DS2013110000001','collectDate':'2013-01-01','dataType':'bloodPressure','dataValue':[{'measureTime':'2013-01-01 08:00:00'},{'heartrate ':'79'},{'systolic ':'120'},{'diastolic ':'80'}]}}";
		boolean gwPushResult = httpClientPost("http://localhost:8080/DADS/service/uploadBloodpressureDatas", "datas", value);
		System.out.println("gwPushResult="+gwPushResult);
	}	
	@Test
	public void bloodglucosedata() {
		String value = "{'company':'cmcc','password':'MHealthV1','data':{'appType':'wsecg','deviceId':'DS2013110000001','collectDate':'2013-01-01','dataType':'bloodGlucose','dataValue':[{'measureTime':'2013-01-01 08:00:00'},{'heartrate ':'79'},{'systolic ':'120'},{'diastolic ':'80'}]}}";
		boolean gwPushResult = httpClientPost("http://localhost:8080/DADS/service/uploadBloodglucoseDatas", "datas", value);
		System.out.println("gwPushResult="+gwPushResult);
	}		
	@Test
	public void heartfunctiondata() {
		String value = "{'company':'cmcc','password':'MHealthV1','data':{'appType':'wsecg','deviceId':'DS2013110000001','collectDate':'2013-01-01','dataType':'heartFunction','dataValue':[{'measureTime':'2013-01-01 08:00:00'},{'heartrate ':'79'},{'systolic ':'120'},{'diastolic ':'80'}]}}";
		boolean gwPushResult = httpClientPost("http://localhost:8080/DADS/service/uploadHeartFunctionDatas", "datas", value);
		System.out.println("gwPushResult="+gwPushResult);
	}		
	@Test
	public void sleepdata() {
		String value = "{'company':'cmcc','password':'MHealthV1','data':{'appType':'WSSM','deviceId':'0800019','collectDate':'2013-01-01','dataType':'sleep','dataValue':[{'measureTime':'2013-01-01 08:00:00'},{'sleepTime':'10'},{'efficiency':'60'},{'apneaTimes':'30'}]}}";
		boolean gwPushResult = httpClientPost("http://localhost:8080/DADS/service/uploadSleepDatas", "datas", value);
		System.out.println("gwPushResult="+gwPushResult);
	}	
	@Test
	public void weightdata() {
//		String value = "{'company':'cmcc','password':'MHealthV1','data':{'appType':'WSJK','deviceId':'0800017','collectDate':'2014-01-01','dataType':'weight','dataValue':[{'measureTime':'2014-04-23 08:00:00'},{'bodyWeight':'79'}]}}";
		String value = "{'data':{'appType':'cd','deviceId':'000013110000001','collectDate':'2014-05-8 15:12:13','dataType':'weight','dataValue':[{'measureTime':'2014-05-08 15:12:13'},{'bodyWeight':'65.2'}]},'password':'123','company':'mljb'}";
		boolean gwPushResult = httpClientPost("http://localhost:8080/DADS/service/uploadWeightDatas", "datas", value);
		System.out.println("gwPushResult="+gwPushResult);
	}		
	@Test
	public void spo2data() {
		String value = "{'company':'cmcc','password':'MHealthV1','data':{'appType':'WSJK','deviceId':'0800017','collectDate':'2014-01-01','dataType':'SPO2','dataValue':[{'measureTime':'2014-04-23 08:00:00'},{'pulse':'79'},{'oxygen':'120'}]}}";
		boolean gwPushResult = httpClientPost("http://localhost:8080/DADS/service/uploadSPO2Datas", "datas", value);
		System.out.println("gwPushResult="+gwPushResult);
	}
/*	@Test
	public void sportsdata() {
		String value = "{'company':'ds','password':'123','data':{'apptype':'ds','deviceid':'DS2013110000001','date':'2013-01-01','datatype':'STEPDETAIL','hour':'7','datavalue':[{'snp5':'0,0,11,249,201,220,81,402,179,0,0,0'},{'knp5':'0,0,0,83,77,73,21,151,67,0,0,0'},{'level2p5':'0,0,10,50,22,28,18,6,28,0,0,0'},{'level3p5':'0,0,0,98,104,90,38,204,64,0,0,0'},{'level4p5':'0,0,0,0,0,0,0,2,12,0,0,0'},{'yuanp5':'0,0,245,3554,1245,1111,0,5281,1326,0,0,0'}]}}";
		boolean gwPushResult = httpClientPost("http://localhost:8080/DADS/service/uploadSportsDatas", "datas", value);
		System.out.println("gwPushResult="+gwPushResult);
	}
	@Test
	public void detail() {
		String value = "{'company':'ds','password':'123','data':{'apptype':'ds','deviceid':'DS2013110000001','date':'2013-01-01','datatype':'STEPDETAIL','hour':'7','datavalue':[{'snp5':'0,0,11,249,201,220,81,402,179,0,0,0'},{'knp5':'0,0,0,83,77,73,21,151,67,0,0,0'},{'level2p5':'0,0,10,50,22,28,18,6,28,0,0,0'},{'level3p5':'0,0,0,98,104,90,38,204,64,0,0,0'},{'level4p5':'0,0,0,0,0,0,0,2,12,0,0,0'},{'yuanp5':'0,0,245,3554,1245,1111,0,5281,1326,0,0,0'}]}}";
		boolean gwPushResult = httpClientPost("http://localhost:8080/DADS/service/uploadSportsDatas.json", "datas", value);
		System.out.println("gwPushResult="+gwPushResult);
	}
	@Test
	public void effective() {
		String value = "{'company':'ds','password':'123','data':{'apptype':'ws','deviceid':'DS2013110000001','date':'2013-01-01','datatype':'STEPEFFECTIVE','hour':'7','datavalue':[{'snyxp5':'0,0,11,249,201,220,81,402,179,0,0,0'},{'knp5':'0,0,0,83,77,73,21,151,67,0,0,0'},{'level2p5':'0,0,10,50,22,28,18,6,28,0,0,0'},{'level3p5':'0,0,0,98,104,90,38,204,64,0,0,0'},{'level4p5':'0,0,0,0,0,0,0,2,12,0,0,0'},{'yuanp5':'0,0,245,3554,1245,1111,0,5281,1326,0,0,0'}]}}";
		boolean gwPushResult = httpClientPost("http://localhost:8080/DADS/service/uploadSportsDatas.json", "datas", value);
		System.out.println("gwPushResult="+gwPushResult);
	}
	@Test
	public void history() {
		String value = "{'company':'ds','password':'123','data':{'apptype':'ws','deviceid':'DS2013110000001','date':'2013-01-01','datatype':'STEPCOUNT','stepSum':'7000','calSum':'70','distanceSum':'500','yxbssum':'5000','weight':'60','stride':'75','degreeOne':'7','degreeTwo':'7','degreeThree':'7','degreeFour':'7','uploadType':'0'}}";
		boolean gwPushResult = httpClientPost("http://localhost:8080/DADS/service/uploadSportsDatas.json", "datas", value);
		System.out.println("gwPushResult="+gwPushResult);
	}
	@Test
	public void stepcount() {
		String value = "{'company':'ds','password':'123','data':{'apptype':'ws','deviceid':'DS2013110000001','date':'2013-12-06','datatype':'STEPCOUNT','stepSum':'7000','calSum':'70','distanceSum':'500','yxbssum':'5000','weight':'60','stride':'75','degreeOne':'7','degreeTwo':'7','degreeThree':'7','degreeFour':'7','uploadType':'0'}}";
		boolean gwPushResult = httpClientPost("http://localhost:8080/DADS/service/uploadSportsDatas.json", "datas", value);
		System.out.println("gwPushResult="+gwPushResult);
	}
	@Test
	public void getPackageData() {
		String value = "{'phone':'20000001009','queryDate':'2014-01-06','type':'simple','apptype':'ws'}";
//		String value = "{'phone':'20000001009','queryDate':'2014-01-06','type':'STEPCOUNT2','apptype':'ws'}";
//		String value = "{'phone':'20000001009','queryDate':'2014-01-06','type':'STEPCOUNT3','apptype':'ws'}";
		boolean gwPushResult = httpClientPost("http://localhost:8080/DADS/getPackageData.json", "param", value);
		System.out.println("gwPushResult="+gwPushResult);
	}
	@Test
	public void checkDataSendFlagStatus() {
		String value = "{'phone':'20000001009','queryDate':'2014-01-06','type':'simple','apptype':'ws'}";
//		String value = "{'phone':'20000001009','queryDate':'2014-01-06','type':'STEPCOUNT2','apptype':'ws'}";
//		String value = "{'phone':'20000001009','queryDate':'2014-01-06','type':'STEPCOUNT3','apptype':'ws'}";
		boolean gwPushResult = httpClientPost("http://localhost:8080/DADS/checkDataSendFlagStatus.json", "", "");
		System.out.println("gwPushResult="+gwPushResult);
	}*/
	/**
	 * 发送post请求推送数据，根据响应结果判断发送成功和失败
	 * 
	 * @param url
	 * @param pairKey
	 * @param jsono
	 * @return boolean
	 */
	public static boolean httpClientPost(String url, String pairKey, String value) {
		boolean gwPushResult = false;
		StringBuilder responseString = new StringBuilder();
		HttpClient client = new HttpClient();
		//设置连接超时时间
		client.getHttpConnectionManager().getParams().setConnectionTimeout(3000);
		//设置响应超时时间
//		client.getHttpConnectionManager().getParams().setSoTimeout(15000);
		PostMethod postM = null;
		try {
			postM = new PostMethod(url);
//			postM.addParameter(new NameValuePair(pairKey, value));
			postM.setParameter(pairKey, value);
			int s = client.executeMethod(postM);
			System.out.println("s="+s);
			System.out.println(postM.getStatusLine());
			Reader reader = new InputStreamReader(postM.getResponseBodyAsStream(), "utf8");
			BufferedReader br = new BufferedReader(reader);
			String line = "";
			while (null != (line = br.readLine())) {
				responseString.append(line);
			}
			System.out.println(responseString);
			JSONObject jo = JSONObject.fromObject(responseString.toString());
			if ("success".equalsIgnoreCase(jo.getString("status"))) {
				gwPushResult = true;
			}
		} catch (Exception e) {
			gwPushResult = false;
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			postM.releaseConnection();
			System.out.println("release..");
		}
		return gwPushResult;
	}
}
