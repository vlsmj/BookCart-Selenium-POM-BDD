package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutPage extends BasePage {

    @FindBy(xpath = "//app-checkout")
    WebElement appCheckout;

    @FindBy(css = "input[formcontrolname='name']")
    WebElement inputName;

    @FindBy(css = "input[formcontrolname='addressLine1")
    WebElement inputAddressLine1;

    @FindBy(css = "input[formcontrolname='addressLine2")
    WebElement inputAddressLine2;

    @FindBy(css = "input[formcontrolname='pincode")
    WebElement inputPinCode;

    @FindBy(css = "input[formcontrolname='state")
    WebElement inputState;

    @FindBy(xpath = "//form/mat-form-field[1]//mat-error")
    WebElement nameFieldError;

    @FindBy(xpath = "//form/mat-form-field[2]//mat-error")
    WebElement addressLine1FieldError;

    @FindBy(xpath = "//form/mat-form-field[3]//mat-error")
    WebElement addressLine2FieldError;

    @FindBy(xpath = "//form/mat-form-field[4]//mat-error")
    WebElement pinCodeFieldError;

    @FindBy(xpath = "//form/mat-form-field[5]//mat-error")
    WebElement stateFieldError;

    @FindBy(xpath = "//table/tbody/tr")
    List<WebElement> listOfBooksOrderSummary;

    @FindBy(xpath = "//table/tfoot/tr/th[2]")
    WebElement grandTotalPrice;

    @FindBy(xpath = "//button[normalize-space()='Place Order']")
    WebElement buttonPlaceOrder;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getCheckoutElement() {
        return appCheckout;
    }

    public List<WebElement> getBooksInOrderSummary() {
        return listOfBooksOrderSummary;
    }

    public WebElement getBookByTitle(String title) {
        for (WebElement book : getBooksInOrderSummary()) {
            String bookTitle = book.findElement(By.xpath("./td[1]")).getText().toLowerCase();
            if (title.toLowerCase().equals(bookTitle)) {
                return book;
            }
        }
        return null;
    }

    public String getBookTitle(String title) {
        WebElement book = getBookByTitle(title);
        return book.findElement(By.xpath("./td[1]")).getText();
    }

    public int getQuantityByTitle(String title) {
        WebElement book = getBookByTitle(title);
        return Integer.parseInt(book.findElement(By.xpath("./td[2]")).getText());
    }

    public String getPriceByTitle(String title) {
        WebElement book = getBookByTitle(title);
        return book.findElement(By.xpath("./td[3]")).getText();
    }

    public String getTotalPriceByTitle(String title) {
        WebElement book = getBookByTitle(title);
        return book.findElement(By.xpath("./td[4]")).getText();
    }

    public String getGrandTotalPrice() {
        return grandTotalPrice.getText();
    }

    public void setName(String name) {
        inputName.sendKeys(name);
    }

    public void setAddressLine1(String address) {
        inputAddressLine1.sendKeys(address);
    }

    public void setAddressLine2(String address) {
        inputAddressLine2.sendKeys(address);
    }

    public void setPinCode(String pinCode) {
        inputPinCode.sendKeys(pinCode);
    }

    public void setState(String state) {
        inputState.sendKeys(state);
    }

    public String getInputFieldErrorMessage(String inputField) {
        return switch (inputField) {
            case "Name" -> nameFieldError.getText();
            case "Address Line 1" -> addressLine1FieldError.getText();
            case "Address Line 2" -> addressLine2FieldError.getText();
            case "Pin Code" -> pinCodeFieldError.getText();
            case "State" -> stateFieldError.getText();
            default -> "";
        };
    }

    public void clickPlaceOrder() {
        buttonPlaceOrder.click();
    }
}
