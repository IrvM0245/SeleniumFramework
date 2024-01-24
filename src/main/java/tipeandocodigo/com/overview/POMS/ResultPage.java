package tipeandocodigo.com.overview.POMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ResultPage {
    WebDriver driver;
    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }

    //LOCATORS
    private final String COURSE_LIST_ITEMS = "//div[@id='course-list']/div/div/a";

    public boolean resultSearch(){
        WebElement courseList = driver.findElement(By.xpath(COURSE_LIST_ITEMS));
        return courseList.isDisplayed();
    }
}
