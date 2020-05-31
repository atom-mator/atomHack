package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import support.CommonFunctions;

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

    public void clickHotelsNavigationMenu() {
        CommonFunctions.waitForPageLoad(driver);
        HotelsBtn.click();
        CommonFunctions.waitForPageLoad(driver);
    }

    public void selectPlace(String placeName) {
        CommonFunctions.scrollToElement(driver, City);
        City.click();
        CommonFunctions.waitForElementClickable(driver, PlaceInput);
        PlaceInput.sendKeys(placeName);
        CommonFunctions.clickWebElement(driver, PlaceBestSuggestion);
//        PlaceBestSuggestion.click();
        CommonFunctions.waitForPageLoad(driver);
    }

    public void selectTravelFor(String reason) {
        CommonFunctions.waitForPageLoad(driver);
        TravellingFor.click();
        CommonFunctions.waitForElementClickable(driver, TravelForPopup);
        WebElement selectThisReason = TravelForPopup.findElement(By.xpath("./li[contains(text(), '" + reason + "')]"));
        selectThisReason.click();
        CommonFunctions.waitForPageLoad(driver);
    }

    public void clickSearchButton() {
        SearchBtn.click();
        CommonFunctions.waitForPageLoad(driver);
    }

    public void selectRoomsAndGuests(String roomsCnt, String adultCnt, String childrenCnt) {
        CommonFunctions.waitForPageLoad(driver);
        Guest.click();
        CommonFunctions.waitForPageLoad(driver);

        WebElement adultCntElement = AdultRange.findElement(By.xpath(".//li[text()='" + adultCnt + "']"));
        adultCntElement.click();

        WebElement childrenCntElement = ChildrenRange.findElement(By.xpath(".//li[text()='" + childrenCnt + "']"));
        childrenCntElement.click();

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
