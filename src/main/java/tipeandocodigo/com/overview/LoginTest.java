package tipeandocodigo.com.overview;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;


public class LoginTest {
    WebDriver driver;
    WebElement signInButton;
    WebElement userTextField;
    WebElement passwordTextField;
    WebElement loginButton;
    WebElement userImage;

    @BeforeClass
    private void beforeMethod(){
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = WebDriverManager.chromedriver().create();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.letskodeit.com/");
        signInButton = driver.findElement(
                By.xpath("//div[@data-component='button']/a[contains(text(),'Sign In')]")
        );
    }

    @Test
    public void testLogin(){
        signInButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        userTextField = driver.findElement(
                By.xpath("//input[@id='email']")
        );
        passwordTextField = driver.findElement(
                By.xpath("//input[@id='login-password']")
        );
        userTextField.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        userTextField.clear();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        userTextField.sendKeys("irving0689@hotmail.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        passwordTextField.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        passwordTextField.clear();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        passwordTextField.sendKeys("39FU8JV@CLxcX@h");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        loginButton = driver.findElement(By.xpath("//button[@id='login']"));
        loginButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        userImage = driver.findElement(By.xpath("//img[@class='zl-navbar-rhs-img ']"));
        Assert.assertNotNull(userImage);
    }

}
