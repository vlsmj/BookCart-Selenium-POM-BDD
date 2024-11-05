package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test.html/java/features",
        glue = {"steps", "hooks"},
        plugin = {"pretty", "html:target/cucumber-reports"},
        monochrome = true
)
public class TestRunner {
}
