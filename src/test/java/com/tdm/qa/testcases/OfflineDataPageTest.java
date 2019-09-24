package com.tdm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tdm.qa.base.BaseClass;
import com.tdm.qa.pages.HomePage;
import com.tdm.qa.pages.LoginPage;
import com.tdm.qa.pages.MoreOptionPage;
import com.tdm.qa.pages.OfflineDataPage;

public class OfflineDataPageTest extends BaseClass {
	LoginPage loginpage;
	HomePage homepage;
	MoreOptionPage moreoptionpage;
	OfflineDataPage offlinedatapage;
	
	public OfflineDataPageTest() {
		super();
	}

	@BeforeTest
	public void setUp() throws Exception {
		initialization();
		loginpage=new LoginPage();
		homepage=new HomePage();
		moreoptionpage=new MoreOptionPage();
		offlinedatapage=new OfflineDataPage();
		homepage=loginpage.login("username", "password");
	}
	
	@Test(priority=1)
	public void verifyOfflineDataPage(){
		homepage.clickOnMoreOption();
		moreoptionpage.clickOnOfflineData();
		Assert.assertTrue(offlinedatapage.verifyOfflineDataPage());
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
