package com.tdm.qa.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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
	
	Logger log=LogManager.getLogger(ResultListPage.class);
	
	public ResultListPage() {
		PageFactory.initElements(driver, this);
	}

	
	public boolean verifyResultListPage() {
		return results.isDisplayed();
	}
	
	public HomePage clickOnMap() {
		goToHome.click();
		log.info("ResultListPage: clicked on map icon");
		return new HomePage();
	}
	
	public void clickOnDownload(String name) throws Exception {
		
		download.click();
		log.info("ResultListPage: clicked on download icon");
		Thread.sleep(2000);
		downloadPopUp.click();
		downloadPopUp.sendKeys(prop.getProperty(name));
		log.info("ResultListPage: Entered file name for download");
		saveDownl.click();
		log.info("ResultListPage: clicked on save download");
		Thread.sleep(10000);
		
	}
	
}
