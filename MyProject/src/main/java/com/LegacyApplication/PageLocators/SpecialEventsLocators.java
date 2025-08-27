package com.LegacyApplication.PageLocators;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.LegacyApplication.TestBase.TestBase;

public class SpecialEventsLocators extends TestBase {
	
	public static WebDriver driver;
    public static final Logger log=Logger.getLogger(BuildersRiskLocators.class.getName());
    
    //....................>Special Events Locators<<.............................//
    
    @FindBy(xpath="//a[@class='btn btn-default btn-primary' and normalize-space(text()='Special Events')]")
    public static WebElement special_events_tab;
    
    @FindBy(xpath="//img[@alt='Event Helper']")
    public static WebElement special_events_link;
    
    @FindBy(xpath="(//button[@class='btn btn-primary btn-sm' and text()='Get a Quote'])[position()=1]")
    public static WebElement special_event_pgm_quote;

}
