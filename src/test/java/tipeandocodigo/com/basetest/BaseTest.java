package tipeandocodigo.com.basetest;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import tipeandocodigo.com.overview.pageclasses.AllCourses;
import tipeandocodigo.com.overview.pageclasses.HomePage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class BaseTest {
    public WebDriver driver;
    protected HomePage homePage;
    protected String username;
    protected String password;
    protected String course;
    protected AllCourses allCourses;
    private String baseURL = "https://www.letskodeit.com/";

    @BeforeClass
    public void baseSetUpData() throws FileNotFoundException {
        driver = WebDriverFactory.getInstance().getDriver("chrome");
        driver.get(baseURL);
        homePage = new HomePage(driver);
        allCourses = new AllCourses(driver);
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

   @AfterClass
    public void baseTearDown(){
        WebDriverFactory.getInstance().quitDriver();
    }
}
