package selenide.sitepage;

import classwork.pagefactory.PageBase;
import com.codeborne.selenide.testng.SoftAsserts;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

@Listeners({ SoftAsserts.class, ScreenshotListener.class})

public class LoginPage extends PageBase {
    private static By emailInputLocator = By.cssSelector("input[name='email']");
    private static By passwordInputLocator = By.cssSelector("input[name='password']");
    private static By loginButtonLocator = By.name("login");

    private static By loginPageForm = By.cssSelector("*[id= 'box-account-login'] form[name='login_form']");

    @Step("Attempt tp login")
    public static void attemptLogin(String username, String password) {
        $(emailInputLocator).shouldBe(visible).sendKeys(username);
        $(passwordInputLocator).shouldBe(visible).sendKeys(password);
        $(loginButtonLocator).shouldBe(visible).click();
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
