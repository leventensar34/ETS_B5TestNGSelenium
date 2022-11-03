package com.eurotech.test.day05_Xpath;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homework2_WikipediaSelenium {

    public static void main(String[] args) {


        /*
             Test case 3
       Go to wikipedia.org (Links to an external site.)
       enter search term selenium webdriver
       click on search button
       click on search result Selenium (software)
       verify url ends with `Selenium_(software)'
         */


        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.wikipedia.org/");

        WebElement inputBox= driver.findElement(By.xpath("//input[@id='searchInput']"));
        inputBox.sendKeys("selenium webdriver");

        WebElement selectCountry= driver.findElement(By.xpath("//select//option[14]"));
        selectCountry.click();

       driver.findElement(By.xpath("(//button/i)[1]")).click();

       WebElement seleniumArtikel= driver.findElement(By.xpath("//a/span[@class='searchmatch']"));
       seleniumArtikel.click();

       String currentUrl= driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);


    }
}
