package steps;

import hooks.DriverHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import pages.RegistrationPage;

import static utils.WaitUtils.retryClickUntilVisible;

public class RegistrationSteps {
    private final WebDriver driver;
    private final RegistrationPage registrationPage;
    private final LoginPage loginPage;

    public RegistrationSteps(DriverHooks driverHooks) {
        driver = driverHooks.getDriver();

        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
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

    @When("User enter valid inputs and selected a gender")
    public void userEnterValidInputsAndSelectedAGender() {
        registrationPage.setFirstName("John");
        registrationPage.setLastName("Doe");
        registrationPage.setUsername("johndoe2015");
        registrationPage.setPassword("Password1");
        registrationPage.setConfirmPassword("Password1");
        registrationPage.setGender("Male");
    }

    @And("User enters a username {string} on the registration page")
    public void userEntersAUsernameOnTheRegistrationPage(String username) {
        registrationPage.clearUsername();
        registrationPage.setUsername(username);
    }

    @And("User enters a password {string} on the registration page")
    public void userEntersAPasswordOnTheRegistrationPage(String password) {
        registrationPage.clearPassword();
        registrationPage.setPassword(password);
    }

    @And("User enters a confirm password {string} on the registration page")
    public void userEntersAConfirmPasswordOnTheRegistrationPage(String password) {
        registrationPage.clearConfirmPassword();
        registrationPage.setConfirmPassword(password);
    }

    @Then("Registration is successful and user is redirected to login page")
    public void registrationIsSuccessfulAndUserIsRedirectedToLoginPage() {
        WebElement loginElement = loginPage.getLoginElement();

        retryClickUntilVisible(driver, registrationPage.getRegisterButton(), loginElement);
        Assertions.assertTrue(loginElement.isDisplayed());
    }
}
