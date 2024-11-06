package steps;

import common.CommonActions;
import hooks.DriverHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class CommonSteps {
    private final CommonActions commonActions;

    public CommonSteps(DriverHooks driverHooks) {
        WebDriver driver = driverHooks.getDriver();

        commonActions = new CommonActions(driver);
    }

    @Given("the user navigated to the {string} page")
    public void theUserNavigatedToThePage(String page) {
        commonActions.navigateTo(page);
    }

    @Then("a message box is shown with a message {string}")
    public void aMessageBoxIsShownWithAMessage(String message) {
        Assertions.assertEquals(message.toLowerCase(), commonActions.getSnackBarMessage().toLowerCase());
    }
}
