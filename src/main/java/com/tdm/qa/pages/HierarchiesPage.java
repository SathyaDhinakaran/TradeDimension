package com.tdm.qa.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.tdm.qa.base.BaseClass;


public class HierarchiesPage extends BaseClass {
	
	@FindBy(xpath="//*[@text='Hierarchies']")
	WebElement hierarchyScreen;
	
	@FindBy(xpath="//android.view.ViewGroup[@index='4']")
	WebElement contiWith;
	
	@FindBy(xpath="//android.view.ViewGroup[@index='4']//following::android.widget.ImageView")
	WebElement expand;
	
	@FindBy(id="text1")
	WebElement store;
	
	Logger log=LogManager.getLogger(HierarchiesPage.class);
	
	public HierarchiesPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyHierarchyScreen() {
		return hierarchyScreen.isDisplayed();	
	}
	
	public void clickOnExpand() {
		
		try {
			expand.click();
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			log.info("HierarchiesPage: Exception has occured");
			
		}
	}
	
	public void clickOnContiWith() {
		contiWith.click();
	}
	
	public HomePage clickOnStore() {
		
		try {
			store.click();
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			log.info("HierarchiesPage: Exception has occured");
		}
	return new HomePage();	
	}
		
	public void selectCheckbox() {
		for(int i=5;i<10;i++) {
			driver.findElement(By.xpath("//android.view.ViewGroup[@index='"+i+"']//following::android.widget.CheckBox")).click();
		}
		
	}

}
