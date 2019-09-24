package com.tdm.qa.testcases;

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
	notificationspage.clickOnMissingStore();
	Assert.assertTrue(notificationspage.verifyMissingStore());
}


@AfterMethod
public void tearDown() {
	driver.quit();
}

}
