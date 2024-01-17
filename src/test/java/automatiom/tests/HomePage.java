package automatiom.tests;

import automatiom.tests.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    public String getTitleOfPage() {

        return getDriver().getTitle();
    }
}
