package com.LegacyApplication.PageLocators;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.LegacyApplication.TestBase.TestBase;

public class SubmissionPageLocators extends TestBase 
{
	
	public static WebDriver driver;
    public static final Logger log=Logger.getLogger(SubmissionPageLocators.class.getName());
    
	@FindBy(id="SelectField")
	public static WebElement ddl_SearchBy;
	
	@FindBy(id="Search")
	public static WebElement search;
	
	@FindBy(id="searchBtn")
	public static WebElement searchbutton;
	
	@FindBy(xpath=".//*[@id='searchTable']/tbody/tr[@data-index='0']/td")
	public static WebElement submissionTableRow;
	
	@FindBy(xpath=".//*[@id='contextMenu']/li/a[contains(text(),'Edit/Finish Submission')]")
	public static WebElement selectFrmCtextMenu;
	
	@FindBy(xpath=".//*[@id='contextMenu']/li/a[contains(text(),'Review Submission')]")
	public static WebElement select_review_submission;
	
	@FindBy(xpath=".//*[@id='Table1']/tbody/tr[3]/td/table/tbody/tr/td[@main='1']/input[contains(@value,\"Home\")]")
	public static WebElement btn_Home;
	
	@FindBy(xpath=".//*[@id='Table1']/tbody/tr[3]/td/table/tbody/tr/td[@main='1']/input[contains(@value,\"General Liability \")]")
	public static WebElement btn_General_Liability;
	
	@FindBy(xpath=".//*[@id='General_Liability_Screen1_SubmissionType']")
	public static WebElement txtbox_SubmissionType;
	
	@FindBy(xpath=".//*[@id='General_Liability_Screen1_ApplicantName']")
	public static WebElement txtbox_ApplicantName;
	
	@FindBy(xpath=".//*[@id='General_Liability_Screen1_DBA']")
	public static WebElement txtbox_DBA;
	
	@FindBy(xpath=".//*[@id='General_Liability_Screen1_State']")
	public static WebElement txtbox_State;
	
	@FindBy(xpath=".//*[@id='General_Liability_Screen1_ZipCodeGL']")
	public static WebElement txtbox_ZipCodeGL;
	
	@FindBy(xpath=".//*[@id='General_Liability_Screen1_GLContractorLicense']")
	public static WebElement txtbox_GLContractorLicense;
	
	@FindBy(xpath=".//*[@id='General_Liability_Screen1_terrByZIP']")
	public static WebElement lbl_terrByZIP;
	
	@FindBy(xpath=".//*[@id='General_Liability_Screen1_NoLicenseNeeded']")
	public static WebElement chkbox_NoLicenseNeeded;

	// -------------
	
	@FindBy(xpath=".//*[@id='General_Liability_Screen1_lblEffectiveDate']")
	public static WebElement txtbox_ProposedEffectiveDate;
	
	@FindBy(xpath=".//*[@id='General_Liability_Screen1_rowTerrByZip']/td[2]")
	public static WebElement txt_Territory;
	
	@FindBy(xpath=".//*[@id='General_Liability_Screen1_Label7']")
	public static WebElement txt_LicenseNumber;

	//===================> General Liability Rating Criteria Locates<========================
	
	@FindBy(xpath=".//*[@id='General_Liability_Screen1_Label6']']")
	public static WebElement txt_GeneralLiabilityRC;
	
	@FindBy(xpath=".//*[@id='General_Liability_Screen1_Limits']")
	public static WebElement ddl_SearchByLimitsofInsurance;
	
	@FindBy(xpath=".//*[@id='General_Liability_Screen1_selectDeductible']")
	public static WebElement ddl_Deductible;
	
	@FindBy(xpath="//tr[2]/td/input[@id='General_Liability_Screen1_Owners']")
	public static WebElement txt_OwnersActiveinField;
	
	@FindBy(xpath="//td[text()='Payroll']")
	public static WebElement tex_Payroll; 

	@FindBy(xpath="//*[@id='TdLimits1']")
	public static WebElement ddl_LimitsofInsurance;
	
	@FindBy(xpath=".//*[@id='tdDeductible1']")
	public static WebElement text_SearchByDeductible;
	
	@FindBy(xpath=".//*[@id='General_Liability_Screen1_selectDeductible']")
	public static WebElement lbl_OwnersActiveinField;

	@FindBy(xpath="//td[text()='Number']")
	public static WebElement tex_Name ;

	@FindBy(xpath="//input[@id=\"General_Liability_Screen1_Owners\"]")
	public static WebElement lbl_ownersActivefield;
	
	@FindBy(xpath="//input[@id=\"General_Liability_Screen1_PartTime\"]")
	public static WebElement tex_pull_timeEmp; 
	
