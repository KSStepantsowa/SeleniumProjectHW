package classwork.fluentpageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FluentRubberDucksTest {
    public static final String LIGHT_PINK = "rgba(255, 204, 204, 1)";
    public static final String LIGHT_GREEN = "rgba(214, 236, 166, 1)";
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        driver.get("https://litecart.stqa.ru/en/");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void ducksCorrectLoginTest() {
        String expectedLoginMessage = "You are now logged in as Test Auto.";

        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .attemptLogin("xidepo1971@rartg.com", "123456789")
                .validateSuccessMessageBgColor(LIGHT_GREEN)
                .validateSuccessMessageText("You are now logged in as Test Auto.")
                .validateSuccessMessageIsVisible();
    }

    @Test
    public void ducksIncorrectLoginTest() throws InterruptedException {
        String expectedErrorMessage = "Wrong password or the account is disabled, or does not exist";

        LoginPage loginPage = new LoginPage(driver);


        loginPage
                .attemptLogin("stepantsowa.karina@gvdvd.com", "gsaljgxx7")
                .validateErrorMessageBgColor(LIGHT_PINK)
                .validateErrorMessageText("Wrong password or the account is disabled, or does not exist")
                .validateErrorMessageIsVisible();
    }
}
