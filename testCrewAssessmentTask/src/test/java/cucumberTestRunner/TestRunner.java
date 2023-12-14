package cucumberTestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Listeners;


@CucumberOptions(
		features = {"src/test/resources/ValidateSubscriptionPackages.feature"}
		,glue="cucumberSteps"
)
	@Listeners({com.shaft.listeners.TestNGListener.class})
	public class TestRunner extends AbstractTestNGCucumberTests {
	}
