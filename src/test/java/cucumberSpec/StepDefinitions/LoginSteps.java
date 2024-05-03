package cucumberSpec.StepDefinitions;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumberSpec.pages.BaseClass;
import cucumberSpec.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 

public class LoginSteps  {
	
	
	private LoginPage loginPage;

	//pre condition for step that user should be on the login page first
	
	@Given("user is on Login Page")
	public void user_is_on_login_page() {
		
		loginPage = new LoginPage(Hooks.getDriver());
		loginPage.navigateToLoginPage();
		
	}
	
    //user entering valid or invalid email for login
	
	@When("user entered username \"([^\"]*)\"$")
	public void user_enter_username(String email) {
	   loginPage.enterUsername(email);
	}
	
    //user entering valid password for login
	
	@When("user entered password {string}")
	public void user_enter_password(String password) {
		loginPage.enterPassword(password);
	}
	
	//post successfull login, user reaches puzzle page

	@Then("user moves to puzzle solve page")
	public void user_moves_to_solve_page() {
	    loginPage.reachedPuzzleMessage();
	   
	}
	
	//error displayed when user enter invalid email
	
	@Then("user gets invalid credential error")
	public void user_gets_error() {
	    loginPage.checkInvalidMsg();
	   
	}

	
}
