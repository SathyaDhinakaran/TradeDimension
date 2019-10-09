package com.tdm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tdm.qa.base.BaseClass;
import com.tdm.qa.pages.HomePage;
import com.tdm.qa.pages.LoginPage;
import com.tdm.qa.pages.NearMePage;
import com.tdm.qa.pages.PrevCheckinPage;

public class PrevCheckinPageTest extends BaseClass{
	
	LoginPage loginpage;
	HomePage homepage;
	NearMePage nearmepage;
	PrevCheckinPage prevcheckinpage;
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginpage=new LoginPage();
		homepage=new HomePage();
		prevcheckinpage =new PrevCheckinPage();
		homepage= loginpage.login("username", "password");
		}
	
	@Test(priority=1)
	public void validatePrevCheckin() throws Exception {
		homepage.clickOnPrevCheckin();
		Assert.assertTrue(prevcheckinpage.verifyCheckInHistory());
		Assert.assertTrue(prevcheckinpage.verifyCheckin());
		prevcheckinpage.clickOnFirstShop();
		Assert.assertTrue(prevcheckinpage.verifyHierarchyIcon());
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
