package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium_Activity6 {
    public static void main(String[] args) throws InterruptedException {

       
        WebDriver driver = new FirefoxDriver();

        
        driver.get("https://training-support.net/webelements/dynamic-controls");

        
        Thread.sleep(2000);

       
        System.out.println("Page title: " + driver.getTitle());

        
        WebElement checkbox = driver.findElement(By.id("checkbox"));

      
        System.out.println("Checkbox selected: " + checkbox.isSelected());

       
        Thread.sleep(2000);

        
        checkbox.click();

      
        Thread.sleep(2000);

    
        System.out.println("Checkbox selected: " + checkbox.isSelected());

       
        Thread.sleep(2000);

        
        driver.quit();
    }
}
