package com.eurotech.test.day03_WebElementIntro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyThatConfirmationMessage {

    public static void main(String[] args) throws InterruptedException {

        //open chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        //go to http://eurotech.study/login
        driver.get("http://eurotech.study/login");
        Thread.sleep(2000);

        driver.findElement(By.id("rcc-confirm-button")).click();

        // enter e mail as 'eurotech@gmail.com'
        WebElement emailInputBtn= driver.findElement(By.id("loginpage-input-email"));
        emailInputBtn.sendKeys("eurotech@gmail.com");


        //enter password as Test12345!
        String password="Test12345!";
        WebElement passwordInputBtn= driver.findElement(By.id("loginpage-form-pw-input"));
        passwordInputBtn.sendKeys(password);

        //click login btn
        WebElement loginBtn=driver.findElement(By.id("loginpage-form-btn"));
        loginBtn.click();

        Thread.sleep(2000);


        //verify that welcome message is "welcome Eurotech"

        WebElement welcomeMessageText= driver.findElement(By.id("dashboard-p1"));
        String actualMessage= welcomeMessageText.getText();
        System.out.println("messageText = " + actualMessage);

        String expectedMessage="Welcome Teacher";

        if (expectedMessage.equals(actualMessage)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }

        driver.close();
    }
}
