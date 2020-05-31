package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import support.CommonFunctions;

import java.util.List;

public class HotelDetailsPage {
    private final WebDriver driver;

    public HotelDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how = How.XPATH, using = "//div[@class='roomWrap']")
    public List<WebElement> AvailableRoomsList;

    public String getRoomType(Integer roomIndex){
        return AvailableRoomsList.get(roomIndex).findElement(By.xpath(".//h2")).getText();
    }

    public void selectAvailableRoom(Integer roomIndex){
        List<WebElement> myRooms = AvailableRoomsList.get(roomIndex).findElements(By.xpath(".//a[text()='SELECT ROOM']"));
        CommonFunctions.clickWebElement(driver, myRooms.get(0));
    }
}
