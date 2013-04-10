package com.parser.test;

import java.net.URL;

public class ClassPathTest {
	public static void main(String args[]) {

		String classPath = System.getProperty("java.class.path");
		
		System.out.println(classPath);
		
		URL url = ClassLoader.getSystemResource("log4j.properties");
		
		System.out.println(url.toString());
	}
}
	