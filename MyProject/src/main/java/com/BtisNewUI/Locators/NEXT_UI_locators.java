package com.BtisNewUI.Locators;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.LegacyApplication.TestBase.TestBase;

public class NEXT_UI_locators extends TestBase{
	
	public static WebDriver driver;

	public static final Logger log=Logger.getLogger(NEXT_UI_locators.class.getName());

	//--------------------------------->><<--------------------------------------------/
	
	//===================== Lets get started Page==============================//
	
	//Business
	@FindBy(xpath="//div//label[contains(text(),'Business ')]//following::div[@class='input-box'][1]")
	public static WebElement business_search;
	
	@FindBy(xpath="//div[contains(text(),'Select your business')]/following::fa-icon/following-sibling::input[@placeholder='Search']")
	public static WebElement business_searchInput;
	
	@FindBy(xpath="//div[@id='cob_100001']")
	public static WebElement businessName;
	
	//coverage
	@FindBy(xpath="//div//label[contains(text(),'Coverage ')]//following::div[@class='input-box'][1]")
	public static WebElement coverage_txtb;
	
	@FindBy(xpath="//div[@id='coverage_GL']")
	public static WebElement coverageName_gl;
	
	@FindBy(xpath="//div[contains(text(),'Select your coverage')]/following::fa-icon/following-sibling::input[@placeholder='Search']")
	public static WebElement coverageSearchInput;

	//state
	@FindBy(xpath="//div//label[contains(text(),'State ')]//following::div[@class='input-box'][1]")
	public static WebElement state_txtb;
	
	@FindBy(xpath="//div[@id='state_5']")
	public static WebElement stateName;
	
	@FindBy(xpath="//div[contains(text(),'Select state')]/following::fa-icon/following-sibling::input[@placeholder='Search']")
	public static WebElement stateSearchInput;
	
	//Input email
	@FindBy(xpath="//input[@id='email']")
	public static WebElement Insure_email_txtxb;
	
	@FindBy(xpath="//div//p[contains(text(),'Answer a few simple questions and ')]/following::span[contains(text(),'okay on my own')]")
	public static WebElement help_PopUp_No;
	
	@FindBy(xpath="//div//p[contains(text(),'Answer a few simple questions and ')]/following::span[contains(text(),'Yes, help me out')]")
	public static WebElement help_PopUp_Yes;
		
	//get Quote Btn
	@FindBy(xpath="//button//span[contains(text(),'Get Instant Quote')]")
	public static WebElement quote_btn;

	//=====================About your customer Page==============================//
	
	@FindBy(xpath="//input[@name='applicantfirstname']")
	public static WebElement firstName_txtb;
	
	@FindBy(xpath="//input[@name='applicantlastname']")
	public static WebElement lastName_txtb;
	
	@FindBy(xpath="//input[@name='telephonenumber']")
	public static WebElement telephone_txtb;
	
	@FindBy(xpath="//input[@name='businessname']")
	public static WebElement businessName_txtb;
	
	
	@FindBy(xpath="//input[@name='street']")
	public static WebElement primaryMailing_txtb_old;
	
	@FindBy(xpath="//div[contains(text(),'Primary Mailing Address')]/following::input[@placeholder='Street, city, state']")
	public static WebElement primaryMailing_txtb;
	
	@FindBy(xpath="//input[@name='businesscity']")
	public static WebElement city_txtb;
	
	@FindBy(xpath="//input[@name='zipcode']")
	public static WebElement zip_txtb;
	
	//====================================Is this address correct?
	
	@FindBy(xpath="//div[@id='address-confirm-dialog']//button[contains(text(),'Yes')]")
	public static WebElement Yes_btn;
	
	@FindBy(xpath="//div[@id='address-confirm-dialog']//button[contains(text(),'No')]")
	public static WebElement No_btn;
	
	//===common Next Button 
	
	@FindBy(xpath="//button[contains(text(),'Next ')]")
	public static WebElement nxt_Btn;
	
	//====================About the company=============================
	
	//==============What best describes your business's ownership structure?==
	
	@FindBy(xpath="//label[contains(text(),'Individual / Sole Proprietorship')]")
	public static WebElement individual_btn;
	
	@FindBy(xpath="//label[contains(text(),'Partnership')]")
	public static WebElement partnership_btn;
	
	@FindBy(xpath="//label[contains(text(),'Limited Liability Company')]")
	public static WebElement llcompany_btn;
	
	@FindBy(xpath="//label[contains(text(),'Corporation')]")
	public static WebElement corporation_btn;
	
	@FindBy(xpath="//label[contains(text(),'Trust')]")
	public static WebElement trust_btn;
	
	@FindBy(xpath="//label[contains(text(),'Entity Other than One Listed Above')]")
	public static WebElement entityOther_btn;
	
