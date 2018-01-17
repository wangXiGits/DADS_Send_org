package com.cloud.send.strategy;

import org.apache.log4j.Logger;

/**
 * 数据转发策略接口
 * <br>项目名称：DADS   
 * <br>类名称：SendStrategy   
 * <br>类描述：暂无 
 * <br>创建人：RCM
 * <br>创建时间：2014-5-29 下午04:51:59   
 * <br>修改人：
 * <br>修改时间：
 * <br>修改备注： 
 * @version
 */
public interface SendStrategy {
	public static Logger log = Logger.getLogger(SendStrategy.class);
	/**
	 * 具体发送接口
	 * @param data		//发送的数据
	 * @param url		//用户Post方式发送的目的地址
	 * @param appType 	//用于MQ方式发送时，查找queueName
	 * @return
	 */
	public boolean send(String data,String url,String appType);
}
