package components;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BasePage;

public class HeaderComponent extends BasePage {

    @FindBy(xpath = "//input[contains(@class, 'searchbox')]")
    WebElement searchBar;

    @FindBy(xpath = "//mat-toolbar-row/div[3]/button[1]")
    WebElement cartIcon;

    @FindBy(id = "mat-badge-content-0")
    WebElement cartCount;

    public HeaderComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void setKeyword(String keyword) {
        searchBar.sendKeys(keyword);
    }

    public void enterSearch() {
        searchBar.sendKeys(Keys.ENTER);
    }

    public int getCartCount(int expectedCount) {
        waitTextToBe(cartCount, String.valueOf(expectedCount));
        return Integer.parseInt(cartCount.getText());
    }

    public void clickCart() {
        cartIcon.click();
    }
}
