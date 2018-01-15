package com.intive.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.intive.utils.AppContext;

public class ChromeBrowser extends BrowserBase {


	@Override
	public WebDriver getWebDriver() {
        return new ChromeDriver(setProperties());
	}

    private ChromeOptions setProperties() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            System.setProperty("webdriver.chrome.driver", AppContext.getEnv().getDriverPath(this));
            return options;
        }
		
	@Override
	public String getWebBrowser() {
		return "chromedriver";
		
	}

}
