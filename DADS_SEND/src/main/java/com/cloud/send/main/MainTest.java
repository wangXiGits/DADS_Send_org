package com.cloud.send.main;

public class MainTest {
	public static void main(String[] args) {
		 //测试血压包
		new Thread(new SportsDataSendThread()).start();
	}
}
