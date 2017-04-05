package com.iosScripts;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class IOSTest {
	
	static String deviceName	= "iPhone 6s";

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities capabilities	= new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.2");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
		
		AppiumDriver<MobileElement> driver	= new IOSDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		
		driver.get("http://m.redbus.in");
		
		driver.findElement(By.xpath("//input[@id='srcCity']")).click();
		
		driver.findElement(By.xpath("//input[@class='search-city']")).click();
		
		driver.findElement(By.xpath("//input[@class='search-city']")).sendKeys("Hyder");
		
		driver.findElement(By.xpath("//li[text()='Hyderabad']")).click();
		
		Thread.sleep(5000l);
		
		driver.quit();

	}

}
