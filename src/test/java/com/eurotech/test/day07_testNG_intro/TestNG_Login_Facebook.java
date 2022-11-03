package com.eurotech.test.day07_testNG_intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestNG_Login_Facebook {

WebDriver driver;
    @Test
    public void pozitifLoginTest() {

        driver.get("https://www.facebook.com");

        WebElement cookies = driver.findElement(By.className("_9xo5"));
        List<WebElement> list = cookies.findElements(By.tagName("button"));
        WebElement id = list.get(0);
        id.click();

        WebElement emailBox = driver.findElement(By.id("email"));
        emailBox.click();
        emailBox.sendKeys("ensar2008@hotmail.com");

        WebElement passwordBox = driver.findElement(By.id("pass"));
        passwordBox.click();
        passwordBox.sendKeys("Gs19052008");


    }

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");


    }

    @AfterMethod
    public void tearDown() {


        driver.close();
    }
}
