package by.it_academy.onliner.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {
    private static final String ONLINER_URL = "https://www.onliner.by";
    private static final String HEADER_NAVIGATION_LINK_PATTERN =
            "//*[@class='b-main-navigation__text' and text()='%s']";

    private static final String HEADER_NAVIGATION_SUBMENU =
            "//*[@class='b-main-navigation__dropdown b-main-navigation__dropdown_visible']";

    private static final String HEADER_NAVIGATION_SUBMENU_ELEMENT =
            "//div[contains(@class, 'dropdown_visible')]" +
                    "//span[@class='b-main-navigation__dropdown-advert-sign' and contains(text(), '%s')]";

    private static final String HEADER_NAVIGATION_SUBMENU_OPTIONS =
            "//div[contains(@class, 'dropdown_visible')]" +
                    "//span[@class='b-main-navigation__dropdown-advert-sign']";

    public HomePage() {
        super();
    }

    public void clickHeaderNavigationLink(String option) {
        waitForElementToBeVisible(By.xpath(String.format(HEADER_NAVIGATION_LINK_PATTERN, option))).click();
    }

    public void hoverHeaderCategoryLink(String category) {
        hoverElement(By.xpath(String.format(HEADER_NAVIGATION_LINK_PATTERN, category)));
    }

    public boolean isHeaderSubmenuOptionDisplayed() {
        return isElementDisplayed(By.xpath(HEADER_NAVIGATION_SUBMENU));
    }

    public List<WebElement> getListOfSubmenuOptions() {
        return getListOfElements(By.xpath(HEADER_NAVIGATION_SUBMENU_OPTIONS));
    }

    @Override
    public String getUrl() {
        return ONLINER_URL;
    }
}
