package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import webdriver.WebDriverManager;

import static utils.Constants.HOME_PAGE_URL;

public class TestBase {

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.navigate(HOME_PAGE_URL.getValue());
    }

    @AfterMethod
    public void afterMethod() {
        WebDriverManager.closeDriver();
    }
}
