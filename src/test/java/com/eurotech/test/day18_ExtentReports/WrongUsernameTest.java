package com.eurotech.test.day18_ExtentReports;

import com.eurotech.pages.LoginPage;
import com.eurotech.test.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;

public class WrongUsernameTest extends TestBase {

    @Test
    public void wrongUsername() {

        LoginPage loginPage = new LoginPage();

        extentLogger = report.createTest("Wrong username Test");

        extentLogger.info("click understand button");
        loginPage.understandBtn_Loc.click();

        extentLogger.info("Enter wrong username");
        loginPage.usernameInput_loc.sendKeys("eurot@gmail.com");

        extentLogger.info("Enter correct password");
        loginPage.passwordInput_loc.sendKeys(ConfigurationReader.get("passwordTeacher"));

        extentLogger.info("Click login button");
        loginPage.loginBtn_loc.click();

        String actualMessage = loginPage.warningMessage_loc.getText();
        extentLogger.info("Verify that NOT log in ");
        Assert.assertEquals(actualMessage, "Invalid Credential!");

        extentLogger.pass("PASSED");

    }

    @Test
    public void wrongPassword() {


        LoginPage loginPage = new LoginPage();

        extentLogger = report.createTest("Wrong password Test");

        extentLogger.info("click understand button");
        loginPage.understandBtn_Loc.click();

        extentLogger.info("Enter correct username");
        loginPage.usernameInput_loc.sendKeys(ConfigurationReader.get("usernameTeacher"));

        extentLogger.info("Enter wrong password");
        loginPage.passwordInput_loc.sendKeys("wrongpassword");

        extentLogger.info("Click login button");
        loginPage.loginBtn_loc.click();

        String actualMessage = loginPage.warningMessage_loc.getText();
        extentLogger.info("Verify that NOT log in ");
        Assert.assertEquals(actualMessage, "Invalid Credentials!");

        extentLogger.pass("PASSED");

    }
}
