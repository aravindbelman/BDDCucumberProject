package com.LegacyApplication.PageLocators;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.LegacyApplication.TestBase.TestBase;

public class GeneralLiabilityPageLocators extends TestBase {
	
    public static WebDriver driver;
	
    public static final Logger log=Logger.getLogger(GeneralLiabilityPageLocators.class.getName());
    
  //....................>>General Liability Locators<<.............................//
   
  //....................>>Victory General Liability Locators<<.............................//
    
    @FindBy(xpath="//img[@alt='Victory General Liability']")
    public static WebElement victory_general_liability;
    
    @FindBy(xpath="//select[@id='selectState']")
    public static WebElement state_info;
    
    @FindBy(xpath="//input[@id='textZip']")
    public static WebElement zip_code;
    
    @FindBy(xpath="//select[@id='selectSubmissionType']")
    public static WebElement submission_type;
    
    @FindBy(xpath="//input[@id='textApplicantName']")
    public static WebElement applicant_name;
    
    @FindBy(xpath="//input[@id='textDBA']")
    public static WebElement dba;
    
    @FindBy(xpath="//input[@id='EffectiveDate']")
    public static WebElement proposed_effective_date;
    
    @FindBy(xpath="//button[@id='btnPrint']")
    public static WebElement print_button;
    
    @FindBy(xpath="//button[@id='btnClear']")
    public static WebElement clear_form_button;
    
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

