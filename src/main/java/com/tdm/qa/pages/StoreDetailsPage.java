package com.tdm.qa.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tdm.qa.base.BaseClass;

public class StoreDetailsPage extends BaseClass{
	
	@FindBy(xpath="//android.view.ViewGroup[@index='0']")
	WebElement backBtn;
	
	@FindBy(xpath="//android.view.ViewGroup[@index='2']")
	WebElement hierarchy;
	
	@FindBy(xpath="//android.view.ViewGroup[@index='0']/child::android.view.ViewGroup[@index='3']")
	WebElement storeMoreOpt;
	
	@FindBy(xpath="//*[@text='Detailed Location' or @text='Hierarchies']")
	WebElement storeHierarchy;
	
	@FindBy(xpath="//*[@text='Check In']")
	WebElement checkin;

	Logger log=LogManager.getLogger(StoreDetailsPage.class);
	
	public StoreDetailsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnHierarchy() {
		
		try {
			hierarchy.click();
			log.info("StoreDetailsPage: Clicked on hierarchy");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			log.error("StoreDetailsPage: Exception has occurred "+e.getMessage());
		}
		
	}
	
	public StoreMoreOptPage clickOnMoreOpt() {
		
		try {
			storeMoreOpt.click();
			log.info("StoreDetailsPage: Clicked on more option");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			log.error("StoreDetailsPage: Exception has occurred "+e.getMessage());
		}
		return new StoreMoreOptPage();
	}
	
	public boolean verifyHierarchyPage() {
		return storeHierarchy.isDisplayed();
	}
	
	public boolean verifyMoreOpt() {
		return checkin.isDisplayed();
	}
	
	
		
		
		
	
}
