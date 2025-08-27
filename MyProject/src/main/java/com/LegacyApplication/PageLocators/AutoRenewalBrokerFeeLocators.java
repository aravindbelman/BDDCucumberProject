package com.LegacyApplication.PageLocators;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.LegacyApplication.TestBase.TestBase;

public class AutoRenewalBrokerFeeLocators extends TestBase {

	public static WebDriver driver;
	public static final Logger log=Logger.getLogger(AutoRenewalBrokerFeeLocators.class.getName());
	
	//===========================> Broker Fee Setup Locators<========================

	@FindBy(xpath="//button[contains(text(),'Submit')]/following-sibling::button[@type='button' and contains(text(),'Cancel')]")
	public static WebElement existing_brokerFee_cancelButton;
	
	@FindBy(xpath="//button[@class='btn btn-primary btn-lg fee-flat' and @type='button']")
	public static WebElement selectButton_flatFee;

	@FindBy(xpath="//button[@class='btn btn-primary btn-lg fee-percentage' and @type='button']")
	public static WebElement selectButton_percentageFee;

	@FindBy(xpath="//button[@class='btn btn-primary btn-lg fee-tiers' and @type='button']")
	public static WebElement selectButton_tieredFee;

	@FindBy(xpath="//div[contains(text(),'No Default Broker Fee')]/following::div[@class='control_indicator']")
	public static WebElement checkbox_noDefaultFee;

	@FindBy(xpath="//button[@class='btn btn-primary submit' and @type='button']")
	public static WebElement submit_noDefaultFee;

	@FindBy(xpath="//button[@class='btn btn-danger' and @type='button']")
	public static WebElement cancel_noDefaultFee;

	@FindBy(xpath="//input[@class='form-control is-valid' and @placeholder='Amount' and @type='text'][position()=1]")
	public static WebElement flatBrokerFee_newBusiness;

	@FindBy(xpath="//label[@data-bind='text: newBusinessTiers()[0].validateFlat']/following::input[@data-bind='checked: differentTiers' and @type='checkbox'][1]")
	public static WebElement flatFee_checkbox;

	@FindBy(xpath="//p[contains(text(),'Enter a broker fee for renewal submissions:')]/following::input[@class='form-control is-valid' and @placeholder='Amount' and @type='text']")
	public static WebElement flatBrokerFee_renewalBusiness;

	@FindBy(xpath="//button[@class='btn btn-primary submit' and @type='button']")
	public static WebElement flatbrokerFee_submitButton;
	
	@FindBy(xpath="//button[@class='btn btn-default' and @type='button']")
	public static WebElement AllbrokerFee_CancelButton;

	@FindBy(xpath="//div[@class='modal-footer no-border center']//button[@class='btn btn-primary btn-save' and @type='button']")
	public static WebElement alert_continueButton;

	@FindBy(xpath="//button[@id='submissionButton' and @type='button']")
	public static WebElement gotoSubmissions_button_old;
	
	@FindBy(xpath="//form[@id='Form']//a[@href='/submissions' and text()='Go To Submissions']")
	public static WebElement gotoSubmissions_button;

	@FindBy(xpath="//button[@class='btn btn-danger' and @type='button']")
	public static WebElement flatbrokerFee_cancelButton;

	@FindBy(xpath="//input[@class='form-control is-valid' and @placeholder='Percentage' and @type='text'][position()=1]")
	public static WebElement percentageBrokerFee_newBusiness;
	
	@FindBy(xpath="//p[contains(text(),'Enter a percentage for new submissions:')]/following::input[@data-bind='checked: differentTiers' and @type='checkbox'][1]")
	public static WebElement percentageFee_checkbox;

	@FindBy(xpath="//p[contains(text(),'Enter a percentage for renewal submissions:')]/following::input[@class='form-control is-valid' and @placeholder='Percentage' and @type='text']")
	public static WebElement percentageBrokerFee_renewalBusiness;

	@FindBy(xpath="//button[@class='btn btn-primary submit' and @type='button']")
	public static WebElement percentageBrokerFee_submitButton;

	@FindBy(xpath="//button[@class='btn btn-danger' and @type='button']")
	public static WebElement percentageBrokerFee_cancelButton;

