package saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageLocators {

    WebDriver driver;
    @FindBy(id="user-name")
    public WebElement username;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(id="login-button")
    public WebElement loginbutton;

    public PageLocators(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
}
