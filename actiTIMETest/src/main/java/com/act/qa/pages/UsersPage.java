package com.act.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.act.qa.base.TestBase;

public class UsersPage extends TestBase {		
	
		@FindBy(xpath="//div[@class='pagetitle']//span[contains(text(),'List of Users')]")
		WebElement userPageHeading;

		//Initializing the Page Objects
		public UsersPage() {		
			PageFactory.initElements(driver, this);		
		}
		
		//Actions:
		public String validateUsersPageTitle() {
			return driver.getTitle();
		}
		
		public Boolean verifyUsersPageHeading() {
			return userPageHeading.isDisplayed();
			
		}
		

}
