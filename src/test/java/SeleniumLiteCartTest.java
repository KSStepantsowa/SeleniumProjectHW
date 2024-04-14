import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class SeleniumLiteCartTest {
    @Test
    public void clickOnGeneralMenuButton() {
        String expectedMostPopularProductsBoxText = "Most Popular";
        String expectedLatestProductsBoxText = "Latest Products";


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://litecart.stqa.ru/en/");

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

        driver.quit();
    }

    @Test
    public void clickOnRubberDucksMenuButton() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://litecart.stqa.ru/en/");

        WebElement rubberDucksCategoryOneButton = driver.findElement(By.xpath(".//div[@id='site-menu-wrapper']/nav[@id='site-menu']//li[@class='category-1']"));
        driver.findElement(By.xpath(".//div[@id='site-menu-wrapper']/nav[@id='site-menu']//li[@class='category-1']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement rubberDucksCategoryOnePageTitle = driver.findElement(By.xpath(".//title"));
        String categoryOneTitleText = driver.getTitle();
        System.out.println("Opened category page title is: "+categoryOneTitleText);

        Assert.assertEquals(categoryOneTitleText, driver.getTitle());

        driver.quit();

    }

    @Test
    public void clickOnSubcategoryMenuButton() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://litecart.stqa.ru/en/");

        WebElement rubberDucksCategoryOneButton = driver.findElement(By.cssSelector("div[id='site-menu-wrapper'] li[class='category-1']"));
        WebElement rubberDucksCategoryTwoButton = driver.findElement(By.cssSelector("div[id='site-menu-wrapper'] li[class='category-2']"));

        Actions builder = new Actions(driver);
        builder.moveToElement(rubberDucksCategoryOneButton).perform();
        builder.moveToElement(rubberDucksCategoryTwoButton).click().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        List<WebElement> productLists = driver.findElements(By.cssSelector("li.product"));
        for (WebElement productList:productLists) {
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

        driver.quit();

    }
}
