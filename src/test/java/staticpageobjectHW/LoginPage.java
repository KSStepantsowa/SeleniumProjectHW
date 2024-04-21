package staticpageobjectHW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase{
    private static By emailInputLocator = By.name("email");
    private static By passwordInputLocator = By.name("password");
    private static By loginButtonLocator = By.name("login");

    public static void attemptLogin(WebDriver driver, String username, String password) {
        driver.findElement(emailInputLocator).sendKeys(username);
        driver.findElement(passwordInputLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();
    }

//    public void isDisplayed(WebDriver driver) {
//        super.isDisplayed(driver, "Online Store | My Store");
//    }
}
