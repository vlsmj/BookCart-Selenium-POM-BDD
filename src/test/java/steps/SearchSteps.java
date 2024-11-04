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

    @When("user enters {string} in the search bar")
    public void userEntersInTheSearchBar(String keyword) {
        searchBarComponent.setKeyword(keyword);
    }

    @And("user pressed enter in the search bar")
    public void userPressedEnterInTheSearchBar() {
        searchBarComponent.enter();
    }
}
