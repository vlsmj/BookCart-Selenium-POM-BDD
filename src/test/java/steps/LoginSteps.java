package steps;

import hooks.DriverHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

public class LoginSteps {
    private final LoginPage loginPage;
    private final HomePage homePage;

    public LoginSteps(DriverHooks driverHooks) {
        WebDriver driver = driverHooks.getDriver();

        this.loginPage = new LoginPage(driver);
        this.homePage = new HomePage(driver);
    }

    @Given("User is on the login page")
    public void userIsOnTheLoginPage() {
        loginPage.navigateTo("https://bookcart.azurewebsites.net/login");
    }

    @When("User enters a username {string} on the login page")
    public void userEntersAUsernameOnTheLoginPage(String username) {
        loginPage.setUsername(username);
    }

    @And("User enters a password {string} on the login page")
    public void userEntersAPasswordOnTheLoginPage(String password) {
        loginPage.setPassword(password);
    }

    @And("User clicks the login button")
    public void userClicksTheLoginButton() {
        loginPage.clickLogin();
    }

    @Then("Username field displays the error message {string} on the login page")
    public void usernameFieldDisplaysTheErrorMessageOnTheLoginPage(String errorMessage) {
        Assertions.assertEquals(errorMessage, loginPage.getUsernameFieldErrorMessage());
    }

    @And("Password field displays the error message {string} on the login page")
    public void passwordFieldDisplaysTheErrorMessageOnTheLoginPage(String errorMessage) {
        Assertions.assertEquals(errorMessage, loginPage.getPasswordFieldErrorMessage());
    }

    @Then("User should see an error message {string} on the login page")
    public void userShouldSeeAnErrorMessageOnTheLoginPage(String errorMessage) {
        Assertions.assertEquals(errorMessage, loginPage.getErrorMessage());
    }

    @Then("Login is successful and user is redirected to home page")
    public void loginIsSuccessfulAndUserIsRedirectedToHomePage() {
        Assertions.assertTrue(homePage.getHomeElement().isDisplayed());
    }
}
