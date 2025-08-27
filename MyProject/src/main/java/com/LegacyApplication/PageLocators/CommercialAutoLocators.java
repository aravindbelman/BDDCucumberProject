package com.LegacyApplication.PageLocators;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.LegacyApplication.TestBase.TestBase;

public class CommercialAutoLocators extends TestBase {
	
	public static WebDriver driver;
	public static final Logger log=Logger.getLogger(CommercialAutoLocators.class.getName());
	
//....................>>Commercial Auto Locators<<.............................//
    
    //....................>>Tough Comp Integrated Workers Comp Locators<<.............................//
	
	@FindBy(xpath="//img[@alt='Amtrust Commercial Auto']")
	public static WebElement amtrust_commercial_auto_link;
	
	@FindBy(xpath="//select[@id='EZStateDropdown']")
	public static WebElement aca_select_state_drpdwn;
	
	@FindBy(xpath="//button[@id='EZContinueBtn']")
	public static WebElement aca_continue_btn;
	
	@FindBy(xpath="//button[@class='btn btn-default' and text()='Cancel']")
	public static WebElement aca_cancel_btn;
	
	//....................>>Eligibility Page Locators<<.............................//
	
	@FindBy(xpath="//input[@id='ClassCodeSearch']")
	public static WebElement aca_class_code_search;
	
	@FindBy(xpath="//input[@id='Name']")
	public static WebElement aca_search;
	
	@FindBy(xpath="//input[@id='DBA']")
	public static WebElement aca_dba;
	
	@FindBy(xpath="//input[@id='PhysicalAddress_Address1']")
	public static WebElement aca_physical_addresss1;
	
	@FindBy(xpath="//input[@id='PhysicalAddress_Address2']")
	public static WebElement aca_physical_address2;
	
	@FindBy(xpath="//input[@id='PhysicalAddress_Address2']")
	public static WebElement aca_zipcode;
	
	@FindBy(xpath="//input[@id='PhysicalAddress_ZipPlusFour']")
	public static WebElement aca_zip_pls_four;
	
	@FindBy(xpath="//span[@id='state']")
	public static WebElement aca_state_name;
	
	@FindBy(xpath="//input[@id='MailingAddress_blnSameAsPhysical']")
	public static WebElement aca_mailingaddress_chkbx;
	
	@FindBy(xpath="//input[@id='MailingAddress_Address1']")
	public static WebElement aca_mailingaddress1;
	
	@FindBy(xpath="//input[@id='MailingAddress_Zip']")
	public static WebElement aca_mailingaddress_zip;
	
	@FindBy(xpath="//input[@id='MailingAddress_ZipPlusFour']")
	public static WebElement aca_mailingaddress_zipplusfour;
	
	@FindBy(xpath="//input[@id='MailingAddress_City']")
	public static WebElement aca_mailing_city;
	
	@FindBy(xpath="//select[@id='MailingAddress_State']")
	public static WebElement aca_mailingaddress_state;

	@FindBy(xpath="//input[@id='FEIN']")
	public static WebElement aca_fein;
	
	@FindBy(xpath="//input[@id='NumYearsInBusiness']")
	public static WebElement aca_yearsinbusiness;
	
	@FindBy(xpath="//textarea[@id='NatureOfBusiness']")
	public static WebElement aca_natureofbusienss; 
	
	//....................>>Contact Information Locators<<.............................//
	
	@FindBy(xpath="//input[@id='InsContactName']")
	public static WebElement aca_contactname;
	
	@FindBy(xpath="//input[@id='InsContactPhone']")
	public static WebElement aca_contactphone;
	
	@FindBy(xpath="//input[@id='InsContactEmail']")
	public static WebElement aca_contact_email;
	
	@FindBy(xpath="//input[@id='30691_Radio_Yes']")
	public static WebElement aca_transport_hardous_radio_yes;
	
	@FindBy(xpath="//input[@id='30691_Radio_No']")
	public static WebElement aca_transport_hardous_radio_no;
	
