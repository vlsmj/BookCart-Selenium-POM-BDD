package steps;

import components.SearchBarComponent;
import hooks.DriverHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class SearchSteps {
    private final SearchBarComponent searchBarComponent;

    public SearchSteps(DriverHooks driverHooks) {
        WebDriver driver = driverHooks.getDriver();

        searchBarComponent = new SearchBarComponent(driver);
    }

    @When("the user enters {string} in the search bar")
    public void theUerEntersInTheSearchBar(String keyword) {
        searchBarComponent.setKeyword(keyword);
    }

    @And("the user pressed enter in the search bar")
    public void theUserPressedEnterInTheSearchBar() {
        searchBarComponent.enter();
    }
}
