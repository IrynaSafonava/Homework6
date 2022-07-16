package by.it_academy.onliner;

import by.it_academy.onliner.navigation.OnlinerNavigation;
import by.it_academy.onliner.page_object.CatalogPage;
import by.it_academy.onliner.page_object.HomePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CatalogPageTest {

    private static CatalogPage catalogPage = new CatalogPage();

    @BeforeAll
    public static void navigateToCatalogFromOnlinerHomePage() {
        OnlinerNavigation.navigateOnlinerHomePage();
        new HomePage().clickHeaderNavigationLink("Каталог");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Электроника", "Компьютеры и сети", "Бытовая техника", "Стройка и ремонт",
            "Дом и сад", "Авто и мото", "Красота и спорт", "Детям и мамам", "Работа и офис"})
    public void catalogClassifierOptionsDisplayed(String option) {
        boolean isCatalogNavigationOptionDisplayed = catalogPage
                .isElementDisplayed(option);

        assertThat(isCatalogNavigationOptionDisplayed)
                .as("Classifier " + option + " is in catalog navigation list")
                .isTrue();
    }

    @Test
    public void allCategoryItemsHaveTitleAndFullDescription() {
        if(!catalogPage.isSideListDisplayed()) {
            catalogPage
                    .clickCatalogClassifierLink("Компьютеры и сети")
                    .clickCategoryLink("Комплектующие");
        }

        int categoryItemsNumber = catalogPage
                .getListOfCategoryItems("Комплектующие")
                .size();

        List<WebElement> listOfItemsWithTitles = catalogPage
                .getListOfItemsTitlesOfCategory("Комплектующие");
        System.out.println(listOfItemsWithTitles);
        List<WebElement> listOfItemsDescriptionsWithProductQnt = catalogPage
                .getListOfDescriptionsWithContent("товар");
        List<WebElement> listOfItemsDescriptionsWithPrice = catalogPage
                .getListOfDescriptionsWithContent("р.");

        assertThat(listOfItemsWithTitles)
                .as("Category items have no empty titles")
                .hasSize(categoryItemsNumber)
                .noneMatch(titles -> titles.getText().isEmpty());

        assertThat(listOfItemsDescriptionsWithPrice)
                .as("Category items have min price")
                .hasSize(categoryItemsNumber);

        assertThat(listOfItemsDescriptionsWithProductQnt)
                .as("Category items have quantity")
                .hasSize(categoryItemsNumber);
    }

    @Test
    public void sideListWithCategoriesDisplayed() {

        if (!catalogPage.isSideListDisplayed()) {
            catalogPage
                    .clickCatalogClassifierLink("Компьютеры и сети")
                    .isSideListDisplayed();
        }

        List<WebElement> listOfCategories = catalogPage.getListOfCategories();

        assertThat(catalogPage.isSideListDisplayed())
                .as("Side list is displayed")
                .isTrue();

        assertThat(listOfCategories)
                .as("All categories present in the side list")
                .extracting(WebElement::getText)
                .containsAll(Arrays.asList("Ноутбуки, компьютеры, мониторы", "Комплектующие",
                        "Хранение данных", "Сетевое оборудование"));
    }


    @AfterAll
    public static void close() {
        catalogPage.closeBrowser();
    }
}
