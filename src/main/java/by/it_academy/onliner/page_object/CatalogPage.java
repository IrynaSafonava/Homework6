package by.it_academy.onliner.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CatalogPage extends BasePage {

    private static final String CATALOG_CLASSIFIER_LINK_XPATH_PATTERN =
            "//*[contains(@class, 'catalog-navigation-classifier') and contains(text(), '%s')]";

    private static final String CATALOG_CLASSIFIER_CATEGORY_XPATH_PATTERN =
            "//div[@class='catalog-navigation-list__aside-title' and normalize-space(text()) = '%s']";

    private static final String CATALOG_CATEGORY_ITEM =
            "//div[@class='catalog-navigation-list__dropdown-item']";

    private static final String CATALOG_CATEGORY_ITEM_TITLE =
            "//div[@class='catalog-navigation-list__aside-title' and normalize-space(text()) = '%s']" +
                    "/following-sibling::div//span[@class='catalog-navigation-list__dropdown-title']";


    public CatalogPage clickOnCatalogClassifierLink(String option) {
        waitForElementToBeVisible(By.xpath(String.format(CATALOG_CLASSIFIER_LINK_XPATH_PATTERN, option))).click();
        return this;
    }

    public CatalogPage clickOnCategoryLink(String option) {
        waitForElementToBeVisible(By.xpath(String.format(CATALOG_CLASSIFIER_CATEGORY_XPATH_PATTERN, option))).click();
        return this;
    }

    public boolean isElementDisplayed(String option) {
        try {
            return waitForElementToBeVisible(By.xpath(String.format(CATALOG_CLASSIFIER_LINK_XPATH_PATTERN, option)))
                    .isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public List<WebElement> getListOfCategoryItems() {
        return getListOfElements(By.xpath(CATALOG_CATEGORY_ITEM));
    }

    public List<WebElement> getListOfItemsTitles() {
        return getListOfElements(By.xpath(CATALOG_CATEGORY_ITEM_TITLE));
    }

    public boolean isAllItemsHaveNotEmptyTitles(){
        if (getListOfItemsTitles().size() == getListOfCategoryItems().size()) {
            return getListOfItemsTitles().stream().noneMatch(titles -> titles.getText().isEmpty());
        }
        return false;
    }
}
