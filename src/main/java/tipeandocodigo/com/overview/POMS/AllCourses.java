package tipeandocodigo.com.overview.POMS;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AllCourses {

    //Driver and constructor
    WebDriver driver;
    SearchBarPage searchBarPage;
    private final Log log = LogFactory.getLog(AllCourses.class);
    ResultPage resultPage;
    public AllCourses(WebDriver driver) {
        this.driver = driver;
    }

    //LOCATORS

    private final String DROPDOWN_MENU_COURSE_FILTER_OPTIONS = "//select[@name='categories']/option";
    private final String DROPDOWN_MENU = "//select[@name='categories']";

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
        log.info(resultPage.countElements());
    }

    public boolean validateSearch(){
        resultPage = new ResultPage(this.driver);
        return resultPage.resultSearch();
    }

    public void selectAllFilters(){
        WebElement dropdownMenu = driver.findElement(By.xpath(DROPDOWN_MENU));
        List<WebElement> dropDownMenuItems = driver.findElements(By.xpath(DROPDOWN_MENU_COURSE_FILTER_OPTIONS));
        if(resultPage == null){
            generateInstanceResultPage();
        }
        int numberOfElements = dropDownMenuItems.size();
        for(int i=0;i < numberOfElements;i++ ){
            dropdownMenu.click();
            dropDownMenuItems.get(i).click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("item number: "+i);
            log.info("has "+resultPage.countElements()+" courses");
            if(i>=1){
                dropdownMenu = driver.findElement(By.xpath(DROPDOWN_MENU));
                dropDownMenuItems = driver.findElements(By.xpath(DROPDOWN_MENU_COURSE_FILTER_OPTIONS));
            }
        }
    }
}
