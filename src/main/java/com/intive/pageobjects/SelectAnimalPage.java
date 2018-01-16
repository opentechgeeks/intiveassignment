package com.intive.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SelectAnimalPage extends BasePage {
	
	@FindBy(how = How.XPATH, using = "//select[contains(@class, ng-pristine)]")
	private WebElement slctAnimalDrpdwn;
	
	@FindBy(how = How.ID, using = "back_button")
	private WebElement btnBack;
	
	public SelectAnimalPage (WebDriver driver) {
        super(driver);
		
	}

	public void isLoaded(){
		
		btnBack.isDisplayed();		
	}
	
	public void slctAnimal(String Animal){
		setDropDownValue(slctAnimalDrpdwn, Animal);
		
	}
	
	
}
