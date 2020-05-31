package stepDefinitions;

import Browsers.Browser;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.Page;

public class HotelDetailsStepDefinitions {
    private WebDriver driver = Browser.getBrowserInstance();
    private Page page = new Page();
    public String selectedRoomType;

    @And("I capture room type of {string}st available room")
    public void iCaptureRoomTypeOfStAvailableRoom(String roomIndex) {
        selectedRoomType = page.hotelDetailsPage.getRoomType(Integer.parseInt(roomIndex) - 1);
    }

    @When("I select {string}st available room")
    public void iSelectStAvailableRoom(String roomIndex) {
        page.hotelDetailsPage.selectAvailableRoom(Integer.parseInt(roomIndex) - 1);
    }
}
