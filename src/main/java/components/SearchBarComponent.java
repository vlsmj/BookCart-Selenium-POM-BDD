package components;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchBarComponent {

    @FindBy(xpath = "//input[contains(@class, 'searchbox')]")
    WebElement searchBar;

    public SearchBarComponent(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void setKeyword(String keyword) {
        searchBar.sendKeys(keyword);
    }

    public void enter() {
        searchBar.sendKeys(Keys.ENTER);
    }
}
