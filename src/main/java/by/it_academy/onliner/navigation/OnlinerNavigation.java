package by.it_academy.onliner.navigation;

import by.it_academy.onliner.page_object.HomePage;

public class OnlinerNavigation {

    private static final String ONLINER_URL = "https://www.onliner.by";

    public static void navigateOnlinerHomePage() {
        new HomePage().navigate(ONLINER_URL);
    }

}