	@FindBy(xpath="//input[@id='62199_Radio_Yes']")
	public static WebElement aca_financial_responsibility_radio_yes;
	
	@FindBy(xpath="//input[.//*[@id='62199_Radio_No']")
	public static WebElement aca_financial_responsibility_radio_no;
	
	@FindBy(xpath="//input[@id='30696_Radio_Yes']")
	public static WebElement aca_vehicles_titled_yes;
	
	@FindBy(xpath="//input[@id='30696_Radio_No']")
	public static WebElement aca_vehicles_titled_no;
	
	@FindBy(xpath="//input[@id='30692_Radio_Yes']")
	public static WebElement aca_livery_operations_yes;
	
	@FindBy(xpath="//input[@id='30692_Radio_No']")
	public static WebElement aca_livery_operations_no;
	
	@FindBy(xpath="//input[@id='62203_Radio_Yes']")
	public static WebElement aca_assigned_risk_pgm_yes;
	
	@FindBy(xpath=".//*[@id='62203_Radio_No']")
	public static WebElement aca_assigned_risk_pgm_no;
	
	@FindBy(xpath="//input[@id='31319_Radio_Yes']")
	public static WebElement aca_more_vehicles_yes;
	
	@FindBy(xpath="//input[@id='31319_Radio_No']")
	public static WebElement aca_more_vehicles_no;
	
	@FindBy(xpath="//a[@id='btnRedirect']")
	public static WebElement aca_redirect_btn;

//....................>>National General Insurance Commercial Auto Program Locators<<.............................//	
	
	@FindBy(xpath="//img[@alt='National General Auto']")
	public static WebElement ngca_Link;
	
	@FindBy(xpath="//select[@id='GMACStateDropdown']")
	public static WebElement ngca_select_state;
	
	@FindBy(xpath="//button[@id='GMACContinueBtn']")
	public static WebElement ngca_continue_btn;
	
	@FindBy(xpath="//button[@class='btn btn-default' and text()='Cancel']")
	public static WebElement ngca_cancel_btn;
	
//....................>>National General Insurance Commercial Auto General Information Locators<<.............................//	
	
	@FindBy(xpath="//input[@id='ctl00_MainContent_InsuredNamed1_txtAgtCode']")
	public static WebElement ngca_agent_code;
	
	@FindBy(xpath="//input[@id='ctl00_MainContent_InsuredNamed1_txtProducerEmail']")
	public static WebElement ngca_producer_email;
	
	@FindBy(xpath="//select[@id='ctl00_MainContent_InsuredNamed1_ddlPlanCode']")
	public static WebElement ngca_plan;
	
	@FindBy(xpath="//input[@id='ctl00_MainContent_InsuredNamed1_txtDateEff']")
	public static WebElement ngca_policy_eff_date;
	
    @FindBy(xpath="//select[@id='ctl00_MainContent_InsuredNamed1_ddlBusinessEntity']")
    public static WebElement ngca_entity;
    
    @FindBy(xpath="//select[@id='ctl00_MainContent_InsuredNamed1_ddlMotorCarrierForHire']")
    public static WebElement ngca_motor_carrier;
	
    @FindBy(xpath="//input[@id='txtSelectionBox']")
    public static WebElement ngca_business_type;
    
    @FindBy(xpath="//select[@id='ctl00_MainContent_InsuredNamed1_ddlYrsInBusiness']")
    public static WebElement ngca_years_as_owner;
    
    @FindBy(xpath="//select[@id='ctl00_MainContent_InsuredNamed1_ddlYrsInIndustry']")
    public static WebElement ngca_exp_in_business;
    
    @FindBy(xpath="//select[@id='ctl00_MainContent_InsuredNamed1_ddlBankruptciesOrLiens']")
    public static WebElement ngca_bankruptcies_liens;
    
 //....................>>National General Insurance Commercial Auto Name Insured Locators<<.............................//	
    
    @FindBy(xpath="//input[@id='ctl00_MainContent_InsuredNamed1_txtInsFirstName']")
    public static WebElement ngca_firstname;
    
