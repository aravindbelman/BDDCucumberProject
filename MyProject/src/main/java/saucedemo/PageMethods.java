package saucedemo;

import org.openqa.selenium.WebDriver;

public class PageMethods {
    WebDriver driver;
    PageLocators loc;

    public PageMethods(WebDriver driver) {
        this.driver = driver;
        loc = new PageLocators(driver);  // ✅ driver is now initialized
    }

    public void enterUsername(String username)
    {
        loc.username.sendKeys(username);
    }
    public void enterPassword(String password)
    {
        loc.password.sendKeys(password);
    }
    public void clicklogin()
    {
        loc.loginbutton.click();
    }
}
