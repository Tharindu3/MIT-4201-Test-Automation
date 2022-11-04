package com.act.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.act.qa.base.TestBase;

public class LoginPage extends TestBase {

	
	@FindBy(xpath = "//input[@name='username']")	
	WebElement userName;
		
	@FindBy(xpath = "//input[@type='password'and @name='pwd']")
	WebElement passWord;
	
	@FindBy(xpath = "//a[@id='loginButton']")
	WebElement loginButton;	
	
	@FindBy(xpath = "//div[@class='atLogoImg']")
	WebElement actiTimeLogo;
	
	
	//Initializing the Page Objects
	public LoginPage() {		
		PageFactory.initElements(driver, this);		
	}
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public Boolean validateActiTimeLogo() {
		return actiTimeLogo.isDisplayed();
		
	}
	
	public HomePage login(String un, String pwd) {
		userName.sendKeys(un);
		passWord.sendKeys(pwd);
		loginButton.click();
		
		return new HomePage();
	}
	
	
	
}

