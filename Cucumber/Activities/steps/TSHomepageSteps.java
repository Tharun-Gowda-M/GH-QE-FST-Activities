package steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TSHomepageSteps extends BaseClass {

    @Given("user is on the TS homepage")
    public void openTSHomepage() {
        driver.get("https://training-support.net");
    }

    @When("the user clicks on the About Us link")
    public void clickButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("About Us"))).click();
    }

    @Then("they are redirected to another page")
    public void aboutUsPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.text-center")));
        String pageHeading = driver.findElement(By.cssSelector("h1.text-center")).getText();
        System.out.println("New page heading is: " + pageHeading);
        assertEquals("About Us", pageHeading);
        System.out.println("Test passed: redirected successfully");
    }
}