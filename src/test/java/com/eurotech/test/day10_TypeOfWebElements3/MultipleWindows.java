package com.eurotech.test.day10_TypeOfWebElements3;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MultipleWindows {


    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        // driver.close();
       // driver.quit();
    }


    @Test
    public void twoWindows() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/windows");
        String titleBeforeClick = driver.getTitle();
        System.out.println("titleBeforeClick = " + titleBeforeClick);

        WebElement click_here = driver.findElement(By.linkText("Click Here"));
        click_here.click();

        Thread.sleep(2000);
        // String titleAfterClick = driver.getTitle();
        // System.out.println("titleAfterClick = " + titleAfterClick);

        String currentTab = driver.getWindowHandle(); // title The Internet and has ID
        // Bu method ilgili acilan sayfanin id sini verir
        System.out.println("currentTab = " + currentTab);

        Set<String> windowsHandle = driver.getWindowHandles();
        // first and most important thing;
        // HashSet is a collection of an items where every Item is uniq!!!

        for (String tab : windowsHandle) {
            if (!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
            }

        }

        System.out.println("driver.getTitle() = " + driver.getTitle());


    }

    @Test
    public void multipleWindows() {

        driver.get("https://the-internet.herokuapp.com/windows");

        System.out.println("driver.getTitle() = " + driver.getTitle());

        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());

        WebElement click_here = driver.findElement(By.linkText("Click Here"));
        click_here.click();
        click_here.click();
        click_here.click();
        click_here.click();

//        List<String> tabs=new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(3));
//        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        Set<String> windowHandle = driver.getWindowHandles();

        for (String tab : windowHandle) {
            driver.switchTo().window(tab);
            if (driver.getTitle().equals("New Window")) {
                break;
            }
        }

        System.out.println("driver.getTitle() = " + driver.getTitle());
    }
}
