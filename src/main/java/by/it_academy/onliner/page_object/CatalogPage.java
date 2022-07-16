package by.it_academy.onliner.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CatalogPage extends BasePage {

    private static final String CATALOG_CLASSIFIER_XPATH_PATTERN =
            "//*[contains(@class, 'catalog-navigation-classifier') and contains(text(), '%s')]";

    private static final String SIDE_LIST_WITH_CATEGORIES_XPATH_PATTERN =
            "//div[@class='catalog-navigation-list__category' and @style='display: block;']"
                    + "//div[@class = 'catalog-navigation-list__aside-title']";

    private static final String CATEGORY_XPATH_PATTERN =
            "//div[@class='catalog-navigation-list__aside-title' and normalize-space(text()) = '%s']";

    private static final String CATALOG_CATEGORY_ITEM_XPATH_PATTERN =
            "//div[@class='catalog-navigation-list__aside-title' and normalize-space(text()) = '%s']" +
                    "/following-sibling::div//a[@class='catalog-navigation-list__dropdown-item']";

    private static final String CATALOG_CATEGORY_ITEM_TITLE_XPATH_PATTERN =
            "//div[@class='catalog-navigation-list__aside-title' and normalize-space(text()) = '%s']" +
                    "/following-sibling::div//span[@class='catalog-navigation-list__dropdown-title']";

    private static final String CATALOG_CATEGORY_ITEM_DESCRIPTION_WITH_SPECIFIC_CONTENT_XPATH_PATTERN =
            "//div[@class='catalog-navigation-list__aside-title' and normalize-space(text()) = 'Комплектующие']" +
                    "/following-sibling::div//span[@class='catalog-navigation-list__dropdown-description' " +
                    "and contains(., '%s')]";

    public CatalogPage clickCatalogClassifierLink(String option) {
        waitForElementToBeVisible(By.xpath(String.format(CATALOG_CLASSIFIER_XPATH_PATTERN, option))).click();
        return this;
    }

    public CatalogPage clickCategoryLink(String category) {
        waitForElementToBeVisible(By.xpath(String
                .format(CATEGORY_XPATH_PATTERN, category))).click();
        return this;
    }

    public boolean isElementDisplayed(String category) {
        try {
            return waitForElementToBeVisible(By.xpath(String
                    .format(CATALOG_CLASSIFIER_XPATH_PATTERN, category)))
                    .isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isSideListDisplayed() {
        try {
            return waitForElementToBeVisible(By.xpath(SIDE_LIST_WITH_CATEGORIES_XPATH_PATTERN))
                    .isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public List<WebElement> getListOfCategoryItems(String category) {
        return getListOfElements(By.xpath(String.format(CATALOG_CATEGORY_ITEM_XPATH_PATTERN, category)));
    }

    public List<WebElement> getListOfItemsTitlesOfCategory(String category) {
        return getListOfElements(By.xpath(String.format(CATALOG_CATEGORY_ITEM_TITLE_XPATH_PATTERN, category)));
    }

    public List<WebElement> getListOfDescriptionsWithContent(String content) {
        return getListOfElements(By.xpath(String
                .format(CATALOG_CATEGORY_ITEM_DESCRIPTION_WITH_SPECIFIC_CONTENT_XPATH_PATTERN, content)));
    }
    public  List<WebElement> getListOfCategories() {
        return getListOfElements(By.xpath(SIDE_LIST_WITH_CATEGORIES_XPATH_PATTERN));
    }
}