package com.BtisNewUI.Locators;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.LegacyApplication.TestBase.TestBase;

public class ClearSpringLocators extends TestBase{

	public static WebDriver driver;

	public static final Logger log=Logger.getLogger(ClearSpringLocators.class.getName());

	//===================Bubbles Heading==========================

	@FindBy(xpath="//p[contains(text(),'Contact Info')]/preceding-sibling::span")
	public static WebElement contactInfo_switch_btn;

	@FindBy(xpath="//p[contains(text(),'Business Info')]/preceding-sibling::span")
	public static WebElement businessInfo_switch_btn;

	@FindBy(xpath="//p[contains(text(),'Insurance History')]/preceding-sibling::span")
	public static WebElement insuranceHistory_switch_btn;

	@FindBy(xpath="//p[contains(text(),'Classifications')]/preceding-sibling::span")
	public static WebElement classifications_switch_btn;

	@FindBy(xpath="//p[contains(text(),'Pricing')]/preceding-sibling::span")
	public static WebElement pricing_switch_btn;

	//--------------------------------->>Applicant's Contact Information Page 1 <<--------------------------------------------//

	@FindBy(xpath="//input[@id='firstNameInput']")
	public static WebElement firstName_txtb;

	@FindBy(xpath="//input[@id='lastNameInput']")
	public static WebElement lastName_txtb;


	//==Business Address

	@FindBy(xpath="//input[@id='businessAddress1Input']")
	public static WebElement business_streetAdd_txtb;

	//====list of address====
	@FindBy(xpath="//div[@class='pac-item']//span[@class='pac-matched']")
	public static List<WebElement> businessAdd_List_cs;

	@FindBy(xpath="//input[@id='businessAddress2Input']")
	public static WebElement business_apt_suit_txtb;

	@FindBy(xpath="//input[@id='businessAddressCityInput']")
	public static WebElement businessAddressCity_txtb;

	@FindBy(xpath="//input[@id='businessAddressStatePlaceholderSelect']/following-sibling::input[@id='businessAddressStateInput']")
	public static WebElement businessAddressState_drpd;

	@FindBy(xpath="//input[@id='businessAddressZipInput']")
	public static WebElement businessAddressZip_txtb;

	//===sameAddresss=====CheckBox

	@FindBy(xpath="//label[@for='sameAddress']")
	public static WebElement sameAddress_chkb;

	//==Mailing Address=====

	@FindBy(xpath="//input[@id='mailingAddress1Input']")
	public static WebElement mailing_streetAdd_txtb;

	@FindBy(xpath="//input[@id='mailingAddress2Input']")
	public static WebElement mailing_apt_suit_txtb;

	@FindBy(xpath="//input[@id='mailingAddressCityInput']")
	public static WebElement mailingAddressCity_txtb;

	@FindBy(xpath="//select[@id='mailingAddressStateSelect']")
	public static WebElement mailingAddressState_drpd;

	@FindBy(xpath="//input[@id='mailingAddressZipInput']")
	public static WebElement mailingAddressZip_txtb;

	@FindBy(xpath="//input[@id='emailAddressInput']")
	public static WebElement emailAddress_txtb;

	@FindBy(xpath="//input[@id='phoneNumberInput']")
	public static WebElement phoneNumber_txtb;

	@FindBy(xpath="//input[@id='cellNumberInput']")
	public static WebElement cellNumber_txtb;

	//==Save and Cont Button Page 1

	@FindBy(xpath="//h1[contains(text(),'Contact Information')]/following::div/child::form/child::div/child::button[contains(text(),' Save & Continue ')]")
	public static WebElement save_continue_btn_page1;

	//============= Applicant's Business Information Page 2

	//What is the applicant's relation to the business?
	// Owner ,Employee ,Contractor 
	
	@FindBy(xpath="//li[@class='nav-item']/span[2]")
	public static WebElement submissionID_Temp;
	
	@FindBy(xpath="//input[@id='contractorLicenseNumberInput']")
	public static WebElement contractorLicenseNum_txtb;
	
	@FindBy(xpath="//select[@ng-reflect-name='relationToBusiness']")
	public static WebElement relationToBusiness_drpd;

	//What is the name of the business?
	@FindBy(xpath="//input[@id='dbaInput']")
	public static WebElement businessName_txtb;

	//What is the structure of the business?
	@FindBy(xpath="//select[@id='businessEntityTypeIdSelect']")
	public static WebElement stractureOfBusiness_drpd;

	//What is the applicant's industry experience?
	@FindBy(xpath="//select[@id='constructionExperienceIdSelect']")
	public static WebElement constructionExperienceId_drpd;

	//How many owners are active in the field?
	@FindBy(xpath="//input[@id='numberOfOwnersInput']")
	public static WebElement numberOfOwners_txtb;

	//What is the annual owner payroll?
	@FindBy(xpath="//input[@name='ownerPayroll']")
	public static WebElement ownerPayroll_txtb;

	//What are the annual gross receipts?
	@FindBy(xpath="//input[@id='grossReceiptsInput']")
	public static WebElement grossReceipts_txtb;

