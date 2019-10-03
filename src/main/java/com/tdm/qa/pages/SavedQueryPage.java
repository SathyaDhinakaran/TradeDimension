package com.tdm.qa.pages;

import static org.testng.Assert.assertNull;

import java.util.NoSuchElementException;

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
	
	public SavedQueryPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifySavedQueryPage() {
		return viewQuery.isDisplayed();
	}

	public boolean verifySavedQry(String qryName) {
		
		
		TestUtil.scrollUpAndDown(qryName);
		return driver.findElement(By.xpath("//*[@text='"+prop.getProperty(qryName)+"']")).isDisplayed();
		//return driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+prop.getProperty(qryName)+"\").instance(0))").isDisplayed();
		   
	}
	
	public void editQuery(String queryN) {
			try {
				
				TestUtil.scrollUpAndDownWithClick(queryN);
				//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+prop.getProperty(queryN)+"\").instance(0))").click();
				
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
	}
	
	public void applySearch() {
		try {
			
			applySearch.click();
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
}

	public void clickOnEdit() {
		
		try {
			editBtn.click();
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void modifyValue(String addFieldN, String op, String val) {
		
		try {
			addField.click();
			Thread.sleep(2000);
			TestUtil.scrollUpAndDownWithClick(addFieldN);
			//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+prop.getProperty(addFieldN)+"\").instance(0))").click();
			saveField.click(); 
			TestUtil.scrollUpAndDown(addFieldN);
			//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+prop.getProperty(addFieldN)+"\").instance(0))");
			driver.findElement(By.xpath("//*[@text='"+prop.getProperty(addFieldN)+"']//following::android.view.ViewGroup[@index='2']")).click();
			driver.findElement(By.xpath("//*[@text='"+prop.getProperty(op)+"']")).click();
			selOper.click();
			Thread.sleep(2000);
			
		driver.findElement(By.xpath("//*[@text='"+prop.getProperty(addFieldN)+"']//following::android.view.ViewGroup[@index='3']")).click();
		Thread.sleep(2000);
		addValBackBtn.click();
		driver.findElement(By.xpath("//*[@text='"+prop.getProperty(addFieldN)+"']//following::android.view.ViewGroup[@index='3']")).click();
		Thread.sleep(2000);
		searchtxt.click();
		searchtxt.sendKeys(prop.getProperty(val));
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+prop.getProperty(val)+"']")).click();
		saveValues.click();
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		  
		
	}
	
	public void saveAs(String saveQryN) {
		try {
			Thread.sleep(2000);
			savedQryScreen.click();
			saveBtn.click();
			saveAs.click();
			enterQueryN.click();
			enterQueryN.sendKeys(prop.getProperty(saveQryN));
			driver.findElement(By.xpath("//*[@text='"+prop.getProperty(saveQryN)+"']//following::android.widget.ImageView")).click();
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void verifySaveQ(String fieldN, String op) {
		
		try {
			
			TestUtil.scrollUpAndDown(fieldN);
			//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+prop.getProperty(fieldN)+"\").instance(0))");
			driver.findElement(By.xpath("//*[@text='"+prop.getProperty(fieldN)+"']//following::android.view.ViewGroup[@index='2']")).click();
			driver.findElement(By.xpath("//*[@text='"+prop.getProperty(op)+"']")).click();
			selOper.click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void clickOnSave() {
		
		try {
			savedQryScreen.click();
			saveBtn.click();
			querySave.click();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	public boolean verifySaveQuery(String fieldNAct, String exp) {
		
	
			String actual=driver.findElement(By.xpath("//*[@text='"+prop.getProperty(fieldNAct)+"']//following::android.view.ViewGroup[@index='1']/android.widget.TextView")).getText();
			System.out.println("Actual: "+actual);
			String expected=prop.getProperty(exp);
			System.out.println("Expected: "+expected);
			if(actual.contentEquals(expected)) 
				return true;
			else 
				return false;
				
	}
	
	public void deleteQuery(String qryN) {
		
		try {
			TestUtil.scrollUpAndDown(qryN);
			//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+prop.getProperty(qryN)+"\").instance(0))");
			driver.findElement(By.xpath("//*[@text='"+prop.getProperty(qryN)+"']//following::android.view.ViewGroup[@index='2']")).click();
			yes.click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
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
			//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+prop.getProperty(field)+"\").instance(0))");
			driver.findElement(By.xpath("//*[@text='"+prop.getProperty(field)+"']//following::android.view.ViewGroup[@index='4']")).click();
			addField.click();
			Thread.sleep(2000);
			TestUtil.scrollUpAndDown(field);
			driver.findElement(By.xpath("//*[@text='"+prop.getProperty(field)+"']")).isDisplayed();
			//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+prop.getProperty(field)+"\").instance(0))").isDisplayed();
			
			Thread.sleep(2000);
			addFieldBackBtn.click();
			savedQryScreen.click();
			resetBtn.click();
			yes.click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public boolean verifyReset(String field) {
		
		
		try {
			savedQryScreen.click();
			editBtn.click();
			Thread.sleep(2000);
			TestUtil.scrollUpAndDown(field);
			
			//return driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+prop.getProperty(field)+"\").instance(0))").isDisplayed();
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		return driver.findElement(By.xpath("//*[text='"+prop.getProperty(field)+"']")).isDisplayed();
	}
}

