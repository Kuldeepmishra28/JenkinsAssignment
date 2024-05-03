package cucumberSpec.pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage  {
private WebDriver driver;
//login page object model containing elements and implementation of login related webpage
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "nav-link-accountList")
	WebElement loginPageTab;
	
	@FindBy(id="ap_email")
	WebElement emailInput;
	
	@FindBy(id="continue")
	WebElement continueBtn;
	
	@FindBy(id="signInSubmit")
	WebElement signInBtn;
	
	@FindBy(id="ap_password")
	WebElement passwordInput;
	
	@FindBy(css = "span[class=\"a-size-large\"]")
	WebElement puzzleMessage;
	
	@FindBy(css = "h4[class=\"a-alert-heading\"]")
	WebElement invalidEmailMsg;
	
	CommonFunctionality commonObj=new CommonFunctionality();
	
	//method to navigate execution to the login page of amazon
	
	public void navigateToLoginPage() {
		
		commonObj.waitFun(driver, loginPageTab);
		loginPageTab.click();
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Amazon Sign In") );
	}
	
	//method to enter the email address
	
	public void enterUsername(String email) {
		emailInput.sendKeys(email);
		continueBtn.click();
	}
	
	//method to enter password
	
	public void enterPassword(String password) {
		passwordInput.sendKeys(password);
	signInBtn.click();
	}
	
	//method to verify successful login when puzzle message appears
	
	public void reachedPuzzleMessage() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(puzzleMessage));
		String mesg = puzzleMessage.getText();
		Assert.assertEquals(mesg, "Solve this puzzle to protect your account");
	}
	
	//verifying error message in case of invalid login credential
	
	public void checkInvalidMsg() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(invalidEmailMsg));
		String mesg = invalidEmailMsg.getText();
		Assert.assertEquals(mesg, "There was a problem");
	}
}
