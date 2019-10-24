package com.tdm.qa.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tdm.qa.base.BaseClass;

public class SelectFieldPage extends BaseClass {
	@FindBy(id="search_src_text")
	WebElement searchTxt;
	
	@FindBy(xpath="//android.view.ViewGroup[@index='1']")
	WebElement clickOnfield;
	
	@FindBy(xpath="//android.view.ViewGroup[@index='3']")
	WebElement saveBtn;
	
	@FindBy(xpath="//android.view.ViewGroup[@index='2']")
	WebElement backToHome;
	
	@FindBy(xpath="//android.widget.ImageView[@index='0']")
	WebElement backBtn;
	
	Logger log=LogManager.getLogger(SelectFieldPage.class);
	
	public SelectFieldPage() {
		PageFactory.initElements(driver, this);
	}

	public void selectField(String field) throws Exception {
		searchTxt.sendKeys(prop.getProperty(field));
		log.info("SelectFieldPage: Entered legend field in search bar");
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+prop.getProperty(field)+"']")).click();
		log.info("SelectFieldPage: Selected legend field");
		Thread.sleep(2000);
		saveBtn.click();
		log.info("SelectFieldPage: Saved legend field");
		Thread.sleep(5000);
			
	}
	
	public SelectFieldPage clickOnBackBtn() {
		backBtn.click();
		log.info("SelectFieldPage: Clicked on previous button");
		return new SelectFieldPage();
	}
	
	public HomePage clickOnMapBtn() {
		backToHome.click();
		log.info("SelectFieldPage: Clicked on map icon");
		return new HomePage();
	}
	
}
