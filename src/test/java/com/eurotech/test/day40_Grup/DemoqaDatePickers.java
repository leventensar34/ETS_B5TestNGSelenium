package com.eurotech.test.day40_Grup;

import com.eurotech.test.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class DemoqaDatePickers extends TestBase {


    @Test
    public void datePickers() {

        driver.findElement(By.cssSelector("#datePickerMonthYearInput")).click();

        WebElement monthElement=driver.findElement(By.cssSelector(".react-datepicker__month-select"));

        Select select=new Select(monthElement);
        select.selectByIndex(0);

        WebElement yearElement=driver.findElement(By.cssSelector(".react-datepicker__year-select"));

        select=new Select(yearElement);
        select.selectByVisibleText("1994");

        List<WebElement> dayElement=driver.findElements(By.cssSelector("div.react-datepicker__day"));

        for (WebElement element : dayElement) {

            String text=element.getText();

            if (text.equals("6")){
                element.click();
                break;
            }

        }

    }
}
