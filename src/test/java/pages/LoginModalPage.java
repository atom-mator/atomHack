package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import support.CommonFunctions;

public class LoginModalPage {
    private final WebDriver driver;

    public LoginModalPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "username")
    public WebElement UserName;

    @FindBy(how = How.XPATH, using = "//section[@class='modalMain ']//button/span[contains(text(), 'Continue')]")
    public WebElement ContinueBtn;

    @FindBy(id = "password")
    public WebElement Password;

    @FindBy(how = How.XPATH, using = "//section[@class='modalMain ']//button/span[contains(text(), 'Login')]")
    public WebElement LoginBtn;

    public void setUserName(String userName) {
        UserName.sendKeys(userName);
    }

    public void clickContinueButton(){
        CommonFunctions.waitForElementClickable(driver, ContinueBtn);
        ContinueBtn.click();
        ContinueBtn.click();
        CommonFunctions.waitForPageLoad(driver);
    }

    public void setPassword(String password) {
        Password.sendKeys(password);
    }

    public void clickLoginButton(){
        CommonFunctions.waitForElementClickable(driver, LoginBtn);
        CommonFunctions.clickWebElement(driver, LoginBtn);
        CommonFunctions.waitForPageLoad(driver);
    }
}
