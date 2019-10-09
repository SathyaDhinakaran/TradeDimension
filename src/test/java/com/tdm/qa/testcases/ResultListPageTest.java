package com.tdm.qa.testcases;

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
		moreoptionpage.clickOnResultList();
		Assert.assertTrue(resultlistpage.verifyResultListPage());
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}


