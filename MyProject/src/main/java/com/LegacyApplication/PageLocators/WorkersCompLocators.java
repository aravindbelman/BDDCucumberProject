package com.LegacyApplication.PageLocators;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.LegacyApplication.TestBase.TestBase;

public class WorkersCompLocators extends TestBase{
	
	public static WebDriver driver;
    public static final Logger log=Logger.getLogger(WorkersCompLocators.class.getName());
    
    //....................>>Workers Comp Locators<<.............................//
    
    //....................>>Tough Comp Integrated Workers Comp<<.............................//
    
    @FindBy(xpath="//a[@class='btn btn-default' and @data-shows-group='workers-comp']")
    public static WebElement workerscomp_tab;
    
    @FindBy(xpath="//img[@alt='Integrated Underwriter Workers Comp']")
    public static WebElement underwriter_workers_comp;
    
    @FindBy(xpath="//button[@class='btn btn-primary' and text()='Continue']")
    public static WebElement continue_button;
    
    @FindBy(xpath="//button[@class='btn btn-primary' and text()='Rate with Victory']")
    public static WebElement rate_with_victory_btn;
    
     //....................>>Application Information<<.............................//
    
    @FindBy(xpath="//input[@id='ApplicantName']")
    public static WebElement applicant_name;
    
    @FindBy(xpath="//select[@id='ApplicantBusinessType']")
    public static WebElement business_type;
    
    @FindBy(xpath="//input[@id='ApplicantPhone']")
    public static WebElement applicant_phone;
    
    @FindBy(xpath="//input[@id='ApplicantFederalEmployerId']")
    public static WebElement federal_emp_id;
    
    @FindBy(xpath="//input[@id='ApplicantEmail']")
    public static WebElement applicant_email;
    
    @FindBy(xpath="//input[@id='ApplicantStreetAddress']")
    public static WebElement applicant_street_address;
    
    @FindBy(xpath="//input[@id='ApplicantBusinessName']")
    public static WebElement applicant_business_name;
    
    @FindBy(xpath="//input[@id='ApplicantCity']")
    public static WebElement applicant_city;
    
    @FindBy(xpath="//select[@id='ApplicantYearsInBusiness']")
    public static WebElement years_in_business;
    
    @FindBy(xpath="//select[@id='ApplicantState']")
    public static WebElement applicant_state;
    
    @FindBy(xpath="//input[@id='ApplicantPostalCode']")
    public static WebElement zip_code;

  //....................>>Work Comp Rating Information<<.............................//
    
    @FindBy(xpath="//input[@id='ProposedEffectiveDate']")
    public static WebElement proposed_effective_date;
    
    @FindBy(xpath="//select[@id='LimitsOfInsurance']")
    public static WebElement limits_of_insurance;
    
    @FindBy(xpath="//input[@id='CurrentExMod']")
    public static WebElement current_exp_mode;
    
    @FindBy(xpath="//select[@id='CurrentLapseInCoverage']")
    public static WebElement lapse_in_coverage;
    
    @FindBy(xpath="//input[@id='PreviousExMod']")
    public static WebElement prev_exp_mode;
    
    @FindBy(xpath="//input[@id='CurrentCarrier']")
    public static WebElement current_carrier;
    
    @FindBy(xpath="//input[@class='form-control' and @name='ExpiringPremiumInput']")
    public static WebElement expiring_premium_input;
    
    @FindBy(xpath="//textarea[@id='ApplicantDescriptionOfOperations']")
    public static WebElement description_of_operations;
    
  //....................>>Select state and Classification Locators<<.............................//
    
    @FindBy(xpath="//select[@class='form-control state-for-classes']")
    public static WebElement state_classifications;
    
    @FindBy(xpath="//input[@id='Classifications_0__Classification']")
    public static WebElement class_codeandname;
    
    @FindBy(xpath="//input[@class='form-control disabled' and @name='PayrollInput[0]']")
    public static WebElement payroll;
    
    @FindBy(xpath="//input[@id='Classifications_0__FullTimeEmployees' and @class='form-control disabled']")
    public static WebElement emp_classification_parttime;
    
    @FindBy(xpath="//input[@id='Classifications_0__PartTimeEmployees' and @type='number']")
    public static WebElement emp_classification_fulltime;
    
    @FindBy(xpath="(//input[@id='HeightExposureOver2Stories'])[position()=1]")
    public static WebElement height_exposure_yes;
    
    @FindBy(xpath="(//input[@id='HeightExposureOver2Stories'])[position()=2]")
    public static WebElement height_exposure_no;
    
    @FindBy(xpath="(//input[@id='DepthExposureOver6Ft'])[position()=1]")
    public static WebElement depth_exposure_yes;
    
    @FindBy(xpath="(//input[@id='DepthExposureOver6Ft'])[position()=2]")
    public static WebElement depth_exposure_no;
    
    @FindBy(xpath="//button[@class='btn btn-primary' and normalize-space(text()='Rate it Now!')]")
    public static WebElement rate_it_now_btn;
    
    //....................>>Victory Worker's Comp Locators<<.............................//
    
    @FindBy(xpath="(//div[@class='ui-dialog-buttonset']//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only'])[position()=1]")
    public static WebElement flash_indication_btn;
    
