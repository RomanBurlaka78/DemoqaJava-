package automatiom.tests.base;

import automatiom.tests.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v116.page.Page;

public abstract class BaseConfigurationPage<T extends BaseConfigurationPage> extends  BasePage{
    public BaseConfigurationPage(WebDriver driver) {
        super(driver);
    }
    protected  abstract  T createNewPage();


    public  T clickGotoNewPage(){


        return createNewPage();
    }


}
