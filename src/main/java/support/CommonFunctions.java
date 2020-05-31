package support;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class CommonFunctions {
    static final Logger logger = Logger.getLogger(CommonFunctions.class);

    public static void waitForPageLoad(WebDriver driver) {
        try {
            ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return (((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
                            .equals("complete")
                            && (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active == 0"));
                }
            };

            WebDriverWait wait = new WebDriverWait(driver,
                    Integer.parseInt(TestProperties.loadProperty().getProperty("browser.ExplicitDriverWait")));
            wait.until(expectation);
            Thread.sleep(5000);
        } catch (Exception e) {

        }
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        try {
            waitForElementVisible(driver, element);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            logger.debug(e.getMessage());
        }
    }

    public static void waitForElementVisible(WebDriver driver, WebElement element) {
        try {
            long timeoutSec = Long
                    .parseLong(TestProperties.loadProperty().get("browser.ExplicitDriverWait").toString());
            (new WebDriverWait(driver, timeoutSec)).until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            logger.debug(e.getMessage());
        }
    }

    public static void waitForElementClickable(WebDriver driver, WebElement element) {
        try {
            long timeoutSec = Long
                    .parseLong(TestProperties.loadProperty().get("browser.ExplicitDriverWait").toString());
            (new WebDriverWait(driver, timeoutSec)).until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            logger.debug(e.getMessage());
        }
    }

    public static void waitForElementNotVisible(WebDriver driver, WebElement element) {
        try {
            long timeoutSec = Long
                    .parseLong(TestProperties.loadProperty().get("browser.ExplicitDriverWait").toString());
            (new WebDriverWait(driver, timeoutSec)).until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception e) {
            logger.debug(e.getMessage());
        }

    }

    public static void clickWebElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String webElementText = element.getText();
        try {
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            CommonFunctions.waitForElementClickable(driver, element);
            js.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            logger.debug(e.getMessage());
        }
    }

    public static void switchToBrowserTab(WebDriver driver, int index) {
        try {
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(index));
            Thread.sleep(500);
            waitForPageLoad(driver);
        } catch (Exception e) {
            logger.debug(e);
        }
    }
}
