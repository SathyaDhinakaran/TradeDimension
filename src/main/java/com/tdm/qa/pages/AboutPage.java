package com.tdm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tdm.qa.base.BaseClass;

public class AboutPage extends BaseClass{
	
	@FindBy(xpath="//android.widget.TextView[@text='Privacy note']")
	WebElement privacyNote;
	
	@FindBy(xpath="//android.widget.TextView[@text='User manual']")
	WebElement userManual;
	
	@FindBy(xpath="//android.widget.TextView[@text='Impressum']")
	WebElement impressum;
	
	public AboutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyPrivacyNote() {
		return privacyNote.isDisplayed();
	}

	public boolean verifyUserManual() {
		return userManual.isDisplayed();
	}
	
	public boolean verifyImpressum() {
		return impressum.isDisplayed();
	}
}
