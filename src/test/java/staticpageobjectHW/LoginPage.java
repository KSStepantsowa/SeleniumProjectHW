package staticpageobjectHW;

import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase{

    public static void attemptLogin(WebDriver driver, String username, String password) {
        driver.findElement(Locators.getLocator("LoginPage.loginInput")).sendKeys(username);
        driver.findElement(Locators.getLocator("LoginPage.passwordInput")).sendKeys(password);
        driver.findElement(Locators.getLocator("LoginPage.loginButton")).click();
    }

//    public void isDisplayed(WebDriver driver) {
//        super.isDisplayed(driver, "Online Store | My Store");
//    }
}
