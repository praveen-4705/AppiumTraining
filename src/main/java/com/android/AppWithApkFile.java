package com.android;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;

public class AppWithApkFile {
	
	AndroidDriver<MobileElement> driver;
	
	public void dragAndDrop(MobileElement m1, MobileElement m2){
		
		TouchAction touchAction	= new TouchAction(driver);
		touchAction.longPress(m1).moveTo(m2).release().perform();
		
	}
	
	
	@Test
	public void dragAndDropTest() throws InterruptedException {
		
		driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Basic')]")).click();
		
//		System.out.println(driver.getPageSource());
		
		MobileElement draggable	= driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Miles')]/preceding-sibling::android.widget.ImageView"));
		MobileElement droppable = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Brad')]/preceding-sibling::android.widget.ImageView"));
		
		dragAndDrop(draggable, droppable);
		
		Thread.sleep(5000);
	}

	@BeforeMethod
	public void beforeMethod() {
		

		
		DesiredCapabilities capabilities	= new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/src/main/resources/apk/Drag.apk");
		
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
