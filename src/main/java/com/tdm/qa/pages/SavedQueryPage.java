package com.tdm.qa.pages;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.tdm.qa.base.BaseClass;
import com.tdm.qa.util.TestUtil;

public class SavedQueryPage extends BaseClass{
	
	@FindBy(xpath="//android.widget.TextView[@text='View Queries']")
	WebElement viewQuery;
	
	@FindBy(xpath="//android.widget.TextView[@text='Query Details']")
	WebElement savedQryScreen;

	@FindBy(xpath="//android.widget.TextView[@text='Query Details']//following::android.view.ViewGroup[@index='2']")
	WebElement editBtn;
	
	@FindBy(xpath="//android.widget.TextView[@text='Query Details']//following::android.view.ViewGroup[@index='2']")
	WebElement saveBtn;
	
	@FindBy(xpath="//android.widget.TextView[@text='Query Details']//following::android.view.ViewGroup[@index='4']")
	WebElement resetBtn;
	
	@FindBy(xpath="//*[@text='Apply Search Criteria']")
	WebElement applySearch;
	
	@FindBy(xpath="//*[@text='Save']")
	WebElement querySave;
	
	@FindBy(xpath="//*[@text='Save As']")
	WebElement saveAs;
	
	@FindBy(xpath="//*[@text='Add Fields']")
	WebElement addField;
	
	@FindBy(xpath="//*[@text='Add Fields']//following::android.widget.ImageView")
	WebElement saveField;
	
	@FindBy(xpath="//*[@text='Operators']/following::android.widget.ImageView")
	WebElement selOper;
	
	@FindBy(xpath="//*[@text='Add Values']//preceding::android.widget.ImageView")
	WebElement addValBackBtn;
	
	@FindBy(xpath="//*[@text='Add Fields']//preceding::android.widget.ImageView")
	WebElement addFieldBackBtn;
	
	@FindBy(id="search_src_text")
	WebElement searchtxt;
	
	@FindBy(xpath="//*[@text='Add Values']//following::android.widget.ImageView")
	WebElement saveValues;
	
	@FindBy(xpath="//*[@text='Enter query name']")
	WebElement enterQueryN;
	
	@FindBy(xpath="//*[@text='Yes']")
	WebElement yes;
	
	Logger log=LogManager.getLogger(SavedQueryPage.class);
	
	public SavedQueryPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifySavedQueryPage() {
		return viewQuery.isDisplayed();
	}

	public boolean verifySavedQry(String qryName) {
		
		
		TestUtil.scrollUpAndDown(qryName);
		return driver.findElement(By.xpath("//*[@text='"+prop.getProperty(qryName)+"']")).isDisplayed();
		  
	}
	
	public void editQuery(String queryN) {
			try {
				
				TestUtil.scrollUpAndDownWithClick(queryN);
				log.info("SavedQueryPage: Clicked on query");
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				log.error("SavedQueryPage: Exception has occurred "+e.getMessage());
			}
	}
	
	public void applySearch() {
		try {
			
			applySearch.click();
			log.info("SavedQueryPage: Clicked on apply search");
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			log.error("SavedQueryPage: Exception has occurred "+e.getMessage());
		}
		
}

	public void clickOnEdit() {
		
		try {
			editBtn.click();
			log.info("SavedQueryPage: Clicked on edit query");
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			log.error("SavedQueryPage: Exception has occurred "+e.getMessage());
		}
		
	}
	
