package com.LegacyApplication.PageLocators;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.LegacyApplication.TestBase.TestBase;

public class WorkersCompLocators extends TestBase{
	
	public static WebDriver driver;
    public static final Logger log=Logger.getLogger(WorkersCompLocators.class.getName());
    
    //....................>>Workers Comp Locators<<.............................//
    
    //....................>>Tough Comp Integrated Workers Comp<<.............................//
    
    @FindBy(xpath="//select[@id='stateProgramFilter']")
    public static WebElement filterByState_drpdwn;
    
    @FindBy(xpath="//div[@id='stateAndGroupSelector']/descendant::a[@data-shows-group='workers-comp']")
    public static WebElement workerscomp_tab;
    
    @FindBy(xpath="//img[@alt='Integrated Underwriter Workers Comp']")
    public static WebElement toughcomp_integreted_uw;
    
    @FindBy(xpath="//img[@alt='Shift Pixy Workers Comp']")
    public static WebElement shiftPixy_wc_link;
    
    @FindBy(xpath="//div[@program='QWCA' and @data-group='workers-comp']/img")
    public static WebElement victory_wc_link;
    
    @FindBy(xpath="//button[@class='btn btn-primary' and text()='Continue']")
    public static WebElement continue_button;
    
    @FindBy(xpath="//button[@class='btn btn-primary' and text()='Rate with Victory']")
    public static WebElement rate_with_victory_btn;
    
//....................>Workers Comp_rating Locators<<.............................//
    
    @FindBy(xpath="//span[@id='QuoteNum']")
    public static WebElement wc_application_quote_number;
    
    @FindBy(xpath="//input[@id='Step1_InsName']")
    public static WebElement wc_applicatnName_txtb;
    
    @FindBy(xpath="//input[@id='Step1_InsDba' and @type='text']")
    public static WebElement wc_dba_txtb;
    
    @FindBy(xpath="//input[@id='Step1_DateEff']")
    public static WebElement wc_effectivedate;
    
    @FindBy(xpath="//select[@id='Step1_Lapse']")
    public static WebElement wc_currentlapse_drpdwn;
    
    @FindBy(xpath="//input[@id='Step1_InsAdr1']")
    public static WebElement wc_address_txtb;
    
    @FindBy(xpath="//input[@id='Step1_InsCity']")
    public static WebElement wc_city_txtb;
    
    @FindBy(xpath="//select[@id='Step1_InsState']")
    public static WebElement wc_state_drpdwn;
    
    @FindBy(xpath="//input[@id='Step1_InsZip']")
    public static WebElement wc_zip_txtb;
    
    @FindBy(xpath="//input[@id='Step1_InsPhoneAreaCode']")
    public static WebElement wc_phone1_txtb;
    
    @FindBy(xpath="//input[@id='Step1_InsPhonePrefix']")
    public static WebElement wc_phone2_txtb;
    
    @FindBy(xpath="//input[@id='Step1_InsPhoneNumber']")
    public static WebElement wc_phone3_txtb;
    
    @FindBy(xpath="//input[@id='Step1_TaxId']")
    public static WebElement wc_fein_txtb;
    
    @FindBy(xpath="//select[@id='Step3And4_LimitDesc']")
    public static WebElement wc_limitinsurance_drpdwn;
    
    @FindBy(xpath="//select[@id='Step2_ClassCodes_0__GovState']")
    public static WebElement wc_state0_drpdwn;
    
    @FindBy(xpath="//select[@id='Step2_ClassCodes_1__GovState']")
    public static WebElement wc_state1_drpdwn;
    
    @FindBy(xpath="//select[@id='Step2_ClassCodes_2__GovState']")
    public static WebElement wc_state2_drpdwn;
    
    @FindBy(xpath="//select[@id='Step2_ClassCodes_3__GovState']")
    public static WebElement wc_state3_drpdwn;
    
    //4 Classification_drpdwn.
    
