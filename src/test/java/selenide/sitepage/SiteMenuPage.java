package selenide.sitepage;

import com.codeborne.selenide.testng.SoftAsserts;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
@Listeners({ SoftAsserts.class, ScreenshotListener.class})

public class SiteMenuPage {
    public static By menuCategoryOneButtonLocator = By.cssSelector("div[id='site-menu-wrapper'] li[class='category-1']");
    public static By categoryOneTitleTextLocator = By.cssSelector("h1[class='title']");

    public static void openCategoryOneMenuOption() {
        $(menuCategoryOneButtonLocator).click();
    }

    @Step("When user clicks om 'Category one' button he is redired to the page with 'Rubber Ducks' title")
    public static void checkCategoryOnePageTitle(String categoryOneTitle) {
        $(menuCategoryOneButtonLocator).click();
        $(categoryOneTitleTextLocator).getText();
        $(categoryOneTitleTextLocator).shouldHave(text(categoryOneTitle));
    }
}
