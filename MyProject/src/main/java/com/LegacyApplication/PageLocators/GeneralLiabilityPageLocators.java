package com.LegacyApplication.PageLocators;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.LegacyApplication.TestBase.TestBase;

public class GeneralLiabilityPageLocators extends TestBase {
	
    public static WebDriver driver;
	
    public static final Logger log=Logger.getLogger(GeneralLiabilityPageLocators.class.getName());
    
  //....................>>General Liability Locators<<.............................//
   //..................... Workers Com.................................................//
    
    @FindBy(xpath="//div[@id='stateAndGroupSelector']//a[contains(text(), 'Workers')]")
    public static WebElement workersCom_button;
    
    @FindBy(xpath="//div[@id='startSubmissionGrid']//div[@program='QMWC']//img[@alt='Workers Comp Rater']")
    public static WebElement select_wrokersCom;
    
    //====Clear Spring GL=======
    
    @FindBy(xpath="//div[@id='startSubmissionGrid']//img[@alt='General Liability Clear Spring']")
    public static WebElement clearSpring_button;
    
  //....................>>Victory General Liability Locators<<.............................//
   
    @FindBy(xpath="//div[@class='submissions']")
    public static WebElement goTo_submissions_btn;
    
    @FindBy(xpath="//div[@id='stateAndGroupSelector']//a[contains(normalize-space(text()), 'General Liability')]")
    public static WebElement general_liablity_button;
    
    @FindBy(xpath="//img[@alt='Victory General Liability']")
    public static WebElement victory_general_liability;
    
    @FindBy(xpath="//div[@id='startSubmissionGrid']//div[@program='QSTM']//img[@alt='STARR Marine GL']")
    public static WebElement starr_marine;
    
    @FindBy(xpath="//img[@alt='Comparative General Liability']")
	public static WebElement selectCBIC;
    
    @FindBy(xpath="//img[@class='next-icon-button']")
	public static WebElement selectNEXT;   
    
    
    @FindBy(xpath="//select[@id='SelectField' and @name='SelectField']")
    public static WebElement selectBy_drpDwn;
    
    @FindBy(xpath="//input[@id='Search' and @type='text']")
    public static WebElement submissionId_searchField;
    
    @FindBy(xpath="//select[@id='DateRange' and @name='DateRange']")
    public static WebElement dateRange_drpDwn;
    
    @FindBy(xpath="//button[@id='searchBtn']")
    public static WebElement submission_search_btn;
    
    @FindBy(xpath="//table[@id='searchTable']/tbody/tr/td[1]")
    public static List <WebElement> submission_id;
        
    //............................>>General Liability Marketplace<<..........................................//
    
    @FindBy(xpath="//select[@id='state']")
    public static WebElement state_select;
    
    @FindBy(xpath="//select[@id='classification']")
    public static WebElement classCode_select;
    
    @FindBy(xpath="//div[@id='productsContainer']//img[@alt='Attune General Liability']")
    public static WebElement attune_prg;
    
    @FindBy(xpath="//div[@id='productsContainer']//div[@program='QCR']/child::img[@alt='Victory General Liability']")
    public static WebElement gl_prg;
    
    @FindBy(xpath="//div[@id='productsContainer']//img[@alt='Comparative General Liability']")
    public static WebElement cbic_prg;
    
    @FindBy(xpath="//div[@id='productsContainer']//img[@alt='Hiscox NOW']")
    public static WebElement hiscox_prg;
    
    @FindBy(xpath="//div[@id='noProduct']//p[contains(text(),'We are unable to provide coverage')]")
    public static WebElement noProduct_prg;
    
    @FindBy(xpath="//div[@id='productsContainer']//img[@alt='Clear Spring General Liability']")
    public static WebElement clearSpring_prg;
  
    
  //....................>>Comparative Rater Locators<<.............................//
    
    @FindBy(xpath="//select[@id='selectState']")
    public static WebElement state_info;
    
    @FindBy(xpath="//input[@id='textLicense' and @name='submission.License']")
    public static WebElement licence_number;
    
    @FindBy(xpath="//input[@id='textZip']")
    public static WebElement zip_code;
    
    @FindBy(xpath="//select[@id='selectSubmissionType']")
    public static WebElement submission_type;
    
    @FindBy(xpath="//input[@id='textApplicantName']")
    public static WebElement applicant_name;
    
