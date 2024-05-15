package cucumber.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginStepdefs {
    WebDriver driver;

    @Given("user is on login page")
    public void user_is_on_login_page() {
        driver = new EdgeDriver();
        driver.get("https://litecart.stqa.ru/en/");

    }

    @When("user enters {string} in user field")
    public void userEntersInUserField(String username) {
        driver.findElement(By.name("email")).sendKeys(username);
    }

    @Then("user enters {string} in password field")
    public void userEntersInPasswordField(String password) {
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @Then("user clicks login button")
    public void userClicksLoginButton() {
        driver.findElement(By.name("login")).click();

    }

    @Then("error screen appears")
    public void errorScreenAppears() {
        driver.findElement(By.cssSelector("div[id = 'notices']"));
    }

    @Then("error message contains {string}")
    public void errorMessageContains(String errorLoginMessage) {
        driver.findElement(By.cssSelector("div[class = 'notice errors']")).getText();
    }
}
