package rindus.automationtest.browser;

import rindus.automationtest.pages.HomePage;
import rindus.automationtest.pages.ItemPage;

public class Browser {

    public static String baseCmsUrl = "https://www.amazon.com/";
    private static HomePage homePage;
    private static String homePageUrl;

    public static HomePage getHomePage(String partialUrl) {
        homePageUrl = baseCmsUrl + partialUrl;
        if (homePage == null) {
            homePage = new HomePage(homePageUrl);
        }
        homePage.setUrl(homePageUrl);
        return homePage;
    }

    public static HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage(baseCmsUrl);
        }
        return homePage;
    }
}
