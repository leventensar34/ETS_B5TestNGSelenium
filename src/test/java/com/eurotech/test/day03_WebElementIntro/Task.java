package com.eurotech.test.day03_WebElementIntro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task {

    public static void main(String[] args) throws InterruptedException {

        /*
        -open chrome browser
        -go to https://www.amazon.com
        -enter 'Java' in the search button
        -click on search  button
        -verify that title has changed
         */
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("http://www.amazon.com");

        Thread.sleep(2000);

        WebElement boxButton= driver.findElement(By.id("twotabsearchtextbox"));
        boxButton.sendKeys("Java");

        WebElement sourchBox= driver.findElement(By.id("nav-search-submit-button"));
        sourchBox.click();

        String expectedTitle="Amazon.com : Java";;
        System.out.println(expectedTitle);

        String actualTitle= driver.getTitle();
        System.out.println(actualTitle);

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }

        driver.close();
    }
}
