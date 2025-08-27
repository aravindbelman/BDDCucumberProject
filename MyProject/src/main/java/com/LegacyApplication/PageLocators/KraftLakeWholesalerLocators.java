package com.LegacyApplication.PageLocators;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.LegacyApplication.TestBase.TestBase;

public class KraftLakeWholesalerLocators extends TestBase {
	
	public static WebDriver driver;
    public static final Logger log=Logger.getLogger(KraftLakeWholesalerLocators.class.getName());
    
//....................> Kraft Lake login Locators<<.............................//
    
    @FindBy(xpath="//input[@id='KraftCode']")
    public static WebElement kl_ownerscode_txtbox;
    
    @FindBy(xpath="//input[@id='Submit']")
    public static WebElement kl_submit_btn;
  
    //....................>Kraft Lake_ submission options Locators<<.............................//
    
    @FindBy(xpath="//input[@id='btnStartGLSubmission']")
    public static WebElement kl_glsubmission_btn;
     
    @FindBy(xpath="//input[@id='btnStartBondsSubmission']")
    public static WebElement  kl_bondsubmission_btn;
	
	
    @FindBy(xpath="//input[@id='btnStartWCSubmission']")
    public static WebElement kl_wcsubmission_btn;
     
    @FindBy(xpath="//input[@id='MainContent_btnAmTrustForms']")
    public static WebElement  kl_admitedglform_btn;
    
    @FindBy(xpath="//input[@id='MainContent_btnAcordForms']")
    public static WebElement kl_glaccordform_btn;
     
    @FindBy(xpath="//input[@id='btnMakePayment']")
    public static WebElement  kl_glpaymentonline_btn;
	
  //....................>Kraft Lake_gl_applicant info_ Locators<<.............................//
    
    @FindBy(xpath="//select[@id='General_Liability_Screen1_SubmissionType']")
    public static WebElement kl_gl_submissiontype_drpdown;
    
    @FindBy(xpath="//input[@id='General_Liability_Screen1_ApplicantName']")
    public static WebElement kl_gl_applicantname_txtbox;
    
    @FindBy(xpath="//input[@id='General_Liability_Screen1_DBA']")
    public static WebElement kl_gl_dbaname_txtbox;
    
    @FindBy(xpath="//input[@id='General_Liability_Screen1_EffectiveDate']")
    public static WebElement kl_gl_proposeddate;
    
    @FindBy(xpath="//select[@id='General_Liability_Screen1_State']")
    public static WebElement kl_gl_state_drpdown;
    
    @FindBy(xpath="//input[@id='General_Liability_Screen1_ZipCodeGL']")
    public static WebElement kl_gl_zip_txtbox;
    
    @FindBy(xpath="//input[@id='General_Liability_Screen1_GLContractorLicense']")
    public static WebElement kl_gl_license_txtbox;
    
    @FindBy(xpath="//input[@id='General_Liability_Screen1_NoLicenseNeeded']")
    public static WebElement kl_gl_nolicenceNeeded_chkbx;
    
  //....................>Kraft Lake_gl_General Liability Rating Criteria _ Locators<<.............................//
    
    @FindBy(xpath="//select[@id='General_Liability_Screen1_Limits']")
    public static WebElement kl_gl_limitofinsurance_drpdown;
    

    @FindBy(xpath="//select[@id='General_Liability_Screen1_selectDeductible']")
    public static WebElement kl_gl_deductible_drpdwn;
    
    @FindBy(xpath="//input[@id='General_Liability_Screen1_Owners']")
    public static WebElement kl_gl_owners_activefield_txtbx;
    
    @FindBy(xpath="//input[@id='General_Liability_Screen1_PayrollEmployees']")
    public static WebElement kl_gl_annual_emp_payroll;
    
    @FindBy(xpath="//input[@id='General_Liability_Screen1_PayrollEmployees']")
    public static WebElement kl_gl_payrollsofemployee_txtbox;
    
    @FindBy(xpath="//input[@id='General_Liability_Screen1_SubcontractingCosts']")
    public static WebElement kl_gl_subcontractingcost_txtbox;
    