	@FindBy(xpath="//input[@id=\"General_Liability_Screen1_FullTime\"]")
	public static WebElement tex_part_timeEmp; 

	@FindBy(xpath="//input[@id=\"General_Liability_Screen1_PayrollEmployees\"]")
	public static WebElement tex_total_payrole; 

	@FindBy(xpath=".//*[@id='spanTotalPayroll']")
	public static WebElement lbl_total_payrole;  

	// ==========================> tex_OptionalCoverages <===============================
	@FindBy(id="General_Liability_Screen1_Label10")
	public static WebElement tex_OptionalCoverages; 
	
	@FindBy(xpath="//td[text()='Optional General Liability Coverages']")
	public static WebElement tex_OptionalCoverages_GL; 
	
	@FindBy(id="General_Liability_Screen1_StopGapLiability")
	public static WebElement chkbox_Stop_gap_ELCE;
	
	@FindBy(id="General_Liability_Screen1_PerProjectAggregate")
	public static WebElement chkbox_Perproject_Aggregate;
	
	@FindBy(id="General_Liability_Screen1_EmployeeBenefits")
	public static WebElement chkbox_Employee_BF;
	
	@FindBy(id="General_Liability_Screen1_RemoveSubsidence")
	public static WebElement chkbox_Remove_fromNX_GL; 
	
	@FindBy(id="General_Liability_Screen1_ClassificationLimitation")
	public static WebElement chkbox_Limitationofcoverage;
	
	@FindBy(id="'General_Liability_Screen1_chkPriorWork")
	public static WebElement chkbox_Priorcompleted;
	
	@FindBy(id="General_Liability_Screen1_CG2010")
	public static WebElement chkbox_NX_GL; 
	
	@FindBy(id="General_Liability_Screen1_PestHerb")
	public static WebElement chkbox_Pesticide; 
	
	@FindBy(id="General_Liability_Screen1_chkEandO")
	public static WebElement chkbox_Faulty_Workmanship; 
	
	@FindBy(id="General_Liability_Screen1_chkInlandMarine")
	public static WebElement chkbox_Contractors_Miscellaneous; 
	
	@FindBy(xpath="//td[text()='Limits']")
	public static WebElement tex_Limits; 
	
	@FindBy(id="General_Liability_Screen1_ddlEandO")
	public static WebElement ddl_Limits; 
	
	@FindBy(xpath="//td[text()='Deductible']")
	public static WebElement tex_Deductible; 
	
	@FindBy(id="General_Liability_Screen1_ddlEandODeductible")
	public static WebElement ddl_Deductibleddl; 
	
	@FindBy(xpath="//span[text()='Optional Inland Marine Coverages']")
	public static WebElement tex_Optional_inland_MC; 
	
	//=========================> Header Row Locators<================================
 
	@FindBy(xpath=".//*[@id='Table1']/tbody/tr[3]/td//table/tbody/tr/td[@main='1']/input")
    public static List<WebElement> tab_Headers;
	
	@FindBy(xpath=".//*[@id='Table1']/tbody/tr[3]/td//table/tbody/tr/td[@main='0']/input")
	public static List <WebElement> tab_Headers2;
	
	@FindBy(xpath=".//*[@id='Table1']/tbody/tr[3]/td//table/tbody/tr/td[@main='0']/input[@status='2']")
	public static List <WebElement> tab_ErrorHeaders1;

	@FindBy(xpath=".//*[@id='Table1']/tbody/tr[3]/td//table/tbody/tr/td[@main='0']/input[@class='UncheckedSelectedTail']")
	public static List <WebElement> tab_ErrorHeaders2;
	
	@FindBy(xpath="//input[@id='Header1_TabControl1_btn43']")
	public static WebElement price_inditcator_errormsg;
	
	@FindBy(xpath="//input[@id='Header1_TabControl1_btn53']")
	public static WebElement eligibility_errormsg;
	
	@FindBy(xpath="//input[@id='Header1_TabControl1_btn63']")
	public static WebElement application_errormsg;
	
	// ====================> Locators for Optional Coverages <===================== 
	
	@FindBy(xpath="//input[@id='General_Liability_Screen1_ASREndorsement']")
	public static WebElement asr_endorsement;
	
	@FindBy(xpath="//input[@id='General_Liability_Screen1_PerProjectAggregate']")
    public static WebElement per_project_aggregate;
	
	@FindBy(xpath="//input[@id='General_Liability_Screen1_EmployeeBenefits']")
	public static WebElement employee_benefits;
	
	@FindBy(xpath="//input[@id='General_Liability_Screen1_ActionOver']")
	public static WebElement action_over;
	
