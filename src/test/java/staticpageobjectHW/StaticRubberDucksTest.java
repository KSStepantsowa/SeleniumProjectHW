package staticpageobjectHW;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class StaticRubberDucksTest extends TestBase{
    public static final String LIGHT_PINK = "rgba(255, 204, 204, 1)";
    public static final String LIGHT_GREEN = "rgba(214, 236, 166, 1)";

//    Login Tests

    @Test(groups = "authorization")
    public void ducksIncorrectLoginTest() {
        String expectedErrorMessage = "Wrong password or the account is disabled, or does not exist";

        LoginPage.attemptLogin(driver, "stepantsowa.karina@gvdvd.com", "gsaljgxx7");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(HomePage.getErrorMessageText(driver), expectedErrorMessage);
        softAssert.assertEquals(HomePage.getErrorMessageBgColor(driver), LIGHT_PINK);
        softAssert.assertTrue(HomePage.errorMessageIsVisible(driver), "Error message is not visible");
        softAssert.assertAll();

    }

    @Test(groups = "authorization")
    public void ducksCorrectLoginTest() {
        String expectedLoginMessage = "You are now logged in as Test Auto.";

        LoginPage.attemptLogin(driver,"xidepo1971@rartg.com", "123456789");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(HomePage.getSuccessMessageText(driver), expectedLoginMessage);
        softAssert.assertEquals(HomePage.getSuccessMessageBgColor(driver), LIGHT_GREEN);
        softAssert.assertTrue(HomePage.successMessageIsVisible(driver), "Error message is not visible");
        softAssert.assertAll();
    }

    @Test(groups = "authorization")
    public void isLoginFormDisplayedTest() {
        WebElement loginPageForm = driver.findElement(By.cssSelector("div[id= 'box-account-login'] form"));
        boolean loginPageFormIsDisplayed = loginPageForm.isDisplayed();
        Assert.assertTrue(loginPageFormIsDisplayed, "Login page is displayed");
    }

    @Test(groups = "authorization")
    public void LoginFormIsNotDisplayedTest() {
        WebElement loginPageForm = driver.findElement(By.cssSelector("div[id= 'box-account-login'] form"));
        boolean loginPageFormIsDisplayed = loginPageForm.isDisplayed();

        LoginPage.attemptLogin(driver,"xidepo1971@rartg.com", "123456789");

        try {
            Assert.assertTrue(loginPageFormIsDisplayed);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            Assert.assertFalse(loginPageFormIsDisplayed);
        } finally {
            driver.quit();
        }
    }

//    Menu options tests
    @Test(groups = "menu")
    public void clickOnGeneralMenuButton() {
        String expectedMostPopularProductsBoxText = "Most Popular";
        String expectedLatestProductsBoxText = "Latest Products";

        SiteMenuPage.clickOnHomeMenuOption(driver);

        WebElement mostPopularProductsBox = driver.findElement(By.cssSelector("div[id='box-most-popular'] h3[class='title']"));
        WebElement latestProductsBox = driver.findElement(By.cssSelector("div[id='box-latest-products'] h3[class='title']"));

        String mostPopularProductsBoxText = mostPopularProductsBox.getText();
        String latestProductsBoxText = latestProductsBox.getText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(mostPopularProductsBoxText, expectedMostPopularProductsBoxText);
        softAssert.assertEquals(latestProductsBoxText, expectedLatestProductsBoxText);

        softAssert.assertAll();

    }

    @Test(groups = "menu")
    public void clickOnCategory1MenuButton() {
        SiteMenuPage.clickOnCategory1MenuOption(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement rubberDucksCategoryOnePageTitle = driver.findElement(By.xpath(".//title"));
        String categoryOneTitleText = driver.getTitle();
        System.out.println("Opened category page title is: " + categoryOneTitleText);

        Assert.assertEquals(categoryOneTitleText, driver.getTitle());

    }

    @Test(groups = "menu")
    public void clickOnCategory2MenuButton() {
        WebElement rubberDucksCategoryOneButton = driver.findElement(By.cssSelector("div[id='site-menu-wrapper'] li[class='category-1']"));
        WebElement rubberDucksCategoryTwoButton = driver.findElement(By.cssSelector("div[id='site-menu-wrapper'] li[class='category-2']"));

        Actions builder = new Actions(driver);
        builder.moveToElement(rubberDucksCategoryOneButton).perform();
        builder.moveToElement(rubberDucksCategoryTwoButton).click().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        List<WebElement> productLists = driver.findElements(By.cssSelector("li.product"));
        for (WebElement productList : productLists) {
            System.out.println("The list of products: " + productList.findElement(By.className("name")).getText());
        }

        WebElement rubberDucksCategoryTwoPageTitle = driver.findElement(By.xpath(".//title"));
        String categoryTwoTitleText = driver.getTitle();
        System.out.println(categoryTwoTitleText);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(categoryTwoTitleText, driver.getTitle());

        boolean categoryTwoPageContent = driver.findElement(By.xpath("//div[@class='content']/ul[@class='listing-wrapper products']")).isDisplayed();
        softAssert.assertTrue(categoryTwoPageContent, "Error: Products are not displayed!");

        softAssert.assertAll();

    }

//    Shopping cart tests
    @Test(groups = "addToCart")
    public void addToCartNotLoggingUserTest() {
        driver.findElement(By.cssSelector("#box-most-popular [alt='Blue Duck']")).click();
        driver.findElement(By.name("add_cart_product")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBe(By.cssSelector("span.quantity"), "1"));
        String quantityInBasket = driver.findElement(By.cssSelector("span.quantity")).getText();
        Assert.assertEquals(quantityInBasket, "1");

    }

    @Test(groups = "addToCart")
    public void addToCartLoggingUserTest() {
        LoginPage.attemptLogin(driver,"xidepo1971@rartg.com", "123456789");

        driver.findElement(By.cssSelector("#box-most-popular a[class='link']")).click();
        driver.findElement(By.name("add_cart_product")).click();

        ShoppingCartPage.clickOnLink(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        ShoppingCartPage.isCartItemDisplayed(driver);
        Assert.assertTrue(ShoppingCartPage.isCartItemDisplayed(driver), "Item is added to cart and displayed");

    }

    @Test(groups = "shoppingCart")
    public void openShoppingCartByCheckoutButtonTest() {
        String emptyCartMessage = "There are no items in your cart.";

        ShoppingCartPage.clickOnLink(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String emptyCartMessageText = driver.findElement(By.cssSelector("div[id='checkout-cart-wrapper'] em")).getText();

        Assert.assertEquals(emptyCartMessageText, emptyCartMessage);
    }

    @Test(groups = "shoppingCart")
    public void openShoppingCartByContentButtonTest() {
        String emptyCartMessage = "There are no items in your cart.";

        ShoppingCartPage.clickOnContent(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String emptyCartMessageText = driver.findElement(By.cssSelector("div[id='checkout-cart-wrapper'] em")).getText();

        Assert.assertEquals(emptyCartMessageText, emptyCartMessage);
    }


    @Test(groups = "productCategories")
    public void openProductNotLoggedInUserTest() {
        driver.findElement(By.cssSelector("#box-most-popular a[class='link']")).click();

        WebElement openedProduct = driver.findElement(By.cssSelector("div[id='box-product']"));
        boolean openedProductIsDisplayed = openedProduct.isDisplayed();
        Assert.assertTrue(openedProductIsDisplayed, "Product is opened");
        driver.close();
    }

    @Test(groups = "product")
    public void emptyQuantityProductAlertTest() {
        driver.findElement(By.cssSelector("#box-most-popular a[class='link']")).click();
        WebElement productQuantityField = driver.findElement(By.cssSelector("td[class='quantity'] input[name='quantity']"));
        driver.findElement(By.cssSelector("td[class='quantity'] input[name='quantity']")).clear();

        WebElement addToCartButton = driver.findElement(By.cssSelector("td[class='quantity'] button[name='add_cart_product']"));
        driver.findElement(By.cssSelector("td[class='quantity'] button[name='add_cart_product']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains("Cannot add product to cart. Invalid quantity"));
        alert.accept();

    }


}
