package com.eurotech.test.day02_webdriver_basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {

    public static void main(String[] args) throws InterruptedException {

        // Go to google
        // Go to facebook
        // Turn back
        // You should see google again

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com");

        // wait 2 second here and then move on
        Thread.sleep(2000);

        // navigate(); to another website with different selenium method
        driver.navigate().to("https://www.facebook.com");

        Thread.sleep(2000);

        // goes back previous page
       driver.navigate().back();

       Thread.sleep(2000);

       // goes back to back

        driver.navigate().forward();

        Thread.sleep(2000);

        // refresh to webpage

        driver.navigate().refresh();

    }
}
