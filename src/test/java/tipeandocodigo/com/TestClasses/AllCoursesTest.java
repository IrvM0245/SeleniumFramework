package tipeandocodigo.com.TestClasses;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.json.Json;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tipeandocodigo.com.overview.POMS.AllCourses;
import tipeandocodigo.com.overview.POMS.HomePage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.Duration;
import java.util.List;

public class AllCoursesTest {

    WebDriver driver;
    HomePage homePage;
    String username;
    String password;
    String course;
    AllCourses allCourses;
    String baseURL = "https://www.letskodeit.com/";
    @BeforeTest
    public void setUp(){
        driver = WebDriverManager.chromedriver().create();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(baseURL);
        homePage = new HomePage(driver);
        allCourses = new AllCourses(driver);
    }
    @BeforeClass
    public void setUpData() throws FileNotFoundException {
        File file = new File("src/test/resources/data.json");
        FileReader reader = new FileReader(file);
        JsonElement element = JsonParser.parseReader(reader);
        if(element.isJsonObject()){
            JsonObject jObject = element.getAsJsonObject();
            username = jObject.get("username").getAsString();
            password = jObject.get("password").getAsString();
            course = jObject.get("course").getAsString();
        }
    }


    @Test(priority = 1)
    public void testSearchCourses(){
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
