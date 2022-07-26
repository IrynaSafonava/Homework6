package by.it_academy.onliner.cucumber.hooks;

import by.it_academy.onliner.driver.WebDriverDiscovery;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class DriverHooks {
    @Before
    public void setupDriver() {
        WebDriverDiscovery.setWebDriver();
    }

    @After
    public void quitDriver() {
        WebDriverDiscovery.quitDriver();
    }
}