    @FindBy(xpath="//input[@id='General_Liability_Screen1_OneYearGrossReceipts']")
    public static WebElement kl_gl_grossrecipt_txtbox;
    
    @FindBy(xpath="//select[@id='General_Liability_Screen1_Classification1']")
    public static WebElement kl_gl_class1_drpdown;
    
    @FindBy(xpath="//input[@id='General_Liability_Screen1_PayrollPercentage1']")
    public static WebElement kl_gl_percent1_txtbox;
    
    @FindBy(xpath="//input[@id='General_Liability_Screen1_btnAdditional']")
    public static WebElement k_gl_addclass_btn;
    
    @FindBy(xpath="//select[@id='General_Liability_Screen1_Classification2']")
    public static WebElement kl_gl_class2_drpdown;
    
    @FindBy(xpath="//input[@id='General_Liability_Screen1_PayrollPercentage2']")
    public static WebElement kl_gl_percent2_txtbox;
    
    @FindBy(xpath="//select[@id='General_Liability_Screen1_Classification3']")
    public static WebElement kl_gl_class3_drpdown;
    
    @FindBy(xpath="//input[@id='General_Liability_Screen1_PayrollPercentage3']")
    public static WebElement kl_gl_percent3_txtbox;
    
    @FindBy(xpath="//select[@id='General_Liability_Screen1_Classification4']")
    public static WebElement kl_gl_class4_drpdown;
    
    @FindBy(xpath="//input[@id='General_Liability_Screen1_PayrollPercentage4']")
    public static WebElement kl_gl_percent4_txtbox;
    
    @FindBy(xpath="//select[@id='General_Liability_Screen1_ExperienceLoss']")
    public static WebElement  kl_gl_businessexp_drpdwn;
   
    //....................>Kraft Lake_gl_optional coverage _ Locators<<.............................//
    
    @FindBy(xpath="//input[@id='General_Liability_Screen1_ASREndorsement']")
    public static WebElement kl_gl_creditavailable_chkbox;
    
    @FindBy(xpath="//input[@id='General_Liability_Screen1_PerProjectAggregate']")
    public static WebElement kl_gl_projectaggreate_chkbox;
    
    @FindBy(xpath="//input[@id='General_Liability_Screen1_EmployeeBenefits']")
    public static WebElement kl_gl_employeebenefit_chkbox;
     
    @FindBy(xpath="//input[@id='General_Liability_Screen1_ActionOver']")
    public static WebElement kl_gl_actionover_chkbox;
    
    @FindBy(xpath="//input[@id='General_Liability_Screen1_ClassificationLimitation']")
    public static WebElement kl_gl_limitation_chkbox;
    
    @FindBy(xpath="//input[@id='General_Liability_Screen1_Buyback']")
    public static WebElement kl_gl_workexclusion_chkbox;
    
    @FindBy(xpath="//input[@id='General_Liability_Screen1_SubsidenceExclusion']")
    public static WebElement kl_gl_subsidence_chkbox;
    
    @FindBy(xpath="//input[@id='General_Liability_Screen1_CG2010']")
    public static WebElement kl_gl_insuredEndorsement_chkbox;
    
    @FindBy(xpath="//input[@id='General_Liability_Screen1_chkEandO']")
    public static WebElement kl_gl_workmanship_chkbox;
    
    @FindBy(xpath="//input[@id='General_Liability_Screen1_chkInlandMarine']")
    public static WebElement kl_gl_Inlandmarine_chkbox;
    
    @FindBy(xpath="//input[@id='General_Liability_Screen1_CheckBoxHasExistingAmTrustPolicies']")
    public static WebElement kl_gl_availiablepolicycredit_chkbox;
   
    @FindBy(xpath="//input[@id='General_Liability_Screen1_checkBoxDeclinedByFarmers']")
    public static WebElement kl_gl_declinedbyarmerschkbox_chkbox;
    
    @FindBy(xpath="//input[@id='General_Liability_Screen1_btnRateIT']")
    public static WebElement kl_gl_rateitnow_btn;
    
    //....................>Kraft Lake_gl_priceindicator _ Locators<<.............................//
    
    @FindBy(xpath="//input[@id='Price_Indicator_Screen1_btnNext2']")
    public static WebElement kl_gl_next_btn;
    
