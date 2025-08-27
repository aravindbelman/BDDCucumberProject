package com.BtisNewUI.Locators;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.LegacyApplication.TestBase.TestBase;

public class CBICLocators extends TestBase{

	public static WebDriver driver;

	public static final Logger log=Logger.getLogger(CBICLocators.class.getName());

	//--------------------------------->>Contact Info Page 1 <<--------------------------------------------/
	
	//===================== Switching Between Pages By Heading Names==============================//
	
	@FindBy(xpath="//a[contains(text(),'Contact Info')]")
	public static WebElement contactInfo_heading_tab;
	
	@FindBy(xpath="//a[contains(text(),'Business Info')]")
	public static WebElement businessInfo_heading_tab;
	
	@FindBy(xpath="//a[contains(text(),'Insurance History')]")
	public static WebElement insuranceHistory_heading_tab;
	
	@FindBy(xpath="//a[contains(text(),'Classifications')]")
	public static WebElement classifications_heading_tab;
	
	@FindBy(xpath="//a[contains(text(),'Pricing')]")
	public static WebElement pricing_heading_tab;
	
	@FindBy(xpath="//a[contains(text(),'Supplemental')]")
	public static WebElement supplemental_heading_tab;	
	
	//======================personal Info==============================//

	@FindBy(xpath="//input[@id='firstName']")
	public static WebElement firstName_txtb;

	@FindBy(xpath="//input[@id='firstName']/following::small//span[contains(text(),'First Name is required.')]")
	public static WebElement first_validation;

	@FindBy(xpath="//input[@id='lastName']")
	public static WebElement lastName_txtb;

	@FindBy(xpath="//input[@id='emailAddress']")
	public static WebElement emailAdd_txtb;

	@FindBy(xpath="//input[@id='emailAddress']/following::small//span[contains(text(),'Email Address is invalid.')]")
	public static WebElement email_validation;

	@FindBy(xpath="//input[@id='phoneNumber']")
	public static WebElement phone_txtb;

	@FindBy(xpath="//input[@id='phoneNumber']/following::small//span[contains(text(),' Please enter Phone Number.')]")
	public static WebElement phone_validation;

	@FindBy(xpath="//input[@id='cellNumber']")
	public static WebElement cellNumber_txtb;

	//=============== applicants business Address===================

	@FindBy(xpath="//input[@id='address']")
	public static WebElement businessAdd_txtb;
	
	@FindBy(xpath="//div[@class='pac-item']//span[@class='pac-matched']")
	public static List<WebElement> businessAdd_List;
	
	@FindBy(xpath="//input[@id='address']/following::small//span[contains(text(),'Please enter Street Address.')]")
	public static WebElement businessAdd_validation;

	@FindBy(xpath="//input[@id='address2']")
	public static WebElement businessAptSuite_txtb;

	@FindBy(xpath="//input[@id='city']")
	public static WebElement businessCity_txtb;

	@FindBy(xpath="//input[@id='city']/following::small//span[contains(text(),'Please enter City.')]")
	public static WebElement businessCity_validation;

	@FindBy(xpath="//select[@id='state']")
	public static WebElement businessState_drpd;

	@FindBy(xpath="//select[@id='state']/following::small//span[contains(text(),'Please select State.')]")
	public static WebElement businessState_validation;

	@FindBy(xpath="//input[@id='zipCode']")
	public static WebElement businessZip_txtb;

	@FindBy(xpath="//input[@id='zipCode']/following::small//span[contains(text(),'Please enter zipCode.')]")
	public static WebElement businessZip_validation;

	//===========Same as Business CheckBox===================

	@FindBy(xpath="//input[@id='sameAddress']")
	public static WebElement smailBusiness_Mailing_chkb;

	//=================Mailing Address=======================

	@FindBy(xpath="//input[@id='_mailingAddress']")
	public static WebElement mailAddress_txtb;

	@FindBy(xpath="//input[@id='_mailingAddress']/following::small//span[contains(text(),'Please enter Street mailing Address.')]")
	public static WebElement mailAddress_validation;

	@FindBy(xpath="//input[@id='mailingAddress']")
	public static WebElement mailingAppt_Suite_txtb;