	@FindBy(xpath="//input[@class='form-control' and @data-bind='textInput: newBusinessTiers()[1].priorTierEnd' and @type='text']")
	public static WebElement tieredBrokerFee_tier1NewBusiness;

	@FindBy(xpath="//input[@class='form-control' and @data-bind='textInput: newBusinessTiers()[1].priorTierEnd' and @type='text']//following::input[1]")
	public static WebElement tier1NewBusiness_brokerFee;
	
	@FindBy(xpath="//span[@class='add-remove-tiers']//span[@class='glyphicon glyphicon-plus'][position()=1]")
	public static WebElement additional_tier_sign_newBusiness;
	
	@FindBy(xpath="//h2[contains(text(),'Renewal Business Default Broker Fee')]/following::span[@class='add-remove-tiers']//span[@class='glyphicon glyphicon-plus']")
	public static WebElement additional_tier_sign_renewalBusiness;

	@FindBy(xpath="//input[@class='form-control' and @aria-label='Tier 2 Ends At' and @type='text'][position()=1]")
	public static WebElement tieredBrokerFee_tier2NewBusiness;

	@FindBy(xpath="//input[@class='form-control' and @aria-label='Tier 2 Ends At' and @type='text']//following::input[1]")
	public static WebElement tier2NewBusiness_brokerFee;

	@FindBy(xpath="//input[@class='form-control' and @aria-label='Tier 3 Ends At' and @type='text'][position()=1]")
	public static WebElement tieredBrokerFee_tier3NewBusiness;

	@FindBy(xpath="//input[@class='form-control' and @aria-label='Tier 3 Ends At' and @type='text'][position()=1]//following::input[1]")
	public static WebElement tier3NewBusiness_brokerFee;

	@FindBy(xpath="//input[@class='form-control' and @aria-label='Tier 3 Ends At' and @type='text'][position()=1]//following::input[2]")
	public static WebElement tier4NewBusiness_brokerFee;

	@FindBy(xpath="//span[contains(text(),'add an additional tier')]/following::input[@data-bind='checked: differentTiers' and @type='checkbox']")
	public static WebElement tieredBrokerFee_checkBox;

	@FindBy(xpath="//input[@class='form-control' and @data-bind='textInput: renewalTiers()[1].priorTierEnd' and @type='text']")
	public static WebElement tieredBrokerFee_tier1RenewalBusiness;

	@FindBy(xpath="//input[@class='form-control' and @data-bind='textInput: renewalTiers()[1].priorTierEnd' and @type='text']//following::input[1]")
	public static WebElement tier1RenewalBusiness_brokerFee;

	@FindBy(xpath="//h2[contains(text(),'Renewal Business Default Broker Fee')]/following::input[@class='form-control' and @aria-label='Tier 2 Ends At' and @type='text']")
	public static WebElement tieredBrokerFee_tier2RenewalBusiness;

	@FindBy(xpath="//input[@class='form-control' and @data-bind='textInput: renewalTiers()[1].priorTierEnd' and @type='text']//following::input[4]")
	public static WebElement tier2RenewalBusiness_brokerFee;

	@FindBy(xpath="//input[@class='form-control' and @data-bind='textInput: renewalTiers()[1].priorTierEnd' and @type='text']//following::input[6]")
	public static WebElement tieredBrokerFee_tier3RenewalBusiness;

	@FindBy(xpath="//input[@class='form-control' and @data-bind='textInput: renewalTiers()[1].priorTierEnd' and @type='text']//following::input[7]")
	public static WebElement tier3RenewalBusiness_brokerFee;

	@FindBy(xpath="//input[@class='form-control' and @data-bind='textInput: renewalTiers()[1].priorTierEnd' and @type='text']//following::input[8]")
	public static WebElement tier4RenewalBusiness_brokerFee;

	@FindBy(xpath="//button[@class='btn btn-primary submit' and @type='button']")
	public static WebElement tieredBrokerFee_submitButton;

	@FindBy(xpath="//button[@class='btn btn-danger' and @type='button']")
	public static WebElement tieredBrokerFee_cancelButton;
	
	@FindBy(xpath="//button[@class='btn btn-primary btn-go-home' and @type='button']")
	public static WebElement close_button;
	
	//===========================> Locators of Rating Work sheet<=============================
	
