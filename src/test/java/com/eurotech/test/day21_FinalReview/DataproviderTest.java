package com.eurotech.test.day21_FinalReview;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.test.TestBase;
import com.eurotech.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderTest extends TestBase {

    @DataProvider
    public Object[][] excelLogin() {

        String[][] data = {
                {"ensar1905@gmail.com", "Gs1905"},
                {"emre@gmail.com", "Test12345!"},
                {"hakans@gmail.com", "hakan86"},
                {"Feride@gmail.com", "Test123456!"}
        };

        return data;
    }


    @Test(dataProvider = "excelLogin")
    public void test(String email, String password) {

        /**Class Task
         * create four test data with DevEX user credentials by using @DataProvider
         * and execute this data set with extendReports
         */
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();

        extentLogger = report.createTest(email + "'s Login Test");

        extentLogger.info("Click understand button");
        loginPage.understandBtn_Loc.click();

        //1. way
        extentLogger.info("Enter email and password");
        loginPage.login_Mtd(email, password);

        //2. way
//        extentLogger.info("Enter username");
//        loginPage.usernameInput_loc.sendKeys(email);
//
//        extentLogger.info("Enter password");
//        loginPage.passwordInput_loc.sendKeys(password);
//
//        extentLogger.info("Click login button");
//        loginPage.loginBtn_loc.click();

        extentLogger.pass("PASSED");
    }


    @DataProvider
    public Object[][] dataUser() {
        ExcelUtil testData = new ExcelUtil("src/test/resources/Mappe3.xlsx", "Tabelle1");
        return testData.getDataArrayWithoutFirstRow();
    }

    @Test(dataProvider = "dataUser")
    public void testDemo(String username, String password) {

        /**Class Task
         * create test data with Swag labs user credentials and Product page for verify by using Excel
         * and execute this data set with extendReports
         * Hint : use product page title to verify
         */
        LoginPage loginPage = new LoginPage();
        extentLogger = report.createTest( username+"'s Login Test");

        extentLogger.info("Enter username");
        loginPage.usernameInput.sendKeys(username);

        extentLogger.info("Enter password");
        loginPage.passwordInput.sendKeys(password);

        extentLogger.info("Click login button");
        loginPage.loginBtn.click();

        extentLogger.info("Verify that Page");
        Assert.assertEquals(loginPage.productsText.getText(),"PRODUCTS");

        extentLogger.pass("PASSED");

    }
}
