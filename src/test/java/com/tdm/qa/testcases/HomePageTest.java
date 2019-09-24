package com.tdm.qa.testcases;

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
	}
	
	@Test(priority=2)
	public void validateGoogleSearch() throws Exception {
		homepage.clickOnGoogleSearch();
		homepage.enterGoogleSearchVal("googleSearchtxt");
		Assert.assertTrue(nearmepage.verifyNearMeShop());
	}
	
	@Test(priority=3)
	public void validateNielsenSearch()throws Exception{
		homepage.clickOnGoogleSearch();
		homepage.clickOnNielsenIcon();
		homepage.enterNielsenSearch("nielsenSearchTxt");
		Assert.assertTrue(nearmepage.verifyNearMeShop());
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	

}
