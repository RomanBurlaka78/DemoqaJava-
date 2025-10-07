package automatiom.tests.tests;

import automatiom.tests.ElementsPage;
import automatiom.tests.ElementsTextBoxPage;
import automatiom.tests.HomePage;
import automatiom.tests.runner.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ElementsPageTest extends BaseTest {

    private static final String ELEMENTS_PAGE = "https://demoqa.com/elements";
    private static final String HOMEPAGE_TITLE = "DEMOQA";





    private ElementsTextBoxPage titleOfTextBoxElementsPage;


    @Test()
    public void testGetTitle() {
        String homePage = new HomePage(getDriver())
                .accetpCookies()
                .getTitleOfPage();

        Assert.assertEquals(homePage, HOMEPAGE_TITLE);

    }

    @Test
    public void testGoToElementsPage() {
        String elementsPage = new HomePage(getDriver())
                .accetpCookies()
                .scrollPage()
                .goToPage("Elements", new ElementsPage(getDriver()))
                .getUrlOfPage();


        Assert.assertEquals(elementsPage, ELEMENTS_PAGE);

    }


    @Test
    public void testVerifyTextBox() {
        String titleOfTextBoxElementsPage = new HomePage(getDriver())
                .accetpCookies()
                .scrollPage()
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
                .scrollPage()
                .goToElementsPage()
                .showElementsContent()
                .clickGotoNewPage()
                .fillForm("Robert", "qwerty@gmail.com", "Berlin 112", "S.Schtrasse 22")
                .submitForm()
                .showSubmitForm();

        Assert.assertEquals(titleOfTextBoxElementsPage, "Name:RobertEmail:qwerty@gmail.comCurrent Address :Berlin 112Permananet Address :S.Schtrasse 22");

    }

}
