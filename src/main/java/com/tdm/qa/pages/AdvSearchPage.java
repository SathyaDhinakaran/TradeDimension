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


public class AdvSearchPage extends BaseClass {
	
	@FindBy(xpath="//android.widget.TextView[@text='Advanced Search']")
	WebElement advSearchScreen;
	
	@FindBy(xpath="//*[@text='Advanced Search']//preceding::android.widget.ImageView")
	WebElement addValBackBtn;
	
	@FindBy(xpath="//android.widget.TextView[@text='Advanced Search']//following::android.view.ViewGroup[@index='2']")
	WebElement saveButton;
	
	@FindBy(xpath="//android.view.ViewGroup[@index='3']")
	WebElement viewSavedQry;
	
	@FindBy(xpath="//android.widget.TextView[@text='Advanced Search']//following::android.view.ViewGroup[@index='4']")
	WebElement reset;
	
	@FindBy(xpath="//*[@text='Add Fields']")
	WebElement addField;
	
		
	@FindBy(xpath="//*[@text='Operators']/following::android.widget.ImageView")
	WebElement selOper;
	
	@FindBy(xpath="//*[@text='Add Fields']//following::android.view.ViewGroup[@index='3']")
	WebElement dropDown;
	
	@FindBy(id="search_src_text")
	WebElement searchtxt;
	
	@FindBy(xpath="//android.view.ViewGroup[@index='0']")
	WebElement backBtn;
	
	
	@FindBy(xpath="//*[@text='Apply Search Criteria']")
	WebElement applySearch;
	
	@FindBy(xpath="//*[@text='Enter query name']")
	WebElement enterQueryN;
	
	@FindBy(xpath="//*[@text='Enter query name']//following::android.widget.ImageView")
	WebElement saveQuery;
	
	
	@FindBy(xpath="//*[@text='Yes']")
	WebElement yes;
	
	@FindBy(xpath="//*[@text='Add Fields']//following::android.widget.ImageView")
	WebElement saveField;
	
	@FindBy(xpath="//*[@text='Add Values']//following::android.widget.ImageView")
	WebElement saveValues;
	
	Logger log=LogManager.getLogger(AdvSearchPage.class);
	
	public AdvSearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	 public boolean verifyAdvSearchScreen() {
    	
    return	advSearchScreen.isDisplayed();
    
    }

    	
	public void deleteQuery(String delQuery) {
		driver.findElement(By.xpath("//*[@text='"+prop.getProperty(delQuery)+"']")).click();
		yes.click();
		log.info("AdvSearchPage: Successfully deleted the query");
	}
    
	
	public void clickOnReset() {
		
		try {
			Thread.sleep(3000);
			reset.click();
			yes.click();
			log.info("AdvSearchPage: Reset is successful");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			 
			e.printStackTrace();
			log.error("AdvSearchPage: Exception has occured");
		}
	}
	
	public void viewQuery() {
		viewSavedQry.click();
	}
	
	
	public void clickOnAddFields() {
		
		try {
			addField.click();
			Thread.sleep(2000);
			log.info("AdvSearchPage: Clicked on add field");
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			log.error("AdvSearchPage: Exception has occured");
			
		}
						
	}
	
