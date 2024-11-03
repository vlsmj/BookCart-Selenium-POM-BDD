package pages;

import base.BasePage;
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

    public double getLowestPricedBook() {
        return getPrices().getFirst();
    }

    public double getHighestPricedBook() {
        return getPrices().getLast();
    }

    private List<Double> getPrices() {
        List<Double> prices = new ArrayList<>();
        for (WebElement book : listOfBooks) {
            String rawPrice = book.findElement(By.xpath("mat-card-content/p")).getText();
            double price = Double.parseDouble(rawPrice.replace("₹", ""));
            prices.add(price);
        }
        Collections.sort(prices);
        return prices;
    }

    public List<WebElement> getCategories() {
        return listOfCategories;
    }

    public void clickCategory(String categoryName) {
        for (WebElement category : listOfCategories) {
            String name = category.findElement(By.xpath("span")).getText();

            if (categoryName.equals(name)) {
                category.click();
                break;
            }
        }
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
