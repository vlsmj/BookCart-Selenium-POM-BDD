package steps;

import hooks.DriverHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.BookDetailsPage;

public class BookDetailsSteps {
    private final BookDetailsPage bookDetailsPage;

    public BookDetailsSteps(DriverHooks driverHooks) {
        WebDriver driver = driverHooks.getDriver();

        bookDetailsPage = new BookDetailsPage(driver);
    }

    @Then("the user is redirected to the book details page")
    public void theUserIsRedirectedToTheBookDetailsPage() {
        Assertions.assertTrue(bookDetailsPage.getBookDetailsElement().isDisplayed());
    }

    @And("the author of the book displayed is {string}")
    public void theAuthorOfTheBookDisplayedIs(String name) {
        Assertions.assertEquals(name, bookDetailsPage.getAuthorName());
    }
}