	@FindBy(xpath="//span[@id='Price_Indicator_Screen1_lblFO_GLPremWithoutSunset']")
	public static WebElement gl_premium;
	
	@FindBy(xpath="//span[@id='Price_Indicator_Screen1_lblFO_PolFeeGLWithoutSunset']")
	public static WebElement gl_policy_fee;
	
	@FindBy(xpath="//span[@id='Price_Indicator_Screen1_lblFO_TotalWithoutSunset']")
	public static WebElement total_gl_premiumandfees;
	
	//===========================> Locators of Binding Document<=============================
	
	 @FindBy(xpath="//div[@id='divOccurrence']")
	 public static WebElement occurent_and_premium;
	
	 @FindBy(xpath="//input[@id='PageTextBox-txtBrokerFee' or @id='PageTextBox-txtAgencyBrokerFee' and @type='text']")
	 public static WebElement agency_broker_fee_field;
	 
	 @FindBy(xpath="//input[@id='PageTextBox-txtInsuredEmail']")
	 public static WebElement insureds_email_address;
	 
	 @FindBy(xpath="//input[@id='rbOnePayNow' and @type='radio']")
	 public static WebElement onePay_payNow_radiobtn;
	 
	 @FindBy(xpath="//input[@id='rbOnePay' and @type='radio']")
	 public static WebElement onePay_zeroDown_radiobtn;
	 
	 @FindBy(xpath="//input[@id='rbTwoPayNow' and @type='radio']")
	 public static WebElement twoPay_payNow_radiobtn;
	 
	 @FindBy(xpath="//input[@id='rbTwoPay' and @type='radio']")
	 public static WebElement twoPay_zeroDown_radiobtn;
	 
	 @FindBy(xpath="//input[@id='rbFivePayNow' and @type='radio']")
	 public static WebElement fivePay_payNow_radiobtn;
	 
	 @FindBy(xpath="//input[@id='rbFivePay' and @type='radio']")
	 public static WebElement fivePay_zeroDown_radiobtn;
	 
	 @FindBy(xpath="//input[@id='rbTenPayNow' and @type='radio']")
	 public static WebElement tenPay_payNow_radiobtn;
	 
	 @FindBy(xpath="//input[@id='rbTenPay' and @type='radio']")
	 public static WebElement tenPay_zeroDown_radiobtn;
	 
	 @FindBy(xpath="//input[@id='PageTextBox-txtQuote' and @type='text']")
	 public static WebElement bindingDoc_quoteNum_txtField;
	 
	 @FindBy(xpath="//input[@id='PageTextBox-txtApplicant' and @type='text']")
	 public static WebElement bindingDoc_appName_txtField;
	 
	 @FindBy(xpath="//input[@id='PageTextBox-txtDba' and @type='text']")
	 public static WebElement bindingDoc_dba_txtField;
	 
	 @FindBy(xpath="//input[@id='rbCreditCard' and @type='radio']")
	 public static WebElement paymentMthd_creditCard_radioBtn;
	 
	 @FindBy(xpath="//input[@id='rbBank' and @type='radio']")
	 public static WebElement paymentMthd_achBank_radioBtn;
	 
	 @FindBy(xpath="//select[@id='PageDropDownList-ddlCreditCardType']")
	 public static WebElement bd_cardType_dropDown;
	 
	 @FindBy(xpath="//input[@id='PageTextBox-tbCardNumber' and @type='text']")
	 public static WebElement bd_cardNum_textField;
	 
	 @FindBy(xpath="//input[@id='PageTextBox-tbMonth' and @type='text']")
	 public static WebElement bd_card_expirationMnth;
	 
	 @FindBy(xpath="//input[@id='PageTextBox-tbYear' and @type='text']")
	 public static WebElement bd_card_expirationYear;
	 
	 @FindBy(xpath="//input[@id='PageTextBox-tbCardCode' and @type='text']")
	 public static WebElement bd_card_securityCode;
	 
	 @FindBy(xpath="//input[@id='PageTextBox-tbCardName' and @type='text']")
	 public static WebElement bd_nameOnCard;
	 
	 @FindBy(xpath="//input[@id='PageTextBox-tbCardAddress' and @type='text']")
	 public static WebElement bd_address_txtField;
	 
