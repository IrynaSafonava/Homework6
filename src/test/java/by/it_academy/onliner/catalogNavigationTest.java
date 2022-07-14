package by.it_academy.onliner;

import by.it_academy.onliner.navigation.OnlinerNavigation;
import by.it_academy.onliner.page_object.CatalogPage;
import by.it_academy.onliner.page_object.HomePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class catalogNavigationTest {

    private static CatalogPage catalogPage = new CatalogPage();

    @BeforeAll
    public static void navigateToOnlinerHomePage(){
        OnlinerNavigation.navigateOnlinerHomePage();
        new HomePage().clickOnHeaderNavigationLink("Каталог");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Электроника", "Компьютеры и", "Бытовая техника",
            "Стройка и", "Дом и","Авто и","Красота и","Детям и","Работа и", "Еда"})
    public void catalogNavigationOptionsDisplayed(String option){
        boolean isCatalogNavigationOptionDisplayed = catalogPage
                .isElementDisplayed(option);

        assertThat(isCatalogNavigationOptionDisplayed)
                .as("Option " + option +" in catalog navigation menu not found")
                .isTrue();
    }
    @Test
    public void allCategoryItemsHaveNotEmptyTitles() {
        boolean isAllItemsHaveTitles = catalogPage
                .clickOnCatalogClassifierLink("Компьютеры и")
                .clickOnCategoryLink("Комплектующие")
                .isAllItemsHaveNotEmptyTitles();

        assertThat(isAllItemsHaveTitles)
                .as("Some Items have empty Titles")
                .isTrue();
    }

    @AfterAll
    public static void close(){
        catalogPage.closeBrowser();
    }

}