	@FindBy(xpath="//input[@id='General_Liability_Screen1_ClassificationLimitation']")
	public static WebElement classification_limitation;
	
	@FindBy(xpath="//input[@id='General_Liability_Screen1_Buyback']")
	public static WebElement prior_completed;
	
	@FindBy(xpath="//input[@id='General_Liability_Screen1_SubsidenceExclusion']")
	public static WebElement subsidence_exclusion;
	
	@FindBy(xpath="//input[@id='General_Liability_Screen1_CG2010']")
	public static WebElement insured_endorsement;
	
	@FindBy(xpath="//input[@id='General_Liability_Screen1_chkEandO']")
	public static WebElement workmanship_coverage;
	
	@FindBy(xpath="//input[@id='General_Liability_Screen1_chkInlandMarine']")
	public static WebElement small_equipment_coverage;
	
	@FindBy(xpath="//input[@id='General_Liability_Screen1_CheckBoxHasExistingAmTrustPolicies']")
	public static WebElement available_policy_credits;
	
	//================> Locators for Price Indicators <======================
	
	@FindBy(xpath="//input[@id='Header1_TabControl1_btn42']")
    public static WebElement price_indicator_tab;
	
	@FindBy(xpath="//input[@id='Price_Indicator_Screen1_cbManifestWithoutSunsetYes']")
	public static WebElement manifest_without_sunset_yes;
	
	@FindBy(xpath="//input[@id='Price_Indicator_Screen1_cbManifestWithoutSunsetNo']")
	public static WebElement manifest_without_sunset_no;
	
	@FindBy(xpath="//input[@id='Price_Indicator_Screen1_cbFullWithSunsetYes']")
	public static WebElement occurence_form_with_sunset_yes;
	
	@FindBy(xpath="//input[@id='Price_Indicator_Screen1_cbFullWithSunsetNo']")
	public static WebElement occurence_form_with_sunset_no;
	
	@FindBy(xpath="//input[@id='Price_Indicator_Screen1_cbFullWithoutSunsetYes']")
	public static WebElement occurence_form_without_sunset_yes;
	
	@FindBy(xpath="//input[@id='Price_Indicator_Screen1_cbFullWithoutSunsetNo']")
	public static WebElement occurence_form_without_sunset_no;
	
	@FindBy(xpath="//select[@id='Price_Indicator_Screen1_Limits']")
	public static WebElement pi_select_limit;
	
	@FindBy(xpath="//select[@id='Price_Indicator_Screen1_ddldeductible']")
	public static WebElement pi_deductible;
	
	@FindBy(xpath="//input[@id='Price_Indicator_Screen1_rbTerrorismAccept']")
	public static WebElement terrorism_accept_radio;
	
	@FindBy(xpath="//input[@id='Price_Indicator_Screen1_rbTerrorismDecline']")
	public static WebElement terrorism_decline_radio;
	
	//================> Locators for Eligibility Page (Common Eligibility Questions) <======================
	
	@FindBy(xpath="//input[@id='Header1_TabControl1_btn52']")
	public static WebElement eligibility_page;
	
	@FindBy(xpath="//input[@id='rbCQ_122241']")
	public static WebElement radio_btn1;
	
	@FindBy(xpath="//*[@id='rbCQ_122240']")
    public static WebElement radio_btn2;
	
	@FindBy(xpath="//input[@id='rbCQ_122251']")
	public static WebElement radio_btn3;
	
	@FindBy(xpath="//input[@id='rbCQ_122250']")
	public static WebElement radio_btn4;
	
	@FindBy(xpath="//input[@id='rbCQ_122261']")
	public static WebElement radio_btn5;
	
	@FindBy(xpath="//input[@id='rbCQ_122260']")
	public static WebElement radio_btn6;
	
	@FindBy(xpath="//input[@id='rbCQ_122271']")
	public static WebElement radio_btn7;
	
	@FindBy(xpath="//input[@id='rbCQ_122270']")
	public static WebElement radio_btn8;
	
	@FindBy(xpath="//input[@id='rbCQ_122281']")
	public static WebElement radio_btn9;
	
	@FindBy(xpath="//input[@id='rbCQ_122280']")
	public static WebElement radio_btn10;
	
	@FindBy(xpath="//input[@id='rbCQ_122291']")
	public static WebElement radio_btn11;
	
	@FindBy(xpath="//input[@id='rbCQ_122290']")
	public static WebElement radio_btn12;
	
	@FindBy(xpath="//input[@id='rbCQ_122301']")
	public static WebElement radio_btn13;
	
	@FindBy(xpath="//input[@id='rbCQ_122300']")
	public static WebElement radio_btn14;
	
