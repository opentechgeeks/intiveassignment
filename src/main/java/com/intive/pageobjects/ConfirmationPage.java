package com.intive.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ConfirmationPage extends BasePage{

	@FindBy(how = How.ID, using = "title")
	private WebElement txtThankYou;
	
	@FindBy(how = How.XPATH, using = "//div[@class='ng-scope']/p")
	private WebElement txtSuccessMessage;

	public ConfirmationPage (WebDriver driver){
		super(driver);		
	}
	
	public void isLoaded() {
		txtThankYou.isDisplayed();		
	}
	
	public void verifySuccessMessage(String successmessage) {
		 Assert.assertEquals(successmessage.trim(), txtSuccessMessage.getText().trim());   
	
	}
}
