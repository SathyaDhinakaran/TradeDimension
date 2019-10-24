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
import com.tdm.qa.pages.OfflineDataPage;
import com.tdm.qa.pages.ResultListPage;

public class OfflineDataPageTest extends BaseClass {
	LoginPage loginpage;
	HomePage homepage;
	MoreOptionPage moreoptionpage;
	OfflineDataPage offlinedatapage;
    ResultListPage resultlistpage;
    
    Logger log=LogManager.getLogger(OfflineDataPageTest.class);
	
	
	public OfflineDataPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginpage=new LoginPage();
		homepage=new HomePage();
		moreoptionpage=new MoreOptionPage();
		offlinedatapage=new OfflineDataPage();
		resultlistpage=new ResultListPage();
		homepage=loginpage.login("username", "password");
	}
	
	@Test(priority=1)
	public void downloadOfflineData() throws Exception {
		homepage.clickOnGoogleSearch();
		homepage.enterGoogleSearchVal("googleSearchtxt");
		Thread.sleep(5000);
		homepage.clickOnMoreOption();
		moreoptionpage.clickOnResultList();
		Thread.sleep(2000);
		resultlistpage.clickOnDownload("downloadName");
		Thread.sleep(2000);
		resultlistpage.clickOnMap();	
		homepage.clickOnMoreOption();
		moreoptionpage.clickOnOfflineData();
	    Assert.assertTrue(offlinedatapage.verifyDownloadedData("downloadName"));	
	    log.info("OfflineDataPageTest: Verified offline data");
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
