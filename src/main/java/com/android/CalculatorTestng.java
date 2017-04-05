package com.android;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;

public class CalculatorTestng {
	
	AppiumDriver<MobileElement> driver;

	@Test
	public void calculatorTest() {
		
		driver.findElement(By.id("digit_5")).click();
		driver.findElement(By.id("digit_2")).click();
		
		driver.findElement(By.id("op_add")).click();
		
		driver.findElement(By.id("digit_4")).click();
		
		driver.findElement(By.id("eq")).click();
		
		String actualResult	= driver.findElement(By.className("android.widget.EditText")).getText();
		
		System.out.println(actualResult);
		
		String expectedResult = "56";
		
		
		Assert.assertTrue(actualResult.equalsIgnoreCase(expectedResult));
		
	}

	@BeforeMethod
	public void beforeMethod() {
		
		DesiredCapabilities capabilities	= new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		capabilities.setCapability("appPackage", "com.android.calculator2");
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		try {
			driver	= new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@AfterMethod
	public void afterMethod() {
		
		driver.quit();
	}

}
