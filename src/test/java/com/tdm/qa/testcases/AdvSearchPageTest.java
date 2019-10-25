package com.tdm.qa.testcases;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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
	
	Logger log=LogManager.getLogger(AdvSearchPageTest.class);
	
	public AdvSearchPageTest() {
		super();
	}

	@BeforeMethod(alwaysRun = true)
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
		
		log.info("AdvSearchPageTest: All the fields are selected");
		
		advsearchpage.saveSelectedField();
		log.info("AdvSearchPageTest: Selected fields are saved");
		
		advsearchpage.selectOperator("advField1", "opString", "field1Val", null, null, null);
		advsearchpage.selectOperator("advField5","opInt","field5Val", null, null, null);
		advsearchpage.selectOperator("advField4","opPicker","field4Val", null, null, null);
		advsearchpage.selectOperator("advField3","opDate",null,"field3ValMon", "field3ValDate", "year");
		advsearchpage.selectOperator("advField2", "opBoolean", null, null, null, null);
		
		log.info("AdvSearchPageTest: All the Operator and its value are added");

	}
	
	@Test(priority=1)
	public void saveQuery() throws Exception {
		
		advsearchpage.saveQuery("saveQueryName");
		homepage.clickOnSavedQuery();
		Assert.assertTrue(savedquerypage.verifySavedQry("saveQueryName"));
		log.info("AdvSearchPageTest: Verified the saved query");
		
	}
		
	
	@Test(priority=2)
	public void applySearch() {
				
			advsearchpage.applySearch();
			log.info("AdvSearchPageTest: Clicked on apply search");
			Assert.assertTrue(nearmepage.verifyNearMeShop());
			log.info("AdvSearchPageTest: Shops are displayed");
		}
	
	
	@Test(priority=3)

	public void resetQuery() {
		advsearchpage.clickOnReset();
		Assert.assertTrue(advsearchpage.validateReset("advField5"));
		log.info("AdvSearchPageTest: Verified Reset");
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
