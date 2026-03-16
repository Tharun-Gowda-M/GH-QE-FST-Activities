package TestNG.Activites;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;

import org.testng.annotations.*;

public class Activity10 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://training-support.net/webelements/simple-form");
        driver.manage().window().maximize();
    }

    public static List<List<String>> readExcel(String filePath) {

        List<List<String>> data = new ArrayList<>();

        try (FileInputStream file = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(file)) {

            XSSFSheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {

                List<String> rowData = new ArrayList<>();

                for (Cell cell : row) {

                    if (cell == null) {
                        rowData.add("");
                        continue;
                    }

                    if (cell.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(cell)) {

                        Date javaDate = cell.getDateCellValue();

                        LocalDate localDate = javaDate.toInstant()
                                .atZone(ZoneId.systemDefault())
                                .toLocalDate();

                        rowData.add(localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                    }
                    else if (cell.getCellType() == CellType.STRING) {

                        rowData.add(cell.getStringCellValue().trim());
                    }
                    else {

                        rowData.add(cell.toString());
                    }
                }

                data.add(rowData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    @DataProvider(name = "Events")
    public static Object[][] signUpInfo() {

        String filePath = "src/test/java/TestNG/sample.xlsx";

        List<List<String>> data = readExcel(filePath);

        return new Object[][]{
                {data.get(1).get(0), data.get(1).get(1), data.get(1).get(2), data.get(1).get(3)},
                {data.get(2).get(0), data.get(2).get(1), data.get(2).get(2), data.get(2).get(3)},
                {data.get(3).get(0), data.get(3).get(1), data.get(3).get(2), data.get(3).get(3)}
        };
    }

    @Test(dataProvider = "Events")
    public void registerTest(String fullNameValue, String emailValue, String dateValue, String detailsValue) {

        WebElement fullName = driver.findElement(By.id("full-name"));

        // Scroll to form first
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fullName);

        WebElement email = driver.findElement(By.id("email"));
        WebElement eventDate = driver.findElement(By.name("event-date"));
        WebElement details = driver.findElement(By.id("additional-details"));

        fullName.clear();
        email.clear();
        eventDate.clear();
        details.clear();

        fullName.sendKeys(fullNameValue);
        email.sendKeys(emailValue);
        eventDate.sendKeys(dateValue);
        details.sendKeys(detailsValue);

        driver.findElement(By.xpath("//button[text()='Submit']")).click();

        // Wait for confirmation message
        WebElement message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation"))
        );

        String confirmationText = message.getText().trim();

        assertEquals(confirmationText, "Your event has been scheduled!");

        driver.navigate().refresh();
    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}