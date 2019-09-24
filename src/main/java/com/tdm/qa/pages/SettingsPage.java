package com.tdm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.tdm.qa.base.BaseClass;

import io.appium.java_client.MobileElement;

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
	
	
	
	public SettingsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public SelectFieldPage goToSelectFields() {
		
		try {
			setLegendMoreOpt.click();
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		return new SelectFieldPage();
	}
	
	public SettingsPage clickOnReset() {
		reset.click();
		return new SettingsPage();
			
	}
	
	public void clickOnEdit() {
		
		try {
			edit.click();
			Thread.sleep(10000);
		} catch (Exception e) {
			
			e.printStackTrace();
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
	
	/*public SettingsPage clickOnPicker() {
		
		
		try {
			clickCountryPicker.click();
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		return new SettingsPage();
		
	}
	
	public boolean verifyCountryPicker() {
		return counPicker.isDisplayed();
	}
	
	public void selectCountry(String country) throws Exception {
		
		List<MobileElement>lst=driver.findElements(By.className("android.widget.EditText"));
		
		lst.get(2).click();
		Thread.sleep(2000); 
		//driver.findElement(By.xpath("//*[@text='"+prop.getProperty(country)+"']")).click();
		
	}*/

	
}
