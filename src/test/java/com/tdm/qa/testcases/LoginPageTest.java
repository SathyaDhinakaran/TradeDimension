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

public class LoginPageTest extends BaseClass {
	

	LoginPage loginpage;
	HomePage homepage;
	
    Logger log=LogManager.getLogger(LoginPageTest.class);

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage=new HomePage();
	}

	@Test
	public void loginTest() throws Exception 
	{
		homepage= loginpage.login("username", "password");
		Assert.assertTrue(homepage.verifyNearMeLabel());
		log.info("LoginPageTest: Login is successful");

	}



	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}


}
