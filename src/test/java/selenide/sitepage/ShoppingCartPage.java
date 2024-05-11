package selenide.sitepage;

import com.codeborne.selenide.testng.SoftAsserts;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

@Listeners({ SoftAsserts.class, ScreenshotListener.class})

public class ShoppingCartPage {
    private static By cartContentButtonLocator = By.cssSelector("div[id='cart'] a[class='content']");
    private static By emptyCartMessageTextLocator = By.cssSelector("div[id='checkout-cart-wrapper'] em");
    private static By cartCheckoutButtonLocator = By.cssSelector("div[id='cart'] a[class='link']");


    @Step("User opens shopping cart page by clicking on 'Checkout' button")
    public static void clickOnCheckoutButton() {
        $(cartCheckoutButtonLocator).click();
    }

    @Step("User opens shopping cart page by clicking on 'Content' button")
    public static void clickOnContentButton() {
        $(cartContentButtonLocator).click();
    }

    @Step("An empty cart message text appears when shopping cart is empty")
    public static void validateEmptyCartMessageText(String expectedEmptyCartMessage) {
        $(emptyCartMessageTextLocator).shouldHave(text(expectedEmptyCartMessage));
    }

}
