package stepDefinitions;

import Browsers.Browser;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {

    static final Logger logger = Logger.getLogger(Hooks.class);
    private WebDriver driver;


    @Before()
    public void beforeTest() {

        Browser.initBrowser();
    }

    @After()
    public void afterTest(Scenario scenario) {
        if (Browser.driver != null) {
            if (scenario.isFailed()) {
                takeScreenshot(scenario);
            }
            Browser.closeBrowser();
        }
    }

    public void takeScreenshot(Scenario myScenario) {
        try {
            driver = Browser.getBrowserInstance();
            myScenario.write("Current Page URL is " + driver.getCurrentUrl());
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            myScenario.embed(screenshot, "image/png");
        } catch (Exception e) {
            BasicConfigurator.configure();
            logger.debug("Nothing to capture");
        }

    }
}
