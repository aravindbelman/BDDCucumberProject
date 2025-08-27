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
	public static WebElement amtrmust_comercial_auto_link;
	
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
	
	 @FindBy(xpath="//div[@id='stateAndGroupSelector']/descendant::*[4]")
	  public static WebElement ca_tab;
	
	@FindBy(xpath="//img[@alt='Victory Commercial Auto']")
	public static WebElement victorycommercialauto_link;
	
//....................>>Victory Commercial Auto Program Rating Information Locators<<.............................//
	
	//....................>>Select Policy Limits and terms locators<<.............................//
	/*
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
	
	@FindBy(xpath="//select[@id='Rating_Screen1_NumVehiclesShow']")
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
	
	*/
	
	// Ashish- 10Jully
	
	//....................Commercial auto_rating info.locators<<.............................//
    
	   //-------------------- 1. select policy limit & policy term-------------------------------// 
	    
		
	    @FindBy(xpath="//span[@id='Header1_SubmissionId1_lblSubmissionIDValue']")
	   	public static WebElement ca_application_quote_no;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_ApplicantName']")
	    public static WebElement ca_name_txtb;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_Dba']")
	    public static WebElement ca_dba_txtb;
	    
	    @FindBy(xpath="//select[@id='Rating_Screen1_StateRs']")
	    public static WebElement ca_state_drpdwn;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_EffectiveDate']")
	    public static WebElement ca_effectivedate;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_Operations']")
	    public static WebElement ca_descriptionoperation_txtb;
	    
	    @FindBy(xpath="//select[@id='Rating_Screen1_YearsInBusiness']")
	    public static WebElement ca_noyear_drpdwn;
	    
	    @FindBy(xpath="//select[@id='Rating_Screen1_LiabilityLimits']")
	    public static WebElement ca_libilitylimit_drpdwn;
	    
	    @FindBy(xpath="//select[@id='Rating_Screen1_CslLimits']")
	    public static WebElement ca_appcurrentlimit_drpdwn;
	    
	    //if split limit option choose
	 	@FindBy(xpath="//select[@id='Rating_Screen1_BiLimits']")
	    public static WebElement ca_bi_drpdwn;
	    
	    @FindBy(xpath="//select[@id='Rating_Screen1_PdLimits']")
	    public static WebElement ca_pd_drpdwn;
	    
	    @FindBy(xpath="//select[@id='Rating_Screen1_MedicalPayments']")
	    public static WebElement ca_medicalpayment_drpdwn;
	    
	    @FindBy(xpath="//select[@id='Rating_Screen1_UninsuredMotorist']")
	    public static WebElement ca_uninsuredmotorist_drpdwn;
	    
	    @FindBy(xpath="//select[@id='Rating_Screen1_PolicyTerm']")
	    public static WebElement ca_policyterm_drpdwn;
	    
	    @FindBy(xpath="//select[@id='Rating_Screen1_Payinfull']")
	    public static WebElement ca_paymentoption_drpdwn;

	    //-------------------- 2.Select the Number of Vehicles and Enter Vehicle Coverage Information-------------------------------// 
	    
	    @FindBy(xpath="//select[@id='Rating_Screen1_NumVehiclesShow']")
	    public static WebElement ca_noofvehicle_drpdwn;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_Vin1']")
	    public static WebElement ca_vin_txtb;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_Year1']")
	    public static WebElement ca_year_txtb;

	    @FindBy(xpath="//input[@id='Rating_Screen1_Make1']")
	    public static WebElement ca_make_txtb;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_Model1']")
	    public static WebElement ca_model_txtb;
	    
	    @FindBy(xpath="//select[@id='Rating_Screen1_Comp1']")
	    public static WebElement ca_compnamedperil_drpdwn;
	    
	    @FindBy(xpath="//select[@id='Rating_Screen1_Coll1']")
	    public static WebElement ca_coll_drpdwn;
	    
	    @FindBy(xpath="//select[@id='Rating_Screen1_UninsuredMotoristPd1']")
	    public static WebElement ca_umpd_drpdwn;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_Value1']")
	    public static WebElement ca_currentvalue_txtb;

  	   //alert appear to close that
	  
	    @FindBy(xpath="//img[@src='images/close_tile.gif']")
	    public static WebElement ca_closealert;	    

	    @FindBy(xpath="//select[@id='Rating_Screen1_Type1']")
	    public static WebElement ca_type_drpdwn;
	    
	    @FindBy(xpath="//select[@id='Rating_Screen1_TypeOfBusiness1']")
	    public static WebElement ca_operation_drpdwn;
	    
	    @FindBy(xpath="//select[@id='Rating_Screen1_Use1']")
	    public static WebElement ca_use_drpdwn;
	    
	    @FindBy(xpath="//select[@id='Rating_Screen1_Radius1']")
	    public static WebElement ca_radius_drpdwn;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_Zip1']")
	    public static WebElement ca_zip_txtb;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_ClrVehicle1']")
	    public static WebElement ca_deletevehicle_chkb;
	    
	    
	    //-------------------- 3.Select the Number of Drivers and Enter Driver Information-------------------------------// 
	    
	    @FindBy(xpath="//select[@id='Rating_Screen1_NumDriversShow']")
	    public static WebElement ca_selectnoofdriver_drpdwn;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_Fname1']")
	    public static WebElement ca_firstname_txtb;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_Name1']")
	    public static WebElement ca_lastname_txtb;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_DriverLicenseNo1']")
	    public static WebElement ca_driverlicense_txtb;
	    
	    @FindBy(xpath="//select[@id='Rating_Screen1_StateLic1drp']")
	    public static WebElement ca_statelic_drpdwn;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_MS_Married1']")
	    public static WebElement ca_married_chkb;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_MS_Single1']")
	    public static WebElement ca_single_chkb;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_Dob1']")
	    public static WebElement ca_dob_txtb;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_YearsLicensed1']")
	    public static WebElement ca_yearlic_txtb;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_None1']")
	    public static WebElement ca_none_chkb;
	    
	    @FindBy(xpath="//select[@id='Rating_Screen1_Major1']")
	    public static WebElement ca_major_drpdwn;
	    
	    @FindBy(xpath="//select[@id='Rating_Screen1_Serious1']")
	    public static WebElement ca_serious_drpdwn;
	    
	    @FindBy(xpath="//select[@id='Rating_Screen1_Minor1']")
	    public static WebElement ca_minor_drpdwn;
	    
	    @FindBy(xpath="//select[@id='Rating_Screen1_Accidents1']")
	    public static WebElement ca_accident_drpdwn;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_ClrDriver1']")
	    public static WebElement ca_deletedriver_chkb;
	    
	    //--------------------4.Provide Coverage History and Select Optional Coverages-------------------------------//
	    
	    
	    @FindBy(xpath="//select[@id='Rating_Screen1_PriorInsurance']")
	    public static WebElement ca_priorinsurance_drpdwn;
	    
	    //optional coverage
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_Hired']")
	    public static WebElement ca_hiredandnonowned_chkb;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_HiredCost']")
	    public static WebElement ca_cost_txtb;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_Employees']")
	    public static WebElement ca_employees_txtb;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_Rentalreimbursement']")
	    public static WebElement ca_rental_chkb;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_RentalReimbursement1']")
	    public static WebElement ca_vehicle1_chkb;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_AdditionalEquipment']")
	    public static WebElement ca_addeqipment_chkb;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_EquipmentValue']")
	    public static WebElement ca_vechicle1value_txtb;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_StereoSound']")
	    public static WebElement ca_stereosound_chkb;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_StereoValue']")
	    public static WebElement ca_stereovehicle_value_txtb;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_OtherCar']")
	    public static WebElement ca_othercar_chkb;
	    
	    @FindBy(xpath="//select[@id='Rating_Screen1_OtherCarNumber']")
	    public static WebElement ca_indivname_drpdwn;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_McpFiling']")
	    public static WebElement ca_mcp65_chkb;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_SrFiling']")
	    public static WebElement ca_sr22_chkb;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_btnRateIT']")
	    public static WebElement wc_ratenow_btn;
	    
	  //....................Commercial auto_ Eligibility question locators<<.............................//
	    //-------------------Question no. 3/4/5/12 -YES- value=1 --------------------------------------//
	    
	    	    
	    @FindBy(xpath="//input[@id='rbCQ_43391'][@value=1]")
	    public static WebElement ca_eq1yes_radio;
	    @FindBy(xpath="//input[@id='rbCQ_43390'][@value=0]")
	    public static WebElement ca_eq1no_radio;
	    
	    @FindBy(xpath="//input[@id='rbCQ_43411'][@value=1]")
	    public static WebElement ca_eq2yes_radio;
	    @FindBy(xpath="//input[@id='rbCQ_43410'][@value=0]")
	    public static WebElement ca_eq2no_radio;
	    
	    @FindBy(xpath="//input[@id='rbCQ_43401'][@value=1]")
	    public static WebElement ca_eq3yes_radio;
	    @FindBy(xpath="//input[@id='rbCQ_43400'][@value=0]")
	    public static WebElement ca_eq3no_radio;
	    
	    @FindBy(xpath="//input[@id='rbCQ_43421'][@value=1]")
	    public static WebElement ca_eq4yes_radio;
	    @FindBy(xpath="//input[@id='rbCQ_43420'][@value=0]")
	    public static WebElement ca_eq4no_radio;
	    
	    @FindBy(xpath="//input[@id='rbCQ_43431'][@value=1]")
	    public static WebElement ca_eq5yes_radio;
	    @FindBy(xpath="//input[@id='rbCQ_43430'][@value=0]")
	    public static WebElement ca_eq5no_radio;
	    
	    @FindBy(xpath="//input[@id='rbCQ_43441'][@value=1]")
	    public static WebElement ca_eq6yes_radio;
	    @FindBy(xpath="//input[@id='rbCQ_43440'][@value=0]")
	    public static WebElement ca_eq6no_radio;
	    
	    @FindBy(xpath="//input[@id='rbCQ_43451'][@value=1]")
	    public static WebElement ca_eq7yes_radio;
	    @FindBy(xpath="//input[@id='rbCQ_43450'][@value=0]")
	    public static WebElement ca_eq7no_radio;
	    
	    @FindBy(xpath="//input[@id='rbCQ_43461'][@value=1]")
	    public static WebElement ca_eq8yes_radio;
	    @FindBy(xpath="//input[@id='rbCQ_43460'][@value=0]")
	    public static WebElement ca_eq8no_radio;
	    
	    @FindBy(xpath="//input[@id='rbCQ_43471'][@value=1]")
	    public static WebElement ca_eq9yes_radio;
	    @FindBy(xpath="//input[@id='rbCQ_43470'][@value=0]")
	    public static WebElement ca_eq9no_radio;
	    
	    @FindBy(xpath="//input[@id='rbCQ_43481'][@value=1]")
	    public static WebElement ca_eq10yes_radio;
	    @FindBy(xpath="//input[@id='rbCQ_43480'][@value=0]")
	    public static WebElement ca_eq10no_radio;
	    
	    @FindBy(xpath="//input[@id='rbCQ_43491'][@value=1]")
	    public static WebElement ca_eq11yes_radio;
	    @FindBy(xpath="//input[@id='rbCQ_43490'][@value=0]")
	    public static WebElement ca_eq11no_radio;
	    
	    @FindBy(xpath="//input[@id='rbCQ_43501'][@value=1]")
	    public static WebElement ca_eq12yes_radio;
	    @FindBy(xpath="//input[@id='rbCQ_43500'][@value=0]")
	    public static WebElement ca_eq12no_radio;
	    
	    @FindBy(xpath="//input[@id='rbCQ_43511'][@value=1]")
	    public static WebElement ca_eq13yes_radio;
	    @FindBy(xpath="//input[@id='rbCQ_43510'][@value=0]")
	    public static WebElement ca_eq13no_radio;
	    
	    @FindBy(xpath="//input[@id='rbCQ_43521'][@value=1]")
	    public static WebElement ca_eq14yes_radio;
	    @FindBy(xpath="//input[@id='rbCQ_43520'][@value=0]")
	    public static WebElement ca_eq14no_radio;
	    
	    @FindBy(xpath="//input[@id='rbCQ_43531'][@value=1]")
	    public static WebElement ca_eq15yes_radio;
	    @FindBy(xpath="//input[@id='rbCQ_43530'][@value=0]")
	    public static WebElement ca_eq15no_radio;
	    
	    @FindBy(xpath="//input[@id='rbCQ_43541'][@value=1]")
	    public static WebElement ca_eq16yes_radio;
	    @FindBy(xpath="//input[@id='rbCQ_43540'][@value=0]")
	    public static WebElement ca_eq16no_radio;
	    
	    @FindBy(xpath="//input[@id='rbCQ_43551'][@value=1]")
	    public static WebElement ca_eq17yes_radio;
	    @FindBy(xpath="//input[@id='rbCQ_43550'][@value=0]")
	    public static WebElement ca_eq17no_radio;
	    
	    @FindBy(xpath="//input[@id='rbCQ_43561'][@value=1]")
	    public static WebElement ca_eq18yes_radio;
	    @FindBy(xpath="//input[@id='rbCQ_43560'][@value=0]")
	    public static WebElement ca_eq18no_radio;
	    
	    @FindBy(xpath="//input[@id='rbCQ_149111'][@value=1]")
	    public static WebElement ca_eq19yes_radio;
	    @FindBy(xpath="//input[@id='rbCQ_149110'][@value=0]")
	    public static WebElement ca_eq19no_radio;
	    
	    @FindBy(xpath="//span[contains(text(),'Are any vehicles registered to an individual?')]")
	    public static WebElement eligible_qus19;
	    
	    	    
	    @FindBy(xpath="//input[@id='Footer1_NextPrev1_btnPrev']")
	    public static WebElement ca_eqpagePrev_btn;
	    
	    @FindBy(xpath="//input[@id='Footer1_NextPrev1_btnNext']")
	    public static WebElement ca_eqpageNext_btn;
	
	      
	  //....................Commercial auto_ Application page locators<<.............................//
	    
	    //Application page Error List
	    @FindBy(xpath=" //table[@id='ProjectDetails_Screen1_tblError']/descendant::tr[1]/child::td[2]")
	    public static WebElement ca_applicationpage_error_list;
	    
	    @FindBy(xpath="//span[@id='ProjectDetails_Screen1_lblError']/descendant::ul[2]/child::li[1]")
	    public static WebElement ca_applicationpage_VIN_error_msg;
	    
	    //Applicant Information
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_Address']")
	    public static WebElement ca_addressphy_txtb;
	    	    
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_City']")
	    public static WebElement ca_city_txtb;
	    
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_ZipCode']")
	    public static WebElement ca_zipcode_txtb;
	    
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_SameMailingAddress']")
	    public static WebElement ca_samemailaddress_chkb;
	    
	    //Mailing address details
	    
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_MailingAddress']")
	    public static WebElement ca_mailaddress_txtb;
	    
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_MailingCity']")
	    public static WebElement ca_mailcity_txtb;
	    
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_MailingZipCode']")
	    public static WebElement ca_mailzip_txtb;
	    
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_ContactName']")
	    public static WebElement ca_contactname_txtb;
	    
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_Area']")
	    public static WebElement ca_ph1_txtb;
	    
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_Prefix']")
	    public static WebElement ca_ph2_txtb;
	    	    
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_Phone']")
	    public static WebElement ca_ph3_txtb;
	    	    
	    @FindBy(xpath="//select[@id='ProjectDetails_Screen1_TypeOfBusiness']")
	    public static WebElement ca_typeofbusiness_drpdwn;
	    
	    //Claim Section
	       
	    @FindBy(xpath="//table[@id='ProjectDetails_Screen1_tblMain']//strong[contains(text(), 'CLAIMS SECTION')]")
	    public static WebElement ca_claimsSection_heading;
	    
	    //Prior Insurance History 
	    
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_CarrierName1']")
	    public static WebElement ca_carrier1_txtb;
	    
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_PolicyNumber1']")
	    public static WebElement ca_policyno1_txtb;
	    
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_PriorInsuranceLimit1']")
	    public static WebElement ca_priorinslimit1_txtb;
	    
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_PolicyTermDates1']")
	    public static WebElement ca_policytermdate1_txtb;
	    
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_TotalPremium1']")
	    public static WebElement ca_totalpremium1_txtb;
	
	    //Driver list
	    
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_DriverLicenseNo1']")
	    public static WebElement ca_driverliscense_txtb;
	    
	    @FindBy(xpath="//select[@id='ProjectDetails_Screen1_StateLic1drp']")
	    public static WebElement ca_statelic1_drpdwn;
	    
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_Sr221']")
	    public static WebElement ca_sr221_chkb;
	   
	    
	    //DRIVE OTHER CAR – INDIVIDUALS (Owners & their spouses only)
	      
	    @FindBy(xpath="//select[@id='ProjectDetails_Screen1_NumDrivers1']")
	    public static WebElement ca_slectdriver_drpdwn;
	    	    
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_Fname11']")
	    public static WebElement ca_firstname1_txtb;
	    
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_Name11']")
	    public static WebElement ca_lastname1_txtb;
	    
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_Dob11']")
	    public static WebElement ca_dob1_txtb;
	    
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_YearsLicensed11']")
	    public static WebElement ca_yeexp_txtb;
	    
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_DriverLicenseNo11']")
	    public static WebElement ca_driverliscense2_txtb;
	    
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_StateLic11']")
	    public static WebElement ca_statelic2_txtb;
	    
	    //Claims section
	    //go with No option
	    
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_ClaimsYes']")
	    public static WebElement ca_claimyes_radio;
	    
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_ClaimsNo']")
	    public static WebElement ca_claimno_radio;
	  
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_ClaimsDateOfLoss1']")
	    public static WebElement ca_dateofloss;
	    
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_ClaimsDescription1']")
	    public static WebElement ca_description_txtb;
	    
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_ClaimsPayOutAmount1']")
	    public static WebElement ca_payout_txtb;
	    
	    @FindBy(xpath="//button[@id='AddClaim']")
	    public static WebElement ca_addclaim_btn;
	    
	    @FindBy(xpath="//button[@id='RemoveLastClaim']")
	    public static WebElement ca_removeclaim_btn;
	    
	    //VEHICLE INFORMATION     
	        
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_Gvw1']")
	    public static WebElement ca_gvw_txtb;
	       
	    //STEREOS/SOUND SYSTEMS or ADDITIONAL EQUIPMENT/MODIFICATIONS
	    
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_StereoModDesc1']")
	    public static WebElement ca_stereo_txtb;
	    
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_AdditionalEquiModDesc1']")
	    public static WebElement ca_addequip_txtb;
	    
	    //LOSS PAYEE REQUESTS //optional
	    
	    @FindBy(xpath="//select[@id='ProjectDetails_Screen1_NoOfLosspayee']")
	    public static WebElement ca_noofloss_drpdwn;
	    
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_LossPayNo1']")
	    public static WebElement ca_vehiclelp_txtb;
	    
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_LossPayName1']")
	    public static WebElement ca_namelp_txtb;
	    
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_LossPayStreet1']")
	    public static WebElement ca_streetlp_txtb;
	    
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_LossPayCity1']")
	    public static WebElement ca_citylp_txtb;
	   
	    @FindBy(xpath="//select[@id='ProjectDetails_Screen1_LossPayState1']")
	    public static WebElement ca_statelosspayee_drpdwn;
	    
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_LossPayZip1']")
	    public static WebElement ca_ziplp_txtb;
	    
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_LossPvehicle1']")
	    public static WebElement ca_leasedlp_chkb;
	  
	    //ADDITIONAL INTERESTS/ADDITIONAL INSURED REQUESTS //optional
	    
	    @FindBy(xpath="//select[@id='ProjectDetails_Screen1_NumberOfCoi']")
	    public static WebElement ca_noofaddint_drpdwn;
	    
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_Coiname1']")
	    public static WebElement ca_nameaddint_txtb;
	    
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_Coistreet1']")
	    public static WebElement ca_streetaddint_txtb;
	    
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_Coicity1']")
	    public static WebElement ca_cityaddint_txtb;
		    
	    @FindBy(xpath="//select[@id='ProjectDetails_Screen1_Coistate1']")
	    public static WebElement ca_stateaddint_drpdwn;
	    
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_Coizip1']")
	    public static WebElement ca_zipaddint_txtb;
		    
	    //submit button
	    @FindBy(xpath="//input[@id='ProjectDetails_Screen1_btnAssignPolicy2']")
	    public static WebElement ca_submitbutton_btn;
	    
	    //Sold change status - enter policy no. locator
	    @FindBy(xpath="(//input[@id='Status'])[position()=3][@value='5']")
	    public static WebElement ca_oktobind_radio;
	    
	    @FindBy(xpath="(//input[@id='Status'])[position()=8][@value='6']")
	    public static WebElement ca_sold_radio;
	    
	    @FindBy(xpath="//button[@type='button' and text()='Submit']")
	    public static WebElement ca_status_submitbutton;
	    
	    @FindBy(xpath="//input[@name='PolicyNumber']")
	    public static WebElement ca_sold_policyno_txtb;
	    
	    
	 
	    
}
