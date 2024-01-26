package tipeandocodigo.com.overview.POMS;

import Utilities.GeneralUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tipeandocodigo.com.overview.base.CustomDriver;

import java.util.List;

public class AllCourses {

    //Driver and constructor
    WebDriver driver;
    CustomDriver customDriver;
    SearchBarPage searchBarPage;
    private final Log log = LogFactory.getLog(AllCourses.class);
    ResultPage resultPage;
    public AllCourses(WebDriver driver) {
        this.driver = driver;
        customDriver = new CustomDriver(driver);
    }

    //LOCATORS

    private final String DROPDOWN_MENU_COURSE_FILTER_OPTIONS = "xpath=>//select[@name='categories']/option";
    private final String DROPDOWN_MENU = "xpath=>//select[@name='categories']";

    //METHODS
    private void generateInstanceSearchBarPage(){
        searchBarPage = new SearchBarPage(this.driver);
    }
    private void generateInstanceResultPage(){
        resultPage = new ResultPage(this.driver);
    }
    public void searchCourses(String course){
        if(searchBarPage==null){
            generateInstanceSearchBarPage();
        }
        searchBarPage.searchCourse(course);
    }
    public void countCourses(){
        generateInstanceResultPage();
        GeneralUtils.logMessage("Course number: "+resultPage.countElements(),"info");
    }

    public boolean validateSearch(){
        resultPage = new ResultPage(this.driver);
        return resultPage.resultSearch();
    }

    public void selectAllFilters() {
        WebElement dropdownMenu = customDriver.getElement(DROPDOWN_MENU);
        List<WebElement> dropDownMenuItems = customDriver.getElements(DROPDOWN_MENU_COURSE_FILTER_OPTIONS);
        if(resultPage == null){
            generateInstanceResultPage();
        }
        int numberOfElements = dropDownMenuItems.size();
        for(int i=0;i < numberOfElements;i++ ){
            dropdownMenu.click();
            dropDownMenuItems.get(i).click();
            GeneralUtils.Sleep();
            GeneralUtils.logMessage("item number"+i,"info");
            GeneralUtils.logMessage("has "+resultPage.countElements()+" courses","info");
            if(i>=1){
                dropdownMenu = customDriver.getElement(DROPDOWN_MENU);
                dropDownMenuItems = customDriver.getElements(DROPDOWN_MENU_COURSE_FILTER_OPTIONS);
            }
        }
    }
}
