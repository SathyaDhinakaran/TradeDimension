package com.tdm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tdm.qa.base.BaseClass;

public class ResultListPage extends BaseClass{
	
	@FindBy(xpath="//*[contains(@text,'Results')]")
	WebElement results;
	
	@FindBy(xpath="//android.view.ViewGroup[@index='2']")
	WebElement goToHome;
	
	
	@FindBy(xpath="//android.view.ViewGroup[@index='3']")
	WebElement download;
	
	@FindBy(xpath="//android.widget.EditText[@text='Please Enter the value']")
	WebElement downloadPopUp;
	
	@FindBy(xpath="//android.widget.Button[@text='Save']")
	WebElement saveDownl;
	
	public ResultListPage() {
		PageFactory.initElements(driver, this);
	}

	
	public boolean verifyResultListPage() {
		return results.isDisplayed();
	}
	
	public HomePage clickOnMap() {
		goToHome.click();
		return new HomePage();
	}
	
	public void clickOnDownload(String name) throws Exception {
		
		download.click();
		Thread.sleep(2000);
		downloadPopUp.click();
		downloadPopUp.sendKeys(prop.getProperty(name));
		saveDownl.click();
		Thread.sleep(10000);
		
	}
	
}
