package tipeandocodigo.com.TestClasses;

import org.testng.annotations.*;
import tipeandocodigo.com.BaseTest.BaseTest;

public class LoginTest extends BaseTest {

    @BeforeClass
    public void setUp() {

    }

    @Test(priority = 1)
    public void testLogInToFail() {
        homePage.clickOnSignInButton();
        homePage.login("Morty", "anitalavalatina");
        homePage.validateErrorMessageOnWrongLogin();
    }

    @Test(priority = 2)
    public void testLogIn() {
        homePage.login(username, password);
    }

    @Test(priority = 3)
    public void validateUserLogIn() {
        homePage.validateSuccessfulLogIn();
    }
    @Test(priority = 4)
    public void logOut(){
        homePage.logOut();
        homePage.validateSigInButton();
    }

}
