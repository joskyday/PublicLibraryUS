package com.PubLibrary.pages;

import com.PubLibrary.utilities.BrowserUtils;
import com.PubLibrary.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {


    @FindBy(xpath = "//*[@id='menu_item']/li[1]")
    public WebElement dashboardButton;

    @FindBy(xpath = "//*[@id='menu_item']/li[2]")
    public WebElement usersButton;

    @FindBy(xpath = "//*[@id='menu_item']/li[3]")
    public WebElement librarianBooksButton;

    @FindBy(xpath = "//*[@id='menu_item']/li[1]")
    public WebElement studentBooksButton;

    @FindBy(xpath = "//*[@id='menu_item']/li[2]")
    public WebElement borrowingBooksButton;


    @FindBy(xpath = "//span[contains(.,'Test')]")
    public WebElement userName;

    @FindBy(css =".dropdown-item")
    public WebElement logOutLink;

    @FindBy(xpath = "/html/body/header/nav/div/ul[2]/li/a")
    public WebElement usernameButton;

    @FindBy(xpath = "/html/body/header/nav/div/ul[2]/li/div/a")
    public WebElement logoutButton;

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }


    public String getUserName(){
        BrowserUtils.waitForVisibility(userName, 5);
        return userName.getText();
    }


    public void logOut(){
        BrowserUtils.waitFor(1);
        BrowserUtils.clickWithJS(userName);
        BrowserUtils.clickWithJS(logOutLink);
    }


}