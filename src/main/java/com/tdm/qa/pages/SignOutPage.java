package com.tdm.qa.pages;

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
	
	public SignOutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifySignOutPopUp() {
		return signOutPopUp.isDisplayed();
		}
	
	public LoginPage clickOnYes() {
		yesBtn.click();
		return new LoginPage();
	}
	
	public HomePage clickOnNo() {
		noBtn.click();
		return new HomePage();
	}

}
