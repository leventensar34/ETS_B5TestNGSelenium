package com.eurotech.test.day01_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenBrowser {

    public static void main(String[] args) {


       //  We have to enter this line every time we want to open chrome/safari/firefox...

       //  Not: Chrome browser la giris....

        WebDriverManager.chromedriver().setup(); //--> chrome kurulumu

        //  WebDriver represent the browser
       //  we are creating driver for chrome browser

        WebDriver driver=new ChromeDriver(); //Polymorphism  //--> this part will open chrome browser
        driver.get("https://www.eurotechstudy.com");


        // Not: FireFox la giris...
//
//        WebDriverManager.firefoxdriver().setup();
//        WebDriver driver=new FirefoxDriver();
//        driver.get("https://www.eurotechstudy.com");

    }
}
