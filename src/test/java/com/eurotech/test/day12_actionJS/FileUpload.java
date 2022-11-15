package com.eurotech.test.day12_actionJS;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FileUpload {


    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        // WebDriverWait wait= new WebDriverWait(driver,15);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();

    }

    @Test
    public void fileUploadTest1() {

        driver.get("https://the-internet.herokuapp.com/upload");

       WebElement chooseFile= driver.findElement(By.cssSelector("#file-upload"));

       chooseFile.sendKeys("C:/Users/User/Pictures/Screenshots/Ekran Görüntüsü (14).png");

       driver.findElement(By.id("file-submit")).click();

       String actualText=driver.findElement(By.id("uploaded-files")).getText();

        Assert.assertEquals(actualText,"Ekran Görüntüsü (14).png");

    }

    @Test
    public void fileUploadTest2() {

        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));
//        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));
//        System.out.println("System.getenv(\"Path\") = " + System.getenv("Path"));

        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement chooseFile= driver.findElement(By.cssSelector("#file-upload"));

        chooseFile.sendKeys("C:/Users/User/Pictures/Screenshots/Ekran Görüntüsü (14).png");


        String projectPath=System.getProperty("user.dir");

        String filePath="src/test/resources/EurotechB5.txt";

        String fullPath=projectPath+"/"+filePath;
        System.out.println("fullPath = " + fullPath);

        chooseFile.sendKeys(fullPath);
        driver.findElement(By.id("file-submit")).click();

    }
}
