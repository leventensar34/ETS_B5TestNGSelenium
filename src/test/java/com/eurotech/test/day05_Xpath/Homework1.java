package com.eurotech.test.day05_Xpath;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homework1 {

    public static void main(String[] args) throws InterruptedException {

        /*

      HW-1
    Locator XPATH PRACTICES
    DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
    1.Open Chrome browser
    2. Go to https://the-internet.herokuapp.com/forgot_password Links to an
    external site.
    3. Locate all the WebElements on the page using XPATH locator only
      a. “Forgot password” header
      b. “E-mail” text
      c. E-mail input box
      d. “Retrieve password” button
    4.Print text of a,b,d and put some email to c
                */
        Faker faker=new Faker();
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://the-internet.herokuapp.com/forgot_password");

        WebElement textForgotPassword= driver.findElement(By.tagName("h2"));
        System.out.println("textForgotPassword.getText() = " + textForgotPassword.getText());

        WebElement emailText= driver.findElement(By.xpath("//label[@for='email']"));
        System.out.println("emailText.getText() = " + emailText.getText());

        WebElement emailButton= driver.findElement(By.xpath("//input[@type='text']"));
        emailButton.sendKeys(faker.internet().emailAddress());

        WebElement passwordRetrieveButton= driver.findElement(By.xpath("//button/i"));
        System.out.println("passwordRetrieveButton.getText() = " + passwordRetrieveButton.getText());

        Thread.sleep(3000);
        passwordRetrieveButton.click();


    }

}
