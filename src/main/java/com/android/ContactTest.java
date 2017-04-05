package com.android;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class ContactTest {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		
		DesiredCapabilities capabilities	= new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		capabilities.setCapability("appPackage", "com.android.calculator2");
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		AppiumDriver<MobileElement> driver	= new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		
		driver.findElement(By.id("digit_5")).click();
		driver.findElement(By.id("digit_2")).click();
		
		driver.findElement(By.id("op_add")).click();
		
		driver.findElement(By.id("digit_4")).click();
		
		driver.findElement(By.id("eq")).click();
		
		String actualResult	= driver.findElement(By.className("android.widget.EditText")).getText();
		System.out.println(actualResult);
		String expectedResult = "57";
		
		
		Assert.assertTrue(actualResult.equalsIgnoreCase(expectedResult));
		
		Thread.sleep(5000l);
		
		driver.quit();

	}

}
