package com.act.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.act.qa.base.TestBase;
import com.act.qa.pages.HomePage;
import com.act.qa.pages.LoginPage;


public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	Logger log = Logger.getLogger(LoginPageTest.class);
	
	public LoginPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void Setup() {
//		log.info("****************************** Starting test cases execution  *****************************************");
		initialization();		
		loginPage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void loginPageLogoTest() {
//		log.info("****************************** Starting loginPageLogoTest test cases execution  *****************************************");
		boolean flag= loginPage.validateActiTimeLogo();
		Assert.assertTrue(flag);		
	}
	
	@Test(priority = 2)
	public void loginpageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "actiTIME - Login");		
	}
	
	@Test(priority = 3)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));			
		Assert.assertTrue(homePage.validateActiTimeLogo());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	

}