	@FindBy(xpath="//input[@id='rbCQ_122311']")
	public static WebElement radio_btn15;
	 
	@FindBy(xpath="//input[@id='rbCQ_122310']")
	public static WebElement radio_btn16;
	
	@FindBy(xpath="//input[@id='rbCQ_122321']")
	public static WebElement radio_btn17;
	
	@FindBy(xpath="//input[@id='rbCQ_122320']")
	public static WebElement radio_btn18;
	
	@FindBy(xpath="//input[@id='rbCQ_122331']")
	public static WebElement radio_btn19;
	
	@FindBy(xpath="//input[@id='rbCQ_122330']")
	public static WebElement radio_btn20;
	
	@FindBy(xpath="//input[@id='rbCQ_122341']")
	public static WebElement radio_btn21;
	
	@FindBy(xpath="//input[@id='rbCQ_122340']")
	public static WebElement radio_btn22;
	
	@FindBy(xpath="//input[@id='rbCQ_122351']")
	public static WebElement radio_btn23;
	
	@FindBy(xpath="//input[@id='rbCQ_122350']")
	public static WebElement radio_btn24;
	
	@FindBy(xpath="//input[@id='rbCQ_122361']")
	public static WebElement radio_btn25;
	
	@FindBy(xpath="//input[@id='rbCQ_122360']")
	public static WebElement radio_btn26;
	
	@FindBy(xpath="//input[@id='rbCQ_122371']")
	public static WebElement radio_btn27;
	
	@FindBy(xpath="//input[@id='rbCQ_122370']")
	public static WebElement radio_btn28;
	
	@FindBy(xpath="//input[@id='rbCQ_122381']")
	public static WebElement radio_btn29;
	
	@FindBy(xpath="//input[@id='rbCQ_122380']")
	public static WebElement radio_btn30;
	
	@FindBy(xpath="//input[@id='rbCQ_122391']")
	public static WebElement radio_btn31;
	
	@FindBy(xpath="//input[@id='rbCQ_122390']")
	public static WebElement radio_btn32;
	
	@FindBy(xpath="//input[@id='rbCQ_122401']")
	public static WebElement radio_btn33;
	
	@FindBy(xpath="//input[@id='rbCQ_122400']")
	public static WebElement radio_btn34;
	
	@FindBy(xpath="//input[@id='rbCQ_122411']")
	public static WebElement radio_btn35;
	
	@FindBy(xpath="//input[@id='rbCQ_122410']")
	public static WebElement radio_btn36;
	
	@FindBy(xpath="//input[@id='rbCQ_122421']")
	public static WebElement radio_btn37;
	
	@FindBy(xpath="//input[@id='rbCQ_122420']")
	public static WebElement radio_btn38;
	
	@FindBy(xpath="//input[@id='rbCQ_122431']")
	public static WebElement radio_btn39;
	
	@FindBy(xpath="//input[@id='rbCQ_122430']")
	public static WebElement radio_btn40;
	
	//================> Locators for Eligibility Page (Specific Eligibility Questions) <======================
	
	
	@FindBy(xpath="//input[@id='rbTO_12290__913421']")
	public static WebElement radio_btn41;
	
	@FindBy(xpath="//input[@id='rbTO_12290__913420']")
	public static WebElement radio_btn42;
	
	@FindBy(xpath="//input[@id='rbTO_12291__913421']")
	public static WebElement radio_btn43;
	
	@FindBy(xpath="//input[@id='rbTO_12291__913420']")
	public static WebElement radio_btn44;
	
	@FindBy(xpath="//input[@id='rbTO_12292__913421']")
	public static WebElement radio_btn45;
	
	@FindBy(xpath="//input[@id='rbTO_12292__913420']")
	public static WebElement radio_btn46;
	
	@FindBy(xpath="//input[@id='rbTO_12293__913421']")
	public static WebElement radio_btn47;
	
	@FindBy(xpath="//input[@id='rbTO_12293__913420']")
	public static WebElement radio_btn48;
	
	@FindBy(xpath="//input[@id='rbTO_12294__913421']")
	public static WebElement radio_btn49;
	
    @FindBy(xpath="//input[@id='rbTO_12294__913420']")
	public static WebElement radio_btn50;
    
    @FindBy(xpath="//input[@id='rbTO_12295__913421']")
	public static WebElement radio_btn51;
    
    @FindBy(xpath="//input[@id='rbTO_12295__913420']")
	public static WebElement radio_btn52;
    
    @FindBy(xpath="//input[@id='rbTO_12296__913421']")
	public static WebElement radio_btn53;
    
