package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = "stepDefinitions",
        plugin = {"pretty", "html:target/Destination", "json:target/cucumber.json"},
        tags = {"@test1"})
public class TestRunner {

}