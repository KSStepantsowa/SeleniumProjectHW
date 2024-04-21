package staticpageobjectHW;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    public static WebDriver driver;
    @BeforeMethod
    protected void setup() {
        Browser browser = Browser.valueOf(System.getProperty("browser", "chrome"));
        driver = switch (browser) {
            case chrome -> new ChromeDriver();
            case firefox -> new FirefoxDriver();
            case edge -> new EdgeDriver();
            case safari -> new SafariDriver();
        };
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://litecart.stqa.ru/en/");
    }

    @AfterMethod
    protected void teardown() {
        driver.quit();
    }
}
