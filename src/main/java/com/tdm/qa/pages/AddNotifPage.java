package com.tdm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.tdm.qa.base.BaseClass;
import com.tdm.qa.util.TestUtil;

import io.appium.java_client.MobileElement;



public class AddNotifPage extends BaseClass {
	
	@FindBy(xpath="//android.widget.TextView[@text='Shop Name']//following::android.widget.ImageView")
	WebElement shopNameEdit;
	
	@FindBy(xpath="//android.widget.TextView[@text='Shop Name']//following::android.view.ViewGroup[@index='2']")
	WebElement shopName;
	
	@FindBy(xpath="//*[@text='Comment :']//following::android.widget.EditText")
	WebElement comments;
	
	@FindBy(xpath="//*[@text='Check GeoCodes?']//following::android.view.ViewGroup")
	WebElement geoCode;
	
	@FindBy(xpath="//*[@text='Yes']")
	WebElement yes;
	
	@FindBy(xpath="//*[@text='Add Fields']")
	WebElement addFields;
	
	@FindBy(xpath="//*[@class='android.view.ViewGroup']")
	WebElement clickOutside;
	
	@FindBy(id="search_src_text")
	WebElement searchtxt;
	
	@FindBy(xpath="//*[@text='Add Fields']//following::android.widget.ImageView")
	WebElement saveField;
	
	@FindBy(xpath="//android.view.ViewGroup[@index='2']")
	WebElement saveOpt;
	
	public AddNotifPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnShopNameEdit(String shopN, String comm, String field) {
		
		try {
			shopNameEdit.click();
			shopName.click();
					
			shopName.clear();
			shopName.sendKeys(prop.getProperty(shopN));
			clickOutside.click();
			comments.clear();
			comments.sendKeys(prop.getProperty(comm));
			clickOutside.click();
			geoCode.click();
			yes.click();
			clickOutside.click();
			Thread.sleep(2000);
			addFields.click();
			Thread.sleep(5000);
			searchtxt.click();
			searchtxt.sendKeys(prop.getProperty(field));
			driver.findElement(By.xpath("//android.widget.TextView[@text='"+prop.getProperty(field)+"']")).click();
			saveField.click();
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		}
	
	
	public void scrollTillElem(String field) {
		TestUtil.scrollUpAndDown(field);
	}
			
			public void enterVal(String field, String FieldVal) {
				
				
				try {
					driver.findElement(By.xpath("//android.widget.TextView[@text='"+prop.getProperty(field)+"']//following::android.widget.ImageView")).click();
					
					Thread.sleep(2000);
					driver.findElement(By.xpath("//android.widget.TextView[@text='"+prop.getProperty(field)+"']//following::android.view.ViewGroup[@index='2']")).sendKeys(prop.getProperty(FieldVal));
					clickOutside.click();
					saveOpt.click();
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
			
		
	
	
	

}
