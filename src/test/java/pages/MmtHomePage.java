package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import support.CommonFunctions;

import java.net.ConnectException;

public class MmtHomePage {
    private final WebDriver driver;

    public MmtHomePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how = How.XPATH, using = "//li[@data-cy='account']")
    public WebElement LoginBtn;

    @FindBy(how = How.CSS, using = "li[class*='menu_Hotels']")
    public WebElement HotelsBtn;

    @FindBy(how = How.XPATH, using = "//span[contains(text(), 'City / Hotel / Area / Building')]")
    public WebElement City;

    @FindBy(how = How.XPATH, using = "//span[contains(text(), 'Travelling For')]")
    public WebElement TravellingFor;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='Enter city/ Hotel/ Area/ Building']")
    public WebElement PlaceInput;

    @FindBy(how = How.XPATH, using = "//ul[@role='listbox']//li[1]")
    public WebElement PlaceBestSuggestion;

    @FindBy(how = How.CSS, using = "ul[class='travelForPopup']")
    public WebElement TravelForPopup;

    @FindBy(how = How.XPATH, using = "//p//*[contains(text(), 'Search')]")
    public WebElement SearchBtn;

    @FindBy(id = "guest")
    public WebElement Guest;

    @FindBy(how = How.CSS, using = "ul[class*='guestCounter']:nth-of-type(1)")
    public WebElement AdultRange;

    @FindBy(how = How.CSS, using = "ul[class*='guestCounter']:nth-of-type(2)")
    public WebElement ChildrenRange;

    @FindBy(how = How.XPATH, using = "//button[contains(text(), '+ ADD ANOTHER ROOM')]")
    public WebElement AddAnotherRoomBtn;

    @FindBy(how = How.XPATH, using = "//button[text()='APPLY']")
    public WebElement ApplyRoomBtn;

    public void clickLoginButton() {
        LoginBtn.click();
        CommonFunctions.waitForPageLoad(driver);
    }

    public void clickHotelsNavigationMenu() throws InterruptedException {
        CommonFunctions.waitForPageLoad(driver);
        CommonFunctions.waitForElementClickable(driver, HotelsBtn);
        Thread.sleep(6000);
        CommonFunctions.clickWebElement(driver, HotelsBtn);
        CommonFunctions.waitForPageLoad(driver);
    }

    public void selectPlace(String placeName) {
        CommonFunctions.scrollToElement(driver, City);
        CommonFunctions.clickWebElement(driver, City);
        CommonFunctions.waitForElementClickable(driver, PlaceInput);
        PlaceInput.sendKeys(placeName);
        CommonFunctions.clickWebElement(driver, PlaceBestSuggestion);
        CommonFunctions.waitForPageLoad(driver);
    }

    public void selectTravelFor(String reason) {
        CommonFunctions.waitForPageLoad(driver);
        CommonFunctions.clickWebElement(driver, TravellingFor);
        CommonFunctions.waitForElementClickable(driver, TravelForPopup);
        WebElement selectThisReason = TravelForPopup.findElement(By.xpath("./li[contains(text(), '" + reason + "')]"));
        CommonFunctions.clickWebElement(driver, selectThisReason);
        CommonFunctions.waitForPageLoad(driver);
    }

    public void clickSearchButton() {
        CommonFunctions.clickWebElement(driver, SearchBtn);
        CommonFunctions.waitForPageLoad(driver);
    }

    public void selectRoomsAndGuests(String roomsCnt, String adultCnt, String childrenCnt) {
        CommonFunctions.waitForPageLoad(driver);
        CommonFunctions.clickWebElement(driver, Guest);
        CommonFunctions.waitForPageLoad(driver);

        WebElement adultCntElement = AdultRange.findElement(By.xpath(".//li[text()='" + adultCnt + "']"));
        CommonFunctions.clickWebElement(driver, adultCntElement);

        WebElement childrenCntElement = ChildrenRange.findElement(By.xpath(".//li[text()='" + childrenCnt + "']"));
        CommonFunctions.clickWebElement(driver, childrenCntElement);

        for (int i = Integer.parseInt(roomsCnt); i > 1; i--) {
            CommonFunctions.clickWebElement(driver, AddAnotherRoomBtn);
            CommonFunctions.waitForPageLoad(driver);

            WebElement adultCntElementTemp = AdultRange.findElement(By.xpath(".//li[text()='" + adultCnt + "']"));
            CommonFunctions.clickWebElement(driver ,adultCntElementTemp);

            WebElement childrenCntElementTemp = ChildrenRange.findElement(By.xpath(".//li[text()='" + childrenCnt + "']"));
            CommonFunctions.clickWebElement(driver, childrenCntElementTemp);
        }
        CommonFunctions.clickWebElement(driver, ApplyRoomBtn);
        CommonFunctions.waitForPageLoad(driver);
}
}
