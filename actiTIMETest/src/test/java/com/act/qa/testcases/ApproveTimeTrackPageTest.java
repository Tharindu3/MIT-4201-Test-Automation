package com.act.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.act.qa.base.TestBase;
import com.act.qa.pages.ApproveTimeTrackPage;
import com.act.qa.pages.HomePage;
import com.act.qa.pages.LoginPage;
//import com.act.qa.pages.ReportsPage;
//import com.act.qa.pages.UsersPage;
import com.act.qa.util.TestUtil;

public class ApproveTimeTrackPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
//	ReportsPage reportsPage;
//	UsersPage usersPage;
	ApproveTimeTrackPage approveTimeTrackPage;
	
	String fileName = "searchEmp";
	String sheetName = "apprtimeemp";
	
	public ApproveTimeTrackPageTest() {
		super();
	}
	
	@BeforeMethod
	public void Setup() {
		initialization();		
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		approveTimeTrackPage = homePage.clickOnApproveTimeTrackLink();
	}
	
	@Test(priority = 1)
	public void validateApproveTimeTrackTitleTest() {			
		String approvePageTitle = approveTimeTrackPage.validateApproveTimeTrackPageTitle();		
		Assert.assertEquals(approvePageTitle, "actiTIME - Approve Time-Track", "Approve TimeTracks Page Title not matched");
	}
	
	@Test(priority = 2)
	public void verifyApproveTimeTrackHeadingTest() {
		Assert.assertTrue(approveTimeTrackPage.verifyApproveTimeTrackPageHeading(), "Approve TimeTracks Page Heading is missing!");
	}
	
	@DataProvider
	public Object [][] getSearchEmpTestData() {
		Object data [][] = TestUtil.getTestData(fileName,sheetName);
		return data;
	}
	
	
//	@Test(priority = 3, dataProvider = "getSearchEmpTestData")
//	public void validateFindSearchedEmpTest(String FName,String LName) {	
//		if(approveTimeTrackPage.verifyApproveTimeTrackPageHeading()) {		
//			approveTimeTrackPage = approveTimeTrackPage.enterSearchEmp(FName,LName);
//		}		
//	}
	
	@Test(priority = 3, dataProvider = "getSearchEmpTestData")
	public void approveEmpTimeTracksTest(String FName,String LName) {
		if(approveTimeTrackPage.verifyApproveTimeTrackPageHeading()) {
			approveTimeTrackPage = approveTimeTrackPage.enterSearchEmp(FName,LName);
		}
				
		if(approveTimeTrackPage.findsearchEmp(FName) && approveTimeTrackPage.verifyEmpTimeRecordsAvailability()) {
			approveTimeTrackPage = approveTimeTrackPage.clickEmpWorkingTimeGroupRecordChkBox();	
			approveTimeTrackPage.clickOnApproveButton();
			
		}
		
		Assert.assertTrue(approveTimeTrackPage.verifyEmpTimeRecordsStatusChangedToRevoke());
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
