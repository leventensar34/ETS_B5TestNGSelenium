package com.eurotech.test.day02_webdriver_basic;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFactory {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("https://www.facebook.com");

        Thread.sleep(2000);

        driver.close();


        /**
         * Task
         * go to devEX website
         * expected title = DevEX
         * get title and verify that title is devEX
         */

       WebDriver driver2=WebDriverFactory.getDriver("chrome");

        driver2.get("http://eurotech.study/");

        String expectedTitle="devEX";

        String actualTitle=driver2.getTitle();


        if (expectedTitle.equals(actualTitle)){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }


    }
}
