package stepdefinations;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

import com.factory.DriverFactory;
import com.pages.LoginPage;
import com.pages.SearchPage;
import com.utils.AppConstants;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps {
	
	private LoginPage loginpage;
	private SearchPage searchpage;
	

	@When("user enters the {string} in search box")
	public void enter_Product_Name(String productName) {
		searchpage = new SearchPage(DriverFactory.getDriver());
		searchpage.enterProduct(productName);
	}
	
	@And("click on enter button or search icon")
	public void click_on_enterbutton_or_search_button() {
		searchpage.clickOnSearchIcon();
	}
	
	@Then("search results should contain all of the following")
	public void  search_results_should_contain_all_of_the_following(DataTable dataTable) {
		 List<String> expectedProducts = dataTable.asList();
		Assert.assertEquals("Product search successful for MacBook",expectedProducts,searchpage.getSearchResultsList());
	}

}
