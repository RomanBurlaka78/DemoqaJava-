package automatiom.tests.tests.windows_widgets;

import automatiom.tests.HomePage;
import automatiom.tests.runner.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Widgets/Select Menu")
public class SelectTest extends BaseTest {

    @Test
    @Description("This test check title of page")
    @Owner("R Burlaka")
    @Link(name = "Website", url = "https:demoqa.com/")

    public void testVerifyTitleOfPage() {
        String showTitleOfPage = new HomePage(getDriver())
                .accetpCookies()
                .scrollPage()
                .goToWidgetsSection()
                .goToSelectPage()
                .showTitleOfPage();

        Allure.step("Expected result: The title of page is 'Select Menu'");
        Assert.assertEquals(showTitleOfPage, "Select Menu", "Not equal");
    }

    @Test
    public void testVerifySelectItemColor() {
        String showSelectItemColor = new HomePage(getDriver())
                .accetpCookies()
                .scrollPage()
                .goToWidgetsSection()
                .goToSelectPage()
                .showSelectedItem("3");

        Assert.assertEquals(showSelectItemColor, "3");


    }

    @Test
    public void testVerifySelectItemRed() {
        String showSelectItemRed = new HomePage(getDriver())
                .accetpCookies()
                .scrollPage()
                .goToWidgetsSection()
                .goToSelectPage()
                .showSelectedItem("2");

        Assert.assertEquals(showSelectItemRed, "2");

    }

    @Test
    public void testMultiSelectCars() {
        String selectItem = new HomePage(getDriver())
                .accetpCookies()
                .scrollPage()
                .goToWidgetsSection()
                .goToSelectPage()
                .multiCarSelect("audi");

        Assert.assertEquals(selectItem, "audi");

    }
}
