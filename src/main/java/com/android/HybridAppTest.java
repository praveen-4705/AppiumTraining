package com.android;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class HybridAppTest {

	AndroidDriver<MobileElement> driver;

	@Test
	public void hybridTest() throws InterruptedException {
		driver.findElement(By.id("et")).clear();
		driver.findElement(By.id("et")).sendKeys("http://www.google.com");
		driver.findElement(By.id("go")).click();
		
		Thread.sleep(6000l);
		
		Set<String> handles = driver.getContextHandles();
		
		// [NATIVE_APP, WEBVIEW_com.html5test.webview]
		System.out.println(handles);
		
		for (String handleName : handles) {
			
			if (handleName.contains("WEBVIEW")) {
				driver.context(handleName);
				break;
			}
			
		}
		
		driver.findElement(By.id("lst-ib")).clear();
		driver.findElement(By.id("lst-ib")).sendKeys("Inside WebView");
		
		Thread.sleep(2000l);
		
		driver.context("NATIVE_APP");
		
		driver.findElement(By.id("et")).clear();
		driver.findElement(By.id("et")).sendKeys("http://www.redbus.in");
		
		
	}

	@BeforeMethod
	public void beforeMethod() {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		capabilities.setCapability("app", System.getProperty("user.dir") + "/src/main/resources/apk/HTML.apk");

		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
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
