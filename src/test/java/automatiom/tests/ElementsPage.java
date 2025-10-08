package automatiom.tests;

import automatiom.tests.base.BaseConfigurationPage;
import automatiom.tests.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public  class ElementsPage extends BaseConfigurationPage<ElementsTextBoxPage> {
    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected ElementsTextBoxPage createNewPage() {
        return null;
    }

    @Override
    public ElementsTextBoxPage clickGotoNewPage() {
        getActions().scrollByAmount(100, 1000).perform();
        getTextBox.click();

        return new ElementsTextBoxPage(getDriver());
    }


    @FindBy(xpath = "//div[@class = 'accordion']//div[@class='element-group'][1]")
    WebElement sectionElements;

    @FindBy(xpath = "//span[contains(text(), 'Text Box')]")
    WebElement getTextBox;

    public String getUrlOfPage() {

        return getDriver().getCurrentUrl();
    }

    @Step("Show elements content")
    public ElementsPage showElementsContent() {
        sectionElements.click();
        getDriver().navigate().back();
        getDriver().navigate().forward();

        return this;
    }

    @Step("Show text box")
    public ElementsTextBoxPage showTextBoxText() {
        getTextBox.click();
        return new ElementsTextBoxPage(getDriver());
    }


}
