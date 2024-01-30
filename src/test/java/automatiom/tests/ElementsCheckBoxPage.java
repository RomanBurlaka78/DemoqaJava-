package automatiom.tests;

import automatiom.tests.base.BaseConfigurationPage;
import org.openqa.selenium.WebDriver;

public class ElementsCheckBoxPage extends BaseConfigurationPage<ElementsCheckBoxPage> {
    public ElementsCheckBoxPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected ElementsCheckBoxPage createNewPage() {

        return new ElementsCheckBoxPage(getDriver()
        );
    }

}
