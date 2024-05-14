//package classwork;
//
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import java.time.Duration;
//
//public class SeleniumClassWorkTest {
//
//    @Test
//    public void xpathDemoTest() {
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(5)));
//        driver.manage().timeouts().pageLoadTimeout((Duration.ofSeconds(10)));
//
//        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
//
//        WebElement doubleClickButton = driver.findElement(By.xpath("ondblckick='myFunction()']"));
//
//        Actions builder = new Actions(driver);
//
////        builder.keyDown(Keys.CONTROL).click(doubleClickButton).keyUp(Keys.CONTROL).perform();
//
//        builder.doubleClick(doubleClickButton).perform();
//
//        driver.quit();
//
//
//    }
//
//    @Test
//    public void xpathDemoBall() {
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(5)));
//        driver.manage().timeouts().pageLoadTimeout((Duration.ofSeconds(10)));
//
//        driver.get("https://demo.guru99.com/article/mouse-drag-and-drop/ball4/");
//
//        WebElement ball = driver.findElement(By.id("ball"));
//        WebElement goal = driver.findElement(By.id("gate"));
//
//        Actions builder = new Actions(driver);
//
//        builder.dragAndDrop(ball, goal).perform();
//        builder.dragAndDropBy(ball, 100, 100).perform();
//        builder.pause(5000).dragAndDropBy(ball, 100, 100).perform();
//
//
////        driver.getTitle();
//        driver.quit();
//
//    }
//
//    @Test
//    public void alertTest() {
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//
//        driver.get("https://the-internet.herokuapp.com/https://the-internet.herokuapp.com/javascript_alerts");
//
//        driver.findElement(By.cssSelector("[onclick='jsAlert()']")).click();
//
//        Alert alert = driver.switchTo().alert();
//        String actualAlertText = alert.getText();
//        Assert.assertEquals(actualAlertText, "I am a JS Alert");
//        alert.accept();
//
//        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You successully clicked an alert");
//
//        driver.findElement(By.cssSelector("[onclick='jsConfirm()']")).click();
//        alert = driver.switchTo().alert();
//
//        String actualConfirmText = alert.getText();
//        Assert.assertEquals(actualConfirmText, "I am a JS Confirm");
//
//
//        alert.accept();
//
//        driver.quit();
//    }
//
//    @Test
//    public void dropdownTest() {
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//
//        driver.get("https://the-internet.herokuapp.com/dropdown");
//
//        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
//
//        dropdown.selectByValue("1");
//
//        driver.quit();
//    }
//
//    @Test
//    public void fluenWaitsTest() {
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//
//        driver.get("https://the-internet.herokuapp.com/dropdown");
//
//        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//
//        // wait.until(ExpectedConditions.elementToBeSelected(By.id("fsdfsdf")));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//
////        wait.until(new Expect<WebElement>() {
////        }) {
////            @Override
////            public WebElement apply(WebDriver d) {
////                return d.findElement(By.id("fefef"));
////            }
////        };
//
//    }
//
//    @Test
//    public void waitTwoTest() {
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//
//        driver.get("https://the-internet.herokuapp.com/dropdown");
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//
//        wait.until((ExpectedCondition<WebElement>) d -> d.findElement(By.id("fefesfes")));
//
//    }
//
////    @Test
////    public Object waitThreeTest() {
////        WebDriver driver = new ChromeDriver();
////        driver.manage().window().maximize();
////        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
////        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
////
////        driver.get("https://the-internet.herokuapp.com/dropdown");
////
////        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
////
////        wait.until((ExpectedCondition<WebElement>) d -> d.findElement(By.id("fefesfes")));
////
////        wait.until(new ExpectedCondition<Boolean>()) {
////            @Override
////            public Boolean apply(WebDriver d) {
////                JavascriptExecutor js = (JavascriptExecutor) d:
////                return js.executeScript("return jQuaery.active ===0");
////
////            }
////        }
////
////        public void waitForJquary(WebDriver driver, int seconds) {
////            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
////            wait.until((ExpectedCondition<Boolean>) d -> (Boolean)((JavascriptExecutor)d).executeScript("return jquery.active ===0")); {
////
////            }
////        }
////
////        // Add to cart
////        // wait.pollingEvery(Duration.ofSeconds(5000))
////        // wait ignoring(NoSuchElementExecution.class)
////        //waitForJquary(driver, 10)
////    }
////
////    @Test
////    public void multipleWindowTest() {
////        WebDriver driver = new ChromeDriver();
////        driver.manage().window().maximize();
////        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
////        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
////
////        driver.get("https://the-internet.herokuapp.com/windows");
////
////        driver.switchTo().frame("frame-top");
////        driver.switchTo().frame("frame-left");
////
////        System.out.println(driver.findElement(By.tagName("body")).getText());
////
////        driver.switchTo().parentFrame();
////        // driver.switchTo().defaultContent();
////        driver.switchTo().frame("frame-left");
////        driver.close();
////    }
////
////    @Test
////    public void shadowRootTest() {
////        WebDriver driver = new ChromeDriver();
////        driver.manage().window().maximize();
////        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
////        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
////        driver.get("https://canvas.apps.chrome.com");
////
////        WebElement drawingApp = driver.findElement(By.id("drawing-app"));
////        SearchContext drawingAppTree = drawingApp.getShadowRoot();
////        WebElement welcomeDialog = drawingAppTree.findElement(By.cssSelector("welcome-dialog[test-state='open']"));
////
////        SearchContext welcomeDialogTree = welcomeDialog.getShadowRoot();
////
////        WebElement paperDialog = welcomeDialogTree.findElement(By.cssSelector("#welcome-screen"));
////        SearchContext paperDialogTree = paperDialog.getShadowRoot();
////        WebElement getStartedButton = paperDialog.findElement(By.cssSelector("#get-started"));
////        getStartedButton.click();
////
////    }
////
////    @Test
////    public void shadowRootTest() {
////        WebDriver driver = new ChromeDriver();
////        driver.manage().window().maximize();
////        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
////        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
////        driver.get("https://canvas.apps.chrome.com");
////
////    }
//
////    @Test
////    public void tableTest() {
////        WebDriver driver = new ChromeDriver();
////        driver.manage().window().maximize();
////        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
////        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
////        driver.get("https://the-internet.herokuapp.com/tables");
////
////        TablesPageCw tablesPageCw = new TablesPageCw(driver);
////
////        Assert.assertEquals(tablesPageCw.table1.getRowsCount(), 5);
////
////
////    }
//
//}
