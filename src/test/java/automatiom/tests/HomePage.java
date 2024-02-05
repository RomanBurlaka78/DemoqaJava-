package automatiom.tests;

import automatiom.tests.base.BaseConfigurationPage;
import automatiom.tests.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage  extends BaseConfigurationPage<HomePage> {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected HomePage createNewPage() {
        return new HomePage(getDriver());
    }


    @FindBy(xpath = "//*[@id='app']/div/div/div[2]/div/div[1]")
    WebElement getNewPage;

    @FindBy(xpath = "//button[@aria-label = 'Zgadzam się']")
    WebElement acceptCookies;

    public String getTitleOfPage() {


        return getDriver().getTitle();
    }
    public ElementsPage goToElementsPage() {
        getNewPage.click();

        return new ElementsPage(getDriver());
    }

    public HomePage scrollPage() {
        getActions().scrollByAmount(100, 1000).perform();

        return this;

    }
    public HomePage acceptCookies(){
        try {
            acceptCookies.click();
        }
        catch (Exception e) {
            System.out.println("Not such element on the page");
        }
        return this;
    }



}
