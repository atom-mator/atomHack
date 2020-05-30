package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MmtHomePage {
    private final WebDriver driver;
    public MmtHomePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how = How.XPATH, using = "//li[@data-cy='account']")
    public WebElement LoginButton;

}
