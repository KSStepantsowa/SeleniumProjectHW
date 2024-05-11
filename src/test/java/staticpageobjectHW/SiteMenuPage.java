package staticpageobjectHW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SiteMenuPage {
    public static void clickOnCategory1MenuOption(WebDriver driver) {
        driver.findElement(Locators.getLocator("SiteMenuPage.category1Button")).click();
    }
    public static void clickOnCategory2MenuOption(WebDriver driver) {
        driver.findElement(Locators.getLocator("SiteMenuPage.category1Button")).click();
        driver.findElement(Locators.getLocator("SiteMenuPage.category2Button")).click();
    }
    public static void clickOnHomeMenuOption(WebDriver driver) {
        driver.findElement(Locators.getLocator("SiteMenuPage.homeButton")).click();
    }
}
