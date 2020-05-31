package stepDefinitions;

import Browsers.Browser;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import pages.Page;
import support.CommonFunctions;

import java.util.List;

public class HotelResultStepDefinitions {
    private WebDriver driver = Browser.getBrowserInstance();
    private Page page = new Page();
    public String selectedHotelName;

    @And("I select User rating {string}")
    public void iSelectUserRating(String RatingSelection) {
        page.hotelResultPage.clickFourAndAbove();
    }

    @And("I capture name of {string}th listed hotel from the top")
    public void iCaptureNameOfListedHotelFromTheTop(String index) {
        index = Integer.toString(Integer.parseInt(index) - 1);
        selectedHotelName = page.hotelResultPage.getSearchedHotelName(index);
        System.out.println(selectedHotelName);
    }

    @And("I select {string}th listed hotel from the top")
    public void iSelectListedHotelFromTheTop(String index) {
        index = Integer.toString(Integer.parseInt(index) - 1);
        page.hotelResultPage.selectHotel(index);
        CommonFunctions.switchToBrowserTab(driver, 1);
        CommonFunctions.waitForPageLoad(driver);
    }

    @When("I select min price range to {string} INR")
    public void iSelectMinPriceRangeToINR(String amount) throws InterruptedException {
        page.hotelResultPage.selectMinimumPriceRange(amount);
    }
}
