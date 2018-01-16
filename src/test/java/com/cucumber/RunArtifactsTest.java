package com.cucumber;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(tags={"@run"},
 glue = { "com.intive.stepDefinitions" }, plugin = { "pretty", "html:target/cucumber",
		"json:target/cucumber.json" })
public class RunArtifactsTest {

}