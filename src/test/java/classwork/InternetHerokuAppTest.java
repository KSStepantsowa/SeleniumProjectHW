package classwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class InternetHerokuAppTest {

    @Test
    public void findLinkTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        List<WebElement> lists = driver.findElements(By.tagName("li"));

        for (WebElement list:lists) {
            System.out.println("Element: " + list.getText());

        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBe(By.linkText("Drag and Drop"), "Drag and Drop"));

        driver.findElement(By.linkText("Drag and Drop")).click();
        boolean squareIsDisplayed = driver.findElement(By.cssSelector("div[class='column']")).isDisplayed();
        Assert.assertTrue(squareIsDisplayed, "The square is not displayed");
        driver.quit();

    }
}
