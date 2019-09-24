package com.tdm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tdm.qa.base.BaseClass;

public class MissingStorePage extends BaseClass{
	
	@FindBy(xpath="//*[@text='Shop Name']//following::android.widget.EditText")
	WebElement shopName;
	
	@FindBy(xpath="//*[@text='Street Name']//following::android.widget.EditText")
	WebElement streetName;
	
	@FindBy(xpath="//*[@text='City']//following::android.widget.EditText")
	WebElement city;
	
	@FindBy(xpath="//*[@text='Outlet Type']//following::android.widget.ImageView")
	WebElement dropdownOutletType;
	
	@FindBy(xpath="//*[@text='Outlet Type']//following::android.widget.EditText")
	WebElement outletType;
	
	@FindBy(id="search_src_text")
	WebElement outlet;
	
	@FindBy(xpath="//*[@text='Missing Store Notification']")
	WebElement clickOutside;
	
	@FindBy(xpath="//*[@text='Comment :']//following::android.widget.EditText")
	WebElement comments;
	
	@FindBy(xpath="//*[@text='Check GeoCodes?']//following::android.view.ViewGroup")
	WebElement geoCode;
	
	@FindBy(xpath="//*[@text='Add Fields']")
	WebElement addFields;
	
	@FindBy(xpath="//*[@text='Missing Store Notification']//following::android.widget.ImageView")
	WebElement saveOpt;
	
	@FindBy(xpath="//*[@text='Add Values']//following::android.widget.ImageView")
	WebElement selectValue;
	
	@FindBy(xpath="//*[@text='Add Fields']//following::android.widget.ImageView")
	WebElement selectField;
	
	@FindBy(xpath="//*[@text='Add Values']")
	WebElement clickOutsideOfValues;
	
	@FindBy(xpath="//*[@text='Yes']")
	WebElement yes;
	
	public MissingStorePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterShopDetails(String shopN,String StreetN, String cityN, String val1, String comm, String fieldN, String val2) {
				
		try {
			shopName.sendKeys(prop.getProperty(shopN));
			clickOutside.click();
			streetName.click();
			streetName.sendKeys(prop.getProperty(StreetN));
			clickOutside.click();
			city.click();
			city.sendKeys(prop.getProperty(cityN));
			clickOutside.click();
			outletType.click();
			dropdownOutletType.click();
			Thread.sleep(2000);
			outlet.click();
			outlet.sendKeys(prop.getProperty(val1));
			clickOutsideOfValues.click();
		    driver.findElement(By.xpath("//android.widget.TextView[@text='"+prop.getProperty(val1)+"']")).click();
		    selectValue.click();
		    comments.sendKeys(prop.getProperty(comm));
		    clickOutside.click();
		    geoCode.click();
		    yes.click();
		    clickOutside.click();
		    addFields.click();
		    Thread.sleep(3000);
		    outlet.click();
			outlet.sendKeys(prop.getProperty(fieldN));
		    driver.findElement(By.xpath("//android.widget.TextView[@text='"+prop.getProperty(fieldN)+"']")).click();
		    
		    selectField.click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//*[@text='"+prop.getProperty(fieldN)+"']//following::android.widget.EditText")).sendKeys(prop.getProperty(val2));
		    saveOpt.click();
		    Thread.sleep(5000);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}

}
