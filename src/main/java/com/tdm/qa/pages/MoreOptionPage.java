package com.tdm.qa.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.tdm.qa.base.BaseClass;


public class MoreOptionPage extends BaseClass{
	
		
	@FindBy(xpath="//android.widget.TextView[@text='Offline Data']")
	WebElement offlineData;
	
	@FindBy(xpath="//android.widget.TextView[@text='Result List']")
	WebElement resultList;
		
	@FindBy(xpath="//android.widget.TextView[@text='Hierarchies']")
	WebElement hierarchies;
	
	@FindBy(xpath="//android.widget.TextView[@text='Notifications']")
	WebElement notifications;
	
	@FindBy(xpath="//android.widget.TextView[@text='Settings']")
	WebElement settings;
	
	@FindBy(xpath="//android.widget.TextView[@text='About']")
	WebElement about;
	
	@FindBy(xpath="//android.widget.TextView[@text='Sign Out']")
	WebElement signOut;
	
	@FindBy(xpath="//*[@text='Settings']")
	WebElement settingsPgTitle;
	
	Logger log=LogManager.getLogger(MoreOptionPage.class);

public MoreOptionPage() {
	PageFactory.initElements(driver, this);
}

public boolean verifyMoreOptionPopUp() {
	return signOut.isDisplayed();
}

public boolean verifySettingsPage() {
	return settingsPgTitle.isDisplayed();
}

public OfflineDataPage clickOnOfflineData() {
	offlineData.click();
	log.info("MoreOptionPage: clicked on offline data");
	return new OfflineDataPage();

}

public ResultListPage clickOnResultList() {
	 resultList.click();
	 log.info("MoreOptionPage: clicked on result list");
	 return new ResultListPage();
}

public HierarchiesPage clickOnHierarchies() {
	
	try {
		hierarchies.click();
		log.info("MoreOptionPage: clicked on hierarchies");
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
		log.error("MoreOptionPage: Exception has occured "+e.getMessage());
	}
	return new HierarchiesPage();
}

public NotificationsPage clickOnNotifications() {
	
	try {
		notifications.click();
		log.info("MoreOptionPage: clicked notification");
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
		log.error("MoreOptionPage: exception has occured "+e.getMessage());
	}
	return new NotificationsPage();
}

public SettingsPage clickOnSettings() {
	settings.click();
	log.info("MoreOptionPage: clicked on settings");
	return new SettingsPage();
}

public AboutPage clickOnAboutPage() {
	
	try {
		about.click();
		log.info("MoreOptionPage: clicked on about link");
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
		log.error("MoreOptionPage: exception has occured "+e.getMessage());
	}
	return new AboutPage();
}

public SignOutPage clickOnSignOut() {
	signOut.click();
	log.info("MoreOptionPage: clicked on signout");
	return new SignOutPage();
}

}