    @FindBy(xpath="//input[@id='ctl00_MainContent_InsuredNamed1_txtInsMiddleName']")
    public static WebElement ngca_middlename;
    
    @FindBy(xpath="//input[@id='ctl00_MainContent_InsuredNamed1_txtInsLastName']")
    public static WebElement ngca_lastname;
    
    @FindBy(xpath="//input[@id='ctl00_MainContent_InsuredNamed1_ucPhones_PhoneNumber1_txtPhone1']")
    public static WebElement ngca_phoneone_txtphn1;
    
    @FindBy(xpath="//input[@id='ctl00_MainContent_InsuredNamed1_ucPhones_PhoneNumber1_txtPhone2']")
    public static WebElement ngca_phoneone_txtphn2;
    
    @FindBy(xpath="//input[@id='ctl00_MainContent_InsuredNamed1_ucPhones_PhoneNumber1_txtPhone3']")
    public static WebElement ngca_phoneone_txtphn3;
    
    @FindBy(xpath="//select[@id='ctl00_MainContent_InsuredNamed1_ucPhones_PhoneNumber1_ddlPhoneType']")
    public static WebElement ngca_phoneone_phntype;
    
    @FindBy(xpath="//input[@id='ctl00_MainContent_InsuredNamed1_ucPhones_PhoneNumber2_txtPhone1']")
    public static WebElement ngca_phonetwo_txtphn1;
	
    @FindBy(xpath="//input[@id='ctl00_MainContent_InsuredNamed1_ucPhones_PhoneNumber2_txtPhone2']")
    public static WebElement ngca_phonetwo_txtphn2;
    
    @FindBy(xpath="//input[@id='ctl00_MainContent_InsuredNamed1_ucPhones_PhoneNumber2_txtPhone3']")
    public static WebElement ngca_phonetw0_txtphn3;
    
    @FindBy(xpath="//select[@id='ctl00_MainContent_InsuredNamed1_ucPhones_PhoneNumber2_ddlPhoneType']")
    public static WebElement ngca_phonetwo_phntype;
    
    @FindBy(xpath="//input[@id='ctl00_MainContent_InsuredNamed1_ucPhones_PhoneNumber3_txtPhone1']")
    public static WebElement ngca_phonethree_txtphn1;
    
    @FindBy(xpath="//input[@id='ctl00_MainContent_InsuredNamed1_ucPhones_PhoneNumber3_txtPhone2']")
    public static WebElement ngca_phnthree_txtphn2;
    
    @FindBy(xpath="//input[@id='ctl00_MainContent_InsuredNamed1_ucPhones_PhoneNumber3_txtPhone3']")
    public static WebElement ngca_phnthree_txtphn3;
    
    @FindBy(xpath="//select[@id='ctl00_MainContent_InsuredNamed1_ucPhones_PhoneNumber3_ddlPhoneType']")
    public static WebElement ngca_phnthree_phntype;
    
    @FindBy(xpath="//select[@id='ctl00_MainContent_InsuredNamed1_ddlEmailOption']")
    public static WebElement ngca_email_option;
    
    @FindBy(xpath="//input[@id='ctl00_MainContent_InsuredNamed1_txtInsEmail']")
    public static WebElement ngca_email_address;
	
  //....................>>National General Insurance Commercial Auto Mailing Address Locators<<.............................//	
	
	@FindBy(xpath="//input[@id='ctl00_MainContent_InsuredNamed1_txtInsAdr']")
	public static WebElement ngca_mailing_address1;
	
	@FindBy(xpath="//input[@id='ctl00_MainContent_InsuredNamed1_txtInsAdr2']")
	public static WebElement ngca_mailing_address2;
	
	@FindBy(xpath="//input[@id='ctl00_MainContent_InsuredNamed1_txtInsCity']")
	public static WebElement ngca_city;
	
	@FindBy(xpath="//select[@id='ctl00_MainContent_InsuredNamed1_ddlInsState']")
	public static WebElement ngca_state;
	
	@FindBy(xpath="//input[@id='ctl00_MainContent_InsuredNamed1_txtInsZip']")
	public static WebElement ngca_zip1;
	
