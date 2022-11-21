package com.eurotech.pages;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends BasePage {


    @FindBy(id = "loginpage-input-email")
    public WebElement usernameInput_loc;

    @FindBy(name = "password")
    public WebElement passwordInput_loc;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement loginBtn_loc;

    @FindBy(xpath = "//*[.='Invalid Credentials!'")
    public WebElement errorMessage_loc;

    @FindBy(css = ".menu-list")
    public List<WebElement> menuList_loc;


    public void login_Mtd(String username, String password) {

        usernameInput_loc.sendKeys(username);
        passwordInput_loc.sendKeys(password);
        loginBtn_loc.click();

    }

    public void loginAsTeacher_Mtd() {
        String username=ConfigurationReader.get("usernameTeacher");
        String password=ConfigurationReader.get("passwordTeacher");

        usernameInput_loc.sendKeys(username);
        passwordInput_loc.sendKeys(password);
        understandBtn_Loc.click();
        loginBtn_loc.click();


    }

    public void loginAsStudent_Mtd() {
        usernameInput_loc.sendKeys(ConfigurationReader.get("usernameStudent"));
        passwordInput_loc.sendKeys(ConfigurationReader.get("passwordStudent"));
        loginBtn_loc.click();
    }

    /*
    these are change with devEx web site
     */


    @FindBy(id = "user-name")
    public WebElement usernameInput;

    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(id = "login-button")
    public WebElement loginBtn;

    @FindBy(xpath = "//form/div[3]/h3")
    public WebElement errorMessage;

    @FindBy(id = "rcc-confirm-button")
    public WebElement understand;

    @FindBy(xpath = "//span[text()='Products']")
    public WebElement productsText;

    @FindBy(xpath = "//form/div")
    public List<WebElement> listElements;

    // FindAll--> or yani "veya" demektiir
    @FindAll({
            @FindBy(id = "user-name"),
            @FindBy(id = "user-name")
    })
    public WebElement getUsernameInput;


    // FindBys--> and yani "ve" demektir
    @FindBys({
            @FindBy(id = "user-name"),
            @FindBy(id = "user-name")
    })
    public WebElement getPasswordInput;


    public void login() {
        usernameInput.sendKeys(ConfigurationReader.get("userswag"));
        passwordInput.sendKeys(ConfigurationReader.get("passwordswag"));
        loginBtn.click();
    }

    public void loginAsPerform() {
        usernameInput.sendKeys(ConfigurationReader.get("userPerform"));
        passwordInput.sendKeys(ConfigurationReader.get("passwordswag"));
        loginBtn.click();

    }

    public void loginAsProblem() {

        String username = ConfigurationReader.get("userProblem");
        String password = ConfigurationReader.get("passwordswag");
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }
}