    @FindBy(xpath="//input[@id='rbTO_12296__913420']")
	public static WebElement radio_btn54;
	
    @FindBy(xpath="//input[@id='rbTO_12297__913421']")
	public static WebElement radio_btn55;
    
    @FindBy(xpath="//input[@id='rbTO_12297__913420']")
	public static WebElement radio_btn56;
    
    @FindBy(xpath="//input[@id='rbTO_12298__913421']")
	public static WebElement radio_btn57;
    
    @FindBy(xpath="//input[@id='rbTO_12298__913420']")
	public static WebElement radio_btn58;
	
    @FindBy(xpath="//input[@id='rbTO_12299__913421']")
	public static WebElement radio_btn59;
    
    @FindBy(xpath="//input[@id='rbTO_12299__913420']")
	public static WebElement radio_btn60;
    
    @FindBy(xpath="//input[@id='rbTO_12300__913421']")
   	public static WebElement radio_btn61;
    
    @FindBy(xpath="//input[@id='rbTO_12300__913420']")
   	public static WebElement radio_btn62;
    
    @FindBy(xpath="//input[@id='rbTO_12301__913421']")
   	public static WebElement radio_btn63;
    
    @FindBy(xpath="//input[@id='rbTO_12301__913420']")
   	public static WebElement radio_btn64;
    
    @FindBy(xpath="//input[@id='rbTO_12302__913421']")
   	public static WebElement radio_btn65;
    
    @FindBy(xpath="//input[@id='rbTO_12302__913420']")
   	public static WebElement radio_btn66;
    
    @FindBy(xpath="//input[@id='rbTO_12303__913421']")
   	public static WebElement radio_btn67;
    
    @FindBy(xpath="//input[@id='rbTO_12303__913420']")
   	public static WebElement radio_btn68;
    
    @FindBy(xpath="//input[@id='rbTO_12304__913421']")
   	public static WebElement radio_btn69;
    
    @FindBy(xpath="//input[@id='rbTO_12304__913420']")
   	public static WebElement radio_btn70;
    
    @FindBy(xpath="//input[@id='rbTO_12305__913421']")
   	public static WebElement radio_btn71;
    
    @FindBy(xpath="//input[@id='rbTO_12305__913420']")
   	public static WebElement radio_btn72;
    
    @FindBy(xpath="//input[@id='rbTO_12306__913421']")
   	public static WebElement radio_btn73;
    
    @FindBy(xpath="//input[@id='rbTO_12306__913420']")
   	public static WebElement radio_btn74;
    
    @FindBy(xpath="//input[@id='rbTO_12307__913421']")
   	public static WebElement radio_btn75;
    
    @FindBy(xpath="//input[@id='rbTO_12307__913420']")
   	public static WebElement radio_btn76;
    
    @FindBy(xpath="//input[@id='rbTO_12308__913421']")
   	public static WebElement radio_btn77;
    
    @FindBy(xpath="//input[@id='rbTO_12308__913420']")
   	public static WebElement radio_btn78;
    
    @FindBy(xpath="//input[@id='rbTO_14766__913421']")
   	public static WebElement radio_btn79;
    
    @FindBy(xpath="//input[@id='rbTO_14766__913420']")
   	public static WebElement radio_btn80;
    
    @FindBy(xpath="//input[@id='rbTO_14856__913421']")
   	public static WebElement radio_btn81; 
    
    @FindBy(xpath="//input[@id='rbTO_14856__913420']")
   	public static WebElement radio_btn82;
    
  //================> Locators for Application Page (Specific Eligibility Questions) <======================
    
  //================> Primary Premise Location Information <======================
    @FindBy(xpath="//input[@id='Header1_TabControl1_btn62']")
    public static WebElement application_tab;
    
    @FindBy(xpath="//span[@id='General_BusinessInfo_Screen1_Label2']//following::td[1]")
    public static WebElement applicant_name;
    
    @FindBy(xpath="//span[@id='General_BusinessInfo_Screen1_Label3']//following::td[1]")
    public static WebElement dba;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_Address']")
    public static WebElement pri_street_address;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_City']")
    public static WebElement primary_city;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_State']")
    public static WebElement pri_state_name;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_ZipCode']")
    public static WebElement pri_zip_code;
    
  //=======================================> Mailing Address Information <====================================
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_SameMailingAddress']")
    public static WebElement same_as_primary_checkbox;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_MailingAddress']")
    public static WebElement mailing_street_address;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_MailingCity']")
    public static WebElement mailing_city;
    
    @FindBy(xpath="//select[@id='General_BusinessInfo_Screen1_MailingState']")
    public static WebElement mailing_state;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_MailingZipCode']")
    public static WebElement mailing_zip_code;
    
