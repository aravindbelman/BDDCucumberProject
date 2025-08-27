package com.BtisNewUI.Locators;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.LegacyApplication.TestBase.TestBase;

public class GlDirectLocators extends TestBase {
	
	public static WebDriver driver;
	
	public static final Logger log=Logger.getLogger(GlDirectLocators.class.getName());
	
	//....................>>Victory Admitted Contractor General Liability Quote Now Locators<<.............................//
	
	@FindBy(xpath="//a[@class='btn btn-secondary btn-lg' and contains(text(),'Quote Now')]")
	public static WebElement GLdirect_quoteNowBtn;
	
	//....................>>Estimated Price page Locators<<.............................//
	
	@FindBy(xpath="//input[@id='postalCode' and @type='text']")
	public static WebElement GLdirect_zipCode;
	
	@FindBy(xpath="//select[@id='classification' and @formcontrolname='classification']")
	public static WebElement Gldirect_classificationDrpDwn;
	
	@FindBy(xpath="//input[@id='effectiveDate' and @type='text']")
	public static WebElement GLdirect_effectiveDate_textField;
	
	@FindBy(xpath="//select[@id='businessExperience']")
	public static WebElement GLdirect_businessExperiencedrpDwn;
	
	@FindBy(xpath="//input[@id='activeOwners']")
	public static WebElement GLdirect_activeOwners_textField;
	
	@FindBy(xpath="//input[@id='annualEmployeePayroll' and @type='text']")
	public static WebElement GLdirect_annualEmployeePayrl_textField;
	
	@FindBy(xpath="//input[@id='numberOfEmployees']")
	public static WebElement GLdirect_annualEmployeeCount_textField;
	
	@FindBy(xpath="//input[@id='annualGrossReceipts' and @type='text']")
	public static WebElement GLdirect_annualGrossReceipts_textField;
	
	@FindBy(xpath="//input[@id='annualSubcontractingCosts' and @type='text']")
	public static WebElement GLdirect_annualSubcontractingCosts_textField;
	
	@FindBy(xpath="//span[contains(text(),' Does the applicant have employees')]/following-sibling::input[@class='btn btn-default'][@value='Yes']")
	public static WebElement haveEmployees_Yes_Btn;
	
	@FindBy(xpath="//span[contains(text(),' Does the applicant have employees')]/following-sibling::input[@class='btn btn-default'][@value='No']")
	public static WebElement haveEmployees_No_Btn;
	
	@FindBy(xpath="//span[contains(text(),'  Does the applicant hire subcontractors')]/following-sibling::input[@class='btn btn-default'][@value='Yes']")
	public static WebElement subcontractors_Yes_Btn;
	
	@FindBy(xpath="//span[contains(text(),'  Does the applicant hire subcontractors')]/following-sibling::input[@class='btn btn-default'][@value='No']")
	public static WebElement subcontractors_No_Btn;
	
	
	@FindBy(xpath="//button[@id='submitButton' and @type='submit']")
	public static WebElement GLdirect_getYourPrice_btn;
	
	//---------------------PreQualify Rates--------------------------------//
	
	@FindBy(xpath="//span[@class='price-in-quote']")
	public static WebElement preQualifyRate;
	
	@FindBy(xpath="//a[@id='submitButton']")
	public static WebElement GLdirect_buyNow_btn;
	
		
	//....................>>Tell us about you page Locators<<.............................//
	
	@FindBy(xpath="//input[@id='firstName' and @type='text']")
	public static WebElement GLdirect_firstName_textField;
	
	@FindBy(xpath="//input[@id='lastName' and @type='text']")
	public static WebElement GLdirect_lastName_textField;
	
	@FindBy(xpath="//input[@id='emailAddress' and @type='text']")
	public static WebElement GLdirect_emailAddress_textField;
	
	@FindBy(xpath="//input[@id='phoneNumber' and @type='text']")
	public static WebElement GLdirect_phoneNumber_textField;
	
	@FindBy(xpath="//input[@id='address' and @type='text']")
	public static WebElement GLdirect_physicalAddress_textField;
	
	@FindBy(xpath="//input[@id='address2' and @type='text']")
	public static WebElement GLdirect_physicalAddress2_textField;
	
