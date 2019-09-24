package com.tdm.qa.pages;

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
	return new OfflineDataPage();

}

public ResultListPage clickOnResultList() {
	 resultList.click();
	 return new ResultListPage();
}

public HierarchiesPage clickOnHierarchies() {
	
	try {
		hierarchies.click();
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	return new HierarchiesPage();
}

public NotificationsPage clickOnNotifications() {
	
	try {
		notifications.click();
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	return new NotificationsPage();
}

public SettingsPage clickOnSettings() {
	settings.click();
	return new SettingsPage();
}

public AboutPage clickOnAboutPage() {
	
	try {
		about.click();
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	return new AboutPage();
}

public SignOutPage clickOnSignOut() {
	signOut.click();
	return new SignOutPage();
}

}