	 @FindBy(xpath="//input[@id='PageTextBox-tbCardCity' and @type='text']")
	 public static WebElement bd_city_txtField;
	 
	 @FindBy(xpath="//select[@id='PageDropDownList-tbCardState']")
	 public static WebElement bd_selectState_drpDown;
	 
	 @FindBy(xpath="//input[@id='PageTextBox-tbCardZip' and @type='text']")
	 public static WebElement bd_zipCode_txtField;
	 
	 @FindBy(xpath="//input[@id='PageCheckBox-cbTermsAndConditionsCC']")
	 public static WebElement bd_TermsAndConditions_chkBox;
	 
	 @FindBy(xpath="//input[@id='rbPaperlessPremiumFinancing' and @type='radio']")
	 public static WebElement bd_Paperless_premiumFinance_radio;
	 
	 @FindBy(xpath="//input[@id='rbManualPremiumFinancing']")
	 public static WebElement bd_Manual_premiumFinance_radio;	 
	 
	 @FindBy(xpath="//input[@id='PageCheckBox-chkAgreePfa' and @type='checkbox']")
	 public static WebElement bd_premiumFinance_chkBox;
	 
	 @FindBy(xpath="//div[@id='divPfaAgree']//input[@name='Checked'][1]")
	 public static WebElement verify_bdPremium_finance;
	 
	 @FindBy(xpath="//button[@id='btnSave' and @type='button']")
	 public static WebElement bindingDoc_save_button;
	 
	 @FindBy(xpath="//button[@id='btnSaveClose' and @type='button']")
	 public static WebElement bindingDoc_close_button;
	 
	 @FindBy(xpath="//input[@id='rbDirectBillOption' and @type='radio']")
	 public static WebElement bd_directbill_radiobtn;
	 
	 @FindBy(xpath="//input[@id='rbAgencyFinanceOption' and @type='radio']")
	 public static WebElement bd_agcyFinanceOption_radiobtn;
	 
	 @FindBy(xpath="//input[@id='rbPremiumFinanceOption' and @type='radio']")
	 public static WebElement bd_premiumFinanceOption_radiobtn;
	 
	 @FindBy(xpath="//div[@id='divEmailBody']//b[contains(text(), 'Broker Fee:')]//following::td[2]")
	 public static WebElement renewalLetter_brokerfee;
	 
	 @FindBy(xpath="//div[@id='divEmailBody']//td/b[contains(text(),'Previous Payment Method:')]//following::td[1]")
	 public static WebElement renewalletter_paymentinfo;
	 
	 @FindBy(xpath="//div[@id='divGroupedRadioButtons-PaymentOptions']//div[@id='divDirectBillOption']")
	 public static WebElement paymentOption_BindingDoc_DirectBill;
	 
	 @FindBy(xpath="//div[@id='divGroupedRadioButtons-PaymentOptions']//div[@id='divAgencyFinanceOption']")
	 public static WebElement paymentOption_BindingDoc_AgencyFinance;
	 
	 @FindBy(xpath="//div[@id='divGroupedRadioButtons-PaymentOptions']//div[@id='divPremiumFinanceOption']")
	 public static WebElement paymentOption_BindingDoc_PremiumFin;
	 
	 @FindBy(xpath="//label[@id='lblPageCheckBox-chkAgreePfa']/a[@class='FinanceFormUrl']")
	 public static WebElement premiumFinance_agreementLink;
	 
	//===========================> Non_Beta QCR Locators<=============================
	 
	 @FindBy(xpath="//ul[@id='contextMenu']/li//a[text()='Edit/Finish Submission']")
	 public static WebElement edit_finish_submission;
	 
	 @FindBy(xpath="//div[@id='divRenewalLetter']//div//input[@value='Send' and @type='button' and @onclick='SendRenewalLetter()']")
	 public static WebElement send_renewalLetter_button;
	 
	 @FindBy(xpath="//input[@id='sendEmail' and @name='sendEmail' and @type='submit']")
	 public static WebElement send_email_button;
	 
	//===========================> Additional Insured Locators<=============================
	 
