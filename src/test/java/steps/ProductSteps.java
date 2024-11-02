package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSteps {
    @Given("user is on the Home page")
    public void userIsOnTheHomePage() {
    }

    @Then("there is a list of books displayed")
    public void thereIsAListOfBooksDisplayed() {
    }

    @When("user clicks the first book in the list")
    public void userClicksTheFirstBookInTheList() {
    }

    @Then("user should be redirected to the book details page")
    public void userShouldBeRedirectedToTheBookDetailsPage() {
    }

    @And("title, author, category, and price is displayed")
    public void titleAuthorCategoryAndPriceIsDisplayed() {
    }

    @Given("there is a list of categories in the sidebar")
    public void thereIsAListOfCategoriesInTheSidebar() {
    }

    @When("user clicks the first category in the sidebar")
    public void userClicksTheFirstCategoryInTheSidebar() {
    }

    @And("the book category is {string}")
    public void theBookCategoryIs(String arg0) {
    }

    @When("user sets the maximum price to {string}")
    public void userSetsTheMaximumPriceTo(String arg0) {
    }

    @And("the lowest priced book is {string}")
    public void theLowestPricedBookIs(String arg0) {
    }

    @And("the maximum priced book is less than or equal to {string}")
    public void theMaximimumPricedBookIsLessThanOrEqualTo(String arg0) {
    }
}
