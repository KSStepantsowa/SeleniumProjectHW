package staticpageobjectHW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage {
    public static void clickOnLink(WebDriver driver) {
        driver.findElement(Locators.getLocator("ShoppingCartPage.cartCheckoutLinkButton")).click();
    }

    public static void clickOnContent(WebDriver driver) {
        driver.findElement(Locators.getLocator("ShoppingCartPage.cartCheckoutContentButton")).click();
    }

    public static boolean isCartItemDisplayed(WebDriver driver) {
        return driver.findElement(Locators.getLocator("ShoppingCartPage.addedItemInCart")).isDisplayed();
    }

}
