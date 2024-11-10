package steps;

import hooks.DriverHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.OrderPage;
import pages.ShoppingCartPage;

public class CheckoutSteps {
    private final CheckoutPage checkoutPage;
    private final ShoppingCartPage shoppingCartPage;
    private final LoginPage loginPage;
    private final OrderPage orderPage;

    public CheckoutSteps(DriverHooks driverHooks) {
        WebDriver driver = driverHooks.getDriver();

        checkoutPage = new CheckoutPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        loginPage = new LoginPage(driver);
        orderPage = new OrderPage(driver);
    }

    @When("the user clicks the check out button")
    public void theUserClicksTheCheckOutButton() {
        shoppingCartPage.clickCheckOut();
    }

    @Then("the user is redirected to the login page")
    public void theUserIsRedirectedToTheLoginPage() {
        Assertions.assertTrue(loginPage.getLoginElement().isDisplayed());
    }

    @Then("the user is redirected to the checkout page")
    public void theUserIsRedirectedToTheCheckoutPage() {
        Assertions.assertTrue(checkoutPage.getCheckoutElement().isDisplayed());
    }

    @When("the user leaves empty inputs on the checkout page")
    public void theUserLeavesEmptyInputsOnTheCheckoutPage() {
        try {
            // Add sleep each input field for the delay of showing error messages
            checkoutPage.setName("");
            Thread.sleep(200);
            checkoutPage.setAddressLine1("");
            Thread.sleep(200);
            checkoutPage.setAddressLine2("");
            Thread.sleep(200);
            checkoutPage.setPinCode("");
            Thread.sleep(200);
            checkoutPage.setState("");
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("the user clicks the place order button")
    public void theUserClicksThePlaceOrderButton() {
        checkoutPage.clickPlaceOrder();
    }

    @Then("input field {string} displays the error message {string} on the checkout page")
    public void inputFieldDisplaysTheErrorMessageOnTheCheckoutPage(String inputField, String errorMessage) {
        Assertions.assertEquals(errorMessage, checkoutPage.getInputFieldErrorMessage(inputField));
    }

    @When("the user enter valid inputs on the checkout page")
    public void theUserEnterValidInputsOnTheCheckoutPage() {
        checkoutPage.setName("John Doe");
        checkoutPage.setAddressLine1("1642 Reyes Locks");
        checkoutPage.setAddressLine2("New Robt, MT 56735");
        checkoutPage.setPinCode("123456");
        checkoutPage.setState("Hawaii");
    }

    @And("the user enters a pin code {string} on the checkout page")
    public void theUserEntersAPinCodeOnTheCheckoutPage(String pinCode) {
        checkoutPage.setPinCode(pinCode);
    }

    @And("the user is redirected to the orders page")
    public void theUserIsRedirectedToTheOrdersPage() {
        Assertions.assertTrue(orderPage.getMyOrdersElement().isDisplayed());
    }

    @And("the order summary displays the book {string} with quantity {int}, price of {string}, and total of {string}")
    public void theOrderSummaryDisplaysTheBookWithQuantityPriceOfAndTotalOf(String title, int quantity, String price, String totalPrice) {
        String bookTitle = checkoutPage.getBookTitle(title);
        int bookQuantity = checkoutPage.getQuantityByTitle(title);
        String bookPrice = checkoutPage.getPriceByTitle(title);
        String bookTotalPrice = checkoutPage.getTotalPriceByTitle(title);

        Assertions.assertEquals(title, bookTitle);
        Assertions.assertEquals(quantity, bookQuantity);
        Assertions.assertEquals(price, bookPrice);
        Assertions.assertEquals(totalPrice, bookTotalPrice);
    }

    @And("the order summary displays the grand total amount of {string}")
    public void theOrderSummaryDisplaysTheGrandTotalAmountOf(String grandTotalPrice) {
        Assertions.assertEquals(grandTotalPrice, checkoutPage.getGrandTotalPrice());
    }
}
