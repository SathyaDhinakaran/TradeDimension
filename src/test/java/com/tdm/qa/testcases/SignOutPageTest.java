package com.tdm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
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
		signoutpage.clickOnNo();
		Assert.assertTrue(homepage.verifyNearMeLabel());
		
	}
	@Test(priority=2)
	public void signOutYesOption() {
		homepage.clickOnMoreOption();
		moreoptionpage.clickOnSignOut();
		Assert.assertTrue(signoutpage.verifySignOutPopUp());
		signoutpage.clickOnYes();
		Assert.assertTrue(loginpage.verifySignInScreen());
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