    @FindBy(xpath="//input[@id='Price_Indicator_Screen1_btnPrev2']")
    public static WebElement kl_gl_prev_btn;
    
  //....................>Kraft Lake_gl_eligibilityquestion_Locators<<.............................//
    
    @FindBy(xpath="//input[@id='Eligibility_Screen1_chkShowAnswers']")
    public static WebElement kl_gl_eleigibility_chkbox;
    
    @FindBy(xpath="//input[@id='Footer1_btnNext']")
    public static WebElement kl_gl_pi_next_btn;
    
    @FindBy(xpath="//input[@id='Footer1_btnPrev']")
    public static WebElement kl_gl_pi_prev_btn;
    
  //....................>Kraft Lake_gl_Applicationpage_Locators<<.............................//
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_Address']")
    public static WebElement kl_gl_app_streetadd_txtbox;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_City']")
    public static WebElement kl_gl_app_city_txtbox;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_SameMailingAddress']")
    public static WebElement kl_gl_app_sameasprimary_chkbox;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_MailingAddress']")
    public static WebElement kl_gl_app_mailingstreetadd_txtbox;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_MailingCity']")
    public static WebElement kl_gl_app_mailingcityadd_txtbox;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_MailingState']")
    public static WebElement kl_gl_app_mailingstateadd_chkbox;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_MailingZipCode']")
    public static WebElement kl_gl_app_mailingzipadd_txtbox;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_Contact']")
    public static WebElement kl_gl_app_contactname_txtbox;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_txtSigningParty']")
    public static WebElement kl_gl_app_applicantline_txtbox;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_SpanishSpeaking']")
    public static WebElement kl_gl_app_spanish_txtbox ;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_Area']")
    public static WebElement kl_gl_app_off1_txtbox;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_Prefix']")
    public static WebElement kl_gl_app_off2_txtbox;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_Phone']")
    public static WebElement kl_gl_app_off3_txtbox;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_cellArea']")
    public static WebElement kl_gl_app_cell1_txtbox;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_cellPrefix']")
    public static WebElement kl_gl_app_cell2_txtbox;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_cellPhone']")
    public static WebElement kl_gl_app_cell3_txtbox;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_TxtEmail']")
    public static WebElement kl_gl_app_email_txtbox;
    
    @FindBy(xpath="//select[@id='General_BusinessInfo_Screen1_TypeOfBusinessID']")
    public static WebElement kl_gl_app_typeofbusiness_drpdown;
    
    @FindBy(xpath="//select[@id='General_BusinessInfo_Screen1_YearsInBusiness']")
    public static WebElement kl_gl_app_yearinbusiness_drpdown;
    
    @FindBy(xpath="//select[@id='General_BusinessInfo_Screen1_YearsExperience']")
    public static WebElement kl_gl_app_constructionexp_drpdown;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_ExpireDate']")
    public static WebElement kl_gl_app_expirationdate;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_CarrierName1']")
    public static WebElement kl_gl_app_carriername_txtbox;
    
    @FindBy(xpath="//select[@id='General_BusinessInfo_Screen1_NumberOfLosses']")
    public static WebElement kl_gl_app_nolosses_drpdown;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_AmountOfLosses']")
    public static WebElement kl_gl_app_amount_txtbox;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_Residential']")
    public static WebElement kl_gl_app_residential_txtbox;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_Industrial']")
    public static WebElement kl_gl_app_industrial_txtbox;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_Commercial']")
    public static WebElement kl_gl_app_commercial_txtbox;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_NewConstruction']")
    public static WebElement kl_gl_app_newconstruction_txtbox;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_ServiceandRepair']")
    public static WebElement kl_gl_app_servicerepair_txtbox;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_Last12Months']")
    public static WebElement kl_gl_app_last12month_txtbox;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_SecondYearPrior']")
    public static WebElement kl_gl_app_last2yr_txtbox;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_ThirdYearPrior']")
    public static WebElement kl_gl_app_last3yr_txtbox;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_DescriptionOperations']")
    public static WebElement kl_gl_app_description_txtbox;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_butSubmit']")
    public static WebElement kl_gl_app_submit_btn;
    
}
