package com.eurotech.test.day10_TypeOfWebElements3;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeTest {


    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        // driver.close();
         driver.quit();
    }

    @Test
    public void iframe() {
        driver.get("https://the-internet.herokuapp.com/iframe");

        // How to switch the Iframe

        //First way : using name or ID
        driver.switchTo().frame("mce_0_ifr");

        WebElement textArea = driver.findElement(By.cssSelector("#tinymce"));
        textArea.clear();
        textArea.sendKeys("Eurotech Batch 5 was here");


        driver.switchTo().parentFrame();
        //***** Second way : switching index


        driver.switchTo().frame(0);
        textArea.clear();
        textArea.sendKeys("Eurotech Batch 5 was here");

        driver.switchTo().parentFrame();
        //**** Third way: using web element

        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        textArea.clear();
        textArea.sendKeys("This is third way");


    }

    @Test
    public void nestedIframe() {

        driver.get("https://the-internet.herokuapp.com/nested_frames");

        //switch to middle frame and get middle text
        driver.switchTo().frame("frame-top");

        driver.switchTo().frame("frame-middle");

        System.out.println("driver.findElement(By.cssSelector(\"#content\")).getText() = " + driver.findElement(By.cssSelector("#content")).getText());

        // go to Right frame and get text

        // driver.switchTo().defaultContent(); // Bu metot otomotik en basa alir.

        driver.switchTo().parentFrame();
        driver.switchTo().frame(2);

        System.out.println("driver.findElement(By.tagName(\"body\")).getText() = " + driver.findElement(By.tagName("body")).getText());


        // go to left frame and get text
        driver.switchTo().parentFrame();
        driver.switchTo().frame(0);
        System.out.println("driver.findElement(By.name(\"frame-left\")).getText() = " + driver.findElement(By.tagName("body")).getText());


        // go to bottom frame and get text
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-bottom");
        System.out.println("driver.findElement(By.tagName(\"body\")).getText() = " + driver.findElement(By.tagName("body")).getText());


    }
}
