package classwork.pagefactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    @FindBy(css = "div[class='notice errors']")
    private WebElement errorMessage;
    @FindBy(css = "div[class='notice success']")
    private WebElement successMessage;


    public String getErrorMessageText() {
        return errorMessage.getText();
    }

    public String getErrorMessageBgColor() {
        return  errorMessage.getCssValue("background-color");
    }

    public boolean errorMessageIsVisible() {
        return errorMessage.isDisplayed();
    }

    public String getSuccessMessageText() {
        return successMessage.getText();
    }

    public String getSuccessMessageBgColor() {
        return successMessage.getCssValue("background-color");
    }

    public boolean successMessageIsVisible() {
        return successMessage.isDisplayed();
    }

}
