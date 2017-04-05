package com.iosScripts;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class Test {
	
	public static void readPropertyFile(String filePath) throws Exception{
		
		Properties properties = new Properties();
		FileInputStream fis	= new FileInputStream(filePath);
		
		properties.load(fis);
		
		System.out.println(properties.get("key"));
		
	}
	
	public static void setPropertyFile(String filePath) throws Exception{
		
		Properties properties = new Properties();
		FileOutputStream fos	= new FileOutputStream(filePath);
		
		properties.setProperty("key", "123");
		
		properties.store(fos, "Added key");
		
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Test.setPropertyFile(System.getProperty("user.dir")+"/src/main/java/com/iosScripts/test.properties");
		Test.readPropertyFile(System.getProperty("user.dir")+"/src/main/java/com/iosScripts/test.properties");

	}

}
