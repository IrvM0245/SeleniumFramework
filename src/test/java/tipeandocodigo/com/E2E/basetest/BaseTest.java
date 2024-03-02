package tipeandocodigo.com.E2E.basetest;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import tipeandocodigo.com.overview.Pages.basepage.pageclasses.AllCourses;
import tipeandocodigo.com.overview.Pages.basepage.pageclasses.HomePage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static utilities.GeneralUtils.*;

public class BaseTest {
    public WebDriver driver;
    public  ExtentReports extentReport;
    public  ExtentTest extentTest;
    protected HomePage homePage;
    protected String username;
    protected String password;
    protected String course;
    protected AllCourses allCourses;
    private String baseURL = "https://www.letskodeit.com/";

    @BeforeClass
    public void baseSetUpData() {
        try {
            driver = WebDriverFactory.getInstance().getDriver("chrome");
            extentReport = new ExtentReports(System.getProperty("user.dir")+"Reports/TestReport_"+currentDate()+randomNumber(1000)+".html");
            extentTest = new ExtentTest("Open web page","Open the letskodeit web page");
            driver.get(baseURL);
            homePage = new HomePage(driver);
            allCourses = new AllCourses(driver);
            File file = new File("src/test/resources/data.json");
            FileReader reader = new FileReader(file);
            JsonElement element = JsonParser.parseReader(reader);
            if (element.isJsonObject()) {
                JsonObject jObject = element.getAsJsonObject();
                username = jObject.get("username").getAsString();
                password = jObject.get("password").getAsString();
                course = jObject.get("course").getAsString();
            }
        }
        catch (FileNotFoundException e){
            System.out.println("data.json not found");
        }
        catch (Exception e){
            System.out.println("The error: "+e.getMessage()+"\n");
            e.printStackTrace();
        }
    }

   @AfterClass
    public void baseTearDown(){
        WebDriverFactory.getInstance().quitDriver();
    }
}
