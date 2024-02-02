package tipeandocodigo.com.overview.pageclasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tipeandocodigo.com.overview.basepage.CustomDriver;


public class SearchBarPage extends CustomDriver{

    public SearchBarPage(WebDriver driver) {
        super(driver);
    }
    private final String SEARCH_BAR = "xpath=>//input[@id=\"search\"]";

    public void searchCourse(String course){
        WebElement searchBar = getElement(SEARCH_BAR);
        searchBar.click();
        searchBar.clear();
        searchBar.sendKeys(course);
        searchBar.sendKeys(Keys.ENTER);
    }
}
