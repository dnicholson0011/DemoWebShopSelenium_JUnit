import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Test Scenario: Positive
 * Test Case: Add items to shopping cart
 * Test Steps: See numbered scripts below
 *
 * Assertions:
 * 1. assertEquals - URL validation
 * 2. assertTrue - Banner validation
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ShoppingCart {

    private WebDriver driver;
    TestMethods testMethod = new TestMethods();

    @BeforeAll
    public static void setUp() {

        System.setProperty("webdriver.chrome.driver", "add directory here/chromedriver.exe");

    }

    @Test
    @Order(1)
    public void urlTest() throws Exception {

        driver = new ChromeDriver();

        //1. Goto Url
        driver.get("https://demowebshop.tricentis.com/");

        String url = driver.getCurrentUrl();

        Assertions.assertEquals("https://demowebshop.tricentis.com/", url);

        // Take screenshot
        testMethod.takeSnapShot(driver, "add directory here");

    }

    @Test
    @Order(2)
    public void shoppingCartTest() {

        //2. Mouse over the computers main header
        WebElement mainHeader = driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[2]/ul[1]/li[2]/a[1]"));

        Actions action = new Actions(driver);
        action.moveToElement(mainHeader);

        //3. Mouse over the desktop in submenu
        action.moveToElement(driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[1]/a[1]")));

        //4. compile all the actions into a single step
        action.click().build().perform();

        //5. Click on expensive computer hyperlink
        driver.findElement(By.linkText("Build your own expensive computer")).click();

        //6. Click fast radio button option
        driver.findElement(By.id("product_attribute_74_5_26_82")).click();

        //7. Click 8GB radio button option
        driver.findElement(By.id("product_attribute_74_6_27_85")).click();

        //8. Click 400 GB radio button option
        driver.findElement(By.id("product_attribute_74_3_28_87")).click();

        //9. Click all three check box options
        driver.findElement(By.id("product_attribute_74_8_29_88")).click();
        driver.findElement(By.id("product_attribute_74_8_29_89")).click();
        driver.findElement(By.id("product_attribute_74_8_29_90")).click();

        //10. Add item to shopping cart
        driver.findElement(By.id("add-to-cart-button-74")).click();

        //Calling this constructor did not accept an int, only the Duration method below
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='shopping cart']")));

        var bool = element.isDisplayed();

        Assertions.assertTrue(bool);

        driver.findElement(By.xpath("//a[normalize-space()='shopping cart']")).click();

        //11. Click
        driver.findElement(By.linkText("Shopping cart")).click();

    }

    @AfterAll
    public void tearDown() {

//        driver.quit();
    }
}
