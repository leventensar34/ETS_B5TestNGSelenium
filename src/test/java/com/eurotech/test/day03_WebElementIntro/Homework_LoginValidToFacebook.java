package com.eurotech.test.day03_WebElementIntro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.*;

import java.util.List;

public class Homework_LoginValidToFacebook {

    public static void main(String[] args) {

        /*
   -open chrome browser
   -go to https://www.facebook.com/
   -enter real username
   -enter real password
   -click login button
   -verify that login successfully

         */

        WebDriver driver = WebDriverFactory.getDriver("Chrome");

        driver.get("https://www.facebook.com");
        //driver.findElement(By.cssSelector(""))

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

        // WebElement loginButton= driver.findElement(By.xpath("//div/button"));
        WebElement loginButton = driver.findElement(By.name("login"));
        loginButton.click();


    }
}
