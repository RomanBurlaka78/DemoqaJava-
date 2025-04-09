package automatiom.tests;

import automatiom.tests.base.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectPage extends BasePage {
    public SelectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[contains(text(), 'Select Menu')]")
    WebElement getTileOfPage;

    @FindBy(xpath = "//select[@id ='oldSelectMenu']")
    WebElement getSelectOldStyle;

    @FindBy(xpath = "//div[@id= 'withOptGroup']//div[@class=' css-1uccc91-singleValue']")
    WebElement getSelectValue;

    @FindBy(xpath = "//div[contains(text(), 'Select...')]")
    WebElement getMultiSelect;

    @FindBy(xpath = "//select[@id='cars']")
    WebElement getSelectCars;

    @FindBy(xpath = "//div[@class= ' css-1uccc91-singleValue']")
    WebElement getValueSelect1;

    @FindBy(xpath = "//div[@id = 'withOptGroup']//div[@class =' css-1hwfws3']")
    WebElement getSelectOptionSelect1;

    @FindBy(xpath = "//div[@id= 'withOptGroup']")
    WebElement getSelectOptionsFirstSelect;

    public String showTitleOfPage() {

        return getTileOfPage.getText();
    }

    public String showSelectedValueGroup() {
        Select selectItem = new Select(getSelectValue);
        selectItem.selectByVisibleText(getSelectValue.getText());

        return getSelectValue.getAttribute("value");
    }

    public String showSelectedItem(String value) {
        try {
            Select selectItem = new Select(getSelectOldStyle);
            selectItem.selectByValue(value);
        }
        catch (Exception e ) {
            System.out.println("Wrong color" + e);
        }


        return getSelectOldStyle.getAttribute("value");
    }

    public String multiCarSelect(String value) {
        Select selectItem = new Select(getSelectCars);
        selectItem.selectByValue(value);

        return getSelectCars.getAttribute("value");

    }

    public SelectPage deSelectItem(String value) {
        Select selectItem = new Select(getSelectCars);
        selectItem.deselectByValue("value");

        return this;

    }

    public SelectPage openDropdownMenu() {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", getSelectOptionsFirstSelect);

        return this;
    }

}
