package steps;

import hooks.DriverHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.RegistrationPage;

public class RegistrationSteps {
    private final RegistrationPage registrationPage;

    public RegistrationSteps(DriverHooks driverHooks) {
        WebDriver driver = driverHooks.getDriver();

        registrationPage = new RegistrationPage(driver);
    }

//    @Given("User is on the registration page")
//    public void userIsOnTheRegistrationPage() {
//    }
//
//    @When("User enters a username {string}")
//    public void userEntersAUsername(String username) {
//
//    }
//
//    @When("User enters a first name {string}")
//    public void userEntersAFirstName(String firstName) {
//    }
//
//    @And("User enters a last name {string}")
//    public void userEntersALastName(String lastName) {
//    }
//
//    @And("User enters a password {string}")
//    public void userEntersAPassword(String password) {
//    }
//
//    @And("User enters a confirm password {string}")
//    public void userEntersAConfirmPassword(String password) {
//    }
//
//    @And("User clicks the registration button")
//    public void userClicksTheRegistrationButton() {
//    }

//    @When("User clicks register button")
//    public void userClicksRegisterButton() {
//        registrationPage.clickRegister();
//    }
//
//    @Then("First name field displays an error message indicating {string}")
//    public void firstNameFieldDisplaysAnErrorMessageIndicating(String errorMessage) {
//        System.out.println(registrationPage.getFirstNameErrorMessage());
//    }
//
//    @And("Last name field displays an error message indicating {string}")
//    public void lastNameFieldDisplaysAnErrorMessageIndicating(String errorMessage) {
//    }
//
//    @And("Username field displays an error message indicating {string}")
//    public void usernameFieldDisplaysAnErrorMessageIndicating(String errorMessage) {
//    }
//
//    @And("Password field displays an error message indicating {string}")
//    public void passwordFieldDisplaysAnErrorMessageIndicating(String errorMessage) {
//
//    }
//
//    @And("Confirm password field displays an error message indicating {string}")
//    public void confirmPasswordFieldDisplaysAnErrorMessageIndicating(String errorMessage) {
//    }
//
//    @And("User enters a password {string}")
//    public void userEntersAPassword(String password) {
//    }
//
//    @And("User enters a confirm password {string}")
//    public void userEntersAConfirmPassword(String password) {
//    }
//
//    @Then("User is navigated to the Login page")
//    public void userIsNavigatedToTheLoginPage() {
//
//    }
}
