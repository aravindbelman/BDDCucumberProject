package com.BtisNewUI.Locators;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.LegacyApplication.TestBase.TestBase;

public class WCnewUILocators extends TestBase{

	public static WebDriver driver;

	public static final Logger log=Logger.getLogger(WCnewUILocators.class.getName());

	//--------------------------------->>Business Info Page 1 <<--------------------------------------------//
	//===================Bubbles Heading ==========================

	@FindBy(xpath="//p[contains(text(),'Business Information')]/preceding-sibling::span/i")
	public static WebElement businessInfo_switch_btn;

	@FindBy(xpath="//p[contains(text(),'Coverage History')]/preceding-sibling::span/i")
	public static WebElement coverageHistory_switch_btn;

	@FindBy(xpath="//p[contains(text(),'Loss Information')]/preceding-sibling::span/i")
	public static WebElement lossInfo_switch_btn;

	@FindBy(xpath="//p[contains(text(),'Class Codes')]/preceding-sibling::span/i")
	public static WebElement classCodes_switch_btn;

	@FindBy(xpath="//p[contains(text(),'Owners and Officers')]/preceding-sibling::span/i")
	public static WebElement ownerOff_switch_btn;

	@FindBy(xpath="//p[contains(text(),'Credit Opportunity')]/preceding-sibling::span/i")
	public static WebElement creditOpp_switch_btn;

	@FindBy(xpath="//p[contains(text(),'Additional Information')]/preceding-sibling::span/i")
	public static WebElement addInfo_switch_btn;

	@FindBy(xpath="//p[contains(text(),'Carrier Selections')]/preceding-sibling::span/i")
	public static WebElement carrierSelc_switch_btn;

	@FindBy(xpath="//p[contains(text(),'Price Indication')]/preceding-sibling::span/i")
	public static WebElement priceIndication_switch_btn;

	@FindBy(xpath="//p[contains(text(),'Sub-Class Code')]/preceding-sibling::span/i")
	public static WebElement subClassCode_switch_btn;

	@FindBy(xpath="//p[contains(text(),'Carrier Specific Questions')]/preceding-sibling::span/i")
	public static WebElement carrierSpeQues_switch_btn;

	@FindBy(xpath="//p[contains(text(),'Payment Plan')]/preceding-sibling::span/i")
	public static WebElement paymentPlan_switch_btn;

	@FindBy(xpath="//p[contains(text(),'Payment Breakdown')]/preceding-sibling::span/i")
	public static WebElement paymentBreakdown_switch_btn;


	//======================Business Address==============================//

	@FindBy(xpath="//input[@id='businessStreetAddress']")
	public static WebElement business_street_txtb;
	
	@FindBy(xpath="//div[@class='pac-item']//span[@class='pac-matched']")
	public static List<WebElement> businessAdd_List;

	@FindBy(xpath="//form[@id='submissionForm']//div[@class='error-message']//div[contains(text(),'Business Address is required. ')]")
	public static WebElement businessStreet_validation1;

	@FindBy(xpath="//form[@id='submissionForm']//div[@class='error-message']//div[contains(text(),'Business Address is required.')]/following::div[contains(text(),'Initial spaces and special characters are not allowed.')][1]")
	public static WebElement businessStreet_validation2;

	@FindBy(xpath="//input[@id='suiteAdds']")
	public static WebElement business_suit_txtb;

	@FindBy(xpath="//input[@id='BusinessCity']")
	public static WebElement business_City_txtb;

	@FindBy(xpath="//form[@id='submissionForm']//input[@id='BusinessCity']/following::div[contains(text(),'Please enter valid city')]")
	public static WebElement businessCity_validation;

	@FindBy(xpath="//select[@id='BusinessStateName']")
	public static WebElement business_state_drpdwn;

	@FindBy(xpath="//form[@id='submissionForm']//select[@id='BusinessStateName']/following::div[contains(text(),'State selected is not available at this time.')]")
	public static WebElement businessState_validation;

	@FindBy(xpath="//input[@id='BusinessZipCode']")
	public static WebElement business_zip_txtb;

	@FindBy(xpath="//form[@id='submissionForm']//input[@id='BusinessCity']/following::div[contains(text(),'Please enter valid zipcode.')]")
	public static WebElement businesZip_validation;

	//======================Same Mailing Address checkBox==============================//

	@FindBy(xpath="//input[@id='BusinessAndMailingAddressSame']/following-sibling::label")
	public static WebElement businessAndMailingAddressSame_chkBox;

	//======================Mailing Address==============================//

	@FindBy(xpath="//input[@id='mailingAddress']")
	public static WebElement mail_street_txtb;

	@FindBy(xpath="//form[@id='submissionForm']//div[@class='error-message']//div[contains(text(),'Business Address is required.')]/following::div[contains(text(),'Initial spaces and special characters are not allowed.')][2]")
	public static WebElement mailinStreet_validation;

	@FindBy(xpath="//input[@id='MailingSuiteAddress']")
	public static WebElement mail_suite_txtb;

	@FindBy(xpath="//input[@id='MailingCity']")
	public static WebElement mail_city_txtb;

	@FindBy(xpath="//form[@id='submissionForm']//input[@id='MailingCity']/following::div[contains(text(),' Please enter valid city.')]")
	public static WebElement mailCity_validation;

	@FindBy(xpath="//select[@id='MailingStateName']")
	public static WebElement mail_state_drpdwn;

	@FindBy(xpath="")
	public static WebElement mailState_validation;

	@FindBy(xpath="//input[@id='MailingZipCode']")
	public static WebElement mail_zip_txtb;

	@FindBy(xpath="//form[@id='submissionForm']//input[@id='MailingCity']/following::div[contains(text(),'Please enter valid zip code.')]")
	public static WebElement mailZip_validation;

	//======================AdditionalBusinessLoaction Radio button==============================//

	@FindBy(xpath="//input[@ng-reflect-name='AdditionalBusinessLocation']/parent::label[contains(text(),'No')]")
	public static WebElement add_businessLocation_NO_radio;

	@FindBy(xpath="//input[@ng-reflect-name='AdditionalBusinessLocation']/parent::label[contains(text(),'Yes')]")
	public static WebElement add_businessLocation_YES_radio;

	//====================Additional Address 1=======================//

	@FindBy(xpath="//form[@id='submissionForm']//div[@class='error-message']/following::div[contains(text(),' Duplicate address found')][1]")
	public static WebElement DubplicateAdd_validationMsg;

	@FindBy(xpath="//input[@id='anotherStreetAddress1']")
	public static WebElement add1_street_txtb;

	@FindBy(xpath="//form[@id='submissionForm']//div[@class='error-message']//div[contains(text(),'Business Address is required.')]/following::div[contains(text(),'Initial spaces and special characters are not allowed.')][3]")
	public static WebElement add1street_validation;

	@FindBy(xpath="//input[@id='anotherSuitAddress1']")
	public static WebElement add1_suite_txtb;

	@FindBy(xpath="//input[@id='anotherCityAddress1']")
	public static WebElement add1_city_txtb;

	@FindBy(xpath="//div[@id='multiple_0']//div[@class='error-message']//div[contains(text(),'Please enter valid city. ')]")
	public static WebElement add1City_validation;

	@FindBy(xpath="//select[@id='anotherStateName1']")
	public static WebElement add1_state_drpdwn;

	@FindBy(xpath="//div[@id='multiple_0']//div[contains(text(),'State selected is not available at this time.')]")
	public static WebElement add1State_validation;

	@FindBy(xpath="//input[@id='anotherZipCode1']")
	public static WebElement add1_zip_txtb;

	@FindBy(xpath="//div[@id='multiple_0']//div[@class='error-message']//div[contains(text(),'Please enter valid zip code. ')]")
	public static WebElement add1Zip_validation;

	@FindBy(xpath="//div[@id='multiple_0']//i[@title='Delete']")
	public static WebElement add1_delete_btn;

	//======================To Generate Additional address2 Radio button==============================//

	@FindBy(xpath="//input[@ng-reflect-name='anotherAdditionalAddress1']/parent::label[contains(text(),'No')]")
	public static WebElement add_address2_NO_radio;

	@FindBy(xpath="//input[@ng-reflect-name='anotherAdditionalAddress1']/parent::label[contains(text(),'Yes')]")
	public static WebElement add_address2_YES_radio;

	//====================Additional Address 2=======================//

	@FindBy(xpath="//input[@id='anotherStreetAddress2']")
	public static WebElement add2_street_txtb;

