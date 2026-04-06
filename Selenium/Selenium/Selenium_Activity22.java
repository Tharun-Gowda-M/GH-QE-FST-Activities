package Selenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium_Activity22 {
    public static void main(String[] args) throws InterruptedException {

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Create the Wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the page
        driver.get("https://training-support.net/webelements/popups");

        Thread.sleep(2000);

        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());

        Thread.sleep(2000);

        // Find the launcher button and click it
        driver.findElement(By.id("launcher")).click();

        Thread.sleep(2000);

        // Wait for the modal to appear
        wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));

        Thread.sleep(2000);

        // Find the input fields
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));

        // Enter the credentials
        username.sendKeys("admin");

        Thread.sleep(1500);

        password.sendKeys("password");

        Thread.sleep(2000);

        // Click the submit button
        driver.findElement(By.xpath("//button[text()='Submit']")).click();

        Thread.sleep(2000);

        // Print the success message
        String message = driver.findElement(By.cssSelector("h2.text-center")).getText();
        System.out.println("Login message: " + message);

        Thread.sleep(2000);

        // Close the browser
        driver.quit();
    }
}