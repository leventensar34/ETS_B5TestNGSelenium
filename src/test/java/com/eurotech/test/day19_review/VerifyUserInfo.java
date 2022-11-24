package com.eurotech.test.day19_review;

import com.eurotech.pages.ToolsQALoginPage;
import com.eurotech.test.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyUserInfo extends TestBase {

    /*
         Test1
    -create mew user

         Test2
    -login as a new user
    -Verify that login is successfully
    -click on go to Book Store
    -Verify that went Book Store
    -Search 'Addy Osmani' in search button

    */
    ToolsQALoginPage toolsQALoginPage = new ToolsQALoginPage();

    @Test
    public void newUserCreate() {


        extentLogger = report.createTest("User create info verification");

        extentLogger.info("Click on new User button");
        toolsQALoginPage.newUserBtn.click();

        extentLogger.info("Enter first name");
        toolsQALoginPage.firstNameInput.sendKeys("Euro");

        extentLogger.info("Enter last name");
        toolsQALoginPage.lastNameInput.sendKeys("tech");

        extentLogger.info("Enter UserName");
        toolsQALoginPage.userNameInput.sendKeys("Eurotech");

        extentLogger.info("Enter password");
        toolsQALoginPage.passwordInput.sendKeys("Eurotech12!");

        extentLogger.info("Click on the I'm not robot");
        toolsQALoginPage.imRobotBtn.click();

        extentLogger.info("Click on the register");
        toolsQALoginPage.registerBtn.click();

        extentLogger.pass("PASSED");

    }

    @Test
    public void loginInfo() {

        extentLogger = report.createTest("User info verification");

        extentLogger.info("Enter User Name");
        toolsQALoginPage.userNameLoginInput.sendKeys(ConfigurationReader.get("userToolsQA"));

        extentLogger.info("Enter password");
        toolsQALoginPage.passwordLoginInput.sendKeys(ConfigurationReader.get("passwordToolsQA"));

        extentLogger.info("Click on the login button");
        toolsQALoginPage.loginBtn.click();

        //1.way
        extentLogger.info("Verify that login is successfully");

        BrowserUtils.waitFor(2);
        String expectedUrl = "https://demoqa.com/profile";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);

        //2.way

        String expectedVerifyMessage = "Eurotech";
        extentLogger.info("Verify that login is profile" + expectedVerifyMessage);

        String actualVerifyUser = toolsQALoginPage.verifyUserName.getText();
        Assert.assertEquals(actualVerifyUser, expectedVerifyMessage);

        extentLogger.info("Click on the Go To Store button");
        // actions.moveToElement( toolsQALoginPage.goToStoreBtn).click();
        BrowserUtils.clickWithJS(toolsQALoginPage.goToStoreBtn);

        extentLogger.info("Enter search button 'You Don't Know JS'  ");
        toolsQALoginPage.typeTosearchBtn.sendKeys("You Don't Know JS");

        extentLogger.pass("PASSED");

    }
}
