package com.hooks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.utils.ElementUtils;
import com.utils.PropertiesUtils;
import com.utils.TakeScreenShotUtils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class MyHooks {

	WebDriver driver;
	Properties prop;
	ElementUtils utils;

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
	public void tearDown(Scenario scenario) {

		if (scenario.isFailed()) {
			// Take screenshot

			String scenarioName = scenario.getName().replaceAll(" ", "-");

			if (prop.getProperty("saveScreenShotLocally").equalsIgnoreCase("false")) {
				scenario.attach(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "img/png", scenarioName);
			}

			else {
				String path = TakeScreenShotUtils.getScreenshot();
				File file = new File(path);

				try {
					FileInputStream fis = new FileInputStream(TakeScreenShotUtils.getScreenshot());
					byte[] bytes = new byte[(int) file.length()];
					fis.read(bytes);
					fis.close();

					// Now, bytes contains the content of the file in byte format
					// You can use bytes array as needed
					scenario.attach(bytes, "image/png", scenarioName);

				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		}
		driver.quit();
	}

}
