package base;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    private final WebDriverWait webDriverWait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        long maxTimeout = 5000;
        this.webDriverWait = new WebDriverWait(driver, Duration.ofMillis(maxTimeout));
    }

    public void retryClickUntilVisible(WebElement clickElement, WebElement visibleElement) {
        int maxRetryCount = 3;
        int retryCount = 0;

        while (retryCount < maxRetryCount) {
            try {
                retryCount++;

                clickElement.click();

                webDriverWait.until(ExpectedConditions.visibilityOf(visibleElement));
                return;
            } catch (NoSuchElementException | TimeoutException exception) {
                System.out.println("Attempt " + retryCount + " failed: " + exception.getMessage() + ". Retrying...");
            }
        }
    }

    public void waitClickable(WebElement clickElement) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(clickElement));
        clickElement.click();
    }

    public void waitVisibility(WebElement webElement) {
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitInvisibility(WebElement webElement) {
        webDriverWait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    public void waitTextToBe(WebElement webElement, String text) {
        webDriverWait.until(_ -> webElement.getText().equals(text));
    }
}