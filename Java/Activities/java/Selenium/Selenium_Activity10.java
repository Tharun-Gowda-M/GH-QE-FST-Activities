package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Selenium_Activity10 {
     public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/webelements/drag-drop");

        Thread.sleep(2000);

        System.out.println("Page title: " + driver.getTitle());

        WebElement ball = driver.findElement(By.id("ball"));
        WebElement dropzone1 = driver.findElement(By.id("dropzone1"));
        WebElement dropzone2 = driver.findElement(By.id("dropzone2"));

        Actions actions = new Actions(driver);

        actions.dragAndDrop(ball, dropzone1).perform();

        Thread.sleep(3000);

        System.out.println("Ball moved to Dropzone 1");

        actions.dragAndDrop(ball, dropzone2).perform();

        Thread.sleep(3000);

        System.out.println("Ball moved to Dropzone 2");

        Thread.sleep(2000);

        driver.quit();
    }
}
