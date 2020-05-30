package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginModalPage {
    private final WebDriver driver;
    public LoginModalPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "username")
    public WebElement UserName;

}
