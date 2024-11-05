package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShoppingCartPage extends BasePage {

    @FindBy(xpath = "//app-shoppingcart")
    WebElement appShoppingCart;

    @FindBy(xpath = "//mat-card//table/tbody/tr")
    List<WebElement> listOfBooksCart;

    @FindBy(xpath = "//mat-card-content[2]/td[5]")
    WebElement cartTotal;

    @FindBy(xpath = "//button[span(text()='Clear cart')]")
    WebElement buttonClearCart;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getShoppingCartElement() {
        return appShoppingCart;
    }

    public List<WebElement> getBooksInCart() {
        return listOfBooksCart;
    }

    public WebElement getBookByTitle(String title) {
        for (WebElement book : listOfBooksCart) {
            String bookTitle = book.findElement(By.cssSelector(".mat-column-title")).getText().toLowerCase();
            if (title.toLowerCase().equals(bookTitle)) {
                return book;
            }
        }
        return null;
    }

    public void increaseQuantity(String title, int step) {
        WebElement buttonIncrement = getBookByTitle(title).findElement(By.xpath("//td[contains(@class, 'mat-column-quantity')]//button[2]"));
        for (int i = 0; i < step; i++) {
            buttonIncrement.click();
            waitClickable(buttonIncrement);
        }
    }

    public void decreaseQuantity(String title, int step) {
        WebElement buttonDecrement = getBookByTitle(title).findElement(By.xpath("//td[contains(@class, 'mat-column-quantity')]//button[1]"));
        for (int i = 0; i < step; i++) {
            buttonDecrement.click();
            waitClickable(buttonDecrement);
        }
    }

    public int getQuantity(String title) {
        WebElement quantity = getBookByTitle(title).findElement(By.xpath("//td[contains(@class, 'mat-column-quantity')]/div/div[2]"));
        return Integer.parseInt(quantity.getText());
    }

    public double getPrice(String title) {
        WebElement quantity = getBookByTitle(title).findElement(By.xpath("//td[contains(@class, 'mat-column-total')]"));
        return Double.parseDouble(quantity.getText().replace("₹", ""));
    }

    public double getCartTotalPrice() {
        return Double.parseDouble(cartTotal.getText());
    }

    public void removeBook(String title) {
        WebElement deleteIcon = getBookByTitle(title).findElement(By.xpath("//td[contains(@class, 'mat-column-action')]/button"));
        deleteIcon.click();
    }

    public void clearCart() {
        buttonClearCart.click();
    }
}
