package com.act.qa.testcases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.act.qa.base.TestBase;
import com.act.qa.pages.HomePage;
import com.act.qa.pages.LoginPage;
import com.act.qa.pages.ReportsPage;
import com.act.qa.pages.UsersPage;
import com.act.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ReportsPage reportsPage;
	UsersPage usersPage;
	
	String fileName = "actiTimeTestData";
	String sheetName = "times";
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void Setup() {
		initialization();		
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
		
	@Test(priority = 1)
	public void homePageLogoTest() {
		
	boolean flag= homePage.validateActiTimeLogo();
	Assert.assertTrue(flag,"Cannot find the Logo");
		
	}
	
	@Test(priority = 2)
	public void validateHomePageTitleTest() {
		
//		driver.get("https://demo.actitime.com/user/submit_tt.do");
//		System.out.println("Page title is : " + driver.getTitle());
		 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		String homePageTitle = homePage.validateHomePageTitle();		
		Assert.assertEquals(homePageTitle, "actiTIME - Enter Time-Track", "Home Page Title not matched");
	}
	
	@Test(priority = 3)
	public void verifyUserNameTest() {
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority = 4)
	public void verifyReportsLinkTest() {
		reportsPage = homePage.clickOnReportsLink();
	}
	
	@Test(priority = 5)
	public void verifyUsersLinkTest() {
		usersPage = homePage.clickOnUsersLink();
	}
	
	@Test(priority = 6)
	public void verifySelectedEmpTest() {
		Assert.assertTrue(homePage.verifySelectedEmpMe());
	}
	
	
	@DataProvider
	public Object [][] getActiTimeTestData() {
		Object data [][] = TestUtil.getTestData(fileName,sheetName);
		return data;
	}
	
	@Test(priority = 7, dataProvider = "getActiTimeTestData")
	public void validateEnterTimeTracksForMeTest(String time_01,String time_02,String time_03) {
//		homePage.enterTimeTrack("5:00","5:15","5:30");
		if(homePage.verifySelectedEmpMe()) {
//			homePage = homePage.enterTimeTrack("7:00","7:15","7:30");
//			System.out.println("Times: " + time_01 + "," + time_02 + "," + time_03);
			
			homePage = homePage.enterTimeTrack(time_01,time_02,time_03);
		}
		Assert.assertTrue(homePage.verifySuccessTimeInsertion());
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
