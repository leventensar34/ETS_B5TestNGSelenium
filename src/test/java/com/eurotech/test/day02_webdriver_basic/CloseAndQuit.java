package com.eurotech.test.day02_webdriver_basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit {

    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("http://eurotech.study/");

        Thread.sleep(2000);

        driver.close();  // close current tab


        // giving new browser tab-->// if we  don't it will give Invalid session id Exception

        driver=new ChromeDriver();
        driver.get("https://www.facebook.com");

        Thread.sleep(2000);

        driver.quit(); // close all tab

    }
}
