package com.LegacyApplication.PageLocators;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.LegacyApplication.TestBase.TestBase;


public class HomePageLocators extends TestBase {
	
	public static WebDriver driver;
	
    public static final Logger log=Logger.getLogger(HomePageLocators.class.getName());
    
    //....................>>Home Page Locators<<.............................//
   
    @FindBy(xpath="//form[@id='Form']//a[@href='/m-login' and text()='Login']")
    public static WebElement homepagelogin;
    
    @FindBy(xpath="//a[@class='text-white']/child::small[contains(text(),'Log in ')]")
    public static WebElement homepagelogin2;
    
    @FindBy(xpath="//a[@class='logoutButton' and text()='Logout']")
    public static WebElement homepageLogout;
    
/*    @FindBy(xpath="//header[@id='expandedHeader']/div[1]//a[contains(text(),'Login')]")
    public static WebElement homepagelogin;*/
   
    @FindBy(id="agencyCodeInputMobile")
    public static WebElement agencyCode;
    
    @FindBy(id="passwordInputMobile")
    public static WebElement agencyPassword;
    
    @FindBy(xpath="//input[@id='loginSubmitMobile']")
    public static WebElement loginButton;	
    
    @FindBy(xpath="//*[@id='searchTable']/tbody/tr")
    public static WebElement rowSubmission;
    
    @FindBy(xpath="//select[@id='contactSelectMobile']")
    public static WebElement contactinfo;
    
    @FindBy(xpath="//input[@id='contactSubmitMobile']")
    public static WebElement submitMobile;
    
    @FindBy(xpath="//input[@id='dnn_ctr809_View_tbUsername']")
    public static WebElement adminusername;
    
    @FindBy(xpath="//input[@id='dnn_ctr809_View_tbPassword']")
    public static WebElement adminpassword;
    
    @FindBy(xpath="//a[@id='dnn_ctr809_View_cmdLogin']")
    public static WebElement adminloginbutton;
	
}