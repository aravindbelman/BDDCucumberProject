package com.LegacyApplication.PageLocators;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.LegacyApplication.TestBase.TestBase;

public class BuildersRiskLocators extends TestBase{
	
	public static WebDriver driver;
    public static final Logger log=Logger.getLogger(BuildersRiskLocators.class.getName());
    
  //....................>Builders Risk Locators<<.............................//
    
    @FindBy(xpath="//a[@class='btn btn-default btn-primary' and normalize-space(text()=' Builders Risk')]")
    public static WebElement buildersrisk_tab;
    
    @FindBy(xpath="//img[@alt='One Shot Builders Risk']")
    public static WebElement brp_residentialandcommerciallink; 
    
  //....................>>Builders Risk application, project information and optional coverages Locators<<.............................//

    @FindBy(xpath="//input[@id='Rating_Screen1_ApplicantName']")
    public static WebElement brp_applicantname;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_Dba']")
    public static WebElement brp_dba;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_NamedInsuredContractor']")
    public static WebElement brp_insuredcontractor_yes;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_rbNamedInsuredContractorNo']")
    public static WebElement brp_insuredcontractor_no;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_EffectiveDate']")
    public static WebElement brp_propeffective_date;
    
    @FindBy(xpath="//select[@id='Rating_Screen1_LengthOfProjectId']")
    public static WebElement brp_lengthofproject;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_EstimatedCompletionDate']")
    public static WebElement brp_estimated_completiondate;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_LocationAddress']")
    public static WebElement brp_street_address;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_LocationCity']")
    public static WebElement brp_city;
    
    @FindBy(xpath="//select[@id='Rating_Screen1_LocationStateId']")
    public static WebElement brp_state_drpdwn;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_LocationZipCode']")
    public static WebElement brp_zipcode;
    
    @FindBy(xpath="//select[@id='Rating_Screen1_ProtectionClassId']")
    public static WebElement brp_protection_class;
    
    @FindBy(xpath="//select[@id='Rating_Screen1_StructureTypeId']")
    public static WebElement brp_structure_type;
    
    @FindBy(xpath="//select[@id='Rating_Screen1_ProjectTypeId']")
    public static WebElement brp_project_type;
    
    @FindBy(xpath="//select[@id='Rating_Screen1_ConstructionTypeId']")
    public static WebElement brp_construction_type;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_MobileManufacturedHome']")
    public static WebElement brp_mobileormanufacturedhome_yes;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_rbMobileManufacturedHomeNo']")
    public static WebElement brp_mobileormanufacturedhome_no;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_PremisesLiabilityIncluded']")
    public static WebElement brp_premisesliability_incuded;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_rbPremisesLiabilityNotIncluded']")
    public static WebElement brp_premisesliability_notincuded;
    
    @FindBy(xpath="//input[@id='Rating_Screen1_btnRateIT']")
    public static WebElement brp_rateitnow_btn;
}