	//------------What year did you start your business
	
	@FindBy(xpath="//div[contains(text(),'What year did you start your business')]/following::div[@class='ni-select-arrows']")
	public static WebElement startBusiness_btn;
	
	@FindBy(xpath="//div[contains(text(),'What year did you start your business')]/following::div[contains(text(),'2000')]")
	public static WebElement startYear_btn;
	
	
	//==================================About the business===================================
	
	//Expected revenue from the next 12 months
	@FindBy(xpath="//input[@name='revenue_in_12_months']")
	public static WebElement revenuein12_txtb;
	
	//Total W-2 employees
	@FindBy(xpath="//input[@name='num_of_employees']")
	public static WebElement noofEmployee_txtb;
	
	//Expected payroll over the next 12 months 
	@FindBy(xpath="//input[@name='payroll_in_12_months']")
	public static WebElement payrollin12_txtb;
	
	//Expected subcontractor cost in the next 12 months
	@FindBy(xpath="//input[@name='subcontractor_cost_in_12_months']")
	public static WebElement subcontractor_txtb;
	
	//Do your subcontractors only do work similar to your own work and operations?
	@FindBy(xpath="//label[@for='subcontractor_similar_work_12357_yes']")
	public static WebElement sub_yes;
	
	@FindBy(xpath="//label[@for='subcontractor_similar_work_12357_no']")
	public static WebElement sub_no;
	
	//Do you accept the following requirements of this policy? 
	@FindBy(xpath="//div[contains(text(),'Do you accept the following requirements of this policy?')]/following::label[contains(text(),'I Accept')]")
	public static WebElement requirement_Iaccept_btn;	
	
	
	//==================================About the business/ Srevices1===================================
	//How much of your work is: 
	@FindBy(xpath="//input[@question-name='residential_work_percent']")
	public static WebElement residential_txtb;
	
	@FindBy(xpath="//input[@question-name='commercial_work_percent']")
	public static WebElement commercial_txtb;
	
	@FindBy(xpath="//input[@question-name='industrial_work_percent']")
	public static WebElement industrial_txtb;
	
	//==================================About the Services2===================================
	
	@FindBy(xpath="//div[contains(text(),'Select all the activities that')]/following::span[contains(text(),'Carpentry')]")
	public static WebElement Carpentry_chkb;
	
	@FindBy(xpath="//div[contains(text(),'Select all the activities that')]/following::span[contains(text(),'Drywall')]")
	public static WebElement Drywall_chkb;
	
	@FindBy(xpath="//div[contains(text(),'Select all the activities that')]/following::span[contains(text(),'Concrete Construction')]")
	public static WebElement concrete_cons_chkb;
	
	@FindBy(xpath="//div[contains(text(),'Select all the activities that')]/following::span[contains(text(),'Electrical Work')]")
	public static WebElement electricalWork_chkb;
	
	@FindBy(xpath="//div[contains(text(),'Select all the activities that')]/following::span[contains(text(),'Plumbing')]")
	public static WebElement Plumbing_chkb;
	
	//==============About the business gc==========================
	
	@FindBy(xpath="//div[contains(text(),'I understand that I must have all required licenses')]/following::label[contains(text(),'I Understand')]")
	public static WebElement I_understand_btn;
	
	@FindBy(xpath="//input[@name='years_of_experience']")
	public static WebElement years_of_experience_txtb;
	
	@FindBy(xpath="//label[@for='work_unsupported_states_149_yes']")
	public static WebElement sub_gc_yes;
	
	@FindBy(xpath="//label[@for='work_unsupported_states_149_no']")
	public static WebElement sub_gc_no;
	
	//==========About the work=======================
	
	//Do you or your employees perform any of the following activities? Do not include activities you subcontract to others. 
	
	@FindBy(xpath="//div[contains(text(),'Do you or your employees perform any of the following activities')]/following::label[contains(text(),'Yes')]")
	public static WebElement about_the_work_YES;
	
	@FindBy(xpath="//div[contains(text(),'Do you or your employees perform any of the following activities')]/following::label[contains(text(),'No')]")
	public static WebElement about_the_work_NO;
	
	//=================If YES====Which of the following activities do you or your employees perform? Select all that apply.
	

	@FindBy(xpath="//div[contains(text(),'Which of the following activities do you or your employees')]/following::span[contains(text(),'Blasting')][2]")
	public static WebElement Blasting_chkb;
	
	@FindBy(xpath="//div[contains(text(),'Which of the following activities do you or your employees')]/following::span[contains(text(),'Foundation work')][2]")
	public static WebElement Foundation_work_chkb;
	
	@FindBy(xpath="//div[contains(text(),'Which of the following activities do you or your employees')]/following::span[contains(text(),'Environmental clean up')][2]")
	public static WebElement Environmental_clean_up_chkb;
	
