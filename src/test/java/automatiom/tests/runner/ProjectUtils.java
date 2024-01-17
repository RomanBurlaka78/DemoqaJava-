package automatiom.tests.runner;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class ProjectUtils {

    private static final String PREFIX_PROP = "https://";
    private static final String PROP_HOST = PREFIX_PROP + "demo.guru99.com/V4/";
    private static final String CLOSE_BROWSER_IF_ERROR = PREFIX_PROP + "closeBrowserIfError";
    private static Properties properties;

    static final ChromeOptions chromeOptions;

    static {
        chromeOptions = new ChromeOptions();
        String options = getUrl();
        if (options != null) {
            for (String argument : options.split(";")) {
                chromeOptions.addArguments(argument);
            }
        }

        WebDriverManager.chromedriver().setup();
    }

    static boolean isServerRun() {
        return System.getenv("CI_RUN") != null;
    }

    static boolean closeBrowserIfError() {
        return Boolean.getBoolean(properties.getProperty(CLOSE_BROWSER_IF_ERROR, "true"));
    }

    static String getUrl() {
        return String.format(PROP_HOST);

    }

    static void get(WebDriver driver) {
        driver.get(getUrl());
    }

    static void acceptAlert(WebDriver driver) {
        Alert alert = ExpectedConditions.alertIsPresent().apply(driver);
        if (alert != null) {
            alert.accept();
        }
    }

    static WebDriver createDriver() {
        WebDriver driver = new ChromeDriver(ProjectUtils.chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }

    public static void log(String str) {
        System.out.println(str);
    }

    public static void logf(String str, Object... arr) {
        System.out.printf(str, arr);
        System.out.println();
    }

    static File takeScreenshot(WebDriver driver, String methodName, String className) {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(String.format("screenshots/%s.%s.png", className, methodName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }


}
