package com.android;

import org.testng.annotations.Test;

import org.testng.annotations.Parameters;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;

public class ScrollTest {

	AndroidDriver<MobileElement> driver;

	
	
	@Test(groups={"Run"})
	public void scroll() throws InterruptedException {
		
		//list
		String locator	= "new UiScrollable(new UiSelector().resourceId(\"android:id/list\")).scrollIntoView(new UiSelector().textContains(\"Atest\"))";
		MobileElement mobileElement	= driver.findElementByAndroidUIAutomator(locator);
		
		System.out.println(mobileElement.getText());
		
	}
	
	@Test(groups={"No Run"})
	public void leftSwipeTest(){
		
		driver.swipe(650, 740, 120, 740, 3000);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Test(groups={"No Run"})
	public void rightSwipeTest(){
		driver.swipe(75, 740, 560, 740, 3000);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test(groups={"No Run"})
	public void topToBottomSwipe(){
		
		driver.swipe(360, 300, 360, 100, 30000);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Parameters("deviceName")
	@BeforeMethod(alwaysRun=true)
	public void beforeMethod(String deviceName) {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		capabilities.setCapability("appPackage", "com.android.contacts");
		capabilities.setCapability("appActivity", "com.android.contacts.activities.PeopleActivity");

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
