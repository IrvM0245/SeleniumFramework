package tipeandocodigo.com.overview.POMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tipeandocodigo.com.overview.base.CustomDriver;

import java.util.List;

public class ResultPage {
    WebDriver driver;
    CustomDriver customDriver;
    public ResultPage(WebDriver driver) {
        this.driver = driver;
        customDriver = new CustomDriver(this.driver);
    }

    //LOCATORS
    private final String COURSE_LIST_ITEMS = "xpath=>//div[@id='course-list']/div/div/a";
    private final String COMPLETE_COURSE_LIST = "xpath=>//div[@class='zen-course-list']/a";


    public boolean resultSearch(){
        //WebElement courseListItem = driver.findElement(By.xpath(COURSE_LIST_ITEMS));
        //return courseListItem.isDisplayed();
        return customDriver.getElement(COURSE_LIST_ITEMS).isDisplayed();
    }

    public int countElements(){
        //List<WebElement> courseList =  driver.findElements(By.xpath(COMPLETE_COURSE_LIST));
        return customDriver.getElements(COMPLETE_COURSE_LIST).size();
    }
}
