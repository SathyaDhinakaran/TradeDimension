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
import com.tdm.qa.pages.MissingStorePage;
import com.tdm.qa.pages.MoreOptionPage;
import com.tdm.qa.pages.NotificationsPage;

public class MissingStorePageTest extends BaseClass{
	LoginPage loginpage;
	HomePage homepage;
	MoreOptionPage moreoptionpage;
	NotificationsPage notificationspage;
	MissingStorePage missingstorepage;
	
	Logger log=LogManager.getLogger(MissingStorePageTest.class);
	
	public MissingStorePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginpage=new LoginPage();
		homepage=new HomePage();
		moreoptionpage=new MoreOptionPage();
		notificationspage=new NotificationsPage();
		missingstorepage=new MissingStorePage();
		homepage=loginpage.login("username", "password");
		homepage.clickOnMoreOption();
		moreoptionpage.clickOnNotifications();
		notificationspage.clickOnMissingStore();
	}
	
	
	@Test
	public void enterMissigStoreDetails() {
		missingstorepage.enterShopDetails("shopName", "streetName", "city", "outletType", "missingStoreComm", "addField", "CorrValue");
		log.info("MissingStorePageTest: Created missing store");
		Assert.assertTrue(missingstorepage.VerifyMissingStoreN("shopName"));
		log.info("MissingStorePageTest: verified missing store");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}

}
