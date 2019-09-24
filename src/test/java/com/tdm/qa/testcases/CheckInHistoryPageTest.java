package com.tdm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tdm.qa.base.BaseClass;
import com.tdm.qa.pages.CheckInHistoryPage;
import com.tdm.qa.pages.HomePage;
import com.tdm.qa.pages.LoginPage;
import com.tdm.qa.pages.NearMePage;
import com.tdm.qa.pages.PrevCheckinPage;
import com.tdm.qa.pages.StoreDetailsPage;
import com.tdm.qa.pages.StoreMoreOptPage;

public class CheckInHistoryPageTest extends BaseClass {
	LoginPage loginpage;
	HomePage homepage;
	PrevCheckinPage prevcheckinpage;
	StoreDetailsPage storedetailspage;
	StoreMoreOptPage storemoreoptpage;
    CheckInHistoryPage checkinhistorypage;
    NearMePage nearmepage;
    
	public CheckInHistoryPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginpage =new LoginPage();
		homepage=new HomePage();
		prevcheckinpage=new PrevCheckinPage();
		storedetailspage=new StoreDetailsPage();
		storemoreoptpage=new StoreMoreOptPage();
		checkinhistorypage=new CheckInHistoryPage();
		nearmepage=new NearMePage();
		homepage=loginpage.login("username", "password");
		homepage.clickOnGoogleSearch();
		homepage.enterGoogleSearchVal("googleSearchtxt");
		nearmepage.clickOnShops();
		nearmepage.clickOnShortInfo();
		storedetailspage.clickOnMoreOpt();
		storemoreoptpage.clickOnCheckInHist();
		}
	
	@Test
	public void verifyCheckInHist() {
		Assert.assertTrue(checkinhistorypage.verifyCheckInHis());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
