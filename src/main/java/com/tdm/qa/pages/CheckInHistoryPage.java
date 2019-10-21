package com.tdm.qa.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tdm.qa.base.BaseClass;


public class CheckInHistoryPage extends BaseClass {
	
	@FindBy(xpath="//*[@text='Check In History']")
	WebElement checkInHist;
	
	 Logger log=LogManager.getLogger(CheckInHistoryPage.class);
	
	public CheckInHistoryPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyCheckIn(String checkin) {
		return driver.findElement(By.xpath("//*[@text='"+prop.getProperty(checkin)+"']")).isDisplayed();
	}
	
	public boolean verifyCheckInHis() {
		return checkInHist.isDisplayed();
	}

}