	@FindBy(xpath="//form[@id='submissionForm']//div[@class='error-message']//div[contains(text(),'Business Address is required.')]/following::div[contains(text(),'Initial spaces and special characters are not allowed.')][4]")
	public static WebElement aad2Street_validation;

	@FindBy(xpath="//input[@id='anotherSuitAddress2']")
	public static WebElement add2_suite_txtb;

	@FindBy(xpath="//input[@id='anotherCityAddress2']")
	public static WebElement add2_city_txtb;

	@FindBy(xpath="//div[@id='multiple_1']//div[@class='error-message']//div[contains(text(),'Please enter valid city. ')]")
	public static WebElement add2City_validation;

	@FindBy(xpath="//select[@id='anotherStateName2']")
	public static WebElement add2_state_drpdwn;

	@FindBy(xpath="//div[@id='multiple_1']//div[contains(text(),'State selected is not available at this time.')]")
	public static WebElement add2State_validation;

	@FindBy(xpath="//input[@id='anotherZipCode2']")
	public static WebElement add2_zip_txtb;

	@FindBy(xpath="//div[@id='multiple_1']//div[@class='error-message']//div[contains(text(),'Please enter valid zip code. ')]")
	public static WebElement add2Zip_validation;

	@FindBy(xpath="//div[@id='multiple_1']//i[@title='Delete']")
	public static WebElement add2_delete_btn;

	//======================To Generate Additional address2 Radio button==============================//

	@FindBy(xpath="//input[@ng-reflect-name='anotherAdditionalAddress2']/parent::label[contains(text(),'No')]")
	public static WebElement add_address3_NO_radio;

	@FindBy(xpath="//input[@ng-reflect-name='anotherAdditionalAddress2']/parent::label[contains(text(),'Yes')]")
	public static WebElement add_address3_YES_radio;

	//====================Additional Address 3=======================//

	@FindBy(xpath="//input[@id='anotherStreetAddress3']")
	public static WebElement add3_street_txtb;

	@FindBy(xpath="//form[@id='submissionForm']//div[@class='error-message']//div[contains(text(),'Business Address is required.')]/following::div[contains(text(),'Initial spaces and special characters are not allowed.')][5]")
	public static WebElement add3Street_validation;

	@FindBy(xpath="//input[@id='anotherSuitAddress3']")
	public static WebElement add3_suite_txtb;

	@FindBy(xpath="//input[@id='anotherCityAddress3']")
	public static WebElement add3_city_txtb;

	@FindBy(xpath="//div[@id='multiple_2']//div[@class='error-message']//div[contains(text(),'Please enter valid city. ')]")
	public static WebElement add3City_validation;

	@FindBy(xpath="//select[@id='anotherStateName3']")
	public static WebElement add3_state_drpdwn;

	@FindBy(xpath="//div[@id='multiple_2']//div[contains(text(),'State selected is not available at this time.')]")
	public static WebElement add3State_validation;

	@FindBy(xpath="//input[@id='anotherZipCode3']")
	public static WebElement add3_zip_txtb;

	@FindBy(xpath="//div[@id='multiple_2']//div[@class='error-message']//div[contains(text(),'Please enter valid zip code. ')]")
	public static WebElement add3Zip_validation;

	@FindBy(xpath="//div[@id='multiple_2']//i[@title='Delete']")
	public static WebElement add3_delete_btn;

	//======================Common NEXT and BACK button==============================//

	@FindBy(xpath="//button[@id='btnNext']")
	public static WebElement next_btn;

	/*@FindBy(xpath="//button[@class='next-btn common-btn btn ng-star-inserted' and contains(text(),'Next')]")
	public static WebElement next_btn;*/

	@FindBy(xpath="//button[@class='cancel-btn common-btn btn' and contains(text(),'Back')]")
	public static WebElement back_btn;

	//--------------------------------->>Business Info Page 2 <<--------------------------------------------//

	@FindBy(xpath="//p-calendar[@id='effectiveDate']//input[@name='DesiredEffectiveDate']")
	public static WebElement effectivedate_calendar;

	@FindBy(xpath="//form[@id='submissionForm']//div[@class='error-message']//div[contains(text(),'Date is required.')]")
	public static WebElement Calendar_validation;

	@FindBy(xpath="//input[@id='businessName']")
	public static WebElement businessName_txtb;

	@FindBy(xpath="//form[@id='submissionForm']//div[@class='error-message']//div[contains(text(),'Invalid Business Name.')]")
	public static WebElement businessName_validation;

	@FindBy(xpath="//input[@id='id_Dba']")
	public static WebElement dba_txtb ;

	@FindBy(xpath="//form[@id='submissionForm']//div[@class='error-message']//div[contains(text(),'Invalid DBA.')]")
	public static WebElement DBA_validation;

	@FindBy(xpath="//input[@id='firstname']")
	public static WebElement firstName_txtb;

	@FindBy(xpath="//form[@id='submissionForm']//div[@class='error-message']//div[contains(text(),'Invalid First name. ')]")
	public static WebElement firstName_validation;

	@FindBy(xpath="//input[@id='lastname']")
	public static WebElement lastName_txtb;

	@FindBy(xpath="//form[@id='submissionForm']//div[@class='error-message']//div[contains(text(),'Invalid Last name')]")
	public static WebElement lastName_validation;

	@FindBy(xpath="//input[@id='emailAddress']")
	public static WebElement email_txtb;

	@FindBy(xpath="//form[@id='submissionForm']//div[@class='error-message']//div[contains(text(),'Please enter valid Email.')]")
	public static WebElement email_validation;

	@FindBy(xpath="//p-inputmask[@id='phoneNumber']//input[@name='PhoneNumber']")
	public static WebElement phoneNo_txtb;

	@FindBy(xpath="//form[@id='submissionForm']//div[@class='error-message']//div[contains(text(),'Must be a valid phone number. ex (999)999-9999 ')]")
	public static WebElement phoneNo_validation;

	@FindBy(xpath="//input[@id='website']")
	public static WebElement website_txtb;

	@FindBy(xpath="//select[@id='entityType']")
	public static WebElement entity_drpd;

	@FindBy(xpath="//input[@id='insuredLastName']")
	public static WebElement insured_lastName;

	@FindBy(xpath="//input[@id='insuredFirstName']")
	public static WebElement insured_firstName;

	@FindBy(xpath="//input[@id='feinNumber']")
	public static WebElement feinNo_txtb;

	@FindBy(xpath="//form[@id='submissionForm']//div[@class='error-message']//div[contains(text(),'FEIN number must be 9 digits.')]")
	public static WebElement feinNo_validation;

	@FindBy(xpath="//input[@id='NothaveEx-mod']/following-sibling::span")
	public static WebElement expMod_No;

	@FindBy(xpath="//input[@id='haveEx-mod']/following-sibling::span")
	public static WebElement expMod_Yes;

	@FindBy(xpath="//input[@id='experienceModification']")
	public static WebElement expMod_txtb;

	@FindBy(xpath="//form[@id='submissionForm']//div[@class='error-message']//div[contains(text(),'Experience Modification must be between 0.00-9.99')]")
	public static WebElement expMod_validation;

	@FindBy(xpath="//select[@id='limitsofInsurance']")
	public static WebElement limits_drpd;

	@FindBy(xpath="//select[@id='industryExperience']")
	public static WebElement industryExp_drpd;

	@FindBy(xpath="//input[@id='businessEstablished']")
	public static WebElement businessEstablished_txtb;

	@FindBy(xpath="//form[@id='submissionForm']//div[@class='error-message']//div[contains(text(),'Invalid year')]")
	public static WebElement businessEst_validation1;

	@FindBy(xpath="//form[@id='submissionForm']//input[@id='businessEstablished']/following::div[contains(text(),' Establishment year must be between 1901 to current year ')]")
	public static WebElement businessEst_validation2; 


	//--------------------------------->>Coverage History Page 3<<--------------------------------------------//

	@FindBy(xpath="//p[@class='quote-number']")
	public static WebElement quoteNo;

	@FindBy(xpath="//h3[contains(text(),'Coverage History')]")
	public static WebElement page3Heading;

	@FindBy(xpath="//h1[contains(text(),'Does the Insured have current')]")
	public static WebElement page3Heading_priorCoverage;

	@FindBy(xpath="//input[@id='Not_have_prior_coverage']/parent::label[contains(text(),'No')]")
	public static WebElement priorCoverage_No_radio;

	@FindBy(xpath="//input[@id='have_prior_coverage']/parent::label[contains(text(),'Yes')]")
	public static WebElement priorCoverage_Yes_radio;

	//if YES choose as answer

