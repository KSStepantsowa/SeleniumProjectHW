package classwork.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import staticpageobjectHW.Browser;

import java.time.Duration;

public class ObjectRubberDucksTest {
    public static final String LIGHT_PINK = "rgba(255, 204, 204, 1)";
    private WebDriver driver;

    @BeforeMethod
    public void setup() {

        Browser browser = Browser.valueOf(System.getProperty("browser", "edge"));
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
    public void teardown() {
        driver.quit();
    }

    @Test
    public void searchInputTest() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://litecart.stqa.ru/en/");

        WebElement searchInput = driver.findElement(By.name("query"));

        searchInput.sendKeys("First Search Input");
    }

    @Test
    public void acmeLink() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://litecart.stqa.ru/en/");

        WebElement acmeLink = driver.findElement(By.id("box-logotypes"));
    }

    @Test
    public void login() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        WebElement loginField = driver.findElement(By.cssSelector("head title"));

        System.out.println(loginField.getText());

        WebElement asidePanel = driver.findElement(By.tagName("aside"));
        WebElement passwordInput = asidePanel.findElement(By.name("password"));
    }

    @Test
    public void addToCartNotLoggingUserTest() {
        driver.findElement(By.cssSelector("#box-most-popular [alt='Blue Duck']")).click();
        driver.findElement(By.name("add_cart_product")).click();
//        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBe(By.cssSelector("span.quantity"), "1"));
        String quantityInBasket = driver.findElement(By.cssSelector("span.quantity")).getText();
        Assert.assertEquals(quantityInBasket, "1");
    }

    @Test
    public void ducksIncorrectLoginTest() {
        String expectedErrorMessage = "Wrong password or the account is disabled, or does not exist";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.attemptLogin("stepantsowa.karina@gvdvd.com", "gsaljgxx7");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(homePage.getErrorMessageText(), expectedErrorMessage);
        softAssert.assertEquals(homePage.getErrorMessageBgColor(), LIGHT_PINK);
        softAssert.assertTrue(homePage.errorMessageIsVisible(), "Error message is not visible");
        softAssert.assertAll();
    }

    @Test
    public void xpathDemo() {
        WebElement boxAccountLogin = driver.findElement(By.id("box-account-login"));

        WebElement loginLabel = boxAccountLogin.findElement(By.xpath(".//h3[@class='title']"));

        System.out.println(loginLabel.getText());
    }


}
