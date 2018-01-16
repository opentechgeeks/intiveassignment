package com.intive.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.intive.pageobjects.BasePage;
import com.intive.pageobjects.SelectAnimalPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SelectAnimalPageSteps {

    private static WebDriver driver; 
    private static SelectAnimalPage animalPage;
    
    public  SelectAnimalPageSteps() {
		driver=BasePage.driver;
	}
   

	@Then("^the Select Animal page should be displayed$")
	public void the_Select_Animal_page_should_be_displayed() throws Throwable {
        	animalPage = new SelectAnimalPage(driver);
	    	animalPage.isLoaded();
	    
	    	}

	@When("^the user selects \"([^\"]*)\" from the dropdown$")
	public void the_user_selects_from_the_dropdown(String Animal) throws Throwable {
	    animalPage.slctAnimal(Animal);
	    
	}

		
}
