package com.tdm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tdm.qa.util.TestUtil;
import com.tdm.qa.base.BaseClass;

public class LoginPage extends BaseClass{
	
	@FindBy(xpath="//*[@class='android.widget.EditText'and @password='false']")
	@CacheLookup
	WebElement username;
	
	@FindBy(xpath="//*[@class='android.widget.EditText'and @password='true']")
	@CacheLookup
	WebElement password;
	
	
	@FindBy(xpath="//*[@class='android.widget.ImageView']")
	WebElement clickOutside;
	
		
	@FindBy(xpath="//*[@text='Sign in']")
	WebElement loginBtn;
	
    @FindBy(xpath="//*[@text='Sign in']//following::android.widget.TextView")
	WebElement loginUnsuccessful;
	
		
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifySignInScreen() {
	return 	loginBtn.isDisplayed();
	}
	
	public HomePage login(String un, String pswd) throws Exception {
		
		 String expected = prop.getProperty(un);
		 System.out.println(expected);

		username.sendKeys(prop.getProperty(un));
	    String name=username.getText();
	   System.out.println(name);
	 	
	if(!name.contentEquals(expected)) {
		username.sendKeys(prop.getProperty(un));
	}
		
		password.sendKeys(prop.getProperty(pswd));
		clickOutside.click();
		loginBtn.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Near Me']")));
		return new HomePage();
	}
	

}
