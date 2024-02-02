package tipeandocodigo.com.testclasses;

import org.testng.annotations.*;
import tipeandocodigo.com.basetest.BaseTest;

public class LoginTest extends BaseTest {

    @BeforeClass
    public void setUp() {

    }

    @Test(testName = "failLogin",priority = 1)
    public void testLogInToFail() {
        homePage.clickOnSignInButton();
        homePage.login("Morty", "anitalavalatina");
        homePage.validateErrorMessageOnWrongLogin();
    }

    @Test(testName = "correctLogin",priority = 2)
    public void testLogIn() {
        homePage.login(username, password);
    }

    @Test(testName = "validateLogin",priority = 3)
    public void validateUserLogIn() {
        homePage.validateSuccessfulLogIn();
    }
    @Test(priority = 4)
    public void logOut(){
        homePage.logOut();
        homePage.validateSigInButton();
    }

}