	@FindBy(xpath="//div[contains(text(),'Which of the following activities do you or your employees')]/following::button[@class='atn-multiselect-submit'][2]")
	public static WebElement submit_btn;

	//=============================About the general contracting=================================
	
	//Do the activities of your subcontractors include:
	@FindBy(xpath="//div[contains(text(),'Do the activities of your subcontractors include')]/following::label[contains(text(),'Yes')]")
	public static WebElement  activities_of_your_subcontractors_YES;
	
	@FindBy(xpath="//div[contains(text(),'Do the activities of your subcontractors include')]/following::label[contains(text(),'No')]")
	public static WebElement activities_of_your_subcontractors_No;
	
	//== if YES  ===Which of the following activities do your subcontractors perform? Select all that apply.
	
	@FindBy(xpath="//div[contains(text(),'Which of the following activities do your subcontractors')]/following::span[contains(text(),'Blasting operations')]")
	public static WebElement Blasting_operations_chkb;
	
	@FindBy(xpath="//div[contains(text(),'Which of the following activities do your subcontractors')]/following::span[contains(text(),'Man hole work')]")
	public static WebElement Man_hole_work_chkb;
	
	@FindBy(xpath="//div[contains(text(),'Which of the following activities do your subcontractors')]/following::span[contains(text(),'Work on traffic lights')]")
	public static WebElement Workontraffic_lights_chkb;
	
	//How frequently do you or one of your employees (not subcontractors) visit each job site? 
	
	@FindBy(xpath="//div[contains(text(),'How frequently do you or one of your employees ')]/following::div[@class='ni-select-arrows']")
	public static WebElement visit_eachjobsite_click;
	
	@FindBy(xpath="//div[contains(text(),'How frequently do you or one of your employees ')]/following::div[contains(text(),'4+ times a month')]")
	public static WebElement four_timesa_month ;
	
	@FindBy(xpath="//div[contains(text(),'How frequently do you or one of your employees ')]/following::div[contains(text(),'1-3 times a month ')]")
	public static WebElement OneTwo_in_month ;
	
	@FindBy(xpath="//div[contains(text(),'How frequently do you or one of your employees ')]/following::div[contains(text(),'Less than once a month')]")
	public static WebElement Less_thanonce_month ;
	
	//================================== Insurance details ===================================================
	
	//Have you filed business insurance claims in the past three years?
	
	@FindBy(xpath="//label[@for='claims_last_3_years_159_yes']")
	public static WebElement claims_last_3_years_12299_yes;
	
	@FindBy(xpath="//label[@for='claims_last_3_years_159_no']")
	public static WebElement claims_last_3_years_12299_no;
	
	//if YES===
	
	@FindBy(xpath="//input[@name='claims_count']")
	public static WebElement claims_count_txtb;
	
	@FindBy(xpath="//input[@name='claims_total_amount']")
	public static WebElement claims_total_amount_txtb;
	
	@FindBy(xpath="//label[@for='fraud_bribery_legal_162_yes']")
	public static WebElement fraud_bribery_legal_12302_yes;
	
	@FindBy(xpath="//label[@for='fraud_bribery_legal_162_no']")
	public static WebElement fraud_bribery_legal_12302_no;
	
	@FindBy(xpath="//div[contains(text(),'The following activities will be excluded from your policy')]/following::label[contains(text(),'I Understand')]")
	public static WebElement excludefromYouPolicy_I_Understand;
	
	//============================About the insurance==========================================
	
	/*Would you like to add coverage for standalone roofing jobs? In order to add this coverage, 
	*we will assume about half of your work may be roofing related. 
	*This can increase your rates by around 50%. 
	*(You can always return to this question by clicking the back button in your browser). */
	
	
	@FindBy(xpath="//label[@for='gc_add_roofing_158_yes']")
	public static WebElement gc_add_roofing_12027_yes;
	
	@FindBy(xpath="//label[@for='gc_add_roofing_158_no']")
	public static WebElement gc_add_roofing_12027_no;
	
	
	//=============================About the quote============================================
	
	/*Do you currently use or plan to use a business or personal vehicle 
	 * for any work related activities such as:
	 *  carrying tools or materials for jobs or allowing contractors, 
	 *  employees or clients to drive or ride in the vehicle?  
	 */
	
	@FindBy(xpath="//label[@for='auto_vehicle_for_work_activity_1156_yes']")
	public static WebElement auto_vehicle_for_work_activity_1137_yes;
	
	@FindBy(xpath="//label[@for='auto_vehicle_for_work_activity_1156_no']")
	public static WebElement auto_vehicle_for_work_activity_1137_no;
	
