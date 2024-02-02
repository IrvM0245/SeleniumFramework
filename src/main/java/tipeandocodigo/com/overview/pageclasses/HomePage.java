package tipeandocodigo.com.overview.pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import tipeandocodigo.com.overview.basepage.CustomDriver;

public class HomePage extends CustomDriver{
    //private WebDriver driver;
    public HomePage(WebDriver driver) {
        super(driver);
        //this.driver = driver;
    }

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



    public void clickOnSignInButton() {
        getElement(SIGNIN_BUTTON).click();
    }

    public void login(String username, String password) {
        //filling username field
        WebElement userNameField = getElement(USERNAME_TEXTFIELD);
        userNameField.click();
        userNameField.clear();
        userNameField.sendKeys(username);

        //filling password field
        WebElement passwordField = getElement(PASSWORD_TEXTFIELD);
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);

        getElement(LOGIN_BUTTON).click();
    }

    public void validateSuccessfulLogIn() {
        WebElement avatar = getElement(USER_AVATAR);
        Assert.assertNotNull(avatar);
    }

    public void clickOnAllCoursesButton() {
       getElement(ALL_COURSES_BUTTON).click();
    }

    public void validateSigInButton(){
        WebElement sigInButton = getElement(SIGNIN_BUTTON);
        Assert.assertNotNull(sigInButton);
    }

    public void logOut() {
        getElement(USER_MENU).click();
        getElement(LOG_OUT_OPTION).click();
    }

    public void validateErrorMessageOnWrongLogin(){
        WebElement errorLabel = getElement(LOG_IN_ERROR_LABEL);
        Assert.assertNotNull(errorLabel);
    }

}
