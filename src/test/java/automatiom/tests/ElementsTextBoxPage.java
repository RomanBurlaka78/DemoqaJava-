package automatiom.tests;

import automatiom.tests.base.BaseConfigurationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;

public class ElementsTextBoxPage  extends BaseConfigurationPage<ElementsTextBoxPage> {


    public ElementsTextBoxPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected ElementsTextBoxPage createNewPage() {
        return new ElementsTextBoxPage(getDriver());
    }

    @FindBy(xpath = "//*[@id='app']/div/div/div[1]/div")
    WebElement titleOfTextBoxPage;

    @FindBy(id = "userName")
    WebElement userName;

    @FindBy(id="userEmail")
    WebElement userEmail;

    public ElementsTextBoxPage fillUserForm(String name, String email) {
        userName.clear();
        userName.sendKeys(name);
        userEmail.clear();
        userEmail.sendKeys(email);

        return this;
    }

    public ElementsTextBoxPage fillForm(String name, String email) {
        HashMap<String, String> listOfElements = new HashMap<>();
        listOfElements.put("name", name);
        listOfElements.put("email", email);

        userName.clear();
        userName.sendKeys(listOfElements.get("name"));
        userEmail.clear();
        userEmail.sendKeys(listOfElements.get("email"));

        return this;
    }


    public  String  getTitleOfPage() {

        return titleOfTextBoxPage.getText();
    }
}
