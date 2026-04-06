package Selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium_Activity20 {
    public static void main(String[] args) throws InterruptedException {

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("https://training-support.net/webelements/alerts");

        // Wait 2 seconds
        Thread.sleep(2000);

        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());

        // Wait 2 seconds
        Thread.sleep(2000);

        // Find and click the button to open the prompt alert
        driver.findElement(By.id("prompt")).click();

        // Wait for alert to appear
        Thread.sleep(2000);

        // Switch focus to the alert
        Alert promptAlert = driver.switchTo().alert();

        // Print the text in the alert
        String alertText = promptAlert.getText();
        System.out.println("Text in alert: " + alertText);

        // Wait 2 seconds
        Thread.sleep(2000);

        // Type into the alert
        promptAlert.sendKeys("Awesome!");

        // Wait 3 seconds
        Thread.sleep(3000);

        // Close the alert by clicking OK
        promptAlert.accept();

        // Wait 2 seconds
        Thread.sleep(2000);

        // Print the result message
        System.out.println(driver.findElement(By.id("result")).getText());

        // Wait 2 seconds before closing browser
        Thread.sleep(2000);

        // Close the browser
        driver.quit();
    }
}