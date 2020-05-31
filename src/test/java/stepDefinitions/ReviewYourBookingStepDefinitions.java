package stepDefinitions;

import Browsers.Browser;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import pages.Page;

import java.util.List;
import java.util.Map;

public class ReviewYourBookingStepDefinitions {
    private WebDriver driver = Browser.getBrowserInstance();
    private Page page = new Page();

    @And("I fill in traveller's information with below values")
    public void iFillInTravellerSInformationWithBelowValues(DataTable fields) {
        List<Map<String, String>> data = fields.asMaps(String.class, String.class);
        page.reviewYourBookingPage.setFirstName(data.get(0).get("FirstName"));
        page.reviewYourBookingPage.setLastName(data.get(0).get("LastName"));
//        page.reviewYourBookingPage.setEmail(data.get(0).get("Email"));
        page.reviewYourBookingPage.setMobileNumber(data.get(0).get("PhoneNumber"));
    }

    @And("I select below COMMONLY REQUESTED options")
    public void iSelectBelowCOMMONLYREQUESTEDOptions(DataTable fields) {
        List<Map<String, String>> data = fields.asMaps(String.class, String.class);
        for (int i = 0; i < data.size(); i++) {
            page.reviewYourBookingPage.selectSepecialRequest(data.get(i).get("SpecialServices"));
        }
    }

    @And("I uncheck Rs 5 to MMT foundation option")
    public void iUncheckRsToMMTFoundationOption() {
        page.reviewYourBookingPage.unCheckDonationOption();
    }

    @When("I click 'Pay Now' button on review your booking page")
    public void iClickPayNowButtonOnReviewYourBookingPage() {
        page.reviewYourBookingPage.clickPayNowButton();
    }
}
