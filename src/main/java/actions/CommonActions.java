package actions;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import webdriver.WebDriverManager;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static webdriver.WebDriverManager.getWait;

public class CommonActions {

    private static final String SCROLL_TO_VIEW_JS = "arguments[0].scrollIntoView(true)";
    private static final String IS_CHECKBOX_SELECTED_JS = "return getComputedStyle(arguments[0], '::after').content !== 'none'";

    public static boolean isPageTitleEqualTo(String expectedTitle) {
        return WebDriverManager.getDriver().getTitle().equals(expectedTitle);
    }

    public static void click(WebElement element) {
        waitForElementToBeClickable(element);
        element.click();
    }

    public static void inputText(WebElement element, String text) {
        waitForElementToBeVisible(element);
        element.sendKeys(text);
    }

    public static String getText(WebElement element) {
        waitForElementToBeVisible(element);
        return element.getText();
    }

    public static void waitForElementToBeVisible(WebElement element) {
        getWait().until(visibilityOf(element));
    }

    public static void waitForElementToBeClickable(WebElement element) {
        getWait().until(elementToBeClickable(element));
    }

    public static void scrollToView(WebElement element) {
        WebDriverManager.getDriver().executeScript(SCROLL_TO_VIEW_JS, element);
    }

    public static boolean isCheckboxSelected(WebElement element) {
        return (Boolean) WebDriverManager.getDriver().executeScript(IS_CHECKBOX_SELECTED_JS, element);
    }

    public static boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public static boolean doesElementExist(WebElement element) {
        try {
            isElementDisplayed(element);
        } catch (NoSuchElementException noElement) {
            return false;
        }
        return true;
    }
}
