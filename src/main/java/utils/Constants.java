package utils;

public enum Constants {
    HOME_PAGE_URL("https://www.xm.com/"),
    HOME_PAGE_TITLE("Forex & CFD Trading on Stocks, Indices, Oil, Gold by XM™"),
    PARTNERS_PAGE_TITLE("Forex Affiliate Program | Forex Affiliates | XM Partners"),
    ACCOUNT_REGISTRATION_PAGE_TITLE("XM Partner Account Registration"),
    CHROMEDRIVER_PATH("./src/main/resources/chromedriver.exe");

    private final String value;

    Constants(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