	public void selectOperator(String field, String op, String val, String mon, String date, String year) throws Exception {
		
			
		TestUtil.scrollUpAndDown(field);
					
		String defaultOper= driver.findElement(By.xpath("//*[@text='"+prop.getProperty(field)+"']//following::android.widget.TextView")).getText();
		System.out.println("op: "+defaultOper);
		Thread.sleep(2000);
		
		
			if(defaultOper.contentEquals("starts with")) {
				driver.findElement(By.xpath("//*[@text='"+prop.getProperty(field)+"']//following::android.view.ViewGroup[@index='2']")).click();
				driver.findElement(By.xpath("//*[@text='"+prop.getProperty(op)+"']")).click();
				selOper.click();
				log.info("AdvSearchPage: Operator selected for 'start with'(String data type)");
			    driver.findElement(By.xpath("//*[@text='"+prop.getProperty(field)+"']//following::android.widget.EditText")).sendKeys(prop.getProperty(val));
			    log.info("AdvSearchPage: Value added for the field");
			    driver.findElement(By.xpath("//*[@text='"+prop.getProperty(field)+"']")).click();
		}
		 
			else if(defaultOper.contentEquals("is included in ")) {
			 	driver.findElement(By.xpath("//*[@text='"+prop.getProperty(field)+"']//following::android.view.ViewGroup[@index='2']")).click();
				driver.findElement(By.xpath("//*[@text='"+prop.getProperty(op)+"']")).click();
				selOper.click();
				Thread.sleep(2000);
				log.info("AdvSearchPage: Operator selected for 'is included in'(picker data type) ");
			driver.findElement(By.xpath("//*[@text='"+prop.getProperty(field)+"']//following::android.view.ViewGroup[@index='3']")).click();
			Thread.sleep(2000);
			addValBackBtn.click();
			driver.findElement(By.xpath("//*[@text='"+prop.getProperty(field)+"']//following::android.view.ViewGroup[@index='3']")).click();
			Thread.sleep(2000);
			searchtxt.click();
			searchtxt.sendKeys(prop.getProperty(val));
			log.info("AdvSearchPage: Search text is entered in search field");
			driver.findElement(By.xpath("//android.widget.TextView[@text='"+prop.getProperty(val)+"']")).click();
			saveValues.click();
			log.info("AdvSearchPage: Selected value for the field");
			
		}
		 
		 else if(defaultOper.contentEquals("is true")) {
			 driver.findElement(By.xpath("//*[@text='"+prop.getProperty(field)+"']//following::android.view.ViewGroup[@index='2']")).click();
				driver.findElement(By.xpath("//*[@text='"+prop.getProperty(op)+"']")).click();
				selOper.click();
				log.info("AdvSearchPage: Operator is selected for 'on'(boolean data type)");
				// driver.findElement(By.xpath("//*[@text='"+prop.getProperty(field)+"']")).click();
			
		}
		 
		 else if(defaultOper.contentEquals("on")) {
			driver.findElement(By.xpath("//*[@text='"+prop.getProperty(field)+"']//following::android.view.ViewGroup[@index='2']")).click();
			driver.findElement(By.xpath("//*[@text='"+prop.getProperty(op)+"']")).click();
			selOper.click();
			log.info("AdvSearchPage: Operator is selected for 'on'(Date data type)");
			driver.findElement(By.xpath("//*[@text='"+prop.getProperty(field)+"']//following::android.view.ViewGroup[@index='5']")).click();
			
			String actual=driver.findElement(By.id("android:id/date_picker_header_year")).getText();
			String expected=prop.getProperty(year);
			
			if(!actual.contentEquals(expected)) {
				driver.findElement(By.id("date_picker_header_year")).click();
				Thread.sleep(2000);
				TestUtil.scrollUpAndDownWithClick(year);
				
			}
			
			while(true) {
				
				WebElement monthYear=driver.findElement(By.id("parentPanel"));
				
				driver.findElement(By.xpath("//*[@text='1']")).click();
				if(monthYear.findElement(By.id("date_picker_header_date")).getText().contains(prop.getProperty(mon))) {
					break;}
				monthYear.findElement(By.id("prev")).click();
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
			
		driver.findElement(By.xpath("//*[@text='OK']")).click();
		log.info("AdvSearchPage: Date, month and year is selected");
	

		}	
			
			
else if(defaultOper.contentEquals("equals")) {
	 driver.findElement(By.xpath("//*[@text='"+prop.getProperty(field)+"']//following::android.view.ViewGroup[@index='2']")).click();
			driver.findElement(By.xpath("//*[@text='"+prop.getProperty(op)+"']")).click();
			selOper.click();
			log.info("AdvSearchPage: Operator is selected for 'equals'(numeric data type)");
			driver.findElement(By.xpath("//*[@text='"+prop.getProperty(field)+"']//following::android.view.ViewGroup[@index='5']")).sendKeys(prop.getProperty(val));
			log.info("AdvSearchPage: Value for the field is entered"); 
			driver.findElement(By.xpath("//*[@text='"+prop.getProperty(field)+"']")).click();

}
			
	}
	
	
	public void saveSelectedField() {
		
		try {
			saveField.click();
			
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			log.error("AdvSearchPage: Exception has occured");
			
		}
	}
	
	public void applySearch()  {
		
		try {
			applySearch.click();
			log.info("AdvSearchPage: Clicked on apply search");
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			log.error("AdvSearchPage: Exception has occured");
			
		}
	}
	
	public void saveQuery(String queryN) {
		try {
			Thread.sleep(2000);
			advSearchScreen.click();
			System.out.println("clicked on advanced search");
			saveButton.click();
			log.info("AdvSearchPage: Clicked on save button");
			System.out.println("clicked");
			enterQueryN.click();
			enterQueryN.sendKeys(prop.getProperty(queryN));
			log.info("AdvSearchPage: Query name entered successfully");
			driver.findElement(By.xpath("//*[@text='"+prop.getProperty(queryN)+"']//following::android.widget.ImageView")).click();
			log.info("AdvSearchPage: Saved query");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
			log.error("AdvSearchPage: Exception has occured");
			
		}
		
	}
	
	public boolean validateReset(String fieldN) {
		addField.click();
		log.info("AdvSearchPage: Clicked on add field to validate reset");
		return driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+prop.getProperty(fieldN)+"\").instance(0))").isDisplayed();
		   
		
	}
	
	
}
