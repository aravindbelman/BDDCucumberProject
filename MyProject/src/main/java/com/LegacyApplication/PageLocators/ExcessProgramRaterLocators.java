package com.LegacyApplication.PageLocators;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExcessProgramRaterLocators {
	public static WebDriver driver;
	public static final Logger log=Logger.getLogger(ExcessProgramRaterLocators.class.getName());
	
	//....................>>Excess Program rater Locators<<.............................//
	
	//---------------------------TestData Available in TLS1.2 ----------------------------//
	
	 @FindBy(xpath="//div[@id='stateAndGroupSelector']/descendant::*[6]")
	 public static WebElement ex_tab;
	
	 @FindBy(xpath="//img[@alt='Excess Rater']")
	 public static WebElement ex_link;
	 
	//....................Excess Program rater auto_rating info.locators<<.............................//
	       
		
	 	@FindBy(xpath="//span[@id='Header1_SubmissionID1_lblSubmissionID']")
	 	public static WebElement ex_application_quote_no;
	 
	 	@FindBy(xpath="//input[@id='Rating_Screen1_rbBoundWithBTISYes']")
	    public static WebElement ex_yes_radio;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_rbBoundWithBTISNo']")
	    public static WebElement ex_no_radio;
	    
	    @FindBy(xpath="//select[@id='Rating_Screen1_SubmissionTypeId']")
	    public static WebElement ex_submissiontype_drpdwn;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_ApplicantName']")
	    public static WebElement ex_applicantname_txtb;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_Dba']")
	    public static WebElement ex_dbaname_txtb;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_EffectiveDate']")
	    public static WebElement ex_effectivedate;
	    
	    @FindBy(xpath="//select[@id='Rating_Screen1_StateId']")
	    public static WebElement ex_state_drpdwn;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_ZipCode']")
	    public static WebElement ex_zip_txtb;
	    
	    @FindBy(xpath="//select[@id='Rating_Screen1_ClassificationTypeId']")
	    public static WebElement ex_classtype_drpdwn;
	    
	    //after selecting classificationType
	    
	    @FindBy(xpath="//select[@id='Rating_Screen1_ContractorClassId']")
	    public static WebElement ex_classifaction_drpdwn;
	    
	    @FindBy(xpath="//select[@id='Rating_Screen1_ExcessCoverageLimit']")
	    public static WebElement ex_coveragelimit_drpdwn;
	    
	    @FindBy(xpath="//select[@id='Rating_Screen1_ExcessCoverageOver']")
	    public static WebElement ex_coverageover_drpdwn;
	    
	    //if you choose General Liability as Coverage Over
	    
	    @FindBy(xpath="//select[@id='Rating_Screen1_UnderlyingGllimits']")
	    public static WebElement ex_underlying_glLimits_drpdwn;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_UnderlyingGlpremium']")
	    public static WebElement ex_underlying_glPremium_txtb;
	    
	    //if you choose General Liability and Auto as Coverage Over
	    // ex_underlying_glLimits_drpdwn &  ex_underlying_glPremium_txtb
	    // some more fields added
	    
		
	    @FindBy(xpath="//select[@id='Rating_Screen1_UnderlyingWorkCompLimits']")
	    public static WebElement ex_Underlying_WorkCompLimits_drpdwn;

	    @FindBy(xpath="//select[@id='Rating_Screen1_UnderlyingAutoLimit']")
	    public static WebElement ex_AutoLimit_drpdwn;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_UnderlyingAutoPremium']")
	    public static WebElement ex_AutoLiabilityPremium_txtb;
	    
	    @FindBy(xpath="//select[@id='Rating_Screen1_HiredAndNonOwnedAuto']")
	    public static WebElement ex_hired_nonOwnAuto_drpdwn;
	    
	    //Private passenger(Include Hired & Non owned)
	    @FindBy(xpath="//input[@id='Rating_Screen1_VehiclesPrivateLocal']")
	    public static WebElement ex_privatepassenger_0_50_txtb;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_VehiclesPrivateIntermediate']")
	    public static WebElement ex_privatepassenger_51_200_txtb;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_VehiclesPrivateLong']")
	    public static WebElement ex_privatepassenger_200above_txtb;
	    
	    // Light Trucks 0 to 10,000 lbs.
	    @FindBy(xpath="//input[@id='Rating_Screen1_VehiclesLightLocal']")
	    public static WebElement ex_lightTruck_0_50_txtb;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_VehiclesLightIntermediate']")
	    public static WebElement ex_lightTruck_51_200_txtb;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_VehiclesLightLong']")
	    public static WebElement ex_lightTruck_200above_txtb;
	    
	    //Medium Trucks 10,001 to 20,000 lbs.
	    @FindBy(xpath="//input[@id='Rating_Screen1_VehiclesMediumLocal']")
	    public static WebElement ex_mediumTruck_0_50_txtb;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_VehiclesMediumIntermediate']")
	    public static WebElement ex_mediumTruck_51_200_txtb;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_VehiclesMediumLong']")
	    public static WebElement ex_mediumTruck_200above_txtb;
	    
	    //Heavy Trucks 20,001 to 45,000 lbs.
	    @FindBy(xpath="//input[@id='Rating_Screen1_VehiclesHeavyLocal']")
	    public static WebElement ex_heavyTruck_0_50_txtb;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_VehiclesHeavyIntermediate']")
	    public static WebElement ex_heavyTruck_51_200_txtb;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_VehiclesHeavyLong']")
	    public static WebElement ex_heavyTruck_200above_txtb;
	    
	    //Extra Heavy Trucks Over 45,000 lbs
	    @FindBy(xpath="//input[@id='Rating_Screen1_VehiclesExtraHeavyLocal']")
	    public static WebElement ex_ExtraheavyTruck_0_50_txtb;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_VehiclesExtraHeavyIntermediate']")
	    public static WebElement ex__ExtraheavyTruck_51_200_txtb;
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_VehiclesExtraHeavyLong']")
	    public static WebElement ex__ExtraheavyTruck_200above_txtb;
	    
	    //if you choose General Liability and WorkComp as Coverage Over
	    // ex_underlying_glLimits_drpdwn &  ex_underlying_glPremium_txtb
	    // ex_Underlying_WorkCompLimits_drpdwn
	
	    
	    //if you choose General Liability Auto and WorkComp as Coverage Over
	    // ex_underlying_glLimits_drpdwn &  ex_underlying_glPremium_txtb
	    // rest same as GenralLiability Auto
	    
	    @FindBy(xpath="//input[@id='Rating_Screen1_btnRateIT']")
	    public static WebElement ex_rateitnow_btn;
	    
	    
	    //....................PriceIndicator page locators<<.............................//
	    
	    @FindBy(xpath="//input[@id='Footer1_NextPrev1_btnNext']")
	    public static WebElement ex_priceindNext_btn;
	    
	    @FindBy(xpath="//input[@id='Footer1_NextPrev1_btnPrev']")
	    public static WebElement ex_priceindPrev_btn;
	    
	  //...................Eligibility question locators<<.............................//
	    //-------------------Question no. 1/2/3/8 -YES- value=1 --------------------------------------//
	    
	    
	    @FindBy(xpath="//input[@id='rbCM_14590__01'][@value=1]")
	    public static WebElement ex_eq1yes_radio;
	    @FindBy(xpath="//input[@id='rbCM_14590__00'][@value=0]")
	    public static WebElement ex_eq1no_radio;
	    
	    @FindBy(xpath="//input[@id='rbCM_14591__01'][@value=1]")
	    public static WebElement ex_eq2yes_radio;
	    @FindBy(xpath="//input[@id='rbCM_14591__00'][@value=0]")
	    public static WebElement ex_eq2no_radio;
	    
	    @FindBy(xpath="//input[@id='rbCM_14592__01'][@value=1]")
	    public static WebElement ex_eq3yes_radio;
	    @FindBy(xpath="//input[@id='rbCM_14592__00'][@value=0]")
	    public static WebElement ex_eq3no_radio;
	    
	    @FindBy(xpath="//input[@id='rbCM_14593__01'][@value=1]")
	    public static WebElement ex_eq4yes_radio;
	    @FindBy(xpath="//input[@id='rbCM_14593__00'][@value=0]")
	    public static WebElement ex_eq4no_radio;
	    
	    @FindBy(xpath="//input[@id='rbCM_14594__01'][@value=1]")
	    public static WebElement ex_eq5yes_radio;
	    @FindBy(xpath="//input[@id='rbCM_14594__00'][@value=0]")
	    public static WebElement ex_eq5no_radio;
	    
	    @FindBy(xpath="//input[@id='rbCM_14595__01'][@value=1]")
	    public static WebElement ex_eq6yes_radio;
	    @FindBy(xpath="//input[@id='rbCM_14595__00'][@value=0]")
	    public static WebElement ex_eq6no_radio;
	    
	    @FindBy(xpath="//input[@id='rbCM_14596__01'][@value=1]")
	    public static WebElement ex_eq7yes_radio;
	    @FindBy(xpath="//input[@id='rbCM_14596__00'][@value=0]")
	    public static WebElement ex_eq7no_radio;
	    
	    @FindBy(xpath="//input[@id='rbCM_14597__01'][@value=1]")
	    public static WebElement ex_eq8yes_radio;
	    @FindBy(xpath="//input[@id='rbCM_14597__00'][@value=0]")
	    public static WebElement ex_eq8no_radio;
	    
	    @FindBy(xpath="//input[@id='rbCM_14598__01'][@value=1]")
	    public static WebElement ex_eq9yes_radio;
	    @FindBy(xpath="//input[@id='rbCM_14598__00'][@value=0]")
	    public static WebElement ex_eq9no_radio;
	    
	    @FindBy(xpath="//input[@id='rbCM_14912__01'][@value=1]")
	    public static WebElement ex_eq10yes_radio;
	    @FindBy(xpath="//input[@id='rbCM_14912__00'][@value=0]")
	    public static WebElement ex_eq10no_radio;
	    
	    
	    @FindBy(xpath="//input[@id='rbCM_14913__01'][@value=1]")
	    public static WebElement ex_eq11yes_radio;
	    @FindBy(xpath="//input[@id='rbCM_14913__00'][@value=0]")
	    public static WebElement ex_eq11no_radio;
	    
	    @FindBy(xpath="//input[@id='rbCM_14914__01'][@value=1]")
	    public static WebElement ex_eq12yes_radio;
	    @FindBy(xpath="//input[@id='rbCM_14914__00'][@value=0]")
	    public static WebElement ex_eq12no_radio;
	    
	    //If you Choose Air Conditioner as Classification
	    
	    @FindBy(xpath="///input[@id='rbTS_14701__4821'][@value=1]")
	    public static WebElement ex_eq13yes_radio;
	    @FindBy(xpath="//input[@id='rbTS_14701__4820'][@value=0]")
	    public static WebElement ex_eq13no_radio;
	    
	    @FindBy(xpath="//input[@id='Footer1_NextPrev1_btnNext']")
	    public static WebElement ex_eleigibilityNext_btn;
	    
	    @FindBy(xpath="//input[@id='Footer1_NextPrev1_btnPrev']")
	    public static WebElement ex_eleigibilityPrev_btn;
	
	    
	 //<-------------------------Application page Locators----------------------------------->// 
	    
	    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_Address']")
	    public static WebElement ex_address_physical_txtb;
	    
	    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_City']")
	    public static WebElement ex_city_txtb;
	    
	    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_SameMailingAddress']")
	    public static WebElement ex_sameasphysical_chkb;
	    
	    @FindBy(xpath="//select[@id='General_BusinessInfo_Screen1_TypeOfBusinessId']")
	    public static WebElement ex_typeofBusiness_drpdwn;
	    
	    @FindBy(xpath="//select[@id='General_BusinessInfo_Screen1_YearsInBusinessId']")
	    public static WebElement ex_yearinBusiness_drpdwn;
	    
	    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_NumberOfEmployees']")
	    public static WebElement ex_noofEmployee_txtb;
	    
	    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_SubContractingCosts']")
	    public static WebElement ex_subCont_cost_txtb;
	    
	    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_TypeOfSubcontractedWork']")
	    public static WebElement ex_type_of_subCont_work_txtb;
	  
	    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_OneYearGrossReceipts']")
	    public static WebElement ex_annualGross_Receipt_txtb;
	    
	    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_UnderlyingGlcarrier']")
	    public static WebElement ex_gl_carrier_txtb;
	    
	    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_UnderlyingGlpolicyNumber']")
	    public static WebElement ex_gl_policyNo_txtb;
	    
	    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_UnderlyingGlexpirationDate']")
	    public static WebElement ex_gl_expDate_txtb;
	    
	    @FindBy(xpath="//select[@id='General_BusinessInfo_Screen1_PerProjectAggregateEndorsement']")
	    public static WebElement ex_project_aggregate_endorse_drpdwn;
	    
	    @FindBy(xpath="//select[@id='General_BusinessInfo_Screen1_GlhiredAndNonOwnedAutoLimit']")
	    public static WebElement ex_hire_nonHired_autoLimit_drpdwn;
	    
	    @FindBy(xpath="//textarea[@id='General_BusinessInfo_Screen1_DescriptionOperations']")
	    public static WebElement ex_descriptionOperation_txtb;
	    
	    @FindBy(xpath="//input[@id='General_BusinessInfo_Screen1_butSubmit']")
	    public static WebElement ex_submitUnderwriting_btn;
}
