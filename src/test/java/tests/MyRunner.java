package tests;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources",
		glue={"stepdefinations","com.hooks"},
		plugin = {"pretty", "html:target/cucumber-reports"},
		tags = "@searchMacBook",
		publish = true, // Set to true to publish results
		monochrome = false, // gives the colour output of steps in console during false value 
		dryRun = false,  // quick check about having all features files defined with steps 
		stepNotifications = false  // don't see any difference
		)
public class MyRunner {
	
	

}
