package com.tdm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tdm.qa.base.BaseClass;
import com.tdm.qa.pages.HomePage;
import com.tdm.qa.pages.LoginPage;
import com.tdm.qa.pages.NearMePage;

public class NearMePageTest extends BaseClass {
	
	LoginPage loginpage;
	HomePage homepage;
	NearMePage nearmepage;
	
	public NearMePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginpage=new LoginPage();
		homepage=new HomePage();
		nearmepage=new NearMePage();
		homepage=loginpage.login("username", "password");
		
	}

		
	@Test(priority=1)
	public void validateNavigationOption() throws Exception {
		nearmepage=	homepage.clickOnNearMe();
		Assert.assertTrue(nearmepage.verifyNearMeShop());
		nearmepage.clickOnShops();
		Assert.assertTrue(nearmepage.verifyShortInfo());
		nearmepage.clickOnNavigator();
		Assert.assertTrue(nearmepage.verifyGoogleMap());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
