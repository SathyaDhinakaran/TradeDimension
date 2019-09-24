package com.tdm.qa.pages;

import org.openqa.selenium.Alert;
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
	
	public SettingsEditPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	public SettingsEditPage setIcon(String val) {
		
		 try {			 	
				searchVal.click();
				searchVal.clear();
				searchVal.sendKeys(prop.getProperty(val));
			    driver.findElement(By.xpath("//android.widget.TextView[@text='"+prop.getProperty(val)+"']")).click();
			    Thread.sleep(2000);
			 
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	return new SettingsEditPage();				
	}
	
	
	public void toSetSkyBlueIcon() {
		skyBlueIcon.click();
	}
	
	public void toSetRedIcon() {
		
		try {
			redIcon.click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	public void toSetYellowIcon() {
		yellowIcon.click();
	}
	
	public void toSetRoseIcon() {
		roseIcon.click();
	}
	
	public void toSetGreenIcon() {
		greenIcon.click();
	}
	
	public SettingsPage clickOnSave() {
		try {
			saveButton.click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		return new SettingsPage();
	}
	
	public SettingsPage clickOnReset() {
		
		try {
			resetBtn.click();
			yes.click();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		return new SettingsPage();
	}

}
