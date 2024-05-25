package tests;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources",
		glue={"stepdefinations","com.hooks"},
		plugin = {"pretty", "html:target/cucumber-reports"},
		tags = "@registration",
		publish = true // Set to true to publish results
		)
public class MyRunner {

}
