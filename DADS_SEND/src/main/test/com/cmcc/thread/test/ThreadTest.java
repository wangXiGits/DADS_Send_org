package com.cmcc.thread.test;

public class ThreadTest  extends Thread{
	    
	    /** Creates a new instance of MutilThread */
	    Object parameter;
	    public static Integer N=20;
	    public ThreadTest(Object p,int N) {
	        parameter=p;
	        this.N=N;
	    }
	    public void run(){
	        //Do something with parameter;
	        for(int i=0;i<5;i++){
//	        	System.out.println("N="+N--);
	        }
	        System.out.println("I am :"+parameter);
	        try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }
	    public static void main(String[] args) {
	    	Long beginTime = System.currentTimeMillis();
	    	System.out.println("begin:"+beginTime);
	    	
	       for(int i=0;i<20000;i++){
	           new ThreadTest("Thread "+i+", ",new Integer(2000)).start();
	       }
	       System.out.println("use:"+(System.currentTimeMillis()-beginTime));
	    }
	    
	}
