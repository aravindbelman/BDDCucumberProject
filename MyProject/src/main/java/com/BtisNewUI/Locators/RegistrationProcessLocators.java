package com.BtisNewUI.Locators;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.LegacyApplication.TestBase.TestBase;

public class RegistrationProcessLocators extends TestBase{
	public static WebDriver driver;

	public static final Logger log=Logger.getLogger(RegistrationProcessLocators.class.getName());
	
	//===========================Registration tab=========================//
	
	@FindBy(xpath="//a[@href='/welcome/register']/descendant::span[contains(text(),'REGISTER')]")
	public static WebElement register_btn;		
	
	//===================Register Now Button=====================
	@FindBy(xpath="//a[contains(text(),'Register Now')]")
	public static WebElement register_now_btn;
	
	//==================Pages Hedings acts as switch between pages===========
	@FindBy(xpath="//span[contains(text(),'Agency Info')]")
	public static WebElement agencyInfo_page_btn;
	
	@FindBy(xpath="//span[contains(text(),'Contact Info')]")
	public static WebElement contactInfo_page_btn;
	
	@FindBy(xpath="//span[contains(text(),'Errors & Omissions Policy Info')]")
	public static WebElement errorInfo_page_btn;
	
	@FindBy(xpath="//span[contains(text(),'Agency Eligibility Questionnaire')]")
	public static WebElement agencyElgibility_page_btn;
	
	@FindBy(xpath="//span[contains(text(),'Upload Documents')]")
	public static WebElement uploadDoc_page_btn;
	
	//==========================Agency Info page elements locators=============================================
	
	@FindBy(xpath="//select[@name='agentType']")
	public static WebElement agentType_drpd;
	
	@FindBy(xpath="//input[@name='LicenseNo']")
	public static WebElement LicenseNo_txtb;
	
	@FindBy(xpath="//input[@name='AgencyName']")
	public static WebElement AgencyName_txtb;
	
	@FindBy(xpath="//input[@name='FederalTaxId']")
	public static WebElement fein_tin_txtb;
	
	@FindBy(xpath="//input[@name='TaxIDName']")
	public static WebElement TaxIDName_txtb;
	
	@FindBy(xpath="//select[@name='BusinessType']")
	public static WebElement BusinessType_drpd;
	
	@FindBy(xpath="//input[@name='PrincipalName']")
	public static WebElement PrincipalName_txtb;
	
	@FindBy(xpath="//input[@name='PrincipalEmail']")
	public static WebElement PrincipalEmail_txtb;
	
	//=========================Save & Contuinue common Button==================
	
	@FindBy(xpath="//input[@type='submit']")
	public static WebElement save_continue_Cmn_btn;
	
	//======================Contact Info page================================
	
	@FindBy(xpath="//input[@name='address1' and @placeholder='Street Address']")
	public static WebElement streetAddress_txtb;
	
	@FindBy(xpath="//input[@name='address2']")
	public static WebElement address2_txtb;
	
	@FindBy(xpath="//input[@name='City']")
	public static WebElement City_txtb;
	
	@FindBy(xpath="//select[@name='State']")
	public static WebElement State_drpd;
	
	@FindBy(xpath="//input[@name='Zip']")
	public static WebElement Zip_txtb;
		
	//===============Do you have a separate mailing address?=============
	@FindBy(xpath="//span[contains(text(),'Do you have a separate mailing address?')]/following::input[@value='Yes']")
	public static WebElement mailingAddress_Yes_btn;
	
	@FindBy(xpath="//span[contains(text(),'Do you have a separate mailing address?')]/following::input[@value='No']")
	public static WebElement mailingAddress_No_btn;
	
	//=============Mailing address==============================
	
	@FindBy(xpath="//input[@name='mailingAddress1' and @placeholder='Street Address']")
	public static WebElement Mail_streetAddress_txtb;
	
	@FindBy(xpath="//input[@name='mailingAddress2']")
	public static WebElement Mail_address2_txtb;
	
	@FindBy(xpath="//input[@name='MailingCity']")
	public static WebElement Mail_City_txtb;
	
	@FindBy(xpath="//select[@name='MailingStateID']")
	public static WebElement Mail_State_drpd;
	
	@FindBy(xpath="//input[@name='MailingZip']")
	public static WebElement Mail_Zip_txtb;
		
	@FindBy(xpath="//input[@name='PhoneNumber']")
	public static WebElement PhoneNumber_txtb;
	
	@FindBy(xpath="//input[@name='MobileNumber']")
	public static WebElement MobileNumber_txtb;
	
