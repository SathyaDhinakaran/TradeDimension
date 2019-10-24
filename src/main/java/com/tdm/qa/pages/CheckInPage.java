package com.tdm.qa.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tdm.qa.base.BaseClass;


public class CheckInPage extends BaseClass{
	
	@FindBy(xpath="//*[@text='Comment']//following::android.widget.EditText")
	WebElement comments;
	
	@FindBy(xpath="//*[@text='Check In']//following::android.widget.ImageView")
	WebElement save;
	
	@FindBy(xpath="//*[@text='Check In']//preceding::android.widget.ImageView")
	WebElement backBtn;
	
	Logger log=LogManager.getLogger(CheckInPage.class);
	
	
	public CheckInPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterComments(String com) {
		
		try {
			comments.sendKeys(prop.getProperty(com));
			save.click();
			log.info("CheckInPage: Check-in comment saved successfully");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			log.error("CheckInPage: Exception has occurred "+e.getMessage());
		}
		
	}
	
	

}
