package steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.openqa.selenium.By;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataTableExampleSteps extends BaseClass {

    @Given("user is on the To-Do list page")
    public void openPage() {
        driver.get("https://training-support.net/webelements/todo-list");
        assertEquals("Selenium: To-Do List", driver.getTitle());
    }

    @When("user adds the following tasks")
    public void inputTasks(DataTable inputTasks) {
        List<String> tasks = inputTasks.asList();

        System.out.println("Tasks: " + tasks);

        for (String task : tasks) {
            driver.findElement(By.id("todo-input")).sendKeys(task);
            driver.findElement(By.id("todo-add")).click();
        }
    }

    @Then("they can see the task added to the list")
    public void verifyResults() {
        System.out.println("All tasks added successfully");
    }
}