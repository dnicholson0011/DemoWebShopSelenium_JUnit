import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.util.Random;

/**
 * TestMethods Class
 *
 * Reusable methods
 * 1. randomNumber
 * 2. takeSnapShot
 */
public class TestMethods {

    public TestMethods() {

    }

    public int randomNumber() {

        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        return randomInt;
    }

    public void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {

        //Convert WebDriver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

        //Call getScreenShotAs method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination
        File DestFile = new File(fileWithPath);

        //Copy file at destination
        //FileUtils.copyFile() has been updated to FileHandler.copy()
        FileHandler.copy(SrcFile, DestFile);
    }
}
