package com.tdm.qa.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.tdm.qa.base.BaseClass;


public class StoreMoreOptPage extends BaseClass{
	
	@FindBy(xpath="//*[@text='Add Notification']")
	WebElement addNotif;
	
	@FindBy(xpath="//*[@text='OwnData']")
	WebElement ownData;
	
	@FindBy(xpath="//*[@text='Check In History']")
	WebElement checkinHistory;
	
	@FindBy(xpath="//*[@text='Notification History']")
	WebElement notifHistory;
	
	@FindBy(xpath="//*[@text='Check In']")
	WebElement checkin;
	
	Logger log=LogManager.getLogger(StoreMoreOptPage.class);
		
	public StoreMoreOptPage() {
		PageFactory.initElements(driver, this);
	}
	
	public AddNotifPage clickOnAddNotif() {
		
		try {
			addNotif.click();
			log.info("StoreMoreOptPage: Clicked on add notification");
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			log.error("StoreMoreOptPage: Exception has occurred "+e.getMessage());
		}
		return new AddNotifPage();
	}
	
public CheckInPage clickOnCheckin() {
	
	try {
		checkin.click();
		log.info("StoreMoreOptPage: Clicked on check-in");
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
		log.error("StoreMoreOptPage: Exception has occurred "+e.getMessage());
	}
	return new CheckInPage();
}

public OwnDataPage clickOnOwnData() {
	ownData.click();
	log.info("StoreMoreOptPage: Clicked on Own data");
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
		log.error("StoreMoreOptPage: Exception has occurred "+e.getMessage());
	}
	return new OwnDataPage();
}



public CheckInHistoryPage clickOnCheckInHist() {
	
	try {
		checkinHistory.click();
		log.info("StoreMoreOptPage: Clicked on check-in history");
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
		log.error("StoreMoreOptPage: Exception has occurred "+e.getMessage());
	}
	return new CheckInHistoryPage();
}

public boolean verifyNotif(String exp) {
	
	try {
		String expected=prop.getProperty(exp);
		notifHistory.click();
		log.info("StoreMoreOptPage: Clicked on notification history");
		Thread.sleep(3000);
		String Actual=driver.findElement(By.xpath("//android.view.ViewGroup[@index='4']")).getText();
		
		
		if(Actual.contains(expected))
		{
			return true;
		}
		
	} catch (InterruptedException e) {
		
		log.error("StoreMoreOptPage: Exception has occurred "+e.getMessage());
		e.printStackTrace();
	}
	
	return true;
	
}
}
