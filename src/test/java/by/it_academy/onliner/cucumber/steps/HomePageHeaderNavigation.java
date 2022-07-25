package by.it_academy.onliner.cucumber.steps;

import by.it_academy.onliner.navigation.OnlinerNavigation;
import by.it_academy.onliner.page_object.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePageHeaderNavigation {

    private HomePage homePage = new HomePage();
    private List<WebElement> list = new ArrayList<>();

    @Given("user navigates home page")
    public void userNavigatesOnlinerHomePage() {
        OnlinerNavigation.navigateOnlinerHomePage();
    }

    @When("user hovers {string} category in header")
    public void userHoversAutoCategoryLink(String category) {
        homePage.hoverHeaderCategoryLink(category);
        if(homePage.isHeaderSubmenuOptionDisplayed()){
            list = homePage.getListOfSubmenuOptions();
        }
    }
    @Then("^submenu with options appears")
    public void headerNavigationSubmenuOptionsDisplayed(List<String> options) {
        assertThat(list)
                .as("All categories present in the side list")
                .extracting(WebElement::getText)
                .containsAll(options);
    }
}
