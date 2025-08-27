package com.BtisNewUI.Locators;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.LegacyApplication.TestBase.TestBase;

public class CBIC_NewLocators extends TestBase{
	public static WebDriver driver;

	public static final Logger log=Logger.getLogger(CBIC_NewLocators.class.getName());

	//--------------------------------->>Contact Info Page 1 <<--------------------------------------------/

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

	@FindBy(xpath="//input[@id='sameAddress']/following-sibling::label")
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

	@FindBy(xpath="//button[@id='submitButton']")
	public static WebElement bi_save_contiunue_btn;
	
	@FindBy(xpath="//input[@id='uwEmailId']/following::button[contains(text(),'Save & Continue')]")
	public static WebElement save_contiunue_btn_uw;

	//==================Page  Classifactions============================

	@FindBy(xpath="//a[@id='addClassification']")
	public static WebElement addClassification_btn;

	@FindBy(xpath="//span[@id='newClassification']")
	public static List<WebElement> classCode_list;

	@FindBy(xpath="//input[@id='percentage_1']")
	public static WebElement percentage_1_txtb;

	@FindBy(xpath="//a[@id='removeClassification']/span")
	public static WebElement deleteClasscode1_btn;

	@FindBy(xpath="//input[@id='percentage_2']")
	public static WebElement percentage_2_txtb;

	@FindBy(xpath="//input[@id='totalPercentage']")
	public static WebElement totalPercentage;

	@FindBy(xpath="//td[contains(text(),'Total')]")
	public static WebElement totalHeading;

	@FindBy(xpath="//div[@class='alert alert-danger'][@class=contains(text(),'- Total must equal 100%')]")
	public static WebElement alertTotal_validation;

	//========Business Info=============

	@FindBy(xpath="//input[@id='name']")
	public static WebElement dba_name;

	@FindBy(xpath="//input[@id='contractorLicense']")
	public static WebElement contractorLicense_txtb;

	@FindBy(xpath="//select[@id='type']")
	public static WebElement business_stracture_drpd;

	@FindBy(xpath="//input[@id='activeOwners']")
	public static WebElement activeOwners_txtb;

	@FindBy(xpath="//input[@id='annualGrossReceipts']")
	public static WebElement annualGrossReceipts_txtb;


	//====Does the applicant have employees?

	@FindBy(xpath="//span[contains(text(),'Does the applicant have employees?')]/following::label[@value='No'][1]/span")
	public static WebElement haveEmployees_NO;

	@FindBy(xpath="//span[contains(text(),'Does the applicant have employees?')]/following::label[1]/following-sibling::label[1]/span")
	public static WebElement haveEmployees_YES;

	// ===if YES == Does the applicant have employees?

	@FindBy(xpath="//input[@id='numberOfEmployees']")
	public static WebElement numberOfEmployees_txtb;

	@FindBy(xpath="//input[@id='annualEmployeePayroll']")
	public static WebElement annualEmployeePayroll_txtb;


	//========Does the applicant hire subcontractors?

	@FindBy(xpath="//span[contains(text(),'Does the applicant hire subcontractors?')]/following::label[@value='No']/span[1]")
	public static WebElement hireSubcontractor_NO;

	@FindBy(xpath="//span[contains(text(),'Does the applicant hire subcontractors?')]/following::label[1]/following-sibling::label[1]/span")
	public static WebElement hireSubcontractor_Yes;

	//========If Yes =====Does the applicant hire subcontractors

	@FindBy(xpath="//input[@id='annualSubcontractingCosts']")
	public static WebElement annualSubcontractingCosts_txtb;

	@FindBy(xpath="//input[@id='annualSubcontractingDwellingsPercentage']")
	public static WebElement annualSubcontractingDwellingsPercentage_txtb;

	//=======The applicant performs residential work prior to the structure being approved for occupancy.

	@FindBy(xpath="//span[contains(text(),'The applicant performs residential work')]/following::label[1]/span")
	public static WebElement performResidential_NO;

	@FindBy(xpath="//span[contains(text(),'The applicant performs residential work')]/following::label[2]/span")
	public static WebElement performResidential_Yes;

	//IF YES========The applicant performs residential work prior to the structure being approved for occupancy.
	@FindBy(xpath="//input[@id='constructionZoneNewPercentage']")
	public static WebElement constructionZoneNewPercentage_txtb;

	@FindBy(xpath="//input[@id='constructionZoneRemodelingPercentage']")
	public static WebElement constructionZoneRemodelingPercentage_txtb;

