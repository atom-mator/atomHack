package stepDefinitions;

import Browsers.Browser;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.Page;
import support.TestProperties;

public class mmtHomeStepDefinitions {
    private WebDriver driver = Browser.getBrowserInstance();
    private Page page = new Page();

    @When("^I open mmt in browser$")
    public void iOpenMmtInBrowser() {
        String mmtPageUrl = TestProperties.loadProperty().getProperty("url");
        driver.navigate().to(mmtPageUrl);
    }
}
