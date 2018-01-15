package com.intive.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.intive.pageobjects.BasePage;
import com.intive.pageobjects.ConfirmationPage;

import cucumber.api.java.en.Then;


public class ConfirmationPageSteps {
	
	private static WebDriver driver; 
    private static ConfirmationPage confPage;
    
    public   ConfirmationPageSteps() {
    	driver=BasePage.driver;	
    	}
    
    @Then("^the Thank you confirmation page should be displayed$")
	public void the_Thank_you_confirmation_page_should_be_displayed() throws Throwable {
	    confPage=new ConfirmationPage(driver);
	    confPage.isLoaded();
    	
	}

	@Then("^the \"([^\"]*)\" should be displayed$")
	public void the_should_be_displayed(String successmessage) throws Throwable {
		confPage.verifySuccessMessage(successmessage);
	    
		
	}

}
