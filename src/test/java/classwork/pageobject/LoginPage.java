package classwork.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import classwork.pagefactory.PageBase;

public class LoginPage extends PageBase {
    private By emailInputLocator = By.name("email");
    private By passwordInputLocator = By.name("password");
    private By loginButtonLocator = By.name("login");

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void attemptLogin(String username, String password) {
        driver.findElement(emailInputLocator).sendKeys(username);
        driver.findElement(passwordInputLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();
    }

    public boolean isDisplayed() {
        return isDisplayed(driver, "Online Store | My Store");
    }

}
