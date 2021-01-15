package pages;

import org.openqa.selenium.support.PageFactory;
import webdriver.WebDriverManager;

public class CommonPage {

    protected CommonPage() {
        PageFactory.initElements(WebDriverManager.getDriver(), this);
    }

}
