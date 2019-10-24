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
import com.tdm.qa.pages.OwnDataPage;
import com.tdm.qa.pages.StoreDetailsPage;
import com.tdm.qa.pages.StoreMoreOptPage;

public class OwnDataPageTest extends BaseClass{
	

	LoginPage loginpage;
	HomePage homepage;
	NearMePage nearmepage;
	StoreDetailsPage storedetailspage;
	StoreMoreOptPage storemoreoptpage;
	OwnDataPage owndatapage;
   
	Logger log=LogManager.getLogger(OwnDataPageTest.class);
    
	public OwnDataPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginpage =new LoginPage();
		homepage=new HomePage();
		nearmepage=new NearMePage();
		storedetailspage=new StoreDetailsPage();
		storemoreoptpage=new StoreMoreOptPage();
		owndatapage=new OwnDataPage();
		
		homepage=loginpage.login("username", "password");
		homepage.clickOnGoogleSearch();
		homepage.enterGoogleSearchVal("googleSearchtxt");
		nearmepage.clickOnShops();
		nearmepage.clickOnShortInfo();
		storedetailspage.clickOnMoreOpt();
		storemoreoptpage.clickOnOwnData();
		}
	
	@Test
	public void fillOwnData() throws Exception {
		owndatapage.enterStorePrio("storePrio");
		owndatapage.selectOrderOnli();	
		owndatapage.clickOnCurrentDate("date", "month", "year");
		owndatapage.clickOnSave();
		Assert.assertTrue(owndatapage.verifyOwnData("storePrio"));
		log.info("OwnDataPageTest: Verified own data");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
