package stepDefinitions;

import Browsers.Browser;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pages.Page;
import support.CommonFunctions;
import support.TestProperties;

import java.util.List;

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
        switch (navMenu.toUpperCase()) {
            case "HOTELS":
                page.mmtHomePage.clickHotelsNavigationMenu();
                break;
            default:
                Assert.fail("Navigation Menu [" + navMenu + "] is not defined.");
        }
    }

    @And("I select place {string}")
    public void iSelectPlace(String place) {
        page.mmtHomePage.selectPlace(place);
    }

    @And("I select reason for travelling {string}")
    public void iSelectReasonForTravelling(String travelReason) {
        page.mmtHomePage.selectTravelFor(travelReason);
    }

    @Then("I click on Search button")
    public void iClickOnSearchButton() {
        page.mmtHomePage.clickSearchButton();
    }

    @And("I select {string} rooms for {string} adults and {string} children each")
    public void iSelectRoomsForAdultsAndChildrenEach(String roomsCnt, String adultCnt, String childrenCnt) {
        page.mmtHomePage.selectRoomsAndGuests(roomsCnt, adultCnt, childrenCnt);
    }

}
