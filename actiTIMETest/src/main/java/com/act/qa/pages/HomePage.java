package com.act.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.act.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//td[@class='profileCell preventPanelsHiding']//a[@class='userProfileLink username ' and contains(text(),'John')]")
	@CacheLookup
	WebElement userNameLabel;
		
	
	@FindBy(xpath = "//div[contains(text(),'Reports') and @class='label']")
	WebElement reportsLink;

	
	@FindBy(xpath = "//div[contains(text(),'Users') and @class='label']")
	WebElement usersLink;
	
	@FindBy(xpath = "//div[@id='logo_aT']")
	WebElement actiTimeLogo;
	
	
	//For Saving Time records
	@FindBy(xpath = "//div[@class='userNameWrapper']//span[contains(text(),'Me')]")
	WebElement selectedEmpMe;
	
	@FindBy(id="spent_135_0")
	WebElement timeInput_01;
	
	@FindBy(id="spent_138_0")
	WebElement timeInput_02;
	
	@FindBy(id="spent_95_0")
	WebElement timeInput_03;	
	
	@FindBy(xpath="//input[@id='SubmitTTButton' and @value='Save Changes']")
	WebElement saveChangesButton;
	
	@FindBy(xpath = "//span[@class='successmsg' and contains(text(),'Your changes were successfully saved.')]")
	WebElement successMsg;
	
	
	//For Approve/Reject Time records
	@FindBy(xpath="//a[@class='item' and contains(text(),'Approve Time-Track')]")
	WebElement approveTimeTrackLink;
	
	
		//Initializing the Page Objects
		public HomePage() {		
			PageFactory.initElements(driver, this);		
		}
		
		//Actions:
		public String validateHomePageTitle() {
			return driver.getTitle();
		}
		
		public Boolean validateActiTimeLogo() {
			return actiTimeLogo.isDisplayed();
			
		}
		
		public ReportsPage clickOnReportsLink() {
			reportsLink.click();			
			return new ReportsPage();
		}
				
		public UsersPage clickOnUsersLink() {
			usersLink.click();			
			return new UsersPage();
		}
		
		public boolean verifyCorrectUserName() {			
			return userNameLabel.isDisplayed();
		}
		
		public boolean verifySelectedEmpMe() {			
			return selectedEmpMe.isDisplayed();
		}
		
		public HomePage enterTimeTrack(String Time1, String Time2, String Time3) {
			timeInput_01.clear();
			timeInput_02.clear();
			timeInput_03.clear();
			
			timeInput_01.sendKeys(Time1);
			timeInput_02.sendKeys(Time2);
			timeInput_03.sendKeys(Time3);
			
			saveChangesButton.click();
			return new HomePage();
		}
		
		public boolean verifySuccessTimeInsertion() {			
			return successMsg.isDisplayed();
		}
		
		public ApproveTimeTrackPage clickOnApproveTimeTrackLink() {
			approveTimeTrackLink.click();			
			return new ApproveTimeTrackPage();
		}
		
	
}