	@FindBy(xpath="//input[@id='city' and @type='text']")
	public static WebElement GLdirect_physicalCity_textField;
	
	@FindBy(xpath="//select[@id='state' and @formcontrolname='state']")
	public static WebElement GLdirect_physicalState_drpDwn;
	
	@FindBy(xpath="//input[@id='zipCode' and @type='text']")
	public static WebElement GLdirect_physicalZipCode_textField;
	
	@FindBy(xpath="//input[@id='mailingAddress' and @type='text']")
	public static WebElement GLdirect_mailingAddress_textField;
	
	@FindBy(xpath="//input[@id='mailingAddress2' and @type='text']")
	public static WebElement GLdirect_mailingAddress2_textField;
	
	@FindBy(xpath="//input[@id='mailingCity' and @type='text']")
	public static WebElement GLdirect_mailingCity_textField;
	
	@FindBy(xpath="//select[@id='mailingState' and @formcontrolname='mailingState']")
	public static WebElement GLdirect_mailingState_drpDwn;
	
	@FindBy(xpath="//button[@id='submit_button' and @type='submit']")
	public static WebElement GLdirect_saveAndContinue_btn;
	
	@FindBy(xpath="//input[@id='sameAddress' and @type='checkbox']")
	public static WebElement GLdirect_sameAsPhysicalAddress_chkBox;
	
	@FindBy(xpath="//input[@id='mailingZipCode' and @type='text']")
	public static WebElement GLdirect_mailingzipCode_drpDwn;
	
	//....................>>Tell us about your business page Locators<<.............................//
	
	
	@FindBy(xpath="//select[@id='businessRelationship']")
	public static WebElement GLdirect_relationtoBusiness_drpdwn;
	
	@FindBy(xpath="//input[@placeholder='Enter the business name/DBA.' and @type='text']")
	public static WebElement GLdirect_businessName_textField;
	
	@FindBy(xpath="//select[@id='type' and @formcontrolname='type']")
	public static WebElement GLdirect_businessType_drpDwn;
	
	@FindBy(xpath="//select[@id='newResidentialWorkPriorCertificateOccupancy']")
	public static WebElement GLdirect_newResidentialStructure_drpDwn;
		
	@FindBy(xpath="//span[contains(text(),'The applicant performs residential work prior')]/following-sibling::input[@class='btn btn-default'][@value='Yes']")
	public static WebElement PerformResidentialWork_Yes_Btn;
	
	@FindBy(xpath="//span[contains(text(),'The applicant performs residential work prior')]/following-sibling::input[@class='btn btn-default'][@value='No']")
	public static WebElement PerformResidentialWork_No_Btn;
		
	@FindBy(xpath="//textarea[@id='descriptionOfOperations']")
	public static WebElement GLdirect_descOfOperations_textArea;
	
	@FindBy(xpath="//button[@id='submitButton' and @type='submit']")
	public static WebElement GLdirect_businessInfo_saveAndContinue_btn;
	
	//-----------------Insurance History Page Locators-----------------------

	
	@FindBy(xpath="//span[contains(text(),' had general liability coverage in the past')]/following-sibling::input[@class='btn btn-default'][@value='Yes']")
	public static WebElement InsuranceHistory_Yes_Btn;
	
	@FindBy(xpath="//span[contains(text(),' had general liability coverage in the past')]/following-sibling::input[@class='btn btn-default'][@value='No']")
	public static WebElement InsuranceHistory_No_Btn;
	
	@FindBy(xpath="//input[@id='noPriorCoverage' and @type='checkbox']")
	 public static WebElement no_prior_genral_chkbox;

	@FindBy(xpath="//input[@id='carrierName' and @placeholder='Enter carrier name.']")
	 public static WebElement enter_carrierName_txtb;

	@FindBy(xpath="//input[@id='insuranceEffectiveEndDate' and @placeholder='End Date']")
	 public static WebElement endDate ;

	@FindBy(xpath="//button[@id='submitButton' and @type='submit']")
	 public static WebElement insuHistory_saveandContinue_btn;

	//-----------------Classifications Page Locators-----------------------

