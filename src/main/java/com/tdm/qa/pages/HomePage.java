package com.tdm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tdm.qa.base.BaseClass;



public class HomePage extends BaseClass {
	
	
	@FindBy(xpath="//android.widget.TextView[@text='Near Me']")
	WebElement nearMe;
	

	@FindBy(xpath="//android.widget.TextView[@text='Previous Checkin']")
	WebElement preCheckin;
	

	@FindBy(xpath="//android.widget.TextView[@text='Saved Queries']")
	WebElement savedQueries;
	
	
	@FindBy(xpath="//android.widget.TextView[@text='Search']//following::android.widget.ImageView")
	WebElement advSearchBtn;

	
	@FindBy(xpath="//android.view.ViewGroup[@instance='14']")
	WebElement googleSearch;
	
	@FindBy(xpath="//*[@text='Search Places..']")
	WebElement googleSearchArea;
	
	@FindBy(xpath="//android.widget.TextView[@instance='0']")
	WebElement pickFirstResult;
	
	@FindBy(xpath="//android.widget.ImageView[@instance=0]")
	WebElement nielsenSearch;
	
	@FindBy(xpath="//*[@text='Enter TDLinx / Address']")
	WebElement nielsenSearchArea;
	
	@FindBy(xpath="//android.view.ViewGroup[@instance='12']")
	WebElement clickSelect;
	
	@FindBy(xpath="//android.widget.TextView[@instance='0']")
	WebElement nielsenPickFirstResult;
	
	@FindBy(xpath="//android.view.ViewGroup[@index='3']")
	WebElement moreOption;
	
	@FindBy(xpath="//android.widget.TextView[@text='Saved Queries']//following::android.widget.ImageView")
	WebElement legendList;
	
	@FindBy(xpath="//*[@class='android.widget.TextView']")
	WebElement legTitle;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyNearMeLabel() {
		return nearMe.isDisplayed();
	}
	
	public boolean verifyPrevCheckinLabel() {
	return preCheckin.isDisplayed();
	}
	
	public boolean verifySavedQueriesLabel() {
		return savedQueries.isDisplayed();
	}	
	
	public NearMePage clickOnNearMe() throws Exception {
			 nearMe.click();
			 Thread.sleep(40000);
			 return new NearMePage();
		}
	
	public PrevCheckinPage clickOnPrevCheckin() throws Exception {
			preCheckin.click();
			Thread.sleep(2000);
			return new PrevCheckinPage();
	}
	
	public SavedQueryPage clickOnSavedQuery() throws Exception {
		savedQueries.click();
		Thread.sleep(2000);
		return new SavedQueryPage();
	}
	
	public AdvSearchPage clickOnAdvSearch() throws Exception {
		advSearchBtn.click();
		Thread.sleep(4000);
		return new AdvSearchPage();
	}
	
	public HomePage clickOnGoogleSearch() {
		googleSearch.click();
		return new HomePage();
	}
	
	public HomePage enterGoogleSearchVal(String val) throws Exception {
		googleSearchArea.sendKeys(prop.getProperty(val));
		Thread.sleep(1000);
		pickFirstResult.click();
		Thread.sleep(20000);
		return new HomePage();
		}
	
	public void clickOnNielsenIcon() {
		nielsenSearch.click();
	}
	
	public HomePage enterNielsenSearch(String nielsenVal) throws Exception {
		nielsenSearchArea.sendKeys(prop.getProperty(nielsenVal));
		Thread.sleep(1000);
		clickSelect.click();
		Thread.sleep(5000);
		nielsenPickFirstResult.click();
		Thread.sleep(10000);
		return new HomePage();
		
	}
	
	
	public MoreOptionPage clickOnMoreOption() {
	 moreOption.click();
	 return new MoreOptionPage();
	}
	
	public void clickOnLegendList() {
		legendList.click();
		
	}
	
	public String getLegHeader() {
		String legHeader=legTitle.getText();
		return legHeader;
	}
	
	
	
	
	}


