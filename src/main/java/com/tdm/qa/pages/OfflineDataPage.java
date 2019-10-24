package com.tdm.qa.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.tdm.qa.base.BaseClass;


public class OfflineDataPage extends BaseClass {
	
	@FindBy(xpath="//*[@text='Offline Data']")
	WebElement offlineDataScreen;
	
	Logger log=LogManager.getLogger(OfflineDataPage.class);
	
	
	public OfflineDataPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyOfflineDataPage() {
	return	offlineDataScreen.isDisplayed();
	}
	
	public boolean verifyDownloadedData(String dname) {
	return	driver.findElement(By.xpath("//*[@text='"+prop.getProperty(dname)+"']")).isDisplayed();
		
	}
}
