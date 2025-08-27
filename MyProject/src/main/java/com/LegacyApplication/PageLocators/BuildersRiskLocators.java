package com.LegacyApplication.PageLocators;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.LegacyApplication.TestBase.TestBase;

public class BuildersRiskLocators extends TestBase{
	
	public static WebDriver driver;
    public static final Logger log=Logger.getLogger(BuildersRiskLocators.class.getName());
    
  //....................>Builders Risk Locators<<.............................//
    
    @FindBy(xpath="//div[@id='stateAndGroupSelector']//a[contains(normalize-space(text()), 'Builders Risk')]")
    public static WebElement buildersrisk_tab;
    
    @FindBy(xpath="//img[@alt='One Shot Builders Risk']")
    public static WebElement brp_residentialandcommerciallink; 
    
    @FindBy(xpath="//div[@id='startSubmissionGrid']//img[@alt='One Shot Builders Risk']")
    public static WebElement brp_BuilderRiskPrg; 
    
  //....................>>Builders Risk application, project information and optional coverages Locators<<.............................//

    @FindBy(xpath="//span[@id='Header1_SubmissionID1_lblSubmissionID']")
    public static WebElement brp_submissionId;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_ApplicantName']")
    public static WebElement brp_applicantname;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_Dba']")
    public static WebElement brp_dba;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_NamedInsuredContractor']")
    public static WebElement brp_insuredcontractor_yes;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_rbNamedInsuredContractorNo']")
    public static WebElement brp_insuredcontractor_no;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_EffectiveDate']")
    public static WebElement brp_propeffective_date;
    
    @FindBy(xpath="//select[@id='Rating_Screen1_LengthOfProjectId']")
    public static WebElement brp_lengthofproject;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_EstimatedCompletionDate']")
    public static WebElement brp_estimated_completiondate;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_LocationAddress']")
    public static WebElement brp_street_address;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_LocationCity']")
    public static WebElement brp_city;
    
    @FindBy(xpath="//select[@id='Rating_Screen1_LocationStateId']")
    public static WebElement brp_state_drpdwn;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_LocationZipCode']")
    public static WebElement brp_zipcode;
    
    @FindBy(xpath="//select[@id='Rating_Screen1_LocationRegionId']")
    public static WebElement brp_region;
    
    @FindBy(xpath="//select[@id='Rating_Screen1_ProtectionClassId']")
    public static WebElement brp_protection_class;
    
    @FindBy(xpath="//select[@id='Rating_Screen1_StructureTypeId']")
    public static WebElement brp_structure_type;
    
    @FindBy(xpath="//select[@id='Rating_Screen1_ProjectTypeId']")
    public static WebElement brp_project_type;
    
    @FindBy(xpath="//select[@id='Rating_Screen1_ConstructionTypeId']")
    public static WebElement brp_construction_type;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_NewConstructionRenovationRemodelValue' and @type='text']")
    public static WebElement brp_construction_limit;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_MobileManufacturedHome']")
    public static WebElement brp_mobileormanufacturedhome_yes;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_rbMobileManufacturedHomeNo']")
    public static WebElement brp_mobileormanufacturedhome_no;
    
    @FindBy(xpath="//select[@id='Rating_Screen1_TemporaryStorageId']")
    public static WebElement brp_temporary_storage;
    
    @FindBy(xpath="//select[@id='Rating_Screen1_PropertyInTransitId']")
    public static WebElement brp_property_in_transit;
    
    @FindBy(xpath="//select[@id='Rating_Screen1_CommercialSoftCostsId1' and @name='Rating_Screen1:CommercialSoftCostsId1']")
    public static WebElement brp_soft_costs;

    @FindBy(xpath="//select[@id='Rating_Screen1_ResidentialSoftCostsId' and @name='Rating_Screen1:ResidentialSoftCostsId']")
    public static WebElement brp_Residential_soft_costs;
    
    @FindBy(xpath="//select[@id='Rating_Screen1_CommercialSoftCostsId1' and @name='Rating_Screen1:CommercialSoftCostsId1']")
    public static WebElement brp_Commercial_soft_costs;
    
