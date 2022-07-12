package by.it_academy.onliner.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.String.format;

public class HomePage extends BasePage {

    private static final String MAIN_NAVIGATION_LINK_PATTERN =
            "//*[@class='b-main-navigation__text' and text()='%s']";

    public void clickOnNavigationLink(String option) {
        waitForElementToBeVisible(By.xpath(String.format(MAIN_NAVIGATION_LINK_PATTERN, option))).click();
    }
}
