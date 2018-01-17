package com.cmcc.SpringContextTest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.cloud.activeMQ.CommonMsgPublisher;

public class SpringContextTest {

	@Test
	public void sendMQMsg(){
		ApplicationContext context = new FileSystemXmlApplicationContext("WebContent/WEB-INF/activeMQContext.xml"); 
		CommonMsgPublisher pub = (CommonMsgPublisher) context.getBean("commonMsgPublisher");
		System.out.println(pub);
		
	}
}