    @FindBy(xpath="//input[@id='CcDesc0']/following::span[1]")
    public static WebElement wc_classification1_drpdwn;
    
    @FindBy(xpath="//input[@id='CcDesc0']")
    public static WebElement wc_classification1;
    
    @FindBy(xpath="//input[@id='CcDesc1']")
    public static WebElement wc_classification2;
    
    @FindBy(xpath="//div[@class='Results']/a")
    public static List <WebElement> wc_classification_list;
    
    @FindBy(xpath="//div[@class='Results']/child::a")
    public static List <WebElement> wc_classCode_List;
    
    @FindBy(xpath="//input[@id='CcDesc1' and @type='text']/following::span[1]")
    public static WebElement wc_classification2_drpdwn;
    
    @FindBy(xpath="//input[@id='CcDesc2' and @type='text']")
    public static WebElement wc_classification3_drpdwn;
    
    @FindBy(xpath="//input[@id='CcDesc3' and @type='text']")
    public static WebElement wc_classification4_drpdwn;
    
    @FindBy(xpath="//input[@id='Step2_ClassCodes_0__Payroll']")
    public static WebElement wc_payroll0_txtb;
    
    @FindBy(xpath="//input[@id='Step2_ClassCodes_1__Payroll']")
    public static WebElement wc_payroll1_txtb;
    
    @FindBy(xpath="//input[@id='Step2_ClassCodes_2__Payroll']")
    public static WebElement wc_payroll2_txtb;
    
    @FindBy(xpath="//input[@id='Step2_ClassCodes_3__Payroll']")
    public static WebElement wc_payroll3_txtb;
    
    
    @FindBy(xpath="//input[@id='Step2_ClassCodes_0__NumFullTimeEmps']")
    public static WebElement wc_fulltimeemp0_txtb;
    
    @FindBy(xpath="//input[@id='Step2_ClassCodes_1__NumFullTimeEmps']")
    public static WebElement wc_fulltimeemp1_txtb;
    
    @FindBy(xpath="//input[@id='Step2_ClassCodes_2__NumFullTimeEmps']")
    public static WebElement wc_fulltimeem2_txtb;
    
    @FindBy(xpath="//input[@id='Step2_ClassCodes_3__NumFullTimeEmps']")
    public static WebElement wc_fulltimeemp3_txtb;
    
    @FindBy(xpath="//input[@id='Step2_ClassCodes_0__NumPartTimeEmps']")
    public static WebElement wc_parttimeemp0_txtb;
    
    @FindBy(xpath="//input[@id='Step2_ClassCodes_1__NumPartTimeEmps']")
    public static WebElement wc_parttimeemp1_txtb;
    
    @FindBy(xpath="//input[@id='Step2_ClassCodes_2__NumPartTimeEmps']")
    public static WebElement wc_parttimeemp2_txtb;
    
    
    @FindBy(xpath="//input[@id='Step2_ClassCodes_3__NumPartTimeEmps']")
    public static WebElement wc_parttimeemp3_txtb;
    
    @FindBy(xpath="//a[@id='AddClasses']")
    public static WebElement wc_addclass_btn;
    
    @FindBy(xpath="//input[@id='Step3And4_EmPct']")
    public static WebElement wc_expmod_txtb;
    
    @FindBy(xpath="//input[@id='Step3And4_BwChk']")
    public static WebElement wc_blanket_chkb;
    
    @FindBy(xpath="//input[@id='Step3And4_MCPChk']")
    public static WebElement wc_mcp65_chkb;
    
    @FindBy(xpath="//input[@alt='Rate It Now']")
    public static WebElement wc_rateit_btn;
    
  //....................>Workers Comp_ Eligibility question page - Locators<<.............................//
    
    //GENRAL QUESTIONS NO as answers
    
    @FindBy(xpath="//input[@id='cphMain_ctl00_rblAnswer_1']")
    public static WebElement wc_eleq1_rbtn;
    
    @FindBy(xpath="//input[@id='cphMain_ctl01_rblAnswer_1']")
    public static WebElement wc_eleq2_rbtn;
    
