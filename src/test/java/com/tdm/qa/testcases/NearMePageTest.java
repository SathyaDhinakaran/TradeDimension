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

public class NearMePageTest extends BaseClass {
	
	LoginPage loginpage;
	HomePage homepage;
	NearMePage nearmepage;
	
	Logger log=LogManager.getLogger(NearMePageTest.class);
	
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
		log.info("NearMePageTest: Verified near me");
		nearmepage.clickOnShops();
		Assert.assertTrue(nearmepage.verifyShortInfo());
		log.info("NearMePageTest: Verified short info");
		nearmepage.clickOnNavigator();
		Assert.assertTrue(nearmepage.verifyGoogleMap());
		log.info("NearMePageTest: Verified google navigation");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
