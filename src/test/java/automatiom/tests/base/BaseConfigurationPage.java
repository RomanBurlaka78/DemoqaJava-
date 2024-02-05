package automatiom.tests.base;

import org.openqa.selenium.WebDriver;

public abstract class BaseConfigurationPage<T extends BaseConfigurationPage> extends  BasePage{
    public BaseConfigurationPage(WebDriver driver) {
        super(driver);
    }
    protected  abstract  T createNewPage();


    public  T clickGotoNewPage(){


        return createNewPage();
    }
}
