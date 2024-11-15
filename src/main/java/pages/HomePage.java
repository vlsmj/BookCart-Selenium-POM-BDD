package pages;

import base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static utils.NumberUtils.convertPriceToDouble;

public class HomePage extends BasePage {

    @FindBy(xpath = "//app-home")
    WebElement appHome;

    @FindBy(xpath = "//div[contains(@class, 'card-deck-container')]//mat-card")
    List<WebElement> listOfBooks;

    @FindBy(xpath = "//mat-nav-list/mat-list-item")
    List<WebElement> listOfCategories;

    @FindBy(xpath = "//mat-slider/input")
    WebElement priceSlider;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getHomeElement() {
        return appHome;
    }

    public List<WebElement> getBooks() {
        return listOfBooks;
    }

    public boolean verifyBooksWithTitle(String keyword) {
        for (WebElement book : getBooks()) {
            String bookTitle = book.findElement(By.cssSelector(".card-title")).getText().toLowerCase();
            if (!bookTitle.contains(keyword.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyBooksHaveHeartIcons() {
        for (WebElement book : getBooks()) {
            try {
                book.findElement(By.xpath(".//span[normalize-space()='favorite']"));
            } catch (NoSuchElementException exception) {
                return false;
            }
        }
        return true;
    }

    public void addToCartBookByTitle(String title) {
        for (WebElement book : getBooks()) {
            String bookTitle = book.findElement(By.cssSelector(".card-title")).getText().toLowerCase();
            if (title.toLowerCase().equals(bookTitle)) {
                WebElement buttonAddToCart = book.findElement(By.xpath(".//app-addtocart/button"));

                new Actions(driver)
                        .moveToElement(buttonAddToCart)
                        .perform();

                waitClickable(buttonAddToCart);
                return;
            }
        }
    }

    public void addToWishlistBookByTitle(String title) {
        for (WebElement book : getBooks()) {
            String bookTitle = book.findElement(By.cssSelector(".card-title")).getText().toLowerCase();
            if (title.toLowerCase().equals(bookTitle)) {
                WebElement heartIcon = book.findElement(By.xpath(".//span[normalize-space()='favorite']"));

                new Actions(driver)
                        .moveToElement(heartIcon)
                        .perform();

                waitClickable(heartIcon);
                return;
            }
        }
    }

    public WebElement getBookStateByTitle(String title, String state) {
        for (WebElement book : getBooks()) {
            String bookTitle = book.findElement(By.cssSelector(".card-title")).getText().toLowerCase();
            if (title.toLowerCase().equals(bookTitle)) {
                String favouriteState = "favourite-" + state;

                return book.findElement(By.xpath(".//span[contains(@class, '" + favouriteState + "')]"));
            }
        }
        return null;
    }

    public double getLowestBookPrice() {
        return getPrices().getFirst();
    }

    public double getHighestBookPrice() {
        return getPrices().getLast();
    }

    private List<Double> getPrices() {
        List<Double> prices = new ArrayList<>();
        for (WebElement book : getBooks()) {
            String rawPrice = book.findElement(By.xpath(".//mat-card-content/p")).getText();
            double price = convertPriceToDouble(rawPrice);
            prices.add(price);
        }
        Collections.sort(prices);
        return prices;
    }

    public List<WebElement> getCategories() {
        return listOfCategories;
    }

    public void clickCategory(String categoryName) {
        for (WebElement category : getCategories()) {
            String name = category.findElement(By.xpath(".//span")).getText();

            if (categoryName.equals(name)) {
                category.click();
                break;
            }
        }
    }

    public void clickFirstBook() {
        getBooks().getFirst().click();
    }

    public void slidePriceTo(double price) {
        try {
            int max = Integer.parseInt(Objects.requireNonNull(priceSlider.getAttribute("max")));
            int step = Integer.parseInt(Objects.requireNonNull(priceSlider.getAttribute("step")));
            double enterCount = ((double) max / step) - (price / step);

            for (int i = 0; i < enterCount; i++) {
                priceSlider.sendKeys(Keys.LEFT);
            }
        } catch (NullPointerException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
