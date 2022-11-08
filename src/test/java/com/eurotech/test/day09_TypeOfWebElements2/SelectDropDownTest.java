package com.eurotech.test.day09_TypeOfWebElements2;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropDownTest {


    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://demoqa.com/select-menu");

        //1 locate your dropdown just like any other web element with unique locator
        // which has "select"
        WebElement colorDropDown = driver.findElement(By.cssSelector("#oldSelectMenu"));

        //2 create select object by passing that elements as a constructor
        Select color = new Select(colorDropDown);

        //3 getOption()--> return all available option from the dropdown
        List<WebElement> colorList = color.getOptions();

        //4 print size of the option
        System.out.println("colorList.size() = " + colorList.size());

        // verify that size is 11
        Assert.assertEquals(colorList.size(),11);

        //5 print option one by one
        for (WebElement element : colorList) {
            System.out.println("element.getText() = " + element.getText());
        }

        // verify that default color is red-->

        String expectedColor="Red";
        String actualColor=color.getFirstSelectedOption().getText();

        Assert.assertEquals(actualColor,expectedColor,"verify that default color is red");

        //****How to select option from dropdown?

        //1.select using  visible  text-->
        Thread.sleep(3000);
        color.selectByVisibleText("Yellow");

        expectedColor="Yellow";
        actualColor=color.getFirstSelectedOption().getText();

        Assert.assertEquals(actualColor,expectedColor);

        //2. Select using INDEX
        Thread.sleep(3000);
        color.selectByIndex(0);
        expectedColor="Red";
        actualColor=color.getFirstSelectedOption().getText();

        System.out.println("actualColor = " + actualColor);
        Assert.assertEquals(actualColor,expectedColor);

        //3. Select using value-->
        Thread.sleep(3000);
        color.selectByValue("7");
        expectedColor="Voilet";
        actualColor=color.getFirstSelectedOption().getText();
        System.out.println("actualColor = " + actualColor);

        Assert.assertEquals(actualColor,expectedColor);


        //**** How can we click each of element? --> with  click(); method
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
