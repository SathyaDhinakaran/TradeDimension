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
import com.tdm.qa.pages.SignOutPage;

public class SignOutPageTest extends BaseClass {

	LoginPage loginpage;
	HomePage homepage;
	MoreOptionPage moreoptionpage;
	SignOutPage signoutpage;
	
	Logger log=LogManager.getLogger(SignOutPageTest.class);
	
	public SignOutPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginpage=new LoginPage();
		homepage=new HomePage();
		moreoptionpage=new MoreOptionPage();
		signoutpage=new SignOutPage();
		homepage=loginpage.login("username","password" );
		
	}
	
	@Test(priority=1)
	public void signOutNoOption() {
		homepage.clickOnMoreOption();
		moreoptionpage.clickOnSignOut();
		Assert.assertTrue(signoutpage.verifySignOutPopUp());
		log.info("SignOutPageTest: Signout pop up is getting displayed");
		signoutpage.clickOnNo();
		Assert.assertTrue(homepage.verifyNearMeLabel());
		log.info("SignOutPageTest: App remains in homepage");
		
	}
	@Test(priority=2)
	public void signOutYesOption() {
		homepage.clickOnMoreOption();
		moreoptionpage.clickOnSignOut();
		Assert.assertTrue(signoutpage.verifySignOutPopUp());
		log.info("SignOutPageTest: Signout pop up is getting displayed");
		signoutpage.clickOnYes();
		Assert.assertTrue(loginpage.verifySignInScreen());
		log.info("SignOutPageTest: Logout is successfully");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
