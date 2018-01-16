package com.intive.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IEBrowser extends BrowserBase {

	@Override
	public WebDriver getWebDriver() {		
        DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
        WebDriver drv = new InternetExplorerDriver(caps);
        drv.manage().window().maximize();
        return drv;
	}

	@Override
	public String getWebBrowser() {
		return "IEDriverServer";
		
	}
	
	 

}
