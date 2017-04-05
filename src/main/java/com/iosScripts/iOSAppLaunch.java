package com.iosScripts;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;

public class iOSAppLaunch {

	AppiumDriver<MobileElement> driver;

	@Test

	public void iOSAppLaunch2() throws InterruptedException {
		driver.findElementByAccessibilityId("Date Picker").click();

		Thread.sleep(5000);


		driver.findElement(By
				.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeDatePicker/XCUIElementTypeOther/XCUIElementTypePickerWheel[1]"))
				.sendKeys("Mon Apr 3");
		
		driver.findElement(By
				.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeDatePicker/XCUIElementTypeOther/XCUIElementTypePickerWheel[2]"))
				.sendKeys("11");

		
		driver.findElement(By
				.xpath("//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeDatePicker/XCUIElementTypeOther/XCUIElementTypePickerWheel[3]"))
				.sendKeys("20");

		Thread.sleep(5000);
	}

	@BeforeMethod
	public void beforeMethod() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6s");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.2");
		capabilities.setCapability(MobileCapabilityType.APP,
				System.getProperty("user.dir") + "/src/main/resources/app/UICatalog.app");

		driver = new IOSDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
