package com.eurotech.pages;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DashboardPage extends BasePage {


    @FindBy(xpath = "//p[text()=' Welcome']")
    public WebElement welcomeMessage_loc;

    @FindBy(xpath = "//a[text()='All Posts']")
    public WebElement allPosts_loc;

    @FindBy(xpath = "//a[text()='Developers']")
    public WebElement developers_loc;

    @FindBy(xpath = "//*[text()='My Account']")
    public WebElement myAccount_loc;

    @FindBy(css = ".nav__menu-item")
    public List<WebElement> menuList_loc;

    public void navigateToMenu(String menuName){
        Driver.get().findElement(By.xpath("//*[text()='"+menuName+"']")).click();
    }



}
