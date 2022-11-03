package com.eurotech.test.day05_Xpath;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homework2_EbaySelenium {

    public static void main(String[] args) throws InterruptedException {

        /*
             Go to Ebay
            search Selenium
           click on search button
           verify title contains Selenium

         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.ebay-kleinanzeigen.de/");

        WebElement alleAkzeptierenButton= driver.findElement(By.xpath("(//span[@class='jsx-3186174802'])[2]"));
        alleAkzeptierenButton.click();

        Thread.sleep(3000);

        WebElement searchInputButton= driver.findElement(By.xpath("//input[@id='site-search-query']"));
        searchInputButton.sendKeys("Selenium");
        driver.findElement(By.xpath("//button[@id='site-search-submit']")).click();

        String actualTitle=driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);


    }
}
