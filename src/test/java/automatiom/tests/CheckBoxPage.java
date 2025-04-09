package automatiom.tests;

import automatiom.tests.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CheckBoxPage extends BasePage {
    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

    @FindBy
    WebElement getCheckAll = getDriver().findElement(By.xpath("//span[@class = 'rct-checkbox']"));

    @FindBy
    List<WebElement> result = getDriver().findElements(By.xpath("//div[@id ='result']/span"));



    public CheckBoxPage confirmCheckAll() {
        getCheckAll.click();

        return this;
    }

    public Boolean resultChecked(){
        getWait5().until(ExpectedConditions.invisibilityOfAllElements(result));

        return true;
    }

    public CheckBoxPage showList() {
        System.out.println(result);

        return this;
    }


}
