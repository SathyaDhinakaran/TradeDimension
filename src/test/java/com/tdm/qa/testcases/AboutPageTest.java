package com.tdm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tdm.qa.base.BaseClass;
import com.tdm.qa.pages.AboutPage;
import com.tdm.qa.pages.HomePage;
import com.tdm.qa.pages.LoginPage;
import com.tdm.qa.pages.MoreOptionPage;

public class AboutPageTest extends BaseClass {
	
	LoginPage loginpage;
	HomePage homepage;
	MoreOptionPage moreoptionpage;
	AboutPage aboutpage;
	
	public AboutPageTest() {
		super();
	}

	@BeforeTest
	public void setUp() throws Exception {
		initialization();
		loginpage=new LoginPage();
		homepage=new HomePage();
		moreoptionpage=new MoreOptionPage();
		aboutpage=new AboutPage();
		homepage=loginpage.login("username", "password");
		homepage.clickOnMoreOption();
		moreoptionpage.clickOnAboutPage();
	}
	
	@Test
	public void validateAboutPage() {
		Assert.assertTrue(aboutpage.verifyPrivacyNote());
		Assert.assertTrue(aboutpage.verifyUserManual());
		Assert.assertTrue(aboutpage.verifyImpressum());
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}