package steps;

import hooks.DriverHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import pages.RegistrationPage;

import static utils.StringUtils.generateUsername;
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

    @When("user leaves empty inputs and no selected gender")
    public void userLeavesEmptyInputsAndNoSelectedGender() {
        registrationPage.setFirstName("");
        registrationPage.setLastName("");
        registrationPage.setUsername("");
        registrationPage.setPassword("");
        registrationPage.setConfirmPassword("");
    }

    @And("user clicks the register button")
    public void userClicksTheRegisterButton() {
        registrationPage.clickRegister();
    }

    @Then("input field {string} displays the error message {string} on the registration page")
    public void inputFieldDisplaysTheErrorMessageOnTheRegistrationPage(String inputField, String errorMessage) {
        Assertions.assertEquals(errorMessage, registrationPage.getInputFieldErrorMessage(inputField));
    }

    @When("user enter valid inputs and selected a gender")
    public void userEnterValidInputsAndSelectedAGender() {
        registrationPage.setFirstName("John");
        registrationPage.setLastName("Doe");
        registrationPage.setUsername(generateUsername());
        registrationPage.setPassword("Password1");
        registrationPage.setConfirmPassword("Password1");
        registrationPage.setGender("Male");
    }

    @When("user enters a first name {string} on the registration page")
    public void userEntersAFirstNameOnTheRegistrationPage(String firstName) {
        registrationPage.setFirstName(firstName);
    }

    @When("user enters a last name {string} on the registration page")
    public void userEntersALastNameOnTheRegistrationPage(String lastName) {
        registrationPage.setLastName(lastName);
    }

    @And("user enters a username {string} on the registration page")
    public void userEntersAUsernameOnTheRegistrationPage(String username) {
        WebElement usernameFieldElement = registrationPage.getUsernameField();
        WebElement usernameFieldErrorElement = registrationPage.getUsernameFieldError();

        registrationPage.clearUsername();
        registrationPage.setUsername(username);

        // Wait for input field error message to show, click input field to not idle.
        retryClickUntilVisible(driver, usernameFieldElement, usernameFieldErrorElement);
    }

    @And("user enters a password {string} on the registration page")
    public void userEntersAPasswordOnTheRegistrationPage(String password) {
        registrationPage.clearPassword();
        registrationPage.setPassword(password);
    }

    @And("user enters a confirm password {string} on the registration page")
    public void userEntersAConfirmPasswordOnTheRegistrationPage(String password) {
        registrationPage.clearConfirmPassword();
        registrationPage.setConfirmPassword(password);
    }

    @And("user sets the gender to {string} on the registration page")
    public void userSetsTheGenderToOnTheRegistrationPage(String gender) {
        registrationPage.setGender(gender);
    }

    @Then("registration is successful and user is redirected to login page")
    public void registrationIsSuccessfulAndUserIsRedirectedToLoginPage() {
        WebElement loginElement = loginPage.getLoginElement();

        retryClickUntilVisible(driver, registrationPage.getRegisterButton(), loginElement);
        Assertions.assertTrue(loginElement.isDisplayed());
    }
}
