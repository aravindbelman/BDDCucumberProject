package com.LegacyApplication.PageLocators;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.LegacyApplication.TestBase.TestBase;

public class ExcessRaterLocators extends TestBase {
	
	public static WebDriver driver;
    public static final Logger log=Logger.getLogger(ExcessRaterLocators.class.getName());
    
//....................>>Excess Rater Locators<<.............................//
    
    @FindBy(xpath="//a[@class='btn btn-default btn-primary' and normalize-space(text())='Excess']")
    public static WebElement excess_tab;
    
    @FindBy(xpath="//img[@alt='Excess Rater']")
    public static WebElement excess_rater_link;
    
    @FindBy(xpath="//select[@id='Rating_Screen1_SubmissionTypeId']")
    public static WebElement er_submission_type;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_ApplicantName']")
    public static WebElement er_applicant_name;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_Dba']")
    public static WebElement er_dba_name;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_EffectiveDate']")
    public static WebElement er_proposed_eff_date;
    
    @FindBy(xpath="//select[@id='Rating_Screen1_StateId']")
    public static WebElement er_state;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_ZipCode']")
    public static WebElement er_zipcode;
    
    @FindBy(xpath="//select[@id='Rating_Screen1_ClassificationTypeId']")
    public static WebElement er_class_type;
    
    @FindBy(xpath="//select[@id='Rating_Screen1_ContractorClassId']")
    public static WebElement er_classification_type;
    
    @FindBy(xpath="//select[@id='Rating_Screen1_ExcessCoverageLimit']")
    public static WebElement er_excess_coverage_limit;
    
    @FindBy(xpath="//select[@id='Rating_Screen1_ExcessCoverageOver']")
    public static WebElement er_excess_coverage_over;
    
    @FindBy(xpath="//select[@id='Rating_Screen1_UnderlyingGllimits']")
    public static WebElement er_underLying_gl_limits;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_UnderlyingGlpremium']")
    public static WebElement er_underLying_gl_premium;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_btnRateIT']")
    public static WebElement er_rateitnow_btn;

}
