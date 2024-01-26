package tipeandocodigo.com.overview.POMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import tipeandocodigo.com.overview.base.CustomDriver;

public class HomePage {

    CustomDriver customDriver;

    //Web elements
    private final String SIGNIN_BUTTON = "xpath=>//a[@href='/login']";
    private final String USERNAME_TEXTFIELD = "xpath=>//input[@id='email']";
    private final String PASSWORD_TEXTFIELD = "id=>login-password";
    private final String LOGIN_BUTTON = "id=>login";
    private final String USER_AVATAR = "xpath=>//img[@class='zl-navbar-rhs-img ']";
    private final String ALL_COURSES_BUTTON = "xpath=>//li[@data-id='41189']/a[@href='/courses']";
    private final String USER_MENU = "id=>dropdownMenu1";
    private final String LOG_OUT_OPTION = "xpath=>//a[@href='/logout']";
    private final String LOG_IN_ERROR_LABEL = "xpath=>//span[contains(text(),'The email must be a valid email address.')]";
    //Driver and constructor
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        customDriver = new CustomDriver(this.driver);
    }

    public void clickOnSignInButton() {
        customDriver.getElement(SIGNIN_BUTTON).click();
    }

    public void login(String username, String password) {
        //filling username field
        WebElement userNameField = customDriver.getElement(USERNAME_TEXTFIELD);
                //driver.findElement(By.xpath(USERNAME_TEXTFIELD));
        userNameField.click();
        userNameField.clear();
        userNameField.sendKeys(username);

        //filling password field
        WebElement passwordField = customDriver.getElement(PASSWORD_TEXTFIELD);
                //driver.findElement(By.xpath(PASSWORD_TEXTFIELD));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);

        customDriver.getElement(LOGIN_BUTTON).click();
                //driver.findElement(By.xpath(LOGIN_BUTTON));
    }

    public void validateSuccessfulLogIn() {
        WebElement avatar = customDriver.getElement(USER_AVATAR);
                //driver.findElement(By.xpath(USER_AVATAR));
        Assert.assertNotNull(avatar);
    }

    public void clickOnAllCoursesButton() {
       customDriver.getElement(ALL_COURSES_BUTTON).click();
                //driver.findElement(By.xpath(ALL_COURSES_BUTTON));
    }

    public void validateSigInButton(){
        WebElement sigInButton = customDriver.getElement(SIGNIN_BUTTON);
                //driver.findElement(By.xpath(SIGNIN_BUTTON));
        Assert.assertNotNull(sigInButton);
    }

    public void logOut() {
        customDriver.getElement(USER_MENU).click();
        //WebElement userMenu =
                //driver.findElement(By.xpath(USER_MENU));
        //userMenu.click();

        customDriver.getElement(LOG_OUT_OPTION).click();
        //WebElement logOutOption = driver.findElement(By.xpath(LOG_OUT_OPTION));
        //logOutOption.click();
    }

    public void validateErrorMessageOnWrongLogin(){
        WebElement errorLabel = customDriver.getElement(LOG_IN_ERROR_LABEL);
                //driver.findElement(By.xpath(LOG_IN_ERROR_LABEL));
        Assert.assertNotNull(errorLabel);
    }

}
