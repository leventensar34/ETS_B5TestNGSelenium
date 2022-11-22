package com.eurotech.test.day17_POM3;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.test.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task_Tab extends TestBase {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage=new DashboardPage();

    @Test
    public void taskTab() {


        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher_Mtd();
        String expectedText = "Experience Credentials";
        Assert.assertEquals(dashboardPage.credentialMessage.getText(), expectedText, "Verify that log in successfully");

        dashboardPage.navigateAll("My Account","My Posts");
        Assert.assertTrue(dashboardPage.submitBtn_loc.isDisplayed(), "Verify that submit button is displayed  ");

        dashboardPage.navigateAll("My Account","Logout");
        Assert.assertTrue(dashboardPage.signText.isDisplayed(), "Verify that login button is displayed");


        /* Method in DashboardPage

     public void navigateAll(String tab, String modul) {
        Driver.get().findElement(By.xpath("//*[text()='" + tab + "']")).click();
        Driver.get().findElement(By.xpath("//span[text()='" + modul + "']")).click();
    }

          * Elements in DashboardPage

      @FindBy(css = "#loginpage-h1")
    public WebElement signText;

    @FindBy(css = "#dashboard-experience-h1")
    public WebElement credentialMessage;


         */


    }
}
