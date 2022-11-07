package com.eurotech.test.day08_TypeOfWebElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task2 {

    @Test
    public void test1() throws InterruptedException {

        //https://the-internet.herokuapp.com/dynamic_loading
        //Homework
        //Example 2: Element rendered after the fact -->click
        //click that element
        //verify that hello world is not displayed
        //click start button
        //verify that hello element is displayed
        //and verify that "Hello World!" text is present


        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");

        WebElement example2Button= driver.findElement(By.xpath("//a[contains(text(),'Example 2')]"));
        example2Button.click();

        // Not: 'Hello World' text i onceden mevcut olmagi icin burada elementi bulamiyoruz.Fakat start butonuna
        // bastiktan sonra bu bu yazi olusturuluyor.Ancak o zaman elementi görebiliyoruz.

//        WebElement helloText= driver.findElement(By.xpath("//*[text()='Hello World!']"));
//        System.out.println("helloText.isDisplayed() = " + helloText.isDisplayed());
//        Assert.assertFalse(helloText.isDisplayed());


        WebElement startButton= driver.findElement(By.xpath("//div/button"));
        startButton.click();

        Thread.sleep(5000);
        WebElement helloText= driver.findElement(By.xpath("//*[text()='Hello World!']"));
        Assert.assertTrue(helloText.isDisplayed());
        System.out.println("helloText.getText() = " + helloText.getText());


    }
}
