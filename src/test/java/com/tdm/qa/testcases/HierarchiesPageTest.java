package com.tdm.qa.testcases;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.tdm.qa.base.BaseClass;
import com.tdm.qa.pages.HierarchiesPage;
import com.tdm.qa.pages.HomePage;
import com.tdm.qa.pages.LoginPage;
import com.tdm.qa.pages.MoreOptionPage;
import com.tdm.qa.pages.NearMePage;

public class HierarchiesPageTest extends BaseClass{
	LoginPage loginpage;
	HomePage homepage;
	MoreOptionPage moreoptionpage;
	HierarchiesPage hierarchiespage;
	NearMePage nearmepage;
	
	Logger log=LogManager.getLogger(HierarchiesPageTest.class);	
	
	public HierarchiesPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginpage=new LoginPage();
		homepage=new HomePage();
		moreoptionpage=new MoreOptionPage();
		hierarchiespage=new HierarchiesPage();
		nearmepage=new NearMePage();
		homepage=loginpage.login("username", "password");
		homepage.clickOnMoreOption();
		moreoptionpage.clickOnHierarchies();
	}

	
	
	@Test(priority=1)
	public void selectStoreAcc() {
		Assert.assertTrue(hierarchiespage.verifyHierarchyScreen());
		log.info("HierarchiesPageTest: Hierarchy screen is loaded successfully");
		hierarchiespage.clickOnExpand();
		log.info("HierarchiesPageTest: Account is expanded successfully");
		hierarchiespage.selectCheckbox();
		log.info("HierarchiesPageTest: Nodes are selected");
		hierarchiespage.clickOnContiWith();
		log.info("HierarchiesPageTest: Clicked on continue with");
		hierarchiespage.clickOnStore();
		log.info("HierarchiesPageTest: Selected store");
		Assert.assertTrue(nearmepage.verifyNearMeShop());
		log.info("HierarchiesPageTest: Stores are displaying successfully");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
