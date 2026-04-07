package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.*;
import java.time.Duration;

public class LoginSteps {

    WebDriver driver = DriverFactory.getDriver();

    @Given("user is on login page")
    public void openBrowser() {
        driver = DriverFactory.getDriver();
        driver.get("https://demoqa.com/login"); // fixed URL
    }

    @When("user enters username {string} and password {string}")
    public void navigateTo(String username, String password) {

        // Correct locators
        driver.findElement(By.id("userName")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("clicks on login button")
    public void clicks_on_login_button() {

        // Define locator properly
        driver.findElement(By.id("login")).click();
    }

    @Then("login result should be {string}")
public void validateTitle(String expected) {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    if (expected.equalsIgnoreCase("success")) {
        wait.until(ExpectedConditions.urlContains("profile"));
        assertTrue(driver.getCurrentUrl().contains("profile"));
    } 
    else {
        // Wait for error message
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        String errorMsg = driver.findElement(By.id("name")).getText();

        assertTrue(errorMsg.contains("Invalid"), "Error message not displayed");
    }
}
}