	@FindBy(xpath="//input[@id='current_carrier_name']")
	public static WebElement currentCarrierName_txtb;

	@FindBy(xpath="//input[@id='current_carrier_name']/following::div[contains(text(),'Current carrier name is required')]")
	public static WebElement currentCarrierName_validation1;

	@FindBy(xpath="//input[@id='current_carrier_name']/following::div[contains(text(),'Invalid Carrier name')]")
	public static WebElement currentCarrierName_validation2;
	
	@FindBy(xpath="//input[@id='annual_premium']")
	public static WebElement annual_premium_txtb;

	@FindBy(xpath="//select[@id='prior_Coverage_Year']")
	public static WebElement priorCoverageYear_drpd;

	//==========Coverage page ======== Does the Insured currently having employee's working?====

	@FindBy(xpath="//input[@id='Not_have_employee_working']/parent::label[contains(text(),'No')]")
	public static WebElement employeesWorking_No_radio;

	@FindBy(xpath="//input[@id='have_employee_working']/parent::label[contains(text(),'Yes')]")
	public static WebElement employeesWorking_Yes_radio;


	// =========================================================================================================

	// This Locators are Not in Use.....

	@FindBy(xpath="//p-calendar[@id='StartDate0']/span/input")
	public static WebElement effectiveDate0;

	@FindBy(xpath="//p-calendar[@id='EndDate0']/span/input")
	public static WebElement expirationDate0;

	@FindBy(xpath="//input[@id='PolicyNumber0']")
	public static WebElement policyNo0_txtb;

	@FindBy(xpath="//input[@id='CarrierName0']")
	public static WebElement carrierName0_txtb;

	@FindBy(xpath="//input[@id='AnnualPremium0']")
	public static WebElement annualPremium0_txtb;

	@FindBy(xpath="//tr[@id='coverageField'][1]/td[6]/i")
	public static WebElement reset0_btn;

	@FindBy(xpath="//p-calendar[@id='StartDate0']/following-sibling::div[contains(text(),'Please enter valid Effective Date Range')]")
	public static WebElement StartDate0_validation;

	@FindBy(xpath="//p-calendar[@id='EndDate0']/following-sibling::div[contains(text(),'Please enter valid Expiration Date Range')]")
	public static WebElement EndDate0_validation;

	@FindBy(xpath="//input[@id='AnnualPremium0']/following::div[contains(text(),'Allow Numbers only.')][1]")
	public static WebElement AnnualPremium0_validation;

	@FindBy(xpath="//p-calendar[@id='StartDate1']/following-sibling::div[contains(text(),'Please enter valid Effective Date Range')]")
	public static WebElement StartDate1_validation;

	@FindBy(xpath="//p-calendar[@id='EndDate1']/following-sibling::div[contains(text(),'Please enter valid Expiration Date Range')]")
	public static WebElement EndDate1_validation;

	@FindBy(xpath="//input[@id='AnnualPremium1']/following::div[contains(text(),'Allow Numbers only.')][1]")
	public static WebElement AnnualPremium1_validation;

	@FindBy(xpath="//p-calendar[@id='StartDate2']/following-sibling::div[contains(text(),'Please enter valid Effective Date Range')]")
	public static WebElement StartDate2_validation;

	@FindBy(xpath="//p-calendar[@id='EndDate2']/following-sibling::div[contains(text(),'Please enter valid Expiration Date Range')]")
	public static WebElement EndDate2_validation;

	@FindBy(xpath="//input[@id='AnnualPremium2']/following::div[contains(text(),'Allow Numbers only.')][1]")
	public static WebElement AnnualPremium2_validation;

	@FindBy(xpath="//p-calendar[@id='StartDate3']/following-sibling::div[contains(text(),'Please enter valid Effective Date Range')]")
	public static WebElement StartDate3_validation;

	@FindBy(xpath="//p-calendar[@id='EndDate3']/following-sibling::div[contains(text(),'Please enter valid Expiration Date Range')]")
	public static WebElement EndDate3_validation;

	@FindBy(xpath="//input[@id='AnnualPremium3']/following::div[contains(text(),'Allow Numbers only.')][1]")
	public static WebElement AnnualPremium3_validation;

	@FindBy(xpath="//td[@id='EndDate']//div[contains(text(),'Expiration date should be greater than or +1 year from Effective date')]")
	public static WebElement expiration_greater_0;

	@FindBy(xpath="//p-calendar[@id='StartDate1']/following-sibling::div[contains(text(),'Dates are overlapping')]")
	public static WebElement dateOverlap_start1;

	@FindBy(xpath="//p-calendar[@id='EndDate1']/following-sibling::div[contains(text(),'Dates are overlapping')]")
	public static WebElement dateOverlap_end1;

	@FindBy(xpath="//i[@id='coverageField0']")
	public static WebElement reset0;

	@FindBy(xpath="//i[@id='coverageField1']")
	public static WebElement reset1;

	@FindBy(xpath="//i[@id='coverageField2']")
	public static WebElement reset2;


	//=======

	@FindBy(xpath="//p-calendar[@id='StartDate1']/span/input")
	public static WebElement effectiveDate1;

	@FindBy(xpath="//p-calendar[@id='EndDate1']/span/input")
	public static WebElement expirationDate1;

	@FindBy(xpath="//input[@id='PolicyNumber1']")
	public static WebElement policyNo1_txtb;

	@FindBy(xpath="//input[@id='CarrierName1']")
	public static WebElement carrierName1_txtb;

	@FindBy(xpath="//input[@id='AnnualPremium1']")
	public static WebElement annualPremium1_txtb;

	@FindBy(xpath="//tr[@id='coverageField'][2]/td[6]/i")
	public static WebElement reset1_btn;

	//================

	@FindBy(xpath="//p-calendar[@id='StartDate2']/span/input")
	public static WebElement effectiveDate2;

	@FindBy(xpath="//p-calendar[@id='EndDate2']/span/input")
	public static WebElement expirationDate2;

	@FindBy(xpath="//input[@id='PolicyNumber2']")
	public static WebElement policyNo2_txtb;

	@FindBy(xpath="//input[@id='CarrierName2']")
	public static WebElement carrierName2_txtb;

	@FindBy(xpath="//input[@id='AnnualPremium2']")
	public static WebElement annualPremium2_txtb;

	@FindBy(xpath="//tr[@id='coverageField'][3]/td[6]/i")
	public static WebElement reset2_btn;

	//================

	@FindBy(xpath="//p-calendar[@id='StartDate3']/span/input")
	public static WebElement effectiveDate3;

	@FindBy(xpath="//p-calendar[@id='EndDate3']/span/input")
	public static WebElement expirationDate3;

	@FindBy(xpath="//input[@id='PolicyNumber3']")
	public static WebElement policyNo3_txtb;

	@FindBy(xpath="//input[@id='CarrierName3']")
	public static WebElement carrierName3_txtb;

	@FindBy(xpath="//input[@id='AnnualPremium3']")
	public static WebElement annualPremium3_txtb;

	@FindBy(xpath="//tr[@id='coverageField'][4]/td[6]/i")
	public static WebElement reset3_btn;

	// This Locators are Not in Use.....


	//	==========================================================================================	


	//============ Loss Information Page 4 -1 ====================================//

	@FindBy(xpath="//h1[contains(text(),'How many claims has the Insured had in the past 3 years?')]")
	public static WebElement claimsInLast3Years_heading;

	@FindBy(xpath="//input[@id='TextIncrementer']/following::span[contains(text(),'+')]")
	public static WebElement plus_Incrementer_btn;

	@FindBy(xpath="//input[@id='TextIncrementer']/preceding-sibling::span[contains(text(),'-')]")
	public static WebElement minus_Incrementer_btn;

	@FindBy(xpath="//input[@id='TextIncrementer']")
	public static WebElement value_Incrementer_txt;

	@FindBy(xpath="//select[@id='TextIncrementer']")
	public static WebElement value_Incrementer_drpd;

	//=====================Loss Info Page 4 -2 ====================================//

	@FindBy(xpath="//p-calendar[@id='DateOfLoss0']/span/input")
	public static WebElement DateOfLoss0;

	@FindBy(xpath="//textarea[@id='DescriptionOfLoss0']")
	public static WebElement DescriptionOfLoss0_txtb;

	@FindBy(xpath="//input[@id='Closed0']/parent::label[contains(text(),'No')]")
	public static WebElement Closed0_No_radio;

	@FindBy(xpath="//input[@id='Closed0']/parent::label[contains(text(),'Yes')]")
	public static WebElement Closed0_Yes_radio;

