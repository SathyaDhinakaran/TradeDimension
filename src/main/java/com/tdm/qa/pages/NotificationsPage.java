package com.tdm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tdm.qa.base.BaseClass;

public class NotificationsPage extends BaseClass{
	
	@FindBy(xpath="//*[@text='History By User']")
	WebElement notificationScreen;
	
	@FindBy(xpath="//*[@text='History By User']//following::android.widget.ImageView")
	WebElement missingStore;
	
	@FindBy(xpath="//*[@text='Missing Store Notification']")
	WebElement verifMissingStore;
	
	public NotificationsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyNotifiScreen() {
		return notificationScreen.isDisplayed();
	}
	
	public MissingStorePage clickOnMissingStore() {
		
		try {
			missingStore.click();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		return new MissingStorePage();
	}
	
	public boolean verifyMissingStore() {
	return verifMissingStore.isDisplayed();	
	}
}


