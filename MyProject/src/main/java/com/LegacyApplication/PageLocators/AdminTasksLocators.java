package com.LegacyApplication.PageLocators;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.LegacyApplication.TestBase.TestBase;

public class AdminTasksLocators extends TestBase {
	
	public static WebDriver driver;
	public static final Logger log=Logger.getLogger(AdminTasksLocators.class.getName());
	
	//===========================> Agency Information Edit Locators<========================
	
	@FindBy(xpath="//select[@id='SearchField' and @name='SearchField']")
	public static WebElement searchBy_drpdwm;
	
	@FindBy(xpath="//input[@id='SearchValue' and @name='SearchValue']")
	public static WebElement search_field;
	
	@FindBy(xpath="//button[@id='searchBtn']")
	public static WebElement search_btn;

}
