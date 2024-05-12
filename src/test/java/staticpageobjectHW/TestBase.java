package staticpageobjectHW;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static com.codeborne.selenide.Browsers.*;

public class TestBase {
    public static WebDriver driver;
    @BeforeMethod
    protected void setup() throws MalformedURLException {
        Browser browser = Browser.valueOf(System.getProperty("browser", "chrome"));
        DesiredCapabilities caps = new DesiredCapabilities();
        switch (browser) {
            case chrome -> caps.setBrowserName(CHROME);
            case firefox -> caps.setBrowserName(FIREFOX);
            case edge -> caps.setBrowserName(EDGE);
            case safari -> caps.setBrowserName(SAFARI);
        }

        caps.setPlatform(Platform.WINDOWS);
        driver = new RemoteWebDriver(new URL("http://192.168.100.42:4444/wd/hub"), caps);

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
