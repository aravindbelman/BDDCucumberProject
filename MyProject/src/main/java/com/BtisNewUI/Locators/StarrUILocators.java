package com.BtisNewUI.Locators;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.LegacyApplication.TestBase.TestBase;

public class StarrUILocators extends TestBase {

	public static WebDriver driver;

	public static final Logger log=Logger.getLogger(StarrUILocators.class.getName());

	@FindBy(xpath="//img[@alt='STARR Marine GL']")
	public static WebElement starr_marine_link;

	//--------------------------------->>Which Product is Right for My Client<<--------------------------------------------//

	@FindBy(xpath="//p[contains(text(),'Marine Artisan')]/following::a[contains(text(),'Get Quote')]")
	public static WebElement get_Marine_Quote_btn;

	@FindBy(xpath="//p[contains(text(),'Small Marine Contractor Trades')]/following::a[@name='GetInstantQuote']")
	public static WebElement get_SmallMarine_Quote_btn;


	//....................>>Let's get started page locators<<.............................//

	@FindBy(xpath="//select[@id='BusinessClass']")
	public static WebElement select_a_class_drpDwn;

	@FindBy(xpath="//input[@placeholder='Enter Zip Code']")
	public static WebElement zipcode_txtField;

	@FindBy(xpath="//form[@id='submissionForm']//input[@name='effectiveDate']")
	public static WebElement requestedEffDate_field;

	@FindBy(xpath="//input[@name='back' and @value='Back' and @type='button']")
	public static WebElement back_button;

	@FindBy(xpath="//input[@name='next' and @value='Next' and @type='button']")
	public static WebElement next_button;

	//....................>>Personal and Business Information page locators<<.............................//

	@FindBy(xpath="//form[@id='submissionForm']//p[@class='alert alert-danger text-center ng-star-inserted']")
	public static WebElement state_validation_msg;

	@FindBy(xpath="//form[@id='submissionForm']//p[@class='alert alert-danger text-center ng-star-inserted']")
	public static WebElement stateZip_validation_msg;	

	@FindBy(xpath="//input[@id='firstName' and @type='text']")
	public static WebElement firstName_txtField;

	@FindBy(xpath="//input[@id='lastName' and @type='text']")
	public static WebElement lastName_txtField;

	@FindBy(xpath="//input[@id='email' and @type='email']")
	public static WebElement email_txtField;

	@FindBy(xpath="//input[@id='businessAdds' and @placeholder='Business Address']")
	public static WebElement business_Address_txtauto;
	
	@FindBy(xpath="//div[@class='pac-item']//span[@class='pac-matched']")
	public static List<WebElement> businessAdd_List;
	
	@FindBy(xpath="//input[@id='BusinessCity' and @placeholder='City']")
	public static WebElement city_txtField;

	@FindBy(xpath="//input[@id='BusinessStateName' and @placeholder='State']")
	public static WebElement state_txtField;

	@FindBy(xpath="//input[@id='BusinessZipCode']")
	public static WebElement zip_txtField;

	@FindBy(xpath="//form[@id='submissionForm']//input[@id='BusinessAndMailingAddressSame']/following-sibling::span")
	public static WebElement same_mail_businessadd_chkb;

	@FindBy(xpath="//input[@id='MailingAdds']")
	public static WebElement mailing_Address_txtauto;

	@FindBy(xpath="//input[@id='MailingCity' and @placeholder='Mailing City']")
	public static WebElement mailing_city_txtField;

	@FindBy(xpath="//input[@id='MailingStateName' and @placeholder='State']")
	public static WebElement mailing_state_txtField;

	@FindBy(xpath="//input[@id='MailingZipCode']")
	public static WebElement mailing_zip_txtField;

	@FindBy(xpath="//input[@name='phoneNumber' and @type='text']")
	public static WebElement phnNumber_txtField;

	@FindBy(xpath="//input[@id='businessName' and @type='text']")
	public static WebElement businessName_txtFiled;

	@FindBy(xpath="//input[@id='estimatedGrossReceipts' and @type='text']")
	public static WebElement estimatedGrossReceips_txtField;

	@FindBy(xpath="//select[@id='BusinessEntityTypeId']")
	public static WebElement businessEntityType_drpDwn;

	@FindBy(xpath="//select[@id='BusinessExperience']")
	public static WebElement businessExperience_drpDwn;


	//....................>Marine Artisan Operations page locators<<.............................//

	@FindBy(xpath="//form[@id='submissionForm']//span[contains (text(),'Marine carpentry')]")
	public static WebElement ma_MarineCarpentry;

