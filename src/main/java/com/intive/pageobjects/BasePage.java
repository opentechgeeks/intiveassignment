package com.intive.pageobjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.intive.utils.AppContext;
import com.intive.utils.Logger;


public class BasePage extends LoadableComponent<BasePage> {
	
	public static WebDriver driver;
    private final int MAX_STALE_ELEMENT_RETRIES = 5;
	private String pageTitle = "";
    private String pageAddress = "";
    public Logger log=AppContext.getAppLogger();
       
	
	public BasePage(){
		
	}
	
	public BasePage(WebDriver driver){
		
        this.driver = driver;
        // This call sets the WebElement fields.
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(getMaxWaitTime(), TimeUnit.SECONDS);
	
	}
	
	
	protected int getMaxWaitTime() {
	        //String timeout = System.getProperty("defaultMaxWaitTime"); // Get it from Jenkins
	        int timeout = Integer.parseInt(AppContext.getProps().getProperty("defaultMaxWaitTime"));
	        return timeout;
	        
	       // return (StringUtil.isNullOrEmpty(timeout)) ? Integer.parseInt(AppContext.getProps().getProperty("defaultMaxWaitTime")) : Integer.parseInt(timeout);
	    }
	

	@Override
	protected void load() {
        //log.logMessage("Loading the application");
        driver.get(getPageAddress());
		
	}

	protected String getPageAddress() {
        return pageAddress;

	}

	@Override
	protected void isLoaded() throws Error {
        if (driver != null) {
            if (!getTitle().equals(driver.getTitle().trim())) {
				throw new Error("This is not the '" + getTitle() + "' page! Loaded page title: '"
						+ driver.getTitle().trim() + "'.");
            }
        } else {
        }
		
	}
	
	


	private String getTitle() {
		return pageTitle;
	}
	
	 
	 
	 protected void setDropDownValue(WebElement dropDown, String optionValue) {

	        if (!dropDown.isEnabled()) {
	            throw new Error("Field is disabled!");
	        } else {
	            Select oSelect = new Select(dropDown);

	            List<WebElement> dropDownOptions = oSelect.getOptions();
	            Boolean found = true;
	            /*
	             * for (WebElement dropDownOption : dropDownOptions) { //
	             * System.out.println("[setDropDownValue] option: '" + //
	             * dropDownOption.getText() + "'"); if
	             * (dropDownOption.getText().compareTo(optionValue) == 0) { found =
	             * true; break; } }
	             */

	            if (found) {
	                oSelect.selectByValue(optionValue);
	            } else {
					throw new Error("The dropdown field does not contain the '" + optionValue + "' value!");
	            }
	        }
	    }

	    
	    
	    /**
	     * @param element
	     */
	    public void clickElement(WebElement element) {

	        //log.logMessage("[clickElement] Click element ");
	        WebDriverWait wait = new WebDriverWait(driver, getMaxWaitTime());
	        int retries = 0;
	        while (true) {
	            try {
	                wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	                //log.logMessage("[clickElement] Element clicked.");
	                return;
	            } catch (StaleElementReferenceException e) {
	                if (retries++ < MAX_STALE_ELEMENT_RETRIES) {
						//log.logMessage(
								//"[clickElement] StaleElementReferenceException raised. Try " + retries + " more time.");
	                    continue;
	                } else {
	                    throw e;
	                }
	            }
	        }
	    }

	    @Override
	    public BasePage get() {
	        try {
	            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	            isLoaded();
	            driver.manage().timeouts().implicitlyWait(getMaxWaitTime(), TimeUnit.SECONDS);
	            return (BasePage) this;
	        } catch (Error e) {
	            driver.manage().timeouts().implicitlyWait(getMaxWaitTime(), TimeUnit.SECONDS);
	            load();
	        }
	        isLoaded();
	        return (BasePage) this;
	    }

	
}
