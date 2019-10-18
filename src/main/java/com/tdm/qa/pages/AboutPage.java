package com.tdm.qa.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tdm.qa.base.BaseClass;
import com.tdm.qa.testcases.AboutPageTest;

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
	
	Logger log=LogManager.getLogger(AboutPage.class);	
	
	/*
	To check whether link for Privacy Note is displayed or not
	*/
	public boolean verifyPrivacyNote() {
		log.info("AboutPage: Inside Privacy note block");
		return privacyNote.isDisplayed();
		}

	/*
	To check whether link for UserManual is displayed or not
	*/
	public boolean verifyUserManual() {
		log.info("AboutPage: Inside user manual block");
		return userManual.isDisplayed();
	}
	
	/*
	To check whether link for Impressum is displayed or not
	*/
	public boolean verifyImpressum() {
		log.info("AboutPage: Inside impressum block");
		return impressum.isDisplayed();
	}
}