	@FindBy(xpath="//form[@id='submissionForm']//span[contains (text(),'Marine electronics installation & repair')]")
	public static WebElement ma_MarineElectronicsInstallationRepair;

	@FindBy(xpath="//form[@id='submissionForm']//span[contains (text(),'Marine engine work')]")
	public static WebElement ma_MarineEngineWork;

	@FindBy(xpath="//form[@id='submissionForm']//span[contains (text(),'Marine valve work')]")
	public static WebElement ma_MarineValveWork;

	@FindBy(xpath="//form[@id='submissionForm']//span[contains (text(),'Propeller installation, repair & servicing')]")
	public static WebElement ma_PropellerInstallation;

	@FindBy(xpath="//form[@id='submissionForm']//span[contains (text(),'Marine rigging')]")
	public static WebElement ma_MarineRigging;

	@FindBy(xpath="//form[@id='submissionForm']//span[contains (text(),'General marine maintenance & winterizing')]")
	public static WebElement ma_GeneralMarineMaintenanceWinterizing;

	@FindBy(xpath="//form[@id='submissionForm']//span[contains (text(),'Fiberglass repair & finishing')]")
	public static WebElement ma_FiberglassRepairFinishing;

	@FindBy(xpath="//form[@id='submissionForm']//span[contains (text(),'Marine painting & finishing')]")
	public static WebElement ma_MarinePaintingFinishing;

	@FindBy(xpath="//form[@id='submissionForm']//span[contains (text(),'Vessel shrink wrapping')]")
	public static WebElement ma_VesselShrinkWrapping;

	@FindBy(xpath="//form[@id='submissionForm']//span[contains (text(),'Canvas repair/install')]")
	public static WebElement ma_CanvasRepair;

	@FindBy(xpath="//form[@id='submissionForm']//span[contains(text(),'Hull work')]")
	public static WebElement ma_HullWork;

	@FindBy(xpath="//form[@id='submissionForm']/fieldset/div[2]/div/div/div/div[2]/div/div/div/div/div/div[12]/div/label/input[@id='op-12' and @type='checkbox']")
	public static WebElement chkbox_verification;

	@FindBy(xpath="//form[@id='submissionForm']//span[contains(text(),'Hull work')]/preceding-sibling::span")
	public static WebElement ma_HullWork_chkBox;


	//....................>Small Marine Contractor Operations page locators<<.............................//

	@FindBy(xpath="//form[@id='submissionForm']//span[contains (text(),'Dock & gangway construction & repair')]")
	public static WebElement smc_DockGangwayConstruction;

	@FindBy(xpath="//form[@id='submissionForm']//span[contains (text(),'Wharf construction & repair')]")
	public static WebElement smc_WharfConstructionRepai;

	@FindBy(xpath="//form[@id='submissionForm']//span[contains (text(),'Seawall/breakwater construction & repair')]")
	public static WebElement smc_SeawallBreakwaterConstructionRepair;

	@FindBy(xpath="//form[@id='submissionForm']//span[contains (text(),'Marine pile driving/cofferdams')]")
	public static WebElement smc_MarinePileDrivingCofferdams;

	@FindBy(xpath="//form[@id='submissionForm']//span[contains (text(),'Dredging')]")
	public static WebElement smc_Dredging;

	@FindBy(xpath="//form[@id='submissionForm']//span[contains (text(),'Beach restoration')]")
	public static WebElement smc_BeachRestoration;

	@FindBy(xpath="//form[@id='submissionForm']//span[contains (text(),'Marine outflow tunnel/pipe repair & installation')]")
	public static WebElement smc_MarineOutflowTunnelInstallation;

	@FindBy(xpath="//form[@id='submissionForm']//span[contains (text(),'Boar & travel lift installation & repair')]")
	public static WebElement smc_BoarTravelliftInstallationRepair;

	@FindBy(xpath="//form[@id='submissionForm']//span[contains (text(),'Vessel salvage')]")
	public static WebElement smc_VesselSalvage;

	//---------Additional Details for Marine Artisan & for Small Marine Contractor - page Locators --------------------------//

	//Do any of the following apply
	@FindBy(xpath="//p[contains(text(),'Do any of the following apply to the insured?')]//following :: input[@id='Apply']")
	public static WebElement mcNsmac_radio_agree;

	@FindBy(xpath="//p[contains(text(),'Do any of the following apply to the insured?')]//following :: input[@id='NotApply']")
	public static WebElement mcNsmac_radio_Notagree;

	//Have you had liability claims brought against you in the last 3 years

	@FindBy(xpath="//p[contains(text(),'Has the Insured had liability claims brought against them in the past 3 years?')]//following :: input[@id='HaveLiability']")
	public static WebElement  mcNsmac_radio_agree_last3Years;

