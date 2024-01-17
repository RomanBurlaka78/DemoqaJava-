package automatiom.tests.tests;

import automatiom.tests.HomePage;
import automatiom.tests.runner.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private static final String BASE_URL = "https://www.demo.guru99.com/V4/";

    @Test
    public void testLogin() {
        String homePage = new HomePage(getDriver())
                .getTitleOfPage();

        Assert.assertEquals(homePage, "Guru99 Bank Home Page");




    }

}
