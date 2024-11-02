package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookDetailsPage extends BasePage {

    @FindBy(xpath = "//app-book-details")
    WebElement appBookDetails;

    @FindBy()
    WebElement bookDetailsTitle;

    @FindBy()
    WebElement title;

    @FindBy()
    WebElement author;

    @FindBy()
    WebElement category;

    @FindBy()
    WebElement price;

    public BookDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
