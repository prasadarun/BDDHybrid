package com.pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.utils.ElementUtils;
import com.utils.TimeUtil;

public class LoginPage {

	private ElementUtils util;

	public LoginPage(WebDriver driver) {
		util = new ElementUtils((DriverFactory.getDriver()));
	}

	private By email = By.id("input-email");
	private By pwd = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By logOutBtn = By.xpath("//a[@class='list-group-item' and contains(text(),'Logout')]");
	private By loginasideLink = By.xpath("//div[@class='list-group']/a[contains(text(),'Login')]");

	public void enterEmail(String username) {
		util.getElement(email).clear();
		util.getElement(email).sendKeys(username);
	}

	public void enterPassword(String password) {
		util.getElement(pwd).clear();
		util.getElement(pwd).sendKeys(password);
	}

	public void clickOnSubmitBtn() {
		util.getElement(loginBtn).click();
	}

	public boolean logoutBtnDisplayed() {
		util.waitForElementPresence(logOutBtn, TimeUtil.DEFAULT_TIME_OUT);
		return util.getElement(logOutBtn).isDisplayed();
	}

	public void enterUsrPwdDB(String username, String password) {
		util.getElement(email).sendKeys(username);
		util.getElement(pwd).sendKeys(password);
	}

	public void clickOnLogoutBtn() {
		util.waitForElementPresence(logOutBtn, TimeUtil.DEFAULT_TIME_OUT);
		util.getElement(logOutBtn).click();
	}

	public void clickOnLogiAsideBtn() {
		util.getElement(loginasideLink).click();
	}

	public Map<String, String> toArray(Object[][] testData) {
		Map<String, String> mapValues = new HashMap();
		
		
		for (int i = 1; i < testData.length; i++) {
		    Object[] row = testData[i];
		    if (row.length >= 3) {
		        String key = (String) row[0]; // Assuming the first element is the key
		        String value = (String) row[1]; // Assuming the second element is the value
		       
		        mapValues.put(key, value);
		    }
		}


		// Added sample text from git
        
        System.out.println(mapValues);

		return mapValues;
	}

}
