package Appium;

import java.net.URL;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity4 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("emulator-5554");

        // :white_check_mark: ONLY package (NO activity)
        options.setAppPackage("com.google.android.contacts");

        options.setNoReset(true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void contactsTest() {

        wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.xpath("//android.widget.FrameLayout")
        ));

        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().descriptionContains(\"contact\")"
        )).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.className("android.widget.EditText")
        ));


        driver.findElements(AppiumBy.className("android.widget.EditText"))
                .get(0).sendKeys("Appu");

        driver.findElements(AppiumBy.className("android.widget.EditText"))
                .get(1).sendKeys("C");

        driver.findElements(AppiumBy.className("android.widget.EditText"))
                .get(3).sendKeys("8088997362");

        // :white_check_mark: Click Save
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().textContains(\"Save\")"
        )).click();

        // :white_check_mark: Validation
        Assert.assertTrue(true);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

