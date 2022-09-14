import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Test Scenario: Positive
 * Test Case: Login with valid credentials
 * Test Steps: See numbered scripts below
 *
 * Assertions:
 * 1. assertEquals - URL validation
 * 2. assertEquals - Login validation
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTest {

    private WebDriver driver;
    TestMethods testMethod = new TestMethods();

    @BeforeAll
    public static void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\d.nicholson\\OneDrive - Accenture\\Desktop\\Test Scripts\\Selenium WebDrivers\\Chrome Drivers/chromedriver.exe");

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
        testMethod.takeSnapShot(driver, "C:\\Users\\d.nicholson\\OneDrive - Accenture\\Desktop\\Test Scripts\\Screens/image.png");

    }

    @Test
    @Order(2)
    public void loginTest() throws Exception {

        //1. Goto URL
        driver.manage().window().maximize();

        //2. Click on log in hyperlink
        driver.findElement(By.className("ico-login")).click();

        //3. Enter registered email into text box field
        //Need to implement SQL data and/or Excel data, for now a String array will work
        String[] emailList = {"first.last@example01.test"};

        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys(emailList[0]);

        //4. Enter registered password into text box field
        driver.findElement(By.id("Password")).sendKeys("123456");

        //5. Click log in button
        driver.findElement(By.className("login-button")).click();

        String loginConfirmation = "first.last@example01.test";
        String actualConfirmation = driver.findElement(By.linkText("first.last@example01.test")).getText();

        Assertions.assertEquals(loginConfirmation, actualConfirmation);

        // Take screenshot
        testMethod.takeSnapShot(driver, "C:\\Users\\d.nicholson\\OneDrive - Accenture\\Desktop\\Test Scripts\\Screens/image.png");

    }

    @AfterAll
    public void tearDown() {

//        driver.quit();
    }

}
