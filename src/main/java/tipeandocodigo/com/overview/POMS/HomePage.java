package tipeandocodigo.com.overview.POMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage {


    //Web elements
    private final String SIGNIN_BUTTON = "//a[@href='/login']";
    private final String USERNAME_TEXTFIELD = "//input[@id='email']";
    private final String PASSWORD_TEXTFIELD = "//input[@id='login-password']";
    private final String LOGIN_BUTTON = "//button[@id='login']";
    private final String USER_AVATAR = "//img[@class='zl-navbar-rhs-img ']";
    private final String ALL_COURSES_BUTTON = "//li[@data-id='41189']/a[@href='/courses']";
    private final String USER_MENU = "//button[@id='dropdownMenu1']";
    private final String LOG_OUT_OPTION = "//a[@href='/logout']";
    private final String LOG_IN_ERROR_LABEL = "//span[contains(text(),'The email must be a valid email address.')]";
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

    public void clickOnAllCoursesButton() {
        WebElement allCoursesButton = driver.findElement(By.xpath(ALL_COURSES_BUTTON));
        allCoursesButton.click();
    }

    public void validateSigInButton(){
        WebElement sigInButton = driver.findElement(By.xpath(SIGNIN_BUTTON));
        Assert.assertNotNull(sigInButton);
    }

    public void logOut() {
        WebElement userMenu = driver.findElement(By.xpath(USER_MENU));
        userMenu.click();

        WebElement logOutOption = driver.findElement(By.xpath(LOG_OUT_OPTION));
        logOutOption.click();
    }

    public void validateErrorMessageOnWrongLogin(){
        WebElement errorLabel = driver.findElement(By.xpath(LOG_IN_ERROR_LABEL));
        Assert.assertNotNull(errorLabel);
    }

}
