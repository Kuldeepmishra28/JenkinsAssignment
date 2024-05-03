package cucumberSpec.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctionality {

	//providing wait method for the functionalities requiring visibility of an element before execution
	public void waitFun(WebDriver driver, WebElement element ) {
		 Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			wait.until(ExpectedConditions.visibilityOf(element));
	}
}
