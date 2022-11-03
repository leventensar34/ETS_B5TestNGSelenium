package com.eurotech.test.day04_basics_locaters;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homework {

    public static void main(String[] args) {

        Faker faker=new Faker();
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://www.browserstack.com/users/sign_up");
        driver.manage().window().maximize();

        WebElement acceptAllBtn = driver.findElement(By.id("accept-cookie-notification"));
        acceptAllBtn.click();

        WebElement inputfFullName= driver.findElement(By.id("user_full_name"));
        inputfFullName.sendKeys(faker.name().fullName());

        WebElement inputBusinessEmail= driver.findElement(By.name("user[email]"));
        inputBusinessEmail.sendKeys(faker.internet().emailAddress());

        WebElement inputPassword= driver.findElement(By.name("user[password]"));
        inputPassword.sendKeys(faker.name().firstName().concat(faker.number().digits(4)));

        driver.findElement(By.id("tnc_checkbox")).click();

        driver.findElement(By.id("user_submit")).click();

        driver.close();

    }
}
