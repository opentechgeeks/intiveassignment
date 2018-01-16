package com.intive.utils;

import cucumber.api.Scenario;

public class Logger {
	
    private Scenario scenario;
    
    /**
     * @param scenario
     */
    public Logger(Scenario scenario) {
        super();
        this.scenario = scenario;
    }
    
    public void logMessage(String message){
        scenario.write(message);
		
    };

}
