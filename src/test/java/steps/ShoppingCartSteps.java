package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShoppingCartSteps {
    @And("the shopping cart icon displays a count of {int}")
    public void theShoppingCartIconDisplaysACountOf(int arg0) {
    }

    @When("the user clicks add to cart button for the book titled {string} in the list of books")
    public void theUserClicksAddToCartButtonForTheBookTitledInTheListOfBooks(String arg0) {
    }

    @When("the user clicks the shopping cart icon")
    public void theUserClicksTheShoppingCartIcon() {
    }

    @Then("the user is redirected to the shopping cart page")
    public void theUserIsRedirectedToTheShoppingCartPage() {
    }

    @And("the book {string} is listed in the shopping cart with quantity {int}")
    public void theBookIsListedInTheShoppingCartWithQuantity(String arg0, int arg1) {
    }

    @When("the user increases the quantity of the book {string} by {int}")
    public void theUserIncreasesTheQuantityOfTheBookBy(String arg0, int arg1) {
    }

    @Then("the quantity of the book {string} updates to {int}")
    public void theQuantityOfTheBookUpdatesTo(String arg0, int arg1) {
    }

    @And("the price for the book {string} is updated to reflect the new quantity")
    public void thePriceForTheBookIsUpdatedToReflectTheNewQuantity(String arg0) {
    }

    @And("the cart total displays the correct price")
    public void theCartTotalDisplaysTheCorrectPrice() {
    }
}