    @FindBy(xpath="//select[@id='Rating_Screen1_CommercialSoftCostsId2' and @name='Rating_Screen1:CommercialSoftCostsId2']")
    public static WebElement brp_Commercial_soft_costs_greaterConstructionLimit;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_PremisesLiabilityIncluded']")
    public static WebElement brp_premisesliability_incuded;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_rbPremisesLiabilityNotIncluded']")
    public static WebElement brp_premisesliability_notincuded;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_btnRateIT']")
    public static WebElement brp_rateitnow_btn;
    
  //....................>Builders Risk application page Locators<<.............................//
    
    @FindBy(xpath="//input[@id='Header1_TabControl1_btn32' and @value='Application  ']")
    public static WebElement brp_application_tab;
    
    @FindBy(xpath="//input[@id='Header1_TabControl1_btn22' and @value='Price Indicator  ']")
    public static WebElement brp_priceIndicator_tab;
    
  //--------------------------Application Page -Eligibility Questions----------------------//
    
    @FindBy(xpath="//input[@id='rbCM_14887__00']")
    public static WebElement br_elgiqutn1_optn_no;
    
    @FindBy(xpath="//input[@id='rbCM_14888__00']")
    public static WebElement br_elgiqutn2_optn_no;
    
    @FindBy(xpath="//input[@id='rbCM_14889__01']")
    public static WebElement br_elgiqutn3_optn_yes;
    
    @FindBy(xpath="//input[@id='rbCM_14890__00']")
    public static WebElement br_elgiqutn4_optn_no;
    
    @FindBy(xpath="//input[@id='rbCM_14891__00']")
    public static WebElement br_elgiqutn5_optn_no;
    
    @FindBy(xpath="//input[@id='rbCM_14892__00']")
    public static WebElement br_elgiqutn6_optn_no;
    
    @FindBy(xpath="//input[@id='rbCM_14893__00']")
    public static WebElement br_elgiqutn7_optn_no;
    
    @FindBy(xpath="//input[@id='rbCM_14894__00']")
    public static WebElement br_elgiqutn8_optn_no;
    
    @FindBy(xpath="//input[@id='rbCM_14895__00']")
    public static WebElement br_elgiqutn9_optn_no;
    
    @FindBy(xpath="//input[@id='rbCM_14896__00']")
    public static WebElement br_elgiqutn10_optn_no;
    
    @FindBy(xpath="//input[@id='rbCM_14897__80']")
    public static WebElement br_elgiqutn11_optn_no;
    
  //-------------------------->   Application Page -Project Info       <----------------------//
    
    //after fill wild score from Admin this field disappear.
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_SpeculativeDwelling']")
    public static WebElement br_application_dwelling_speculative_radio;
    
    //after fill wild score from Admin this field disappear.
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_rbSpeculativeDwellingNo']")
    public static WebElement br_application_dwelling_presold_radio;  
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_LocationCounty']")
    public static WebElement br_application_county_txtbox ;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_WildFireScore']")
    public static WebElement br_application_fireScore_txtbox;
    
    //after fill wild score from Admin this field disappear.
    @FindBy(xpath="//select[@id='General_BusinessInfo_Screen1_NumberOfUnitsId']")
    public static WebElement br_application_noofUnits_drodown;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_TotalSquareFootage']")
    public static WebElement br_application_totalsquarefootage_txtbox;
     
    @FindBy(xpath="//select[@id='General_BusinessInfo_Screen1_NumberOfStoriesId']")
    public static WebElement  br_application_noofstories_drodown;
    
    @FindBy(xpath="//select[@id='General_BusinessInfo_Screen1_AnticipatedOccupancyId']")
    public static WebElement br_application_anticipatedoccupancy_drodown;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_DistanceToNearestFireHydrant']")
    public static WebElement  br_application_firehydrant_txtbox;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_DistanceToNearestFireStation']")
    public static WebElement br_application_firestation_txtbox;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_JobSiteSecurityPrivatePatrol']")
    public static WebElement br_application_privatepatrol_checkbox;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_JobSiteSecurityFence']")
    public static WebElement br_application_fence_checkbox;
     
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_JobSiteSecurityLights']")
    public static WebElement br_application_Lights_checkbox;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_JobSiteSecurityCamera']")
    public static WebElement br_application_camera_checkbox;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_JobSiteSecurityWatchman']")
    public static WebElement br_application_watchman_checkbox;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_JobSiteSecurityNone']")
    public static WebElement br_application_none_chckbox;
            
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_JobSiteSecurityOther']")
    public static WebElement br_application_other_checkbox;
    
