package Selenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium_Activity21 {
    public static void main(String[] args) throws InterruptedException {

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Create the Wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the page
        driver.get("https://training-support.net/webelements/tabs");

        Thread.sleep(2000);

        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());

        Thread.sleep(2000);

        // Print the handle of the parent window
        System.out.println("Current tab: " + driver.getWindowHandle());

        Thread.sleep(2000);

        // Find button to open new tab
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Open A New Tab']"))).click();

        Thread.sleep(2000);

        // Wait for the second tab to open
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Thread.sleep(2000);

        // Print all window handles
        System.out.println("Currently open windows: " + driver.getWindowHandles());

        Thread.sleep(2000);

        // Switch focus to the latest tab
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        Thread.sleep(2000);

        // Wait for the new page to load
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Another One')]")));

        Thread.sleep(2000);

        // Print the handle of the current tab
        System.out.println("Current tab: " + driver.getWindowHandle());

        // Print the title and heading of the new page
        System.out.println("New Page title: " + driver.getTitle());
        System.out.println("New Page message: " + driver.findElement(By.cssSelector("h2.mt-5")).getText());

        Thread.sleep(2000);

        // Find and click the button on page to open another tab
        driver.findElement(By.xpath("//button[contains(text(), 'Another One')]")).click();

        Thread.sleep(2000);

        // Wait for new tab to open
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));

        Thread.sleep(2000);

        // Switch focus
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        Thread.sleep(3000);

        // Close the browser
        driver.quit();
    }
}