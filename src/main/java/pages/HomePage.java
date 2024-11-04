package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class HomePage {

    @FindBy(xpath = "//app-home")
    WebElement appHome;

    @FindBy(xpath = "//div[contains(@class, 'card-deck-container')]//mat-card")
    List<WebElement> listOfBooks;

    @FindBy(xpath = "//mat-nav-list/mat-list-item")
    List<WebElement> listOfCategories;

    @FindBy(xpath = "//mat-slider/input")
    WebElement priceSlider;

    public HomePage(WebDriver driver) {
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
            String title = book.findElement(By.cssSelector(".card-title")).getText().toLowerCase();
            if (!title.contains(keyword.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    public double getLowestPricedBook() {
        return getPrices().getFirst();
    }

    public double getHighestPricedBook() {
        return getPrices().getLast();
    }

    private List<Double> getPrices() {
        List<Double> prices = new ArrayList<>();
        for (WebElement book : getBooks()) {
            String rawPrice = book.findElement(By.xpath("mat-card-content/p")).getText();
            double price = Double.parseDouble(rawPrice.replace("₹", ""));
            prices.add(price);
        }
        Collections.sort(prices);
        System.out.println(prices);
        return prices;
    }

    public List<WebElement> getCategories() {
        return listOfCategories;
    }

    public void clickCategory(String categoryName) {
        for (WebElement category : getCategories()) {
            String name = category.findElement(By.xpath("span")).getText();

            if (categoryName.equals(name)) {
                category.click();
                break;
            }
        }
    }

    public void clickFirstBook() {
        getBooks().getFirst().click();
    }

    public void slidePriceTo(int price) {
        try {
            int max = Integer.parseInt(Objects.requireNonNull(priceSlider.getAttribute("max")));
            int step = Integer.parseInt(Objects.requireNonNull(priceSlider.getAttribute("step")));
            int enterCount = (max / step) - (price / step);

            for (int i = 0; i < enterCount; i++) {
                priceSlider.sendKeys(Keys.LEFT);
            }
        } catch (NullPointerException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
