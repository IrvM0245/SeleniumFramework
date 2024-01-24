package tipeandocodigo.com.overview.POMS;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchBarPage {

    WebDriver driver;
    public SearchBarPage(WebDriver driver) {
        this.driver = driver;
    }

    private final String SEARCH_BAR = "//li[@data-id='41189']/a[@href='/courses']";

    public void searchCourse(String course){
        WebElement searchBar = driver.findElement(By.xpath("//input[@id='search']"));
        searchBar.click();
        searchBar.clear();
        searchBar.sendKeys(course);
        searchBar.sendKeys(Keys.ENTER);
    }
}
