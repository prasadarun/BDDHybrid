package stepdefinations;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.pages.LoginPage;
import com.utils.FertchDataFromMySQL;
import com.utils.PropertiesUtils;
import com.utils.ReadExcelFile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	private WebDriver driver;
	private LoginPage loginpage;
	private FertchDataFromMySQL getsql;
	private Properties prop;
	private Map<String, String> dbuserpwdValue;

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

	@Given("I have a valid database connection with {string} {string} {string} {string}")
	public void I_have_a_valid_database_connection(String user, String password, String account, String query)
			throws FileNotFoundException {
		getsql = new FertchDataFromMySQL();
		prop = PropertiesUtils.readProperties();
		dbuserpwdValue = getsql.connectDB(prop.getProperty("user"), prop.getProperty("password"),
				prop.getProperty("account"), prop.getProperty("query"));

	}

	@And("enter the fetched {string} and {string} in login page")
	public void enter_the_fetched_user_and_password_in_login_page(String usernameKey, String passwordKey) {

		loginpage.enterEmail(usernameKey);
		loginpage.enterPassword(passwordKey);
	}

	@And("enter the fetched {string} and {string} in login page and check the login status")
	public void enter_the_fetched_user_and_password_in_login_page_and_check_the_login_status(String usernameKey,
			String passwordKey) {

		for (Entry<String, String> entry : dbuserpwdValue.entrySet()) {

			String userNameKey = entry.getKey();
			String passwordKey1 = entry.getValue();

			try {
				System.out.println(userNameKey);
				System.out.println(passwordKey1);

				loginpage.enterEmail(userNameKey);
				loginpage.enterPassword(passwordKey1);
				loginpage.clickOnSubmitBtn();
				Thread.sleep(5000);

				if (loginpage.logoutBtnDisplayed()) {
					Assert.assertTrue("Login status true", loginpage.logoutBtnDisplayed());
					loginpage.clickOnLogoutBtn();
					loginpage.clickOnLogiAsideBtn();
					continue;
				}

			} catch (Exception e) {
				System.out.println("Exception occurred while logging in: " + e.getMessage());
				Assert.assertFalse("Login status true",false);
				continue; 
			}

		}

	}
	
	@Given("I have valid credentials in Excel sheet {string}")
    public void loadCredentialsFromExcel(String sheetName) throws Exception {
        // Specify the path to your Excel sheet
        // Use ExcelUtility to read data from Excel sheet
		dbuserpwdValue = loginpage.toArray(ReadExcelFile.getTestData(sheetName));
        

        
    }
	

}
