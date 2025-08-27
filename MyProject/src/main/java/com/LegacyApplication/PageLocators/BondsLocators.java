package com.LegacyApplication.PageLocators;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.LegacyApplication.TestBase.TestBase;

public class BondsLocators extends TestBase {
	
	public static WebDriver driver;
    public static final Logger log=Logger.getLogger(BondsLocators.class.getName());
    
  //....................>>Bonds Product Locators<<.............................//
    @FindBy(xpath="//div[@id='stateAndGroupSelector']//a[contains(normalize-space(text()), 'Bonds')]")
    public static WebElement bonds_button;
    
    @FindBy(xpath="//img[@alt='Victory Contractor Bonds']")
    public static WebElement vcb_link;
    
    @FindBy(xpath="//img[@alt='Victory Xpress Bonds']")
    public static WebElement victory_xpress_bondlink;
    
  //....................>>Victory Contractor Bond Locators<<.............................//
  //....................>>VCB Bond Information Locators<<.............................//
    
    @FindBy(xpath="//select[@id='BondInfo_StateId']")
    public static WebElement vcb_state_drpdwn;
    
    @FindBy(xpath="//input[@id='EffectiveDate_Value']")
    public static WebElement vcb_effective_date;
    
    @FindBy(xpath="//input[@id='BondInfo_HasLicense'][1]")
    public static WebElement vcb_applicantLicenceYes_rbtn;
    
    @FindBy(xpath="//input[@id='BondInfo_HasLicense'][2]")
    public static WebElement vcb_applicantLicenceNo_rbtn;
    
    @FindBy(xpath="//input[@id='BondInfo_LicenseNumber']")
    public static WebElement BondInfo_LicenseNumber;
    
    @FindBy(xpath="(//div[@class='LicenseEndorsementType']//input)[position()=1]")
    public static WebElement vcb_residentialConstructionLicense_chkbx;
    
    @FindBy(xpath="(//div[@class='LicenseEndorsementType']//input)[position()=2]")
    public static WebElement vcb_commercialConstructionLicense_chkbx;
    
    @FindBy(xpath="(//div[@class='LicenseEndorsementType']//input)[position()=3]")
    public static WebElement vcb_publicWorksLicense_chkbx;
    
    @FindBy(xpath="(//div[@id='divLicenseEndorsementTypes']//select)[position()=1]")
    public static WebElement vcb_residentialConstruction_drpdwn;
    
    @FindBy(xpath="(//div[@id='divLicenseEndorsementTypes']//select)[position()=2]")
    public static WebElement vcb_commercialConstruction_drpdwn;
    
    @FindBy(xpath="(//div[@id='divLicenseEndorsementTypes']//select)[position()=3]")
    public static WebElement vcb_publicWorks_drpdwn;
    
  //....................>>VCB Company Information Locators<<.............................//
    
    @FindBy(xpath="//input[@id='CompanyInfo_DBA']")
    public static WebElement vcb_company_name;
    
    @FindBy(xpath="//select[@id='CompanyInfo_BusinessTypeId']")
    public static WebElement vcb_company_type;
    
    @FindBy(xpath="//input[@id='CompanyInfo_BusinessName']")
    public static WebElement vcb_dba;
    
    @FindBy(xpath="//input[@id='CompanyInfo_BusinessAddress']")
    public static WebElement vcb_business_address;
    
    @FindBy(xpath="//input[@id='CompanyInfo_BusinessCity']")
    public static WebElement vcb_busienss_city;
    
    @FindBy(xpath="//select[@id='CompanyInfo_BusinessStateId']")
    public static WebElement vcb_company_state_drpdwn;
    
    @FindBy(xpath="//input[@id='CompanyInfo_BusinessPostalCode']")
    public static WebElement vcb_zipcode;
    
    @FindBy(xpath="//input[@id='CompanyInfo_BusinessPhone']")
    public static WebElement vcb_business_phone;
    
    @FindBy(xpath="//input[@id='CompanyInfo_BusinessFax']")
    public static WebElement vcb_business_fax;
    
    @FindBy(xpath="//input[@id='CompanyInfo_Email']")
    public static WebElement vcb_email;
    
   //....................>>VCB personal Indemnitor Locators<<.............................//
    
    @FindBy(xpath="//input[@id='CreditCheckInfo_FirstName']")
    public static WebElement vcb_pi_firstname;
    
    @FindBy(xpath="//input[@id='CreditCheckInfo_MiddleName']")
    public static WebElement vcb_pi_middlename;
    
    @FindBy(xpath="//input[@id='CreditCheckInfo_LastName']")
    public static WebElement vcb_pi_lastname;
    
