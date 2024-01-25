package tipeandocodigo.com.TestClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tipeandocodigo.com.overview.POMS.AllCourses;
import tipeandocodigo.com.overview.POMS.HomePage;

import java.time.Duration;

public class AllCoursesTest {

    WebDriver driver;

    HomePage homePage;
    AllCourses allCourses;
    String baseURL = "https://www.letskodeit.com/";
    @BeforeClass
    public void setUp(){
        driver = WebDriverManager.chromedriver().create();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(baseURL);
        homePage = new HomePage(driver);
        allCourses = new AllCourses(driver);
    }


    @Test(priority = 1)
    public void testSearchCourses(){
        String username = "irving0689@hotmail.com";
        String password = "39FU8JV@CLxcX@h";
        String course = "JavaScript";
        homePage.clickOnSignInButton();
        homePage.login(username,password);
        homePage.validateSuccessfulLogIn();
        homePage.clickOnAllCoursesButton();
        allCourses.countCourses();
        allCourses.searchCourses(course);
        Assert.assertTrue(allCourses.validateSearch());
    }

    @Test(priority = 2)
    public void testFilterCourses(){
        homePage.clickOnAllCoursesButton();
        allCourses.selectAllFilters();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
