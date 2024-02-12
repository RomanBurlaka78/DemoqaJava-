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
    @FindBy(id= "currentAddress")
    WebElement currentAddress;
    @FindBy(id = "permanentAddress")
    WebElement permanentAddress;
    @FindBy(id = "submit")
    WebElement submitFormButton;
    @FindBy(id = "name")
    WebElement showName;
    @FindBy(id ="email")
    WebElement showEmail;
    @FindBy(xpath = "//p[@id ='currentAddress']")
    WebElement showCurrentAddress;
    @FindBy(xpath = "//p[@id ='permanentAddress']")
    WebElement showPermanentAddress;


    public  String  getTitleOfPage() {

        return titleOfTextBoxPage.getText();
    }

    public ElementsTextBoxPage fillUserForm(String name, String email) {
        userName.clear();
        userName.sendKeys(name);
        userEmail.clear();
        userEmail.sendKeys(email);

        return this;
    }

    public ElementsTextBoxPage fillForm(String name, String email, String cAddress, String pAddress ) {
        HashMap<String, String> listOfElements = new HashMap<>();
        listOfElements.put("name", name);
        listOfElements.put("email", email);
        listOfElements.put("cAddress", cAddress);
        listOfElements.put("pAddress", pAddress);

        userName.clear();
        userName.sendKeys(listOfElements.get("name"));
        userEmail.clear();
        userEmail.sendKeys(listOfElements.get("email"));
        currentAddress.clear();
        currentAddress.sendKeys(listOfElements.get("cAddress"));
        permanentAddress.clear();
        permanentAddress.sendKeys(listOfElements.get("pAddress"));

        return this;
    }

    public ElementsTextBoxPage submitForm() {
        getActions().scrollByAmount(100, 1000).perform();
        submitFormButton.click();

        return this;
    }

    public String   showSubmitForm()  {
        try {
            showName.getText();
            showEmail.getText();
            showCurrentAddress.getText();
            showPermanentAddress.getText();

            System.out.println(showName.getText() + showEmail.getText() + showCurrentAddress.getText()+showPermanentAddress.getText());
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return showName.getText() + showEmail.getText() + showCurrentAddress.getText() + showPermanentAddress.getText();



    }



}
