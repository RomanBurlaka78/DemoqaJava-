package automatiom.tests.runner;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public abstract class BaseTest {
    protected WebDriver driver;
    private String browser;


    protected WebDriver getDriver() {
        return driver;
    }

    List<String> optionalBrowser = List.of("firefox", "chrome", "edge");
    Random random = new Random();
    String optionalItem = optionalBrowser.get(random.nextInt(optionalBrowser.size()));


    @BeforeClass
    @Parameters("browser")
    protected void beforeClass() {
        this.browser = "chrome";
        Arrays.stream(this.getClass().getMethods())
                .filter(m -> m.getAnnotation(Test.class) != null && m.getAnnotation(Ignore.class) == null)
                .collect(Collectors.toList());

    }

    @BeforeMethod
    public WebDriver setUp() {

        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless"); // стабильно на Windows
                chromeOptions.addArguments("--window-size=1920,1080");
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--remote-allow-origins=*");

                if (!System.getProperty("os.name").toLowerCase().contains("win")) {
                    chromeOptions.addArguments("--no-sandbox", "--disable-dev-shm-usage");
                    chromeOptions.addArguments("--user-data-dir=/tmp/chrome-profile-" + System.currentTimeMillis());
                } else {
                    chromeOptions.addArguments("--user-data-dir=" + System.getProperty("java.io.tmpdir") + "chrome-profile-" + System.currentTimeMillis());
                }
                driver = new ChromeDriver(chromeOptions);

                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--width=1920");
                firefoxOptions.addArguments("--height=1080");
                firefoxOptions.addArguments("--headless");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--window-size=1920,1080");
                edgeOptions.addArguments("--headless");
                driver = new EdgeDriver(edgeOptions);
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }


        driver.get("https://demoqa.com/");
        return driver;
    }


    @AfterMethod
    public void tearDown(ITestResult testResult) {
        if (testResult.isSuccess()) {
            driver.quit();
        }
        else if (!testResult.isSuccess()) {
            Allure.addAttachment(
                    "screenshot.png",
                    "image/png",
                    new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)),
                    "png");
        } else {
            System.out.println("Failed: " + testResult.getTestClass());
        }
    }
}