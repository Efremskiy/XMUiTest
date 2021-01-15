package webdriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static utils.Constants.CHROMEDRIVER_PATH;

public class WebDriverManager {

    private static final int EXPLICIT_WAIT_IN_SECONDS = 10;
    private static final int IMPLICIT_WAIT_IN_SECONDS = 2;

    private static ChromeDriver driver;
    private static WebDriverWait wait;

    public static ChromeDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH.getValue());
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_IN_SECONDS, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static WebDriverWait getWait() {
        if (wait == null) {
            wait = new WebDriverWait(getDriver(), EXPLICIT_WAIT_IN_SECONDS);
        }
        return wait;
    }

    public static void navigate(String url) {
        getDriver().get(url);
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver.quit();
            driver = null;
        }
    }
}
