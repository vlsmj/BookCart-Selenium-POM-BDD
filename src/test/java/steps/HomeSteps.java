package steps;

import hooks.DriverHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class HomeSteps {
    private final HomePage homePage;

    public HomeSteps(DriverHooks driverHooks) {
        WebDriver driver = driverHooks.getDriver();
        this.homePage = new HomePage(driver);
    }

    @Then("there is a list of books displayed")
    public void thereIsAListOfBooksDisplayed() {
        Assertions.assertFalse(homePage.getBooks().isEmpty());
    }

    @Then("there is a list of books displayed with the title {string}")
    public void thereIsAListOfBooksDisplayedWithTheTitle(String title) {
        Assertions.assertTrue(homePage.verifyBooksWithTitle(title));
    }

    @Then("there is a list of books displayed that contains {string} in the title")
    public void thereIsAListOfBooksDisplayedThatContainsInTheTitle(String keyword) {
        Assertions.assertTrue(homePage.verifyBooksWithTitle(keyword));
    }

    @Given("there is a list of categories in the sidebar")
    public void thereIsAListOfCategoriesInTheSidebar() {
        Assertions.assertFalse(homePage.getCategories().isEmpty());
    }

    @When("user clicks the {string} category in the sidebar")
    public void userClicksTheCategoryInTheSidebar(String categoryName) {
        homePage.clickCategory(categoryName);
    }

    @When("user sets the maximum price to {int}")
    public void userSetsTheMaximumPriceTo(int price) {
        homePage.slidePriceTo(price);
    }

    @And("the lowest priced book is not less than {int}")
    public void theLowestPricedBookIsNotLessThan(int price) {
        Assertions.assertFalse(homePage.getLowestPricedBook() < price);
    }

    @And("the maximum priced book is not greater than {int}")
    public void theMaximumPricedBookIsNotGreaterThan(int price) {
        Assertions.assertFalse(homePage.getHighestPricedBook() > price);
    }

    @When("user clicks the first book in the list")
    public void userClicksTheFirstBookInTheList() {
        homePage.clickFirstBook();
    }
}
