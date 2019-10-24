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
import com.tdm.qa.pages.NearMePage;
import com.tdm.qa.pages.PrevCheckinPage;
import com.tdm.qa.pages.StoreDetailsPage;
import com.tdm.qa.pages.StoreMoreOptPage;

public class StoreMoreOptPageTest extends BaseClass{
	
	LoginPage loginpage;
	HomePage homepage;
	StoreDetailsPage storedetailspage;
	StoreMoreOptPage storemoreoptpage;
	NearMePage nearmepage;
	PrevCheckinPage prevcheckinpage;
	
	Logger log=LogManager.getLogger(StoreMoreOptPageTest.class);
	
	public StoreMoreOptPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginpage=new LoginPage();
		homepage=new HomePage();
		prevcheckinpage=new PrevCheckinPage();
		storedetailspage=new StoreDetailsPage();
		homepage=loginpage.login("username","password");
		homepage.clickOnPrevCheckin();
		prevcheckinpage.clickOnFirstShop();
			
	}
	
	@Test
	public void clickOnMoreOpt() {
		
			storedetailspage.clickOnMoreOpt();
			Assert.assertTrue(storedetailspage.verifyMoreOpt());
			log.info("StoreMoreOptPageTest: Verified more option in store details page");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
