package staticpageobjectHW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage {
    private static By cartCheckoutLinkButtonLocator = By.cssSelector("div[id='cart'] a[class='link']");
    private static By cartCheckoutContentButtonLocator = By.cssSelector("div[id='cart'] a[class='content']");

    private static By addedItemInCartLocator = By.cssSelector("div[id='checkout-cart-wrapper'] li[class='item']");

    public static void clickOnLink(WebDriver driver) {
        driver.findElement(cartCheckoutLinkButtonLocator).click();
    }

    public static void clickOnContent(WebDriver driver) {
        driver.findElement(cartCheckoutContentButtonLocator).click();
    }

    public static boolean isCartItemDisplayed(WebDriver driver) {
        return driver.findElement(addedItemInCartLocator).isDisplayed();
    }

}
