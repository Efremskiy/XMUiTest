package pages;

import actions.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.Constants.ACCOUNT_REGISTRATION_PAGE_TITLE;

public class AccountRegistrationPage extends CommonPage {

    private static final String DROPDOWN_OPTION_XPATH = ".//option[text()='%s']";

    static {
        new AccountRegistrationPage();
    }

    @FindBy(xpath = "//input[@id='first_name']")
    private static WebElement firstNameField;

    @FindBy(xpath = "//input[@id='last_name']")
    private static WebElement lastNameField;

    @FindBy(xpath = "//select[@id='dob_day']")
    private static WebElement dayOfBirthDropdown;

    @FindBy(xpath = "//select[@id='dob_month']")
    private static WebElement monthOfBirthDropdown;

    @FindBy(xpath = "//select[@id='dob_year']")
    private static WebElement yearOfBirthDropdown;

    @FindBy(xpath = "//select[@id='country']")
    private static WebElement countryDropdown;

    @FindBy(xpath = "//input[@id='city']")
    private static WebElement cityField;

    @FindBy(xpath = "//input[@id='state_region']")
    private static WebElement stateRegionField;

    @FindBy(xpath = "//input[@id='street_name']")
    private static WebElement residentialAddressField;

    @FindBy(xpath = "//input[@id='street_number']")
    private static WebElement streetNumberField;

    @FindBy(xpath = "//input[@id='postal_zip']")
    private static WebElement postalZipCodeField;

    @FindBy(xpath = "//select[@id='phoneNumberCountryPrefix']")
    private static WebElement phoneCountryCodeDropdown;

    @FindBy(xpath = "//input[@id='phone_number']")
    private static WebElement phoneNumberField;

    @FindBy(xpath = "//input[@id='email']")
    private static WebElement emailField;

    @FindBy(xpath = "//select[@id='preferred_language']")
    private static WebElement preferredLanguageDropdown;

    @FindBy(xpath = "//input[@id='account_password']")
    private static WebElement passwordField;

    @FindBy(xpath = "//input[@id='account_password_confirmation']")
    private static WebElement passwordConfirmationField;

    @FindBy(xpath = "//label[@for='agree_terms']")
    private static WebElement termsAndConditionsCheckbox;

    @FindBy(xpath = "//label[@class='error']")
    private static WebElement errorMessage;

    @FindBy(xpath = "//button[@type='submit']")
    private static WebElement openPartnerAccountButton;

    @FindBy(xpath = "//div[contains(@class,'alert-success')]")
    private static WebElement successAlert;

    public static boolean isPageTitleCorrect() {
        return CommonActions.isPageTitleEqualTo(ACCOUNT_REGISTRATION_PAGE_TITLE.getValue());
    }

    public static void inputFirstName(String firstName) {
        CommonActions.inputText(firstNameField, firstName);
    }

    public static void inputLastName(String lastName) {
        CommonActions.inputText(lastNameField, lastName);
    }

    public static void selectDateOfBirth(int day, int month, int year) {
        selectOptionFromDropdown(dayOfBirthDropdown, String.valueOf(day));
        selectOptionFromDropdown(monthOfBirthDropdown, String.valueOf(month));
        selectOptionFromDropdown(yearOfBirthDropdown, String.valueOf(year));
    }

    public static void selectCountry(String country) {
        selectOptionFromDropdown(countryDropdown, country);
    }

    public static void inputCity(String city) {
        CommonActions.inputText(cityField, city);
    }

    public static void inputStateRegion(String stateRegion) {
        CommonActions.inputText(stateRegionField, stateRegion);
    }

    public static void inputResidentialAddress(String residentialAddress) {
        CommonActions.inputText(residentialAddressField, residentialAddress);
    }

    public static void inputStreetNumber(String streetNumber) {
        CommonActions.inputText(streetNumberField, streetNumber);
    }

    public static void inputPostalZipCode(String postalZipCode) {
        CommonActions.inputText(postalZipCodeField, postalZipCode);
    }

    public static void selectPhoneCountryCode(String phoneCountryCode) {
        selectOptionFromDropdown(phoneCountryCodeDropdown, phoneCountryCode);
    }

    public static void inputPhoneNumber(String phoneNumber) {
        CommonActions.inputText(phoneNumberField, phoneNumber);
    }

    public static void inputEmail(String email) {
        CommonActions.inputText(emailField, email);
    }

    public static void selectPreferredLanguage(String preferredLanguage) {
        selectOptionFromDropdown(preferredLanguageDropdown, preferredLanguage);
    }

    public static void inputAndConfirmPassword(String password) {
        CommonActions.inputText(passwordField, password);
        CommonActions.inputText(passwordConfirmationField, password);
    }

    public static void selectTermsAndConditionsCheckbox() {
        if (!CommonActions.isCheckboxSelected(termsAndConditionsCheckbox)) {
            CommonActions.click(termsAndConditionsCheckbox);
        }
    }

    public static String getErrorMessageText() {
        return CommonActions.getText(errorMessage);
    }

    public static boolean isErrorMessageDisplayed() {
        try {
            return CommonActions.isElementDisplayed(errorMessage);
        } catch (NoSuchElementException noErrorMessage) {
            return false;
        }
    }

    public static void clickOpenPartnerAccountButton() {
        CommonActions.click(openPartnerAccountButton);
    }

    public static boolean isAccountCreated() {
        return !CommonActions.doesElementExist(openPartnerAccountButton) && CommonActions.isElementDisplayed(successAlert);
    }

    public static String getSuccessAlertText() {
        return CommonActions.getText(successAlert);
    }

    private static void selectOptionFromDropdown(WebElement dropdown, String optionText) {
        CommonActions.scrollToView(dropdown);
        CommonActions.click(dropdown);
        WebElement option = dropdown.findElement(By.xpath(String.format(DROPDOWN_OPTION_XPATH, optionText)));
        CommonActions.click(option);
    }
}
