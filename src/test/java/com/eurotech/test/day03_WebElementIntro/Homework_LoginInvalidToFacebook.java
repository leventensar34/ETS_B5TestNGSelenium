package com.eurotech.test.day03_WebElementIntro;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Homework_LoginInvalidToFacebook {

    public static void main(String[] args) {


        /*
            Task2
   -open chrome browser
   -go to https://www.facebook.com/
   -enter dummy username with using Faker class
   -enter dummy password with using Faker class
   -click login btn
   -veriify that login Failed
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get(" https://www.facebook.com/");


        WebElement cookies = driver.findElement(By.className("_9xo5"));
        List<WebElement> list = cookies.findElements(By.tagName("button"));
        WebElement id = list.get(0);
        id.click();

        WebElement emailButton = driver.findElement(By.id("email"));
        emailButton.click();
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        emailButton.sendKeys(email);

        WebElement passwordButton = driver.findElement(By.id("pass"));
        passwordButton.click();
        String password = faker.phoneNumber().phoneNumber().concat(faker.name().firstName());
        passwordButton.sendKeys(password);

        WebElement loginButton = driver.findElement(By.name("login"));
        loginButton.click();

    }
}
