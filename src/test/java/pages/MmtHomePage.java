package pages;

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

    @FindBy(how= How.XPATH, using = "//span[contains(text(), 'City / Hotel / Area / Building')]")
    public WebElement City;

    @FindBy(how = How.XPATH, using="//input[@placeholder='Enter city/ Hotel/ Area/ Building']")
    public WebElement PlaceInput;

    @FindBy(how= How.XPATH, using="//ul[@role='listbox']//li[1]")
    public WebElement PlaceBestSuggestion;

    @FindBy(how = How.XPATH, using = "//a[contains(text(), 'Search')]")
    public WebElement SearchBtn;


    public void clickLoginButton() {
        LoginBtn.click();
        CommonFunctions.waitForPageLoad(driver);
    }

    public void clickHotelsNavigationMenu(){
        HotelsBtn.click();
        CommonFunctions.waitForPageLoad(driver);
    }

    public void selectPlace(String placeName){
        CommonFunctions.scrollToElement(driver, City);
        City.click();
        CommonFunctions.waitForElementClickable(driver, PlaceInput);
        PlaceInput.sendKeys(placeName);
        CommonFunctions.clickWebElement(driver, PlaceBestSuggestion);
    }
}
