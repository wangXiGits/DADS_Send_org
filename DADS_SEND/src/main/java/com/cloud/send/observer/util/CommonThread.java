package com.cloud.send.observer.util;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.cloud.send.strategy.impl.StrategyContext;

import net.sf.json.JSONObject;

public class CommonThread extends Thread {
	private static Logger log = Logger.getLogger(CommonThread.class);
	private String baseQuerySql;
	private String baseUpdateSql;
	private String sendWay;
	private ThreadStateFlag threadStateFlag;
	private String tableName;
	private String sendFlag;
	private String appType;
	private String sendPath;

	public CommonThread(String tableName, String sendFlag, String appType, String sendPath,
			ThreadStateFlag threadStateFlag, String sendWay) {
		this.tableName = tableName;
		this.sendFlag = sendFlag;
		this.appType = appType;
		this.sendPath = sendPath;
		this.threadStateFlag = threadStateFlag;
		this.sendWay = PropertiesReader.getProp(sendWay);
		this.baseQuerySql = PropertiesReader.getProp("baseQuerySql_" + sendWay);
		this.baseUpdateSql = PropertiesReader.getProp("baseUpdateSql_" + sendWay);
	}

	@Override
	public void run() {
		log.info(Thread.currentThread().getName() + " 线程启动！");
		//同步，解决线程安全问题
		synchronized (threadStateFlag) {
			List<HashMap<String, String>> unSendList = null;
			JSONObject data = null;
			String querySql = String.format(baseQuerySql, tableName, sendFlag, "%" + appType + "%");
			log.info(this.getClass().getSimpleName() + " running... query not send data sql is " + querySql);
			//查询未发送的数据
			unSendList = C3P0Util.getData(querySql);
			log.info("unSendList size : " + unSendList.size());
			while (unSendList.size() > 0) {
				for (HashMap<String, String> map : unSendList) {
					data = new JSONObject();
					data.put("appType", appType);
					data.put("dataType", map.get("dataType"));
					data.put("collectDate", map.get("receiveTime"));
					data.put("phone", map.get("phone"));
					data.put("dataValue", map.get("dataValue"));
					if (StrategyContext.sendData(data.toString(), sendPath, appType, sendWay)) {
						System.out.println("发送成功");
						String updateSql = String.format(baseUpdateSql, tableName, sendFlag, map.get("id"));
						boolean rebool = C3P0Util.executeUpdate(updateSql);
						if (rebool) {
							log.info(this.getClass().getSimpleName()
									+ " send data successfully,and update flag successed.The sql is: " + updateSql);
						} else {
							log.error(this.getClass().getSimpleName()
									+ " send data successfully,but update flag failed.The sql is: " + updateSql);
						}
					} else {
						log.info(this.getClass().getSimpleName() + " send data failure");
						if ("PostStrategy".equals(sendWay))
							log.error("该路径发送失败：" + sendPath);
						try {
							//如果发送失败，则休息20秒再发
							Thread.sleep(20000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				log.info(this.getClass().getSimpleName() + " running... query not send data sql is " + querySql);
				//查询未发送的数据
				unSendList = C3P0Util.getData(querySql);
				log.info("unSendList size : " + unSendList.size());
			}
			log.info("数据发送完成，结束本线程！" + Thread.currentThread().getName());
			threadStateFlag.notify();
		}
	}
}