	@FindBy(xpath="//input[@id='mailingCity']")
	public static WebElement mailCity_txtb;

	@FindBy(xpath="//input[@id='mailingCity']/following::small//span[contains(text(),'Please enter Mailing City.')]")
	public static WebElement mailCity_validation;

	@FindBy(xpath="//select[@id='mailingState']")
	public static WebElement mailState_drpd;

	@FindBy(xpath="//select[@id='mailingState']/following::small//span[contains(text(),'Please select mailing State.')]")
	public static WebElement mailState_validation;

	@FindBy(xpath="//input[@id='mailingZipCode']")
	public static WebElement mailZip_txtb;

	@FindBy(xpath="//input[@id='mailingZipCode']/following::small//span[contains(text(),' Please enter mailingZipCode.')]")
	public static WebElement mailZip_validation;

	//Save & Continue Button

	@FindBy(xpath="//button[@id='submit_button']")
	public static WebElement save_contiunue_btn;

	//--------------------------------->>Business Info Page 2 <<--------------------------------------------//

	//==What is your relation to the business? 

	@FindBy(xpath="//select[@id='businessRelationship']")
	public static WebElement relationToBusiness_drpd;

	@FindBy(xpath="//select[@id='businessRelationship']/following::small//span[contains(text(),' Required.')]")
	public static WebElement relationToBusiness_validation;

	@FindBy(xpath="//select[@id='businessRelationship']/following::a[1]")
	public static WebElement relationToBusiness_info_btn;

	//=====What is the name of the business? 

	@FindBy(xpath="//input[@placeholder='Enter the business name/DBA.']")
	public static WebElement dba_txtb;
	
	@FindBy(xpath="//input[@id='contractorLicense']")
	public static WebElement contractorLicense;

	@FindBy(xpath="//input[@placeholder='Enter the business name/DBA.']/following::small//span[contains(text(),' Required.')]")
	public static WebElement dba_validation;

	//===============What is the structure of the business?

	@FindBy(xpath="//select[@id='type']")
	public static WebElement stractureType_drpd;

	@FindBy(xpath="//select[@id='type']/following::small//span[contains(text(),'Please select a Structure of the Business.')]")
	public static WebElement stractureType_valiation;

	@FindBy(xpath="//select[@id='businessRelationship']/following::a[2]")
	public static WebElement stractureType_info_btn;

	//==========How many owners are active in the field?

	@FindBy(xpath="//input[@id='activeOwners']")
	public static WebElement activeOwners_txt_arrow;

	@FindBy(xpath="//input[@id='activeOwners']/following::span[contains(text(),' There must be at least 1 owner.')]")
	public static WebElement activeOwners_validation;

	@FindBy(xpath="//select[@id='businessRelationship']/following::a[3]")
	public static WebElement activeOwners_info_btn;

	//=======What are your annual gross receipts?

	@FindBy(xpath="//input[@id='annualGrossReceipts']")
	public static WebElement anualGross_txtb;

	@FindBy(xpath="//input[@id='annualGrossReceipts']/following::span[contains(text(),' This is required.')]")
	public static WebElement anualGross_validation;

	@FindBy(xpath="//select[@id='businessRelationship']/following::a[4]")
	public static WebElement anualGross_info_btn;

	//=========Does the applicant have employees?

	@FindBy(xpath="//span[contains(text(),'Does the applicant have employees?')]/following::input[@value='Yes'][1]")
	public static WebElement applicantEmployee_YES;

	@FindBy(xpath="//span[contains(text(),'Does the applicant have employees?')]/following::input[@value='No'][1]")
	public static WebElement applicantEmployee_NO;
	

	//----------------------How many employees does the applicant have?

	@FindBy(xpath="//input[@id='numberOfEmployees']")
	public static WebElement noOfEmployee_txtb;

	//-----------------------------What is the annual employee payroll?

	@FindBy(xpath="//input[@id='annualEmployeePayroll']")
	public static WebElement annualPayroll_txtb;

	//=====Does the applicant hire subcontractors?

	@FindBy(xpath="//span[contains(text(),' Does the applicant hire subcontractors?')]/following::input[@value='Yes'][1]")
	public static WebElement subContractors_YES;

