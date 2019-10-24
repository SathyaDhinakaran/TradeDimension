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

public class SettingsPageTest extends BaseClass {
	
	LoginPage loginpage;
	HomePage homepage;
	MoreOptionPage moreoptionpage;
	SettingsPage settingspage;
	SelectFieldPage selectfieldpage;
	
	Logger log=LogManager.getLogger(SettingsPageTest.class);
	
	public SettingsPageTest() {
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
		
	}
		
	@Test(priority=1)
    public void resetLegend() throws Exception {
		settingspage.goToSelectFields();
		selectfieldpage.selectField("setLegendField");
		selectfieldpage.clickOnBackBtn();
		settingspage.clickOnReset();
		Assert.assertTrue(settingspage.afterReset());
		log.info("SettingsPage: Reset is successful");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