    @FindBy(xpath="//input[@id='textDBA']")
    public static WebElement dba;
    
    @FindBy(xpath="//img[@class='ui-datepicker-trigger']")
    public static WebElement gl_date_picker;
    
    @FindBy(xpath="//input[@id='EffectiveDate']")
    public static WebElement proposed_effective_date;
    
    @FindBy(xpath="//select[@id='selectLimit' and @name='submission.Limits']")
    public static WebElement gl_limits;
    
    @FindBy(xpath="//select[@id='selectDeductible' and @name='submission.Deductible']")
    public static WebElement gl_deductible;
    
    @FindBy(xpath="//input[@id='textOwners' and @class='textInputExSmallNumber']")
    public static WebElement gl_owners_activeinfield;
    
    @FindBy(xpath="//input[@id='textPT' and @name='submission.Ptemployees']")
    public static WebElement gl_parttime_emp;
    
    @FindBy(xpath="//input[@id='textFT' and @name='submission.Ftemployees']")
    public static WebElement gl_fulltime_emp;
    
    @FindBy(xpath="//select[@id='selectClass1' and @name='submission.Class1']")
    public static WebElement gl_select_class1;
    
    @FindBy(xpath="//input[@id='txtPercentage1' and @name='submission.Percentage1']")
    public static WebElement gl_class_percentage1;
    
    @FindBy(xpath="//select[@id='selectClass2' and @name='submission.Class2']")
    public static WebElement gl_select_class2;
    
    @FindBy(xpath="//input[@id='txtPercentage2' and @name='submission.Percentage2']")
    public static WebElement gl_class_percentage2;
    
    @FindBy(xpath="//select[@id='selectClass3' and @name='submission.Class3']")
    public static WebElement gl_select_class3;
    
    @FindBy(xpath="//input[@id='txtPercentage3' and @name='submission.Percentage3']")
    public static WebElement gl_class_percentage3;
    
    @FindBy(xpath="//select[@id='selectClass4' and @name='submission.Class4']")
    public static WebElement gl_select_class4;
    
    @FindBy(xpath="//input[@id='txtPercentage4' and @name='submission.Percentage4']")
    public static WebElement gl_class_percentage4;

    @FindBy(xpath="//button[@id='btnAdditionalClasses' and @type='button']")
    public static WebElement gl_additionalclass_button;      
    
    @FindBy(xpath="//input[@id='textSubcontracting' and @name='submission.MvcOpcCosts']")
    public static WebElement gl_subcontracting_costs;
    
    @FindBy(xpath="//input[@id='textGrossReceipts' and @name='submission.MvcReceipts']")
    public static WebElement gl_gross_receipts;
    
    @FindBy(xpath="//select[@id='selectExperience' and @name='submission.BusinessExperience']")
    public static WebElement gl_business_experience;
    
    @FindBy(xpath="//select[@id='selectYearsWithAmTrust']")
    public static WebElement gl_selectYearsWithAmTrust;
    
    @FindBy(xpath="//select[@id='selectGLPaidLoss' and @name='submission.GLpaidLoss']")
    public static WebElement gl_paid_loss;
    
    @FindBy(xpath="//input[@id='checkOption1' and @class='specialOptions']")
    public static WebElement gl_newResidentialStructure_chkbox;
    
    @FindBy(xpath="//button[@id='btnASRYes']")
    public static WebElement gl_SandRcredit_yeso;
    
    @FindBy(xpath="//button[@id='btnASRNo']")
    public static WebElement gl_SandRcredit_no;
    
    @FindBy(xpath="//input[@id='checkOption3' and @class='specialOptions']")
    public static WebElement gl_perprojectAggrefate_chkbox;
    
    @FindBy(xpath="//input[@id='checkOption4' and @class='specialOptions']")
    public static WebElement gl_employeeBenefits_chkbox;
    
    @FindBy(xpath="//input[@id='checkOption5' and @class='specialOptions']")
    public static WebElement gl_removeSubsidence_chkbox;
    
    @FindBy(xpath="//input[@id='checkOption7'and @class='specialOptions']")
    public static WebElement gl_additional_insured_endoresement_chkbox;
    
    @FindBy(xpath="//input[@id='checkOption8' and @class='specialOptions']")
    public static WebElement gl_coveragetoBusienss_chkbox;
    