	 @FindBy(xpath="//div[@id='dnn_ctr2524_HtmlModule_lblContent']/h1[contains(text(), 'Additional Insured Request')]")
	 public static WebElement additional_insured_verify;
	//=====================Make Payment Page ========================================== 
	 @FindBy(xpath="//section[@id='pageHeaderSection']//h3[contains(text(),'   Make A Payment')]")
	 public static WebElement makePaymentPage_verify;
	 
	//===========================> Make a Payment page Locators<=============================
	 
	 @FindBy(xpath="//input[@id='PaymentInfo_Reference1' and @type='text']")
	 public static WebElement paymentinfo_policy_or_quote_num;
	 
	 @FindBy(xpath="//input[@id='PaymentInfo_Reference2' and @type='text']")
	 public static WebElement paymentinfo_insureds_name;
	 
	 @FindBy(xpath="//input[@id='PaymentInfo_Reference3' and @type='text']")
	 public static WebElement paymentinfo_dba_name;
	 
	 @FindBy(xpath="//input[@id='PaymentInfo_Amount' and @type='text']")
	 public static WebElement paymentinfo_amount;
	 
	 @FindBy(xpath="//input[@id='PaymentInfo_PaymentMethod' and @value='eCheck' and @type='radio']")
	 public static WebElement payment_method_eCheck;
	 
	 @FindBy(xpath="//input[@id='PaymentInfo_PaymentMethod' and @value='CreditCard' and @type='radio']")
	 public static WebElement payment_method_creditCard;
	 
	 @FindBy(xpath="//textarea[@id='PaymentInfo_Comments' and @name='PaymentInfo.Comments']")
	 public static WebElement paymentinfo_comments;
	 
	 @FindBy(xpath="//span[@id='processingFee']")
	 public static WebElement paymentinfo_processingFee;
	 
	 @FindBy(xpath="//span[@id='total']")
	 public static WebElement paymentinfo_totalAmount;
	 
	//===========================> eCheck info<=============================
	 
	 @FindBy(xpath="//input[@id='eCheckInfo_BankName' and @name='eCheckInfo.BankName']")
	 public static WebElement eCheck_bankName;
	 
	 @FindBy(xpath="//select[@id='eCheckInfo_BankAccountType' and @name='eCheckInfo.BankAccountType']")
	 public static WebElement eCheck_accountType;
	 
	 @FindBy(xpath="//input[@id='eCheckInfo_CheckNumber' and @name='eCheckInfo.CheckNumber']")
	 public static WebElement eCheck_checkNumber;
	 
	 @FindBy(xpath="//input[@id='eCheckInfo_BankAccountName' and @name='eCheckInfo.BankAccountName']")
	 public static WebElement eCheck_nameOnAccount;
	 
	 @FindBy(xpath="//input[@id='eCheckInfo_BankRoutingNumber' and @name='eCheckInfo.BankRoutingNumber']")
	 public static WebElement eCheck_routingNumber;
	 
	 @FindBy(xpath="//input[@id='eCheckInfo_BankAccountNumber' and @name='eCheckInfo.BankAccountNumber']")
	 public static WebElement eCheck_accountNumber;
	 
	 @FindBy(xpath="//input[@id='eCheckInfo_BankAccountNumberConfirm' and @name='eCheckInfo.BankAccountNumberConfirm']")
	 public static WebElement eCheck_confirmAccountNumber;
	 
	 @FindBy(xpath="//span[@id='socAmount']")
	 public static WebElement eCheck_paymentAmountApplied;
	 
	 @FindBy(xpath="//span[@id='socProcessingFee']")
	 public static WebElement eCheck_processingFee;
	 
	 @FindBy(xpath="//span[@id='socTotal']")
	 public static WebElement eCheckOrcreditcard_amountCharged;
	 
	 @FindBy(xpath="//input[@id='Agreement' and @name='Agreement']")
	 public static WebElement eCheck_agreement_chkbox;
	 
	 @FindBy(xpath="//input[@id='btnSubmitPayment' and @value='Submit']")
	 public static WebElement paymentInfo_submitPayment_btn;
	 
	//===========================> Credit Card info<=============================
	 
	 @FindBy(xpath="//select[@id='CreditCardInfo_CardType' and @name='CreditCardInfo.CardType']")
	 public static WebElement creditCard_cardType;
	 
	 @FindBy(xpath="//input[@id='CreditCardInfo_CardNumber' and @type='text']")
	 public static WebElement creditCard_cardNumber;
	 
