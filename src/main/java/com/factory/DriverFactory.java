package com.factory;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.io.Files;

public class DriverFactory {

	static WebDriver driver;
	
	public static String highlight;


	public static WebDriver getDriver() {
		return driver;
	}

	public static void initializeDriver(String browserName) {
		switch (browserName.toLowerCase()) {
		case "chrome":
			// Set system properties for Chrome driver
			
			// Initialize ChromeDriver
			driver = new ChromeDriver();
			break;
		case "firefox":
			// Set system properties for Firefox driver
			
			// Initialize FirefoxDriver
			driver = new FirefoxDriver();
			break;
		case "edge":
			// Set system properties for Edge driver
			// Initialize EdgeDriver
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Invalid browser name provided");
		}

		
	}
	
	public static void takeScreenshot(WebDriver driver, String screenshotPath) {
        // Take screenshot
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Save screenshot to the specified location
        try {
            Files.copy(screenshotFile, new File(screenshotPath));
            System.out.println("Screenshot saved to: " + screenshotPath);
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }



}
