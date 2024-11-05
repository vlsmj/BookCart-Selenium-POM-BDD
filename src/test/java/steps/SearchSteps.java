package steps;

import components.HeaderComponent;
import hooks.DriverHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class SearchSteps {
    private final HeaderComponent headerComponent;

    public SearchSteps(DriverHooks driverHooks) {
        WebDriver driver = driverHooks.getDriver();

        headerComponent = new HeaderComponent(driver);
    }

    @When("the user enters {string} in the search bar")
    public void theUserEntersInTheSearchBar(String keyword) {
        headerComponent.setKeyword(keyword);
    }

    @And("the user pressed enter in the search bar")
    public void theUserPressedEnterInTheSearchBar() {
        headerComponent.enterSearch();
    }
}