	@FindBy(xpath="//span[contains(text(),' Does the applicant hire subcontractors?')]/following::input[@value='No'][1]")
	public static WebElement subContractors_NO;

	//-------------- What are the annual subcontracting costs

	@FindBy(xpath="//input[@id='annualSubcontractingCosts']")
	public static WebElement annualSubcontractingCosts_txtb;
	
	@FindBy(xpath="//input[@id='annualSubcontractingDwellingsPercentage']")
	public static WebElement annualSubcontractingDwellingsPercentage_txtb;	

	//======The applicant performs residential work prior to the structure being approved for occupancy. Example: New ground-up construction or new custom homes. 

	@FindBy(xpath="//span[contains(text(),'The applicant performs residential work prior to the structure')]/following::input[@value='Yes'][1]")
	public static WebElement residentialWork_Yes;
	
	//If YES===========================
	//Specify the percentage of each type of work the applicant performs prior to approval of occupancy. 
		
	@FindBy(xpath="//span[contains(text(),'The applicant performs residential work prior to the structure')]/following::input[@value='No'][1]")
	public static WebElement residentialWork_No;
	
	@FindBy(xpath="//input[@id='constructionZoneNewPercentage']")
	public static WebElement newPercentage_txtb;
	
	@FindBy(xpath="//input[@id='constructionZoneRemodelingPercentage']")
	public static WebElement remodelingPercentage_txtb;
	
	@FindBy(xpath="//input[@id='constructionZoneTotalPercentage']/following-sibling::input")
	public static WebElement totalPercentage;

	//========================Describe the operations of the business.

	@FindBy(xpath="//textarea [@id='descriptionOfOperations']")
	public static WebElement descibeOperations_txtb;

	//================BusinessInfo PAge2 Save & Continue Btn

	@FindBy(xpath="//button[@id='submitButton']")
	public static WebElement bi_save_contiunue_btn;

	//-------------------------Insurance History page 3------------------------------------

	@FindBy(xpath="//input[@id='effectiveDate']")
	public static WebElement effectiveDate;

	@FindBy(xpath="")
	public static WebElement effevtiveDate_Validation;

	//======What is the applicant's business experience/insurance history? 

	@FindBy(xpath="//select[@id='businessExperience']")
	public static WebElement businessExp_drpd;

	@FindBy(xpath="//select[@id='businessExperience']/following::small//span[contains(text(),' This is required.')]")
	public static WebElement businessExp_validation;

	//==========Has the applicant had general liability coverage in the past?

	@FindBy(xpath="//span[contains(text(),'Has the applicant had general liability coverage in the past?')]/following::input[@value='Yes'][1]")
	public static WebElement coveragePast_YES;

	@FindBy(xpath="//span[contains(text(),'Has the applicant had general liability coverage in the past?')]/following::input[@value='No'][1]")
	public static WebElement coveragePast_NO;

	//-----------------What is the applicant's most recent general liability carrier? 
	@FindBy(xpath="//input[@id='carrier']")
	public static WebElement carrier_txtb;
	
	@FindBy(xpath="//input[@id='carrier']/following::small//span[contains(text(),'Please enter Carrier name.')]")
	public static WebElement carrier_validation;

	//--------What is the expiration date of the applicant's most recent general liability policy? 
	@FindBy(xpath="//input[@id='effectiveDate']")
	public static WebElement expirationDate;
	
	@FindBy(xpath="//select[@id='businessHistoryId']")
	public static WebElement businessYears_drpd;
	
	@FindBy(xpath="//select[@id='constructionExperienceId']")
	public static WebElement industryExp_drpd;
	
	@FindBy(xpath="//input[@id='insuranceEffectiveEndDate']/following::small//span[contains(text(),' Expiration Date is required.')]")
	public static WebElement expirationDate_validation;
	
	
	//==================Page 4 Classifactions============================
	
	@FindBy(xpath="//a[@id='addClassification']")
	public static WebElement addClassification_btn;
	
	@FindBy(xpath="//select[@id='newClassification']")
	public static WebElement newClassification_drpd;
		
	@FindBy(xpath="//button[@id='addButton']")
	public static WebElement addButton_btn;
	
