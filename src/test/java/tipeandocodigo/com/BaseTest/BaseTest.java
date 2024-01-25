package tipeandocodigo.com.BaseTest;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import tipeandocodigo.com.overview.POMS.AllCourses;
import tipeandocodigo.com.overview.POMS.HomePage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.Duration;

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
        driver = WebDriverManager.chromedriver().create();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
        //driver.quit();
    }
}
