package com.eurotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ToolsQALoginPage extends BasePage {


    @FindBy(id = "newUser")
    public WebElement newUserBtn;

    @FindBy(id = "firstname")
    public WebElement firstNameInput;


    @FindBy(id = "lastname")
    public WebElement lastNameInput;


    @FindBy(id = "userName")
    public WebElement userNameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(css = "#g-recaptcha")
    public WebElement imRobotBtn;

    @FindBy(css = "#register")
    public WebElement registerBtn;

    @FindBy(id = "userName")
    public WebElement userNameLoginInput;

    @FindBy(id = "password")
    public WebElement passwordLoginInput;

    @FindBy(id = "login")
    public WebElement loginBtn;


    @FindBy(xpath = "//*[text()='Eurotech']")
    public WebElement verifyUserName;

    @FindBy(xpath = "//div/button[@id='gotoStore']")
    public WebElement goToStoreBtn;
       @FindBy(id = "searchBox")
    public WebElement typeTosearchBtn;





}
