package com.LegacyApplication.PageLocators;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.LegacyApplication.TestBase.TestBase;

public class BondsLocators extends TestBase {
	
	public static WebDriver driver;
    public static final Logger log=Logger.getLogger(BondsLocators.class.getName());
    
  //....................>>Bonds Product Locators<<.............................//
    
    @FindBy(xpath="//img[@alt='Victory Contractor Bonds']")
    public static WebElement vcb_link;
    
    @FindBy(xpath="//img[@alt='Victory Xpress Bonds']")
    public static WebElement victory_xpress_bondlink;
    
  //....................>>Victory Contractor Bond Locators<<.............................//
  //....................>>VCB Bond Information Locators<<.............................//
    
    @FindBy(xpath="//select[@id='BondInfo_StateId']")
    public static WebElement vcb_state_drpdwn;
    
    @FindBy(xpath="//input[@id='EffectiveDate_Value']")
    public static WebElement vcb_effective_date;
    
  //....................>>VCB Company Information Locators<<.............................//
    
    @FindBy(xpath="//input[@id='CompanyInfo_DBA']")
    public static WebElement vcb_company_name;
    
    @FindBy(xpath="//select[@id='CompanyInfo_BusinessTypeId']")
    public static WebElement vcb_company_type;
    
    @FindBy(xpath="//input[@id='CompanyInfo_BusinessName']")
    public static WebElement vcb_dba;
    
    @FindBy(xpath="//input[@id='CompanyInfo_BusinessAddress']")
    public static WebElement vcb_business_address;
    
    @FindBy(xpath="//input[@id='CompanyInfo_BusinessCity']")
    public static WebElement vcb_busienss_city;
    
    @FindBy(xpath="//select[@id='CompanyInfo_BusinessStateId']")
    public static WebElement vcb_state;
    
    @FindBy(xpath="//input[@id='CompanyInfo_BusinessPostalCode']")
    public static WebElement vcb_zipcode;
    
    @FindBy(xpath="//input[@id='CompanyInfo_BusinessPhone']")
    public static WebElement vcb_business_phone;
    
    @FindBy(xpath="//input[@id='CompanyInfo_BusinessFax']")
    public static WebElement vcb_business_fax;
    
    @FindBy(xpath="//input[@id='CompanyInfo_Email']")
    public static WebElement vcb_email;
    
   //....................>>VCB personal Indemnitor Locators<<.............................//
    
    @FindBy(xpath="//input[@id='CreditCheckInfo_FirstName']")
    public static WebElement vcb_pi_firstname;
    
    @FindBy(xpath="//input[@id='CreditCheckInfo_MiddleName']")
    public static WebElement vcb_pi_middlename;
    
    @FindBy(xpath="//input[@id='CreditCheckInfo_LastName']")
    public static WebElement vcb_pi_lastname;
    
    @FindBy(xpath="//select[@id='CreditCheckInfo_Suffix']")
    public static WebElement vcb_suffix_drpdwn;
    
    @FindBy(xpath="//input[@id='chkSameAddress']")
    public static WebElement vcb_sameaddress_chkbx;
    
    @FindBy(xpath="//input[@id='CreditCheckInfo_Address']")
    public static WebElement vcb_pi_homeaddress;
    
    @FindBy(xpath="//input[@id='CreditCheckInfo_City']")
    public static WebElement vcb_pi_homecity;
    
    @FindBy(xpath="//select[@id='CreditCheckInfo_State']")
    public static WebElement vcb_pi_homestate;
    
    @FindBy(xpath="//input[@id='CreditCheckInfo_ZipCode']")
    public static WebElement vcb_pi_homezip;
    
    @FindBy(xpath="//input[@id='CreditCheckInfo_SSN']")
    public static WebElement vcb_si_ssnnumber;
    
    @FindBy(xpath="//input[@id='CreditCheckInfo_ConfirmSSN']")
    public static WebElement vcb_si_confirmssn;
    
    @FindBy(xpath="//input[@id='CreditCheckInfo_CreditCheckOK']")
    public static WebElement vcb_creditcheck_chkbox;
    
    @FindBy(xpath="//input[@id='btnRateItNow']")
    public static WebElement vcb_rateitnow_btn;
    
}
