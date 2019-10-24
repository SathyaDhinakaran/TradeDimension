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

public class ResultListPageTest extends BaseClass {
	
	
	LoginPage loginpage;
	HomePage homepage;
	MoreOptionPage moreoptionpage;
	ResultListPage resultlistpage;
	OfflineDataPage offlinedatapage;
	
	Logger log=LogManager.getLogger(ResultListPageTest.class);
	
	public ResultListPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() throws Exception {
		initialization();
		loginpage=new LoginPage();
		homepage=new HomePage();
		moreoptionpage=new MoreOptionPage();
		resultlistpage=new ResultListPage();
		offlinedatapage=new OfflineDataPage();
		homepage=loginpage.login("username", "password");
	}
	
	@Test(priority=1)
	public void verifyResultList() {
		homepage.clickOnMoreOption();
		log.info("ResultListPageTest: clicked on more option in homepage");
		moreoptionpage.clickOnResultList();
		log.info("ResultListPageTest: clicked on result list ");
		Assert.assertTrue(resultlistpage.verifyResultListPage());
		log.info("ResultListPageTest: Result list page is displayed successfully");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}


