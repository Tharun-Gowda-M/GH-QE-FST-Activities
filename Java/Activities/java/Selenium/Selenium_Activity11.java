package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Selenium_Activity11 {
    public static void main(String[] args) {

        // Initialize Firefox Driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("https://training-support.net");

        // Print home page title
        System.out.println("Page title is: " + driver.getTitle());

        // Click About Us link
        driver.findElement(By.linkText("About Us")).click();

        // Print About Us page title
        System.out.println("New page title is: " + driver.getTitle());

        // Locate the About Us content
        WebElement aboutContent = driver.findElement(By.tagName("p"));

        // Print the text inside About Us
        System.out.println("About Us Content:");
        System.out.println(aboutContent.getText());

        // Close browser
        driver.quit();
    }
}
