package com.eurotech.test.day04_basics_locaters;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Task {
    public static void main(String[] args) {



        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://the-internet.herokuapp.com/inputs");

        System.out.println("driver.findElement(By.tagName(\"h3\")).getText() = " + driver.findElement(By.tagName("h3")).getText());
        System.out.println("driver.findElement(By.tagName(\"p\")).getText() = " + driver.findElement(By.tagName("p")).getText());


    }
}
