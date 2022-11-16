package com.eurotech.test.day14_propertiesSingleton;

import com.eurotech.test.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {


    @Test
    public void test() throws InterruptedException {


        driver.get(ConfigurationReader.get("url"));
        driver.findElement(By.id("loginpage-input-email")).sendKeys(ConfigurationReader.get("usernameTeacher"));
        driver.findElement(By.id("loginpage-form-pw-input")).sendKeys(ConfigurationReader.get("passwordTeacher")+ Keys.ENTER);

        Thread.sleep(2000);
    }
}
