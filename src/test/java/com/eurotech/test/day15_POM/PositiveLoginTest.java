package com.eurotech.test.day15_POM;

import com.eurotech.pages.LoginPage;
import com.eurotech.test.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {

    LoginPage loginPage=new LoginPage();

    @Test
    public void login() {

        driver.get(ConfigurationReader.get("url1"));
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("userswag"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("passwordswag"));
        loginPage.loginBtn.click();

        Assert.assertEquals(loginPage.productsText.getText(),"PRODUCTS");

    }

    @Test
    public void loginWithMethod() {

        driver.get(ConfigurationReader.get("url1"));
        loginPage.login();

    }

    @Test
    public void loginAsPerform() {
        driver.get(ConfigurationReader.get("url1"));

        loginPage.loginAsPerform();

        String actualUrl= driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,"https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void loginAsProblemMethod() {
        driver.get(ConfigurationReader.get("url1"));

        loginPage.loginAsProblem();

        Assert.assertEquals(loginPage.productsText.getText(),"PRODUCTS");

    }
}