	@FindBy(xpath="//input[@id='ReserveAmt0']")
	public static WebElement ReserveAmt0_txtb;

	@FindBy(xpath="//input[@id='PaidAmt0']")
	public static WebElement PaidAmt0_txtb;

	@FindBy(xpath="//input[@id='LostTime0']/parent::label[contains(text(),'No')]")
	public static WebElement LostTime0_No_radio;

	@FindBy(xpath="//input[@id='LostTime0']/parent::label[contains(text(),'Yes')]")
	public static WebElement LostTime0_Yes_radio;

	@FindBy(xpath="//input[@id='LostTime0']/parent::label[contains(text(),'Medical')]")
	public static WebElement Medical0_radio;

	@FindBy(xpath="//input[@id='LostTime0']/parent::label[contains(text(),'Indemnity')]")
	public static WebElement Indemnity0_radio;

	//============= 

	@FindBy(xpath="//p-calendar[@id='DateOfLoss1']/span/input")
	public static WebElement DateOfLoss1;

	@FindBy(xpath="//textarea[@id='DescriptionOfLoss1']")
	public static WebElement DescriptionOfLoss1_txtb;

	@FindBy(xpath="//input[@id='Closed1']/parent::label[contains(text(),'No')]")
	public static WebElement Closed1_No_radio;

	@FindBy(xpath="//input[@id='Closed1']/parent::label[contains(text(),'Yes')]")
	public static WebElement Closed1_Yes_radio;

	@FindBy(xpath="//input[@id='ReserveAmt1']")
	public static WebElement ReserveAmt1_txtb;

	@FindBy(xpath="//input[@id='PaidAmt1']")
	public static WebElement PaidAmt1_txtb;

	@FindBy(xpath="//input[@id='Not_Closed_0']/parent::label[contains(text(),'No')]")
	public static WebElement LostTime1_No_radio;

	@FindBy(xpath="//input[@id='Yes_Closed_0']/parent::label[contains(text(),'Yes')]")
	public static WebElement LostTime1_Yes_radio;

	@FindBy(xpath="//input[@id='Not_LostTime_0']/parent::label[contains(text(),'Medical')]")
	public static WebElement Medical1_radio;

	@FindBy(xpath="//input[@id='Yes_LostTime_0']/parent::label[contains(text(),'Indemnity')]")
	public static WebElement Indemnity1_radio;

	//===============

	@FindBy(xpath="//p-calendar[@id='DateOfLoss2']/span/input")
	public static WebElement DateOfLoss2;

	@FindBy(xpath="//textarea[@id='DescriptionOfLoss2']")
	public static WebElement DescriptionOfLoss2_txtb;

	@FindBy(xpath="//input[@id='Closed2']/parent::label[contains(text(),'No')]")
	public static WebElement Closed2_No_radio;

	@FindBy(xpath="//input[@id='Closed2']/parent::label[contains(text(),'Yes')]")
	public static WebElement Closed2_Yes_radio;

	@FindBy(xpath="//input[@id='ReserveAmt2']")
	public static WebElement ReserveAmt2_txtb;

	@FindBy(xpath="//input[@id='PaidAmt2']")
	public static WebElement PaidAmt2_txtb;

	@FindBy(xpath="//input[@id='Not_Closed_1']/parent::label[contains(text(),'No')]")
	public static WebElement LostTime2_No_radio;

	@FindBy(xpath="//input[@id='Yes_Closed_1']/parent::label[contains(text(),'Yes')]")
	public static WebElement LostTime2_Yes_radio;

	@FindBy(xpath="//*[@id='submissionForm']/div/div[1]/div[2]/div[1]/div/div[1]/table/tbody/tr/td[1]/div/div/div[1]")
	//@FindBy(xpath="//div[@class='error-message']/preceding-sibling::div[contains(text(),'Date of Loss must be between Effective Date and Expiration Date.')]")
	public static WebElement rangeBetween_DateOfLoss0;

	@FindBy(xpath="//p-calendar[@id='DateOfLoss0']/following-sibling::div[contains(text(),'Date of Loss must be within last 4 years from Effective Date.')]")
	public static WebElement rangeBetween_DateOfLoss0_new;

	@FindBy(xpath="//p-calendar[@id='DateOfLoss1']/following-sibling::div[contains(text(),'Date of Loss must be between Effective Date and Expiration Date.')]")
	public static WebElement rangeBetween_DateOfLoss1;

	@FindBy(xpath="//p-calendar[@id='DateOfLoss2']/following-sibling::div[contains(text(),'Date of Loss must be between Effective Date and Expiration Date.')]")
	public static WebElement rangeBetween_DateOfLoss2;

	@FindBy(xpath="//input[@id='Not_LostTime_1']/parent::label[contains(text(),'Medical')]")
	public static WebElement Medical2_radio;

	@FindBy(xpath="//input[@id='Yes_LostTime_0']/parent::label[contains(text(),'Indemnity')]")
	public static WebElement Indemnity2_radio;

	//========================
	@FindBy(xpath="//select[@id='TextIncrementer']/following::p/child::em[contains(text(),'Please email currently valued loss runs to comp@btisinc.com. Be sure to reference the quote number above.')]")
	public static WebElement lossInfo4year_msg;

	@FindBy(xpath="//textarea[@id='Description']")
	public static WebElement description_txtb;

	//==================================Loss Info page 4-3========================//

	//==================PAGE 5 CLASS CODES========================//
	@FindBy(xpath="//h3[contains(text(),'Class Codes')]")
	public static WebElement classCode_Heading;

	@FindBy(xpath="//button[contains(text(),'+add')]")
	public static WebElement addClasscode_btn;

	@FindBy(xpath="//div[@class='error-message pt-error']/following::i[@class='fal fa-trash-alt ng-star-inserted']")
	public static WebElement deleteClasscode_btn;

	@FindBy(xpath="//p-dropdown[@id='location0']")
	public static WebElement location0_drpd;
	
	@FindBy(xpath="//p-dropdown[@id='location0']/div/div[4]/div/ul/li/span")
	public static List<WebElement> location0_List;	
	
	@FindBy(xpath="//p-autocomplete[@id='classCode0']/span/input")
	public static WebElement classCode0_txtSearch;

	@FindBy(xpath="//p-autocomplete[@id='classCode0']/span/div/ul/li/span")
	public static List<WebElement> classCode0_List;

	@FindBy(xpath="//input[@id='payRoll0']")
	public static WebElement payRoll0_txtb;

	@FindBy(xpath="//input[@id='payRoll0']/following::div[contains(text(),'Only digits allowed, except 0')][1]")
	public static WebElement payRoll0_validation_msg;

	@FindBy(xpath="//input[@id='partTimeEmployee0']")
	public static WebElement partTimeEmployee0_txtb;

	@FindBy(xpath="//input[@id='partTimeEmployee0']/following::div[contains(text(),'Invalid')][1]")
	public static WebElement partTimeEmployee0_validation_msg;

	@FindBy(xpath="//input[@id='fullTimeEmployee0']")
	public static WebElement fullTimeEmployee0_txtb;

	@FindBy(xpath="//input[@id='fullTimeEmployee0']/following::div[contains(text(),'Invalid')][1]")
	public static WebElement fullTimeEmployee0_validation_msg;

	@FindBy(xpath="//p-dropdown[@id='location1']")
	public static WebElement location1_drpd;
	
	@FindBy(xpath="//p-dropdown[@id='location1']/div/div[4]/div/ul/li/span")
	public static List<WebElement> location1_List;	

	@FindBy(xpath="//p-autocomplete[@id='classCode1']/span/input")
	public static WebElement classCode1_txtSearch;

	@FindBy(xpath="//p-autocomplete[@id='classCode1']/span/div/ul/li/span")
	public static List<WebElement> classCode1_List;

	@FindBy(xpath="//input[@id='payRoll1']")
	public static WebElement payRoll1_txtb;

	@FindBy(xpath="//input[@id='partTimeEmployee1']")
	public static WebElement partTimeEmployee1_txtb;

	@FindBy(xpath="//input[@id='fullTimeEmployee1']")
	public static WebElement fullTimeEmployee1_txtb;

	//==================PAGE 6 Owners and Officers =======================//

	@FindBy(xpath="//button[contains(text(),'+add')]")
	public static WebElement addOwner_btn;

	@FindBy(xpath="//input[@id='owner_name0']")
	public static WebElement owner_name0_txtb;

	@FindBy(xpath="//input[@id='owner_name0']/following::div[contains(text(),'Initially spaces and special characters are not allowed.')][1]")
	public static WebElement owner_name0_validation_msg;

