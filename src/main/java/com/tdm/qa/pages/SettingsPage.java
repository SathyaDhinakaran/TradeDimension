package com.tdm.qa.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.tdm.qa.base.BaseClass;

public class SettingsPage extends BaseClass{
	@FindBy(xpath="//android.widget.EditText[@index='0']")
	WebElement clickCountryPicker;
	
	@FindBy(xpath="//android.view.ViewGroup[@index='1']")
	WebElement clickLangPicker;
	
	@FindBy(xpath="//*[@text='Please Select']")
	WebElement counPicker;
	
	@FindBy(xpath="//*[@text='Set Legend Field']//following::android.widget.ImageView")
	WebElement setLegendMoreOpt;
	
	@FindBy(xpath="//android.widget.Button[@text='Reset']")
	WebElement reset;
	
	@FindBy(xpath="//android.widget.Button[@text='Edit']")
	WebElement edit;

	@FindBy(xpath="//*[@text='Set Legend Field']//following::android.view.ViewGroup")
	WebElement afterReset;
	
	Logger log=LogManager.getLogger(SettingsPage.class);
	
	public SettingsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public SelectFieldPage goToSelectFields() {
		
		try {
			setLegendMoreOpt.click();
			log.info("SettingsPage: Clicked on more option in set legend");
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			log.error("SettingsPage: Exception has occurred "+e.getMessage());
		}
		return new SelectFieldPage();
	}
	
	public SettingsPage clickOnReset() {
		reset.click();
		log.info("SettingsPage: Clicked on reset in settings page");
		return new SettingsPage();
			
	}
	
	public void clickOnEdit() {
		
		try {
			edit.click();
			log.info("SettingsPage: Clicked on edit option");
			Thread.sleep(20000);
		} catch (Exception e) {
			
			e.printStackTrace();
			log.error("SettingsPage: Exception has occurred "+e.getMessage());
		}
			
	}
	
	public boolean afterReset() {
		String text1=afterReset.getAttribute("text");
		System.out.println("text content:"+text1);
		if(text1.isEmpty())
			return true;
		else
			return false;
	}
	
		
}
