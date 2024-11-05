package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;

    private final long maxTimeout = 5000;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void retryClickUntilVisible(WebElement clickElement, WebElement visibleElement) {
        int maxRetryCount = 3;
        int retryCount = 0;

        while (retryCount < maxRetryCount) {
            try {
                retryCount++;

                clickElement.click();

                WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofMillis(maxTimeout));
                webDriverWait.until(ExpectedConditions.visibilityOf(visibleElement));
                return;
            } catch (NoSuchElementException | TimeoutException exception) {
                System.out.println("Attempt " + retryCount + " failed: " + exception.getMessage() + ". Retrying...");
            }
        }
    }

    public void waitClickable(WebElement clickElement) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofMillis(maxTimeout));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(clickElement));

        clickElement.click();
    }

    public void waitTextToBe(WebElement webElement, String text) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofMillis(maxTimeout));
        webDriverWait.until(_ -> webElement.getText().equals(text));
    }
}