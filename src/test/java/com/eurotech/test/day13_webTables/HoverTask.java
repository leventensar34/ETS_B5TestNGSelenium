package com.eurotech.test.day13_webTables;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HoverTask {

    /*
         // class Task
                go to https://the-internet.herokuapp.com/hovers url
                and get "view profile" elements' text (all of them)
                and verify element is displayed (one by one)

                hind: Use list and for loop
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        // WebDriverWait wait= new WebDriverWait(driver,15);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();

    }

    @Test
    public void hoverTask1() {
        // 1. way
        driver.get("https://the-internet.herokuapp.com/hovers");

        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='figure']"));

        Actions actions = new Actions(driver);

        for (WebElement element1 : elements) {

            actions.moveToElement(element1).perform();
            System.out.println("element1.getText() = " + element1.getText());

            WebElement viewProfile = driver.findElement(By.linkText("View profile"));
            Assert.assertTrue(viewProfile.isDisplayed(), "verify that element is Displayed!");
        }

    }

    @Test
    public void hoverTask2() throws InterruptedException {
        // 2.way
        driver.get("https://the-internet.herokuapp.com/hovers");

        driver.findElement(By.xpath("(//img)[2]"));

        List<WebElement> imgList = driver.findElements(By.tagName("img"));

        // img size=4

        for (int i = 2; i <= imgList.size(); i++) {

            String imgXpath = "(//img)[" + i + "]";
            System.out.println("imgXpath = " + imgXpath);

            WebElement img = driver.findElement(By.xpath(imgXpath));

            Actions actions = new Actions(driver);
            Thread.sleep(1000);
            actions.moveToElement(img).perform();

            String textPath = "//h5[text()='name: user" + (i - 1) + "']";

            // if I use --> //h5[text()='name: user1']==> user1
            // if I use --> //h5[text()='name: user2']==> user2

            WebElement text = driver.findElement(By.xpath(textPath));

            System.out.println("textPath = " + textPath);

            Assert.assertTrue(text.isDisplayed(), "Verify that user " + (i - 1) + " is displayed");

            System.out.println("Verify that user " + (i - 1) + " is displayed");


        }


    }
}
