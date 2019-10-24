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
import com.tdm.qa.pages.NearMePage;

public class MoreOptionPageTest extends BaseClass {
	
	

	LoginPage loginpage;
	HomePage homepage;
	NearMePage nearmepage;
	MoreOptionPage moreoptionpage;
	
	Logger log=LogManager.getLogger(MoreOptionPageTest.class);
	
	public MoreOptionPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginpage=new LoginPage();
		homepage=new HomePage();
		homepage= loginpage.login("username", "password");
		nearmepage=new NearMePage();
		moreoptionpage=	new MoreOptionPage();
	}
	
	@Test(priority=1)
	public void verifyMoreOptionpopup() {
		homepage.clickOnMoreOption();
		log.info("MoreOptionPageTest: clicked on more option");
		Assert.assertTrue(moreoptionpage.verifyMoreOptionPopUp());
		log.info("MoreOptionPageTest: More option menu is getting displayed");
	}
@AfterMethod
public void tearDown() {
	driver.quit();
}
	
	
}
