package ui;

import base.TestBase;
import org.testng.annotations.Test;
import pages.AccountRegistrationPage;
import pages.HomePage;
import pages.PartnersPage;

import static org.testng.Assert.*;

public class PartnershipsTest extends TestBase {

    private static final String PARTNERS_PAGE_MAIN_SLIDE_TEXT = "Partner with a Trusted Global Broker";
    private static final String TERMS_AND_CONDITIONS_ERROR_MESSAGE = "To register a Real Account, you must accept all applicable Terms and Conditions";
    private static final String ACCOUNT_CREATION_SUCCESS_ALERT = "Congratulations on opening an XM Partner Account\n" +
            "To complete the registration process, please confirm your email by clicking on the link sent to the email address you have provided: %s\n\n" +
            "If this message is not displayed in your inbox, you may need to check your spam folder.";
    private static final String EMAIL = "test@test.ru";

    @Test
    public void partnerAccountCreationTest() {
        HomePage.acceptCookiesUsage();
        assertTrue(HomePage.isPageTitleCorrect(),
                "Home page title is incorrect");
        assertTrue(HomePage.isLogoDisplayed());

        HomePage.clickPartnershipsHeaderLink();
        assertTrue(PartnersPage.isPageTitleCorrect(),
                "Partners page title is incorrect");
        assertEquals(PartnersPage.getMainSlideTitle(), PARTNERS_PAGE_MAIN_SLIDE_TEXT,
                "Main slide title is incorrect");

        PartnersPage.clickPartnerAccountRegistration();
        assertTrue(AccountRegistrationPage.isPageTitleCorrect(),
                "Account registration page title is incorrect");

        AccountRegistrationPage.inputFirstName("Test0");
        AccountRegistrationPage.inputLastName("Test0");
        AccountRegistrationPage.selectDateOfBirth(1, 1, 1990);
        AccountRegistrationPage.selectCountry("Russia");
        AccountRegistrationPage.inputCity("Moscow");
        AccountRegistrationPage.inputStateRegion("Moscow");
        AccountRegistrationPage.inputResidentialAddress("Krasnaya Ploshchad");
        AccountRegistrationPage.inputStreetNumber("3");
        AccountRegistrationPage.inputPostalZipCode("109012");
        AccountRegistrationPage.selectPhoneCountryCode("Russian Federation (+7)");
        AccountRegistrationPage.inputPhoneNumber("9990001122");
        AccountRegistrationPage.inputEmail(EMAIL);
        AccountRegistrationPage.selectPreferredLanguage("English");
        AccountRegistrationPage.inputAndConfirmPassword("TestTask123");

        AccountRegistrationPage.clickOpenPartnerAccountButton();
        assertEquals(AccountRegistrationPage.getErrorMessageText(), TERMS_AND_CONDITIONS_ERROR_MESSAGE,
                "Error message is incorrect:");

        AccountRegistrationPage.selectTermsAndConditionsCheckbox();
        assertFalse(AccountRegistrationPage.isErrorMessageDisplayed(),
                "Error message does not disappear when checkbox is selected correctly");

        AccountRegistrationPage.clickOpenPartnerAccountButton();
        assertTrue(AccountRegistrationPage.isAccountCreated(),
                "Submit failed and/or account was not created");
        assertEquals(AccountRegistrationPage.getSuccessAlertText(), String.format(ACCOUNT_CREATION_SUCCESS_ALERT, EMAIL),
                "Success alert text is incorrect:");
    }
}
