package pages;

import actions.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.Constants.HOME_PAGE_TITLE;

public class HomePage extends CommonPage {

    static {
        new HomePage();
    }

    @FindBy(xpath = "//div[contains(@class,'navbar-header')]//a[contains(@class,'logo')]//img")
    private static WebElement logo;

    @FindBy(xpath = "//div[@id='main-nav']//li[contains(@class,'partners')]//a")
    private static WebElement partnershipsHeaderLink;

    @FindBy(xpath = "//div[@id='cookieModal']")
    private static WebElement cookiesModalDialog;

    @FindBy(xpath = "//div[@id='cookieModal']//button[text()='CONTINUE']")
    private static WebElement cookiesModalDialogContinueButton;

    public static boolean isPageTitleCorrect() {
        return CommonActions.isPageTitleEqualTo(HOME_PAGE_TITLE.getValue());
    }

    public static boolean isLogoDisplayed() {
        return CommonActions.isElementDisplayed(logo);
    }

    public static void clickPartnershipsHeaderLink() {
        CommonActions.click(partnershipsHeaderLink);
    }

    public static void acceptCookiesUsage() {
        CommonActions.waitForElementToBeVisible(cookiesModalDialog);
        CommonActions.click(cookiesModalDialogContinueButton);
    }

}
