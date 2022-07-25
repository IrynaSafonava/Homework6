package by.it_academy.onliner.cucumber.steps;

import by.it_academy.onliner.navigation.OnlinerNavigation;
import by.it_academy.onliner.page_object.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoPageNavigation {

    private HomePage homePage = new HomePage();

    @Given("user navigates home page")
    public void userNavigatesOnlinerHomePage() {
        OnlinerNavigation.navigateOnlinerHomePage();
    }

    @When("user hovers {string} category in header")
    public void userHoversAutoCategoryLink(String category) {
        homePage.hoverHeaderCategoryLink(category);
    }

    @Then("^submenu with options appears")
    public void headerNavigationSubmenuOptionsDisplayed(List<String> options) {
        //boolean isSubmenuDisplayed = homePage.isHeaderSubmenuOptionDisplayed();
        List<WebElement> list = homePage.getListOfSubmenuOptions();

        List<String> elements = new ArrayList<>();
        for (WebElement option: list) {
            elements.add(option.getText());
            System.out.println(elements);
        }

        assertThat(elements.containsAll(options))
                .as("Options are displayed")
                .isTrue();

    }
}
