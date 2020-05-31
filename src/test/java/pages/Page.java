package pages;

import Browsers.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Page {
    public WebDriver driver = Browser.getBrowserInstance();
    public MmtHomePage mmtHomePage = PageFactory.initElements(driver, MmtHomePage.class);
    public LoginModalPage loginModalPage = PageFactory.initElements(driver, LoginModalPage.class);
    public HotelResultsPage hotelResultPage = PageFactory.initElements(driver, HotelResultsPage.class);
    public HotelDetailsPage hotelDetailsPage = PageFactory.initElements(driver, HotelDetailsPage.class);
    public ReviewYourBookingPage reviewYourBookingPage = PageFactory.initElements(driver, ReviewYourBookingPage.class);
    public BookingSummaryPage bokingSummaryPage = PageFactory.initElements(driver, BookingSummaryPage.class);
}
