package com.act.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.act.qa.base.TestBase;
import com.act.qa.pages.HomePage;
import com.act.qa.pages.LoginPage;
import com.act.qa.pages.ReportsPage;
//import com.act.qa.pages.UsersPage;
import com.act.qa.util.TestUtil;

public class ReportsPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	ReportsPage reportsPage;
	TestUtil testUtil;
	
	public ReportsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void Setup() {
		initialization();		
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		reportsPage = homePage.clickOnReportsLink();		
	}
	
	@Test(priority = 1)
	public void validateReportsPageTitleTest() {				
		String reportsPageTitle = reportsPage.validateReportsPageTitle();		
		Assert.assertEquals(reportsPageTitle, "actiTIME - Reports Dashboard", "Reports Page Title not matched");
	}
	
	@Test(priority = 2)
	public void verifyReportsPageHeadingTest() {
		Assert.assertTrue(reportsPage.verifyReportsPageHeading(), "Reports Page Heading is missing!");
	}
	
	@Test(priority = 3)
	public void visibleChartModalTest() {
		Assert.assertTrue(reportsPage.visibleChartModal(), "Chart didn't Visible!");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