	//Does the applicant have employees?
	@FindBy(xpath="//label[@id='haveEmployeesNo']/span")
	public static WebElement employees_NO;

	@FindBy(xpath="//label[@id='haveEmployeesYes']/span")
	public static WebElement employees_YES;

	// if YES -=- How many employees does the applicant have?
	@FindBy(xpath="//input[@id='numberOfFullTimeEmployeesInput']")
	public static WebElement numberOfFullTimeEmployees_txtb;

	// ==What is the annual employee payroll?
	@FindBy(xpath="//input[@id='employeePayrollInput']")
	public static WebElement employeePayroll_txtb;

	//=======================================================
	//Does the applicant hire subcontractors?
	@FindBy(xpath="//label[@id='hireSubcontractorsNo']/span")
	public static WebElement subcontractors_NO;

	@FindBy(xpath="//label[@id='hireSubcontractorsYes']/span")
	public static WebElement subcontractors_YES;

	//IF YES then 
	//What are the annual subcontracting costs?
	@FindBy(xpath="//input[@id='subcontractorCostsInput']")
	public static WebElement subcontractorCosts_txtb;

	//What percentage of subcontracted work is done on single family or duplex dwellings?
	@FindBy(xpath="//input[@id='percentageSubcontractorDwellingInput']")
	public static WebElement percentageSubcontractorDwelling_txtb;

	//==========================================================
	//The applicant performs residential work prior to the structure being approved for occupancy.
	@FindBy(xpath="//label[@id='performNewResidentialWorkNo']/span")
	public static WebElement residential_work_NO;

	@FindBy(xpath="//label[@id='performNewResidentialWorkYes']/span")
	public static WebElement residential_work_YES;

	//if YES==== Specify the percentage of each type of work the applicant performs prior to approval for occupancy.

	@FindBy(xpath="//input[@id='priorToApprovalWorkPercentagesNewInput']")
	public static WebElement residential_NEW_txtb;

	@FindBy(xpath="//input[@id='priorToApprovalWorkPercentagesRemodelingInput']")
	public static WebElement residential_REMODELING_txtb;

	///========================================================================

	//Describe the operation of the business
	@FindBy(xpath="//textarea [@id='descriptionOfOperationsTextArea']")
	public static WebElement textarea_txtb;

	@FindBy(xpath="//textarea[@ng-reflect-name='descriptionOfOperations']/following::div[1]/child::button[contains(text(),' Save & Continue ')]")
	public static WebElement save_continue_btn_page2 ;

	//=====Applicant's Insurance Information Page 3 =====

	//Enter the proposed effective start date.
	@FindBy(xpath="//input[@id='proposedEffectiveDateInput']")
	public static WebElement proposedEffectiveDate_txtb;
	
	@FindBy(xpath="//button[@title='Next month']")
	public static WebElement nextMonthArrow;

	@FindBy(xpath="//span[@class='custom-day']")
	public static List<WebElement> days_List;
	
	//How many years has the applicant's current company been in business?
	@FindBy(xpath="//select[@id='businessExperienceIdSelect']")
	public static WebElement businessHistory_drpd;

	//If yoy choose oher then "New In Business" below field will appear
	//Any claims in the past year?
	@FindBy(xpath="//label[@id='hasClaimsNo']/span")
	public static WebElement pastClaim_NO;

	@FindBy(xpath="//label[@id='hasClaimsYes']/span")
	public static WebElement pastClaim_YES;

	//If you Choose NO as option.
	//Any lapse in coverage?
	@FindBy(xpath="//label[@id='hasLapseInCoverageNo']/span")
	public static WebElement lapsCoverage_NO;

	@FindBy(xpath="//label[@id='hasLapseInCoverageYes']/span")
	public static WebElement lapseCoverage_YES;

	@FindBy(xpath="//select[@id='businessExperienceIdSelect']/following::div[1]/child::button[@id='submitButton']")
	public static WebElement save_continue_btn_page3;

	//============Applicant's Classifications Page 4===================

	@FindBy(xpath="//button[contains(text(),'Add a classification')]")
	public static WebElement addClassifaction_btn;

	@FindBy(xpath="//button[@class='dropdown-item']")
	public static List<WebElement> classCode_list;

	@FindBy(xpath="//button[@class='dropdown-item']")
	public static WebElement classCodes;

	@FindBy(xpath="//button[contains(text(),'Add another classification')]")
	public static WebElement addAnotherClassifaction_btn;

	@FindBy(xpath="//tr[@formarrayname='addedClassifications'][1]/td[1]")
	public static WebElement classCode1;

	@FindBy(xpath="//input[@id='percentage0']")
	public static WebElement classCodePercentage1;

	@FindBy(xpath="//tr[@formarrayname='addedClassifications'][1]/td[3]/button")
	public static WebElement classCodeDelete1;

	@FindBy(xpath="//tr[@formarrayname='addedClassifications'][2]/td[1]")
	public static WebElement classCode2;

