package steps;

import hooks.DriverHooks;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import utils.CommonActions;

public class CommonSteps {
    private final CommonActions commonActions;

    public CommonSteps(DriverHooks driverHooks) {
        WebDriver driver = driverHooks.getDriver();

        commonActions = new CommonActions(driver);
    }

    @Given("user navigated to the {string} page")
    public void userNavigatedToThePage(String page) {
        commonActions.navigateTo(page);
    }
}
