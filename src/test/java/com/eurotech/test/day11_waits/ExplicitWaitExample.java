package com.eurotech.test.day11_waits;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitExample {


    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        // used Selenium version 4
        //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        //driver.close();
        //driver.quit();
    }

    @Test
    public void explicitWait() {

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        WebDriverWait wait = new WebDriverWait(driver, 15);


        driver.findElement(By.cssSelector("#start>button")).click();

        WebElement helloText = driver.findElement(By.xpath("//h4[text()='Hello World!']"));

        // it will wait up to 15 second until hello element is visible
        wait.until(ExpectedConditions.visibilityOf(helloText));

        System.out.println("helloText.getText() = " + helloText.getText());

        Assert.assertEquals(helloText.getText(), "Hello World!");


    }

    @Test
    public void explicitWait2() {

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebDriverWait wait = new WebDriverWait(driver, 15);

        driver.findElement(By.xpath("(//button[@autocomplete='off'])[2]")).click();

        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));
        wait.until(ExpectedConditions.elementToBeClickable(inputBox));

        inputBox.sendKeys("Eurotech");

        WebElement messageText = driver.findElement(By.cssSelector("#input-example>p"));
        System.out.println("messageText.getText() = " + messageText.getText());

        Assert.assertEquals(messageText.getText(), "It's enabled!");


    }

    @Test
    public void testName() {


        driver.get("https://demoqa.com/alerts");

        WebDriverWait wait = new WebDriverWait(driver, 15);

        // On button click, alert will appear after 5 seconds

        driver.findElement(By.cssSelector("#timerAlertButton")).click();

        wait.until(ExpectedConditions.alertIsPresent());

        System.out.println("driver.switchTo().alert().getText() = " + driver.switchTo().alert().getText());

        driver.switchTo().alert().accept();


    }
}
