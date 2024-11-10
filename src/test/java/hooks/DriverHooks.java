package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Collection;

public class DriverHooks {
    private WebDriver driver;

    @Before
    public void setUp(Scenario scenario) {
        Collection<String> tags = scenario.getSourceTagNames();
        if (tags.contains("@firefox")) {
            driver = new FirefoxDriver();
        } else {
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public WebDriver getDriver() {
        return driver;
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