	@FindBy(xpath="//button[@id='cancelButton']")
	public static WebElement cancelButton_btn;
	
	@FindBy(xpath="//input[@id='percentage_1']")
	public static WebElement percent1_txtb;
	
	@FindBy(xpath="//input[@id='percentage_2']")
	public static WebElement percent2_txtb;
	
	@FindBy(xpath="//input[@id='percentage_3']")
	public static WebElement percent3_txtb;
	
	@FindBy(xpath="//input[@id='totalPercentage']")
	public static WebElement totalPercentage_txtb;
	
	@FindBy(xpath="//div[@class='alert alert-danger'][@class=contains(text(),'- Total must equal 100%')]")
	public static WebElement alertTotal_validation;
	
	//=================================  contractorLicense  =======================================
	
	@FindBy(xpath="//input[@id='contractorLicense']")
	public static WebElement contractorLicense_txtb;
	
	//==========================================================
	
	@FindBy(xpath="//h1[@class=contains(text(),'Pricing Options')]/following::h1[@class='text-primary font-weight-bold']")
	public static WebElement pricingOptions_value;
	
	//======================Page 6 Supplemental =====================================
	
	//========How many years of construction experience does the applicant have? 
	
	@FindBy(xpath="//select[@id='constructionExperience']")
	public static WebElement constructionExperience_drpd;
	
	//=====What is the applicant's prior work experience?  if you choose 1 or 2 only
	@FindBy(xpath="//textarea[@id='priorConstructionExperience']")
	public static WebElement priorConstructionExperience_txt;
	
	//==========Does applicant work out of state? 
	
	@FindBy(xpath="//span[contains(text(),'Does applicant work out of state?')]/following::input[@value='Yes']")
	public static WebElement applicantWorkOutOfState_Yes;
	
	@FindBy(xpath="//span[contains(text(),'Does applicant work out of state?')]/following::input[@value='No']")
	public static WebElement applicantWorkOutOfState_No;
	
	//  ==================What state(s)?  if YES choose
	
	@FindBy(xpath="//input[@id='workOutOfStateStates']")
	public static WebElement workOutOfStateStates_txt;
	
	
	//==================% of Work  Each column must add up to 100%

	@FindBy(xpath="//input[@id='residentailWorkPercentage']")
	public static WebElement residentailWorkPercentage_txtb;
	
	@FindBy(xpath="//input[@id='commercialWorkPercentage']")
	public static WebElement commercialWorkPercentage_txtb;
	
	@FindBy(xpath="//input[@id='industrialWorkPercentage']")
	public static WebElement industrialWorkPercentage_txtb;
	
	@FindBy(xpath="//input[@id='manufacturingWorkPercentage']")
	public static WebElement manufacturingWorkPercentage_txtb;
	
	@FindBy(xpath="//input[@id='newConstructionTypePercentage']")
	public static WebElement newConstructionTypePercentage_txtb;
	
	@FindBy(xpath="//input[@id='remodelTypePercentage']")
	public static WebElement remodelTypePercentage_txt;
	
	@FindBy(xpath="//input[@id='serviceRepairTypePercentage']")
	public static WebElement serviceRepairTypePercentage_txtb;
	
	//=-==========Do you plan to use subcontractors within the next year? ==
	
	@FindBy(xpath="//span[contains(text(),'Do you plan to use subcontractors within the next year?')]/following::input[@value='Yes']")
	public static WebElement planToUseSubcontaractorNxtYear_Yes_btn;
	
	@FindBy(xpath="//span[contains(text(),'Do you plan to use subcontractors within the next year?')]/following::input[@value='No']")
	public static WebElement planToUseSubcontaractorNxtYear_No_btn;
		
	//================== Prior Carrier Information===============
	
	@FindBy(xpath="//input[@id='carrierInfo1StartDate']")
	public static WebElement carrierInfo1StartDate_txtb;
	
	@FindBy(xpath="//input[@id='carrierInfo1EndDate']")
	public static WebElement carrierInfo1EndDate_txtb;
	
	@FindBy(xpath="//input[@id='carrierInfo1Name']")
	public static WebElement carrierInfo1Name_txtb;
	
