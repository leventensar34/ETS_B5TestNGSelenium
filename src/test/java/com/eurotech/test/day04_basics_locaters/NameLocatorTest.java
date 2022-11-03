package com.eurotech.test.day04_basics_locaters;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NameLocatorTest {

    public static void main(String[] args) throws InterruptedException {



        Faker faker=new Faker();

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://eurotech.study/login");

       WebElement understandBtn= driver.findElement(By.id("rcc-confirm-button"));
       understandBtn.click();

        WebElement emailInputBox=driver.findElement(By.name("email"));
        emailInputBox.sendKeys("eurotech@gmail.com");

        //1.way
        WebElement passwordInputBox=driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("Test12345!");

        //2.way--> lazy way
       // driver.findElement(By.name("password")).sendKeys("Test12345!");


        driver.findElement(By.id("loginpage-form-btn")).click();

        Thread.sleep(2000);



    }
}