	@FindBy(xpath="//select[@id='relationship0']")
	public static WebElement relationship0_drpd;

	@FindBy(xpath="//input[@id='ownership0']")
	public static WebElement ownership0_txtb;

	@FindBy(xpath="//input[@id='ownership0']/following::div[contains(text(),'Allow numbers from 1 to 100.')][1]")
	public static WebElement ownership0_validation_msg;

	@FindBy(xpath="//select[@id='exclude/include0']")
	public static WebElement exclude0_drpd;

	@FindBy(xpath="//input[@id='owner_name1']")
	public static WebElement owner_name1_txtb;

	@FindBy(xpath="//select[@id='relationship1']")
	public static WebElement relationship1_drpd;

	@FindBy(xpath="//input[@id='ownership1']")
	public static WebElement ownership1_txtb;

	@FindBy(xpath="//select[@id='exclude/include1']")
	public static WebElement exclude1_drpd;

	@FindBy(xpath="//textarea[@id='DescriptionofOperation']")
	public static WebElement DescriptionofOperation_txtarea;

	@FindBy(xpath="//textarea[@id='DescriptionofOperation']/following-sibling::div[contains(text(),'Minimum 10 words is required')]")
	public static WebElement DescriptionofOperation_validation_msg;


	//=================Page 7 Credit Opportunity===================================================

	@FindBy(xpath="//p[contains(text(),'Is the owner directly involved in day-to-day operations?')]")
	public static WebElement q1;

	@FindBy(xpath="//input[@id='quest-1']/following::input[@id='Not_Valid_0']/following-sibling::span")
	public static WebElement quest1_No;

	@FindBy(xpath="//input[@id='quest-1']/following::input[@id='Valid_0']/following-sibling::span")
	public static WebElement quest1_Yes;

	@FindBy(xpath="//p[contains(text(),'Is the employee turnover under 10%?')]")
	public static WebElement q2;

	@FindBy(xpath="//input[@id='Not_Valid_1']/following-sibling::span")
	public static WebElement quest2_No;

	@FindBy(xpath="input[@id='Valid_1']/following-sibling::span")
	public static WebElement quest2_Yes;

	@FindBy(xpath="//p[contains(text(),'Are benefits provided for employees?')]")
	public static WebElement q3;

	@FindBy(xpath="//input[@id='Not_Valid_2']/following-sibling::span")
	public static WebElement quest3_No;

	@FindBy(xpath="input[@id='Valid_2']/following-sibling::span")
	public static WebElement quest3_Yes;

	@FindBy(xpath="//p[contains(text(),'Are drug testing of employees pre-employment?')]")
	public static WebElement q4;

	@FindBy(xpath="//input[@id='Not_Valid_3']/following-sibling::span")
	public static WebElement quest4_No;

	@FindBy(xpath="input[@id='Valid_3']/following-sibling::span")
	public static WebElement quest4_Yes;

	@FindBy(xpath="//p[contains(text(),'Does the owner have a minimum of 10 years experience in the industry of business?')]")
	public static WebElement q5;

	@FindBy(xpath="//input[@id='Not_Valid_4']/following-sibling::span")
	public static WebElement quest5_No;

	@FindBy(xpath="input[@id='Valid_4']/following-sibling::span")
	public static WebElement quest5_Yes;

	@FindBy(xpath="//p[contains(text(),'Are there formal accident investigation procedures in place?')]")
	public static WebElement q6;

	@FindBy(xpath="//input[@id='Not_Valid_5']/following-sibling::span")
	public static WebElement quest6_No;

	@FindBy(xpath="input[@id='Valid_5']/following-sibling::span")
	public static WebElement quest6_Yes;

	@FindBy(xpath="//p[contains(text(),'Is the supervisor to employee ratios low (1 sup / 12 or fewer employees)?')]")
	public static WebElement q7;

	@FindBy(xpath="//input[@id='Not_Valid_6']/following-sibling::span")
	public static WebElement quest7_No;

	@FindBy(xpath="input[@id='Valid_6']/following-sibling::span")
	public static WebElement quest7_Yes;

	@FindBy(xpath="//p[contains(text(),'Is there a return to work program in place?')]")
	public static WebElement q8;

	@FindBy(xpath="//input[@id='Not_Valid_7']/following-sibling::span")
	public static WebElement quest8_No;

	@FindBy(xpath="input[@id='Valid_7']/following-sibling::span")
	public static WebElement quest8_Yes;

	@FindBy(xpath="//p[contains(text(),'Is there a written safety program/policy?')]")
	public static WebElement q9;

	@FindBy(xpath="//input[@id='Not_Valid_8']/following-sibling::span")
	public static WebElement quest9_No;

	@FindBy(xpath="input[@id='Valid_8']/following-sibling::span")
	public static WebElement quest9_Yes;

	@FindBy(xpath="//p[contains(text(),'Is there a safety committee or designated safety manager?')]")
	public static WebElement q10;

	@FindBy(xpath="//input[@id='Not_Valid_9']/following-sibling::span")
	public static WebElement quest10_No;

	@FindBy(xpath="input[@id='Valid_9']/following-sibling::span")
	public static WebElement quest10_Yes;

	@FindBy(xpath="//p[contains(text(),'Are regular safety meetings held with employees?')]")
	public static WebElement q11;

	@FindBy(xpath="//input[@id='Not_Valid_10']/following-sibling::span")
	public static WebElement quest11_No;

	@FindBy(xpath="input[@id='Valid_10']/following-sibling::span")
	public static WebElement quest11_Yes;

	//=========================Page 8 Additional Info page========================

	@FindBy(xpath="//p[contains(text(),'Does the Applicant own, operate or lease aircraft/watercraft?')]")
	public static WebElement accord_0;

	@FindBy(xpath="//input[@id='QuestNotValid_0']/parent::label[contains(text(),'No')]")
	public static WebElement accord_0_No;

	@FindBy(xpath="//input[@id='QuestValid_0']/parent::label[contains(text(),'Yes')]")
	public static WebElement accord_0_Yes;

	@FindBy(xpath="//textarea[@id='_model.explaination0']")
	public static WebElement accord_0_textArea;




	@FindBy(xpath="//p[contains(text(),'Do / have past, present or discontinued operations involve')]")
	public static WebElement accord_1;

	@FindBy(xpath="//input[@id='QuestNotValid_1']/parent::label[contains(text(),'No')]")
	public static WebElement accord_1_No;

	@FindBy(xpath="//input[@id='QuestValid_1']/parent::label[contains(text(),'Yes')]")
	public static WebElement accord_1_Yes;

	@FindBy(xpath="//textarea[@id='_model.explaination1']")
	public static WebElement accord_1_textArea;



	@FindBy(xpath="//p[contains(text(),'Any work performed underground or above 15 feet')]")
	public static WebElement accord_2;

	@FindBy(xpath="//input[@id='QuestNotValid_2']/parent::label[contains(text(),'No')]")
	public static WebElement accord_2_No;

	@FindBy(xpath="//input[@id='QuestValid_2']/parent::label[contains(text(),'Yes')]")
	public static WebElement accord_2_Yes;

	@FindBy(xpath="//textarea[@id='_model.explaination2']")
	public static WebElement accord_2_textArea;



	@FindBy(xpath="//p[contains(text(),'Any work performed on barges, vessels, docks, bridge over water')]")
	public static WebElement accord_3;

	@FindBy(xpath="//input[@id='QuestNotValid_3']/parent::label[contains(text(),'No')]")
	public static WebElement accord_3_No;

	@FindBy(xpath="//input[@id='QuestValid_3']/parent::label[contains(text(),'Yes')]")
	public static WebElement accord_3_Yes;

	@FindBy(xpath="//textarea[@id='_model.explaination3']")
	public static WebElement accord_3_textArea;



	@FindBy(xpath="//p[contains(text(),'Is the Applicant engaged in any other type of business')]")
	public static WebElement accord_4;

	@FindBy(xpath="//input[@id='QuestNotValid_4']/parent::label[contains(text(),'No')]")
	public static WebElement accord_4_No;

	@FindBy(xpath="//input[@id='QuestValid_4']/parent::label[contains(text(),'Yes')]")
	public static WebElement accord_4_Yes;

	@FindBy(xpath="//textarea[@id='_model.explaination4']")
	public static WebElement accord_4_textArea;



	@FindBy(xpath="//p[contains(text(),'Are subcontractors used')]")
	public static WebElement accord_5;

	@FindBy(xpath="//input[@id='QuestNotValid_5']/parent::label[contains(text(),'No')]")
	public static WebElement accord_5_No;