	@FindBy(xpath="//input[@id='carrierInfo1PolicyNumber']")
	public static WebElement carrierInfo1PolicyNumber_txtb;
	
	
	//==================
	@FindBy(xpath="//input[@id='carrierInfo2StartDate']")
	public static WebElement carrierInfo2StartDate_txtb;
	
	@FindBy(xpath="//input[@id='carrierInfo2EndDate']")
	public static WebElement carrierInfo2EndDate_txtb;
	
	@FindBy(xpath="//input[@id='carrierInfo2Name']")
	public static WebElement carrierInfo2Name_txtb;
	
	@FindBy(xpath="//input[@id='carrierInfo2PolicyNumber']")
	public static WebElement carrierInfo2PolicyNumber_txtb;
	
	//===================
	@FindBy(xpath="//input[@id='carrierInfo3StartDate']")
	public static WebElement carrierInfo3StartDate_txtb;
	
	@FindBy(xpath="//input[@id='carrierInfo3EndDate']")
	public static WebElement carrierInfo3EndDate_txtb;
	
	@FindBy(xpath="//input[@id='carrierInfo3Name']")
	public static WebElement carrierInfo3Name_txtb;
	
	@FindBy(xpath="//input[@id='carrierInfo3PolicyNumber']")
	public static WebElement carrierInfo3PolicyNumber_txtb;
	
	//=======================Subcontractors=============================

	@FindBy(xpath="//input[@id='useSubcontractorsNextYearTrades']")
	public static WebElement useSubcontractorsNextYearTrades_txtb;
	
	@FindBy(xpath="//input[@id='subcontractorCompliance1']")
	public static WebElement subcontractorCompliance1_chkb;
	
	@FindBy(xpath="//input[@id='subcontractorCompliance2']")
	public static WebElement subcontractorCompliance2_chkb;
	
	@FindBy(xpath="//input[@id='subcontractorCompliance3']")
	public static WebElement subcontractorCompliance3_chkb;
	
	@FindBy(xpath="//input[@value='Electrical']")
	public static WebElement Electrical_chkb;
	
	@FindBy(xpath="//input[@value='Drywall']")
	public static WebElement Drywall_chkb;
	
	@FindBy(xpath="//input[@value='Concrete']")
	public static WebElement Concrete_chkb;
	
	
	
	//===========Has the applicant had any prior claims? 
	
	@FindBy(xpath="//span[contains(text(),'Has the applicant had any prior claims?')]/following::input[@value='Yes']")
	public static WebElement applicantHadAnyPrioeClaim_Yes_btn;
	
	@FindBy(xpath="//span[contains(text(),'Has the applicant had any prior claims?')]/following::input[@value='No']")
	public static WebElement applicantHadAnyPrioeClaim_No_btn;
	
	//==============if YES=======
	
	@FindBy(xpath="//input[@id='priorClaims1Year']")
	public static WebElement priorClaims1Year_txtb;
	
	@FindBy(xpath="//input[@id='priorClaims1Nature']")
	public static WebElement priorClaims1Nature_txtb;
	
	@FindBy(xpath="//input[@id='priorClaims1Outcome']")
	public static WebElement priorClaims1Outcome_txtb;
	
	//=====================
	@FindBy(xpath="//input[@id='priorClaims2Year']")
	public static WebElement priorClaims2Year_txtb;
	
	@FindBy(xpath="//input[@id='priorClaims2Nature']")
	public static WebElement priorClaims2Nature_txtb;
	
	@FindBy(xpath="//input[@id='priorClaims2Outcome']")
	public static WebElement priorClaims2Outcome_txtb;
	
	//=====================List the applicant’s 3 largest jobs in the past 5 years or currently underway or planned.
	
	@FindBy(xpath="//input[@id='largestJob1Year']")
	public static WebElement largestJob1Year_txtb;
	
	@FindBy(xpath="//input[@id='largestJob1Description']")
	public static WebElement largestJob1Description_txtb;
	
	@FindBy(xpath="//input[@id='largestJob1Receipts']")
	public static WebElement largestJob1Receipts_txtb;
	
	//======================
	
