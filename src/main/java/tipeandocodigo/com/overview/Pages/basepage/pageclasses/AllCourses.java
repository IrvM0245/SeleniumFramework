package tipeandocodigo.com.overview.Pages.basepage.pageclasses;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.GeneralUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tipeandocodigo.com.overview.Pages.basepage.CustomDriver;

import java.time.Duration;
import java.util.List;

public class AllCourses extends CustomDriver{

    //Driver and constructor
    public AllCourses(WebDriver driver) {
        super(driver);
    }
    SearchBarPage searchBarPage;
    private final Log log = LogFactory.getLog(AllCourses.class);
    ResultPage resultPage;


    //LOCATORS

    //private final String DROPDOWN_MENU_COURSE_FILTER_OPTIONS = "xpath=>//select[@name='categories']/option";
    private final String DROPDOWN_MENU_COURSE_FILTER_OPTIONS = "xpath=>//select[@name='categories']/option";
    private final String DROPDOWN_MENU = "xpath=>//select[@name='categories']";

    //METHODS
    private void generateInstanceSearchBarPage(){
        if(searchBarPage == null){
            searchBarPage = new SearchBarPage(this.getDriver());
        }
    }
    private void generateInstanceResultPage(){
        if(resultPage==null){
            resultPage = new ResultPage(this.getDriver());
        }
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
        generateInstanceResultPage();
        return resultPage.resultSearch();
    }
    public boolean validateSearch2(){
        WebElement dropdownMenu = getElement(DROPDOWN_MENU);
        WebDriverWait wait = new WebDriverWait(this.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(dropdownMenu));
        if(dropdownMenu.isDisplayed()){
            return true;
        }
        return false;
    }

    public void selectAllFilters() {
        WebElement dropdownMenu = getElement(DROPDOWN_MENU);
        List<WebElement> dropDownMenuItems = getElements(DROPDOWN_MENU_COURSE_FILTER_OPTIONS);
        if(resultPage == null){
            generateInstanceResultPage();
        }
        int numberOfElements = dropDownMenuItems.size();
        for(int i=0;i < numberOfElements;i++ ){
            dropdownMenu.click();
            dropDownMenuItems.get(i).click();
            GeneralUtils.Sleep(2000);
            GeneralUtils.logMessage("item number"+i,"info");
            GeneralUtils.logMessage("has "+resultPage.countElements()+" courses","info");
            if(i>=1){
                dropdownMenu = getElement(DROPDOWN_MENU);
                dropDownMenuItems = getElements(DROPDOWN_MENU_COURSE_FILTER_OPTIONS);
            }
        }
    }

    public void testingCode(){
        Actions actions = new Actions(this.getDriver());
        actions.pause(1000);

    }

}