	@FindBy(xpath="//input[@id='QuestValid_5']/parent::label[contains(text(),'Yes')]")
	public static WebElement accord_5_Yes;

	@FindBy(xpath="//textarea[@id='_model.explaination5']")
	public static WebElement accord_5_textArea;



	@FindBy(xpath="//p[contains(text(),'Any work sublet without certificates of insurance')]")
	public static WebElement accord_6;

	@FindBy(xpath="//input[@id='QuestNotValid_6']/parent::label[contains(text(),'No')]")
	public static WebElement accord_6_No;

	@FindBy(xpath="//input[@id='QuestValid_6']/parent::label[contains(text(),'Yes')]")
	public static WebElement accord_6_Yes;

	@FindBy(xpath="//textarea[@id='_model.explaination6']")
	public static WebElement accord_6_textArea;



	@FindBy(xpath="//p[contains(text(),'Is a written safety program in operation')]")
	public static WebElement accord_7;

	@FindBy(xpath="//input[@id='QuestNotValid_7']/parent::label[contains(text(),'No')]")
	public static WebElement accord_7_No;

	@FindBy(xpath="//input[@id='QuestValid_7']/parent::label[contains(text(),'Yes')]")
	public static WebElement accord_7_Yes;



	@FindBy(xpath="//p[contains(text(),'Any group transportation provided')]")
	public static WebElement accord_8;

	@FindBy(xpath="//input[@id='QuestNotValid_8']/parent::label[contains(text(),'No')]")
	public static WebElement accord_8_No;

	@FindBy(xpath="//input[@id='QuestValid_8']/parent::label[contains(text(),'Yes')]")
	public static WebElement accord_8_Yes;

	@FindBy(xpath="//textarea[@id='_model.explaination8']")
	public static WebElement accord_8_textArea;



	@FindBy(xpath="//p[contains(text(),'Any employees under 16 or over 60 years of age')]")
	public static WebElement accord_9;

	@FindBy(xpath="//input[@id='QuestNotValid_9']/parent::label[contains(text(),'No')]")
	public static WebElement accord_9_No;

	@FindBy(xpath="//input[@id='QuestValid_9']/parent::label[contains(text(),'Yes')]")
	public static WebElement accord_9_Yes;

	@FindBy(xpath="//textarea[@id='_model.explaination9']")
	public static WebElement accord_9_textArea;


	@FindBy(xpath="//p[contains(text(),'Any seasonal employees')]")
	public static WebElement accord_10;

	@FindBy(xpath="//input[@id='QuestNotValid_10']/parent::label[contains(text(),'No')]")
	public static WebElement accord_10_No;

	@FindBy(xpath="//input[@id='QuestValid_10']/parent::label[contains(text(),'Yes')]")
	public static WebElement accord_10_Yes;

	@FindBy(xpath="//textarea[@id='_model.explaination10']")
	public static WebElement accord_10_textArea;


	@FindBy(xpath="//p[contains(text(),'Is there any volunteer or donated labor')]")
	public static WebElement accord_11;

	@FindBy(xpath="//input[@id='QuestNotValid_11']/parent::label[contains(text(),'No')]")
	public static WebElement accord_11_No;

	@FindBy(xpath="//input[@id='QuestValid_11']/parent::label[contains(text(),'Yes')]")
	public static WebElement accord_11_Yes;

	@FindBy(xpath="//textarea[@id='_model.explaination11']")
	public static WebElement accord_11_textArea;



	@FindBy(xpath="//p[contains(text(),'Any employees with physical handicaps')]")
	public static WebElement accord_12;

	@FindBy(xpath="//input[@id='QuestNotValid_12']/parent::label[contains(text(),'No')]")
	public static WebElement accord_12_No;

	@FindBy(xpath="//input[@id='QuestValid_12']/parent::label[contains(text(),'Yes')]")
	public static WebElement accord_12_Yes;

	@FindBy(xpath="//textarea[@id='_model.explaination12']")
	public static WebElement accord_12_textArea;


	@FindBy(xpath="//p[contains(text(),'Do employees travel out of state')]")
	public static WebElement accord_13;

	@FindBy(xpath="//input[@id='QuestNotValid_13']/parent::label[contains(text(),'No')]")
	public static WebElement accord_13_No;

	@FindBy(xpath="//input[@id='QuestValid_13']/parent::label[contains(text(),'Yes')]")
	public static WebElement accord_13_Yes;

	@FindBy(xpath="//textarea[@id='_model.explaination13']")
	public static WebElement accord_13_textArea;


	@FindBy(xpath="//p[contains(text(),'Are athletic teams sponsored')]")
	public static WebElement accord_14;

	@FindBy(xpath="//input[@id='QuestNotValid_14']/parent::label[contains(text(),'No')]")
	public static WebElement accord_14_No;

	@FindBy(xpath="//input[@id='QuestValid_14']/parent::label[contains(text(),'Yes')]")
	public static WebElement accord_14_Yes;

	@FindBy(xpath="//textarea[@id='_model.explaination14']")
	public static WebElement accord_14_textArea;



	@FindBy(xpath="//p[contains(text(),'Are physicals required after offers of employment are made?')]")
	public static WebElement accord_15;

	@FindBy(xpath="//input[@id='QuestNotValid_15']/parent::label[contains(text(),'No')]")
	public static WebElement accord_15_No;

	@FindBy(xpath="//input[@id='QuestValid_15']/parent::label[contains(text(),'Yes')]")
	public static WebElement accord_15_Yes;

	@FindBy(xpath="//textarea[@id='_model.explaination15']")
	public static WebElement accord_15_textArea;




	@FindBy(xpath="//p[contains(text(),'Any other insurance with this insurer?')]")
	public static WebElement accord_16;

	@FindBy(xpath="//input[@id='QuestNotValid_16']/parent::label[contains(text(),'No')]")
	public static WebElement accord_16_No;

	@FindBy(xpath="//input[@id='QuestValid_16']/parent::label[contains(text(),'Yes')]")
	public static WebElement accord_16_Yes;

	@FindBy(xpath="//textarea[@id='_model.explaination16']")
	public static WebElement accord_16_textArea;




	@FindBy(xpath="//p[contains(text(),'Any prior coverage declined/cancelled/non-renewed')]")
	public static WebElement accord_17;

	@FindBy(xpath="//input[@id='QuestNotValid_17']/parent::label[contains(text(),'No')]")
	public static WebElement accord_17_No;

	@FindBy(xpath="//input[@id='QuestValid_17']/parent::label[contains(text(),'Yes')]")
	public static WebElement accord_17_Yes;

	@FindBy(xpath="//textarea[@id='_model.explaination17']")
	public static WebElement accord_17_textArea;



	@FindBy(xpath="//p[contains(text(),'Are employee health plans provided?')]")
	public static WebElement accord_18;

	@FindBy(xpath="//input[@id='QuestNotValid_18']/parent::label[contains(text(),'No')]")
	public static WebElement accord_18_No;

	@FindBy(xpath="//input[@id='QuestValid_18']/parent::label[contains(text(),'Yes')]")
	public static WebElement accord_18_Yes;

	@FindBy(xpath="//textarea[@id='_model.explaination18']")
	public static WebElement accord_18_textArea;



	@FindBy(xpath="//p[contains(text(),'Do any employees perform work for other businesses or subsidiaries?')]")
	public static WebElement accord_19;

	@FindBy(xpath="//input[@id='QuestNotValid_19']/parent::label[contains(text(),'No')]")
	public static WebElement accord_19_No;

	@FindBy(xpath="//input[@id='QuestValid_19']/parent::label[contains(text(),'Yes')]")
	public static WebElement accord_19_Yes;

	@FindBy(xpath="//textarea[@id='_model.explaination19']")
	public static WebElement accord_19_textArea;



	@FindBy(xpath="//p[contains(text(),'Does the Applicant lease employees to or from other employers?')]")
	public static WebElement accord_20;

	@FindBy(xpath="//input[@id='QuestNotValid_20']/parent::label[contains(text(),'No')]")
	public static WebElement accord_20_No;

	@FindBy(xpath="//input[@id='QuestValid_20']/parent::label[contains(text(),'Yes')]")
	public static WebElement accord_20_Yes;

	@FindBy(xpath="//textarea[@id='_model.explaination20']")
	public static WebElement accord_20_textArea;



	@FindBy(xpath="//p[contains(text(),'Do any employees predominantly work at home')]")
	public static WebElement accord_21;

