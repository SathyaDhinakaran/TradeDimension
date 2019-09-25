package com.tdm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tdm.qa.base.BaseClass;
import com.tdm.qa.pages.HomePage;
import com.tdm.qa.pages.LoginPage;
import com.tdm.qa.pages.NearMePage;
import com.tdm.qa.pages.SavedQueryPage;

public class SavedQueryPageTest extends BaseClass{

	LoginPage loginpage;
	HomePage homepage;
	SavedQueryPage savedquerypage;
	NearMePage nearmepage;
	
	public SavedQueryPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginpage=new LoginPage();
		homepage=new HomePage();
		savedquerypage=new SavedQueryPage();
		nearmepage= new NearMePage();
		homepage=loginpage.login("username", "password");
		savedquerypage=homepage.clickOnSavedQuery();
		
	}
	/*@Test(priority=1)
	public void verifySavedQueryPage() {
	savedquerypage.editQuery("saveQueryName");
		Assert.assertTrue(savedquerypage.verifySavedQueryPage());
	}*/
	
	/*@Test(priority=2)
	public void verifyApplySearch() {
	savedquerypage.editQuery("saveQueryName");
		savedquerypage.applySearch();
		Assert.assertTrue(nearmepage.verifyNearMeShop());
		   
	}*/
	/*
	@Test(priority=3)
	public void editQuery() {
		
		try {
		savedquerypage.editQuery("saveQueryName");
			savedquerypage.clickOnEdit();
			savedquerypage.modifyValue("savedQryAddField","sQOperator","sQVal");	
			savedquerypage.saveAs("saveAsName");
			Thread.sleep(2000);
			homepage.clickOnSavedQuery();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		Assert.assertTrue(savedquerypage.verifySavedQry("saveQueryName"));
	}*/
	
	/*@Test(priority=4, dependsOnMethods="saveQuery")
	public void saveQuery() {
		
		try {
			savedquerypage.editQuery("saveQueryName");
			savedquerypage.clickOnEdit();
			savedquerypage.verifySaveQ("advField4","saveOp");
			savedquerypage.clickOnSave();
			homepage.clickOnSavedQuery();
			savedquerypage.editQuery("saveQueryName");
			savedquerypage.clickOnEdit();
			Assert.assertTrue(savedquerypage.verifySaveQuery("advField4", "saveOp"));
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
	}*/
	
	@Test(priority=6)
	public void deleteQuery() {
		savedquerypage.deleteQuery("saveAsName");
		Assert.assertTrue(savedquerypage.verifyDeleteQry("saveAsName"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
