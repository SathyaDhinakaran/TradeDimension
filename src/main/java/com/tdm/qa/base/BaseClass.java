package com.tdm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	
	//public static AppiumDriver<MobileElement> driver;
	public static AndroidDriver driver;
	public static DesiredCapabilities caps;
	public static Properties prop;
	public static URL url;
	
	
	public BaseClass() {
		try {
			prop=new Properties();
			FileInputStream fis=new FileInputStream("C:\\Users\\dhsa7001\\eclipse-workspace\\TDM\\src\\main\\java\\com\\tdm\\qa\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void initialization()
	
	{
		try {
			caps= new DesiredCapabilities();
			caps.setCapability("platformName",prop.getProperty("platName"));
			caps.setCapability(MobileCapabilityType.DEVICE_NAME,prop.getProperty("deviceName"));
			caps.setCapability(MobileCapabilityType.APP,prop.getProperty("app") );
			caps.setCapability("appPackage",prop.getProperty("appPckg"));
			caps.setCapability("appActivity",prop.getProperty("appActi"));
			caps.setCapability("autoGrantPermissions",prop.getProperty("permissions"));
			url =new URL(prop.getProperty("urls"));
			driver=new AndroidDriver(url,caps);
			//driver = new AppiumDriver<MobileElement>(url,caps);
			//driver.manage().deleteAllCookies();
			Thread.sleep(3000);
			
			
		} catch (Exception exp) {
			 System.out.println("Cause is: "+exp.getCause());
			 System.out.println("Message is: "+exp.getMessage());
			 exp.printStackTrace();
		}
		 
		
	}
	
	
	

}