	@FindBy(xpath="//a[@id='toggleClassificationDescription']")
	 public static WebElement viewClassDescription_link;

	@FindBy(xpath="//input[@id='percentage_1' and @type='text']")
	 public static WebElement class1_percentofWork_txtb;

	@FindBy(xpath="//a[@id='addClassification']")
	 public static WebElement addAnotherClass_link;

	@FindBy(xpath="//select[@id='newClassification' and @class='form-control']")
	 public static WebElement  addClassifiaction_drpdwn;

	@FindBy(xpath="//button[@id='addButton']")
	 public static WebElement add_btn;

	@FindBy(xpath="//button[@id='cancelButton']")
	 public static WebElement cancel_btn;

	@FindBy(xpath="//input[@id='percentage_2' and @type='text']")
	 public static WebElement class2_percentofWork_txtb;

	@FindBy(xpath="//input[@id='percentage_3' and @type='text']")
	 public static WebElement class3_percentofWork_txtb;

	@FindBy(xpath="//input[@id='percentage_4' and @type='text']")
	 public static WebElement class4_percentofWork_txtb;
	
	@FindBy(xpath="//p[contains(text(),'Must equal 100%')]")
	 public static WebElement mustEqual100_txt;
	
	@FindBy(xpath="//button[@id='submitButton' and @type='button']")
	 public static WebElement class_saveandContinue_btn;


	//-----------------Eligibility Page Locators-----------------------

	@FindBy(xpath="//span[contains(text(),'  Does the applicant agree to all')]/following::input[@class='btn btn-outline-info'][@value='Yes']")
	public static WebElement eligibility_Yes_Btn;
	
	@FindBy(xpath="//span[contains(text(),'  Does the applicant agree to all')]/following::input[@class='btn btn-outline-info'][@value='No']")
	public static WebElement eligibility_No_Btn;
	
	@FindBy(xpath="//input[@id='statementsAgreement' and @type='checkbox']")
	 public static WebElement yes_chkbox;

	@FindBy(xpath="//input[@id='statementsDisagreement' and @type='checkbox']")
	 public static WebElement no_chkbox;

	@FindBy(xpath="//button[@id='submitButton' and @type='submit']")
	 public static WebElement eleigibilty_saveandContinue_btn;
	
	//----------------------Contractor License Number----------------
	
	@FindBy(xpath="//input[@id='contractorLicense']")
	 public static WebElement contaracorsLicense_txtb;
	
	@FindBy(xpath="//div[@class='form-group text-center']//button[@id='submitButton']")
	 public static WebElement contaracorsLicense_saveandContinue_btn;
	
	//----------------------QAAno--------------------
	
	@FindBy(xpath="//div[@class='row form-row']//p[2]/child::b")
	public static WebElement qaaquoteNo;
	
	//------------------Coverage Options Page Locators --------------------------

	@FindBy(xpath="//div[@id='Basic-Coverage']")
	 public static WebElement silver_btn;
	
	@FindBy(xpath="//div[@id='Basic-Coverage']//div[@class='price-indication']//span")
	 public static WebElement silver_Quote_btn;
		

	@FindBy(xpath="//div[@id='Best-Coverage']")
	 public static WebElement gold_btn;
	
	@FindBy(xpath="//div[@id='Best-Coverage']//div[@class='price-indication']//span")
	 public static WebElement gold_Quote_btn;
	

	@FindBy(xpath="//div[@id='Premium-Coverage']")
	 public static WebElement platinum_btn;
	
	@FindBy(xpath="//div[@id='Premium-Coverage']//div[@class='price-indication']//span")
	 public static WebElement platinum_Quote_btn;
		

	@FindBy(xpath="//input[@id='additionalConverage0']")
	 public static WebElement terrorism_chkbox;

	@FindBy(xpath="//*[contains(text(),'Payment Options')]/following::p[contains(text(),'Down')]/preceding-sibling::h1")
	 public static WebElement monthlyPayment_value;

	@FindBy(xpath="//*[contains(text(),'Payment Options')]/following::p[contains(text(),'Annually')]/preceding-sibling::h1")
	 public static WebElement annualPayment_value;
	
