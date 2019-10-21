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

public class HomePageTest extends BaseClass{
	
	LoginPage loginpage;
	HomePage homepage;
	NearMePage nearmepage;
	
	Logger log=LogManager.getLogger(HomePageTest.class);
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginpage=new LoginPage();
		homepage=new HomePage();
		homepage= loginpage.login("username", "password");
		nearmepage=new NearMePage();
	}
	

	
	@Test(priority=1)
	public void verifyHomePage() {
		Assert.assertTrue(homepage.verifyNearMeLabel());
		log.info("HomePageTest: home page is displayed successfully");
	}
	
	@Test(priority=2)
	public void validateGoogleSearch() throws Exception {
		homepage.clickOnGoogleSearch();
		homepage.enterGoogleSearchVal("googleSearchtxt");
		Assert.assertTrue(nearmepage.verifyNearMeShop());
		log.info("HomePageTest: Shops are displayed for Google search");
	}
	
	@Test(priority=3)
	public void validateNielsenSearch()throws Exception{
		homepage.clickOnGoogleSearch();
		homepage.clickOnNielsenIcon();
		homepage.enterNielsenSearch("nielsenSearchTxt");
		Assert.assertTrue(nearmepage.verifyNearMeShop());
		log.info("HomePageTest: Shop is displayed for Nielsen search");
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	

}
