package tipeandocodigo.com.overview.POMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResultPage {
    WebDriver driver;
    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }

    //LOCATORS
    private final String COURSE_LIST_ITEMS = "//div[@id='course-list']/div/div/a";
    private final String COMPLETE_COURSE_LIST = "//div[@class='zen-course-list']/a";


    public boolean resultSearch(){
        WebElement courseListItem = driver.findElement(By.xpath(COURSE_LIST_ITEMS));
        return courseListItem.isDisplayed();
    }

    public int countElements(){
        List<WebElement> courseList =  driver.findElements(By.xpath(COMPLETE_COURSE_LIST));
        return courseList.size();
    }
}
