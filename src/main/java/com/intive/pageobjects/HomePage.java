package com.intive.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.intive.utils.AppContext;
import com.intive.utils.Logger;


public class HomePage extends BasePage{
	
	private String pageAddress = "https://preprod-adidas.cs83.force.com";
    protected Logger log;

	
	@FindBy(how = How.ID, using = "send2Dsk")
    private WebElement txtUser;
	
	@FindBy(how = How.XPATH, using = "//input[contains(@class, ng-valid)]")
	private WebElement txtUserName;
	
	@FindBy(how = How.CLASS_NAME, using = "ng-binding")
	private WebElement usernametext;
	
	@FindBy(how = How.ID, using = "continue_button")
	private WebElement btnContinue;

	public HomePage(WebDriver driver) {		
		super(driver);		
		pageAddress =AppContext.getProps().getProperty("defaultAppUrl");			
		
	}
	
	public HomePage(WebDriver driver, String pageUrl) {
		super(driver);
		pageAddress = pageUrl;
	}
	
	@Override
	public void isLoaded() throws Error {		
		try {
			Assert.assertEquals(true, txtUser.isDisplayed());			
		} catch (NoSuchElementException e) {
			throw new Error("The text field is not present!");
		}
	}
	
	public String getPageAddress() {
		return pageAddress;
	}

	public void enterUserName(String Name) {
		String username = AppContext.getProps().getProperty("username");
		txtUserName.sendKeys(username);
		
	}

	public void verifyUserName(String Name) {
		 Assert.assertEquals(Name.trim(), usernametext.getText().trim());
	
	}

	public void clickContinue() {
		clickElement(btnContinue);
		
	}
	
}
