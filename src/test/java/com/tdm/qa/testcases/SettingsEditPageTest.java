package com.tdm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tdm.qa.base.BaseClass;
import com.tdm.qa.pages.HomePage;
import com.tdm.qa.pages.LoginPage;
import com.tdm.qa.pages.MoreOptionPage;
import com.tdm.qa.pages.SelectFieldPage;
import com.tdm.qa.pages.SettingsEditPage;
import com.tdm.qa.pages.SettingsPage;

public class SettingsEditPageTest extends BaseClass {
	

	LoginPage loginpage;
	HomePage homepage;
	MoreOptionPage moreoptionpage;
	SettingsPage settingspage;
	SelectFieldPage selectfieldpage;
	SettingsEditPage settingseditpage;
	
	public SettingsEditPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginpage=new LoginPage();
		homepage=new HomePage();
		moreoptionpage=new MoreOptionPage();
		settingspage=new SettingsPage();
		selectfieldpage=new SelectFieldPage();
		settingseditpage = new SettingsEditPage();
		homepage=loginpage.login("username","password" );
		homepage.clickOnMoreOption();
		moreoptionpage.clickOnSettings();
		settingspage.goToSelectFields();
		selectfieldpage.selectField("setLegendField");
		selectfieldpage.clickOnBackBtn();
		settingspage.clickOnEdit();
	}
	
/*	@Test(priority=1)
	public void assignIcon() {
		settingseditpage.setIcon("corresFieldValue1");
		settingseditpage.toSetGreenIcon();
		
		settingseditpage.setIcon("corresFieldValue2");
		settingseditpage.toSetRedIcon();
		
		settingseditpage.clickOnSave();
		Assert.assertTrue(moreoptionpage.verifySettingsPage());
			
	}*/
	
	@Test(priority=2)
	
	public void selectReset() {
		settingseditpage.clickOnReset();
		Assert.assertTrue(moreoptionpage.verifySettingsPage());
	}
	
	
@AfterTest
public void tearDown() {
	driver.quit();
}
}
