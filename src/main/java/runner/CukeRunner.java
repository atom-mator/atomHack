package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, features = "src/test/java/features", plugin = {
		"json: cucumber_output/cucumber.json" }, glue = "stepDefinitions", tags = { "" })
public class CukeRunner extends AbstractTestNGCucumberTests {
}
