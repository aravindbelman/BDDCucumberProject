package com.LegacyApplication.PageLocators;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AgencyMainMenuLocators {
	public static WebDriver driver;
	
    public static final Logger log=Logger.getLogger(AgencyMainMenuLocators.class.getName());
    
     //....................>>Main Menu Option/Tabs Locators<<.............................//
    
    @FindBy(xpath="//a[contains(text(),'Products')]")
  	public static WebElement products_tab;
    
    @FindBy(xpath="//a[contains(text(),'Producer Tools')]")
	public static WebElement producertool_tab;
    
    @FindBy(xpath="//a[contains(text(),'Company')]")
  	public static WebElement company_tab;
    
    @FindBy(xpath="//a[contains(text(),'FAQ')]")
	public static WebElement faq_tab;
    
    @FindBy(xpath="//header//a[contains(text(),'Register Now')]")
  	public static WebElement register_producer_tab;
    
    @FindBy(xpath="//button[@id='btisRewardsButton']")
	public static WebElement rewardpoint_btn;
    
  //....................>>Products subMenus Locators<<.............................//
  //....................>>Producer tool subMenus Locators<<.............................//
    //---Accounting---//
    @FindBy(xpath="//a[contains(text(),'Producer Tools')]/following::a[contains(text(),'Accounting')]")
  	public static WebElement account_heading_menu;
    
    //ul[@class='sub-menu']/following::ul/li/a[contains(text(),'Make a Payment')]
    //a[contains(text(),'Producer Tools')]/following::a[contains(text(),'Accounting')]/following::ul/li/a[contains(text(),'Make a Payment')]
    
    @FindBy(xpath="//ul[@class='sub-menu']/following::ul/li/a[contains(text(),'Make a Payment')]")
   	public static WebElement makeapay_link;
    
    @FindBy(xpath="//ul[@class='sub-menu']/following::ul/li/a[contains(text(),'ECheck/Credit Card Payment Authorization')]")
   	public static WebElement echeck_link;
    
    @FindBy(xpath="//ul[@class='sub-menu']/following::ul/li/a[contains(text(),'Direct Bill Information')]")
   	public static WebElement directbillinfo_link;
    
    @FindBy(xpath="//ul[@class='sub-menu']/following::ul/li/a[contains(text(),'Premium Finance')]")
   	public static WebElement premiumfinance_link;
    
    
    //---Marketing---//
    @FindBy(xpath="//a[contains(text(),'Producer Tools')]/following::a[contains(text(),'Marketing')][1]")
  	public static WebElement Marketing_heading_menu;
    
    @FindBy(xpath="//ul[@class='sub-menu']/following::ul/li/a[contains(text(),'BTIS Rewards')]")
   	public static WebElement btisreward_link;
    
    @FindBy(xpath="//ul[@class='sub-menu']/following::ul/li/a[contains(text(),'Marketing Materials Archive')]")
   	public static WebElement marketingmaterial_link;
    
    //---Underwriting---//
    @FindBy(xpath="//a[contains(text(),'Producer Tools')]/following::a[contains(text(),'Underwriting Services')]")
  	public static WebElement Underwriting_heading_menu;
    
    @FindBy(xpath="//ul[@class='sub-menu']/following::ul/li/a[contains(text(),'Additional Insured Request')]")
   	public static WebElement additional_insured_link;
    
    
    @FindBy(xpath="//ul[@class='sub-menu']/following::ul/li/a[contains(text(),'Loss Run Request')]")
   	public static WebElement lossrun_link;
    
    
    //---Claims information---//
    @FindBy(xpath="//a[contains(text(),'Producer Tools')]/following::a[contains(text(),'Claims Information')]")
  	public static WebElement Claimsinfo_heading_menu;
    
    @FindBy(xpath="//ul[@class='sub-menu']/following::ul/li/a[contains(text(),'How to Report a Claim')]")
   	public static WebElement howtoreportclaim_link;
    
    //---Forms & Applications---//
    @FindBy(xpath="//a[contains(text(),'Producer Tools')]/following::a[contains(text(),'Forms & Applications')]")
  	public static WebElement forms_app_heading_menu;
    
    @FindBy(xpath="//ul[@class='sub-menu']/following::ul/li/a[contains(text(),'General Liability')]")
   	public static WebElement gl_link;
    
    @FindBy(xpath="//a[@href='https://mytest.btisinc.com/Producer-Tools/Forms-Applications/Auto']")
   	public static WebElement auto_link;
    
    //----Inside_form & application _Auto_---// 
    @FindBy(xpath="//a[contains(text(),'   Commerce West Auto Forms List')]")
    public static WebElement commercewest_link;
    
    //----------------------
           
    @FindBy(xpath="//ul[@class='sub-menu']/following::ul/li/a[contains(text(),'Bonds')]")
   	public static WebElement bonds_link;
        
    @FindBy(xpath="//ul[@class='sub-menu']/following::ul/li/a[contains(text(),'BOP/Package')]")
   	public static WebElement bop_link;
    
    @FindBy(xpath="//ul[@class='sub-menu']/following::ul/li/a[contains(text(),'Builders Risk')]")
   	public static WebElement buildersrisk_link;
    
    @FindBy(xpath="//ul[@class='sub-menu']/following::ul/li/a[contains(text(),'Excess')]")
   	public static WebElement excess_link;
    
    @FindBy(xpath="//a[@href='https://mytest.btisinc.com/Producer-Tools/Forms-Applications/Inland-Marine']")
   	public static WebElement inlandmarine_link;
    
    //----Inside form & application _InlandMarine_---// 
    
    @FindBy(xpath="//a[contains(text(),'Great American Schedule of Equipment')]")
    public static WebElement greatamerican_schedule_link;
    
    @FindBy(xpath="//a[contains(text(),'   IM Loss Warranty Letter')]")
    public static WebElement imwarrenty_letter_link;
        
    @FindBy(xpath="//div[@id='la-110534-inland-marine-forms-and-applications']/descendant::a[3]")
    public static WebElement victory_im_list_link;
  
    //----------------
    
    @FindBy(xpath="//ul[@class='sub-menu']/following::ul/li/a[contains(text(),'Workers Compensation')]")
   	public static WebElement workerscomp_link;
    
    @FindBy(xpath="//ul[@class='sub-menu']/following::ul/li/a[contains(text(),'Acord® Forms')]")
   	public static WebElement acordforms_link;
    
    
    //---Training---//
    @FindBy(xpath="//a[contains(text(),'Producer Tools')]/following::a[contains(text(),'Training')]")
  	public static WebElement training_heading_menu;
    
    @FindBy(xpath="//ul[@class='sub-menu']/following::ul/li/a[contains(text(),'Register for a Webinar')]")
   	public static WebElement registerforwebinar_link;
    
    @FindBy(xpath="//ul[@class='sub-menu']/following::ul/li/a[contains(text(),'Instructional Guides')]")
   	public static WebElement instructionalguides_link;
    
    @FindBy(xpath="//ul[@class='sub-menu']/following::ul/li/a[contains(text(),'Instructional Videos')]")
   	public static WebElement instructionalvideos_link;
 
        
    //---------------Sub Menu option -Underwriting services/Loss Run Request form Locators--//
   
   
    @FindBy(xpath="//h4[contains(text(),'Policy Information')]")
   	public static WebElement policyInfo_heading ;
    
    @FindBy(xpath="//input[@id='Policy_Number']")
   	public static WebElement policyno_txtb ;
    
    @FindBy(xpath="//input[@id='Applicant_Name']")
   	public static WebElement applicantname_txtb;
    
    @FindBy(xpath="//input[@id='DBA']")
   	public static WebElement dba_txtb;
    
    @FindBy(xpath="//input[@id='Loss_Run_Years_Needed']")
   	public static WebElement lossrunyr_txtb;
    
    @FindBy(xpath="//button[@id='btnSubmit']")
   	public static WebElement submit_btn;
    
    @FindBy(xpath="//p[contains(text(),'Thank you for contacting us')]")
   	public static WebElement success_text;
    
    
  //....................>>Company subMenus Locators<<.............................//
  //....................>>FAQ subMenus Locators<<.............................//
  //....................>>Register As A Producer -form- Locators<<.............................//
  //....................>>RewardsButton -form- Locators<<.............................//
    
  //Producer tools - Underwriter service- AI Request - Locators
  //AI search Criteria Page Locators.
    
   @FindBy(xpath="//select[@id='ddlSearchCriteria']")
   public static WebElement select_activesoldPolicy_drpdwn;
   
   @FindBy(xpath="//input[@id='searchText']")
   public static WebElement serchtext_txtb;
   
   @FindBy(xpath="//button[@id='btnGo']")
   public static WebElement searchgo_btn;
   
   //search result 
   @FindBy(xpath="//div[@id='dnn_ctr1346_ModuleContent']/child::div[2]/child::table[1]/child::tbody[1]/child::tr[1]/child::td[5]")
   public static WebElement serachresult_table_soldstatus;
   
   @FindBy(xpath="//a[contains(text(),'Print Blanket AI')]")
   public static WebElement printblanket_context_option;
   
   @FindBy(xpath="//a[contains(text(),'Request Scheduled AI Form')]")
   public static WebElement requestscheduled_context_option;
   
   @FindBy(xpath="//a[contains(text(),'View Current AI')]")
   public static WebElement viewcurrentai_context_option;
   
   //AI request Form -page Locators
   
   @FindBy(xpath="//a[contains(text(),'Your Contact Information')]")
   public static WebElement contact_info_displaylink;
   
   @FindBy(xpath="//a[contains(text(),'Insured Information')]")
   public static WebElement insured_info_displaylink;
   
   @FindBy(xpath="//select[@id='AIType'][@name='AIType']")
   public static WebElement whois_additional_insured_drpdwn;
   
   //If we choose Equipment rental/Lease company Option for AI then page Locators
   
   @FindBy(xpath="//input[@id='CG2028-CGName']")
   public static WebElement lessorname_textb;
   
   @FindBy(xpath="//textarea[@id='CG2028-ANIs']")
   public static WebElement additional_insued_names_txtb;
   
   @FindBy(xpath="//input[@id='CG2028-CGStreet1']")
   public static WebElement lessor_add_street_txtb;
   
   @FindBy(xpath="//input[@id='CG2028-CGCity1']")
   public static WebElement lessor_add_city_txtb;
   
   @FindBy(xpath="//select[@id='CG2028-CGState1']")
   public static WebElement lessor_add_state_drpdwn;
   
   @FindBy(xpath="//input[@id='CG2028-CGZipCode1']")
   public static WebElement lessor_add_zipcode_txtb;
   
   @FindBy(xpath="//textarea[@id='CG2028-Instructions']")
   public static WebElement specialInstuctions_txtb;
   
   @FindBy(xpath="//button[@id='btnSubmit']")
   public static WebElement airequest_submit_btn;
   
   @FindBy(xpath="//button[@id='btnSave']")
   public static WebElement save_finish_btn;
   
   @FindBy(xpath="//button[@id='btnClear']")
   public static WebElement clearform_btn;
   
   @FindBy(xpath="//button[@id='btnCancel']")
   public static WebElement cancel_btn;
   
   @FindBy(xpath="//div[@class='alert alert-success']")
   public static WebElement success_alert_msg;
   
   //after that search for that Submission Grid - View current AI- Table appear
   //select Incomplete Status AI - Edit AI- 
  
   //ul[@id='contextMenu']/child::li[9]/a[contains(text(),'View Current')]
   @FindBy(xpath=" //table[@id='dataGrid']/child::tbody[1]/child::tr[1]/child::td[4]")
   public static WebElement incomplete_ststus_option;
   
   @FindBy(xpath="//a[contains(text(),'Edit AI')]")
   public static WebElement editai_context_option;
   
   @FindBy(xpath="//div[@class='alert alert-warning']/child::p[1]")
   public static WebElement warning_msg;
  
  
  
   @FindBy(xpath="//div[@id='divProducerRegistration']//label[contains(text(), 'Are you an agent with any of the following (select all that apply)')]//following::label[@class='checkbox-inline']")
   public static List<WebElement> affiliation_list;

}
