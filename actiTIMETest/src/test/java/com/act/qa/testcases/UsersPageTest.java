package com.act.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.act.qa.base.TestBase;
import com.act.qa.pages.HomePage;
import com.act.qa.pages.LoginPage;
import com.act.qa.pages.ReportsPage;
import com.act.qa.pages.UsersPage;
import com.act.qa.util.TestUtil;

public class UsersPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ReportsPage reportsPage;
	UsersPage usersPage;
	TestUtil testUtil;
	
	public UsersPageTest() {
		super();
	}
	
	@BeforeMethod
	public void Setup() {
		initialization();		
		loginPage = new LoginPage();
		usersPage = new UsersPage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		usersPage = homePage.clickOnUsersLink();
		
	}
		
	@Test(priority = 1)
	public void validateUsersPageTitleTest() {

		String usersPageTitle = usersPage.validateUsersPageTitle();		
		Assert.assertEquals(usersPageTitle, "actiTIME - User List", "Users Page Title not matched");
	}
	
	@Test(priority = 2)
	public void verifyUsersPageHeadingTest() {
		Assert.assertTrue(usersPage.verifyUsersPageHeading(), "Users Page Heading is missing!");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
