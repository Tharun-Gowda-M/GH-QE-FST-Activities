package Selenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium_Activity15 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://training-support.net/webelements/dynamic-attributes");

        Thread.sleep(2000);

        System.out.println("Page title is: " + driver.getTitle());

        WebElement fullName = driver.findElement(By.xpath("//input[starts-with(@id, 'full-name')]"));
        WebElement email = driver.findElement(By.xpath("//input[contains(@id, '-email')]"));
        WebElement eventDate = driver.findElement(By.xpath("//input[contains(@name, '-event-date-')]"));
        WebElement details = driver.findElement(By.xpath("//textarea[contains(@id, '-additional-details-')]"));

        Thread.sleep(2000);

        fullName.sendKeys("Raiden Shogun");

        Thread.sleep(2000);

        email.sendKeys("raiden@electromail.com");

        Thread.sleep(2000);

        eventDate.sendKeys("2025-06-26");

        Thread.sleep(2000);

        details.sendKeys("It will be electric!");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[text()='Submit']")).click();

        Thread.sleep(2000);

        String message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation"))
        ).getText();

        System.out.println("Success message: " + message);

        Thread.sleep(2000);

        driver.quit();
    }
}