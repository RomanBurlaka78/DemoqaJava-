package automatiom.tests.tests;

import automatiom.tests.ElementsTextBoxPage;
import automatiom.tests.HomePage;
import automatiom.tests.runner.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

public class ElementsPageTests extends BaseTest {

    private ElementsTextBoxPage titleOfTextBoxElementsPage;


    @Test
    public void testGetTitle() {
        String homePage = new HomePage(getDriver())
                .acceptCookies()
                .getTitleOfPage();

        Assert.assertEquals(homePage, "DEMOQA");
    }

    @Test
    public void testGoToElementsPage() {
        String elementsPage = new HomePage(getDriver())
                .acceptCookies()
                .scrollPage()
                .goToElementsPage()
                .getUrlOfPage();


        Assert.assertEquals(elementsPage, "https://demoqa.com/elements");
    }


    @Test
    public void testVerifyTextBox() {
        String titleOfTextBoxElementsPage = new HomePage(getDriver())
                .acceptCookies()
                .scrollPage()
                .goToElementsPage()
                .showElementsContent()
                .showTextBoxText()
                .getTitleOfPage();

        Assert.assertEquals(titleOfTextBoxElementsPage, "Text Box");
    }


    @Test
    public void testVerifyTextBoxForm() throws InterruptedException {
        HashMap<String, String> titleOfTextBoxElementsPage = new HomePage(getDriver())
                .acceptCookies()
                .scrollPage()
                .goToElementsPage()
                .showElementsContent()
                .clickGotoNewPage()
                .fillForm("Robert", "qwe222@gmail.com", "Florida", "Aveny101")
                .scrollPage()
                .submitForm()
                .getUserInformation();
        Boolean mapExist = new ElementsTextBoxPage(getDriver())
                .checkUserInformation();

        Assert.assertTrue(mapExist);

    }

}
