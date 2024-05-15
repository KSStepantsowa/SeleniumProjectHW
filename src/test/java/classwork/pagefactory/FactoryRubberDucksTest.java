package classwork.pagefactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import classwork.pageobject.TestBase;

public class FactoryRubberDucksTest extends TestBase {
    public static final String LIGHT_PINK = "rgba(255, 204, 204, 1)";
    public static final String LIGHT_GREEN = "rgba(214, 236, 166, 1)";

    @Test
    public void ducksIncorrectLoginTest() {
        String expectedErrorMessage = "Wrong password or the account is disabled, or does not exist";

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        loginPage.attemptLogin("stepantsowa.karina@gvdvd.com", "gsaljgxx7");

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(homePage.getErrorMessageText(), expectedErrorMessage);
        softAssert.assertEquals(homePage.getErrorMessageBgColor(), LIGHT_PINK);
        softAssert.assertTrue(homePage.errorMessageIsVisible(), "Error message is not visible");
        softAssert.assertAll();
    }

    @Test
    public void ducksCorrectLoginTest() {
        String expectedLoginMessage = "You are now logged in as Test Auto.";

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        loginPage.attemptLogin("xidepo1971@rartg.com", "123456789");

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(homePage.getSuccessMessageText(), expectedLoginMessage);
        softAssert.assertEquals(homePage.getSuccessMessageBgColor(), LIGHT_GREEN);
        softAssert.assertTrue(homePage.successMessageIsVisible(), "Error message is not visible");
        softAssert.assertAll();
    }


}
