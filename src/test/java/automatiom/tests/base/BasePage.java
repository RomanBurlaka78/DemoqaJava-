package automatiom.tests.base;

import automatiom.tests.base.BaseModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public abstract class BasePage extends BaseModel {

    private Actions actions;

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public Actions getActions() {
        if (actions == null) {
            actions = new Actions(getDriver());
        }
        return actions;
    }




}
