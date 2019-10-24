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
import com.tdm.qa.pages.NotificationsPage;

public class NotificationsPageTest extends BaseClass{
	
	LoginPage loginpage;
	HomePage homepage;
	MoreOptionPage moreoptionpage;
	NotificationsPage notificationspage;
	
	Logger log=LogManager.getLogger(NotificationsPageTest.class);
	
	public NotificationsPageTest() {
		super();
	}
@BeforeMethod
public void setUp() throws Exception {
initialization();
loginpage =new LoginPage();
homepage=new HomePage();
moreoptionpage=new MoreOptionPage();
notificationspage=new NotificationsPage();
homepage=loginpage.login("username", "password");
homepage.clickOnMoreOption();
moreoptionpage.clickOnNotifications();
}

@Test(priority=1)
public void missingStore() {
	Assert.assertTrue(notificationspage.verifyNotifiScreen());
	log.info("NotificationsPageTest: Verified history by user page is getting displayed");
	notificationspage.clickOnMissingStore();
	Assert.assertTrue(notificationspage.verifyMissingStore());
	log.info("NotificationsPageTest: Missing store notification page is getting displayed");
}


@AfterMethod
public void tearDown() {
	driver.quit();
}

}