	//========Text Area========
	@FindBy(xpath="//textarea[@id='descriptionOfOperations']")
	public static WebElement descriptionOfOperations_txtb;

	//======================Insurance Histor==========================

	@FindBy(xpath="//input[@id='effectiveDate']")
	public static WebElement expirationDate;

	@FindBy(xpath="//select[@id='businessHistoryId']")
	public static WebElement businessYears_drpd;

	@FindBy(xpath="//select[@id='constructionExperienceId']")
	public static WebElement industryExp_drpd;

	//==========================Pricing option page===================

	@FindBy(xpath="//td[@class='carrier-price']/h1")
	public static WebElement pricingOptions_value;

	@FindBy(xpath="//button[@id='submit_button']")
	public static WebElement submitQuote_btn;
	
	@FindBy(xpath="//button[@id='submitButton']")
	public static WebElement submitQuote_btn1;
	
	@FindBy(xpath="//button[contains(text(),'Submit to CBIC')]")
	public static WebElement submit_CBIC_btn;	

	//====================Supplimental Page-==================================

	//==========% of Work====

	//=============Structure Type 	100%================
	
	@FindBy(xpath="//div/span[contains(text(),'Amount: ')]/following::h3[1]")
	public static WebElement priceShown;
	
	@FindBy(xpath="//input[@id='residentailWorkPercentage']")
	public static WebElement residentailWorkPercentage_txtb;

	@FindBy(xpath="//input[@id='commercialWorkPercentage']")
	public static WebElement commercialWorkPercentage_txtb;

	@FindBy(xpath="//input[@id='industrialWorkPercentage']")
	public static WebElement industrialWorkPercentage_txtb;

	@FindBy(xpath="//input[@id='manufacturingWorkPercentage']")
	public static WebElement manufacturingWorkPercentage_txtb;

	//============Construction Type 	100%========

	@FindBy(xpath="//input[@id='newConstructionTypePercentage']")
	public static WebElement newConstructionTypePercentage_txtb;

	@FindBy(xpath="//input[@id='remodelTypePercentage']")
	public static WebElement remodelTypePercentage_txtb;

	@FindBy(xpath="//input[@id='serviceRepairTypePercentage']")
	public static WebElement serviceRepairTypePercentage_txtb;

	//==========Subcontractors (Select the list of trades of the subcontractors) ===

	@FindBy(xpath="//label[contains(text(),'Concrete')]")
	public static WebElement Concrete_chkb;

	@FindBy(xpath="//label[contains(text(),'Drywall')]")
	public static WebElement Drywall_chkb;

	@FindBy(xpath="//label[contains(text(),'Excavation')]")
	public static WebElement Excavation_chkb;

	@FindBy(xpath="//label[contains(text(),'Electrical')]")
	public static WebElement Electrical_chkb;

	@FindBy(xpath="//label[contains(text(),'Framing')]")
	public static WebElement Framing_chkb;

	@FindBy(xpath="//label[contains(text(),'Finish Work')]")
	public static WebElement finishWork_chkb;

	@FindBy(xpath="//label[contains(text(),'Flooring')]")
	public static WebElement Flooring_chkb;

	@FindBy(xpath="//label[contains(text(),'Grading')]")
	public static WebElement Grading_chkb;

	@FindBy(xpath="//label[contains(text(),'General Clean Up')]")
	public static WebElement Glazier_clean_chkb;

	@FindBy(xpath="//label[contains(text(),'Glazier')]")
	public static WebElement Glazier_chkb;

	@FindBy(xpath="//label[contains(text(),'Interior Decorating')]")
	public static WebElement Interior_chkb;

	@FindBy(xpath="//label[contains(text(),'Landscape')]")
	public static WebElement Landscape_chkb;

	@FindBy(xpath="//label[contains(text(),'Painting')]")
	public static WebElement Painting_chkb;

	@FindBy(xpath="//label[contains(text(),'Plastering')]")
	public static WebElement Plastering_chkb;

	@FindBy(xpath="//label[contains(text(),'Plumbing')]")
	public static WebElement Plumbing_chkb;

	@FindBy(xpath="//label[contains(text(),'Roofing')]")
	public static WebElement Roofing_chkb;

	@FindBy(xpath="//input[@id='useSubcontractorsNextYearTradesOther']")
	public static WebElement useSubcontractorsNextYearTradesOther_txtb;

	//==============Mark the checkbox if the applicant complies with:==================

	@FindBy(xpath="//input[@id='subcontractorCompliance1']/following-sibling::label")
	public static WebElement subcontractorCompliance1_chkb;

