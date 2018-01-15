package com.intive.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import cucumber.api.Scenario;


public class AppContext {

    private static Properties props = new Properties();
	private static Scenario scenario;
    private static Logger appLogger = new Logger(scenario);
    private static Environment env = new Environment();
    
    public static Logger getAppLogger() {
		return appLogger;
	}
	public static void setAppLogger(Logger appLogger) {
		AppContext.appLogger = appLogger;
	}
	public static Properties getProps() {
		return props;
	}
	public static void setProps(Properties props) {
        AppContext.props = props;
    }

    public static void setProps(String properties) {
        try (FileInputStream fileIn = new FileInputStream(properties)) {
            AppContext.props.load(fileIn);
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void setEnv(Environment env) {
        AppContext.env = env;
    }
    
	public static Environment getEnv() {
		return env;
	}


	
}
