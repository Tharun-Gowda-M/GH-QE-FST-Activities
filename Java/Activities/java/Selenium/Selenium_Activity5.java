package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium_Activity5 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/webelements/dynamic-controls");

        System.out.println("Page title: " + driver.getTitle());

        // Find checkbox
        WebElement checkbox = driver.findElement(By.id("checkbox"));

        // Check visibility first
        System.out.println("Checkbox displayed: " + checkbox.isDisplayed());

        // Wait 2 seconds
        Thread.sleep(2000);

        // Click toggle button
        driver.findElement(By.xpath("//button[text()='Toggle Checkbox']")).click();

        // Wait 2 seconds
        Thread.sleep(2000);

        // Check again
        System.out.println("Checkbox displayed: " + checkbox.isDisplayed());

        driver.quit();
    }
}