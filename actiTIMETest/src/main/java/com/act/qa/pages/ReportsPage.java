package com.act.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.act.qa.base.TestBase;

public class ReportsPage extends TestBase {

	@FindBy(xpath = "//td[@class='pagetitle' and contains(text(),'Reports Dashboard')]")
	WebElement reportsPageHeading;
	
	@FindBy(xpath= "//div[@class='type-title' and contains(text(),'Leave hours by Users')]")
	WebElement reportCard;
	
	@FindBy(xpath= "//div[@class='lightBoxTitle' and contains(text(),'Create Chart:')]")	
	WebElement chartModal;
	
	
	//Initializing the Page Objects
	public ReportsPage() {		
		PageFactory.initElements(driver, this);		
	}
			
	//Actions:
	public String validateReportsPageTitle() {
		return driver.getTitle();
	}
			
	public Boolean verifyReportsPageHeading() {
		return reportsPageHeading.isDisplayed();			
	}
	
	
	public Boolean visibleChartModal() {
		reportCard.click();	
		return chartModal.isDisplayed();			
	}
	
	
}
