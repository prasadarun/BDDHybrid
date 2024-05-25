package com.hooks;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.google.common.io.Files;
import com.utils.PropertiesUtils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class MyHooks {
	
	
	WebDriver driver;
	Properties prop;

	@Before
	public void setup() throws FileNotFoundException {
		
		prop = PropertiesUtils.readProperties();
		DriverFactory.initializeDriver(prop.getProperty("browser"));
		System.out.println(prop.getProperty(prop.getProperty("browser")));
		driver = DriverFactory.getDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@After
	public void tearDown(Scenario Scenario) {
		
		 if (Scenario.isFailed()) {
	            // Take screenshot
			
	        }
		driver.quit();
	}

}