    @FindBy(xpath="//span[@id='AddAddressControl1']/u")
    public static WebElement additional_premise;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_Contact']")
    public static WebElement contact_name;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_txtSigningParty']")
    public static WebElement signing_party;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_SpanishSpeaking']")
    public static WebElement spanish_speaking;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_Area']")
    public static WebElement office_phno1;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_Prefix']")
    public static WebElement office_phno2;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_Phone']")
    public static WebElement office_phno3;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_cellArea']")
    public static WebElement cell_phno1;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_cellPrefix']")
    public static WebElement cell_phno2;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_cellPhone']")
    public static WebElement cell_phno3;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_TxtEmail']")
    public static WebElement email_address;
    
    @FindBy(xpath="//select[@id='General_BusinessInfo_Screen1_TypeOfBusinessID']")
    public static WebElement business_type;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_IdentityTheftProtectionContactName']")
    public static WebElement theft_protection;
    
  //=======================================> WebElements of Business Experience <==================================== 
    
    @FindBy(xpath="//select[@id='General_BusinessInfo_Screen1_YearsInBusiness']")
    public static WebElement years_in_business;
    
    @FindBy(xpath="//select[@id='General_BusinessInfo_Screen1_YearsExperience']")
    public static WebElement construction_experience;
    
    @FindBy(xpath="//span[@id='General_BusinessInfo_Screen1_lblGrossReceipts']//following::td[1]")
    public static WebElement annual_gross_receipts;
    
    @FindBy(xpath="//span[@id='General_BusinessInfo_Screen1_Label12']//following::td[1]")
    public static WebElement total_payroll;
    
    @FindBy(xpath="//span[@id='General_BusinessInfo_Screen1_Label18']//following::td[1]")
    public static WebElement sub_contractor_costs;
    
    @FindBy(xpath="//span[@id='General_BusinessInfo_Screen1_Label20']//following::td[1]")
    public static WebElement requested_eff_date;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_ExpireDate']")
    public static WebElement current_gl_policy;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_CarrierName1']")
    public static WebElement carrier_name;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_NoInsurance1']")
    public static WebElement no_insurancecoverage_chkbx;
    
    @FindBy(xpath="//select[@id='General_BusinessInfo_Screen1_NumberOfLosses']")
    public static WebElement gl_noof_losses;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_AmountOfLosses']")
    public static WebElement amount_of_losses;
    
  //=======================================> WebElements of Business Operations <==================================== 
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_Residential']")
    public static WebElement resedential_strct_type;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_Industrial']")
    public static WebElement industrial_strct_type;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_Commercial']")
    public static WebElement commercial_strct_type;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_NewConstruction']")
    public static WebElement new_construction_type;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_ServiceandRepair']")
    public static WebElement service_and_repair_type;
    
    @FindBy(xpath="//span[@id='General_BusinessInfo_Screen1_Label38']//following::td[1]")
    public static WebElement next_12months_val;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_Last12Months']")
    public static WebElement last_12months_txtfield;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_SecondYearPrior']")
    public static WebElement second_year_prior;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_ThirdYearPrior']")
    public static WebElement third_year_prior;
    
    @FindBy(xpath="//textarea[@id='General_BusinessInfo_Screen1_DescriptionOperations']")
    public static WebElement description_of_operations;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_butSubmit']")
    public static WebElement submit_button;
    
    @FindBy(xpath="//input[@id='Footer1_btnPrev']")
    public static WebElement previous_button;
    


//=======================================> WebElements of Submission Info Search table <==================================== 

   @FindBy(xpath="//table[@id='searchTable']//tr//td[1]")
   public static WebElement submission_applicant_name;
   
   @FindBy(xpath="//table[@id='searchTable']//tr//td[2]")
   public static WebElement dba_info;
   
   @FindBy(xpath="//table[@id='searchTable']//tr//td[3]")
   public static WebElement program_name;
   
   @FindBy(xpath="//table[@id='searchTable']//tr//td[4]")
   public static WebElement effective_date;
   
   @FindBy(xpath="//table[@id='searchTable']//tr//td[5]")
   public static WebElement submission_id;
   
   @FindBy(xpath="//table[@id='searchTable']//tr//td[6]")
   public static WebElement application_status;
   
   @FindBy(xpath="//table[@id='searchTable']//tr//td[7]")
   public static WebElement policy_no;
   
   @FindBy(xpath="//table[@id='searchTable']//tr//td[8]")
   public static WebElement submission_contact_name;
   
   @FindBy(xpath="//table[@id='searchTable']//tr//td[9]")
   public static WebElement underwriter;
   
 //================> Review Submission Page locators <======================
   
