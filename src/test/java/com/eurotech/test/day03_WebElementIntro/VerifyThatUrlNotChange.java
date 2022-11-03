package com.eurotech.test.day03_WebElementIntro;

import com.eurotech.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyThatUrlNotChange {

    public static void main(String[] args) {

        // open Chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        // go to "http:// eurotech.study/login"
        driver.get("http://eurotech.study/login");

        // click to login btn
        driver.findElement(By.id("rcc-confirm-button")).click();

        WebElement loginBtn= driver.findElement(By.id("loginpage-form-btn"));

        loginBtn.click();


        // verify not changed is url
        String expectedUrl="http://eurotech.study/login";
        String actualUrl= driver.getCurrentUrl();
        System.out.println("actualUrl = " + actualUrl);

        if (expectedUrl.equals(actualUrl)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }
        driver.close();



    }
}