	@FindBy(xpath="//input[@id='subcontractorCompliance2']/following-sibling::label")
	public static WebElement subcontractorCompliance2_chkb;

	@FindBy(xpath="//input[@id='subcontractorCompliance3']/following-sibling::label")
	public static WebElement subcontractorCompliance3_chkb;

	//===================Has the applicant had any prior claims?=========

	@FindBy(xpath="//span/h5[contains(text(),'Has the applicant had any prior claims?')]/following::label[@value='No']/span")
	public static WebElement priorClaims_No;

	@FindBy(xpath="//span/h5[contains(text(),'Has the applicant had any prior claims?')]/following::label[2]/span")
	public static WebElement priorClaims_Yes;

	//==If Yes==========================

	@FindBy(xpath="//input[@id='priorClaims1Year']")
	public static WebElement priorClaims1Year_txtb;

	@FindBy(xpath="//input[@id='priorClaims1Nature']")
	public static WebElement priorClaims1Nature_txtb;

	@FindBy(xpath="//input[@id='priorClaims1Outcome']")
	public static WebElement priorClaims1Outcome_txtb;

	@FindBy(xpath="//input[@id='priorClaims2Year']")
	public static WebElement priorClaims2Year_txtb;

	@FindBy(xpath="//input[@id='priorClaims2Nature']")
	public static WebElement priorClaims2Nature_txtb;

	@FindBy(xpath="//input[@id='priorClaims2Outcome']")
	public static WebElement priorClaims2Outcome_txtb;

	//==============Please select following coverages===========================

	//================ 49-0116 Scheduled Additional Insured Endorsement (CG 20 10 11/85 equivalent)

	@FindBy(xpath="//div//label[contains(text(),'49-0116')]/following::label[1]/span")
	//@FindBy(xpath="//div//label[contains(text(),'Blanket Additional Insured Endorsement')]/following::label[1]/span")
	public static WebElement aadInsEndorse_No;

	//@FindBy(xpath="//div//label[contains(text(),'49-0116')]/following::label[2]/span")
	@FindBy(xpath="//div//label[contains(text(),'Blanket Additional Insured Endorsement')]/following::label[2]/span")
	public static WebElement aadInsEndorse_Yes;

	//========Inland Marine==============

	@FindBy(xpath="//div//label[contains(text(),'Inland Marine')]/following::label[1]/span")
	public static WebElement inlandMarine_No;

	@FindBy(xpath="//div//label[contains(text(),'Inland Marine')]/following::label[2]/span")
	public static WebElement inlandMarine_Yes;
	
	@FindBy(xpath="//button[contains(text(),'Recalculate')]")
	public static WebElement recalculate_btn;
	//=============Genral Questions=====================================

	@FindBy(xpath="//p[contains(text(),'Does applicant')]/following::input[@id='carrierInValidQuest0']/parent::label")
	public static WebElement workOutOfState_No;

	@FindBy(xpath="//p[contains(text(),'Does applicant')]/following::input[@id='carrierValidQuest0']/parent::label")
	public static WebElement workOutOfState_Yes;

	@FindBy(xpath="//p[contains(text(),'Are you affiliated')]/following::input[@id='carrierInValidQuest1']/parent::label")
	public static WebElement affiliatedAnotherCompany_No;

	@FindBy(xpath="//p[contains(text(),'Are you affiliated')]/following::input[@id='carrierValidQuest1']/parent::label")
	public static WebElement affiliatedAnotherCompany_Yes;

	@FindBy(xpath="//span[contains(text(),'Check if None')]")
	public static WebElement checkIfNone_chkb;

	@FindBy(xpath="//span[contains(text(),'The insured has claims against their insurance')]")
	public static WebElement claimWithin5yr_chkb;

	@FindBy(xpath="//span[contains(text(),'The insured has operated for any period')]")
	public static WebElement periodWithoutInsurance_chkb;

	@FindBy(xpath="//span[contains(text(),'The insured has lawsuits or arbitrations or disputes')]")
	public static WebElement assessedByLawyer_chkb;

	@FindBy(xpath="//span[contains(text(),'The insured has knowledge of any existing problems')]")
	public static WebElement legalActionAgainstPerson_chkb;

	@FindBy(xpath="//span[contains(text(),'declined or non-renewed due to claims ')]")
	public static WebElement ineligible_operations_chkb;

	@FindBy(xpath="//span[contains(text(),'The insured has any bankruptcies')]")
	public static WebElement any_bankruptcies_chkb;
	
	//=======Class code specific Question =========
	
	// class code = 9111 (Air Con.)
	
