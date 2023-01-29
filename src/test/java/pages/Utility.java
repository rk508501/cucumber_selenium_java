package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This is Utility class contains reusable methods.
 * @author ankurd
 */
public class Utility {


    /**
     * This method is used to get the values from config file.
     *
     * @author ankurd
     * @return String
     */

    public static String getPropertyValue(String fileName, String propertyName) {
        Properties properties = new Properties();
        try {
            String current = new java.io.File(".").getCanonicalPath();
            fileName = fileName.replace("./", "/");
            InputStream inputStream = new FileInputStream(current + fileName);
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.println(e);
        }
        return properties.getProperty(propertyName);
    }


    public static void elementClick(WebDriver driver, WebElement ele) {
        boolean flag = false;
        WebElement elementClick = null;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            elementClick = wait.until(ExpectedConditions.visibilityOf(ele));
            flag = true;
        } catch (Exception e) {

        }
        if (flag = true) {
            elementClick.click();
        }
    }

    /**
     * This wait is used to Check the element visibility using Fluent wait, polling every 10ms
     *
     * @author ankurd
     */
    public static void waitForElementToBeVisibleFastAndFluent(WebDriver driver, int timeout, WebElement element) {
        FluentWait<WebDriver> fwait =
                new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMillis(timeout)).pollingEvery(Duration.ofMillis(10)).ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        fwait.until(ExpectedConditions.visibilityOf(element));
    }



    /**
     * Add the generateRandomIntInRange Method to generate random interger in a given min max range
     * Generates random number of type string of specific length
     *
     *@author ankurd
     *@return String
     */
    public static String generateRandomIntInRange(int min, int max) {
        return Integer.toString(ThreadLocalRandom.current().nextInt(min, max + 1));
    }


}