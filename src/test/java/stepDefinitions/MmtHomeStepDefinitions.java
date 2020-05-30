package stepDefinitions;

import Browsers.Browser;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.Page;
import support.CommonFunctions;
import support.TestProperties;

public class MmtHomeStepDefinitions {
    private WebDriver driver = Browser.getBrowserInstance();
    private Page page = new Page();

    @Given("^I open MakeMyTrip in browser$")
    public void iOpenMakeMyTripInBrowser() {
        String mmtPageUrl = TestProperties.loadProperty().getProperty("url");
        driver.navigate().to(mmtPageUrl);
    }

    @When("I login to MakeMyTrip portal")
    public void iLoginToMakeMyTripPortal() {
        page.mmtHomePage.clickLoginButton();
        page.loginModalPage.setUserName("ps.leo26@gmail.com");
        page.loginModalPage.clickContinueButton();
        page.loginModalPage.setPassword("welcome@123");
        page.loginModalPage.clickLoginButton();
        CommonFunctions.waitForElementClickable(driver, page.mmtHomePage.SearchBtn);
    }

    @And("I select {string} navigation menu")
    public void iSelectNavigationMenu(String navMenu) {
        switch(navMenu.toUpperCase()){
            case "HOTELS":
                page.mmtHomePage.clickHotelsNavigationMenu();
                break;
            default:
                Assert.fail("Navigation Menu [" + navMenu +"] is not defined.");
        }
    }

    @And("I select place {string}")
    public void iSelectPlace(String place) {
        page.mmtHomePage.selectPlace(place);
    }
}
