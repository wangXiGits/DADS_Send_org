package com.cmcc.Util;

public class GetStepCountPwd{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//      String aab =  GetStepCountPwd.getCheckCode("CMTC03711301111");
//      String aab =  GetStepCountPwd.getCheckCode("CMTC03721301111");
		
		
//      String aab =  GetStepCountPwd.getCheckCode("CMTC03711111111");
//      String aab =  GetStepCountPwd.getCheckCode("CMTC03721111111");
      
      String aab =  GetStepCountPwd.getCheckCode("CMTC08711300013");
//      String aab =  GetStepCountPwd.getCheckCode("CMTC03725555555");
      
      
      
      System.out.println(aab);
//      System.out.println(aac);
        //Cmri20130000555===>914343
        //Cmri20130000560=====513103
        //Cmri20130001027===>410242
	}
	public static String getCheckCode(String deviceID){
	    //String num[10];
		//int[] checkCode  = {0,0,0,0,0,0} ;
		String result = "";
	    int i = 0;
	    int sum = 0;
	    char[] deviceIDArr = deviceID.toCharArray();
	    int[] num ={0,0,0,0,0,0,0,0,0,0} ;
	    
	    if(null == deviceID||deviceID.length()!=15 )
	    {
	    	return "-1";
	    }
	    for(i = 0;i < 10;i ++)
	    {
	      num[i] = deviceIDArr[i + 5] - '0';
	      sum += num[i];
	    }
	  
	    //checkCode[0] = sum % 10;
	    result += sum % 10;
	    //checkCode[1] = (sum / 10) % 10;
	    result += (sum / 10) % 10;
	    if(num[9] == 0)
	    {
	      //checkCode[2] = (sum % (num[9] + 12)) % 10;
	      result += (sum % (num[9] + 12)) % 10;
	      //checkCode[3] = (sum / (num[9] + 12)) % 10;  
	      result += (sum / (num[9] + 12)) % 10;  
	    }
	    else
	    {
	      //checkCode[2] = (sum % num[9]) % 10;
	      result += (sum % num[9]) % 10;
	      //checkCode[3] = (sum / num[9]) % 10;
	      result += (sum / num[9]) % 10;
	    }
	    int temp = 0;
	    if((num[9] - num[8] - num[7]) > 0)
	      temp = num[9] - num[8] - num[7];
	    else
	      temp = 5;
	    //checkCode[4] = sum % temp;
	    result +=  sum % temp;
	   // checkCode[5] = (sum / temp) % 10;
	    result += (sum / temp) % 10;
	    return result;
	}
}
