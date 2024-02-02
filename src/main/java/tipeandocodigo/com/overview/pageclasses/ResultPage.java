package tipeandocodigo.com.overview.pageclasses;

import org.openqa.selenium.WebDriver;
import tipeandocodigo.com.overview.basepage.CustomDriver;

public class ResultPage extends CustomDriver{
    public ResultPage(WebDriver driver) {
        super(driver);
    }

    //LOCATORS
    private final String COURSE_LIST_ITEMS = "xpath=>//div[@id='course-list']/div/div/a";
    private final String COMPLETE_COURSE_LIST = "xpath=>//div[@class='zen-course-list']/a";


    public boolean resultSearch(){
        return getElement(COURSE_LIST_ITEMS).isDisplayed();
    }

    public int countElements(){
        return getElements(COMPLETE_COURSE_LIST).size();
    }
}
