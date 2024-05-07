
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.testng.annotations.Test;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/cucumberSpec/features",
		glue="cucumberSpec.StepDefinitions",
		plugin= {"pretty","html:testResults/results.html"},
		tags="@login"
		)

@Test
public class TestRunner {

}
