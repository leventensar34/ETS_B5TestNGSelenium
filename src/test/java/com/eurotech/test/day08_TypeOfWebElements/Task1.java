package com.eurotech.test.day08_TypeOfWebElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task1 {

    @Test
    public void test1() {


        // Class Task
        // complete the task
        // click all the checkbox
        // than assert that is selected or not


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/automation-practice-form");

        WebElement sports = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']"));

        WebElement reading = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']"));

        WebElement music = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-3']"));


        sports.click();
        System.out.println("sports.isSelected() = " + sports.isSelected());
        Assert.assertFalse(sports.isSelected()); // assert: false, condition: false, test: PASS

        reading.click();
        System.out.println("reading.isSelected() = " + reading.isSelected());
        Assert.assertFalse(reading.isSelected()); // assert: false, condition: false, test: PASS

        music.click();
        System.out.println("music.isSelected() = " + music.isSelected());
        Assert.assertFalse(music.isSelected()); // assert: false, condition: false, test: PASS

        driver.close();

    }
}
