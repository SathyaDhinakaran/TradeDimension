package com.tdm.qa.testcases;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tdm.qa.base.BaseClass;
import com.tdm.qa.pages.HomePage;
import com.tdm.qa.pages.LoginPage;
import com.tdm.qa.pages.MoreOptionPage;
import com.tdm.qa.pages.SelectFieldPage;
import com.tdm.qa.pages.SettingsPage;

public class SelectFieldPageTest extends BaseClass{
	

	LoginPage loginpage;
	HomePage homepage;
	MoreOptionPage moreoptionpage;
	SettingsPage settingspage;
	SelectFieldPage selectfieldpage;
	
	Logger log=LogManager.getLogger(SelectFieldPageTest.class);
	
	public SelectFieldPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginpage=new LoginPage();
		homepage=new HomePage();
		moreoptionpage=new MoreOptionPage();
		settingspage=new SettingsPage();
		selectfieldpage=new SelectFieldPage();
		homepage=loginpage.login("username","password" );
		homepage.clickOnMoreOption();
		moreoptionpage.clickOnSettings();
		settingspage.goToSelectFields();
		
		
	}
	
	@Test(priority=1)
	public void setLegendAndSettingsPage() throws Exception {
		selectfieldpage.selectField("setLegendField");
		selectfieldpage.clickOnBackBtn();
		Assert.assertTrue(moreoptionpage.verifySettingsPage());
		log.info("SelectFieldPageTest: Verified set legend field");
	
	}

	@Test(priority=2)
	public void selectFieldAndHomePage() throws Exception {
		selectfieldpage.selectField("setLegendField");
		selectfieldpage.clickOnMapBtn();
		Thread.sleep(2000);
		homepage.clickOnNearMe();
		homepage.clickOnLegendList();
		Thread.sleep(2000);
		Assert.assertEquals(homepage.getLegHeader(),prop.getProperty("setLegendField") );
		log.info("SelectFieldPage: Verified set legend is getting displayed in homepage");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
