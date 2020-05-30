package stepDefinitions;

import Browsers.Browser;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.Page;
import support.TestProperties;

public class MmtHomeStepDefinitions {
    private WebDriver driver = Browser.getBrowserInstance();
    private Page page = new Page();

    @Given("^I open MakeMyTrip in browser$")
    public void iOpenMakeMyTripInBrowser() {
        String mmtPageUrl = TestProperties.loadProperty().getProperty("url");
        driver.navigate().to(mmtPageUrl);
    }

    @When("I click on login button")
    public void iClickOnLoginButton() {
        page.mmtHomePage.clickLoginButton();
    }

    @When("I login to MakeMyTrip portal")
    public void iLoginToMakeMyTripPortal() {

    }
}