    @FindBy(xpath="//textarea[@id='General_BusinessInfo_Screen1_DescriptionOfProject']")
    public static WebElement br_application_description_txtbox;
    
    //-------------------------->   Application Page -Applicant Info   <----------------------//  
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_ApplicantName']")
    public static WebElement br_application_Insuredname_txtbox;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_DBA']")
    public static WebElement br_application_dba_txtbox;
                  
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_InsuredAddress']")
    public static WebElement br_application_streetaddress_txtbox;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_InsuredCity']")
    public static WebElement br_application_city_txtbox;

    @FindBy(xpath="//select[@id='General_BusinessInfo_Screen1_InsuredStateId']")
    public static WebElement br_application_state_drpdwn;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_InsuredZipCode']")
    public static WebElement br_application_zip_txtbox;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_InsuredContactName']")
    public static WebElement br_application_contactname_txtbox;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_InsuredPhone']")
    public static WebElement br_application_contactphone_txtbox;
                  
    @FindBy(xpath="//select[@id='General_BusinessInfo_Screen1_TypeOfBusinessId']")
    public static WebElement br_application_typebusiness_dropdwn;
    
    @FindBy(xpath="//select[@id='General_BusinessInfo_Screen1_TypeOfEntityId']")
    public static WebElement br_application_entity_dropdwn;   
    
  //-------------------------->    Application Page -Contractor Information     <----------------------//
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_ContractorName']")
    public static WebElement br_application_contractorname_txtbox;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_ContractorLicenseNumber']")
    public static WebElement br_application_licenseno_txtbox ;
    
    @FindBy(xpath="//select[@id='General_BusinessInfo_Screen1_ContractorsYearsExperienceId']")
    public static WebElement br_application_contyeraexp_dropdwn;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_ContractorAddress']")
    public static WebElement br_application_contaddress_txtbox;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_ContractorCity']")
    public static WebElement br_application_contcity_txtbox;
                  
    @FindBy(xpath="//select[@id='General_BusinessInfo_Screen1_ContractorStateId']")
    public static WebElement br_application_contststate_dropdwn;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_ContractorZipCode']")
    public static WebElement br_application_contzip_txtbox ;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_LossPayee']")
    public static WebElement br_application_losspayee_checkbox;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_Mortgagee']")
    public static WebElement br_application_mortgagee_checkbox;
    
    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_AdditionalInsured']")
    public static WebElement br_application_addInsured_checkbox;
    
    @FindBy(xpath="//input[@id='Footer1_NextPrev1_btnPrev']")
    public static WebElement br_application_previous_btn;
    
    @FindBy(xpath="//input[@id='Footer1_NextPrev1_btnNext']")
    public static WebElement br_application_next_btn;
    
    @FindBy(xpath="//input[@id='btnSubmit']")
    public static WebElement br_finalReview_submission_btn;
    
    @FindBy(xpath="//tr[@id='trReview']//input[@id='cbReviewed']/following-sibling::b")
    public static WebElement br_policyIssue_detail;
    
    @FindBy(xpath="//tr[@id='trReview']//input[@id='cbReviewed' and @type='checkbox']")
    public static WebElement br_policyIssue_chkb;
    
    @FindBy(xpath="//input[@id='btnIssue' and @name='btnIssue']")
    public static WebElement br_policyIssue_btn;
    
    @FindBy(xpath="//input[@id='btnPolicyIssuanceIssue' and @value='Issue']")
    public static WebElement br_policyIssue_popup_btn;
    
    @FindBy(xpath="//input[@id='btnPolicyIssuanceCancel' and @value='Cancel']")
    public static WebElement br_policyIssueCancel_popup_btn;
    
    @FindBy(xpath="//input[@id='Header1_TabControl1_btn42'][@url='Final_Review.aspx' and @type='submit']")
    public static WebElement  FinalReviewTab;
}
