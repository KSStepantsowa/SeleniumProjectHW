import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class SeleniumClassWorkTest {
    public static final String LIGHT_PINK = "rgba(255, 204, 204, 2)";

    @Test
    public void searchInputTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");

        WebElement searchInput = driver.findElement(By.name("query"));

        searchInput.sendKeys("First Search Input");

        driver.quit();
    }

    @Test
    public void acmeLink() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");

        WebElement acmeLink = driver.findElement(By.id("box-logotypes"));

        driver.quit();

    }

    @Test
    public void login() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        WebElement loginField = driver.findElement(By.name("title"));

        System.out.println(loginField.getText());

        WebElement asidePanel = driver.findElement(By.tagName("aside"));
        WebElement passwordInput = asidePanel.findElement(By.name("password"));

        driver.quit();
    }

    @Test
    public void addToCart() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(5)));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://litecart.stqa.ru/en/");
        driver.findElement(By.cssSelector("#box-most-popular [alt='Blue Duck']")).click();
        driver.findElement(By.name("add_cart_product")).click();
//        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBe(By.cssSelector("span.quantity"), "1"));
        String quantityInBasket = driver.findElement(By.cssSelector("span.quantity")).getText();
        Assert.assertEquals(quantityInBasket, "1");
        driver.quit();

    }

    @Test
    public void ducksIncorrectLoginTest() {
        String expectedErrorMessage = "Wrong password or the account is disabled, or does not exist";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(5)));
        driver.manage().timeouts().pageLoadTimeout((Duration.ofSeconds(10)));

        driver.get("https://litecart.stqa.ru/en/");
        WebElement loginInput = driver.findElement(By.name("email"));
        loginInput.sendKeys("stepantsowa.karina@gvdvd.com");
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("123456789");

        driver.findElement(By.name("login")).click();

        WebElement errorMessage = driver.findElement(By.cssSelector(".notice.errors"));

        String errorMessageText = errorMessage.getText();

        boolean errorMessageIsVisible = errorMessage.isDisplayed();
        String bgColor = errorMessage.getCssValue("background-color");

        SoftAssert softAssert = new SoftAssert();
//        String errorMessageText = driver.findElement(By.cssSelector(".notice.errors")).getText();
        softAssert.assertEquals(errorMessageText, expectedErrorMessage);

        softAssert.assertEquals(bgColor, LIGHT_PINK);

        softAssert.assertTrue(errorMessage.isDisplayed(), "Error message is not visible");

        softAssert.assertAll();
//        Assert.assertEquals(errorMessageText, expectedErrorMessage);

        driver.close();

    }

    @Test
    public void xpathDemo() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(5)));
        driver.manage().timeouts().pageLoadTimeout((Duration.ofSeconds(10)));

        driver.get("https://litecart.stqa.ru/en/");

        WebElement boxAccountLogin = driver.findElement(By.id("box-account-login"));

        WebElement loginLabel = boxAccountLogin.findElement(By.xpath(".//h3[@class='title']"));

        System.out.println(loginLabel.getText());

        driver.close();
    }

    @Test
    public void xpathDemoTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(5)));
        driver.manage().timeouts().pageLoadTimeout((Duration.ofSeconds(10)));

        driver.get("https://demo.guru99.com/test/simple_context_menu.html");

        WebElement doubleClickButton = driver.findElement(By.xpath("ondblckick='myFunction()']"));

        Actions builder = new Actions(driver);

//        builder.keyDown(Keys.CONTROL).click(doubleClickButton).keyUp(Keys.CONTROL).perform();

        builder.doubleClick(doubleClickButton).perform();

        driver.quit();


    }

    @Test
    public void xpathDemoBall() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(5)));
        driver.manage().timeouts().pageLoadTimeout((Duration.ofSeconds(10)));

        driver.get("https://demo.guru99.com/article/mouse-drag-and-drop/ball4/");

        WebElement ball = driver.findElement(By.id("ball"));
        WebElement goal = driver.findElement(By.id("gate"));

        Actions builder = new Actions(driver);

        builder.dragAndDrop(ball, goal).perform();
        builder.dragAndDropBy(ball, 100, 100).perform();
        builder.pause(5000).dragAndDropBy(ball, 100, 100).perform();


//        driver.getTitle();
        driver.quit();

    }

}

