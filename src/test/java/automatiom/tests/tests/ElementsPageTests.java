package automatiom.tests.tests;

import automatiom.tests.TextBoxPage;
import automatiom.tests.HomePage;
import automatiom.tests.runner.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.List;

public class ElementsPageTests extends BaseTest {

    private static final String ELEMENTS_PAGE = "https://demoqa.com/elements";
    private static final String HOMEPAGE_TITLE = "DEMOQA";


    @Test
    @Description("Title of page")
    public void testTitleOfPage() {
        String homePage = new HomePage(getDriver())
                .accetpCookies()
                .getTitleOfPage();

        Assert.assertEquals(homePage, HOMEPAGE_TITLE);
    }

    @Ignore
    @Test
    public void testGoToElementsPage() {
        String elementsPage = new HomePage(getDriver())
                .accetpCookies()
                .scrollPage()
                .goToElementsPage()
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
                .goToTextboxPage()
                .fillForm("Robert", "qwerty@gmail.com", "Berlin 112", "S.Schtrasse 22")
                .submitForm()
                .showSubmitForm();

        Assert.assertEquals(titleOfTextBoxElementsPage, "Name:RobertEmail:qwerty@gmail.comCurrent Address :Berlin 112Permananet Address :S.Schtrasse 22");

    }

    @Test
    public void testVerifyCheckBox() {
        Boolean checkBoxAllElementsChecked = new HomePage(getDriver())
                .accetpCookies()
                .scrollPage()
                .goToElementsPage()
                .showElementsContent()
                .showCheckText()
                .confirmCheckAll()
                .resultChecked();

        Assert.assertEquals(checkBoxAllElementsChecked, true, "Not visible");
    }

}
