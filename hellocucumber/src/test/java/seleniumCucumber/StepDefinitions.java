package seleniumCucumber;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public class StepDefinitions {
    WebDriver driver;
    @Given("user goes to the {string}")
    public void user_goes_to_the(String pageUrl) {
        driver.get(pageUrl);
    }
    @Then("user waits for {int} seconds")
    public void user_waits_for_seconds(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }
    @Then("verifies that the page title contains the word {string}")
    public void verifies_that_the_page_title_contains_the_word(String title) {
        String actualTitle = driver.getTitle();
        Assertions.assertTrue(actualTitle.contains(title));
    }
    @Then("closes the page")
    public void closes_the_page() {
        driver.quit();
    }
    @Before
    public void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

}
