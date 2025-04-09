package automatiom.tests;

import automatiom.tests.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public  class ElementsPage extends BasePage {
    public ElementsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath  ="//div[@class = 'accordion']//div[@class='element-group'][1]")
    WebElement sectionElements;

    @FindBy(xpath = "//span[contains(text(), 'Text Box')]")
    WebElement getTextBox;

//    @FindBy(xpath = "//span[contains(text(), 'Check Box')]")
    WebElement getCheckBox;


    public String getUrlOfPage() {

        return getDriver().getCurrentUrl();
    }

    public ElementsPage showElementsContent() {
        sectionElements.click();
        getDriver().navigate().back();
        getDriver().navigate().forward();

        return this;
    }

    public TextBoxPage  showTextBoxText() {
        getTextBox.click();

        return new TextBoxPage(getDriver());
    }

    public CheckBoxPage showCheckText() {
        getCheckBox.click();

        return new CheckBoxPage(getDriver());
    }
    public TextBoxPage goToTextboxPage() {
        getTextBox.click();

        return new TextBoxPage(getDriver());
    }



}
