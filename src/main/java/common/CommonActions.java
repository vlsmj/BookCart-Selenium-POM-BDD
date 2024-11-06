package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BasePage;

import java.util.HashMap;

public class CommonActions extends BasePage {
    private final HashMap<String, String> pages = new HashMap<>();

    @FindBy(xpath = "//simple-snack-bar/div")
    WebElement snackBarMessage;

    @FindBy(id = "cdk-overlay-38")
    WebElement snackBarOverlay;

    public CommonActions(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

        setupPages();
    }

    private void setupPages() {
        pages.put("home", "https://bookcart.azurewebsites.net/");
        pages.put("login", "https://bookcart.azurewebsites.net/login");
        pages.put("registration", "https://bookcart.azurewebsites.net/register");
    }

    public void navigateTo(String page) {
        driver.get(pages.get(page));
    }

    public String getSnackBarMessage() {
        waitVisibility(snackBarMessage);
        String message = snackBarMessage.getText();
        waitInvisibility(snackBarOverlay);
        return message;
    }
}
