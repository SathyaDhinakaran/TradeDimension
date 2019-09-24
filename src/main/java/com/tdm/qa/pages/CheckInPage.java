package com.tdm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tdm.qa.base.BaseClass;

public class CheckInPage extends BaseClass{
	
	@FindBy(xpath="//*[@text='Comment']//following::android.widget.EditText")
	WebElement comments;
	
	@FindBy(xpath="//*[@text='Check In']//following::android.widget.ImageView")
	WebElement save;
	
	@FindBy(xpath="//*[@text='Check In']//preceding::android.widget.ImageView")
	WebElement backBtn;
	
	public CheckInPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterComments(String com) {
		
		try {
			comments.sendKeys(prop.getProperty(com));
			save.click();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	
	

}
