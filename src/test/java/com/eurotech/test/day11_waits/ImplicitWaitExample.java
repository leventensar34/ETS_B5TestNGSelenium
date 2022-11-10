package com.eurotech.test.day11_waits;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ImplicitWaitExample {


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

        driver.close();
        //driver.quit();
    }

    @Test
    public void implicitWait() {

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.cssSelector("#checkbox-example>button")).click();

        WebElement messageText = driver.findElement(By.cssSelector("#checkbox-example>p"));

        System.out.println("messageText.getText() = " + messageText.getText());

        Assert.assertEquals(messageText.getText(), "It's gone!");

    }

    @Test
    public void implicitWait2() {

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.cssSelector("#input-example>button")).click();

        WebElement enableMessage=driver.findElement(By.cssSelector("#input-example>p"));
        System.out.println("enableMessage.getText() = " + enableMessage.getText());

        Assert.assertEquals(enableMessage.getText(),"It's enabled!");


    }
}
