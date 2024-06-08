
package stepdefinations;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.pages.RegistrationPage;
import com.utils.AppConstants;
import com.utils.GenerateRandomString;
import com.utils.TimeUtil;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationSteps {

	private WebDriver driver;
	private RegistrationPage registrationPage;

	@Given("navigate to home page")
	public void navigate_to_home_page() {
		this.driver = DriverFactory.getDriver();
		registrationPage = new RegistrationPage(driver);

	}

	@When("click on register option from aside menu")
	public void click_on_register_option_from_aside_menu() {

		System.out.println("registration driver" + driver);
		registrationPage.clickRegisterLink();
	}

	@When("enter the following details")
	public void enter_the_following_details(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		List<Map<String, String>> dataList = dataTable.asMaps(String.class, String.class);

		// Logging to verify data retrieval
		for (Map<String, String> data : dataList) {
			System.out.println("Data from feature file: " + data);

			String firstName = data.get("first_Name");
			String lastName = data.get("last_Name");
			String email = data.get("email");
			String telephone = data.get("telephone");
			String password = data.get("password");
			String confirmPassword = data.get("confirm_password");

			if (firstName != null && lastName != null && telephone != null && password != null
					&& confirmPassword != null) {
				registrationPage.enterFirstName(firstName);
				registrationPage.enterLastName(lastName);
				registrationPage.enterPhone(telephone);
				registrationPage.enterPWD(password);
				registrationPage.enterConfirmPWD(confirmPassword);

				if (email.equals("empty") || email == null) {
					// nothing or handle empty email as per your requirement
					// If you want to skip entering email, you can leave this block empty
				} else if (email.equals("dynamicvalue"))
					registrationPage.enterEmail(GenerateRandomString.generateRandomString(TimeUtil.EMAIL_CHAR_LENGTH));
			} else {

				System.out.println("One or more required values are null. Cannot proceed with registration.");
			}

			Thread.sleep(5000);

		}

	}

	@When("click on Subscribe option")
	public void click_on_subscribe_option() {
		registrationPage.checkSubscribeYes();

	}

	@When("click on accept privacy button")
	public void click_on_accept_privacy_button() {
		registrationPage.checkAgressCheckbox();
	}

	@When("click on continue button")
	public void click_on_continue_button() {

		registrationPage.clickContinueBtn();
	}

	@Then("user should be able to successfully create account")
	public void user_should_be_able_to_successfully_create_account() {

		Assert.assertEquals("Your Account Has Been Created!", registrationPage.getRegisterSuccessMsg());

	}

	@Then("User should not be able to create account")
	public void user_should_not_be_able_to_create_account() {

	}

	@Then("first name error label should be displayed")
	public void first_name_error_label_should_be_displayed() {

		Assert.assertEquals(registrationPage.getfirstNameErrorLabel(), AppConstants.FIRST_NAME_ERROR_LABEL);

	}

	@Then("last name error label should be displayed")
	public void last_name_error_label_should_be_displayed() {

		Assert.assertEquals(registrationPage.getlastNameErrorLabel(), AppConstants.LAST_NAME_ERROR_LABEL);
	}

	@Then("email error label should be displayed")
	public void email_error_label_should_be_displayed() {
		Assert.assertEquals(registrationPage.getemailErrorLabel(), AppConstants.EMAIL_ERROR_LABEL);
	}

	@Then("telephone error label should be displayed")
	public void telephone_error_label_should_be_displayed() {
		Assert.assertEquals(registrationPage.gettelephoneErrorLabel(), AppConstants.TELEPHONE_ERROR_LABEL);
	}

	@Then("password error label should be displayed")
	public void password_error_label_should_be_displayed() {

		Assert.assertEquals(registrationPage.getpasswordErrorLabel(), AppConstants.PASSWORD_ERROR_LABEL);
	}

	@Then("'Your Personal Details' text should be present")
	public void your_personal_details_text_should_be_present() {
		Assert.assertEquals(registrationPage.getPersonalTextHeading(), AppConstants.YOUR_PERSONALDETAILS_TITLE);
	}

	@Then("'Register Account' title should be present")
	public void register_account_title_should_be_present() {
		Assert.assertEquals(registrationPage.getRegisterTextTitle(), AppConstants.REGISTER_ACCOUNT_TITLE);
	}

	@Then("'Your Password' text should be present")
	public void your_password_text_should_be_present() {
		Assert.assertEquals(registrationPage.getPasswordTextTitle(), AppConstants.YOUR_PASSWORD_TITLE);
	}

	@Then("'Newsletter' text should be present")
	public void newsletter_text_should_be_present() {

		Assert.assertEquals(registrationPage.getNewsTextTitle(), AppConstants.NEWS_LETTER_TITLE);
	}

	@Then("'I have read and agree to the Privacy Policy ' text should be present")
	public void privacy_policy_text_should_be_present() throws InterruptedException {

		Assert.assertEquals(registrationPage.getPrivacyText(), AppConstants.PRIVACYTEXT);
	}

	@When("click on login link from header")
	public void click_on_login_link_from_header() {
		registrationPage.clickLoginPageLink();

	}

	@Then("login page should display with page title as Account Login")
	public void verifyLoginPageTitle() {

		Assert.assertEquals(AppConstants.LOGIN_PAGE_TITLE, registrationPage.getLoginPageTitle());
	}
	
	@Then("login link should be displayed with following colour code '#23a1d'")
	public void verifyLoginColurCode() {
		Assert.assertTrue(registrationPage.checkLoginLinkColorCode());
	}
	
	@Then("privacy link should be displayed with following colour code '#23a1d'")
	public void verifyprivacynColurCode() {
		
	}

	@When("click on privacy policy link above to submit button")
	public void click_on_privacy_policy_link_above_to_submit_button() {

		registrationPage.clickPrivacyLink();
	}

	@Then("privacy policy alert window should get displayed")
	public void verifyPrivacyPolicyAlert() {

		Assert.assertTrue(registrationPage.getPrivacyWindowAlertDisplayed());
	}

	@Then("click on close from alert window")
	public void closeAlertWindow() {
		registrationPage.closeModelAlert();
	}

}