	@FindBy(xpath="//input[@id='QuestNotValid_21']/parent::label[contains(text(),'No')]")
	public static WebElement accord_21_No;

	@FindBy(xpath="//input[@id='QuestValid_21']/parent::label[contains(text(),'Yes')]")
	public static WebElement accord_21_Yes;

	@FindBy(xpath="//textarea[@id='_model.explaination21']")
	public static WebElement accord_21_textArea;



	@FindBy(xpath="//p[contains(text(),'Any tax liens or bankruptcy within the last 5 years?')]")
	public static WebElement accord_22;

	@FindBy(xpath="//input[@id='QuestNotValid_22']/parent::label[contains(text(),'No')]")
	public static WebElement accord_22_No;

	@FindBy(xpath="//input[@id='QuestValid_22']/parent::label[contains(text(),'Yes')]")
	public static WebElement accord_22_Yes;

	@FindBy(xpath="//textarea[@id='_model.explaination22']")
	public static WebElement accord_22_textArea;


	@FindBy(xpath="//p[contains(text(),'Any undisputed and unpaid workers compensation premium due from you or any company managed or owned enterprises')]")
	public static WebElement accord_23;

	@FindBy(xpath="//input[@id='QuestNotValid_23']/parent::label[contains(text(),'No')]")
	public static WebElement accord_23_No;

	@FindBy(xpath="//input[@id='QuestValid_23']/parent::label[contains(text(),'Yes')]")
	public static WebElement accord_23_Yes;

	@FindBy(xpath="//textarea[@id='_model.explaination23']")
	public static WebElement accord_23_textArea;

	//===================Carrier selection==================================

	@FindBy(xpath="//label[@for='EMPLOYERS']")
	public static WebElement EMPLOYERS_btn;

	@FindBy(xpath="//label[@for='AMTRUSTWC']")
	public static WebElement AMTRUSTWC_btn;
	
	@FindBy(xpath="//label[@for='PIE']")
	public static WebElement pie_btn;
	
	@FindBy(xpath="//label[@for='OTHER']")
	public static WebElement other_btn;

	@FindBy(xpath="//span[contains(text(),'Please select all available carriers you wish to proceed with')]")
	public static WebElement carreierPage_text;

	//==============================================Final Carrier selection============

	@FindBy(xpath="//span[@class='carrier-selection-heading']")
	public static WebElement priceIndiacationPage_Heading;

	@FindBy(xpath="//input[@class='input-img AMTRUSTWC']")
	public static WebElement carrierAMTRUSTWC;

	@FindBy(xpath="//input[@class='input-img EMPLOYERS']")
	public static WebElement carrierEMPLOYERS;

	@FindBy(xpath="//input[@class='input-img OTHER']")
	public static WebElement carrierOthers;

	@FindBy(xpath="//input[@class='input-img AMTRUSTWC']/following::label[@id='rate0']")
	public static WebElement annualPremiumAMTRUSTWC;

	@FindBy(xpath="//input[@class='input-img EMPLOYERS']/following::label[@id='rate1']")
	public static WebElement annualPremiumEMPLOYERS;
	
	@FindBy(xpath="//input[@class='input-img PIE']/following::label[@id='rate0']")
	public static WebElement annualPremiumPIE;
	
	@FindBy(xpath="//input[@class='input-img EMPLOYERS']/following::label[@id='rate0']")
	public static WebElement annualPremiumEMPLOYERS1;

	@FindBy(xpath="//input[@class='input-img OTHER']/following::label[@id='rate2']")
	public static WebElement annualPremiumOTHERS;

	@FindBy(xpath="//input[@class='input-img AMTRUSTWC']/following::input[@id='rateLimits0']")
	public static WebElement annualLimitAMTRUSTWC;

	@FindBy(xpath="//input[@class='input-img EMPLOYERS']/following::input[@id='rateLimits1']")
	public static WebElement annualLimitEMPLOYERS;
	
	@FindBy(xpath="//input[@class='input-img PIE']/following::input[@id='rateLimits0']")
	public static WebElement annualLimitPIE;
	
	@FindBy(xpath="//input[@class='input-img EMPLOYERS']/following::input[@id='rateLimits0']")
	public static WebElement annualLimitEMPLOYERS1;

	@FindBy(xpath="//input[@class='input-img OTHER']/following::input[@name='limits'][1]")
	public static WebElement annualLimitOTHERS;

	@FindBy(xpath="//input[@class='input-img AMTRUSTWC']/following::button[contains(text(),'Proceed with Quote')][1]")
	public static WebElement proceedWith_AMTRUSTWC;

	@FindBy(xpath="//input[@class='input-img EMPLOYERS']/following::button[contains(text(),'Proceed with Quote')][1]")
	public static WebElement proceedWith_EMPLOYERS;
	
	
	//@FindBy(xpath="//div[@class='ng-star-inserted']/child::button[contains(text(),'Submit To UW')]")
	@FindBy(xpath="//button[@id='btnSubmitToUW']")
	public static WebElement submitUW1;
	
	@FindBy(xpath="//button[@id='submitToUW']")
	public static WebElement submitUW;
	
	@FindBy(xpath="//button[@id='submitToUW_2']")
	public static WebElement submitUW2;
	
	@FindBy(xpath="//button[@id='submitToUW_0']")
	public static WebElement submitUW0;
	
	//=================== the Sub-Class Code=========================

	@FindBy(xpath="//input[@id='classCode0']")
	public static WebElement subMainClasscode1;

	@FindBy(xpath="//input[@id='description0']")
	public static WebElement subDescription1;

	@FindBy(xpath="//input[@id='classCode0']/following::p-dropdown[@id='subclassCode0']")
	public static WebElement subClasscode1;
	
	@FindBy(xpath="//p-dropdown[@id='subclassCode0']/div/div[4]/div/ul/li/span")
	public static List<WebElement> subClasscode1_List;	

	@FindBy(xpath="//input[@id='classCode1']")
	public static WebElement subMainClasscode2;

	@FindBy(xpath="//input[@id='description1']")
	public static WebElement subDescription2;

	@FindBy(xpath="//input[@id='classCode1']/following::p-dropdown[@id='subclassCode1']")
	public static WebElement subClasscode2;
	
	@FindBy(xpath="//p-dropdown[@id='subclassCode1']/div/div[4]/div/ul/li/span")
	public static List<WebElement> subClasscode2_List;

	//====================Carrier Specific Questions Employeer======================

	@FindBy(xpath="//div[contains(text(),'Does the Applicant engage sub-contractors or independent contractors?')]")
	public static WebElement carrierQ1;

	@FindBy(xpath="//div[contains(text(),'Does the Applicant use motor vehicles for business purposes?')]")
	public static WebElement carrierQ2;

	@FindBy(xpath="//div[contains(text(),'Does the Applicant provide group transportation, where five or more employees are in a vehicle at one time?')]")
	public static WebElement carrierQ3;

	@FindBy(xpath="//div[contains(text(),'Any prior coverage declined/cancelled/non-renewed in the last three (3) years?')]")
	public static WebElement carrierQ4;

	@FindBy(xpath="//div[contains(text(),'Are employee health plans provided?')]")
	public static WebElement carrierQ5;

	@FindBy(xpath="//div[contains(text(),'Do you lease employees to or from other employers?')]")
	public static WebElement carrierQ6;

	@FindBy(xpath="//div[contains(text(),'Does Applicant own, operate or lease aircraft/watercraft?')]")
	public static WebElement carrierQ7;

	@FindBy(xpath="//div[contains(text(),'Applicant provides emergency roadside assistance, mobile auto repair, or city, county, or municipality towing-for-hire services.')]")
	public static WebElement carrierQ8;

	@FindBy(xpath="//div[contains(text(),'Applicant performs repair on motorcycle, bus, recreational vehicle, commercial truck, industrial truck, and trailers or performs testing on watercraft or jet skiing.')]")
	public static WebElement carrierQ9;

	@FindBy(xpath="//div[contains(text(),'Applicant has cover charges, bouncers, crowd control, or armed security guards.')]")
	public static WebElement carrierQ10;

	@FindBy(xpath="//div[contains(text(),'Two or more employees are on duty at all times.')]")
	public static WebElement carrierQ11;

	@FindBy(xpath="//div[contains(text(),'Business is open after 2:00 a.m.')]")
	public static WebElement carrierQ12;

	@FindBy(xpath="//div[contains(text(),'Applicant delivers to customers, provides off-premises catering or operates mobile catering services.')]")
	public static WebElement carrierQ13;

	@FindBy(xpath="//div[contains(text(),'Applicant has a minimum of eight gasoline nozzles at each location.')]")
	public static WebElement carrierQ14;

