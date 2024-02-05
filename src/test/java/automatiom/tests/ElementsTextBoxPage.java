package automatiom.tests;

import automatiom.tests.base.BaseConfigurationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class ElementsTextBoxPage extends BaseConfigurationPage<ElementsTextBoxPage> {


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
    @FindBy(id = "userEmail")
    WebElement userEmail;
    @FindBy(id = "currentAddress")
    WebElement currentAddress;
    @FindBy(id = "permanentAddress")
    WebElement permanentAddress;
    @FindBy(id = "submit")
    WebElement submit;
    @FindBy(id = "output")
    WebElement output;
    @FindBy(id = "name")
    WebElement getName;
    @FindBy(id = "email")
    WebElement getEmail;
    @FindBy(xpath = "//p[@id='currentAddress']")
    WebElement getCurrentAddress;
    @FindBy(xpath = "//p[@id='permanentAddress']")
    WebElement getPermanentAddress;

    public ElementsTextBoxPage fillUserForm(String name, String email) {
        userName.clear();
        userName.sendKeys(name);
        userEmail.clear();
        userEmail.sendKeys(email);

        return this;
    }

    public ElementsTextBoxPage fillForm(String name, String fEmail, String cAddress, String pAddress) {

        HashMap<String, String> listOfElements = new HashMap<>();
        listOfElements.put("name", name);
        listOfElements.put("fEmail", fEmail);
        listOfElements.put("cAddress", cAddress);
        listOfElements.put("pAddress", pAddress);

        userName.clear();
        userName.sendKeys(listOfElements.get("name"));
        userEmail.clear();
        userEmail.sendKeys(listOfElements.get("fEmail"));
        currentAddress.clear();
        currentAddress.sendKeys(listOfElements.get("cAddress"));
        permanentAddress.clear();
        permanentAddress.sendKeys(listOfElements.get("pAddress"));

        return this;
    }

    public ElementsTextBoxPage submitForm() {
        submit.click();

        return this;
    }

    public String getTitleOfPage() {

        return titleOfTextBoxPage.getText();
    }

    public HashMap<String, String> getUserInformation() throws InterruptedException {
        HashMap<String, String> collectionOfUser = new HashMap<>();
        try {

            collectionOfUser.put("name", getName.getText());
            collectionOfUser.put("email", getEmail.getText());
            collectionOfUser.put("currentAddress", getCurrentAddress.getText());
            collectionOfUser.put("permanentAddress", getPermanentAddress.getText());

        } catch (Exception e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread Interrupted, Elements  not found");
        }
        return collectionOfUser;

    }

    public ElementsTextBoxPage scrollPage() {
        getActions().scrollByAmount(100, 1000).perform();

        return this;

    }

    public boolean checkUserInformation() throws InterruptedException {
        try {
            if (getUserInformation().containsKey("name")) {

                return true;
            }
            else {
                return false;
            }

        } catch (Exception e) {
            System.out.println("Error getUserInformation");
        }
        return checkUserInformation();
    }


}
