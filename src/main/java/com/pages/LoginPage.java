package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.utils.ElementUtils;


public class LoginPage{
	
	
	private ElementUtils util;
	
	public LoginPage(WebDriver driver) {
		util = new ElementUtils((DriverFactory.getDriver()));
	}
	
	private By email = By.id("input-email");
	private By pwd = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By logOutBtn = By.xpath("//ul//a[text()='Logout']");
	
	
	public void enterEmail(String username) {
		util.getElement(email).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		util.getElement(pwd).sendKeys(password);
	}
	
	
	public void clickOnSubmitBtn() {
		util.getElement(loginBtn).click();
	}
	
	
	public boolean logoutBtnDisplayed() {
		return util.getElement(logOutBtn).isDisplayed();
	}

}