	@FindBy(xpath="//input[@id='ctl00_MainContent_InsuredNamed1_txtInsZip2']")
	public static WebElement ngca_zip2;
	
	@FindBy(xpath="//select[@id='ctl00_MainContent_InsuredNamed1_ddlInsRecentMove60']")
	public static WebElement ngca_prevaddress_drpdwn;
	
	@FindBy(xpath="//a[@id='ctl00_MainContent_btnContinue']")
	public static WebElement ngca_saveandcontinuebtn;
	
//....................>>Victory Commercial Auto Program Locators<<.............................//	
	
	@FindBy(xpath="//img[@alt='Victory Commercial Auto']")
	public static WebElement victorycommercialauto_link;
	
//....................>>Victory Commercial Auto Program Rating Information Locators<<.............................//
	
	//....................>>Select Policy Limits and terms locators<<.............................//
	
	@FindBy(xpath="//input[@id='Rating_Screen1_ApplicantName']")
	public static WebElement vca_applicantname;
	
	@FindBy(xpath="//input[@id='Rating_Screen1_Dba']")
	public static WebElement vca_dba;
	
	@FindBy(xpath="//select[@id='Rating_Screen1_StateRs']")
	public static WebElement vca_selectstate;
	
	@FindBy(xpath="//input[@id='Rating_Screen1_EffectiveDate']")
	public static WebElement vca_effectivedate;
	
	@FindBy(xpath="//input[@id='Rating_Screen1_Operations']")
	public static WebElement vca_desc_of_operations;
	
	@FindBy(xpath="//select[@id='Rating_Screen1_YearsInBusiness']")
	public static WebElement vca_yearsinbusiness;
	
	@FindBy(xpath="//select[@id='Rating_Screen1_LiabilityLimits']")
	public static WebElement vca_liabilitylimits;
	
	@FindBy(xpath="//select[@id='Rating_Screen1_CslLimits']")
	public static WebElement vca_applicant_curr_limits;
	
	@FindBy(xpath="//select[@id='Rating_Screen1_MedicalPayments']")
	public static WebElement vca_medical_payments;
	
	@FindBy(xpath="//select[@id='Rating_Screen1_UninsuredMotorist']")
	public static WebElement vca_uninsured_motorist;
	
	@FindBy(xpath="//select[@id='Rating_Screen1_PolicyTerm']")
	public static WebElement vca_policy_term;
	
	@FindBy(xpath="//select[@id='Rating_Screen1_Payinfull']")
	public static WebElement vca_payment_options;
	
	@FindBy(xpath=".//*[@id='Rating_Screen1_NumVehiclesShow']")
	public static WebElement vca_no_of_vehicles;
	
	@FindBy(xpath="//select[@id='Rating_Screen1_NumDriversShow']")
	public static WebElement vca_no_of_drivers;
	
	@FindBy(xpath="//input[@id='Rating_Screen1_Hired']")
	public static WebElement vca_nonowned_liability_chkbx;
	
	@FindBy(xpath="//input[@id='Rating_Screen1_Rentalreimbursement']")
	public static WebElement vca_rental_reimbursement_chkbx;
	
	@FindBy(xpath="//input[@id='Rating_Screen1_AdditionalEquipment']")
	public static WebElement vca_additional_equipment;
	
	@FindBy(xpath="//input[@id='Rating_Screen1_StereoSound']")
	public static WebElement vca_stereosound;
	
	@FindBy(xpath="//input[@id='Rating_Screen1_OtherCar']")
	public static WebElement vca_driver_othercar_chkbx;
	
	@FindBy(xpath="//input[@id='Rating_Screen1_McpFiling']")
	public static WebElement vca_mcp65_filing_chkbx;;
	
	@FindBy(xpath="//input[@id='Rating_Screen1_McpFiling']")
	public static WebElement vca_Sr22_filing_chkbx;
	
	@FindBy(xpath="//input[@id='Rating_Screen1_btnRateIT']")
	public static WebElement vca_rateitnow_button;
	
	
	
	
}
