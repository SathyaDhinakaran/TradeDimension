package com.tdm.qa.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tdm.qa.base.BaseClass;

public class SettingsEditPage extends BaseClass {
	
	@FindBy(xpath="//android.view.ViewGroup[@index='4']")
	WebElement skyBlueIcon;
	
	@FindBy(xpath="//android.view.ViewGroup[@index='5']")
	WebElement redIcon;
	
	@FindBy(xpath="//android.view.ViewGroup[@index='6']")
	WebElement yellowIcon;
	
	@FindBy(xpath="//android.view.ViewGroup[@index='7']")
	WebElement roseIcon;
	
	@FindBy(xpath="//android.view.ViewGroup[@index='8']")
	WebElement greenIcon;
	
	@FindBy(xpath="//android.view.ViewGroup[@index='2']")
	WebElement resetBtn;
	
	@FindBy(xpath="//android.view.ViewGroup[@index='3']")
	WebElement saveButton;
	
	@FindBy(xpath="//android.view.ViewGroup[@index='0']")
	WebElement backButton;
	
	@FindBy(id="search_src_text")
	WebElement searchVal;
	
	@FindBy(xpath="//android.widget.Button[@text='Yes']")
	WebElement yes;
	
	Logger log=LogManager.getLogger(SettingsEditPage.class);
	
	public SettingsEditPage() {
		PageFactory.initElements(driver, this);
	}
	
	public SettingsEditPage setIcon(String val) {
		
		 try {			 	
				searchVal.click();
				searchVal.clear();
				searchVal.sendKeys(prop.getProperty(val));
				log.info("SettingsEditPage: Entered field value for icon configuration");
			    driver.findElement(By.xpath("//android.widget.TextView[@text='"+prop.getProperty(val)+"']")).click();
			    log.info("SettingsEditPage: Selected field value for icon configuration");
			    Thread.sleep(2000);
			 
		} catch (Exception e) {
			
			e.printStackTrace();
			log.error("SettingsEditPage: Exception has occurred "+e.getMessage());
		}
		
	return new SettingsEditPage();				
	}
	
	
	public void toSetSkyBlueIcon() {
		skyBlueIcon.click();
		log.info("SettingsEditPage: Clicked on sky blue icon");
	}
	
	public void toSetRedIcon() {
		
		try {
			redIcon.click();
			log.info("SettingsEditPage: Clicked on red icon");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			log.error("SettingsEditPage: Exception has occurred "+e.getMessage());
		}
	}
	
	public void toSetYellowIcon() {
		yellowIcon.click();
		log.info("SettingsEditPage: Clicked on yellow icon");
	}
	
	public void toSetRoseIcon() {
		roseIcon.click();
		log.info("SettingsEditPage: Clicked on pink icon");
	}
	
	public void toSetGreenIcon() {
		greenIcon.click();
		log.info("SettingsEditPage: Clicked on green icon");
	}
	
	public SettingsPage clickOnSave() {
		try {
			saveButton.click();
			log.info("SettingsEditPage: Clicked on save option");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			log.error("SettingsEditPage: Exception has occurred "+e.getMessage());
		}
		return new SettingsPage();
	}
	
	public SettingsPage clickOnReset() {
		
		try {
			resetBtn.click();
			log.info("SettingsEditPage: Clicked on reset icon");
			yes.click();
			log.info("SettingsEditPage: Selected yes");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			log.error("SettingsEditPage: Exception has occurred "+e.getMessage());
		}
		return new SettingsPage();
	}

}