    @FindBy(xpath="(//div[@class='ui-dialog-buttonset']//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only'])[position()=2]")
    public static WebElement get_a_full_quote_btn;
    
  //....................>>Victory Worker's Comp application information Locators<<.............................//
    
    @FindBy(xpath="//input[@id='txtboxApplicant']")
    public static WebElement fi_applicant_name;
    
    @FindBy(xpath="//input[@id='txtboxDBA']")
    public static WebElement fi_dba;
    
    @FindBy(xpath="//input[@id='txtState']")
    public static WebElement fi_state;
    
    @FindBy(xpath="//input[@id='txtboxZipCode']")
    public static WebElement fi_zipcode;
    
    //....................>>Victory Worker's Comp Rating Information information Locators<<.............................//   
    
    @FindBy(xpath="//input[@id='txtLimits']")
    public static WebElement fi_limits_of_insurance;
    
    @FindBy(xpath="//input[@id='txtboxExpMod']")
    public static WebElement workers_modification;
    
    @FindBy(xpath="//input[@id='divClassification1_input']")
    public static WebElement classification_input1;
    
    @FindBy(xpath="//input[@id='txtboxPayroll1']")
    public static WebElement fi_payroll1;
    
    @FindBy(xpath="//input[@id='divClassification2_input']")
    public static WebElement classification_input2;
    
    @FindBy(xpath="//input[@id='txtboxPayroll2']")
    public static WebElement fi_payroll2;
    
    @FindBy(xpath="//input[@id='divClassification3_input']")
    public static WebElement classification_input3;
    
    @FindBy(xpath="//input[@id='txtboxPayroll3']")
    public static WebElement fi_payroll3;
    
    @FindBy(xpath="//input[@id='divClassification4_input']")
    public static WebElement classification_input4;
    
    @FindBy(xpath="//input[@id='txtboxPayroll4']")
    public static WebElement fi_payroll4;
    
    @FindBy(xpath="//button[@id='ButtonGetFlashQuote']")
    public static WebElement fi_rate_itnow_btn;
    
    @FindBy(xpath="//button[@id='ButtonViewSubmissions']")
    public static WebElement fi_back_to_submission_btn;
    
  //....................>>Victory Worker's Comp Rating Information information Locators after clicking the get full quote<<.............................//
    
  //....................>>Application information<<.............................//     
  //gfc===== get full Quote
    
    @FindBy(xpath="//input[@id='Step1_InsName']")
    public static WebElement gfq_applicant_name;  
    
    @FindBy(xpath="//input[@id='Step1_InsDba']")
    public static WebElement gfq_dba;
    
    @FindBy(xpath="//input[@id='Step1_DateEff']")
    public static WebElement gfq_prop_effective_date;
    
    @FindBy(xpath="//select[@id='Step1_Lapse']")
    public static WebElement gfq_lapse_in_coverage;
    
    @FindBy(xpath="//input[@id='Step1_InsAdr1']")
    public static WebElement gfq_address;
    
    @FindBy(xpath="//input[@id='Step1_InsCity']")
    public static WebElement gfq_city;
    
    @FindBy(xpath="//select[@id='Step1_InsState']")
    public static WebElement gfq_state;
    
    @FindBy(xpath="//input[@id='Step1_InsZip']")
    public static WebElement gfq_zipcode;
    
    @FindBy(xpath="//input[@id='Step1_InsPhoneAreaCode']")
    public static WebElement gfq_phn_area_code;
    
    @FindBy(xpath="//input[@id='Step1_InsPhonePrefix']")
    public static WebElement gfq_phn_prefix;
    
    @FindBy(xpath="//input[@id='Step1_InsPhoneNumber']")
    public static WebElement gfq_phn_number;
    
    @FindBy(xpath="//input[@id='Step1_TaxId']")
    public static WebElement fein_number;
    
  //....................>>Rating information<<.............................// 
    
    @FindBy(xpath="//select[@id='Step3And4_LimitDesc']")
    public static WebElement gfq_limits_of_insurance;
    
    @FindBy(xpath="//select[@id='Step2_ClassCodes_0__GovState']")
    public static WebElement gfq_gov_state1;
    
    @FindBy(xpath="//input[@id='CcDesc0']")
    public static WebElement gfq_descrioton1;
    
    @FindBy(xpath="//input[@id='Step2_ClassCodes_0__Payroll']")
    public static WebElement gfq_payroll1;
    
    @FindBy(xpath="//input[@id='Step2_ClassCodes_0__NumFullTimeEmps']")
    public static WebElement gfq_full_time_emp1;
    
    @FindBy(xpath="//input[@id='Step2_ClassCodes_0__NumPartTimeEmps']")
    public static WebElement gfq_part_time_emp1;
    
    @FindBy(xpath="//input[@id='Step3And4_EmPct']")
    public static WebElement gfq_exp_modification;
    
    @FindBy(xpath="//input[@id='Step3And4_BwChk']")
    public static WebElement gfq_blanket_waiver_subrogation;
    
    @FindBy(xpath="//input[@id='Step3And4_MCPChk']")
    public static WebElement mcp_chkbx;
    
    @FindBy(xpath="//div[@id='RateItNow']/input")
    public static WebElement gfq_rate_it_now_btn;
}


