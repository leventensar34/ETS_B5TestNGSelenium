package com.eurotech.test.day09_TypeOfWebElements2;


import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfWebElements {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }


    @Test
    public void test2() {

        driver.get("https://demoqa.com/elements");

        List<WebElement> menuList = driver.findElements(By.cssSelector(".header-text"));

        System.out.println("menuList.size() = " + menuList.size());

        int expectedSize = 6;
        int actualSize = menuList.size();

        Assert.assertEquals(actualSize, expectedSize);

        for (WebElement element : menuList) {
            System.out.println("element.getText() = " + element.getText());
            Assert.assertTrue(element.isDisplayed());
        }


    }


    @Test
    public void test1() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com");

        List<WebElement> menuList = driver.findElements(By.xpath("//a[text()='A/B Testing']/../../li"));

        // get size()--> return the size of the element
        System.out.println("menuList.size() = " + menuList.size());

        int expectedSize = 44;
        int actualSize = menuList.size();

        Assert.assertEquals(actualSize, expectedSize);

        System.out.println("menuList.get(0) = " + menuList.get(0));

        menuList.get(0).click();
        Thread.sleep(2000);

        for (WebElement element : menuList) {

            System.out.println("element.getText() = " + element.getText());
        }


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}