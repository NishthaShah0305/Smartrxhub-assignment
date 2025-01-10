package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features"

, glue = "StepDefinitions", // This is the package where step definitions are defined
		plugin = { "pretty", "html:target/cucumber-reports.html" } 
)
public class TestRunner {
	// This class runs the Cucumber tests with the feature files in the specified
	// order.
}