   @FindBy(xpath="//span[@id='SubmissionID1_lblSubmissionIDValue']")
   public static WebElement review_submission_id;
   
   @FindBy(xpath="//span[@id='lblContact']")
   public static WebElement review_contact;
   
   @FindBy(xpath="//span[@id='lblAgencyName']")
   public static WebElement review_agentname;
   
   @FindBy(xpath="//span[@id='lblContactPhone']")
   public static WebElement review_phone;
   
   @FindBy(xpath="//span[@id='lblSubproducerCode']")
   public static WebElement review_subproducercode;
   
   @FindBy(xpath="//span[@id='lblContactEmail']")
   public static WebElement review_email;
   
   // ================> Review application Info <======================
   
   @FindBy(xpath="//td[@id='TdSubmission2']")
   public static WebElement review_sumission_type;
   
   @FindBy(xpath="//td[@id='TdApplicant2']")
   public static WebElement review_appname;
   
   @FindBy(xpath="//td[@id='TdDBA2']")
   public static WebElement review_dbaname;
   
   @FindBy(xpath="//span[@id='General_Liability_Screen1_ValidateEffDate']")
   public static WebElement review_propeffdate;
   
   @FindBy(xpath="//div[@id='ShowState']")
   public static WebElement review_state;
   
   @FindBy(xpath="//td[@id='ZipShowHide']")
   public static WebElement review_zipcode;
   
   @FindBy(xpath="//tr[@id='General_Liability_Screen1_rowTerrByZip']/td[3]")
   public static WebElement review_territory;
   
   @FindBy(xpath="//tr[@id='trNoLicense']/td[3]")
   public static WebElement review_licence_needed;

// ================> Review Rating Criteria Info <======================
   
   @FindBy(xpath="//td[@id='TdLimits2']")
   public static WebElement review_limitsof_insurance;
   
   @FindBy(xpath="//table[@id='trLimits']/tbody/tr[2]/td[3]")
   public static WebElement review_deductible;
   
   @FindBy(xpath="//td[@id='tdGeneralLiabilityScreen']/table[5]/tbody/tr[2]/td[3]")
   public static WebElement review_owners_active;
   
   @FindBy(xpath="//td[@id='tdGeneralLiabilityScreen']/table[5]/tbody/tr[3]/td[3]")
   public static WebElement review_parttime_emp;
   
   @FindBy(xpath="//td[@id='tdGeneralLiabilityScreen']/table[5]/tbody/tr[4]/td[3]")
   public static WebElement reivew_fulltime_emp;
   
   @FindBy(xpath="//td[@id='tdPayrollEmployees']")
   public static WebElement review_totalemp_payroll;
   
   @FindBy(xpath="//td[@id='tdGeneralLiabilityScreen']/table[5]/tbody/tr[6]/td[5]")
   public static WebElement review_leased_emp;
   
   @FindBy(xpath="//td[@id='TdPayRoll']")
   public static WebElement review_payroll_assigned;
   
   @FindBy(xpath="//td[@id='TdSubcontracting2']")
   public static WebElement review_subcontracting_cost;
   
   @FindBy(xpath="//td[@id='TdAnnualGross2']")
   public static WebElement review_annualgross_receipt;
   
   @FindBy(xpath="//div[@id='showExperienceLoss']")
   public static WebElement experience_loss;
   
// ================> Review optional coverages Info <======================
   
   @FindBy(xpath="//td[@id='tdASREndorsement']")
   public static WebElement review_asrendorsement;
   
   @FindBy(xpath="//tr[@id='SHStopGapLiability']/td[2]")
   public static WebElement review_stopgap_liability;
   
   @FindBy(xpath="//tr[@id='trPerProjectAggregate']/td[2]")
   public static WebElement revicew_perproject_aggregate;
   
   @FindBy(xpath="//tr[@id='trEmployeeBenefits']/td[2]")
   public static WebElement review_empbenefirs_liability;
   
   @FindBy(xpath="//tr[@id='trActionOver']/td[2]")
   public static WebElement review_tr_actionover;
   
   @FindBy(xpath="//tr[@id='trClassLimitation']/td[2]")
   public static WebElement review_tr_classlimitation;
   
   @FindBy(xpath="//td[@id='General_Liability_Screen1_rowBuybackk']")
   public static WebElement review_abandoned_work;
   
   @FindBy(xpath="//tr[@id='rowSubsidenceExclusionOption']/td[2]")
   public static WebElement review_subsident_exclusion;
   
   @FindBy(xpath="//tr[@id='trBlanket']/td[2]")
   public static WebElement review_insured_endoresement;
   
