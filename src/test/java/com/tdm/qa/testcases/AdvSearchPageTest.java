package com.tdm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tdm.qa.base.BaseClass;
import com.tdm.qa.pages.AdvSearchPage;
import com.tdm.qa.pages.HomePage;
import com.tdm.qa.pages.LoginPage;
import com.tdm.qa.pages.NearMePage;
import com.tdm.qa.pages.SavedQueryPage;
import com.tdm.qa.util.TestUtil;

public class AdvSearchPageTest extends BaseClass{
	LoginPage loginpage;
	HomePage homepage;
	AdvSearchPage advsearchpage;
	NearMePage nearmepage;
	SavedQueryPage savedquerypage;
	
	public AdvSearchPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginpage=new LoginPage();
		homepage=new HomePage();
		advsearchpage=new AdvSearchPage();
		nearmepage=new NearMePage();
		savedquerypage=new SavedQueryPage();
		homepage=loginpage.login("username","password");
		advsearchpage=homepage.clickOnAdvSearch();
		advsearchpage.clickOnAddFields();
		
		TestUtil.scrollUpAndDownWithClick("advField1");
		TestUtil.scrollUpAndDownWithClick("advField2");
		TestUtil.scrollUpAndDownWithClick("advField4");
		TestUtil.scrollUpAndDownWithClick("advField3");
		TestUtil.scrollUpAndDownWithClick("advField5");
		
		advsearchpage.saveSelectedField();
		
		advsearchpage.selectOperator("advField1", "opString", "field1Val", null, null, null);
		advsearchpage.selectOperator("advField5","opInt","field5Val", null, null, null);
		advsearchpage.selectOperator("advField4","opPicker","field4Val", null, null, null);
		advsearchpage.selectOperator("advField3","opDate",null,"field3ValMon", "field3ValDate", "year");
		advsearchpage.selectOperator("advField2", "opBoolean", null, null, null, null);
		

	}
	
	@Test(priority=1)
	public void saveQuery() throws Exception {
		
		advsearchpage.saveQuery("saveQueryName");
		homepage.clickOnSavedQuery();
		Assert.assertTrue(savedquerypage.verifySavedQry("saveQueryName"));
		
	}
		
	
	@Test(priority=2)
	public void applySearch() {
				
			advsearchpage.applySearch();
			
			Assert.assertTrue(nearmepage.verifyNearMeShop());
		}
	
	
	@Test(priority=3)

	public void resetQuery() {
		advsearchpage.clickOnReset();
		Assert.assertTrue(advsearchpage.validateReset("advField5"));
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
