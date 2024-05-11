package selenide.sitepage;

import com.codeborne.selenide.testng.SoftAsserts;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import classwork.pagefactory.PageBase;
import org.testng.annotations.Listeners;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Listeners({ SoftAsserts.class, ScreenshotListener.class})

public class LoginPage extends PageBase {
    private static By emailInputLocator = By.name("email");
    private static By passwordInputLocator = By.name("password");
    private static By loginButtonLocator = By.name("login");

    private static By loginPageForm = By.cssSelector("div[id= 'box-account-login'] form");

    @Step("Attempt tp login")
    public static void attemptLogin(String username, String password) {
        $(emailInputLocator).sendKeys(username);
        $(passwordInputLocator).sendKeys(password);
        $(loginButtonLocator).click();
    }

    @Step("Checking visibility of login form")
    public static void loginFormIsDisplayed() {
        $(loginPageForm).shouldBe(visible);
    }

    @Step("Login form is not visible")
    public static void loginFormIsNotDisplayed() {
        $(loginPageForm).shouldNotBe(visible);
    }

//    public boolean isDisplayed() {
//        return isDisplayed("Online Store | My Store");
//    }

}
