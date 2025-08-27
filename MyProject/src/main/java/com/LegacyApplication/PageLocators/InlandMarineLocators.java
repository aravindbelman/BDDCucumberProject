package com.LegacyApplication.PageLocators;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.LegacyApplication.TestBase.TestBase;

public class InlandMarineLocators extends TestBase {
	
	public static WebDriver driver;
    public static final Logger log=Logger.getLogger(InlandMarineLocators.class.getName());
    
  //....................>Inland Marine Locators<<.............................//
    
    @FindBy(xpath="//a[@class='btn btn-default btn-primary' and normalize-space(text()='Inland Marine')]")
    public static WebElement inland_marine_tab;
    
    @FindBy(xpath="//img[@alt='Victory Inland Marine']")
    public static WebElement inland_marine_link;
    
    @FindBy(xpath="//img[@alt='Inland Marine Special Floater']")
    public static WebElement inland_marine_specialfloater_link;   
    
  //....................>Victory Inland Marine Locators<<.............................//
    
    @FindBy(xpath="//select[@id='Rating_Screen1_SubmissionType']")
    public static WebElement vim_submission_type;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_ApplicantName']")
    public static WebElement vim_applicant_name;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_EffectiveDate']")
    public static WebElement vim_proposed_effectivedate;
    
    @FindBy(xpath="//select[@id='Rating_Screen1_State']")
    public static WebElement vim_state;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_optCreateOwn']")
    public static WebElement vim_createyourown_radio;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_optBasic']")
    public static WebElement vim_optbasic_radio;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_optStandard']")
    public static WebElement vim_optstandard_radio;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_optStandard']")
    public static WebElement vim_officecontents_txtbox;
    
    @FindBy(xpath="//td[@id='Rating_Screen1_td_3_1']")
    public static WebElement vim_officecontents_basic;
    
    @FindBy(xpath="//td[@id='Rating_Screen1_td_3_2']")
    public static WebElement vim_officecontents_standard;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_MiscToolsLimit']")
    public static WebElement vim_mistools_txtbox;
    
    @FindBy(xpath="//td[@id='Rating_Screen1_td_4_1']")
    public static WebElement vim_mistools_basic;
    
    @FindBy(xpath="//td[@id='Rating_Screen1_td_4_2']")
    public static WebElement vim_mistools_standard;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_EquipmentLimit']")
    public static WebElement vim_csequip_txtbox;    
    
    @FindBy(xpath="//td[@id='Rating_Screen1_td_5_1']")
    public static WebElement vim_csequip_basic;
    
    @FindBy(xpath="//td[@id='Rating_Screen1_td_5_2']")
    public static WebElement vim_csequip_standard;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_DataMediaLimit']")
    public static WebElement vim_csdateandmedia_txtbox;
    
    @FindBy(xpath="//td[@id='Rating_Screen1_td_6_1']")
    public static WebElement vim_csdateandtime_basic;
    
    @FindBy(xpath="//td[@id='Rating_Screen1_td_6_2']")
    public static WebElement vim_csdateandtime_standard;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_ExtraExpenseLimit']")
    public static WebElement vim_extraexpense_txtbox;
    
    @FindBy(xpath="//td[@id='Rating_Screen1_td_7_1']")
    public static WebElement vim_extraexpense_basic;
    
    @FindBy(xpath="//td[@id='Rating_Screen1_td_7_2']")
    public static WebElement vim_extraexpense_standard;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_LightToMediumToolsLimit']")
    public static WebElement vim_lighttomediaumtoolslimit;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_HeavyToolsLimit']")
    public static WebElement vim_heavytollslimit;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_InstallationFloaterLimit']")
    public static WebElement vim_installationfloaterlimit;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_ItemLimit']")
    public static WebElement vim_rentedorleasedequip_chkbx;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_btnRateIT']")
    public static WebElement vim_rateitnow_btn;
    
    //....................>Victory Inland Marine Special Floater Locators<<.............................//
    
    @FindBy(xpath="//input[@id='Rating_Screen1_ApplicantName']")
    public static WebElement vimsf_named_insured;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_DBA']")
    public static WebElement vimsf_dba;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_EffectiveDate']")
    public static WebElement vimsf_proposed_effectivedate;
    
    @FindBy(xpath="//select[@id='Rating_Screen1_StateId']")
    public static WebElement vimsf_state_drpdwn;
    
    //....................>Special Floater Rating Information Locators<<.............................//
    
    @FindBy(xpath="//select[@id='Rating_Screen1_Classification1']")
    public static WebElement vimsf_property_classification1;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_Payroll1']")
    public static WebElement vimsf_limits_payroll1;
    
    @FindBy(xpath="//textarea[@id='Rating_Screen1_DescriptionOperations']")
    public static WebElement vimsf_descriptionofoperations;
}
