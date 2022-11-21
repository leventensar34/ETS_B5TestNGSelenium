package com.eurotech.test.day16_POM2;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.test.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DashboardTest extends TestBase {

    DashboardPage dashboardPage = new DashboardPage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void dashboardMenu() {

        /**
         * Class Task
         *
         * go to http://92.205.106.232/login
         * login with teacher credentials
         * Get the text of the dashboard and verify following menu
         *     Developers
         *     All Posts
         *     My Account
         */

        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher_Mtd();

        String expectedText="Welcome Teacher";

        Assert.assertEquals(dashboardPage.welcomeMessage_loc.getText(),expectedText,
                "Verify that log in successfully");

        // 1. way
        for (WebElement menu : dashboardPage.menuList_loc ) {
            System.out.println("menu.getText() = " + menu.getText());

        }

//        // 2 . way
//        List<WebElement> dashboardMenu=dashboardPage.menuList_loc;
//        for (WebElement menu: dashboardMenu){
//            System.out.println("menu.getText() = " + menu.getText());
//        }


    }


    @Test
    public void navigatemenu() {

        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher_Mtd();

        String expectedText="Welcome Teacher";

        Assert.assertEquals(dashboardPage.welcomeMessage_loc.getText(),expectedText,
                "Verify that log in successfully");

        dashboardPage.allPosts_loc.click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/posts");


        dashboardPage.developers_loc.click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/profiles");

    }

    @Test
    public void navigate2() {

        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsTeacher_Mtd();

        String expectedText="Welcome Teacher";

        Assert.assertEquals(dashboardPage.welcomeMessage_loc.getText(),expectedText,
                "Verify that log in successfully");
        dashboardPage.navigateToMenu("Developers");
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/profiles");
        dashboardPage.navigateToMenu("All Posts");
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/posts");


    }
}
