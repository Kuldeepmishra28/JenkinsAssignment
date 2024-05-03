package cucumberSpec.StepDefinitions;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumberSpec.pages.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks  {
public static WebDriver driver;
	@Before
	public void initial() {
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
	}
	@After
	public void cleanUp() {
		driver.quit();
	}
	public static WebDriver getDriver() {
		return driver;
	}
}
