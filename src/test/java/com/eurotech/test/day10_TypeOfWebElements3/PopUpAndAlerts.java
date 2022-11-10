package com.eurotech.test.day10_TypeOfWebElements3;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopUpAndAlerts {


    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        driver.close();
    }


    @Test
    public void test1() throws InterruptedException {

        // HTML yöntemi ile cözülen alertler

        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=b656a");

        //
        driver.findElement(By.xpath("(//span[text()='Confirm'])[1]")).click();

        // click Yes
        driver.findElement(By.xpath("(//span[text()='Yes'])[2]")).click();

        Thread.sleep(2000);

        //verify that confirm is accepted
        String expectedMesssage = "You have accepted";
        WebElement actualMessage = driver.findElement(By.xpath("//p[text()='You have accepted']"));

        Assert.assertEquals(actualMessage.getText(), expectedMesssage);


    }

    @Test
    public void jsAlerts() throws InterruptedException {

        //Alert sinifindan metodlarla cözulen alertler.

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        Thread.sleep(2000);

        // click--> Click for JS Alert Button

        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        //e.g: 1 switch to JS alert popUp

        // driver.switchTo().alert().accept();

        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);

        // click OK
        alert.accept();

        //e.g: 2 click For JS Confirm

        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

        Thread.sleep(2000);

        // click to cancel
        driver.switchTo().alert().dismiss();


        //e.g: 3 Click--> Click For JS Prompt

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

        driver.switchTo().alert().sendKeys("Eurotech Batch 5");
        Thread.sleep(4000);

        System.out.println("driver.switchTo().alert().getText() = " + driver.switchTo().alert().getText());

        driver.switchTo().alert().accept();
        Thread.sleep(2000);


    }
}
