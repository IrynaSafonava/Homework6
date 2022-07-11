package by.it_academy.onliner.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.String.format;

public class HomePage extends BasePage {

    private static final By MAIN_NAVIGATION_LINK_PATTERN = By.xpath(format("//span(@class ='b-main-navigation__text') and text()= %s))"));

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnCatalogLink() {

    }
}
