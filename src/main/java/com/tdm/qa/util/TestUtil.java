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
	
	
	
	public static void scrollUpAndDown(String text) {
	
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+prop.getProperty(text)+"\").instance(0))");
		
	}
	
	public static void scrollUpAndDownWithClick(String text) {
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+prop.getProperty(text)+"\").instance(0))").click();
			
		}
}
