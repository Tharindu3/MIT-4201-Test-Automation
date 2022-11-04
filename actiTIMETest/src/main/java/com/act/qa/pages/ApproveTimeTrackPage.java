package com.act.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.act.qa.base.TestBase;

public class ApproveTimeTrackPage extends TestBase {
	
	@FindBy(xpath= "//td[@class='pagetitle' and contains(text(),'Approve Time-Track')]")
	WebElement approveTimePageHeader;
	
	@FindBy(xpath = "//input[@class='filterFieldInput inputFieldWithPlaceholder' and @placeholder='Start typing name']")	
	WebElement empSearchField;
	
	@FindBy(xpath = "//tbody[@class='data']//tr[@class='groupingRow']//td[@class='selectionCell']//input")	
	WebElement empWorkingTimeGroupRecordChkBox;
	
	@FindBy(xpath = "//tr[@class='childRow operationWasApplied approved']//a[@class='revokeLink' and contains(text(),'revoke')]")	
	WebElement empTimeTrackRevokeState;
	
	@FindBy(xpath = "//span[@id='approveButton' and @class='actionButton approve']")	
	WebElement approveButton;
	
	
	
	//Initializing the Page Objects
		public ApproveTimeTrackPage() {		
			PageFactory.initElements(driver, this);		
		}
	
		//Actions:
		public String validateApproveTimeTrackPageTitle() {
			return driver.getTitle();
		}
		
		public Boolean verifyApproveTimeTrackPageHeading() {
			return approveTimePageHeader.isDisplayed();			
		}
		
		public ApproveTimeTrackPage enterSearchEmp(String fName, String lName) {
			empSearchField.clear();			
			String fullName = fName + ", " + lName;			
			empSearchField.sendKeys(fullName);							
			return new ApproveTimeTrackPage();
		}
		
		
		public boolean findsearchEmp(String Fname) {			
			String searchedEmpLabel = "//div[@class='userNameInfo' and contains(text(),',')]//span[contains(text(),'"+Fname+"')]";
			return driver.findElement(By.xpath(searchedEmpLabel)).isDisplayed();			
		}
		
		public Boolean verifyEmpTimeRecordsAvailability() {
			return empWorkingTimeGroupRecordChkBox.isDisplayed();			
		}
				
		
		public ApproveTimeTrackPage clickEmpWorkingTimeGroupRecordChkBox() {						
			empWorkingTimeGroupRecordChkBox.click();
			return new ApproveTimeTrackPage();
		}
		
		public ApproveTimeTrackPage clickOnApproveButton() {
			approveButton.click();			
			return new ApproveTimeTrackPage();
		}
		
		public Boolean verifyEmpTimeRecordsStatusChangedToRevoke() {
			return empTimeTrackRevokeState.isDisplayed();			
		}
		
}
