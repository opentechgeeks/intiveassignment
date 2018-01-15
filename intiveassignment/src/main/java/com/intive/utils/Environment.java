package com.intive.utils;

import java.io.File;


import com.intive.browsers.BrowserBase;

public class Environment {

	public String getDriverPath(BrowserBase browser) {
        return getToolPath() + 
                File.separator + 
                "drivers" +
                File.separator +
                browser.getWebBrowser() + 
                getFileExtension();
    }

	private String getFileExtension() {
		return ".exe";
	}

	public String getToolPath() {
		
		return "tools";
		
	}

	
	
	
}
