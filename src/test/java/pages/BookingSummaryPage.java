package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class BookingSummaryPage {
    private final WebDriver driver;
    public BookingSummaryPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how = How.CSS, using = "div[class='summary_description'] [class*='hotel_name']")
    public WebElement HotelName;

    @FindBy(how = How.CSS, using="//div[@class='summary_description']//p[@class='checkin_time']")
    public List<WebElement> BookingDates;

    @FindBy(how = How.CSS, using="span[class*='room_info '] span")
    public List<WebElement> Rooms;

    @FindBy(how = How.CSS, using="div[class*='traveler_details '] *[class*='traveler_name']")
    public WebElement TravelerName;

    public String getTravelerName(){
        return TravelerName.getText();
    }

}
