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

    //if u need --> create a new Class named PostsPage and write the web element in to the that page
    @FindBy(css = "#post-form-btn")
    public WebElement submitBtn_loc;

    @FindBy(css = "#loginpage-h1")
    public WebElement signText;

    @FindBy(css = "#dashboard-experience-h1")
    public WebElement credentialMessage;


    public void navigateToMenu(String menuName) {
        Driver.get().findElement(By.xpath("//*[text()='" + menuName + "']")).click();

    }

    public void navigateToSubMenu(String subMenu) {
        Driver.get().findElement(By.xpath("//span[text()='" + subMenu + "']")).click();


    }

    public void navigateAll(String tab, String modul) {
        Driver.get().findElement(By.xpath("//*[text()='" + tab + "']")).click();
        Driver.get().findElement(By.xpath("//span[text()='" + modul + "']")).click();

    }

    public String getCompany_mtd(String companyName){
        return Driver.get().findElement(By.xpath("//td[text()='"+companyName+"']")).getText();
    }

}
