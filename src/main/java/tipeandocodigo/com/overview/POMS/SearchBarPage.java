package tipeandocodigo.com.overview.POMS;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tipeandocodigo.com.overview.base.CustomDriver;


public class SearchBarPage {

    WebDriver driver;
    CustomDriver customDriver;
    public SearchBarPage(WebDriver driver) {
        this.driver = driver;
        customDriver = new CustomDriver(this.driver);
    }
    private final String SEARCH_BAR = "xpath=>//input[@id=\"search\"]";

    public void searchCourse(String course){
        WebElement searchBar = customDriver.getElement(SEARCH_BAR);
        searchBar.click();
        searchBar.clear();
        searchBar.sendKeys(course);
        searchBar.sendKeys(Keys.ENTER);
    }
}
