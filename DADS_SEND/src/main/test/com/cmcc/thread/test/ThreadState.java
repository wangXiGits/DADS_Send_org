package com.cmcc.thread.test;
/**
 * public final boolean isAlive()
 * 测试线程是否处于活动状态。如果线程已经启动且尚未终止，则为活动状态。 
 * 返回：
 * 如果该线程处于活动状态，则返回 true；否则返回 false
 * <br>项目名称：DADS   
 * <br>类名称：ThreadState   
 * <br>类描述：暂无 
 * <br>创建人：RCM
 * <br>创建时间：2014-5-29 上午09:43:11   
 * <br>修改人：
 * <br>修改时间：
 * <br>修改备注： 
 * @version 
 */
public class ThreadState extends Thread {

	@Override
	public void run() {
		System.out.println("kaishi yunxing!");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Thread tt = new ThreadState();
		tt.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(tt.isAlive());
	}

}
