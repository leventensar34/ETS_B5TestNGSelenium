package com.eurotech.test.day20_DDF;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.test.TestBase;
import com.eurotech.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFLoginTest extends TestBase {

    @DataProvider
    public Object[][] userData() {
        //path of Excel and sheet name
        ExcelUtil testData = new ExcelUtil("src/test/resources/Mappe1.xlsx", "Tabelle1");

        return testData.getDataArrayWithoutFirstRow();
    }


    @Test(dataProvider = "userData")
    public void ddfLoginTest(String username, String password, String title, String company, String name) {
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();

        extentLogger = report.createTest(name + "'s Login Test");

        extentLogger.info("Click understand button");
        loginPage.understandBtn_Loc.click();

        extentLogger.info("Enter username");
        loginPage.usernameInput_loc.sendKeys(username);

        extentLogger.info("Enter password");
        loginPage.passwordInput_loc.sendKeys(password);

        extentLogger.info("Click login button");
        loginPage.loginBtn_loc.click();

        String expectedMessage = "Welcome " + name;
        extentLogger.info("Verify that  welcome message is " + expectedMessage);
        Assert.assertEquals(dashboardPage.welcomeMessage_loc.getText(), expectedMessage);

        extentLogger.info("Verify that title is " + title);

        extentLogger.info("Verify that "+name+" is working at "+company);

       Assert.assertEquals(dashboardPage.getCompany_mtd(company),company);

       extentLogger.pass("PASSED");

    }
}
