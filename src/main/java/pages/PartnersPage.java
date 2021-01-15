package pages;

import actions.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.Constants.PARTNERS_PAGE_TITLE;

public class PartnersPage extends CommonPage {

    static {
        new PartnersPage();
    }

    @FindBy(xpath = "//div[contains(@class,'slick-slider')]//span[@class='title']")
    private static WebElement mainSlideTitle;

    @FindBy(xpath = "//div[@class='buttons-wrap']//div[contains(@class,'hidden')]//a[contains(text(),'Register')]")
    private static WebElement registerPartnerAccountButton;

    public static boolean isPageTitleCorrect() {
        return CommonActions.isPageTitleEqualTo(PARTNERS_PAGE_TITLE.getValue());
    }

    public static String getMainSlideTitle() {
        return CommonActions.getText(mainSlideTitle);
    }

    public static void clickPartnerAccountRegistration() {
        CommonActions.click(registerPartnerAccountButton);
    }

}
