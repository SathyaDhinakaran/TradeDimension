package com.tdm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tdm.qa.base.BaseClass;
import com.tdm.qa.pages.AddNotifPage;
import com.tdm.qa.pages.HomePage;
import com.tdm.qa.pages.LoginPage;
import com.tdm.qa.pages.NearMePage;
import com.tdm.qa.pages.StoreDetailsPage;
import com.tdm.qa.pages.StoreMoreOptPage;

public class AddNotifPageTest extends BaseClass{
	LoginPage loginpage;
	HomePage homepage;
	NearMePage nearmepage;
	StoreDetailsPage storedetailspage;
	StoreMoreOptPage storemoreoptpage;
	AddNotifPage addnotifpage;
	
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
}




@Test
public void addNotification() throws Exception {
	addnotifpage.clickOnShopNameEdit("addNotiShopName","addNotiComm","addNotiAddField");
	addnotifpage.scrollTillElem("addNotiAddField");
	addnotifpage.enterVal("addNotiAddField", "addNotiFieldVal");
	storedetailspage.clickOnMoreOpt();
	Assert.assertTrue(storemoreoptpage.verifyNotif("addNotiComm"));
	
}

@AfterMethod
public void tearDown() {
	driver.quit();
}



}
