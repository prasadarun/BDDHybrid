package stepdefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.hooks.MyHooks;
import com.pages.LoginPage;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps{

	
	 private WebDriver driver;
	 private LoginPage loginpage;
	
	

	@Given("Navigate to login page")
	public void navigate_to_login_page() {
		loginpage = new LoginPage(driver);
		System.out.println("User navigated to login page");
	}

	@When("User enters the valid email address {string} into email text field")
	public void user_enters_the_valid_email_address_into_email_text_field(String email) {

 		loginpage.enterEmail(email);

	}

	@When("User enters the valid password {string} into password text field")
	public void user_enters_the_valid_password_into_password_text_field(String password) {

		loginpage.enterPassword(password);

	}

	@When("Click on Login button")
	public void click_on_Login_button() {

		loginpage.clickOnSubmitBtn();

	}

	@Then("User should be login successfully")
	public void user_should_be_login_successfully() {
		System.out.println("User should be login successfully");

		Assert.assertTrue("Login Sucessfull", loginpage.logoutBtnDisplayed());
	}

	@When("User enters the invalid email address {string} into email text field")
	public void user_enters_the_invalid_email_address_into_email_text_field(String invalidemail) throws Throwable {

		loginpage.enterEmail(invalidemail);

	}

	@And("User enters the invalid password {string} into password text field")
	public void user_enters_the_invalid_password_into_password_text_field(String invalidpassword) throws Throwable {

		loginpage.enterPassword(invalidpassword);

	}

	@Then("User should not be login successfully")
	public void user_should_not_be_login_successfully() throws Throwable {

		loginpage.clickOnSubmitBtn();

	}

}