    @FindBy(xpath="//input[@id='checkOption9' and @class='specialOptions']")
    public static WebElement gl_applicatior_coverage_chkbox;
    
    @FindBy(xpath="//input[@id='checkOption10' and @class='specialOptions']")
    public static WebElement gl_remove_employersliability_chkbox;
    
    @FindBy(xpath="//input[@id='chkContractorsEquipmentCoverage' and @class='specialOptions'] ")
    public static WebElement gl_optionalInalndMarine_chkbox;
    
    @FindBy(xpath="//select[@id='selectHasExistingAmtrustPolicyNumbers' and @name='submission.HasExistingAmtrustPolicyNumbers']")
    public static WebElement gl_existingAmturstPolicy;
    
    @FindBy(xpath="//img[@id='btnPriceIndicate' and @alt='Rate It!']")
    public static WebElement gl_rateitnow_button; 
    
    @FindBy(xpath="//button[@id='btnASRYes']")
    public static WebElement accept_ASR;
    
    @FindBy(xpath="//button[@id='btnASRNo']")
    public static WebElement decline_ASR;
    
    @FindBy(xpath="//div[@id='checkDivAMTRUSTADMITTED1']")
    public static WebElement victory_admitted_chkbox;
    
    @FindBy(xpath="//input[@id='checkBoxAMTRUSTADMITTED1' and @class='checkBoxSubmit']")
    public static WebElement verify_victory_admitted_chkbox;
    
    @FindBy(xpath="//div[@id='checkDivAMTRUSTNONADMITTED1']")
    public static WebElement victory_nonadmitted_chkbox;
    
    @FindBy(xpath="//input[@id='checkBoxAMTRUSTNONADMITTED1' and @type='checkbox']")
    public static WebElement verify_victory_nonadmitted_chkbox;
    
    @FindBy(xpath="//div[@id='checkDivAMTRUSTCERTIFIED1']")
    public static WebElement victory_certified_chkbox;
    
    @FindBy(xpath="//input[@id='checkBoxAMTRUSTCERTIFIED1' and @type='checkbox']")
    public static WebElement verify_victory_certified_chkbox;
    
    @FindBy(xpath="//img[@id='imgCreateSubmission']")
    public static WebElement create_submission_button;
    
    @FindBy(xpath="//button[@id='btnPrint']")
    public static WebElement print_button;
    
    @FindBy(xpath="//button[@id='btnClear']")
    public static WebElement clear_form_button;
    
  //....................>>Review Submission Page Locators<<.............................//
    
    @FindBy(xpath="//span[@id='totalPayrollPercentage']")
    public static WebElement reviewSubmission_totalPercentage;

    
  //....................>>Victory Non Admitted Plus Locators<<.............................//
    
    @FindBy(xpath="//img[@onclick='HideQESNews();']")
    public static WebElement qes_okay_btn;
    
    @FindBy(xpath="//img[@alt='Create Submission']")
    public static WebElement create_qes_submission;    
  //....................>>Hiscox Now Small Business Locators<<.............................//

    @FindBy(xpath="//img[@alt='Hiscox NOW']")
    public static WebElement hiscox_now_link;
    
    @FindBy(xpath="//input[@name='agentName' and @placeholder='First and Last Name']")
    public static WebElement first_last_name;
    
    @FindBy(xpath="//input[@name='agencyName' and @placeholder='Agency Name']")
    public static WebElement agency_name;
    
    @FindBy(xpath="//input[@name='agentId' and @placeholder='Agent ID']")
    public static WebElement agent_id;
    
    @FindBy(xpath="//input[@name='agentEmail' and @placeholder='Email Address']")
    public static WebElement agent_email_address;
    
    @FindBy(xpath="//input[@name='businessName' and @placeholder='Your Client’s Business Name']")
    public static WebElement client_business_name;
    
    @FindBy(xpath="//span[@id='select2-state-yk-container' and @class='select2-selection__rendered']")
    public static WebElement state_dropdown;
    
    @FindBy(xpath="//span[@id='select2-cob-aa-container' and @class='select2-selection__rendered']")
    public static WebElement profession_dropdown;
    
    @FindBy(xpath="//a[@class='button button--primary button--large quote-box__button--get-quote']")
    public static WebElement get_a_quote_btn;
}