	@FindBy(xpath="//input[@id='percentage1']")
	public static WebElement classCodePercentage2;

	@FindBy(xpath="//tr[@formarrayname='addedClassifications'][2]/td[3]/button")
	public static WebElement classCodeDelete2;

	@FindBy(xpath="//button[contains(text(),'Add another classification')]/following::button[contains(text(),'Save & Continue')]")
	public static WebElement save_continue_btn_page4;

	//============Pricing Options Page 5 ===================

	@FindBy(xpath="//img[@alt='ClearSpring']")
	public static WebElement carrierLogo;
	
	@FindBy(xpath="//select[@id='pricingOptionclearspringLimit']")
	public static WebElement limits_drpd;
	
	@FindBy(xpath="//select[@id='pricingOptionclearspringDeductible']")
	public static WebElement deductible_drpd;
	
	@FindBy(xpath="//td[@class='amt-col']/span")
	public static WebElement amount_Value;
	
	@FindBy(xpath="//a[contains(text(),'Recalculate')]")
	public static WebElement recalculate;
	
	@FindBy(xpath="//button[@id='pricingOptionclearspringButton']")
	public static WebElement customize_btn;
	
	@FindBy(xpath="//li[@class='nav-item']/span[2]")
	public static WebElement submissionID_onCustomizeTab ;
	
	//===========Broker Fee and Enhancement page 6 ======================
	
	@FindBy(xpath="//input[@id='brokerFeeInput']")
	public static WebElement brokerFee_txtb;
	
	@FindBy(xpath="//div[@class='price-head']/child::h2/span")
	public static WebElement AmountPrice_txt;
	
	@FindBy(xpath="//button[@id='downloadProposalButton']")
	public static WebElement downloadProposal_btn;
	
	@FindBy(xpath="//button[@id='recalculateButton']")
	public static WebElement recalculate_btn;
	
	@FindBy(xpath="//select[@id='setDeductiblesIdSelect']")
	public static WebElement deductible_drpd_page6;
	
	@FindBy(xpath="//select[@id='setLimitsIdSelect']")
	public static WebElement limits_drpd_page6;
	
	//Check Boxes
	@FindBy(xpath="//span[contains(text(),'Per Project Aggregate')]/parent::div/following-sibling::div/child::div/label")
	public static WebElement preProject_chkb;
	
	@FindBy(xpath="//span[contains(text(),'Employee Benefits Liability')]/parent::div/following-sibling::div/child::div/label")
	public static WebElement employeeBenefits_chkb;
	
	@FindBy(xpath="//span[contains(text(),'Remove Form 49-0103')]/parent::div/following-sibling::div/child::div/label")
	public static WebElement removeForm49_chkb;
	
	@FindBy(xpath="//span[contains(text(),'Terrorism Coverage')]/parent::div/following-sibling::div/child::div/label")
	public static WebElement terrorCoverage_chkb;
	
	@FindBy(xpath="//span[contains(text(),'49-0116 Scheduled Additional')]/parent::div/following-sibling::div/child::div/label")
	public static WebElement scheduledAdditional_chkb;
	
	@FindBy(xpath="//button[@ng-reflect-ngb-popover='Remove Prior Completed or Aban']/following::label[1]")
	public static WebElement removePrior_chkb;
	
	@FindBy(xpath="//div[contains(text(),'Is the current carrier solvent')]/following::div[2]/child::label[2]/span")
	public static WebElement carrierSovent_Yes;
	
	@FindBy(xpath="//div[contains(text(),'Is the current carrier solvent')]/following::div[2]/child::label[1]/span")
	public static WebElement carrierSovent_No;
		
	@FindBy(xpath="//button[@ng-reflect-ngb-popover='Remove Earth Movement Exclusio']/following::label[1]")
	public static WebElement removeEarth_chkb;
	
	@FindBy(xpath="//div[contains(text(),'Included')]/following::div/button")
	public static WebElement save_continue_btn_page6;
	
	//===================Eligibility Statement Page 7 ========================
	
	@FindBy(xpath="//label[@id='agreementNo']/span")
	public static WebElement submitNO_radio_btn;
	
	@FindBy(xpath="//label[@id='agreementYes']/span")
	public static WebElement submitYES_radio_btn;
	
	@FindBy(xpath="//button[@id='submitButton' and contains(text(),'Submit for Underwriter Review')]")
	public static WebElement submitUW_btn;
	
	@FindBy(xpath="//button[@id='submitButton' and contains(text(),'Save & Customize Coverages')]")
	public static WebElement submitCustomizeCoverage_btn;
	
	@FindBy(xpath="//h1[contains(text(),'Thank You.')]")
	public static WebElement thankU_msg;
	
	@FindBy(xpath="//li[@class='nav-item']/span[2]")
	//@FindBy(xpath="//span[@id='submissionId']")
	public static WebElement submissionId;
	
	@FindBy(xpath="//*[@id='Form']/div[3]/header/div[2]/div/div/div[3]/div/a")
	public static WebElement gotos;
}
