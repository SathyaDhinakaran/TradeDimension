package com.tdm.qa.pages;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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
	
	Logger log=LogManager.getLogger(AddNotifPage.class);	
	
	
	public void clickOnShopNameEdit(String shopN, String comm) {
		
		try {
			shopNameEdit.click();
			shopName.click();
			shopName.clear();
			shopName.sendKeys(prop.getProperty(shopN));
			log.info("AddNotifPage: Shop name is edited");
			clickOutside.click();
			comments.clear();
			comments.sendKeys(prop.getProperty(comm));
			log.info("AddNotifPage: Comments are added");
			Thread.sleep(2000);
			clickOutside.click();
			addFields.click();
			log.info("AddNotifPage: New field is added");
			Thread.sleep(5000);
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			log.error("AddNotifPage: Exception has occured");
			
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
					log.info("AddNotifPage: Field and its value is added");
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
					log.error("AddNotifPage: Exception has occured");
				}
				
			}
				
				public void save() {
					
					try {
						saveOpt.click();
						Thread.sleep(5000);
						
					} catch (InterruptedException e) {
						
						e.printStackTrace();
						log.error("AddNotifPage: Exception has occured");
					}
				
			}
			
		
	
	
	

}
