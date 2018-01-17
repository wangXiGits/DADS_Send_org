package com.cloud.send.observer.util;

import java.util.HashMap;

/**
 * 线程状态标识，对同一Key值只有一个实例，不同的Key有不同的实例，习惯称为伪单例,
 * 项目名称：DADS   
 * 类名称：ThreadStateFlag   
 * 类描述：暂无 
 * 创建人：RCM
 * 创建时间：2014-5-26 下午12:09:33   
 * 修改人：
 * 修改时间：
 * 修改备注： 
 * @version
 */
public class ThreadStateFlag {
	private static HashMap<String, ThreadStateFlag> iMap = new HashMap<String, ThreadStateFlag>();
	private ThreadStateFlag() {
	}

	public static synchronized ThreadStateFlag getInstance(String key) {
		if(iMap.containsKey(key)){
			return iMap.get(key);
		}else{
			iMap.put(key, new ThreadStateFlag());
			return iMap.get(key);
		}
	}
}