	//ClassCode 91111
	//Estimate the number of jobs performed annually (0 if 'None')
	//Coolers and refrigeration systems
	
	@FindBy(xpath="//p[contains(text(),'Coolers and refrigeration')]/following::input[@id='classcodeQuestions00T292']")
	public static WebElement coller_txtb;
	
	@FindBy(xpath="//p[contains(text(),'Exterior jobs over')]/following::input[@id='classcodeQuestions10T291'][1]")
	public static WebElement exterior_txtb;
	
	@FindBy(xpath="//p[contains(text(),'Installations requiring boom')]/following::input[@id='classcodeQuestions20T284'][1]")
	public static WebElement installation_txtb;
	
	@FindBy(xpath="//p[contains(text(),'LPG Systems')]/following::input[@id='classcodeQuestions30T294'][1]")
	public static WebElement lpg_txtb;
	
	@FindBy(xpath="//p[contains(text(),'Roof top units')]/following::input[@id='classcodeQuestions40T290'][1]")
	public static WebElement roof_txtb;
	
	@FindBy(xpath="//p[contains(text(),'Services performed in clean rooms')]/following::input[@id='classcodeQuestions50T293'][1]")
	public static WebElement servicesPer_txtb;
	
	@FindBy(xpath="//p[contains(text(),'Solar heating installation')]/following::input[@id='classcodeQuestions60T285'][1]")
	public static WebElement solarHeating_txtb;
	
	@FindBy(xpath="//p[contains(text(),'Woodstove and')]/following::input[@id='classcodeQuestions70T282'][1]")
	public static WebElement woodstove_txtb;
	
	//List all other services provided that are unrelated to installing, servicing or repairing heating and air conditioning systems
	
	@FindBy(xpath="//span[contains(text(),'Check if None')]")
	public static WebElement listOfOtherServices_chkb_9111;
	
	@FindBy(xpath="//span[contains(text(),'Records are kept for each job including')]")
	public static WebElement recordKept_chkb_9111;
		
	//Does the insured sell any equipment that does not get installed by the insured or through employees or subcontractors of the insured?
	
	@FindBy(xpath="//div[@id='cc0']/div[13]/div/label[1]/span")
	public static WebElement doesTheInsuredSell_No;
	
	@FindBy(xpath="//div[@id='cc0']/div[13]/div/label[2]/span")
	public static WebElement doesTheInsuredSell_Yes;
	
	//=======Seprator========
	
	@FindBy(xpath="//div[@id='cc0']/preceding::h5[@class='separator']")
	public static WebElement separator_btn;
	
	@FindBy(xpath="//div[@id='cc1']/preceding::h5[@class='separator collapsed'][1]")
	public static WebElement separatorCollapsed_btn;
	
	//=====Class Codes=======92338=======Drywall======
	
	@FindBy(xpath="//p[contains(text(),'Exterior plastering')]/following::input[@id='classcodeQuestions01T569'][1]")
	public static WebElement exterior_plastering_txtb;
		
	@FindBy(xpath="//p[contains(text(),'Exterior plastering')]/following::input[@id='classcodeQuestions01C348' and @name='answer']/following-sibling::span")
	public static WebElement listOfOtherServices_chkb_92338;
		
	@FindBy(xpath="//p[contains(text(),'Exterior plastering')]/following::input[@id='classcodeQuestions21C302' and @name='answer']/following-sibling::span[contains(text(),'Records are kept for each job including')]")
	public static WebElement recordKept_chkb_92338;
		
	@FindBy(xpath="//p[contains(text(),'Exterior plastering')]/following::input[@id='classcodeQuestions31C307' and @name='answer']/following-sibling::span[contains(text(),'No exterior drywall work performed')]")
	public static WebElement noExteriorDrywall_chkb;
	
	//===========================QCGL=THANK YOU PAGE AND SUBMISSION ID========================================
	
	@FindBy(xpath="//span[contains(text(),'The status of your CBIC application ')]/b[1]")
	public static WebElement qcgl_ID;
	
	@FindBy(xpath="//span[contains(text(),'The status of your CBIC application ')]/b[2]")
	public static WebElement qcgl_STATUS;
	
	@FindBy(xpath="//span//a[contains(text(),'here')]")
	public static WebElement qcgl_application_link;
	
	@FindBy(xpath="//a[contains(text(),'Close')]")
	public static WebElement qcgl_close_btn;
	
	//=============Uner writer -- URL =============================================
	
	@FindBy(xpath="//input[@id='uwEmailId']")
	public static WebElement uwEmailId_txt;
}