    @FindBy(xpath="//input[@id='cphMain_ctl02_rblAnswer_1']")
    public static WebElement wc_eleq3_rbtn;
    
    @FindBy(xpath="//input[@id='cphMain_ctl03_rblAnswer_1']")
    public static WebElement wc_eleq4_rbtn;
    
    @FindBy(xpath="//input[@id='cphMain_ctl09_rblAnswer_1']")
    public static WebElement wc_eleq5_rbtn;
    
    @FindBy(xpath="//input[@id='cphMain_ctl13_rblAnswer_1']")
    public static WebElement wc_eleq6_rbtn;
    
    //GENRAL QUESTIONS NO as answers for CA state
    
    @FindBy(xpath="//input[@id='cphMain_ctl00_rblAnswer_1']")
    public static WebElement wc_ca_eleq1_rbtn;
    
    @FindBy(xpath="//input[@id='cphMain_ctl01_rblAnswer_1']")
    public static WebElement wc_ca_eleq2_rbtn;
    
    @FindBy(xpath="//input[@id='cphMain_ctl02_rblAnswer_1']")
    public static WebElement wc_ca_eleq3_rbtn;
    
    
    //Classification eligibility questions 0035 (For CA State) NO as answers
    
    @FindBy(xpath="//input[@id='cphMain_ctl03_rblAnswer_1']")
    public static WebElement wc_ca_eleq1_0035_rbtn;
    
   //Classification eligibility questions 0035 (For CA State) NO as answers
    
    @FindBy(xpath="//input[@id='cphMain_ctl04_rblAnswer_1']")
    public static WebElement wc_ca_eleq1_0005_rbtn;
    
    @FindBy(xpath="//input[@id='cphMain_ctl05_rblAnswer_1']")
    public static WebElement wc_ca_eleq2_0005_rbtn;
    
    @FindBy(xpath="//input[@id='cphMain_ctl06_rblAnswer_1']")
    public static WebElement wc_ca_eleq3_0005_rbtn;
    
    @FindBy(xpath="//input[@id='cphMain_ctl07_rblAnswer_1']")
    public static WebElement wc_ca_eleq4_0005_rbtn;
    
    @FindBy(xpath="//input[@id='cphMain_ctl08_rblAnswer_1']")
    public static WebElement wc_ca_eleq5_0005_rbtn;
    
    @FindBy(xpath="//input[@id='cphMain_ctl09_rblAnswer_1']")
    public static WebElement wc_ca_eleq6_0005_rbtn;
    
    @FindBy(xpath="//input[@id='cphMain_ctl10_rblAnswer_1']")
    public static WebElement wc_ca_eleq7_0005_rbtn;
    
    //Classification eligibility questions 0035 NO as answers
    
    @FindBy(xpath="//input[@id='cphMain_ctl16_rblAnswer_1']")
    public static WebElement wc_eleq1_0035_rbtn;
    
    //Classification eligibility questions 0005 NO as answers
    
    @FindBy(xpath="//input[@id='cphMain_ctl17_rblAnswer_1']")
    public static WebElement wc_eleq1_0005_rbtn;
    
    @FindBy(xpath="//input[@id='cphMain_ctl18_rblAnswer_1']")
    public static WebElement wc_eleq2_0005_rbtn;
    
    @FindBy(xpath="//input[@id='cphMain_ctl19_rblAnswer_1']")
    public static WebElement wc_eleq3_0005_rbtn;
    
    @FindBy(xpath="//input[@id='cphMain_ctl20_rblAnswer_1']")
    public static WebElement wc_eleq4_0005_rbtn;
    
    @FindBy(xpath="//input[@id='cphMain_ctl21_rblAnswer_1']")
    public static WebElement wc_eleq5_0005_rbtn;
    
    @FindBy(xpath="//input[@id='cphMain_ctl22_rblAnswer_1']")
    public static WebElement wc_eleq6_0005_rbtn;
    