	@FindBy(xpath="//p[contains(text(),'Has the Insured had liability claims brought against them in the past 3 years?')]//following :: input[@id='DoNotHaveLiability']")
	public static WebElement  mcNsmac_radio_Notagree_last3Years;

	//Do you own, operate or charter any vessels
	@FindBy(xpath="//input[@id='OperateVessel']")
	public static WebElement smc_radio_agree_Vessels;

	@FindBy(xpath="//input[@id='DonotOperateVessel']")
	public static WebElement smc_radio_Notagree_Vessels;

	//Have you purchased Protection & Indemnity Insurance for those vessels
	@FindBy(xpath="//input[@id='PurchasedProtection']")
	public static WebElement smac_radio_agree_InsuranceForThoseVessels;

	@FindBy(xpath="//input[@id='NotPurchasedProtection']")
	public static WebElement smac_radio_Notagree_InsuranceForThoseVessels;


	//-----------------------Price Indication page Locators-------------------------//

	@FindBy(xpath="//form[@id='submissionForm']//span[@class='quote-txt themeTxtColor ng-star-inserted']")
	public static WebElement quote_number;

	@FindBy(xpath="//form[@id='submissionForm']//span[@class='price-txt']")
	public static WebElement amount_txt;

	@FindBy(xpath="//button[@id='select']")
	public static WebElement price_select_btn;

	@FindBy(xpath="//select[@id='PlanDeductible']")
	public static WebElement deductible_drpdwn;

	//Terrorism Risk Insurance Act (TRIA) chkBox
	@FindBy(xpath="//form[@id='submissionForm']//span[@class='coverage-txt']")
	public static WebElement tria_chkb;

	@FindBy(xpath="//form[@id='submissionForm']//span[contains(text(),'Download Summary Review')]")
	public static WebElement download_Summary_link;

	//------------------------------Checkout Page Locators-------------------------------------------------//

	@FindBy(xpath="//form[@id='submissionForm']//button[contains(text(),'Pay Online Now')]")
	public static WebElement payOnlineNow_btn;

	//Premium Breakdown

	@FindBy(xpath="//input[@id='brokerFee']")
	public static WebElement brokerfee_txtb;

	@FindBy(xpath="//input[@value='Save']")
	public static WebElement brokerFee_save;

	@FindBy(xpath="//p[contains(text(),'Premium Breakdown')]/following::label[contains(text(),'Marine GL :')]/following-sibling::span")
	public static WebElement marine_GL_Value;

	@FindBy(xpath="//p[contains(text(),'Premium Breakdown')]/following::label[contains(text(),'Terrorism :')]/following-sibling::span")
	public static WebElement terrorism_Value;

	@FindBy(xpath="//p[contains(text(),'Premium Breakdown')]/following::label[contains(text(),'Total Premium :')]/following-sibling::span")
	public static WebElement totalPremium_Value;

	@FindBy(xpath="//p[contains(text(),'Premium Breakdown')]/following::div[4]//span")
	public static WebElement commisionRate_percent;

	@FindBy(xpath="//p[contains(text(),'Premium Breakdown')]/following::label[contains(text(),'Commission Amount')]/following-sibling::span")
	public static WebElement commisionAmount_Value;

	@FindBy(xpath="//b[contains(text(),'Fully Earned')]/following::span[1]")
	public static WebElement btisServiceFee_Value;

	@FindBy(xpath="//p[contains(text(),'Premium Breakdown')]/following::label[contains(text(),'Broker Fee :')]/following-sibling::span")
	public static WebElement brokerFee_value;

	@FindBy(xpath="//p[contains(text(),'Premium Breakdown')]//following::label[contains(text(),'Gross Total :')]/following-sibling::span")
	public static WebElement grossTotal_Value;
	
	@FindBy(xpath="//label[contains(text(),'Down Payment :')]/following-sibling::span[@class='rate-price']")
	public static WebElement netDown_Value;	

	@FindBy(xpath="//input[@id='paySelection']")
	public static WebElement payandBind_btn;

	@FindBy(xpath="//input[@id='finish']")
	public static WebElement viewANDprint_quote_btn;

	//------------------------------Finish Page Locators-------------------------------------------------//

	//to get policy no getText
	@FindBy(xpath="//div[@id='printcomponent']//span")
	public static WebElement policyNo_getTxt;

	@FindBy(xpath="//div[@class='doc-list-row']/child::a[@target='_blank']")
	public static WebElement policyDocument_DocLink;

	@FindBy(xpath="//div[@class='doc-list-row']/child::a[@style='cursor: pointer;']")
	public static WebElement summary_DocLink;

