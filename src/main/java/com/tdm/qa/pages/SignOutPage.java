package com.tdm.qa.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tdm.qa.base.BaseClass;

public class SignOutPage extends BaseClass{
	
	@FindBy(xpath="//android.widget.TextView[@text='Sign Out']")
	WebElement signOutPopUp;
	
	@FindBy(xpath="//android.widget.Button[@text='Yes']")
	WebElement yesBtn;
	
	@FindBy(xpath="//android.widget.Button[@text='No']")
	WebElement noBtn;
	
	Logger log=LogManager.getLogger(SignOutPage.class);
	
	public SignOutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifySignOutPopUp() {
		return signOutPopUp.isDisplayed();
		}
	
	public LoginPage clickOnYes() {
		yesBtn.click();
		log.info("SignOutPage: Clicked on Yes");
		return new LoginPage();
	}
	
	public HomePage clickOnNo() {
		noBtn.click();
		log.info("SignOutPage: Clicked on No");
		return new HomePage();
	}

}
