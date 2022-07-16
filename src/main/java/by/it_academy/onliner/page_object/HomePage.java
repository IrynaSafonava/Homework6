package by.it_academy.onliner.page_object;

import org.openqa.selenium.By;

import static java.lang.String.format;

public class HomePage extends BasePage {
    private static final String HEADER_NAVIGATION_LINK_PATTERN =
            "//*[@class='b-main-navigation__text' and text()='%s']";

    public void clickHeaderNavigationLink(String option) {
        waitForElementToBeVisible(By.xpath(String.format(HEADER_NAVIGATION_LINK_PATTERN, option))).click();
    }
}
