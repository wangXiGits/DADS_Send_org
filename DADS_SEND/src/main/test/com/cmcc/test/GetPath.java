package com.cmcc.test;


public class GetPath {
	public static void main(String[] args) {
		String path = GetPath.class.getResource("").toString();
		path = path.substring(6, path.indexOf("/build"));
		System.out.println(path);
	}
}
