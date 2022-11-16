package com.eurotech.test.day14_propertiesSingleton;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {

    @Test
    public void test1() {

        //  Singleton singleton=new Singleton();

        String driver1 = Singleton.getInstance();

        String driver2 = Singleton.getInstance();

        System.out.println("driver1= " + driver1);
        System.out.println("driver2 = " + driver2);

    }

    @Test
    public void test2() {

      // WebDriver driver= WebDriverFactory.getDriver("chrome");

       WebDriver driver=Driver.get();
       driver.get(ConfigurationReader.get("url"));


    }

    @Test
    public void test3() {

       // WebDriver driver= WebDriverFactory.getDriver("chrome");

        WebDriver driver=Driver.get();
        driver.get("https://www.amazon.co.uk/");

      //  Driver.get().get("https://www.amazon.co.uk/"); // Bu sekilde de yailabilir.

        Driver.closeDriver();


    }

    @Test
    public void test4() {

       // WebDriver driver= WebDriverFactory.getDriver("chrome");

        WebDriver driver=Driver.get();
        driver.get("http://eurotech.study/login");


    }
}
