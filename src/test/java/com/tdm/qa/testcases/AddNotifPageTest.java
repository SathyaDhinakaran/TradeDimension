package com.tdm.qa.testcases;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tdm.qa.base.BaseClass;
import com.tdm.qa.pages.AddNotifPage;
import com.tdm.qa.pages.AdvSearchPage;
import com.tdm.qa.pages.HomePage;
import com.tdm.qa.pages.LoginPage;
import com.tdm.qa.pages.NearMePage;
import com.tdm.qa.pages.StoreDetailsPage;
import com.tdm.qa.pages.StoreMoreOptPage;
import com.tdm.qa.util.TestUtil;

public class AddNotifPageTest extends BaseClass{
	LoginPage loginpage;
	HomePage homepage;
	NearMePage nearmepage;
	StoreDetailsPage storedetailspage;
	StoreMoreOptPage storemoreoptpage;
	AddNotifPage addnotifpage;
	AdvSearchPage advsearchpage ;
	
	Logger log=LogManager.getLogger(AddNotifPageTest.class);	
	
	
public AddNotifPageTest() {
	super();
}


@BeforeMethod
public void setUp() throws Exception {
	initialization();
	loginpage=new LoginPage();
	homepage=new HomePage();
	nearmepage=new NearMePage();
	storedetailspage=new StoreDetailsPage();
	storemoreoptpage=new StoreMoreOptPage();
	homepage=loginpage.login("username", "password");
	homepage.clickOnNearMe();
	nearmepage.clickOnShops();
	nearmepage.clickOnShortInfo();
	storedetailspage.clickOnMoreOpt();
	storemoreoptpage.clickOnAddNotif();
	addnotifpage=new AddNotifPage();
	advsearchpage=new AdvSearchPage();
}


@Test
public void addNotification() throws Exception {
	
	log.info("AddNotifPageTest: Inside add notification block");
	addnotifpage.clickOnShopNameEdit("addNotiShopName","addNotiComm");
	TestUtil.scrollUpAndDownWithClick("addNotiAddField");
	advsearchpage.saveSelectedField();
	addnotifpage.scrollTillElem("addNotiAddField");
	addnotifpage.enterVal("addNotiAddField", "addNotiFieldVal");
	TestUtil.scrollUpAndDownWithClick("shopN");
	addnotifpage.save();
	log.info("AddNotifPageTest: Notification is saved");
	storedetailspage.clickOnMoreOpt();
	Assert.assertTrue(storemoreoptpage.verifyNotif("addNotiComm"));
	log.info("AddNotifPageTest: Verified added notification");
}

@AfterMethod
public void tearDown() {
	driver.quit();
}



}
