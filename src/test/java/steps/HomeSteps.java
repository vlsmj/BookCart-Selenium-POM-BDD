package steps;

import hooks.DriverHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

import static utils.NumberUtils.convertPriceToDouble;

public class HomeSteps {
    private final HomePage homePage;

    public HomeSteps(DriverHooks driverHooks) {
        WebDriver driver = driverHooks.getDriver();

        homePage = new HomePage(driver);
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

    @When("the user clicks the {string} category in the sidebar")
    public void theUserClicksTheCategoryInTheSidebar(String categoryName) {
        homePage.clickCategory(categoryName);
    }

    @When("the user sets the maximum price to {string}")
    public void theUserSetsTheMaximumPriceTo(String price) {
        homePage.slidePriceTo(convertPriceToDouble(price));
    }

    @And("the lowest priced book is not less than {string}")
    public void theLowestPricedBookIsNotLessThan(String price) {
        Assertions.assertFalse(homePage.getLowestBookPrice() < convertPriceToDouble(price));
    }

    @And("the maximum priced book is not greater than {string}")
    public void theMaximumPricedBookIsNotGreaterThan(String price) {
        Assertions.assertFalse(homePage.getHighestBookPrice() > convertPriceToDouble(price));
    }

    @When("the user clicks the first book in the list")
    public void theUserClicksTheFirstBookInTheList() {
        homePage.clickFirstBook();
    }

    @When("the user clicks add to cart button for the book titled {string} on the home page")
    public void theUserClicksAddToCartButtonForTheBookTitledOnTheHomePage(String title) {
        homePage.addToCartBookByTitle(title);
    }
}