	 @FindBy(xpath="//select[@id='CreditCardInfo_ExpirationMonth' and @name='CreditCardInfo.ExpirationMonth']")
	 public static WebElement creditCard_expirationMonth;
	 
	 @FindBy(xpath="//select[@id='CreditCardInfo_ExpirationYear' and @name='CreditCardInfo.ExpirationYear']")
	 public static WebElement creditCard_expirationYear;
	 
	 @FindBy(xpath="//input[@id='CreditCardInfo_CardSecurityCode' and @type='text']")
	 public static WebElement creditCard_securityCode;
	 
	 @FindBy(xpath="//input[@id='CreditCardInfo_NameOnCard' and @name='CreditCardInfo.NameOnCard']")
	 public static WebElement creditCard_nameOnCard;
	 
	 @FindBy(xpath="//input[@id='CreditCardInfo_StreetAddress' and @type='text']")
	 public static WebElement creditCard_address;
	 
	 @FindBy(xpath="//input[@id='CreditCardInfo_City' and @type='text']")
	 public static WebElement creditCard_city;
	 
	 @FindBy(xpath="//select[@id='CreditCardInfo_State' and @name='CreditCardInfo.State']")
	 public static WebElement creditCard_state;
	 
	 @FindBy(xpath="//input[@id='CreditCardInfo_Zip' and @type='text']")
	 public static WebElement creditCard_zipcode;
	 
	 
	 
	//===========================Locators of new Auto Renewal Program changes<========================
	 
    @FindBy(xpath="//table[@id='searchTable']/tbody/tr/td[7]")
    public static WebElement RenewalSubmission_Status;
    
    @FindBy(xpath="//table[@id='searchTable']/tbody/tr/td[2]")
    public static WebElement policy_number;
    
    @FindBy(xpath="//input[@id='PolicyExpirationDate']")
    public static WebElement policy_expiration_date;
    
    @FindBy(xpath="//button[@id='btnBindNow']")
    public static WebElement bindingDoc_bindNow_btn;
    
  //Renewal Pending status//DirectBill//BT007//TestAdmin-QAA01482483

    @FindBy(xpath="//div[@id='divEmailBody']/div[contains(text(),'scheduled for auto renewal')]")
    public static WebElement renewLetter_headline_DirectBill_RenPending;

    @FindBy(xpath="//div[@id='divEmailBody']//b[text()='Name:']/following::td[1]")
    public static WebElement renewLetter_name;

    @FindBy(xpath="//div[@id='divEmailBody']//b[text()='DBA:']/following::td[1]")
    public static WebElement renewLetter_dba;

    @FindBy(xpath="//div[@id='divEmailBody']//b[text()='Program:']/following::td[1]")
    public static WebElement renewLetter_program;

    @FindBy(xpath="//div[@id='divEmailBody']//b[text()='Previous Policy Number:']/following::td[1]")
    public static WebElement renewLetter_PrePolicyNo;

    @FindBy(xpath="//div[@id='divEmailBody']//b[text()='Renewal Effective Date:']/following::td[1]")
    public static WebElement renewLetter_RenEffectDate;

    @FindBy(xpath="//div[@id='divEmailBody']//b[text()='Renewal Premium:']/following::td[2]")
    public static WebElement renewLetter_RenPremium;

    @FindBy(xpath="//div[@id='divEmailBody']//b[text()='Broker Fee*:']/following::td[2]")
    public static WebElement renewLetter_BrokerFee;

    @FindBy(xpath="//div[@id='divEmailBody']//b[text()='Wholesaler Fee:']/following::td[2]")
    public static WebElement renewLetter_wholesalerFee;

    @FindBy(xpath="//div[@id='divEmailBody']//b[text()='Total:']/following::td[2]")
    public static WebElement renewLetter_total;

    @FindBy(xpath="//div[@id='divEmailBody']//b[text()='Previous Payment Method:']/following::td[1]")
    public static WebElement renewLetter_PrePaymentMethod;

    @FindBy(xpath="//div[@id='divEmailBody']//b[text()='Previous Payment Plan:']/following::td[1]")
    public static WebElement renewLetter_PrePayPlan;

