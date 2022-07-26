package by.it_academy.onliner.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Optional;

public class WebDriverDiscovery {
    private static ThreadLocal<WebDriver> remoteWebDriver = new ThreadLocal<>();

    public WebDriverDiscovery() {
    }

    public static void setWebDriver() {
        WebDriver driver = new ChromeDriver();
        remoteWebDriver.set(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
    }

    public static WebDriver getWebDriver() {
        return remoteWebDriver.get();
    }

    public static void quitDriver() {
        Optional.ofNullable(getWebDriver()).ifPresent(webDriver -> {
            webDriver.quit();
            remoteWebDriver.remove();
        });
    }
}
