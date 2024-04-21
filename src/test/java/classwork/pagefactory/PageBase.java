package classwork.pagefactory;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PageBase {
    protected boolean isDisplayed(WebDriver driver, String expectedTitle) {
        return driver.getTitle().equals(expectedTitle);
    }
}
