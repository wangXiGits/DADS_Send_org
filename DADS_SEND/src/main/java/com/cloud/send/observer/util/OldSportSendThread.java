package com.cloud.send.observer.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;

/**
 * company : 所有
 * send to EMR(基地)
 * spareFlag : 0->1
 */
public class OldSportSendThread implements Runnable {
	private static Logger log = Logger.getLogger(CommonThread.class);
	private static String className = OldSportSendThread.class.getSimpleName();
	private static String send_path = PropertiesReader.getProp("emrSendPath");
	private static String querySql = PropertiesReader.getProp("emrQuerySql");
	private static String updateSql = PropertiesReader.getProp("emrUpdateSql");
	private List<HashMap<String,String>> unSendList = null;
	private ThreadStateFlag threadStateFlag;
	private String tableName;
	private String sendFlag;
	private String appType;
	private String sendPath;
	private StringBuffer simplePacket = null;
	public OldSportSendThread(String tableName, String sendFlag, String appType,
			String sendPath,ThreadStateFlag threadStateFlag){
		this.tableName = tableName;
		this.sendFlag = sendFlag;
		this.appType = appType;
		this.sendPath = sendPath;
		this.threadStateFlag = threadStateFlag;
	}
	@Override
	public void run() {
		synchronized (threadStateFlag)
		{
			if("on".equals(PropertiesReader.getProp(tableName+"Toggle"))){
				log.info(className+" running... query not send data : "+querySql);
				//查询未发送的数据
				unSendList = C3P0Util.getData(querySql);
				log.info("unSendList size : "+unSendList.size());
				while(unSendList.size()>0)
				{
					for (HashMap<String,String> map : unSendList) {
						if("8-1".equals(map.get("packageNum")) || "8-3".equals(map.get("packageNum")))
						{
							sendSimple(map);
						}
						else if("8-2".equals(map.get("packageNum")))
						{
							sendDetail(map);
						}
						else if("8-4".equals(map.get("packageNum")))
						{
							sendEffective(map);
						}
					}
					unSendList = C3P0Util.getData(querySql);
					log.info("unSendList size : "+unSendList.size());
				}
				log.info("数据发送完成，结束本线程！"+Thread.currentThread().getName());
			}else{
				log.info(tableName+"Toggle 未开启");
			}
		}
	}
	/**
	 * 发送8-4
	 * @param map
	 */
	private void sendEffective(HashMap<String, String> map) {
		//方式4 未发送
		NameValuePair patientid = new NameValuePair("patientID" ,map.get("patientID"));
		NameValuePair STEP3NVALUE = new NameValuePair("STEP3NEWVALUE" ,map.get("STEP3NEWVALUE"));
		NameValuePair packagedataID = new NameValuePair("packagedataID" ,map.get("id"));
		log.info("send package 8-4 ... ");
		if(sendHttpData(send_path,new NameValuePair[] {patientid,packagedataID,STEP3NVALUE}))
		{
			boolean rebool = C3P0Util.insertOrUpdateData(updateSql,map.get("id"));
		    if(rebool)
		    	log.info(className+" 8-4 send data successfully,and update packagedata is success.the updateSql is \r\n"+updateSql);   
		    else
		    	log.info(className+" 8-4 send data successfully,and update packagedata is fail.the updateSql is \r\n"+updateSql);
		}else{
		    log.info(className+" send data failure");
		}
	}
	/**
	 * 发送8-2
	 * @param map
	 */
	private void sendDetail(HashMap<String, String> map) {
		//方式2 未发送
		NameValuePair patientid = new NameValuePair("patientID" ,map.get("patientID"));
		NameValuePair STEP2NVALUE = new NameValuePair("STEP2NEWVALUE" ,map.get("STEP2NEWVALUE"));
		NameValuePair packagedataID = new NameValuePair("packagedataID" ,map.get("id"));
		log.info("send package 8-2 ...");
		if(sendHttpData(send_path,new NameValuePair[] {patientid,STEP2NVALUE,packagedataID}))
		{
			boolean rebool = C3P0Util.insertOrUpdateData(updateSql,map.get("id"));
		    if(rebool)
		    	log.info(className+" 8-2 send data successfully,and update packagedata is success.the updateSql is \r\n"+updateSql);   
		    else
		    	log.info(className+" 8-2 send data successfully,and update packagedata is fail.the updateSql is \r\n"+updateSql);   
		}else{
		    log.info(className+"send data failure");         
		}
	}
	/**
	 * 发送8-1和8-3
	 * @param map
	 */
	private void sendSimple(HashMap<String, String> map) {
		//简要包增加 设备 ID，设备类型，版本号 三个参数
		simplePacket = new StringBuffer();
		simplePacket.append(map.get("data_newcontent_stepcount2"))
		.append(" ").append(DataSendUtil.getDeviceId(map.get("deviceID")))
		.append(" ").append(DataSendUtil.getDeviceType(map.get("deviceType")))
		.append(" ").append(DataSendUtil.getVersion(map.get("firmware_version")));
		//方式1 未发送
		NameValuePair patientid = new NameValuePair("patientID" ,map.get("patientID"));
		NameValuePair stepcount = new NameValuePair("data_newcontent_stepcount2" ,simplePacket.toString());
		NameValuePair locationInfo = new NameValuePair("locationInfo" ,map.get("location"));
		log.info("send package "+map.get("packageNum")+" ... id="+map.get("id"));
		if(sendHttpData(send_path,new NameValuePair[] {patientid,stepcount,locationInfo}))
		{
		    boolean rebool = C3P0Util.insertOrUpdateData(updateSql,map.get("id"));
		    if(rebool)
		    	log.info(className+" "+map.get("packageNum")+" send data successfully,and update packagedata is success");   
		    else
		    	log.info(className+" "+map.get("packageNum")+" send data successfully,and update packagedata is fail");   
		}else{
		    log.info(className+" "+map.get("packageNum")+" send data failure");           
		}
	}
	
	private boolean sendHttpData(String url, NameValuePair[] parameter){
		HttpClient client = new HttpClient(); 
		PostMethod post = new PostMethod(url);
		boolean isSuccess=true; 
		try {
			post.setRequestBody(parameter); 
			log.info(className+" send data : "+Arrays.deepToString(parameter));
			//设置连接超时时间
			client.getHttpConnectionManager().getParams().setConnectionTimeout(3000);
			//设置响应超时时间
			client.getHttpConnectionManager().getParams().setSoTimeout(15000);
			int returnFlag = client.executeMethod(post);
			if(returnFlag!=200){
				isSuccess=false;
			}
			log.info(className+" success receive form post: " + post.getStatusLine().toString()+ ",returnFlag="+returnFlag);      
		} catch (Exception e) {
			e.printStackTrace();
			isSuccess=false;
			log.info(className+" fail receive form post: " +e.getMessage()); 
		}finally{
			if(post!=null){
				post.releaseConnection();
				log.info(className+" post.releaseConnection() " + "is coming");
			}
		}
		return isSuccess;
	}
}
