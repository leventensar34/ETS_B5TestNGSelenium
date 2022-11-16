package com.eurotech.test.day13_webTables;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.xml.stream.XMLStreamConstants;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Example {



    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();

    }

    @Test
    public void demoqaTableTest() {

        driver.get("https://demoqa.com/webtables");


        List<WebElement> firstHeaders=driver.findElements(By.xpath("(//div[@class='rt-tr'])/div"));
        System.out.println("firstHeaders.size() = " + firstHeaders.size());

        List<WebElement> allElements=driver.findElements(By.xpath("(//div[@class='rt-tbody'])/div[1]"));
        System.out.println("allElements.size() = " + allElements.size());
//
//        String name="";
//        for (int i = 1; i <= firstHeaders.size(); i++) {
//           // firstHeaders.get(i).click();
//            WebElement headers=driver.findElement(By.xpath("(//div[@class='rt-th rt-resizable-header -cursor-pointer'])["+i+"]"));
//            System.out.println("headers.getText() = " + headers.getText());
//            headers.click();
//            WebElement elements=driver.findElement(By.xpath("//div[@class='rt-tbody']//div[text()='"+name+"']");
//            System.out.println("elements.getText() = " + elements.getText());
//
//        }








    }
}