	@FindBy(xpath="//div[contains(text(),'Applicant provides photography work for television, newspapers, magazines, or media outlets')]")
	public static WebElement carrierQ15;


	//====================Carrier Specific Questions AMTrust======================

	@FindBy(xpath="//div[contains(text(),'Does business have more than 50 people working at one location at a time?')]")
	public static WebElement carrierAMQ1;

	@FindBy(xpath="//div[contains(text(),'Does business currently have workers compensation coverage in effect?')]")
	public static WebElement carrierAMQ2;

	@FindBy(xpath="//div[contains(text(),'In the past 2 years has business had 2 or more Workers Compensation claims, a single')]")
	public static WebElement carrierAMQ3;

	@FindBy(xpath="//div[contains(text(),'Does the business employ or contract any type of armed/non- armed security guards?')]")
	public static WebElement carrierAMQ4;

	//==========================Thank you page=================================

	@FindBy(xpath="//p[contains(text(),'Thank you for your business!')]")
	public static WebElement thankYou_page_txt;

	//==================Payment Paln Page =================================//

	//AmTrust as Carrier

	@FindBy(xpath="//select[@id='paymentPlan0']")
	public static WebElement paymentPlan;

	/*Standard Payment in Full 
	 *Standard Payment 50% Down + 1 installment 
	 *Standard Payment 25% Down + 3 Monthly installments 
	 *Standard Payment 10 Monthly installments 
	 *PAYO 
	 *Direct Debit Payment in Full 
	 *Direct Debit 50% Down + 1 installment 
	 *Direct Debit Payment 25% Down + 3 Monthly installments 
	 *Direct Debit Payment 10 Monthly installments 
	 *Direct Debit Payment 12 Monthly Installments 
	 */

	@FindBy(xpath="//input[@id='paymentInValidQuest1']/parent::label[contains(text(),'No')]")
	public static WebElement directDebit_No;

	@FindBy(xpath="//input[@id='paymentValidQuest1']/parent::label[contains(text(),'Yes')]")
	public static WebElement directDebit_Yes;

	@FindBy(xpath="//select[@id='paymentPlan1']")
	public static WebElement payrollCompany;

	//If  PAYO is selected as Payment Plan. fro AMTrust.
	/*Reliable Premium Management 
	Payroll Office of America 
	Heartland Payroll Solutions 
	Paylocity 
	Term - Use Heartland ID #73 
	Payroll Data Processing 
	SmartPay Solutions LLC 
	Payroll Centric fka NetPay Services Inc 
	Apex Payroll 
	SBS Payroll, Inc. 
	Payroll Link, Inc 
	Rapid Data Inc 
	Pink Payroll 
	Business Payroll Services, Inc 
	Payroll Plus CA 
	BLI Payroll Solutions, Inc. 
	L&G Payroll Center 
	AIU Payroll, Inc 
	TJH Payroll 
	Amcheck Payroll NV 
	HRX Payroll 
	Pinnacle Payroll Solutions 
	Meridian Payroll Group 
	Mise en Place Restaurant Services, Inc. */


	// Employer - & there Payement plan page

	/*
	 * In Payment plan page for Employers only.
	 * 1    100% Down   :    0
	 * 2    30% Down + 3 Equal Installments : 1000
	 * 3    10% Down + 9 Equal Installments : 2500
	 * 4    0% Down + Pay-As-You-Go : 2500
	 */
	/*
	 * 100% Down
	 * 30% Down + 3 Equal Installments 
	 * 10% Down + 9 Equal Installments 
	 * 0% Down + Pay-As-You-Go 
	 */

	//PAYEMENT BreakDown Page

	@FindBy(xpath="//h3[contains(text(),'Payment Breakdown')]")
	public static WebElement paymentBreakDown_pageHeading;

	@FindBy(xpath="//input[@id='brokerFee_id']")
	public static WebElement brokerFee_txtb;

	@FindBy(xpath="//button[@id='btnSaveBrokerFee']")
	public static WebElement saveBrokerFee_btn;

	@FindBy(xpath="//label[contains(text(),'Comp Premium')]/following-sibling::div[1]/child::span")
	public static WebElement wokerCom_premium_Fee;

	@FindBy(xpath="//label[contains(text(),'Broker Fee')]/preceding::div[2]/child::span")
	public static WebElement btis_service_Fee;

	@FindBy(xpath="//label[contains(text(),'Gross Total')]/preceding::div[1]/child::span")
	public static WebElement broker_Fees;

	@FindBy(xpath="//label[contains(text(),'Gross Total')]/following-sibling::div[2]/following::span[1]")
	public static WebElement grossTotal_Fee;

	@FindBy(xpath="//a[@class='link' and contains(text(),'clicking here.')]")
	public static WebElement clickTogoTo_priceIndicationPage_link;

	@FindBy(xpath="//p[contains(text(),'Download Summary Review')]")
	public static WebElement download_summary_link;

	@FindBy(xpath="//button[@id='btnBind']")
	public static WebElement bind_btn;

	@FindBy(xpath="//button[@id='btnYes']")
	public static WebElement bind_YES_btn;

	@FindBy(xpath="//button[@id='btnNo']")
	public static WebElement bind_NO_btn;

	@FindBy(xpath="//button[@id='btnPayNowAndBind']")
	public static WebElement btnPayNowAndBind_btn;

	// Thank you Page
	@FindBy(xpath="//h3[contains(text(),'Thank You!')]")
	public static WebElement finalThankYou;
	
	@FindBy(xpath="//div[@class='loader-thank-you']/child::div[1]/child::div[1]/child::div[1]/child::p[contains(text(),'We have received your payment.')]")
	public static WebElement poaymentReceived_msg;
	
	@FindBy(xpath="//p[contains(text(),'Policy Number :')]/b")
	public static WebElement policyNo;

	@FindBy(xpath="//p[contains(text(),'Thank you for binding with')]/b")
	public static WebElement CarrierFinal_name ;

	@FindBy(xpath="//input[@id='btnClose']")
	public static WebElement close_btn;
	
	@FindBy(xpath="//input[@id='close']")
	public static WebElement close_btn1;

	//payment pop up page

	@FindBy(xpath="//label[@class='payment-select']/child::span[2][contains(text(),'Credit Card')]")
	public static WebElement CreditCard_btn;

	@FindBy(xpath="//label[@class='payment-select']/child::span[2][contains(text(),'ACH/eCheck')]")
	public static WebElement TeleCheck_btn;

	@FindBy(xpath="//input[@value='Pay Now']")
	public static WebElement payNow_btn;

	//<iframe id="payment-form-iframe" class="embed-responsive-item" name="payment-form-iframe" style="overflow: hidden; height: 500px; width: 100%; position: absolute;" frameborder="0">

	//===================Payment gateway=================================

	//Choose Payment Option

	@FindBy(xpath="//div[@id='order']/p[1]/span[@class='total_value']")
	public static WebElement  orderAmountUSD;

	@FindBy(xpath="//div[@id='order']/p[2]/span[@class='total_value']")
	public static WebElement  convenience_Fee;

	@FindBy(xpath="//div[@id='order']/p[3]/span[@class='total_value']")
	public static WebElement  totalAmountUSD;

	@FindBy(xpath="//input[@id='f_cc']")
	public static WebElement  cc_opayment_radio;

	@FindBy(xpath="//input[@id='f_tc']")
	public static WebElement cheque_payement_radio ;

	@FindBy(xpath="//input[@id='exact_cardholder_name']")
	public static WebElement  exact_cardholder_name;

	@FindBy(xpath="//input[@id='x_address']")
	public static WebElement  x_address;

	@FindBy(xpath="//input[@id='x_city']")
	public static WebElement  x_city;

	@FindBy(xpath="//select[@id='x_state']")
	public static WebElement  x_state;

	@FindBy(xpath="//input[@id='x_zip']")
	public static WebElement  x_zip;

	@FindBy(xpath="//input[@id='x_exp_date']")
	public static WebElement x_exp_date;

	@FindBy(xpath="//input[@id='x_card_num']")
	public static WebElement  x_card_num;

	@FindBy(xpath="//input[@id='x_card_code']")
	public static WebElement x_card_code;

	@FindBy(xpath="//select[@id='cvd_presence_ind']")
	public static WebElement  cvd_presence_ind;

	@FindBy(xpath="//input[@id='cc_email']")
	public static WebElement cc_email;

	@FindBy(xpath="//div[@id='cc']/form/input[@value='Pay Now']")
	public static WebElement  pay_now_btn;
}

