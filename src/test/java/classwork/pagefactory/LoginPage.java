package classwork.pagefactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(name = "email")
    WebElement emailInput;
    @FindBy(name = "password")
    WebElement passwordInput;
    @FindBy(name = "login")
    WebElement loginButton;
    public void attemptLogin(String username, String password) {
        emailInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

}
