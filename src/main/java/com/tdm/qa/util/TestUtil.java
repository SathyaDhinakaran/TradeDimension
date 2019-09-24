package com.tdm.qa.util;

import java.time.Duration;

import org.openqa.selenium.Dimension;

import com.tdm.qa.base.BaseClass;


import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;

import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class TestUtil extends BaseClass {
	
	
	public static long IMPLICIT_WAIT=20;
	public static long PAGE_LOAD=20;
	
	
	public static void scrollDown() {
		Dimension dim = driver.manage().window().getSize();
		
		Double scrollHeightStart =dim.getHeight()*0.5;
		int scrollStart=scrollHeightStart.intValue();
		
		Double scrollHeightEnd =dim.getHeight()*0.2;
		int scrollEnd=scrollHeightEnd.intValue();
		
		new TouchAction((PerformsTouchActions)driver)
		.press(PointOption.point(0, scrollStart))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
		.moveTo(PointOption.point(0, scrollEnd))
		.release().perform();
	
	}
	
public static void scrollUpAndDown(String text) {
	
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+prop.getProperty(text)+"\").instance(0))").click();
		
	}
}
