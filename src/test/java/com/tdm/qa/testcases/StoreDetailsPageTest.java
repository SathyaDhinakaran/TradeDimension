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
import com.tdm.qa.pages.PrevCheckinPage;
import com.tdm.qa.pages.StoreDetailsPage;

public class StoreDetailsPageTest extends BaseClass{
	 
	LoginPage loginpage;
	HomePage homepage;
	MoreOptionPage moreoptionpage;
	PrevCheckinPage prevcheckinpage;
	StoreDetailsPage storedetailspage;
	
	Logger log=LogManager.getLogger(StoreDetailsPageTest.class);
	
	public StoreDetailsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginpage=new LoginPage();
		homepage=new HomePage();
		moreoptionpage=new MoreOptionPage();
		prevcheckinpage=new PrevCheckinPage();
		storedetailspage=new StoreDetailsPage();
		homepage=loginpage.login("username","password");
		homepage.clickOnPrevCheckin();
		prevcheckinpage.clickOnFirstShop();
	}
	
	@Test(priority=1)
	public void verifyStoreHierarchy() {
		storedetailspage.clickOnHierarchy();
		Assert.assertTrue(storedetailspage.verifyHierarchyPage());
		log.info("StoreDetailsPageTest: Verified store hierarchy");
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
