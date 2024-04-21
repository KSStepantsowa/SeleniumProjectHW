package classwork.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import classwork.pagefactory.PageBase;

public class HomePage extends PageBase {
    private By errorMessageLocator = By.cssSelector("[class = '.notice.errors]");
    private By successMessageLocator = By.cssSelector("[class = '.notice.success']");

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getErrorMessageText() {
        return driver.findElement(errorMessageLocator).getText();
    }

    public String getErrorMessageBgColor() {
        return  driver.findElement(errorMessageLocator).getCssValue("background-color");
    }

    public boolean errorMessageIsVisible() {
        return driver.findElement(errorMessageLocator).isDisplayed();
    }

    public String getSuccessMessageText() {
        return driver.findElement(successMessageLocator).getText();
    }

    public String getSuccessMessageBgColor() {
        return driver.findElement(successMessageLocator).getCssValue("background-color");
    }

    public boolean successMessageIsVisible() {
        return driver.findElement(successMessageLocator).isDisplayed();
    }

    public boolean isDisplayed() {
        return isDisplayed(driver, "Online Store | My Store");
    }
}
