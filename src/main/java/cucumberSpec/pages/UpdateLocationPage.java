package cucumberSpec.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UpdateLocationPage {
	private WebDriver driver;
	//page object model containing elements and web page implementation of delivery location page
	CommonFunctionality commonObj=new CommonFunctionality();
	public UpdateLocationPage(WebDriver driver ) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="glow-ingress-line2")
	WebElement locationBtn;
	
	@FindBy(id="GLUXZipUpdateInput")
	WebElement pincodeInput;
	@FindBy(id = "nav-logo-sprites")
	WebElement logo;
	
	@FindBy(id="GLUXZipUpdate")
	WebElement applyBtn;
	
	@FindBy(id="GLUXZipError")
	WebElement errorMsg;

	//method to verify that current page is home page or not by verifying logo
	public void onHomepage() {
		Assert.assertTrue(logo.isDisplayed());
	}
	
	//click on the location update button
	
	public void clickedLocationUpdateButton() {
		locationBtn.click();
		Assert.assertTrue(locationBtn.isDisplayed());
	}
	
	//method to enter pincode of the location and applying
	
	public void enterPincode(String pincode) {
		commonObj.waitFun(driver, pincodeInput);
		pincodeInput.sendKeys(pincode);
		applyBtn.click();
	}
	
	//method to verify whether entered pincode updated 
	
	public void isLocationUpdated(String pincode) {

		 Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			wait.until(ExpectedConditions.textToBePresentInElement(locationBtn,pincode));
		String pincodeTitle=locationBtn.getText();
		Assert.assertTrue(pincodeTitle.contains(String.valueOf(pincode)));
		
	}
	
	//method to verify that invalid pincode gets error
	
	public void isUpdationFailed() {
		commonObj.waitFun(driver, errorMsg);
		Assert.assertTrue(errorMsg.isDisplayed());
	}
	
	
	
}