	@FindBy(xpath="//input[@name='ContactName']")
	public static WebElement ContactName_txtb;
	
	@FindBy(xpath="//input[@name='ContactEmail']")
	public static WebElement ContactEmail_txtb;
	
	//============================Errors and Omissions Policy Information============================
	
	@FindBy(xpath="//input[@name='EOPNumber']")
	public static WebElement EOPNumber_txtb;
	
	@FindBy(xpath="//input[@name='EOPCarrierName']")
	public static WebElement EOPCarrierName_txtb;
	
	@FindBy(xpath="//input[@id='your_unique_id']")
	public static WebElement exp_date;
	
	@FindBy(xpath="//select[@name='EOPLimit']")
	public static WebElement EOPLimit_drpd;
	
	//===========================Agency Eligibility Questionnaire===================================
	
	//Has your agency or any partners, officers, owners, or producers of the agency ever been subject to any Department of Insurance action regarding a violation?
	
	@FindBy(xpath="//span[contains(text(),'Has your agency or any partner')]/following::div[1]/child::div/child::div[2]/child::input[@value='YES']")
	public static WebElement ViolationExplanation_yes;
	
	@FindBy(xpath="//span[contains(text(),'Has your agency or any partner')]/following::div[1]/child::div/child::div[3]/child::input[@value='NO']")
	public static WebElement ViolationExplanation_no;
	
	@FindBy(xpath="//textarea[@name='ViolationExplanation']")
	public static WebElement ViolationExplanation_txtb;
	
	//Have there been any Errors & Omissions (E & O) claims made against your agency, partners, officers, owners, or producers in the past five (5) years?
	
	@FindBy(xpath="//span[contains(text(),'Have there been any Errors & Omissions ')]/following::div[1]/child::div/child::div[2]/child::input[@value='YES']")
	public static WebElement EAndOClaimsInPastFiveExplanation_yes;
	
	@FindBy(xpath="//span[contains(text(),'Have there been any Errors & Omissions ')]/following::div[1]/child::div/child::div[3]/child::input[@value='NO']")
	public static WebElement EAndOClaimsInPastFiveExplanation_no;
	
	@FindBy(xpath="//textarea[@name='EAndOClaimsInPastFiveExplanation']")
	public static WebElement EAndOClaimsInPastFiveExplanation_txtb;
	
	//Has your agency and/or partners, officers, or owners filed for bankruptcy in the past five (5) years?
	
	@FindBy(xpath="//span[contains(text(),'Has your agency and/or partners')]/following::div[1]/child::div/child::div[2]/child::input[@value='YES']")
	public static WebElement BankruptcyInPastFiveExplanation_yes;
	
	@FindBy(xpath="//span[contains(text(),'Has your agency and/or partners')]/following::div[1]/child::div/child::div[3]/child::input[@value='NO']")
	public static WebElement BankruptcyInPastFiveExplanation_no;
	
	@FindBy(xpath="//textarea[@name='BankruptcyInPastFiveExplanation']")
	public static WebElement BankruptcyInPastFiveExplanation_txtb;
	
	//Are there currently any open liens levied against your agency and/or partners, officers, or owners?
	
	@FindBy(xpath="//span[contains(text(),'Are there currently any open liens')]/following::div[1]/child::div/child::div[2]/child::input[@value='YES']")
	public static WebElement OpenLiensExplanation_yes;
	
	@FindBy(xpath="//span[contains(text(),'Are there currently any open liens')]/following::div[1]/child::div/child::div[3]/child::input[@value='NO']")
	public static WebElement OpenLiensExplanation_no;
	
	@FindBy(xpath="//textarea[@name='OpenLiensExplanation']")
	public static WebElement OpenLiensExplanation_txtb;
	
	@FindBy(xpath="//input[@name='HowDidYouHearAboutUs']")
	public static WebElement HowDidYouHearAboutUs_txtb;
	
	//==============Upload Your Documents===============================
	
	@FindBy(xpath="//input[@id='agencyLicenseFile']/following-sibling::label[contains(text(),'Choose file')]")
	public static WebElement agencyLicenseFile;
	
	@FindBy(xpath="//input[@id='proofOfInsuranceFile']/following-sibling::label[contains(text(),'Choose file')]")
	public static WebElement proofOfInsuranceFile;
	
	@FindBy(xpath="//input[@id='w9File']/following-sibling::label[contains(text(),'Choose file')]")
	public static WebElement w9File;
	
}
