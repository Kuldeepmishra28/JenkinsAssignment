package cucumberSpec.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchProduct  {

	private WebDriver driver;
	public SearchProduct(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="twotabsearchtextbox")
    WebElement searchBox; 
	@FindBy(id = "nav-logo-sprites")
	WebElement logo;
    @FindBy(id="nav-search-submit-button")
    WebElement searchButton;
    @FindBy(xpath ="//div[@data-component-type='s-search-result']")
	WebElement searchResults;
    @FindBy(className="sg-col-inner")
    WebElement errorMsg;
    
    //method to verify current page is home page or not by checking logo
    
       public void onHomepage() {
			Assert.assertTrue(logo.isDisplayed());
		}
    
    	//method to enter product name and entering search button
		public void searchInput(String item) {
			searchBox.sendKeys(item);
			searchButton.click();
		}
		
		//method to verify whether searched product displayed or not by using locator 
		
		public void searchResultAvailable() {
			Assert.assertTrue(searchResults.isDisplayed()); ;
		}
		
		//method to verify whether invalid product name displayed error message
		
	    public void isErrorDisplayed() {
		  String text=errorMsg.getText();
		  Assert.assertTrue(text.contains("No results"));
	  }
	
}
