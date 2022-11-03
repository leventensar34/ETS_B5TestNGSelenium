package com.eurotech.test.day03_WebElementIntro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetAttribute {

    public static void main(String[] args) throws InterruptedException {

        //getAttribute method

        //open chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        //go to http://eurotech.study/login
        driver.get("http://eurotech.study/login");
        Thread.sleep(2000);

        driver.findElement(By.id("rcc-confirm-button")).click();

        // enter e mail as 'eurotech@gmail.com'
        WebElement emailInputBtn= driver.findElement(By.id("loginpage-input-email"));
        emailInputBtn.sendKeys("eurotech@gmail.com");

        String emailInputBtnAttribute = emailInputBtn.getAttribute("value");
        System.out.println("emailInputBtnAttribute = " + emailInputBtnAttribute);


        //enter password as Test12345!
        String password="Test12345!";
        WebElement passwordInputBtn= driver.findElement(By.id("loginpage-form-pw-input"));
        passwordInputBtn.sendKeys(password);

        String passwordInputBtnAttribute = passwordInputBtn.getAttribute("name");
        System.out.println("passwordInputBtnAttribute = " + passwordInputBtnAttribute);


        //click login btn
        WebElement loginBtn=driver.findElement(By.id("loginpage-form-btn"));
        System.out.println("loginBtn.getAttribute(\"type\") = " + loginBtn.getAttribute("type"));
        loginBtn.click();


    }
}
