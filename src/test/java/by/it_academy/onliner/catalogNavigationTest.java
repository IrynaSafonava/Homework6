package by.it_academy.onliner;

import by.it_academy.onliner.navigation.OnlinerNavigation;
import by.it_academy.onliner.page_object.HomePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class catalogNavigationTest {

    private static HomePage homePage = new HomePage();

    @BeforeAll
    public static void navigateToOnlinerHomePage(){
        OnlinerNavigation.navigateToOnlinerHomePage();
    }

    @Test
    public void userIsAbleToNavigateToHomePageViaLink(){
        homePage.clickOnNavigationLink("Каталог");
    }

    @AfterAll
    public static void close(){
        homePage.closeBrowser();
    }

}
