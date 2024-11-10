package steps;

import hooks.DriverHooks;
import io.cucumber.java.en.And;
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

    @When("the user enters a username {string} on the login page")
    public void theUserEntersAUsernameOnTheLoginPage(String username) {
        loginPage.setUsername(username);
    }

    @And("the user enters a password {string} on the login page")
    public void theUserEntersAPasswordOnTheLoginPage(String password) {
        loginPage.setPassword(password);
    }

    @And("the user clicks the login button")
    public void theUserClicksTheLoginButton() {
        loginPage.clickLogin();
    }

    @Then("username field displays the error message {string} on the login page")
    public void usernameFieldDisplaysTheErrorMessageOnTheLoginPage(String errorMessage) {
        Assertions.assertEquals(errorMessage, loginPage.getUsernameFieldErrorMessage());
    }

    @And("password field displays the error message {string} on the login page")
    public void passwordFieldDisplaysTheErrorMessageOnTheLoginPage(String errorMessage) {
        Assertions.assertEquals(errorMessage, loginPage.getPasswordFieldErrorMessage());
    }

    @Then("the user should see an error message {string} on the login page")
    public void theUserShouldSeeAnErrorMessageOnTheLoginPage(String errorMessage) {
        Assertions.assertEquals(errorMessage, loginPage.getErrorMessage());
    }

    @Then("login is successful and user is redirected to home page")
    public void loginIsSuccessfulAndUserIsRedirectedToHomePage() {
        Assertions.assertTrue(homePage.getHomeElement().isDisplayed());
    }

    @And("user is logged in with username {string} and password {string}")
    public void userIsLoggedInWithUsernameAndPassword(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLogin();
        Assertions.assertTrue(homePage.getHomeElement().isDisplayed());
    }
}
