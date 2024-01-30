package automatiom.tests.tests;

import automatiom.tests.ElementsTextBoxPage;
import automatiom.tests.HomePage;
import automatiom.tests.runner.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class ElementsPageTests extends BaseTest {

//    private  static  final USER_NAME= "Robert";


    private ElementsTextBoxPage titleOfTextBoxElementsPage;


    @Test
    public void testGetTitle() {
        String homePage = new HomePage(getDriver())
                .accetpCookies()
                .getTitleOfPage();

        Assert.assertEquals(homePage, "DEMOQA");

    }

    @Test
    public void testGoToElementsPage() {
        String elementsPage = new HomePage(getDriver())
                .accetpCookies()
                .ScrollPage()
                .goToElementsPage()
                .getUrlOfPage();


        Assert.assertEquals(elementsPage, "https://demoqa.com/elements");

    }


    @Test
    public void testVerifyTextBox() {
        String titleOfTextBoxElementsPage = new HomePage(getDriver())
                .accetpCookies()
                .ScrollPage()
                .goToElementsPage()
                .showElementsContent()
                .showTextBoxText()
                .getTitleOfPage();

        Assert.assertEquals(titleOfTextBoxElementsPage, "Text Box");

    }

    @Test
    public void testVerifyTextBoxForm() {
        String titleOfTextBoxElementsPage = new HomePage(getDriver())
                .accetpCookies()
                .ScrollPage()
                .goToElementsPage()
                .showElementsContent()
                .clickGotoNewPage()
                .fillUserForm("Robert", "qwe222@gmail.com")
                .getTitleOfPage();



        Assert.assertEquals(titleOfTextBoxElementsPage, "Text Box");

    }

}