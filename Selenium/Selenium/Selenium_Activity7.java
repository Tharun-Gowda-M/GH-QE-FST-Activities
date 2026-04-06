package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium_Activity7 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/webelements/dynamic-controls");

        Thread.sleep(2000);

        System.out.println("Page title: " + driver.getTitle());

        WebElement textField = driver.findElement(By.xpath("//input[@type='text']"));

        System.out.println("Text field enabled: " + textField.isEnabled());

        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[text()='Enable Input']")).click();

        Thread.sleep(3000);

        System.out.println("Text field enabled: " + textField.isEnabled());

        Thread.sleep(2000);

        driver.quit();
    }
}
