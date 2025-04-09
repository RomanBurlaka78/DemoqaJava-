package automatiom.tests;

import automatiom.tests.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage  extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }



    @FindBy(xpath = "//div[@class = 'category-cards']/div[@class ='card mt-4 top-card'][1]")
    WebElement getNewPage;

    @FindBy(xpath = "//button[@aria-label = 'Zgadzam się']")
    WebElement acceptCookies;

    @FindBy(xpath ="//h5[contains(text(), 'Widgets')]")
    WebElement getWindowsSection;

    public String getTitleOfPage() {


        return getDriver().getTitle();
    }
    public ElementsPage goToElementsPage() {
        getNewPage.click();

        return new ElementsPage(getDriver());
    }

    public WidgetsPage goToWidgetsSection() {
        getWindowsSection.click();

        return new WidgetsPage(getDriver());
    }

    public HomePage scrollPage() {
        getActions().scrollByAmount(100, 1000).perform();

        return this;

    }
    public HomePage accetpCookies(){
        try {
            acceptCookies.click();
        }
        catch (Exception e) {
            System.out.println("Not such element on the page");
        }
        return this;
    }



}