    @FindBy(xpath="//input[@id='cphMain_ctl23_rblAnswer_1']")
    public static WebElement wc_eleq7_0005_rbtn;
    
    @FindBy(xpath="//a[@id='cphMain_navBtns_btnNext']")
    public static WebElement wc_elgques_continue_btn;
   
        
  //....................>Workers Comp_PriceIndicators - Locators<<.............................//
    
    @FindBy(xpath="//select[@id='InvDetail_SelectedPayPlanIdent']")
    public static WebElement wc_paymentoption_drpdwn;
    
    @FindBy(xpath="//*[text()='Prev']")
    public static WebElement wc_priceindicator_prev_btn;
    
    @FindBy(xpath="//*[text()='Next']")
    public static WebElement wc_priceindicator_nxt_btn;
    
    
  //....................>Workers Comp_ Application page Locators<<............................./
    
    @FindBy(xpath="//input[@id='Applicant_InsName']")
    public static WebElement wc_appname_txtb;
    
    @FindBy(xpath="//input[@id='Applicant_InsDba']")
    public static WebElement wc_appdba_txtb;
    
    @FindBy(xpath="//input[@id='Applicant_DateEff']")
    public static WebElement wc_appeffectivedate;
    
    @FindBy(xpath="//select[@id='Applicant_Lapse']")
    public static WebElement wc_applapse_drpdwn;
    
    @FindBy(xpath="//input[@id='Applicant_InsAdr1']")
    public static WebElement wc_appadd1_txtb;
    
    @FindBy(xpath="//input[@id='Applicant_InsCity']")
    public static WebElement wc_appcity_txtb;
    
    @FindBy(xpath="//select[@id='Applicant_InsState']")
    public static WebElement wc_appstate_drpdwn;
    
    @FindBy(xpath="//input[@id='Applicant_InsZip']")
    public static WebElement wc_appzip_txtb;
    
    @FindBy(xpath="//input[@id='Applicant_InsPhoneAreaCode']")
    public static WebElement wc_appphone1_txtb;
    
    @FindBy(xpath="//input[@id='Applicant_InsPhonePrefix']")
    public static WebElement wc_appphone2_txtb;
    
    @FindBy(xpath="//input[@id='Applicant_InsPhoneNumber']")
    public static WebElement wc_appphone3_txtb;
    
    @FindBy(xpath="//input[@id='Applicant_TaxId']")
    public static WebElement wc_appfein_txtb;
    
    @FindBy(xpath="//input[@id='Applicant_LicenseNum']")
    public static WebElement wc_appLicenceNumber_txtb;
    
    @FindBy(xpath="//input[@id='Applicant_Website']")
    public static WebElement wc_appwebsite_txtb;
    
    @FindBy(xpath="//input[@id='Mailing_MailSameAsPhys']")
    public static WebElement wc_samemailingadd_chkb;
    
    @FindBy(xpath="//input[@id='Mailing_MaAddress']")
    public static WebElement wc_mailadd1_txtb;
    
    @FindBy(xpath="//input[@id='Mailing_MaCity']")
    public static WebElement wc_mailcity_txtb;
    
    @FindBy(xpath="//select[@id='Mailing_MaState']")
    public static WebElement wc_mailstate_drpdwn;
    
    @FindBy(xpath="//input[@id='Mailing_MaZip']")
    public static WebElement wc_mailzip_txtb;
    
    @FindBy(xpath="//input[@id='Mailing_MaContactFirst']")
    public static WebElement wc_contactFirstName_txtb;
    
    @FindBy(xpath="//input[@id='Mailing_MaContactLast']")
    public static WebElement wc_contactLastName_txtb;
    
    @FindBy(xpath="//input[@id='Mailing_SpanishService']")
    public static WebElement wc_spanishservice_chkb;
    
    @FindBy(xpath="//select[@id='Mailing_QbLegalEntity']")
    public static WebElement wc_typebusiness_drpdwn;
    
