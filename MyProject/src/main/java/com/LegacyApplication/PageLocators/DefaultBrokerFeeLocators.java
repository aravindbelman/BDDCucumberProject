package com.LegacyApplication.PageLocators;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.LegacyApplication.TestBase.TestBase;

public class DefaultBrokerFeeLocators extends TestBase {
	
	public static WebDriver driver;
    public static final Logger log=Logger.getLogger(DefaultBrokerFeeLocators.class.getName());
    
    @FindBy(xpath="//a[@class='dropdown-toggle' and contains(text(),'Admin Tasks')]/i")
    public static WebElement admintasks_tab;
    
    @FindBy(xpath="//ul[@class='dropdown-menu']//li//a[text()='Agency Information - View']")
    public static WebElement agency_informationview;
    
    @FindBy(xpath="//select[@id='SearchField']")
    public static WebElement agency_search_dropdown;
    
    @FindBy(xpath="//input[@id='SearchValue']")
    public static WebElement agency_name_searchfield;
    
    @FindBy(xpath="//button[@id='searchBtn']")
    public static WebElement search_button;
    
    @FindBy(xpath="//table[@id='grid']//tbody//tr//td[contains(text(),'BORCE TEST' )]")
    public static WebElement select_agency;
    
    @FindBy(xpath="//li//a[@id='viewLink']")
    public static WebElement view_link;
    
  //......................>>Agency Information View Locators<<.............................//
    
    @FindBy(xpath="//input[@name='GeneralInfo.AgencyName']")
    public static WebElement agency_name;
    
    @FindBy(xpath="//div[@id='GeneralInfo']/div[3]/div[1]/select")
    public static WebElement agencyinfo_status;
    
    @FindBy(xpath="//div[@id='GeneralInfo']/div[3]/div[2]/select")
    public static WebElement agencyinfo_reason;
    
    @FindBy(xpath="//input[@name='GeneralInfo.Contact' and @type='text']")
    public static WebElement agencyinfo_agencycontact;
    
    @FindBy(xpath="//input[@name='GeneralInfo.EmailId' and @type='text']")
    public static WebElement agencyinfo_emailaddress;
    
    @FindBy(xpath="//select[@name='GeneralInfo.BusinessType']")
    public static WebElement agencyinfo_businesstype;
    
    @FindBy(xpath="//input[@name='GeneralInfo.Fedaraltaxid' and @type='text']")
    public static WebElement agencyinfo_federaltax;
    
    @FindBy(xpath="//input[@name='GeneralInfo.Webaddress' and @type='text']")
    public static WebElement agencyinfo_webaddress;
    
    @FindBy(xpath="//input[@name='GeneralInfo.PhoneNo' and @type='text']")
    public static WebElement agencyinfo_phoneno;
    
    @FindBy(xpath="//input[@name='GeneralInfo.Fax' and @type='text']")
    public static WebElement agencyinfo_faxnumber;
    
    @FindBy(xpath="//input[@name='GeneralInfo.Tollfree' and @type='text']")
    public static WebElement agencyinfo_tollfreenumber;
    
    @FindBy(xpath="//input[@name='GeneralInfo.Licensenumber' and @type='text']")
    public static WebElement agencyinfo_licensenumber;
    
    @FindBy(xpath="//input[@name='GeneralInfo.Licenseexpdate' and @type='text']")
    public static WebElement agencyinfo_licenseexpdate;
    
    @FindBy(xpath="//input[@name='GeneralInfo.Eopolicynumber' and @type='text']")
    public static WebElement agencyinfo_policynumber;
    
    @FindBy(xpath="//input[@name='GeneralInfo.Eopolicydate' and @type='text']")
    public static WebElement agencyinfo_policydate;
    
    @FindBy(xpath="//input[@name='GeneralInfo.Pname1' and @type='text']")
    public static WebElement agencyinfo_principlename1;
    
    @FindBy(xpath="//input[@name='GeneralInfo.Email1' and @type='text']")
    public static WebElement agencyinfo_princpleemail1;
    
    @FindBy(xpath="//input[@name='GeneralInfo.Pname2' and @type='text']")
    public static WebElement agencyinfo_principlename2;
    
    @FindBy(xpath="//input[@name='GeneralInfo.Email2' and @type='text']")
    public static WebElement agencyinfo_princpleemail2;
    
    @FindBy(xpath="//input[@name='GeneralInfo.Pname3' and @type='text']")
    public static WebElement agencyinfo_principlename3;
    
    @FindBy(xpath="//input[@name='GeneralInfo.Email3' and @type='text']")
    public static WebElement agencyinfo_princpleemail3;
    
    @FindBy(xpath="//input[@name='GeneralInfo.Pname4' and @type='text']")
    public static WebElement agencyinfo_principlename4;
    
    @FindBy(xpath="//input[@name='GeneralInfo.Email4' and @type='text']")
    public static WebElement agencyinfo_princpleemail4;
    
    @FindBy(xpath="//input[@name='GeneralInfo.Address1' and @type='text']")
    public static WebElement agencyinfo_mailingaddress;
    
    @FindBy(xpath="//input[@name='GeneralInfo.City' and @type='text']")
    public static WebElement agencyinfo_mailingcity;
    
