package tipeandocodigo.com.overview.POMS;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllCourses {

    //Driver and constructor
    WebDriver driver;
    SearchBarPage searchBarPage;
    ResultPage resultPage;
    public AllCourses(WebDriver driver) {
        this.driver = driver;
    }

    //LOCATORS


    //METHODS

    public void searchCourses(String course){
        searchBarPage = new SearchBarPage(this.driver);
        searchBarPage.searchCourse(course);
    }

    public boolean validateSearch(){
        resultPage = new ResultPage(this.driver);
        return resultPage.resultSearch();
    }
}
