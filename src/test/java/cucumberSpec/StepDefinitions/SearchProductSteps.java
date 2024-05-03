package cucumberSpec.StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumberSpec.pages.BaseClass;
import cucumberSpec.pages.SearchProduct;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchProductSteps {
	
	SearchProduct searchProduct;

	//pre condition of user to be on homepage before searching product
	
	@Given("user should be on homepage")
	public void user_should_be_on_homepage() {
		searchProduct=new SearchProduct(Hooks.getDriver());
		searchProduct.onHomepage();
	}
	
	//user entering desired product for search
	
	@When("user searches for {string}")
	public void user_searches_for(String product) {
		searchProduct.searchInput(product);
	}
	
	//verifying search product is getting displayed
	
	@Then("search result should display")
	public void search_result_should_display() {
		searchProduct.searchResultAvailable();
	}
	
	//verifying searched product is not getting displayed
	@Then("search result should not display")
	public void search_result_should_not_display() {
		searchProduct.isErrorDisplayed();
	}


}