	@FindBy(xpath="//div[contains(text(),'Do you have insurance for the vehicle above')]/following::label[contains(text(),'Yes, a commercial auto policy')]")
	public static WebElement Yes_commercial_auto_policy;
	
	@FindBy(xpath="//div[contains(text(),'Do you have insurance for the vehicle above')]/following::label[contains(text(),'No')]")
	public static WebElement No_policy;
	
	@FindBy(xpath="//span[contains(text(),'Continue without Auto')]")
	public static WebElement continue_without_auto_btn;	
	
	//===================Select your coverage==========================
	
	//basics
	@FindBy(xpath="//bundle-tabs//div[contains(text(),'Basic ')]")
	public static WebElement basic_tab;
	
	@FindBy(xpath="//bundle-tabs//div[contains(text(),'Basic ')]/following::h1[@class='automation-basic-amount amount'][2]")
	public static WebElement basic_value;
	
	@FindBy(xpath="//bundle-tabs//div[contains(text(),'Basic ')]/following::h1[@class='automation-basic-amount amount'][2]/following::button[@class='automation-basic-btn'][1]")
	public static WebElement basic_select_btn;
	
	//Pro
	@FindBy(xpath="//bundle-tabs//div[contains(text(),'Pro ')][1]")
	public static WebElement pro_tab;
	
	@FindBy(xpath="//bundle-tabs//div[contains(text(),'Pro ')][1]/following::h1[@class='automation-pro-amount amount'][2]")
	public static WebElement pro_value;
	
	@FindBy(xpath="//bundle-tabs//div[contains(text(),'Pro ')][1]/following::h1[@class='automation-pro-amount amount'][2]/following::button[@class='automation-pro-btn']/span")
	public static WebElement pro_select_btn;
	
	@FindBy(xpath=".//*[@id='step4']/div/div/div/bundles/div[1]/div[1]/bundle-single[2]/div[3]/button")
	public static WebElement pro_select_btn2;
	
	//proPlus
	@FindBy(xpath="//bundle-tabs//div[contains(text(),'Pro Plus')]")
	public static WebElement proPlus_tab;
	
	@FindBy(xpath="//bundle-tabs//div[contains(text(),'Pro Plus')]/following::h1[@class='automation-proPlus-amount amount'][2]")
	public static WebElement proPlus_value;
	
	@FindBy(xpath="//bundle-tabs//div[contains(text(),'Pro Plus')]/following::h1[@class='automation-proPlus-amount amount'][2]/following::button[@class='automation-proPlus-btn']/span")
	public static WebElement proPlus_select_btn;
	
	//==================Summary page=======================
	
	@FindBy(xpath="//button[@class='automation-agreements-summary-btn invert']")
	public static WebElement continueToPayment_btn;
	//========================Payment page=============================
	
	@FindBy(xpath="//span[contains(text(),'now for first + last month')]/preceding-sibling::span")
	public static WebElement FirstAndLast_Value;
	
	@FindBy(xpath="//div[@class='change-payment-frequency']/a[contains(text(),'Switch to annual')]")
	public static WebElement annual_switch;
	
	@FindBy(xpath="//div[@class='change-payment-frequency']/a[contains(text(),'Switch to monthly')]")
	public static WebElement monthly_switch;
	
	@FindBy(xpath="//div//label[contains(text(),'Name on card')]/child::input[@id='nameOnCard']")
	public static WebElement name_txtb;
	
	@FindBy(xpath="//input[@name='cardnumber']")
	public static WebElement cardNumber_txtb;//
	
	@FindBy(xpath="//div[@id='cardExpiration']")
	public static WebElement expdate;
	
	@FindBy(xpath="//input[@name='exp-date']")
	public static WebElement expiryDate_txtb;
	
	@FindBy(xpath="//input[@name='cvc']")
	public static WebElement securityCode_txtb;
	
	@FindBy(xpath="//button[@id='submit']")
	public static WebElement submitPay_btn;
	
	@FindBy(xpath="//button[contains(text(),'Pay')]")
	public static WebElement Pay_btn;
	
	@FindBy(xpath="//div[@class='endcap invert ni-payment-success-view-agent-container']/child::h2[contains(text(),'Payment Successful')]")
	public static WebElement paymentSuccessPage;
	
	@FindBy(xpath="//div[@id='next-insurance-close']")
	public static WebElement close_btn;
	
	//==========================Context menus==========================
	
	@FindBy(xpath="//ul[@id='contextMenu']/li//a[text()='Retrieve and Pay']")
	public static WebElement context_RetriveNPay;
	
	@FindBy(xpath="//ul[@id='contextMenu']/li//a[text()='Proposal Document']")
	public static WebElement context_propsalDocument;
	
	@FindBy(xpath="//button[contains(text(),'Back to Agent Portal')]")
	public static WebElement backToAgentPortal_btn;
		
}