	public void modifyValue(String addFieldN, String op, String val) {
		
		try {
			addField.click();
			log.info("SavedQueryPage: Clicked on add fields");
			Thread.sleep(2000);
			TestUtil.scrollUpAndDownWithClick(addFieldN);
			saveField.click(); 
			log.info("SavedQueryPage: Added new field");
			TestUtil.scrollUpAndDown(addFieldN);
			driver.findElement(By.xpath("//*[@text='"+prop.getProperty(addFieldN)+"']//following::android.view.ViewGroup[@index='2']")).click();
			driver.findElement(By.xpath("//*[@text='"+prop.getProperty(op)+"']")).click();
			selOper.click();
			log.info("SavedQueryPage: Selected operator for the newly added field");
			Thread.sleep(2000);
			
		driver.findElement(By.xpath("//*[@text='"+prop.getProperty(addFieldN)+"']//following::android.view.ViewGroup[@index='3']")).click();
		log.info("SavedQueryPage: Clicked on dropdown");
		Thread.sleep(2000);
		addValBackBtn.click();
		driver.findElement(By.xpath("//*[@text='"+prop.getProperty(addFieldN)+"']//following::android.view.ViewGroup[@index='3']")).click();
		Thread.sleep(2000);
		searchtxt.click();
		log.info("SavedQueryPage: Clicked on search field");
		searchtxt.sendKeys(prop.getProperty(val));
		log.info("SavedQueryPage: Entered value in search text field");
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+prop.getProperty(val)+"']")).click();
		log.info("SavedQueryPage: Selected field value");
		saveValues.click();
		log.info("SavedQueryPage: Added field value");
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			log.error("SavedQueryPage: Exception has occurred "+e.getMessage());
		}
		  
		
	}
	
	public void saveAs(String saveQryN) {
		try {
			Thread.sleep(2000);
			savedQryScreen.click();
			saveBtn.click();
			log.info("SavedQueryPage: Clicked on Save button");
			saveAs.click();
			log.info("SavedQueryPage: Selected SaveAs option");
			enterQueryN.click();
			enterQueryN.sendKeys(prop.getProperty(saveQryN));
			log.info("SavedQueryPage: Entered save as name");
			driver.findElement(By.xpath("//*[@text='"+prop.getProperty(saveQryN)+"']//following::android.widget.ImageView")).click();
			log.info("SavedQueryPage: Save As query is saved");
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			log.error("SavedQueryPage: Exception has occurred "+e.getMessage());
		}
		
	}
	
	public void verifySaveQ(String fieldN, String op) {
		
		try {
			
			TestUtil.scrollUpAndDown(fieldN);
			driver.findElement(By.xpath("//*[@text='"+prop.getProperty(fieldN)+"']//following::android.view.ViewGroup[@index='2']")).click();
			driver.findElement(By.xpath("//*[@text='"+prop.getProperty(op)+"']")).click();
			selOper.click();
			log.info("SavedQueryPage: Modified operator for the field");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			log.error("SavedQueryPage: Exception has occurred "+e.getMessage());
		}
		
	}
	
	public void clickOnSave() {
		
		try {
			savedQryScreen.click();
			saveBtn.click();
			log.info("SavedQueryPage: Clicked on save option");
			querySave.click();
			log.info("SavedQueryPage: Selected save option");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			log.error("SavedQueryPage: Exception has occurred "+e.getMessage());
		}
	}
	
	public boolean verifySaveQuery(String fieldNAct, String exp) {
		
	
			String actual=driver.findElement(By.xpath("//*[@text='"+prop.getProperty(fieldNAct)+"']//following::android.view.ViewGroup[@index='1']/android.widget.TextView")).getText();
			System.out.println("Actual: "+actual);
			String expected=prop.getProperty(exp);
			System.out.println("Expected: "+expected);
			if(actual.contentEquals(expected)) 
			{
				log.info("SavedQueryPage: Verified saved query");
				return true;
			}else {
				log.error("SavedQueryPage: Error in verifying saved query");
				return false;
			}
	}
	
	public void deleteQuery(String qryN) {
		
		try {
			TestUtil.scrollUpAndDown(qryN);
			driver.findElement(By.xpath("//*[@text='"+prop.getProperty(qryN)+"']//following::android.view.ViewGroup[@index='2']")).click();
			yes.click();
			log.info("SavedQueryPage: Deleted query");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			log.error("SavedQueryPage: Exception has occurred "+e.getMessage());
		}
		
	}
	
	public int veifyDeletedQry(String qryN)
	{
		return driver.findElements(By.xpath("//*[@text='"+prop.getProperty(qryN)+"']")).size();
	
}
	
	public void reset(String field) {
	
		try {
			editBtn.click();
			TestUtil.scrollUpAndDown(field);
			driver.findElement(By.xpath("//*[@text='"+prop.getProperty(field)+"']//following::android.view.ViewGroup[@index='4']")).click();
			log.info("SavedQueryPage: Deleted field");
			addField.click();
			log.info("SavedQueryPage: clicked on add field");
			Thread.sleep(2000);
			TestUtil.scrollUpAndDown(field);
			driver.findElement(By.xpath("//*[@text='"+prop.getProperty(field)+"']")).isDisplayed();
			log.info("SavedQueryPage: Verified the deleted field is added back to the add fields list");
			Thread.sleep(2000);
			addFieldBackBtn.click();
			savedQryScreen.click();
			resetBtn.click();
			log.info("SavedQueryPage: Clicked on reset");
			yes.click();
			log.info("SavedQueryPage: Selected Reset-Yes");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			log.error("SavedQueryPage: Exception has occurred "+e.getMessage());
		}
		
		
		
	}
	
	public boolean verifyReset(String field) {
		
		
		try {
			savedQryScreen.click();
			editBtn.click();
			Thread.sleep(2000);
					
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			log.error("SavedQueryPage: Exception has occurred: "+e.getMessage());
		}
		TestUtil.scrollUpAndDown(field);
		return driver.findElement(By.xpath("//*[@text='"+prop.getProperty(field)+"']")).isDisplayed();
		
	}
}

