package com.eurotech.test.day05_Xpath;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homework2_EbayJava {

    public static void main(String[] args) throws InterruptedException {

        /*

             Test case 1
       Go to Ebay
      enter search term as "java"
      click on search button
      print number of results
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.ebay-kleinanzeigen.de/");

        WebElement alleAkzeptierenButton= driver.findElement(By.xpath("(//span[@class='jsx-3186174802'])[2]"));
        alleAkzeptierenButton.click();

        Thread.sleep(3000);
        WebElement searchInputButton= driver.findElement(By.xpath("//input[@id='site-search-query']"));
        searchInputButton.sendKeys("java");
        driver.findElement(By.xpath("//button[@id='site-search-submit']")).click();

        WebElement numberOfResult= driver.findElement(By.xpath("//span[@class='breadcrump-summary']"));
        System.out.println("numberOfResult.getText() = " + numberOfResult.getText());
    }
}
