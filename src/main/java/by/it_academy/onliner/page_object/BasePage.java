package by.it_academy.onliner.page_object;

import by.it_academy.onliner.driver.WebDriverDiscovery;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    private final WebDriver driver;

    public BasePage() {
        this.driver = WebDriverDiscovery.getWebDriver();
    }

    public WebElement waitForElementToBeVisible(By by) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void navigate() {
        driver.get(getUrl());
    }

    public abstract String getUrl();

    public List<WebElement> getListOfElements(By by) {
        return driver.findElements(by);
    }

    public void hoverElement(By by) {
        WebElement element = waitForElementToBeVisible(by);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public boolean isElementDisplayed(By by) {
        try {
            return waitForElementToBeVisible(by)
                    .isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}
