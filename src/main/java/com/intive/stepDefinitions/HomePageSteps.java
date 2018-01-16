package com.intive.stepDefinitions;


import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.intive.browsers.BrowserFactory;
import com.intive.pageobjects.HomePage;
import com.intive.utils.AppContext;
import com.intive.utils.Logger;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class HomePageSteps {
	
    private static WebDriver driver;
    private static Logger log;
    private static HomePage homePage;
	private Scenario scenario;
	

	@Given("^The user navigates to Website \"([^\"]*)\"$")
	public void the_user_navigates_to_Website(String URL) throws Throwable {
		try {
			homePage = new HomePage(driver);
            homePage.get();
        } catch (Throwable err) {
        }

			
	}

	@When("^the user enters \"([^\"]*)\" in the text field$")
	public void the_user_enters_in_the_text_field(String Name) throws Throwable {
		homePage.enterUserName(Name);
	    
	}

	@Then("^The \"([^\"]*)\" should be displayed below the text field\\.$")
	public void the_should_be_displayed_below_the_text_field(String Name) throws Throwable {
	    homePage.verifyUserName(Name);
	}
	

	@When("^the user clicks on Continue button$")
	public void the_user_clicks_on_Continue_button() throws Throwable {
	    homePage.clickContinue();
	    
	}

	@Before
    public void startUp(Scenario scenario) throws Exception {
        AppContext.setProps("intive.properties");
        this.scenario = scenario; 
        AppContext.setAppLogger(log);
        driver = getDriver();
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }       
        driver.quit();
        
    }
	private WebDriver getDriver() {
			String browser = AppContext.getProps().getProperty("browser");
	        BrowserFactory browserFactory = new BrowserFactory();
	        return browserFactory.getBrowser(browser).getWebDriver();
    }

}
