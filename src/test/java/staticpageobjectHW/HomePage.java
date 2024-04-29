package staticpageobjectHW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase{

    public static String getErrorMessageText(WebDriver driver) {
        return driver.findElement(Locators.getLocator("HomePage.errorLoginMessage")).getText();
    }

    public static String getErrorMessageBgColor(WebDriver driver) {
        return  driver.findElement(Locators.getLocator("HomePage.errorLoginMessage")).getCssValue("background-color");
    }

    public static boolean errorMessageIsVisible(WebDriver driver) {
        return driver.findElement(Locators.getLocator("HomePage.errorLoginMessage")).isDisplayed();
    }

    public static String getSuccessMessageText(WebDriver driver) {
        return driver.findElement(Locators.getLocator("HomePage.successLoginMessage")).getText();
    }

    public static String getSuccessMessageBgColor(WebDriver driver) {
        return driver.findElement(Locators.getLocator("HomePage.successLoginMessage")).getCssValue("background-color");
    }

    public static boolean successMessageIsVisible(WebDriver driver) {
        return driver.findElement(Locators.getLocator("HomePage.successLoginMessage")).isDisplayed();
    }
//    public void isDisplayed(WebDriver driver) {
//        super.isDisplayed(driver, "Rubber Ducks | My Store");
//    }

}
