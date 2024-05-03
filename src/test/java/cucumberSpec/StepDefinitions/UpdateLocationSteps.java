package cucumberSpec.StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumberSpec.pages.BaseClass;
import cucumberSpec.pages.UpdateLocationPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpdateLocationSteps {

	
	UpdateLocationPage locationPage;
	
   //pre condition as user to be on home page before updating location
	@Given("user is on home page")
	public void user_is_on_home_page() {
		locationPage=new UpdateLocationPage(Hooks.getDriver());
		locationPage.onHomepage();
	}
	
	//clicking the location update button present on homepage
	
	@Given("user clicked on location update button")
	public void user_clicked_on_location_update() {
		locationPage.clickedLocationUpdateButton();
	}
	
	//enter pincode on appeared popup of update location 
	
	@When("user entered pincode {string}")
	public void user_entered_pincode (String pincode) {
		locationPage.enterPincode(pincode);
	}

	 
	//verifying successfull updation of location
	
	@Then("location updated to {string}")
	public void location_should_get_updated(String pincode) {
		locationPage.isLocationUpdated(pincode);
	}
	@Then("location not get updated")
	public void location_not_updated() {
		locationPage.isUpdationFailed();
	}

}
