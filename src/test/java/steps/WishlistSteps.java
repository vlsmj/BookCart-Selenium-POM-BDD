package steps;

import common.CommonActions;
import components.HeaderComponent;
import hooks.DriverHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.WishlistPage;

public class WishlistSteps {
    private final WishlistPage wishlistPage;
    private final HomePage homePage;
    private final HeaderComponent headerComponent;
    private final CommonActions commonActions;

    public WishlistSteps(DriverHooks driverHooks) {
        WebDriver driver = driverHooks.getDriver();

        wishlistPage = new WishlistPage(driver);
        homePage = new HomePage(driver);
        headerComponent = new HeaderComponent(driver);
        commonActions = new CommonActions(driver);
    }

    @And("heart icons are not displayed for each book in the list")
    public void heartIconsAreNotDisplayedForEachBookInTheList() {
        Assertions.assertFalse(homePage.verifyBooksHaveHeartIcons());
    }

    @And("heart icons are displayed for each book in the list")
    public void heartIconsAreDisplayedForEachBookInTheList() {
        Assertions.assertTrue(homePage.verifyBooksHaveHeartIcons());
    }

    @And("the wishlist icon displays a count of {int}")
    public void theWishlistIconDisplaysACountOf(int expectedCount) {
        Assertions.assertEquals(expectedCount, headerComponent.getWishlistCount(expectedCount));
    }

    @When("the user clicks the heart icon for the book titled {string} in the list of books")
    public void theUserClicksTheHeartIconForTheBookTitledInTheListOfBooks(String title) {
        homePage.addToWishlistBookByTitle(title);
    }

    @And("the heart icon for the book {string} turns to {string} state")
    public void theHeartIconForTheBookTurnsToState(String title, String state) {
        Assertions.assertNotNull(homePage.getBookStateByTitle(title, state));
    }

    @When("the user clicks the heart icon in the header")
    public void theUserClicksTheHeartIconInTheHeader() {
        headerComponent.clickWishlist();
    }

    @Then("the user is redirected to the wishlist page")
    public void theUserIsRedirectedToTheWishlistPage() {
        Assertions.assertTrue(wishlistPage.getWishlistElement().isDisplayed());
    }

    @And("the book {string} is listed in the wishlist")
    public void theBookIsListedInTheWishlist(String title) {
        Assertions.assertTrue(wishlistPage.getBookByTitle(title).isDisplayed());
    }

    @And("the book {string} is removed from the wishlist")
    public void theBookIsRemovedFromTheWishlist(String title) {
        Assertions.assertNull(wishlistPage.getBookByTitle(title));
    }

    @When("user clicks the remove from wishlist button for the book {string}")
    public void userClicksTheRemoveFromWishlistButtonForTheBook(String title) {
        wishlistPage.removeBook(title);
    }

    @When("the user clicks the clear wishlist button")
    public void theUserClicksTheClearWishlistButton() {
        wishlistPage.clearWishlist();
    }

    @And("all books in the wishlist are removed")
    public void allBooksInTheWishlistAreRemoved() {
        wishlistPage.waitForWishlistToBeEmpty();
        Assertions.assertTrue(wishlistPage.getBooksInWishlist().isEmpty());
    }

    @And("the wishlist is empty")
    public void theWishlistIsEmpty() {
        wishlistPage.clearWishlist();
        wishlistPage.waitForWishlistToBeEmpty();
        Assertions.assertTrue(wishlistPage.getBooksInWishlist().isEmpty());
    }
}
