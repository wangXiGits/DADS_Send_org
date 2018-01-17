package com.cloud.send.observer.impl;

import java.util.HashMap;

import com.cloud.send.observer.Observer;
import com.cloud.send.observer.Subject;
import com.cloud.send.observer.util.CommonThread;
import com.cloud.send.observer.util.DatatypeInfoContext;
import com.cloud.send.observer.util.PropertiesReader;
import com.cloud.send.observer.util.ThreadStateFlag;

/**
 * 各观察者具有相同的处理逻辑，只需要传入相应的参数
 * <br>项目名称：DADS   
 * <br>类名称：AbstractObserver   
 * <br>类描述：暂无 
 * <br>创建人：RCM
 * <br>创建时间：2014-5-28 上午09:51:44   
 * <br>修改人：
 * <br>修改时间：
 * <br>修改备注： 
 * @version
 */
public abstract class AbstractObserver implements Observer {
	/**
	 * 抽象公共方法
	 * @param subject
	 * @param sendFlag
	 * @param appType
	 * @param sendPath
	 * @param threadMap
	 */
	protected void commonUpdate(Subject subject, String sendFlag, String appType, String sendPath,
			HashMap<String, CommonThread> threadMap) {
		log.info(this.getClass().getSimpleName() + " 收到主题通知，开始发送数据...");
		log.info("dataType=" + subject.getDataType() + " appType=" + subject.getAppType());

		String dataType = subject.getDataType();
		String tableName = DatatypeInfoContext.getTableNameByDatatype(dataType);
		String sendWayList = PropertiesReader.getProp("sendWayList");
		if (sendWayList == null) {
			log.info("未配置发送策略 sendWayList");
			return;
		}
		String[] sendWayArray = sendWayList.split(",");
		for (String sendWay : sendWayArray) {
			//线程key，若key重复，则说明线程重复
			//App类型一样,sendWay一样，则不会起重复的线程
			String threadKey = appType + "_" + tableName + "_" + sendWay;

			//判断发送方式有没有开启
			if (!"on".equals(PropertiesReader.getProp(sendWay + "_toggle"))) {
				System.out.println(sendWay + "_toggle" + "___" + PropertiesReader.getProp(sendWay + "_toggle"));
				continue;
			}

			//启动线程进行发送
			//			synchronized (threadKey) {
			if (threadMap.containsKey(threadKey)) {
				CommonThread thread = threadMap.get(threadKey);
				if (thread.isAlive()) {
					log.info("已有线程在工作，不需重新开启：" + thread.getName());
					continue;
				}
			}
			System.out.println(sendWay);
			// modify by rcm on 2014/06/18 appType->threadKey
			CommonThread thread = new CommonThread(tableName, sendFlag, appType, sendPath,
					ThreadStateFlag.getInstance(threadKey), sendWay);
			thread.setName(threadKey);
			log.info("开启新的发送线程:" + thread.getName());
			thread.start();
			threadMap.put(threadKey, thread);
		}
		//		}
	}
}
