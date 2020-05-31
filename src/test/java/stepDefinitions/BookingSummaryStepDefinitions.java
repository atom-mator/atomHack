package stepDefinitions;

import Browsers.Browser;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.Page;

import java.util.List;
import java.util.Map;

public class BookingSummaryStepDefinitions {
    private WebDriver driver = Browser.getBrowserInstance();
    private Page page = new Page();
    public String selectedRoomType;

    @Then("I verify below information in Booking summary section")
    public void iVerifyBelowInformationInBookingSummarySection(DataTable fields) {
        List<Map<String, String>> data = fields.asMaps(String.class, String.class);
        String[] currentKeyValuePair;
        for (int i = 0; i < data.size(); i++) {
            currentKeyValuePair = data.get(i).values().toArray(new String[0]);
            switch (currentKeyValuePair[0].toUpperCase()) {

                case "HOTEL NAME":
                    //tbd
                    break;
                case "CHECKIN DATE":
                    //tbd
                    break;
                case "CHECKOUT DATE":
                    //tbd
                    break;
                case "NUMBER OF ROOMS":
                    //Assert.assertEquals(page.bokingSummaryPage.Rooms.size() , Integer.parseInt(currentKeyValuePair[1]));
                    break;
                case "ADULT GUESTS COUNT":
                    //tbd
                    break;
                case "CHILDREN GUESTS COUNT":
                    //tbd
                    break;
                case "ROOM TYPE":
                    //tbd
                    break;
                case "NAME":
                    Assert.assertEquals(page.bokingSummaryPage.getTravelerName(), currentKeyValuePair[1]);
                    break;
                case "PHONE NUMBER":
                    //tbd
                    break;
                case "EMAIL":
                    //tbd
                    break;
                default:
                    break;
            }
        }
    }
}
