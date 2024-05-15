package classwork.pageobject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class ObjectSeleniumLiteCartTest {

    public static final String LIGHT_GREEN = "rgba(214, 236, 166, 1)";
    private WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://litecart.stqa.ru/en/");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
    @Test
    public void clickOnGeneralMenuButton() {
        String expectedMostPopularProductsBoxText = "Most Popular";
        String expectedLatestProductsBoxText = "Latest Products";

        WebElement homeButton = driver.findElement(By.cssSelector("li[class='general-0']"));
        driver.findElement(By.cssSelector("li[class='general-0']")).click();

        WebElement mostPopularProductsBox = driver.findElement(By.cssSelector("div[id='box-most-popular'] h3[class='title']"));
        WebElement latestProductsBox = driver.findElement(By.cssSelector("div[id='box-latest-products'] h3[class='title']"));

        String mostPopularProductsBoxText = mostPopularProductsBox.getText();
        String latestProductsBoxText = latestProductsBox.getText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(mostPopularProductsBoxText, expectedMostPopularProductsBoxText);
        softAssert.assertEquals(latestProductsBoxText, expectedLatestProductsBoxText);

        softAssert.assertAll();
    }

    @Test
    public void clickOnRubberDucksMenuButton() {
        WebElement rubberDucksCategoryOneButton = driver.findElement(By.xpath(".//div[@id='site-menu-wrapper']/nav[@id='site-menu']//li[@class='category-1']"));
        driver.findElement(By.xpath(".//div[@id='site-menu-wrapper']/nav[@id='site-menu']//li[@class='category-1']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement rubberDucksCategoryOnePageTitle = driver.findElement(By.xpath(".//title"));
        String categoryOneTitleText = driver.getTitle();
        System.out.println("Opened category page title is: " + categoryOneTitleText);

        Assert.assertEquals(categoryOneTitleText, driver.getTitle());
    }

    @Test
    public void clickOnSubcategoryMenuButton() {
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

    @Test
    public void ducksCorrectLoginTest() {
        String expectedLoginMessage = "You are now logged in as Test Auto.";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.attemptLogin("xidepo1971@rartg.com", "123456789");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(homePage.getSuccessMessageText(), expectedLoginMessage);
        softAssert.assertEquals(homePage.getSuccessMessageBgColor(), LIGHT_GREEN);
        softAssert.assertTrue(homePage.successMessageIsVisible(), "Error message is not visible");
        softAssert.assertAll();
    }

    @Test
    public void isLoginFormDisplayedTest() {
        WebElement loginPageForm = driver.findElement(By.cssSelector("div[id= 'box-account-login'] form"));
        boolean loginPageFormIsDisplayed = loginPageForm.isDisplayed();
        Assert.assertTrue(loginPageFormIsDisplayed, "Login page is displayed");
    }

    @Test
    public void isLoginFormVisibleTest() {
        WebElement loginPageForm = driver.findElement(By.cssSelector("div[id= 'box-account-login'] form"));
        boolean loginPageFormIsDisplayed = loginPageForm.isDisplayed();

        WebElement loginInput = driver.findElement(By.name("email"));
        loginInput.sendKeys("xidepo1971@rartg.com");
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("123456789");
        driver.findElement(By.name("login")).click();

            try {
                Assert.assertTrue(loginPageFormIsDisplayed);
            } catch (org.openqa.selenium.NoSuchElementException e) {
                Assert.assertFalse(loginPageFormIsDisplayed);
            }
        }
    @Test
    public void openShoppingCartByCheckoutButtonTest() {
        String emptyCartMessage = "There are no items in your cart.";

        WebElement cartCheckoutButton = driver.findElement(By.cssSelector("div[id='cart'] a[class='link']"));
        driver.findElement(By.cssSelector("div[id='cart'] a[class='link']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String emptyCartMessageText = driver.findElement(By.cssSelector("div[id='checkout-cart-wrapper'] em")).getText();

        Assert.assertEquals(emptyCartMessageText, emptyCartMessage);
    }

    @Test
    public void openShoppingCartByContentButtonTest() {
        String emptyCartMessage = "There are no items in your cart.";

        WebElement cartContentButton = driver.findElement(By.cssSelector("div[id='cart'] a[class='content']"));
        driver.findElement(By.cssSelector("div[id='cart'] a[class='content']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String emptyCartMessageText = driver.findElement(By.cssSelector("div[id='checkout-cart-wrapper'] em")).getText();

        Assert.assertEquals(emptyCartMessageText, emptyCartMessage);
    }

    @Test
    public void addToCartLoggingUserTest() {
        WebElement loginInput = driver.findElement(By.name("email"));
        loginInput.sendKeys("xidepo1971@rartg.com");
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("123456789");

        driver.findElement(By.name("login")).click();

        driver.findElement(By.cssSelector("#box-most-popular a[class='link']")).click();
        driver.findElement(By.name("add_cart_product")).click();

        WebElement cartCheckoutButton = driver.findElement(By.cssSelector("div[id='cart'] a[class='link']"));
        driver.findElement(By.cssSelector("div[id='cart'] a[class='link']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement addedItemInCart = driver.findElement(By.cssSelector("div[id='checkout-cart-wrapper'] li[class='item']"));
        boolean addedItemIsDisplayed = addedItemInCart.isDisplayed();
        Assert.assertTrue(addedItemIsDisplayed, "Item is added to cart and displayed");
    }

    @Test
    public void openProductNotLoggedInUserTest() {
        driver.findElement(By.cssSelector("#box-most-popular a[class='link']")).click();

        WebElement openedProduct = driver.findElement(By.cssSelector("div[id='box-product']"));
        boolean openedProductIsDisplayed = openedProduct.isDisplayed();
        Assert.assertTrue(openedProductIsDisplayed, "Product is opened");
    }

    @Test
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