	@FindBy(xpath="//input[@id='finish']")
	public static WebElement finish_btn;

	//---------------------------------context options------------------------//

	@FindBy(xpath="//ul[@id='contextMenu']//a[contains(text(),'Policy Documents')]")
	public static WebElement policyDoc_option;

	@FindBy(xpath="//ul[@id='contextMenu']//a[contains(text(),'Review Submission')]")
	public static WebElement ReviewSubmission_option;

	@FindBy(xpath="//ul[@id='contextMenu']//a[contains(text(),'Edit/Finish Submission')]")
	public static WebElement Edit_Finish_option;

	//------------------------Calendar year-------------------------------//

	@FindBy(xpath="//form[@id='submissionForm']//span[@class='ui-datepicker-year ng-tns-c3-0 ng-star-inserted']")
	public static List <WebElement> year;

	@FindBy(xpath="//form[@id='submissionForm']//span[@class='ui-datepicker-month ng-tns-c3-0 ng-star-inserted']")
	public static List <WebElement> month;

	@FindBy(xpath="//form[@id='submissionForm']//a[@class='ui-state-default ng-tns-c3-0 ui-state-active ng-star-inserted']")
	public static List <WebElement> day;

	@FindBy(xpath="//table[@class='ui-datepicker-calendar ng-tns-c3-0 ng-star-inserted']/tbody/tr/td/a")
	public static List <WebElement> day_list;


	//============Pay & Bind =====================================//

	//=============Pay Now==========

	@FindBy(xpath="//a//span[contains(text(),'Pay Now')]")
	public static WebElement payNow_tab;

	@FindBy(xpath="//div[@id='home']//span[contains(text(),'Net down payment')]")
	public static WebElement payNow_netDown_Option;

	@FindBy(xpath="//div[@id='home']//span[contains(text(),'Other')]")
	public static WebElement payNow_Other_Option;

	@FindBy(xpath="//div[@id='home']//div//input[@value='Pay Now and Bind']")
	public static WebElement payNow_pay_bind_btn;

	//========Manual Fianance===============

	@FindBy(xpath="//a//span[contains(text(),'Manual Finance')]")
	public static WebElement manualFinance_btn;

	@FindBy(xpath="//div[@id='menu2']//span[contains(text(),'Net down payment')]")
	public static WebElement manualFinance_netDown_Option;

	@FindBy(xpath="//div[@id='menu2']//span[contains(text(),'Other')]")
	public static WebElement manualFinance_Other_Option;

	@FindBy(xpath="//div[@id='menu2']//div//input[@value='Pay Now and Bind']")
	public static WebElement manualFinance_pay_bind_btn;

	@FindBy(xpath="//div[@id='menu2']//span[contains(text(),'I acknowledge')]")
	public static WebElement acknowledge_chkb;

	@FindBy(xpath="//div[@id='menu2']//a[contains(text(),'premium finance agreement')]")
	public static WebElement pfa_link_manualFinance;

	//==========paperless Finance==========

	@FindBy(xpath="//a//span[contains(text(),'Paperless Finance')]")
	public static WebElement paperLessFinance_btn;

	@FindBy(xpath="//div[@id='menu3']//span[contains(text(),'Net down payment')]")
	public static WebElement paperLessFinance_netDown_Option;

	@FindBy(xpath="//div[@id='menu3']//span[contains(text(),'Other')]")
	public static WebElement paperLessFinance_Other_Option;

	@FindBy(xpath="//div[@id='menu3']//div//input[@value='Pay Now and Bind']")
	public static WebElement paperLessFinance_pay_bind_btn;

	@FindBy(xpath="//div[@id='menu3']//span[contains(text(),'I understand')]")
	public static WebElement understand_chkb;

	@FindBy(xpath="//div[@id='menu3']//strong[contains(text(),'I am affirming')]")
	public static WebElement affirming_chkb;
	
	//====Payment select Option====================
	
	@FindBy(xpath="//label[@class='payment-select']/child::span[contains(text(),'Credit Card')]")
	public static WebElement creditCard_radio_btn;
	
	@FindBy(xpath="//label[@class='payment-select']/child::span[contains(text(),'ACH/eCheck')]")
	public static WebElement ach_radio_btn;
	
	@FindBy(xpath="//input[@value='Pay Now']")
	public static WebElement payNow_btn;
	
	
	//<iframe id="payment-form-iframe" class="embed-responsive-item" name="payment-form-iframe" style="overflow: hidden; height: 500px; width: 100%; position: absolute;" frameborder="0">
	
	//===================Payment gateway=================================

	//Choose Payment Option
	
	@FindBy(xpath="//div[@id='order']/p/span[@class='total_value']")
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