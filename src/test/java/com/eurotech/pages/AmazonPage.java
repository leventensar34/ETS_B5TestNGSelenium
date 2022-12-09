package com.eurotech.pages;

import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class AmazonPage extends BasePage {


    @FindBy(xpath = "(//*[@class='a-button-input'])[1]")
    public WebElement changeAddressBtn;

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(id = "searchDropdownBox")
    public WebElement kategoriList;

    @FindBy(className = "a-price-whole")
    public List<WebElement> tumFiyatlar;

    @FindBy(css = "[data-component-type='s-search-result']")
    public List<WebElement> tumUrunler;



    public void navigateAllMenu2(String tab,String module){
        Driver.get().findElement(By.xpath("(//*[.='All'])[2]")).click();
        BrowserUtils.waitFor(1);
        Driver.get().findElement(By.xpath("//div[text()='"+tab+"']")).click();
        BrowserUtils.waitFor(1);
        Driver.get().findElement(By.xpath("//a[text()='"+module+"']")).click();
    }
}
