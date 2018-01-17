package com.cloud.activeMQ;

import java.net.URLDecoder;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;

import com.cloud.send.observer.util.C3P0Util;
import com.cloud.send.observer.util.UserSyncUtil;

/**
 * 从业务管理系统MQ服务器接收用户信息
 * 项目名称：DADS   
 * 类名称：UserInfoMessageListener   
 * 类描述：暂无 
 * 创建人：RCM
 * 创建时间：2014-5-7 上午11:36:29
 * 修改人：
 * 修改时间：
 * 修改备注： 
 * @version
 */
public class UserInfoMessageListener implements MessageListener {
	private static Logger log = Logger.getLogger(UserInfoMessageListener.class);
	private JmsTemplate ope_jmsTemplate;
	@Override
	public void onMessage(Message message) {
        if ( message instanceof TextMessage )
        {
            TextMessage textMessage = (TextMessage) message;
            try
            {
            	String userInfo = URLDecoder.decode(textMessage.getText(), "utf-8");
            	log.info("receive userInfo :　"+ userInfo);
            	//单元测试数据（正式运行请注释掉）
//            	userInfo = "{'opeType':'delete','deviceId':'xxx12345','gateway':'223.202.47.134:8889','phone':'13701115948','name':'郭义华','appType':'WSYD;WSJK;WSXD','ywid':2}";
            	handleUserInfo(userInfo);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
	}
	/**
	 * 处理从MQ获取来的用户信息
	 * opeType：
	 * @param userInfo
	 */
	public static void handleUserInfo(String userInfo) {
		JSONObject jo = JSONObject.fromObject(userInfo);
		boolean ret = false;
		try {
			String opeType = jo.getString("opeType");
			if("insert".equals(opeType)){
				int count = C3P0Util.getCount("select count(1) from usertbl where ywId='"+jo.getString("ywid")+"'");
				if(count==0){
					String sql = "insert into usertbl(deviceId,patientId,pname,appType,ywId,modifyTime) values(?,?,?,?,?,now())";
					ret = C3P0Util.insertOrUpdateData(sql, jo.getString("deviceId"),jo.getString("phone"),jo.getString("name"),
							jo.getString("appType"),jo.getString("ywid"));
					if(ret){
						log.info("DADS新增用户成功！");
						//推送用户信息到EMR
						UserSyncUtil.pushUserInfoToEMR(jo);
					}else{
						log.info("DADS新增用户失败！");
					}
				}else{
					String sql = "update usertbl set deviceId=?,patientId=?,pname=?,appType=? where ywId=?";
					ret = C3P0Util.insertOrUpdateData(sql, jo.getString("deviceId"),jo.getString("phone"),jo.getString("name"),
							jo.getString("appType"),jo.getString("ywid"));
					if(ret){
						log.info("DADS修改用户成功！");
						//推送用户信息到EMR
						UserSyncUtil.pushUserInfoToEMR(jo);
					}else{
						log.info("DADS修改用户失败！");
					}
				}
			}else if ("delete".equals(opeType)) {
				ret = UserSyncUtil.deleteUserFromEMR(jo);
				if(ret){
					log.info("删除用户成功！");
				}else{
					log.info("删除用户失败！");
				}
			}else{
				log.info("消息内容格式错误！"+userInfo);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}
	public JmsTemplate getOpe_jmsTemplate() {
		return ope_jmsTemplate;
	}
	public void setOpe_jmsTemplate(JmsTemplate ope_jmsTemplate) {
		this.ope_jmsTemplate = ope_jmsTemplate;
	}
}
