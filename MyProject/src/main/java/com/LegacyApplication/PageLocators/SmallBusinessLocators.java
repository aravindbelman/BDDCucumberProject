package com.LegacyApplication.PageLocators;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.LegacyApplication.TestBase.TestBase;

public class SmallBusinessLocators extends TestBase {
	
	public static WebDriver driver;
    public static final Logger log=Logger.getLogger(SmallBusinessLocators.class.getName());
    
  //....................>>Small Business Locators<<.............................//
    
    @FindBy(xpath="//a[@class='btn btn-default btn-primary' and normalize-space(text())='Small Business']")
    public static WebElement small_business_link;
    
  //....................>>Hiscox Now Small Business Locators<<.............................//
    
    @FindBy(xpath="//img[@alt='Hiscox NOW']")
    public static WebElement hnsb_link;
    
    @FindBy(xpath="//input[@name='agentName' and @placeholder='First and Last Name']")
    public static WebElement hnsb_agent_name;
    
    @FindBy(xpath="//input[@name= 'agencyName' and @placeholder='Agency Name']")
    public static WebElement hnsb_agency_name;
    
    @FindBy(xpath="//input[@name='agentId' and @placeholder='Agent ID']")
    public static WebElement hnsb_agentid;
    
    @FindBy(xpath="//input[@name='agentEmail' and @placeholder='Email Address']")
    public static WebElement hnsb_agentemail;
    
    @FindBy(xpath="//input[@name='businessName']")
    public static WebElement hnsb_businessname;
    
    @FindBy(xpath="//span[@id='select2-state-mx-container']")
    public static WebElement hnsb_state_drpdwn;
    
    @FindBy(xpath="//span[@id='select2-cob-o4-container']")
    public static WebElement hnsb_profession_drpdwn;
    
    @FindBy(xpath="//a[@class='button button--primary button--large quote-box__button--get-quote']")
    public static WebElement hnsb_getaquote_btn;
    
    @FindBy(xpath="//a[@class='quote-box__button--retrieve-quote']")
    public static WebElement hnsb_retrieve_a_quote_link;
    
  //....................>>CNA BOP Rater Locators<<.............................//
    
    @FindBy(xpath="//img[@alt='BOP Rater']")
    public static WebElement cnac_bop_rater_link;
    
  //....................>>CNAC agency information and Eligibility locators<<.............................//
    
    @FindBy(xpath="//input[@id='AGENCY_CONTACT_NM']")
    public static WebElement cnac_agent_name;
    
    @FindBy(xpath="//input[@id='AGENCY_EMAIL']")
    public static WebElement cnac_agent_email;
    
    @FindBy(xpath="//input[@id='AGENCY_PHONE']")
    public static WebElement cnac_agent_phone;
    
    @FindBy(xpath="//input[@id='AGENCY_CODE']")
    public static WebElement cnac_agent_code;
    
    @FindBy(xpath="//select[@id='industry']")
    public static WebElement cnac_industry_drpdwn;
    
    @FindBy(xpath="//input[@id='occupation']")
    public static WebElement cnac_classification_drpdwn;
    
  //....................>>CNAC business and premise information locators<<.............................//
    
    @FindBy(xpath="//input[@id='COVERAGE_START_DT']")
    public static WebElement cnac_coverage_startdate;
    
    @FindBy(xpath="//input[@id='BUSINESS_NAME']")
    public static WebElement cnac_business_name;
    
    @FindBy(xpath="//select[@id='LEGAL_ENTITY']")
    public static WebElement cnac_legal_entity_drpdwn;
    
    @FindBy(xpath="//input[@id='ADDRESS']")
    public static WebElement cnac_address;
    
    @FindBy(xpath="//input[@id='ZIP']")
    public static WebElement cnac_zipcode;
    
    @FindBy(xpath="//input[@id='CITY']")
    public static WebElement cnac_city;
    
    @FindBy(xpath="//select[@id='STATE']")
    public static WebElement cnac_state_drpdwn;
    
    @FindBy(xpath="//input[@id='YEARS_IN_BUSS']")
    public static WebElement cnac_yearsinbusiness;
    
    @FindBy(xpath="//input[@id='TOTAL_SALES']")
    public static WebElement cnac_total_sales;
    
    @FindBy(xpath="//input[@id='FULL_TIME_EMPLOYEES']")
    public static WebElement cnac_fulltime_emp;
    
    @FindBy(xpath="//input[@id='PART_TIME_EMPLOYEES']")
    public static WebElement cnac_parttime_emp;
    
    @FindBy(xpath="//input[@id='PHONE']")
    public static WebElement cnac_phone;
    
    @FindBy(xpath="//input[@id='C10-99-COVERAGE_SELECTED']")
    public static WebElement cnac_buildinglimit_chkbx;
    
    @FindBy(xpath="//input[@id='C20-99-COVERAGE_SELECTED']")
    public static WebElement cnac_contentlimit_chkbx;
    
    @FindBy(xpath="//input[@id='SPRINKLED']")
    public static WebElement cnac_sprinklered_chkbx;
    
    @FindBy(xpath="//input[@id='NUM_STORIES']")
    public static WebElement num_of_stories_chkbx;
    
    @FindBy(xpath="//input[@id='YEAR_BUILT']")
    public static WebElement year_built;
    
    @FindBy(xpath="//input[@id='SQUARE_FEET']")
    public static WebElement square_footage;
    
    @FindBy(xpath="//select[@id='CONSTRUCTION']")
    public static WebElement construction_drpdwn;
    
    @FindBy(xpath="//a[@id='mssubmit']/img")
    public static WebElement submit_btn;
}
