package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import support.CommonFunctions;

import java.util.List;

public class ReviewYourBookingPage {
    private final WebDriver driver;

    public ReviewYourBookingPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "title")
    public WebElement Title;

    @FindBy(id = "fName")
    public WebElement FirstName;

    @FindBy(id = "lName")
    public WebElement LastName;

    @FindBy(id = "email")
    public WebElement Email;

    @FindBy(id = "mNo")
    public WebElement MobileNumber;

    @FindBy(how = How.XPATH, using = "//ul[contains(@class,'appendBottom')]//li")
    public List<WebElement> SpecialRequests;

    @FindBy(how = How.XPATH, using = "//label[@for='donation']")
    public WebElement DonationLabel;

    @FindBy(how = How.XPATH, using = "//*[text()='Pay Now']")
    public WebElement PayNowBtn;

    public void setFirstName(String firstName) {
        FirstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        LastName.sendKeys(lastName);
    }

    public void setEmail(String email) {
        Email.sendKeys(email);
    }

    public void setMobileNumber(String mobileNumber) {
        MobileNumber.sendKeys(mobileNumber);
    }

    public void selectSepecialRequest(String requestName) {
        for (int i = 0; i < SpecialRequests.size(); i++) {
            WebElement currnetLabel = SpecialRequests.get(i).findElement(By.xpath(".//label"));
            if (currnetLabel.getText().equalsIgnoreCase(requestName)) {
                if (currnetLabel.findElement(By.xpath(".//parent::span/input[@type='checkbox']")).getAttribute("checked") == null) {
                    CommonFunctions.clickWebElement(driver, currnetLabel);
                    CommonFunctions.waitForPageLoad(driver);
                }
            }
        }
    }

    public void unCheckDonationOption() {
        if (DonationLabel.findElement(By.xpath(".//parent::span/input[@type='checkbox']")).getAttribute("checked").equalsIgnoreCase("true")) {
            CommonFunctions.clickWebElement(driver, DonationLabel);
            CommonFunctions.waitForPageLoad(driver);
        }
    }

    public void clickPayNowButton() {
        CommonFunctions.clickWebElement(driver, PayNowBtn);
        CommonFunctions.waitForPageLoad(driver);
    }
}