   @FindBy(xpath="//tr[@id='trEandO']/td[2]")
   public static WebElement review_errorsandomissions;
   
   @FindBy(xpath="//tr[@id='trInlandMarine']/td[2]")
   public static WebElement review_inland_marine;
   
   @FindBy(xpath="//tr[@id='General_Liability_Screen1_trAvailablePolicyCredits']/td/table/tbody/tr[2]/td/table/tbody/tr/td[2]")
   public static WebElement review_available_policycredits;
   
// ================> Review or change limits of insurance <======================
   
   @FindBy(xpath="//tr[@id='trPILimit']/td[3]")
   public static WebElement review_select_limit;
   
   @FindBy(xpath="//span[@id='Price_Indicator_Screen1_valFireDamage']")
   public static WebElement review_damageto_premesis;
   
   @FindBy(xpath="//div[@id='Price_Indicator_Screen1_divPI']/table[2]/tbody/tr[4]/td[3]/span")
   public static WebElement review_medical_payments;
   
  // ================> Review Occurrence form with manifestation provision locators <======================
   
   @FindBy(xpath="//span[@id='Price_Indicator_Screen1_lblGLPremWithoutSunset']")
   public static WebElement review_gl_premium_withoutsunset;
   
   @FindBy(xpath="//span[@id='Price_Indicator_Screen1_lblEandO_Without']")
   public static WebElement review_gl_workmanship_withoutsunset;
   
   @FindBy(xpath="//span[@id='Price_Indicator_Screen1_lblTotalGLPremWithoutSunset']")
   public static WebElement review_gl_totalpremium_withoutsunset;
   
   @FindBy(xpath="//span[@id='Price_Indicator_Screen1_lblModNoTerrorismWithoutSunset']")
   public static WebElement review_gl_terrorismpremium_withoutsunset;
   
   @FindBy(xpath="//span[@id='Price_Indicator_Screen1_lblPolFeeGLWithoutSunset']")
   public static WebElement review_gl_policyfee_withoutsunset;
   
   @FindBy(xpath="//span[@id='Price_Indicator_Screen1_lblTotalGLPolicyNotCovWithoutSunset']")
   public static WebElement review_total_gl_policy;
   
// ================> Review Occurrence form locators <======================
   
   @FindBy(xpath="//span[@id='Price_Indicator_Screen1_lblFO_GLPremWithSunset']")
   public static WebElement review_occurenceformwithsunset_glpremium;
   
   @FindBy(xpath="//span[@id='Price_Indicator_Screen1_lblFO_GLPremWithoutSunset']")
   public static WebElement review_occurenceformwithoutsunset_glpremium;
   
   @FindBy(xpath="//span[@id='Price_Indicator_Screen1_lblEandO_OCC_With']")
   public static WebElement review_occurenceformwithsunset_glworkmanship;
   
   @FindBy(xpath="//span[@id='Price_Indicator_Screen1_lblEandO_OCC_Without']")
   public static WebElement review_occurenceformwithoutsunset_glworkmanship;
   
   @FindBy(xpath="//span[@id='Price_Indicator_Screen1_lblFO_TotalGLPremWithSunset']")
   public static WebElement review_occurenceformwithsunset_gltotalpremium;
   
   @FindBy(xpath="//span[@id='Price_Indicator_Screen1_lblFO_TotalGLPremWithoutSunset']")
   public static WebElement review_occurenceformwithoutsunset_gltotalpremium;
   
   @FindBy(xpath="//span[@id='Price_Indicator_Screen1_lblFO_NoTerrorismWithSunset']")
   public static WebElement review_occurenceformwithsunset_terrorismpremium;
   
   @FindBy(xpath="//span[@id='Price_Indicator_Screen1_lblFO_NoTerrorismWithoutSunset2']")
   public static WebElement review_occurenceformwithoutsunset_terrorismpremium;
   
   @FindBy(xpath="//span[@id='Price_Indicator_Screen1_lblFO_PolFeeGLWithSunset']")
   public static WebElement review_occurenceformwithsunset_policyfee;
   
   @FindBy(xpath="//span[@id='Price_Indicator_Screen1_lblFO_PolFeeGLWithoutSunset']")
   public static WebElement review_occurenceformwithoursunset_policyfee;
   
   @FindBy(xpath="//span[@id='Price_Indicator_Screen1_lblFO_TotalGLPolNotCovWithSunset']")
   public static WebElement review_occurenceformwithsunset_totalglpolicy;
   
   @FindBy(xpath="//span[@id='Price_Indicator_Screen1_lblFO_TotalGLPolNotCovWithoutSunset']")
   public static WebElement review_occurenceformwithoutsunset_totalglpolicy;
   
   
   
}