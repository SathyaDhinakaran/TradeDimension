package com.tdm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tdm.qa.base.BaseClass;
import com.tdm.qa.pages.CheckInHistoryPage;
import com.tdm.qa.pages.CheckInPage;
import com.tdm.qa.pages.HomePage;
import com.tdm.qa.pages.LoginPage;
import com.tdm.qa.pages.NearMePage;
import com.tdm.qa.pages.StoreDetailsPage;
import com.tdm.qa.pages.StoreMoreOptPage;

public class CheckInPageTest extends BaseClass {
	
	LoginPage loginpage;
	HomePage homepage;
	StoreDetailsPage storedetailspage;
	CheckInPage checkinpage;
    StoreMoreOptPage storemoreoptpage;
    CheckInHistoryPage checkinhistorypage;
    NearMePage nearmepage;
    
	public CheckInPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginpage =new LoginPage();
		homepage=new HomePage();
		storedetailspage=new StoreDetailsPage();
		checkinpage=new CheckInPage();
		storemoreoptpage=new StoreMoreOptPage();
		checkinhistorypage=new CheckInHistoryPage();
		nearmepage=new NearMePage();
		homepage=loginpage.login("username", "password");
		homepage.clickOnGoogleSearch();
		homepage.enterGoogleSearchVal("googleSearchtxt");
		nearmepage.clickOnShops();
		nearmepage.clickOnShortInfo();
		storedetailspage.clickOnMoreOpt();
		storemoreoptpage.clickOnCheckin();
		}
	
	@Test()
	public void checkInComm(){
		checkinpage.enterComments("checkinComm");
		storedetailspage.clickOnMoreOpt();
		storemoreoptpage.clickOnCheckInHist();
		Assert.assertTrue(checkinhistorypage.verifyCheckIn("checkinComm"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