    @FindBy(xpath="//select[@id='Mailing_QbYearsInBusiness']")
    public static WebElement wc_yearbusiness_drpdwn;
    
    @FindBy(xpath="//input[@id='Officer_Officers_0__OffName']")
    public static WebElement wc_ownername0_txtb;
    
    @FindBy(xpath="//input[@id='Officer_Officers_1__OffName']")
    public static WebElement wc_ownername1_txtb;
    
    @FindBy(xpath="//input[@id='Officer_Officers_2__OffName']")
    public static WebElement wc_ownername2_txtb;
    
    @FindBy(xpath="//input[@id='Officer_Officers_3__OffName']")
    public static WebElement wc_ownername3_txtb;
    
    
    @FindBy(xpath="//input[@id='Officer_Officers_0__OffTitle']")
    public static WebElement wc_ownertitle0_txtb;
    
    @FindBy(xpath="//input[@id='Officer_Officers_1__OffTitle']")
    public static WebElement wc_ownertitle1_txtb;
    
    @FindBy(xpath="//input[@id='Officer_Officers_2__OffTitle']")
    public static WebElement wc_ownertitle2_txtb;
    
    @FindBy(xpath="//input[@id='Officer_Officers_3__OffTitle']")
    public static WebElement wc_ownertitle3_txtb;
    
    @FindBy(xpath="//input[@id='Officer_Officers_0__OffOwnerPct']")
    public static WebElement wc_ownerpercent0_txtb;
    
    @FindBy(xpath="//input[@id='Officer_Officers_1__OffOwnerPct']")
    public static WebElement wc_ownerpercent1_txtb;
    
    @FindBy(xpath="//input[@id='Officer_Officers_2__OffOwnerPct']")
    public static WebElement wc_ownerpercent2_txtb;
    
    @FindBy(xpath="//input[@id='Officer_Officers_3__OffOwnerPct']")
    public static WebElement wc_ownerpercent3_txtb;
    
    @FindBy(xpath="//select[@id='Officer_Officers_0__OffEI']")
    public static WebElement wc_ownerexin0_drpdwn;
    
    @FindBy(xpath="//select[@id='Officer_Officers_1__OffEI']")
    public static WebElement wc_ownerexin1_drpdwn;
    
    @FindBy(xpath="//select[@id='Officer_Officers_2__OffEI']")
    public static WebElement wc_ownerexin2_drpdwn;
    
    @FindBy(xpath="//select[@id='Officer_Officers_3__OffEI']")
    public static WebElement wc_ownerexin3_drpdwn;
    
    
    @FindBy(xpath="//input[@id='History_Historys_0__HistNoCov']")
    public static WebElement wc_noinsurancecoverage_chkb;
    
    @FindBy(xpath="//input[@id='History_Historys_0__HistCarrier']")
    public static WebElement wc_carriername_txtb;
    
    @FindBy(xpath="//input[@id='History_Historys_0__HistPolicy']")
    public static WebElement wc_policy_txtb;
    
    @FindBy(xpath="//textarea[@id='History_Historys_0__HistPremium']")
    public static WebElement wc_premium_txtb;
    
    @FindBy(xpath="//textarea[@id='History_Historys_0__HistNumClaims']")
    public static WebElement wc_ofclaims_txtb;
    
    @FindBy(xpath="//textarea[@id='Description_DescOfOperations']")
    public static WebElement wc_description_txtb;
    
    @FindBy(xpath="//textarea[@id='Description_Comments']")
    public static WebElement wc_comments_txtb;
    
    @FindBy(xpath="//div[@id='SubmitToUnderwriting']/input")
    public static WebElement wc_submit_to_underwriting_btn;
    
  //....................>Workers Comp binding document Locators<<............................./
    
    @FindBy(xpath="//input[@name='radioStatus' and @type='radio']//following::td[1]")
    public static List <WebElement> changestatus_labels;
    
    @FindBy(xpath="//select[@id='selectCarrier']")
    public static WebElement selectCarrier_drpdwn;
}