    @FindBy(xpath="//select[@name='GeneralInfo.State']")
    public static WebElement agencyinfo_mailingstate;
    
    @FindBy(xpath="//input[@name='GeneralInfo.Zip' and @type='text']")
    public static WebElement agencyinfo_mailingzip;
    
    @FindBy(xpath="//input[@id='SameAsAddress']")
    public static WebElement agencyinfo_sameaddresschkbox;
    
    @FindBy(xpath="//input[@name='GeneralInfo.NonMailingAddress' and @type='text']")
    public static WebElement agencyinfo_agencyaddress;
    
    @FindBy(xpath="//input[@name='GeneralInfo.NonMailingCity' and @type='text']")
    public static WebElement agencyinfo_agencycity;
    
    @FindBy(xpath="//select[@id='State']")
    public static WebElement agencyinfo_agencystate;
    
    @FindBy(xpath="//input[@name='GeneralInfo.NonMailingZip' and @type='text']")
    public static WebElement agencyinfo_agencyzip;
    
    @FindBy(xpath="//select[@id='TerritoryId' and @name='GeneralInfo.TerritoryId']")
    public static WebElement agencyinfo_agencyterritoryid;
    
    @FindBy(xpath="//a[@id='backButton']")
    public static WebElement agencyinfo_backtoagencybtn;
    
  //......................>>More Information View Locators<<.............................//
    
    @FindBy(xpath="//div[@id='form-in-groups']//a[text()='More Info']")
    public static WebElement moreinfo_tab;
    
    @FindBy(xpath="//div[@id='MoreInfo']//input")
    public static List <WebElement> moreinfo_chekcboxes;
    
  //......................>>Contact Information Locators<<.............................//
    
    @FindBy(xpath="//a[@id='AgentsManager']")
    public static WebElement contacts_manageagent_tab;
    
    @FindBy(xpath="//select[@name='Contacts.DefaultRenewalContact']")
    public static WebElement contacts_defaultrenewalcontact;
    
    @FindBy(xpath="//select[@name='Contacts.SingleRenewalContact']")
    public static WebElement contacts_singlerenewalcontact;
    
    @FindBy(xpath="//textarea[@name='Notes']")
    public static WebElement notes_notes;
    
  //......................>>Locators to validate Broker fee<<.............................//
    
    @FindBy(xpath="//ul[@id='contextMenu']/li//a[text()='Change Status']")
    public static WebElement changestatus_link;
    
    @FindBy(xpath="//ul[@id='contextMenu']/li//a[text()='Review Submission']")
    public static WebElement reviewSubmission_link;
    
    @FindBy(xpath="//ul[@id='contextMenu']/li//a[text()='Temp Endorsement']")
    public static WebElement gl_tempEndorsement_link;
    
    @FindBy(xpath="//ul[@id='contextMenu']/li//a[text()='Create Endorsement']")
    public static WebElement gl_createEndorsement_link;
    
    @FindBy(xpath="//button[@id='AreYouSureBtn']")
    public static WebElement tempEndoresment_continue_btn;
    
    @FindBy(xpath="//label//input[@id='Status']")
    public static List <WebElement> changestatus_options;
    
    @FindBy(xpath="//form[@id='ChangeStatus']/div[1]/div/div/label")
    public static List <WebElement> changestatus_labels;
    
    //@FindBy(xpath="(//input[@id='Status'])[position()=2]")
    @FindBy(xpath="(//input[@id='Status'])[position()='\"+j+\"']")
    public static WebElement changestatus_oktobind;
    
    @FindBy(xpath="//button[@type='button' and text()='Submit']")
    public static WebElement changestatus_submitbutton;
    
    @FindBy(xpath="//div[@id='ModalDialog']//button[@class='btn btn-default' and text()='Cancel']")
    public static WebElement changestatus_cancelbutton;
    
    @FindBy(xpath="//ul[@id='contextMenu']//li//a[text()='View App']")
    public static WebElement view_application_link;
    
    @FindBy(xpath=".//*[@id='viewer']/xhtml:div[1]/xhtml:div[2]/xhtml:div[135]")
    public static WebElement broker_fee_text;
    
    @FindBy(xpath="//ul[@id='contextMenu']/li//a[text()='Binding Documents']")
    public static WebElement bindingDocuments_link;
    
    @FindBy(xpath="//h2[@class='center underline bold' and contains(text(),'Victory Inland Marine Information to Request Binding of Coverage')]")
    public static WebElement bindingDocPage_Heading;
    
    @FindBy(xpath="//ul[@id='contextMenu']/li//a[text()='Renewal Information']")
    public static WebElement renewalInformation_link;
    
    @FindBy(xpath="//ul[@id='contextMenu']/li//a[text()='Renewal Letter']")
    public static WebElement renewalLetter_link;
    
    @FindBy(xpath="//ul[@id='contextMenu']/li//a[text()='Request AI']")
    public static WebElement additionalInsured_link;
    
    @FindBy(xpath="//ul[@id='contextMenu']/li//a[text()='Make a Payment']")
    public static WebElement makePayment_link;
    
    @FindBy(xpath="//button[@id='btnSaveClose_nonDb']")
    public static WebElement bindingClose_btn;
        
}