	@FindBy(xpath="//*[contains(text(),'Payment Options')]/following::p[contains(text(),'Down')]/following-sibling::button")
	 public static WebElement monthlyPayment_btn;
	
	@FindBy(xpath="//*[contains(text(),'Payment Options')]/following::p[contains(text(),'Annually')]/following-sibling::button")
	 public static WebElement annualPayment_btn;

	//------------------ Review Page Locators --------------------------

	@FindBy(xpath="//a[text()='Review Application']")
	 public static WebElement reviewApplication_link;

	@FindBy(xpath="//a[@id='submitButton' and text()='Buy Your Policy Now']")
	 public static WebElement buyPolicy_btn;
	
	@FindBy(xpath="//a[@id='submitButton']/span")
	 public static WebElement reviewApp_applyNow_btn;

	//---------------Buy your insurance and Payment Information Page Locators-------------------
	
	@FindBy(xpath="//a[contains(text(),'Review Application')]")
	 public static WebElement buy_reviewApplication_link;
	
	@FindBy(xpath="//input[@id='cardNumber' and @type='text']")
	 public static WebElement card_no_txtb;

	@FindBy(xpath="//input[@id='cardExpiration']")
	 public static WebElement expiration_txtb;

	@FindBy(xpath="//input[@id='cardCode']")
	 public static WebElement cvv_txtb;

	@FindBy(xpath="//input[@id='nameOnCard']")
	 public static WebElement nameonCard_txtb;

	@FindBy(xpath="//input[@id='address1' and  @placeholder='Address']")
	 public static WebElement address1_txtb;

	@FindBy(xpath="//input[@id='city' and @placeholder='City']")
	 public static WebElement city_txtb;

	@FindBy(xpath="//select[@id='stateCode']")
	 public static WebElement state_drpdwn;

	@FindBy(xpath="//input[@id='postalCode']")
	 public static WebElement zip_txtb;

	@FindBy(xpath="//button[@id='submitButton' and text()='Complete Payment']")
	 public static WebElement completePayment_btn; 
			
	//-----------------------------Docu Sign Page Locators------------------------------------
	
	@FindBy(xpath="//label[@for='disclosureAccepted']")
	public static WebElement doc_IAgree_chkb;
	
	@FindBy(xpath="//button[@id='action-bar-btn-continue' and text()='Continue']")
	 public static WebElement doc_continue_btn;
	
	@FindBy(xpath="//button[@id='otherActionsButton']")
	 public static WebElement doc_otherAction_drpdwn;
	
	//------------doc page 2-
	
	@FindBy(xpath="//button[@id='comments-tooltip-btn-ok' and text()='OK']")
	 public static WebElement doc2_okAlert_btn;
	
	@FindBy(xpath="//button[@id='navigate-btn']")
	 public static WebElement doc2_start_btn;
	
	@FindBy(xpath="//button[@id='action-bar-btn-finish'][text()='Finish']")
	 public static WebElement doc2_Finish_btn;
	
	//------------doc page 3-
	
	@FindBy(xpath="//button[@id='navigate-btn']//span[text()='Sign']")
	 public static WebElement doc3_sign_tab;
	
	@FindBy(xpath="//button[@class='tab-button' and @type='button' and @aria-invalid='false' and @olive-menu-position='below left' and @olive-menu-initialized='true']")
	 public static WebElement doc3_requiredSign_btn;
	
	@FindBy(xpath="//button[@id='action-bar-btn-finish'][text()='Finish']")
	 public static WebElement doc3_finish_btn;
	
	//---------------------------Adopt Your Signature popUp-----
		
	@FindBy(xpath="//button[contains(text(),'Adopt and Sign')]")
	 public static WebElement adoptSign_btn;
	
	//-----------------------------Your Policy Information locators ---------------------------------------
	
	@FindBy(xpath="//div[@id='summaryDiv']/div[1]/div[2]/strong[2]")
	 public static WebElement yourPolicy_QAAno;
	
	@FindBy(xpath="//div[@id='summaryDiv']/div[1]/div[2]/strong[4]")
	 public static WebElement yourPolicy_policyNo;

	
}


