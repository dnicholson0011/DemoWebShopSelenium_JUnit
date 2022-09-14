import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Test Scenario: Positive
 * Test Case: Register account
 * Test Steps: See numbered scripts below
 *
 * Assertions:
 * 1. assertEquals - URL validation
 * 2. assertEquals - Registration validation
 */

//Needed to run the test with setUp and tearDown methods below
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Registration {

    private WebDriver driver;
//    WebDriver driver = new ChromeDriver();

    TestMethods testMethod = new TestMethods();

    @BeforeAll
    public static void setUp() {

        System.setProperty("webdriver.chrome.driver", "add directory here/chromedriver.exe");

    }

//    @BeforeEach
//    public void setUp() {
//
//        driver = new ChromeDriver();
//    }

    @Test
    @Order(1)
    public void urlTest() throws Exception {

        driver = new ChromeDriver();

        //1. Goto Url
        driver.get("https://demowebshop.tricentis.com/");

        String url = driver.getCurrentUrl();

        Assertions.assertEquals("https://demowebshop.tricentis.com/", url);

        // Take screenshot
        testMethod.takeSnapShot(driver, "C:\\Users\\d.nicholson\\OneDrive - Accenture\\Desktop\\Test Scripts\\Screens/image.png");

    }

    @Test
    @Order(2)
    public void registrationTest() throws Exception {

        //1. Goto URL
//        urlTest();

        //2. Click on register hyperlink
        driver.findElement(By.className("ico-register")).click();

        //3. Click male radio button
        driver.findElement(By.id("gender-male")).click();

        //4. Enter valid first name into text box field
        driver.findElement(By.id("FirstName")).sendKeys("First");

        //5. Enter valid last name into text box field
        driver.findElement(By.id("LastName")).sendKeys("Last");

        //6. Enter a valid email into text box field
        // Need to implement an ArrayList to store the random values or push/pull from database/Excel
        String str = String.valueOf(testMethod.randomNumber());
        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("username" + str + "@example.test");

        String registerConfirmation = "username" + str + "@example.test";

        //7. Enter a valid password into text box field
        driver.findElement(By.id("Password")).sendKeys("123456");

        //8. Enter a valid password into text box field
        driver.findElement(By.id("ConfirmPassword")).sendKeys("123456");

        //9. Click register button
        driver.findElement(By.id("register-button")).click();

        //Confirm expected results with actual results
        String actualConfirmation = driver.findElement(By.linkText("username" + str + "@example.test")).getText();

        Assertions.assertEquals(registerConfirmation,actualConfirmation);

        // Take screenshot
        testMethod.takeSnapShot(driver, "C:\\Users\\d.nicholson\\OneDrive - Accenture\\Desktop\\Test Scripts\\Screens/image.png");

//        driver.close();

    }

   @AfterAll
    public void tearDown() {

//        driver.quit();
    }
}
