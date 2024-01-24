package tipeandocodigo.com.overview.POMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage {


    //Web elements
    private final String SIGNIN_BUTTON = "//div[@data-component='button']/a[contains(text(),'Sign In')]";
    private final String USERNAME_TEXTFIELD = "//input[@id='email']";
    private final String PASSWORD_TEXTFIELD = "//input[@id='login-password']";
    private final String LOGIN_BUTTON = "//button[@id='login']";
    private final String USER_AVATAR = "//img[@class='zl-navbar-rhs-img ']";
    private final String ALL_COURSES_BUTTON = "//li[@data-id='41189']/a[@href='/courses']";
    //Driver and constructor
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnSignInButton() {
        WebElement signInButton = driver.findElement(By.xpath(SIGNIN_BUTTON));
        signInButton.click();
    }

    public void login(String username, String password) {
        //filling username field
        WebElement userNameField = driver.findElement(By.xpath(USERNAME_TEXTFIELD));
        userNameField.click();
        userNameField.clear();
        userNameField.sendKeys(username);

        //filling password field
        WebElement passwordField = driver.findElement(By.xpath(PASSWORD_TEXTFIELD));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);

        WebElement loginButton = driver.findElement(By.xpath(LOGIN_BUTTON));
        loginButton.click();
    }

    public void validateSuccessfulLogIn() {
        WebElement avatar = driver.findElement(By.xpath(USER_AVATAR));
        Assert.assertNotNull(avatar);
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnAllCoursesButton(){
        WebElement allCoursesButton = driver.findElement(By.xpath(ALL_COURSES_BUTTON));
        allCoursesButton.click();
    }

}
