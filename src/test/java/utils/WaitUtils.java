package utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    public static void retryClickUntilVisible(WebDriver driver, WebElement clickElement, WebElement visibleElement) {
        int retryCount = 0;
        int maxRetryCount = 3;
        long maxTimeout = 3000;

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
}
