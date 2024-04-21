package staticpageobjectHW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase{
    private static By errorMessageLocator = By.cssSelector("div[class = 'notice errors']");
    private static By successMessageLocator = By.cssSelector("div[class = 'notice success']");


    public static String getErrorMessageText(WebDriver driver) {
        return driver.findElement(errorMessageLocator).getText();
    }

    public static String getErrorMessageBgColor(WebDriver driver) {
        return  driver.findElement(errorMessageLocator).getCssValue("background-color");
    }

    public static boolean errorMessageIsVisible(WebDriver driver) {
        return driver.findElement(errorMessageLocator).isDisplayed();
    }

    public static String getSuccessMessageText(WebDriver driver) {
        return driver.findElement(successMessageLocator).getText();
    }

    public static String getSuccessMessageBgColor(WebDriver driver) {
        return driver.findElement(successMessageLocator).getCssValue("background-color");
    }

    public static boolean successMessageIsVisible(WebDriver driver) {
        return driver.findElement(successMessageLocator).isDisplayed();
    }
//    public void isDisplayed(WebDriver driver) {
//        super.isDisplayed(driver, "Rubber Ducks | My Store");
//    }

}
