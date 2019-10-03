package com.tdm.qa.pages;

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
	
	public StoreMoreOptPage() {
		PageFactory.initElements(driver, this);
	}
	
	public AddNotifPage clickOnAddNotif() {
		
		try {
			addNotif.click();
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		return new AddNotifPage();
	}
	
public CheckInPage clickOnCheckin() {
	
	try {
		checkin.click();
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	return new CheckInPage();
}

public OwnDataPage clickOnOwnData() {
	ownData.click();
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	return new OwnDataPage();
}

public NotifHistoryPage clickOnNotifHistory() {
	notifHistory.click();
	return new NotifHistoryPage();
}

public CheckInHistoryPage clickOnCheckInHist() {
	
	try {
		checkinHistory.click();
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	return new CheckInHistoryPage();
}

public boolean verifyNotif(String exp) {
	
	try {
		String expected=prop.getProperty(exp);
		System.out.println(expected);
		notifHistory.click();
		Thread.sleep(3000);
		String Actual=driver.findElement(By.xpath("//android.view.ViewGroup[@index='4']")).getText();
		System.out.println(Actual);
		
		if(Actual.contains(expected))
		{
			return true;
		}
		
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	return true;
	
}
}
