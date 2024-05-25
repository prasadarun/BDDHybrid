package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.factory.DriverFactory;
import com.utils.AppConstants;
import com.utils.ElementUtils;
import com.utils.TimeUtil;

public class RegistrationPage {
	
	
	private ElementUtils util;


	public RegistrationPage(WebDriver driver) {
		util = new ElementUtils(DriverFactory.getDriver());
		System.out.println("utils driver"+DriverFactory.getDriver());
	}
	
	//private By myAccount = By.xpath("//span[contains(text(),'My Account')]");
	
	private By registerasideLink = By.xpath("//div[@class='list-group']/a[contains(text(),'Register')]");
	
	
	
	// Text fields data 
	private By firstName = By.cssSelector("#input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmpassword = By.id("input-confirm");

	private By agreeCheckBox = By.name("agree");
	private By continueButton = By.xpath("//input[@type='submit' and @value='Continue']");
	private By subscribeYes = By.xpath("//label[@class='radio-inline']/input[@value='1' and @type='radio']");
	private By subscribeNo = By.xpath("//label[@class='radio-inline']/input[@value='0' and @type='radio']");
	
	
	// Error text labels 
	
	private By firstNameErrorLabel = By.xpath("//input[@name='firstname']//following::div[contains(text(),'First Name must be between 1 and 32 characters!')]");
	private By lastNameErrorLabel = By.xpath("//input[@name='lastname']//following::div[contains(text(),'Last Name must be between 1 and 32 characters!')]");
	private By emailErrorLabel = By.xpath("//input[@name='email']//following::div[contains(text(),'E-Mail Address does not appear to be valid!')]");
	private By telephoneErrorLabel = By.xpath("//input[@name='telephone']//following::div[contains(text(),'Telephone must be between 3 and 32 characters!')]");
	private By passwordErrorLabel = By.xpath("//input[@name='password']//following::div[contains(text(),'Password must be between 4 and 20 characters!')]");
	
	
	// Header text 
	private By registerAccountTitle = By.cssSelector("div#content h1");
	private By yourpersonalDetails = By.cssSelector("fieldset#account>legend");
	private By yourpassword = By.cssSelector("fieldset:nth-child(2) legend");
	private By newsLetters = By.cssSelector("fieldset:nth-child(3) legend");
	private By privacyText = By.cssSelector("div.pull-right:nth-child(1)");
	
	
	//links
	private By loginPageLink = By.xpath("//a[contains(text(),'login page')]");
	private By privacyLink = By.cssSelector("a.agree");
	private By privacyWindowText = By.xpath("//h4[contains(text(),'Privacy Policy')]");
	private By closePrivacyModel = By.cssSelector("button.close");
	
	
	private By registerSuccessMesg = By.cssSelector("div#content h1");
	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");
	
	
	
	public void clickRegisterLink() {
		util.getElement(registerasideLink).click();
	}
	
	public void enterFirstName(String firstname) {
		util.getElement(firstName).sendKeys(firstname);
	}
	
	public void enterLastName(String lastname) {
		util.getElement(lastName).sendKeys(lastname);
	}
	
	public void enterEmail(String emailAddress) {
		util.getElement(email).sendKeys(emailAddress);
	}
	
	public void enterPhone(String mobile) {
		util.getElement(telephone).sendKeys(mobile);
	}
	
	public void enterPWD(String pwd) {
		util.getElement(password).sendKeys(pwd);
	}
	
	public void enterConfirmPWD(String confirmPwd) {
		util.getElement(confirmpassword).sendKeys(confirmPwd);
	}
	
	
	public void checkAgressCheckbox() {
		util.getElement(agreeCheckBox).click();
	}
	
	public void checkSubscribeYes() {
		util.getElement(subscribeYes).click();
	}
	
	
	public void checkSubscribeNo() {
		util.getElement(subscribeNo).click();
	}
	
	public void clickContinueBtn() {
		util.waitForElementPresence(continueButton, TimeUtil.DEFAULT_TIME_OUT);
		util.getElement(continueButton).click();
	}
	
	public boolean isLoogoutDisplayed() {
		return util.getElement(logoutLink).isDisplayed();
	}
	
	public String getRegisterSuccessMsg() {
		return util.getElement(registerSuccessMesg).getText();
	}
	
	public String getfirstNameErrorLabel() {
		return util.getElement(firstNameErrorLabel).getText();
	}
	

	public String getlastNameErrorLabel() {
		return util.getElement(lastNameErrorLabel).getText();
	}
	

	public String getemailErrorLabel() {
		return util.getElement(emailErrorLabel).getText();
	}
	
	
	public String gettelephoneErrorLabel() {
		return util.getElement(telephoneErrorLabel).getText();
	}
	
	public String getpasswordErrorLabel() {
		return util.getElement(passwordErrorLabel).getText();
	}
	
	public String getPersonalTextHeading() {
		return util.getElement(yourpersonalDetails).getText();
	}
	
	public String getRegisterTextTitle() {
		return util.getElement(registerAccountTitle).getText();
	}
	
	public String getPasswordTextTitle() {
		return util.getElement(yourpassword).getText();
	}
	
	public String getNewsTextTitle() {
		return util.getElement(newsLetters).getText();
	}
	
	public String getPrivacyText() throws InterruptedException {
		String value = util.getElement(privacyText).getText();
		Thread.sleep(3000);
		return value;
	}
	
	public void clickLoginPageLink() {
		
		util.waitForElementPresence(loginPageLink, TimeUtil.DEFAULT_TIME_OUT);
		util.getElement(loginPageLink).click();
	}
	
	public String getLoginPageTitle() {
		return util.waitForTitleContains(AppConstants.LOGIN_PAGE_TITLE, TimeUtil.DEFAULT_TIME_OUT);
	}
	
	public void clickPrivacyLink() {
		util.waitForElementPresence(privacyLink, TimeUtil.DEFAULT_TIME_OUT);
		util.getElement(privacyLink).click();
	}

	public boolean getPrivacyWindowAlertDisplayed() {
		
	return	util.waitForElementPresence(privacyWindowText, TimeUtil.DEFAULT_TIME_OUT).isDisplayed();
		
	}
	
	public void closeModelAlert() {
		util.getElement(closePrivacyModel).click();
	}
	
	public boolean checkLoginLinkColorCode() {
		
		String colrValue = util.getElement(loginPageLink).getCssValue("color");
		
		
		if(colrValue.equals(AppConstants.LOGIN_COLOR_LINK)) {
			return true;
		}
		return false;
		
	}
	
	public boolean checkPrivacyLinkColorCode() {
			String colrValue = util.getElement(privacyLink).getCssValue("color");
		
		if(colrValue.equals(AppConstants.LOGIN_COLOR_LINK)) {
			return true;
		}
		return false;
		
	}

}
