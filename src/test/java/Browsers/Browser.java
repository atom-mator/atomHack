package Browsers;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import support.TestProperties;

public class Browser {

    private Browser() {

    }

    static final Logger logger = Logger.getLogger(Browser.class);
    public static WebDriver driver;

    public static String binaryURL = TestProperties.loadProperty().getProperty("driver.binaries.path");
    public static String browserBit = TestProperties.loadProperty().getProperty("browserBit");
    public static String operatingSystem = TestProperties.loadProperty().getProperty("operatingSystem");
    public static String browserName = TestProperties.loadProperty().getProperty("browserName");
    public static int globalTimeout = Integer.parseInt(TestProperties.loadProperty().getProperty("browser.ExplicitDriverWait"));

    public static void initBrowser() {
        startLocalDriver();
        driver.manage().timeouts().implicitlyWait(globalTimeout, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static WebDriver getBrowserInstance() {
        if (driver == null) {
            initBrowser();
        }
        return driver;
    }

    public static void closeBrowser() {
        driver.quit();
    }

    public static void startLocalDriver() {
        String executable = browserName;
        if (operatingSystem.equalsIgnoreCase("windows")) {
            executable = executable + ".exe";
        }

        switch (browserName.toLowerCase()) {

            case "chromedriver":
                System.setProperty("webdriver.chrome.driver",
                        binaryURL + "/" + operatingSystem + "/" + browserBit + "/" + executable);
                driver = new ChromeDriver();
                break;
            case "geckodriver":
            case "firefoxdriver":
                System.setProperty("webdriver.gecko.driver",
                        binaryURL + "/" + operatingSystem + "/" + browserBit + "/" + executable);
                driver = new FirefoxDriver();
                break;
        }
    }

    public static Capabilities capabilities() {
        Capabilities browserSettings = null;
        switch (browserName.toLowerCase()) {
            case "chromedriver":
                browserSettings = DesiredCapabilities.chrome();
                break;
            case "geckodriver":
            case "firefoxdriver":
                browserSettings = DesiredCapabilities.firefox();
                break;
        }
        return browserSettings;
    }
}
