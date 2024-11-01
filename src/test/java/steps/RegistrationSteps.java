package steps;

import hooks.DriverHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.RegistrationPage;

public class RegistrationSteps {
    private final RegistrationPage registrationPage;

    public RegistrationSteps(DriverHooks driverHooks) {
        WebDriver driver = driverHooks.getDriver();

        registrationPage = new RegistrationPage(driver);
    }

    @Given("User is on the registration page")
    public void userIsOnTheRegistrationPage() {
        registrationPage.navigateTo("https://bookcart.azurewebsites.net/register");
    }

    @When("User leaves empty inputs and no selected gender")
    public void userLeavesEmptyInputsAndNoSelectedGender() {
        registrationPage.setFirstName("");
        registrationPage.setLastName("");
        registrationPage.setUsername("");
        registrationPage.setPassword("");
        registrationPage.setConfirmPassword("");
    }

    @And("User clicks the register button")
    public void userClicksTheRegisterButton() {
        registrationPage.clickRegister();
    }

    @Then("Input field {string} displays the error message {string} on the registration page")
    public void inputFieldDisplaysTheErrorMessageOnTheRegistrationPage(String inputField, String errorMessage) {
        Assertions.assertEquals(errorMessage, registrationPage.getInputFieldErrorMessage(inputField));
    }
}
