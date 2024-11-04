package utils;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class CommonActions {
    private final WebDriver driver;
    private final HashMap<String, String> pages = new HashMap<>();

    public CommonActions(WebDriver driver) {
        this.driver = driver;

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
}
