package com.cmcc.Util;

import java.util.Arrays;

public class Sort {
	
	public static  int[] sort(int[] a,int initIndex){
		if(initIndex>=a.length-1){
			return a;
		}
		 //int temp;
		 int max=a[initIndex];
		 int min=a[initIndex];
		 int maxIndex=0;
		 int minIndex=0;
		 for (int i=initIndex;i<a.length;i++){
		   if(a[i]>=max){
		    max=a[i];
		    maxIndex=i;
		   }
		 }
		 for (int i=initIndex;i<a.length;i++){
			   if(a[i]<=min){
			    min=a[i];
			    minIndex=i;
			   }
		 }
		 //temp=max;
		 a[maxIndex]=a[initIndex];
		 a[initIndex]=max;
		 a[minIndex]=a[initIndex+1];
		 a[initIndex+1]=min;
		 System.out.println(Arrays.toString(a));
		 if(initIndex != a.length-1){
			 sort(a,initIndex+2);
		 }
		 
		return a;
	} 
	public static void bothEndsSort(int[] a){
		boolean flag = true;
		for(int i = 0;i<a.length-1;i++){
			if(flag){
				int index = i;
				for(int j=i;j<a.length;j++){
					if(a[index]<a[j]){
						int temp = a[j];
						a[j] = a[index];
						a[index] = temp;
					}
				}
				flag = !flag;
			}else{
				int index = i;
				for(int j=i;j<a.length;j++){
					if(a[index]>a[j]){
						int temp = a[j];
						a[j] = a[index];
						a[index] = temp;
					}
				}
				flag = !flag;
			}
		}
	}
	public static void main(String[] args){
		int a[] ={55,99,66,77,11,22,44,33,88};
		bothEndsSort(a);
		System.out.println(Arrays.toString(a));
//		int b[] =sort(a,0);
//		for(int i=0;i<b.length-1;i++){
//			System.out.println(b[i]);
//		}
	}

}
