package com.intive.browsers;

public class BrowserFactory {
	
	public BrowserBase getBrowser(String browserName){
		
		switch (browserName.toLowerCase()) {
		
		case "ie":
            return new IEBrowser();                       
		default:
            return new ChromeBrowser();
	
		}
		
		
	}

	
	
}
