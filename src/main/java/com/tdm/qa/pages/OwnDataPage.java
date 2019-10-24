package com.tdm.qa.pages;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tdm.qa.base.BaseClass;
import com.tdm.qa.util.TestUtil;

public class OwnDataPage extends BaseClass{
	@FindBy(xpath="//*[@text='Store Priority']//following::android.widget.EditText")
	WebElement storePrio;
	
	@FindBy(xpath="//*[@text='Orders online?']//following::android.widget.EditText")
	WebElement orderOnl;
	
	@FindBy(xpath="//*[@text='Yes']")
	WebElement yes;
	
	@FindBy(xpath="//*[@text='No']")
	WebElement no;
	
	@FindBy(xpath="//*[@text='Date of Last visit']//following::android.widget.EditText")
	WebElement dolVisit;
	
	@FindBy(id="month_view")
	WebElement fullMonth;
	
	@FindBy(id="date_picker_header_date")
	WebElement monthHeader;
	
	@FindBy(id="next")
	WebElement nextBtn;
	
	@FindBy(id="prev")
	WebElement prevBtn;
	
	@FindBy(xpath="//*[@text='Edit']//following::android.widget.ImageView")
	WebElement save;
	
	@FindBy(xpath="//*[@text='TDLinx']")
	WebElement clickOutside;
	
	Logger log=LogManager.getLogger(OwnDataPage.class);
	
public OwnDataPage() {
	PageFactory.initElements(driver, this);
}

public void enterStorePrio(String prio) {
	
	storePrio.clear();
	storePrio.sendKeys(prop.getProperty(prio));
	log.info("OwnDataPage: entered store priority value");
	clickOutside.click();
}
	

public void selectOrderOnli() {
	orderOnl.click();
	yes.click();
	log.info("OwnDataPage: Selected order online yes");
	clickOutside.click();
	//no.click();  //select no if required by default kept yes.
}


//This method supports current and future date not previous date
public void clickOnCurrentDate(String date, String mon, String year) throws Exception {
	
	if(dolVisit.getText().isEmpty()) {
		dolVisit.click();
		log.info("OwnDataPage: current date value is entered");
		
	}
	else {
	
		dolVisit.click();
		
		
		
		String actual=driver.findElement(By.id("android:id/date_picker_header_year")).getText();
		String expected=prop.getProperty(year);
		
		if(!actual.contentEquals(expected)) {
			driver.findElement(By.id("date_picker_header_year")).click();
			Thread.sleep(2000);
			TestUtil.scrollUpAndDownWithClick(year);
			log.info("OwnDataPage: Selected year");
			
		}
		
		
	while(true) {
		
		WebElement monthYear=driver.findElement(By.id("parentPanel"));
		driver.findElement(By.xpath("//*[@text='1']")).click();
		
		if(monthYear.findElement(By.id("date_picker_header_date")).getText().contains(prop.getProperty(mon))) {
			break;}
		monthYear.findElement(By.id("next")).click();
	}
	
	WebElement fullMonth=driver.findElement(By.id("month_view"));
	List<WebElement> lst=fullMonth.findElements(By.className("android.view.View"));
	for(WebElement we:lst)
	{
		if(we.getText().contentEquals(prop.getProperty(date))) {
			we.click();
			break;
		}
	}
	
	log.info("OwnDataPage: entered month and date");
driver.findElement(By.xpath("//*[@text='OK']")).click();
}}

public void clickOnSave() {
	
	try {
		save.click();
		log.info("OwnDataPage: Saved own data");
		Thread.sleep(5000);
		
	} catch (InterruptedException e) {
		
		e.printStackTrace();
		log.error("OwnDataPage: Exception has occurred "+e.getMessage());
	}
}

public boolean verifyOwnData(String storePriority) {
	TestUtil.scrollUpAndDown(storePriority);
	return driver.findElement(By.xpath("//*[@text='"+prop.getProperty(storePriority)+"']")).isDisplayed();
	
}
}
