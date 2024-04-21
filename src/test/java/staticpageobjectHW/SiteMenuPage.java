package staticpageobjectHW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SiteMenuPage {
    private static By homeButtonLocator = By.cssSelector("li[class='general-0']");

    private static By category1ButtonLocator = By.cssSelector("div[id='site-menu-wrapper'] li[class='category-1']");
    private static By category2ButtonLocator = By.cssSelector("div[id='site-menu-wrapper'] li[class='category-2']");

    public static void clickOnCategory1MenuOption(WebDriver driver) {
        driver.findElement(category1ButtonLocator).click();
    }
    public static void clickOnCategory2MenuOption(WebDriver driver) {
        driver.findElement(category1ButtonLocator).click();
        driver.findElement(category2ButtonLocator).click();
    }
    public static void clickOnHomeMenuOption(WebDriver driver) {
        driver.findElement(homeButtonLocator).click();
    }
}
