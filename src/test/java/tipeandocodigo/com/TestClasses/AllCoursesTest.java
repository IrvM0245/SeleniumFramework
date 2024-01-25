package tipeandocodigo.com.TestClasses;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tipeandocodigo.com.BaseTest.BaseTest;

public class AllCoursesTest extends BaseTest {

    @BeforeClass
    public void setUp(){
        homePage.clickOnSignInButton();
        homePage.login(username,password);
        homePage.validateSuccessfulLogIn();
    }

    @Test
    public void testSearchCourses(){
        homePage.clickOnAllCoursesButton();
        allCourses.countCourses();
        allCourses.searchCourses(course);
        Assert.assertTrue(allCourses.validateSearch());
    }

    @Test
    public void testFilterCourses(){
        homePage.clickOnAllCoursesButton();
        allCourses.selectAllFilters();
    }

}
