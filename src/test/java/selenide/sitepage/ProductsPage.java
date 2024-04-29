package selenide.sitepage;

import com.codeborne.selenide.testng.SoftAsserts;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Listeners({ SoftAsserts.class, ScreenshotListener.class})

public class ProductsPage {
    private static By productLocator = By.cssSelector("div[id='box-product']");
    private static By mostPopularBoxLocator = By.cssSelector("#box-most-popular a[class='link']");
    private static By productQuantityFieldLocator = By.cssSelector("td[class='quantity'] input[name='quantity']");
    private static By addToCartButtonLocator = By.cssSelector("td[class='quantity'] button[name='add_cart_product']");

    @Step("Open a product from 'Most Popular' category")
    public static void openProductFromMostPopularBox() {
        $(mostPopularBoxLocator).click();
    }
    @Step("The product from 'Most popular' category is displayed")
    public static void openedMostPopularProductIsDisplayed() {
        $(productLocator).shouldBe(visible);
    }

    @Step("The alert is shown after the user tries to add product with empty quantity")
    public static void getQuantityProductAlert() {
        $(mostPopularBoxLocator).click();
        $(productQuantityFieldLocator).clear();
        $(addToCartButtonLocator).click();

    }


}
