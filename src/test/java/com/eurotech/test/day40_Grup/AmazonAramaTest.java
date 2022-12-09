package com.eurotech.test.day40_Grup;

import com.eurotech.pages.AmazonPage;
import com.eurotech.test.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonAramaTest extends TestBase {

    AmazonPage page = new AmazonPage();

    @Test
    public void amazonSearch() {

        page.changeAddressBtn.click();
        Select select = new Select(page.kategoriList);
        select.selectByVisibleText("Automotive");

        page.searchBox.sendKeys("car phone holder" + Keys.ENTER);

        try {
            for (WebElement e : page.tumUrunler) {
                WebElement fiyat = e.findElement(By.className("a-price-whole"));
                System.out.println("fiyat.getText() = " + fiyat.getText());
            }
        } catch (Exception e) {

        }

    }

    @Test
    public void allTabTest() {

        page.changeAddressBtn.click();
        page.navigateAllMenu2("Amazon Music","Podcasts");

        WebElement actualMessage= driver.findElement(By.xpath("(//div/span[@class='macro'])[1]"));
        Assert.assertEquals(actualMessage.getText(),"Want access to top ad-free podcasts and 100 million songs? Try Amazon Music Unlimited");

    }

}
