package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookDetailsPage extends BasePage {

    @FindBy(xpath = "//app-book-details")
    WebElement appBookDetails;

    @FindBy(xpath = "//mat-card-content//table/tbody/tr[2]/td[2]")
    WebElement author;

    public BookDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getBookDetailsElement() {
        return appBookDetails;
    }

    public String getAuthorName() {
        return author.getText();
    }
}