    @FindBy(xpath="//div[@id='divEmailBody']//div[text()='Want to update policy information? ']")
    public static WebElement renewLetter_updatePolicyInfo_link;

    @FindBy(xpath="//div[@id='divEmailBody']//div[text()='Want to update broker fee or payment information for the renewal term? ']")
    public static WebElement renewLetter_PayInfoForRenewalTerm_link;

    @FindBy(xpath="//div[@id='divEmailBody']//u[text()='Important Renewal Information']")
    public static WebElement renewLetter_ImportantInfo_Heading;

    @FindBy(xpath="//div[@id='divEmailBody']//b[contains(text(),'when applicable')]")
    public static WebElement renewLetter_1st_txtLine_DirectBill;

   /* @FindBy(xpath="//div[@id='divEmailBody']//div[contains(text(),'This is a direct bill policy. The insured will receive a Welcome Letter from BTIS DirectPay.')]")
    public static WebElement renewLetter_;

    @FindBy(xpath="//div[@id='divEmailBody']//div[6]//div//b/following-sibling::*[1]")
    public static WebElement renewLetter_;*/

    //=========================================================================================================

    // Renewal Pending status//AgencyFinance//BT007//TestAdmin-QAA01482480

    @FindBy(xpath="//div[@id='divEmailBody']/div[contains(text(),'scheduled for auto renewal')]")
    public static WebElement renewLetter_headline_AgencyFin_RenPending;

    @FindBy(xpath="//div[@id='divEmailBody']//b[contains(text(),'Please retain your producer commission and broker fee (when applicable).')]")
    public static WebElement renewLetter_1st_txtLine_AgencyFinance;

    //=========================================================================================================

    // Renewal Pending status//Premium Finance//BT007//TestAdmin-QAA01482477

    @FindBy(xpath="//div[@id='divEmailBody']/div[contains(text(),'scheduled for auto renewal')]")
    public static WebElement renewLetter_headline_PremiumFin_RenPending;

    @FindBy(xpath="//div[@id='divEmailBody']//div[contains(text(),'In order to finance your renewal policy with Best Choice Premium Finance, you must accept the terms.')]")
    public static WebElement renewLetter_Note_AgencyFin;

    @FindBy(xpath="//div[@id='divEmailBody']//b[contains(text(),'Please retain your producer commission and broker fee (when applicable) from the down payment.')]")
    public static WebElement renewLetter_1st_txtLine_PremiumFinance;

    //=========================================================================================================

    // Renewal Created status//DirectBill//TE026//TestAdmin-QAA01482568

    @FindBy(xpath="//div[@id='divEmailBody']//div[contains(text(),'The policy number referenced below is scheduled for DirectPay auto renewal. This renewal will be bound 30 days prior to the effective date using the payment information entered in the prior term. No action is required.')]")
    public static WebElement renewLetter_headline_RenewalCreated_DirectBill;

    @FindBy(xpath="//div[@id='divEmailBody']//b[contains(text(),'Your producer commission and broker fee (when applicable), will be paid directly by BTIS DirectPay.')]")
    public static WebElement renewLetter_1st_txtLine_RenewalCreated_DirectBill;
    
    @FindBy(xpath="//ul[@id='contextMenu']//li//a")
    public static WebElement RenewalCreated_DirectBill_contextOpt_All;
    
    @FindBy(xpath="//ul[@id='contextMenu']//li//a[contains(text(),'Renewal Information')]")
    public static WebElement RenewalCreated_DirectBill_contextOpt_RenewalInfo;
    
    

    //=========================================================================================================

    // Bind Request Pending status//AgencyFinance//TE026//TestAdmin-QAA01482571

    @FindBy(xpath="//div[@id='divEmailBody']/div[contains(text(),'The policy number referenced below is available for renewal through the One-Click Renewal program.')]")
    public static WebElement renewLetter_headline_BindReqPending_AgencyFin;

    //=========================================================================================================

    // Bind Request Pending status//PremiumFinance//TE026//TestAdmin-QAA01481989

    @FindBy(xpath="//div[@id='divEmailBody']/div[contains(text(),'The policy number referenced below is available for renewal through the One-Click Renewal program.')]")
    public static WebElement renewLetter_headline_BindReqPending_PremiumFin;
    
    
    
}
