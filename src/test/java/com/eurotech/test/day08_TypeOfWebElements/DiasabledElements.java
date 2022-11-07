package com.eurotech.test.day08_TypeOfWebElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DiasabledElements {

    @Test
    public void test1() throws InterruptedException {

        /*
        What is Disable elements?
        - you can not interact the element
        -you can click
        -you can not write something
         */
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement disableElement= driver.findElement(By.cssSelector("#input-example>input"));

        Assert.assertFalse(disableElement.isEnabled(),"verify that element is not enable or element is disable");

        //if we click enable button it will be interactive

        WebElement enableElement= driver.findElement(By.cssSelector("#input-example>button"));
        enableElement.click();

        Thread.sleep(3000);  // There is a procces and we add wait
        Assert.assertTrue(disableElement.isEnabled(),"verify that  is enable");

        driver.close();


    }
}
