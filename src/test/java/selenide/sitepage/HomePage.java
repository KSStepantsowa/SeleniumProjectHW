package selenide.sitepage;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.SoftAsserts;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import classwork.pagefactory.PageBase;
import org.testng.annotations.Listeners;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
@Listeners({ SoftAsserts.class, ScreenshotListener.class})

public class HomePage{
    private static By errorMessageLocator = By.cssSelector("[class='notice errors']");
    private static By successMessageLocator = By.cssSelector("[class = 'notice success']");

    public String getErrorMessageText() {
        return $(errorMessageLocator).getText();
    }

    public String getErrorMessageBgColor() {
        return $(errorMessageLocator).getCssValue("background-color");
    }

    public boolean errorMessageIsVisible() {
        return $(errorMessageLocator).isDisplayed();
    }

    public String getSuccessMessageText() {
        return $(successMessageLocator).getText();
    }

    public String getSuccessMessageBgColor() {
        return $(successMessageLocator).getCssValue("background-color");
    }

    public boolean successMessageIsVisible() {
        return $(successMessageLocator).isDisplayed();
    }

//    public boolean isDisplayed() {
//        return isDisplayed("Online Store | My Store");
//    }

    @Story("Validation of error message, when user is failed to login")
    public static void validateErrorMessage(String expectedErrorMessageText, String bgColor) {
        Configuration.assertionMode = AssertionMode.SOFT;
        $(errorMessageLocator).shouldHave(text(expectedErrorMessageText));
        $(errorMessageLocator).shouldHave(cssValue("background-color", bgColor));
        $(errorMessageLocator).shouldBe(visible);
    }

    @Story("Validation of success message, when user is login")
    public static void validateSuccessMessage(String expectedLoginMessage, String bgColor) {
        Configuration.assertionMode = AssertionMode.SOFT;
        $(successMessageLocator).shouldHave(text(expectedLoginMessage));
        $(successMessageLocator).shouldHave(cssValue("background-color", bgColor));
        $(successMessageLocator).shouldBe(visible);
    }
}
