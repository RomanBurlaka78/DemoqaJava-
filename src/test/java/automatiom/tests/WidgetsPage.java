package automatiom.tests;

import automatiom.tests.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WidgetsPage extends BasePage {
    public WidgetsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(text(), 'Select Menu')]")
    WebElement getSelectMenu;



    public SelectPage goToSelectPage() {
        getSelectMenu.click();

        return new SelectPage(getDriver());
    }



}