	@FindBy(xpath="//input[@id='largestJob2Year']")
	public static WebElement largestJob2Year_txtb;
	
	@FindBy(xpath="//input[@id='largestJob2Description']")
	public static WebElement largestJob2Description_txtb;
	
	@FindBy(xpath="//input[@id='largestJob2Receipts']")
	public static WebElement largestJob2Receipts_txtb;
	
	//=====================
	
	@FindBy(xpath="//input[@id='largestJob3Year']")
	public static WebElement largestJob3Year_txtb;
	
	@FindBy(xpath="//input[@id='largestJob3Description']")
	public static WebElement largestJob3Description_txtb;
	
	@FindBy(xpath="//input[@id='largestJob3Receipts']")
	public static WebElement largestJob3Receipts_txtb;
	
	//=========Check all of the following that describes applicant’s operation
	
	
	@FindBy(xpath="//label[contains(text(),'Construction consultant to owners')]")
	public static WebElement constructionConsultant_chkb;
	
	@FindBy(xpath="//label[contains(text(),'Developer/owner of land/buildings')]")
	public static WebElement developer_chkb;
	
	@FindBy(xpath="//label[contains(text(),'Developer of land only')]")
	public static WebElement developerOfLandOnly_chkb;
	
	@FindBy(xpath="//label[contains(text(),'hired by developers')]")
	public static WebElement hiredby_chkb;
	
	@FindBy(xpath="//label[contains(text(),'hired by property owner')]")
	public static WebElement propertyOwner_chkb;
	
	@FindBy(xpath="//label[contains(text(),'property owner hires the subcontractors')]")
	public static WebElement subcontractors_chkb;
	
	@FindBy(xpath="//label[contains(text(),'speculative builder')]")
	public static WebElement speculative_builder_chkb;
	
	@FindBy(xpath="//label[contains(text(),'Subcontractor performing one or two trades')]")
	public static WebElement performing_one_two_chkb;
	
	//=============Estimate the number of jobs performed annually (indicate Zero "0" if none):
	
	@FindBy(xpath="//label[contains(text(),'Total jobs completed annually')]/preceding::input[@id='annualJobEstimate1']")
	public static WebElement Totaljobscompletedannually_txtb;
	
	@FindBy(xpath="//label[contains(text(),'New homes built in any one tract')]/preceding::input[@id='annualJobEstimate2']")
	public static WebElement Newhomesbuilt_txtb;
	
	@FindBy(xpath="//label[contains(text(),'Hospitals, clinics and assisted living facilities')]/preceding::input[@id='annualJobEstimate3']")
	public static WebElement Hospitals_txtb;
	
	@FindBy(xpath="//label[contains(text(),'Exterior jobs over 3 stories')]/preceding::input[@id='annualJobEstimate4']")
	public static WebElement Exteriorjobsover_txtb;
	
	@FindBy(xpath="//label[contains(text(),'Jobs running at one time')]/preceding::input[@id='annualJobEstimate5']")
	public static WebElement Jobsrunningatonetime_txtb;
	
	@FindBy(xpath="//label[contains(text(),'Total new homes built')]/preceding::input[@id='annualJobEstimate6']")
	public static WebElement Totalnewhomesbuilt_txtb;
	
	@FindBy(xpath="//label[contains(text(),'Townhomes, co-op buildings, condos or condo conversion projects')]/preceding::input[@id='annualJobEstimate7']")
	public static WebElement townhomes_txtb;
	
	@FindBy(xpath="//label[contains(text(),'Jobs on homes valued over $1.5 million')]/preceding::input[@id='annualJobEstimate8']")
	public static WebElement jobsonhomesvaluedovermillion_txtb;
	
	@FindBy(xpath="//label[contains(text(),'Airports or aerospace facilities')]/preceding::input[@id='annualJobEstimate9']")
	public static WebElement airportsoraerospacefacilities_txtb;
	
	
	//=================Final Submission Success======================
	
	@FindBy(xpath="//h1[contains(text(),'Thank You. Your CBIC application has been submitted successfully.')]")
	public static WebElement SuccesMsg_confirm_msg;
	
	@FindBy(xpath="//p")
	public static WebElement quote_msg;
	
		
}
