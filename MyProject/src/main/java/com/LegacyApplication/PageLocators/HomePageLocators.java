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
    
    @FindBy(xpath="//header[@id='expandedHeader']/div[1]//a[contains(text(),'Login')]")
    public static WebElement homepagelogin;
    
    @FindBy(id="agencyCodeInputMobile")
    public static WebElement agencyCode;
    
    @FindBy(id="passwordInputMobile")
    public static WebElement agencyPassword;
    
    @FindBy(xpath=".//input[@id='loginSubmitMobile']")
    public static WebElement loginButton;	
    
    @FindBy(xpath=".//*[@id='searchTable']/tbody/tr")
    public static WebElement rowSubmission;
    
    @FindBy(id="contactSelectMobile")
    public static WebElement contactinfo;
    
    @FindBy(id="contactSubmitMobile")
    public static WebElement submitMobile;
    
    @FindBy(xpath="//input[@id='dnn_ctr809_View_tbUsername']")
    public static WebElement adminusername;
    
    @FindBy(xpath="//input[@id='dnn_ctr809_View_tbPassword']")
    public static WebElement adminpassword;
    
    @FindBy(xpath="//a[@id='dnn_ctr809_View_cmdLogin']")
    public static WebElement adminloginbutton;
	
}