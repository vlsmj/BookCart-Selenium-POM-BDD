package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WishlistPage extends BasePage {

    @FindBy(xpath = "//app-wishlist")
    WebElement appWishlist;

    @FindBy(xpath = "//mat-card//table/tbody/tr")
    List<WebElement> listOfBooksWishlist;

    @FindBy(xpath = "//button[normalize-space()='Clear Wishlist']")
    WebElement buttonClearWishlist;

    public WishlistPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getWishlistElement() {
        return appWishlist;
    }

    public List<WebElement> getBooksInWishlist() {
        return listOfBooksWishlist;
    }

    public void waitForWishlistToBeEmpty() {
        waitListToBeEmpty(getBooksInWishlist());
    }

    public WebElement getBookByTitle(String title) {
        for (WebElement book : getBooksInWishlist()) {
            String bookTitle = book.findElement(By.cssSelector(".mat-column-title")).getText().toLowerCase();
            if (title.toLowerCase().equals(bookTitle)) {
                return book;
            }
        }
        return null;
    }

    public void removeBook(String title) {
        WebElement buttonRemove = getBookByTitle(title).findElement(By.xpath(".//button[normalize-space()='Remove from Wishlist']"));
        buttonRemove.click();
    }

    public void clearWishlist() {
        try {
            buttonClearWishlist.click();
        } catch (NoSuchElementException exception) {
            System.out.println("Wishlist is empty. Skipping clear button click.");
        }
    }
}
