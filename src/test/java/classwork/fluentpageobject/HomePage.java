package classwork.fluentpageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
    private By errorMessageLocator = By.cssSelector("[class = '.notice.errors]");
    private By successMessageLocator = By.cssSelector("[class = '.notice.success']");

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage validateErrorMessageText(String expectedErrorText) {
        Assert.assertEquals(driver.findElement(errorMessageLocator).getText(), expectedErrorText);
        return this;
    }

    public HomePage validateErrorMessageBgColor(String expectedErrorBg) {
        Assert.assertEquals(driver.findElement(errorMessageLocator).getCssValue("background-color"), expectedErrorBg);
        return this;
    }

    public HomePage validateErrorMessageIsVisible() {
        Assert.assertTrue(driver.findElement(errorMessageLocator).isDisplayed());
        return this;
    }

    public HomePage validateSuccessMessageText(String expectedSuccessText) {
        Assert.assertEquals(driver.findElement(successMessageLocator).getText(), expectedSuccessText);
        return this;
    }

    public HomePage validateSuccessMessageBgColor(String expectedSuccessBg) {
        Assert.assertEquals(driver.findElement(successMessageLocator).getCssValue("background-color"), expectedSuccessBg);
        return this;
    }

    public HomePage validateSuccessMessageIsVisible() {
        Assert.assertTrue(driver.findElement(successMessageLocator).isDisplayed());
        return this;
    }

}
