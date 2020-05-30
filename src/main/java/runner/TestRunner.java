package runner;


//import cucumber.api.junit.Cucumber;
//import cucumber.api.testng.AbstractTestNGCucumberTests;
//import org.junit.runner.RunWith;
//
//@RunWith(Cucumber.class)
//@cucumber.api.CucumberOptions(monochrome = true, features = "src/main/java/features", plugin = {
//		"json: cucumber_output/cucumber.json" }, glue = "stepDefinitions", tags = { "test1" })
//public class TestRunner extends AbstractTestNGCucumberTests {
//}


import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features", glue="stepDefinitions")
public class TestRunner {

}