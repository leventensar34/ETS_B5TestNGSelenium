package com.eurotech.test.day13_webTables;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTable {


    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        // WebDriverWait wait= new WebDriverWait(driver,15);
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
        driver.findElement(By.cssSelector("#ez-accept-all")).click();

        WebElement demoTable = driver.findElement(By.xpath("//h3[text()='Demo Table 2']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", demoTable);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();

    }

    @Test
    public void printTable() {


        WebElement tableDemo = driver.findElement(By.xpath("//table[@border='1']"));

        System.out.println("tableDemo.getText() = " + tableDemo.getText());

        Assert.assertTrue(tableDemo.getText().contains("Mecca"));


    }

    @Test
    public void getAllHeaders() {
        //get allColumn headers
        List<WebElement> allHeaders = driver.findElements(By.xpath("//table[@border='1']/thead/tr/th"));

        //get size
        System.out.println("allHeaders.size() = " + allHeaders.size());

        //get all headers--> use for-each
        for (WebElement header : allHeaders) {
            System.out.println("header.getText() = " + header.getText());
        }

        // to get allRow headers

        List<WebElement> allRows = driver.findElements(By.xpath("//table[@border='1']/tbody/tr"));

        // get size
        System.out.println("allRows.size() = " + allRows.size());

        for (WebElement allRow : allRows) {
            System.out.println("allRow.getText() = " + allRow.getText());
        }
    }

    @Test
    public void getRows() {

        List<WebElement> allRows = driver.findElements(By.xpath("//table[@border='1']/tbody/tr"));
        System.out.println("allRows.size() = " + allRows.size());

        WebElement clockTower = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[2]"));
        System.out.println("clockTower.getText() = " + clockTower.getText());

        for (int i = 1; i <= allRows.size(); i++) {

            WebElement row = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[" + i + "]"));
            System.out.println("row.getText() = " + row.getText());

        }
    }

    @Test
    public void getAllCellOnOneRow() {

        //task-->get Burj Khalifa's info as a list
        List<WebElement> burjKhalifa = driver.findElements(By.xpath("//table[@border='1']/tbody/tr[1]/td"));
        System.out.println("burjKhalifa.size() = " + burjKhalifa.size());

        Assert.assertEquals(burjKhalifa.size(), 6);

        for (WebElement burj : burjKhalifa) {
            System.out.println("burj.getText() = " + burj.getText());
        }

    }

    @Test
    public void getSingleCell() {

        // task one cell
        // get Height from Clock Tower Hotel
        // verify thatt height is 601m

        WebElement heightClockTowerHotel = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[2]/td[3]"));
        System.out.println("heightClockTowerHotel.getText() = " + heightClockTowerHotel.getText());
        Assert.assertEquals(heightClockTowerHotel.getText(), "601m");


    }

    @Test
    public void printAllCellByIndex() {

        //*** we need nested loop
        //*** we need methods

        int rowNumber = getNumberOfRows();
        int columnNumber = getNumberOfColumn();

        System.out.println("rowNumber = " + rowNumber);
        System.out.println("columnNumber = " + columnNumber);


        // iterate through each row on the table
        for (int i = 1; i <= rowNumber; i++) {

            //iterate through eachh row cell in the row
            for (int j = 1; j < columnNumber; j++) {

                String cellPath = "//table[@border='1']/tbody/tr[" + i + "]/td[" + j + "]";
               // System.out.println("cellPath = " + cellPath);

                WebElement cell = driver.findElement(By.xpath(cellPath));
                System.out.println("cell.getText() = " + cell.getText());

            }
        }


    }

    private int getNumberOfColumn() {

        List<WebElement> columns = driver.findElements(By.xpath("//table[@border='1']/thead//th"));
        return columns.size();
    }

    private int getNumberOfRows() {

        List<WebElement> rows = driver.findElements(By.xpath("//table[@border='1']/tbody/tr"));
        return rows.size();
    }
}
