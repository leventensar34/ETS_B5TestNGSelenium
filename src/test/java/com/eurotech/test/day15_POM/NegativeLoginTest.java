package com.eurotech.test.day15_POM;

import com.eurotech.pages.LoginPage;
import com.eurotech.test.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {


    LoginPage loginPage=new LoginPage();

    @Test
    public void wrongUserName() {

        driver.get(ConfigurationReader.get("url"));
        WebElement userInput = driver.findElement(By.id("loginpage-input-email"));
        WebElement passwordInput = driver.findElement(By.name("password"));

        userInput.sendKeys("wronguser@gmail.com");
        passwordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));

        driver.findElement(By.id("rcc-confirm-button")).click();
        driver.findElement(By.id("loginpage-form-btn")).click();

        WebElement warningMessage = driver.findElement(By.xpath("//*[.='Invalid Credentials!']"));

        Assert.assertEquals(warningMessage.getText(), "Invalid Credentials!");
    }

    @Test
    public void wrongUserName2() {


        driver.get(ConfigurationReader.get("url1"));
        loginPage.usernameInput.sendKeys("standard_use");
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("passwordswag"));
        loginPage.loginBtn.click();
        System.out.println("loginPage.errorMessage.getText() = " + loginPage.errorMessage.getText());
        Assert.assertEquals(loginPage.errorMessage.getText(),"Epic sadface: Username and password do not match any user in this service");

    }

    @Test
    public void wrongPassword() {

        driver.get(ConfigurationReader.get("url1"));
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("userswag"));
        loginPage.passwordInput.sendKeys("secret_sauc");
        loginPage.loginBtn.click();

        String acctualUrl= driver.getCurrentUrl();
        Assert.assertEquals(acctualUrl,"https://www.saucedemo.com/");


    }
}
