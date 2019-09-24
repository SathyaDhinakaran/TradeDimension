package com.tdm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tdm.qa.base.BaseClass;

public class PrevCheckinPage extends BaseClass {
	
	@FindBy (xpath="//android.widget.TextView[@text='Check In History']")
	WebElement checkInHistory;
	
	@FindBy(xpath="//android.widget.TextView[@text='Type']")
	WebElement checkIn;
	
	@FindBy(xpath="//android.view.ViewGroup[@index='0']")
	WebElement clickOnShop;
	
	@FindBy(xpath="//android.view.ViewGroup[@index='2']")
	WebElement hierarchyIcon;
	
	
	public PrevCheckinPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyCheckInHistory() {
		return checkInHistory.isDisplayed();
	}
	
	public boolean verifyCheckin() {
		return checkIn.isDisplayed();
	}
	
	public StoreDetailsPage clickOnFirstShop() {
		
		try {
			clickOnShop.click();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		return new StoreDetailsPage();
	}
	
	public boolean verifyHierarchyIcon() {
		return hierarchyIcon.isDisplayed();
	}
	
	

}
