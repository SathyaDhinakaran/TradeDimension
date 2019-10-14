package com.tdm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tdm.qa.base.BaseClass;

public class NearMePage extends BaseClass {
	@FindBy(xpath="//android.view.View[contains(@content-desc,'_photograph.jpeg')]")
	WebElement nearMeShop;
	
	@FindBy(xpath="//android.widget.TextView[@text='Distance']")
	WebElement shortInfo;
	
	@FindBy(xpath="//android.widget.TextView[@text='Distance']//following::android.widget.ImageView")
	WebElement navigator;
	
	@FindBy(xpath="//android.widget.EditText[@text='‎www.google.com']")
	WebElement googleMap;
	
	public NearMePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyNearMeShop() {
		return nearMeShop.isDisplayed();
	}
	
	public HomePage clickOnShops() {
			
		 try {
			 nearMeShop.click();
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		 return new HomePage();
	}

	public boolean verifyShortInfo() {
		return shortInfo.isDisplayed();
	}
	
	public StoreDetailsPage clickOnShortInfo() {
		
		try {
			shortInfo.click();
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		return new StoreDetailsPage();
	}
	
	public NearMePage clickOnNavigator() {
		
		try {
			navigator.click();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		return new NearMePage();
	}
	
	public boolean verifyGoogleMap() {
		return googleMap.isDisplayed();
	}
}
