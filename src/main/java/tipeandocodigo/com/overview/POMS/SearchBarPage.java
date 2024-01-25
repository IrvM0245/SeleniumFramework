package tipeandocodigo.com.overview.POMS;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchBarPage {

    WebDriver driver;
    public SearchBarPage(WebDriver driver) {
        this.driver = driver;
    }
    private final String SEARCH_BAR = "//input[@id='search']";

    public void searchCourse(String course){
        WebElement searchBar = driver.findElement(By.xpath(SEARCH_BAR));
        searchBar.click();
        searchBar.clear();
        searchBar.sendKeys(course);
        searchBar.sendKeys(Keys.ENTER);
    }
}