    @FindBy(xpath="//select[@id='CreditCheckInfo_Suffix']")
    public static WebElement vcb_suffix_drpdwn;
    
    @FindBy(xpath="//input[@id='chkSameAddress']")
    public static WebElement vcb_sameaddress_chkbx;
    
    @FindBy(xpath="//input[@id='CreditCheckInfo_Address']")
    public static WebElement vcb_pi_homeaddress;
    
    @FindBy(xpath="//input[@id='CreditCheckInfo_City']")
    public static WebElement vcb_pi_homecity;
    
    @FindBy(xpath="//select[@id='CreditCheckInfo_State']")
    public static WebElement vcb_pi_homestate;
    
    @FindBy(xpath="//input[@id='CreditCheckInfo_ZipCode']")
    public static WebElement vcb_pi_homezip;
    
    @FindBy(xpath="//input[@id='CreditCheckInfo_SSN']")
    public static WebElement vcb_si_ssnnumber;
    
    @FindBy(xpath="//input[@id='CreditCheckInfo_ConfirmSSN']")
    public static WebElement vcb_si_confirmssn;
    
    @FindBy(xpath="//input[@id='CreditCheckInfo_CreditCheckOK']")
    public static WebElement vcb_creditcheck_chkbox;
    
    @FindBy(xpath="//input[@id='btnRateItNow']")
    public static WebElement vcb_rateitnow_btn;
    
    // Pricing page Locators
    @FindBy(xpath="//img[@id='imgCarrierCBA']")
    public static WebElement compricing_amtrust_chkbx;
    
    @FindBy(xpath="//img[@id='imgCarrierBWS']")
    public static WebElement compricing_acna_chkbx;
    
    @FindBy(xpath="//input[@id='btnCreateSubmission']")
    public static WebElement compricing_acreatesubmission_btn;
    
    //=====Price Indicator page==============
    @FindBy(xpath="//input[@id='radioButtonTerm1']")
    public static WebElement year1_radio_btn;
    
    @FindBy(xpath="//input[@id='radioButtonTerm2']")
    public static WebElement year2_radio_btn;
    
    @FindBy(xpath="//input[@id='radioButtonTerm3']")
    public static WebElement year3_radio_btn;
    
    @FindBy(xpath="//input[@id='next']")
    public static WebElement next_btn;
    
    @FindBy(xpath="//input[@id='previous']")
    public static WebElement previous_btn;
    
    // Final Review Page
    
    @FindBy(xpath="//img[@id='imgIssue']")
    public static WebElement bondIssue_btn;
    
    @FindBy(xpath="//img[@id='imgViewDocuments']")
    public static WebElement view_docu_btn;
    
    //Bond Issuance checklist
    
    @FindBy(xpath="//input[@id='chkReadyToIssue']")
    public static WebElement chkReadyToIssue;
    
    @FindBy(xpath="//input[@id='PaymentType_ECheck']")
    public static WebElement PaymentType_ECheck;
    
    @FindBy(xpath="//input[@id='PaymentType_CreditCard']")
    public static WebElement PaymentType_CreditCard;
    
    @FindBy(xpath="//input[@id='PaymentType_Agency']")
    public static WebElement PaymentType_Agency;
    
    @FindBy(xpath="//input[@id='FinalEffectiveDate_Value']")
    public static WebElement FinalEffectiveDate_Value;
    
    @FindBy(xpath="//img[@id='imgIssueConfirm']")
    public static WebElement imgIssueConfirm;
    
    //Agent acknowledgement
    
    @FindBy(xpath="//div[@id='divAgentAcknowledgement']//b[contains(text(),'I understand that I am responsible')]")
    public static WebElement divAgentAcknowledgement;
    
    @FindBy(xpath="//img[@id='imgIssueConfirmAck']")
    public static WebElement imgIssueConfirmAck;
    
    @FindBy(xpath="//img[@id='imgCancelTransactionAck']")
    public static WebElement imgCancelTransactionAck;
    
    //Final ReviewPage2
    @FindBy(xpath="//img[@id='imgPrintPackage']")
    public static WebElement imgPrintPackage;
    
    @FindBy(xpath="//img[@id='imgPrintInvoice']")
    public static WebElement imgPrintInvoice;
    
    @FindBy(xpath="//img[@id='imgGoHome']")
    public static WebElement imgGoHome;
        
    @FindBy(xpath="//div[@id='divFinalReview']/div[1]/div[1]")
    public static WebElement qbws_submssion_id;
    
    //....................>>Victory express bond Locators<<.............................//
    
    @FindBy(xpath="//xhtml:div[@id='viewer']//xhtml:div[contains(text(),'E-Mail Address')]")
    public static WebElement vez_emailAddressField;
   
    
}
