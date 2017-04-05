package com.android;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;

public class MultiTouchActionExample {

	AndroidDriver<MobileElement> driver;

	@Test
	public void multiTouchTest() throws InterruptedException {
		
		MobileElement mobileElement	= driver.findElement(By.id("points"));
		
		int x = mobileElement.getLocation().getX();
		int y = mobileElement.getLocation().getY();
		
		TouchAction a1	= new TouchAction(driver).tap(x+100, y+100).waitAction(3000);
		TouchAction a2 = new TouchAction(driver).tap(x+200, y+200).waitAction(3000);
		TouchAction a3 = new TouchAction(driver).tap(x+300, y+300).waitAction(3000);
		TouchAction a4 = new TouchAction(driver).tap(x+400, y+400).waitAction(3000);
		TouchAction a5 = new TouchAction(driver).tap(x+500, y+500);
		
		MultiTouchAction mAction	= new MultiTouchAction(driver);
		mAction.add(a1).add(a2).add(a3).add(a4).add(a5).perform();
		
		Thread.sleep(5000);
		
	}

	@BeforeMethod
	public void beforeMethod() {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		capabilities.setCapability("app", System.getProperty("user.dir") + "/src/main/resources/apk/MultiTouch.apk");
		

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
