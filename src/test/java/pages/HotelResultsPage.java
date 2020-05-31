package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import support.CommonFunctions;

import java.util.List;


public class HotelResultsPage {
    private final WebDriver driver;

    public HotelResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "listingView")
    public WebElement ListingViewBanner;

    @FindBy(how = How.XPATH, using = "//div//*[contains(text(), 'Explore Hotels on Map')]")
    public WebElement ExploreHotelsOnMapLabel;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Select Filters')]")
    public WebElement SelectFilterLabel;

    @FindBy(how = How.XPATH, using = "//label[text()='4 & above (Very Good)']")
    public WebElement FourAndAboveLabel;

    @FindBy(id = "hotelListingContainer")
    public WebElement HotelListingContainer;

    @FindBy(how = How.XPATH, using = "//div[@class='priceGraph']//div[@class='blueBar']")
    public List<WebElement> PriceRangeBlueBar;

    @FindBy(how = How.XPATH, using = "//div[@class='input-range__slider']")
    public List<WebElement> SliderRange;

    @FindBy(how = How.XPATH, using = "//div[@class='mmBackdrop wholeBlack']")
    public WebElement PageGrayOut;

    public void clickFourAndAbove() {
        CommonFunctions.waitForElementClickable(driver, FourAndAboveLabel);
        this.closeMapView();
        if (FourAndAboveLabel.findElement(By.xpath(".//parent::span/input[@type='checkbox']")).getAttribute("checked") == null) {
            CommonFunctions.clickWebElement(driver, FourAndAboveLabel);
            CommonFunctions.waitForPageLoad(driver);
        }
    }

    public void closeMapView() {
//        if (driver.findElements(By.xpath("//div//*[contains(text(), 'Explore Hotels on Map')]")).size() != 0) {
//            CommonFunctions.clickWebElement(driver, SelectFilterLabel);
//            SelectFilterLabel.click();
//            SelectFilterLabel.click();
//            CommonFunctions.waitForPageLoad(driver);
//        }
        try {
            CommonFunctions.waitForPageLoad(driver);
            PageGrayOut.click();
        } catch (Exception e) {
        }
    }

    public String getSearchedHotelName(String index) {
        WebElement myhotel = HotelListingContainer.findElement(By.xpath(".//div[@id='Listing_hotel_" + index + "']//*[@id='hlistpg_hotel_name']"));
        return myhotel.getText();
    }

    public void selectHotel(String index) {
        WebElement myhotel = HotelListingContainer.findElement(By.id("Listing_hotel_" + index));
        myhotel.click();
        CommonFunctions.waitForPageLoad(driver);
    }

    public void selectMinimumPriceRange(String minAmount) throws InterruptedException {
        CommonFunctions.waitForPageLoad(driver);
        int maxRange = 30000;
        Thread.sleep(6000);
        int difference = maxRange / PriceRangeBlueBar.size();
        int sliderDiff = Integer.parseInt(minAmount) / difference;

        int offset = (int) Math.round(sliderDiff * 3.33);
        Actions move = new Actions(driver);
        Action action = (Action) move.dragAndDropBy(SliderRange.get(0), offset, 0).build();
        action.perform();
        CommonFunctions.waitForPageLoad(driver);
    }
}
