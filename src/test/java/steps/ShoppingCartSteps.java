package steps;

import components.HeaderComponent;
import hooks.DriverHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.ShoppingCartPage;

public class ShoppingCartSteps {
    private final HeaderComponent headerComponent;
    private final ShoppingCartPage shoppingCartPage;

    public ShoppingCartSteps(DriverHooks driverHooks) {
        WebDriver driver = driverHooks.getDriver();

        headerComponent = new HeaderComponent(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
    }

    @And("the shopping cart icon displays a count of {int}")
    public void theShoppingCartIconDisplaysACountOf(int expectedCount) {
        Assertions.assertEquals(expectedCount, headerComponent.getCartCount(expectedCount));
    }

    @When("the user clicks the shopping cart icon")
    public void theUserClicksTheShoppingCartIcon() {
        headerComponent.clickCart();
    }

    @Then("the user is redirected to the shopping cart page")
    public void theUserIsRedirectedToTheShoppingCartPage() {
        Assertions.assertTrue(shoppingCartPage.getShoppingCartElement().isDisplayed());
    }

    @And("the book {string} is listed in the shopping cart")
    public void theBookIsListedInTheShoppingCart(String title) {
        Assertions.assertTrue(shoppingCartPage.getBookByTitle(title).isDisplayed());
    }

    @When("the user increases the quantity of the book {string} by {int}")
    public void theUserIncreasesTheQuantityOfTheBookBy(String title, int step) {
        shoppingCartPage.increaseQuantity(title, step);
    }

    @When("the user decreases the quantity of the book {string} by {int}")
    public void theUserDecreasesTheQuantityOfTheBookBy(String title, int step) {
        shoppingCartPage.decreaseQuantity(title, step);
    }

    @Then("the quantity of the book {string} updates to {int}")
    public void theQuantityOfTheBookUpdatesTo(String title, int expectedQuantity) {
        Assertions.assertEquals(expectedQuantity, shoppingCartPage.getQuantity(title, expectedQuantity));
    }

    @And("the price for the book {string} amounts to {string}")
    public void thePriceForTheBookAmountsTo(String title, String price) {
        Assertions.assertEquals(price, shoppingCartPage.getPrice(title));
    }

    @And("the cart total price amounts to {string}")
    public void theCartTotalPriceAmountsTo(String price) {
        Assertions.assertEquals(price, shoppingCartPage.getCartTotalPrice());
    }

    @When("user clicks the delete item action for the book {string}")
    public void userClicksTheDeleteItemActionForTheBook(String title) {
        shoppingCartPage.removeBook(title);
    }

    @And("the book {string} is removed from the shopping cart list")
    public void theBookIsRemovedFromTheShoppingCartList(String title) {
        Assertions.assertNull(shoppingCartPage.getBookByTitle(title));
    }

    @When("the user clicks the clear cart button")
    public void theUserClicksTheClearCartButton() {
        shoppingCartPage.clickClearCart();
    }

    @Then("all books in the shopping cart are removed")
    public void allBooksInTheShoppingCartAreRemoved() {
        shoppingCartPage.waitForCartToBeEmpty();
        Assertions.assertTrue(shoppingCartPage.getBooksInCart().isEmpty());
    }

    @And("the shopping cart is empty empty")
    public void theShoppingCartIsEmptyEmpty() {
        shoppingCartPage.clickClearCart();
        shoppingCartPage.waitForCartToBeEmpty();
        Assertions.assertTrue(shoppingCartPage.getBooksInCart().isEmpty());
    }
}
