package com.LegacyApplication.PageLocators;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.LegacyApplication.TestBase.TestBase;

public class AdminSubmissionPageLocators extends TestBase {
	
	public static WebDriver driver;
    public static final Logger log=Logger.getLogger(AdminSubmissionPageLocators.class.getName());
    
    @FindBy(xpath="//input[@id='Search']")
    public static WebElement submission_id_searchfield;
    
    @FindBy(xpath="//button[@id='searchBtn']")
    public static WebElement search_button;
    
    @FindBy(xpath="//table[@id='searchTable']/tbody/tr[@data-index='0']/td")
    public static WebElement submission_table_row;
    
    @FindBy(xpath="//table[@id='searchTable']//td[contains(text(),'Incomplete')]")
    public static WebElement submitted_status;
    
    @FindBy(xpath="//table[@id='searchTable']//td[contains(text(),'Sold')]")
    public static WebElement sold_status;
    
    @FindBy(xpath="//ul[@id='contextMenu']/li/a[contains(text(),'Rating W/S')]")
    public static WebElement rating_ws_link;
    
    @FindBy(xpath="//ul[@id='contextMenu']/li/a[contains(text(),'Renewal')]")
    public static WebElement renewal_link;
    
    @FindBy(xpath="//ul[@id='contextMenu']/li//a[text()='Review Submission']")
    public static WebElement reviewSubmission_link;
        
    @FindBy(xpath="//header[@id='condensedHeader']//a[@class='logoutButton']")
    public static WebElement logoutOfAgency;
    
    @FindBy(xpath="//ul[@id='contextMenu']//a[contains(text(),'Quote CBIC')]")
    public static WebElement quote_CBIC_link;
    
    @FindBy(xpath="//table[@id='searchTable']/tbody/tr[@data-index='0']//td[contains(text(),'Paid')]")
    public static WebElement Paid_status;
    
    @FindBy(xpath="//table[@id='searchTable']/tbody/tr[@data-index='0']//td[5]")
    public static WebElement submissionID;
    
    //==================Review Submission Locators=================================//
    
    @FindBy(xpath="//span[@id='Price_Indicator_Screen1_lblFO_TotalGLPremWithoutSunset']")
    public static WebElement premiumValue;
    
    //======================Quote CBIC ==========================//
    
    @FindBy(xpath="//div[@id='ModalDialog']//strong[contains(text(),'Reference Number:')]/following::label[1]")
    public static WebElement quote_CBIC_ReferenceNo;
   
    @FindBy(xpath="//div[@id='ModalDialog']//strong[contains(text(),'Amtrust Premium:')]/following::label[1]")
    public static WebElement quote_CBIC_AmTrust_Value;
    
    @FindBy(xpath="//div[@id='ModalDialog']//strong[contains(text(),'CBIC Premium:')]/following::label[1]")
    public static WebElement quote_CBIC_Quote_Value;
    
  //===================> QAA Rating Worksheet Locators<========================
    
    @FindBy(xpath="//span[@id='lblSubmissionId']")
    public static WebElement verify_submission_id;
    
    @FindBy(xpath="//input[@id='cbFullWithoutSunset']")
    public static WebElement cbFullWithoutSunset_chkbx;
    
    @FindBy(xpath="//input[@id='cbFullWithSunset']")
    public static WebElement cbFullWithSunset_chkbx;
    
    @FindBy(xpath="//span[@id='lblFULLWITHOUTSUNSETTotalGLPremium']")
    public static WebElement lbl_withoutsunset_totalgl;
    
    @FindBy(xpath="//span[@id='lblFULLWITHOUTSUNSETEmpBen']")
    public static WebElement lbl_withoutsunset_empbenefits;
    
    @FindBy(xpath="//span[@id='lblFULLWITHOUTSUNSETPerProjAgg']")
    public static WebElement lbl_withoutsunset_perprojagg;
    
    @FindBy(xpath="//span[@id='lblFULLWITHOUTSUNSETRemoveSubsidence']")
    public static WebElement lbl_withoutsunset_earthmovexclusion;
    
    @FindBy(xpath="//span[@id='lblFULLWITHOUTSUNSETStopGap']")
    public static WebElement lbl_withoutsunset_stopgap;
    
    @FindBy(xpath="//span[@id='lblFULLWITHOUTSUNSETAdditionalInsured']")
    public static WebElement lbl_withoutsunset_additionalinsured;
    
    @FindBy(xpath="//span[@id='lblEandO5']")
    public static WebElement lbl_withoutsunset_workmanship;
    
    @FindBy(xpath="//span[@id='lblExtEandO5']")
    public static WebElement lbl_withoutsunset_extendedreporting;
    
    @FindBy(xpath="//span[@id='lblFULLWITHOUTSUNSETSubTotalGLPrem']")
    public static WebElement lbl_withoutsunset_total_all_glprem;
    
    @FindBy(xpath="//span[@id='lblFULLWITHOUTSUNSETIMPrem']")
    public static WebElement lbl_inland_marine;
    
    @FindBy(xpath="//span[@id='lblFULLWITHOUTSUNSETTerrorism']")
    public static WebElement lbl_withoutsunset_terrorismprem;
    
    @FindBy(xpath="//span[@id='lblFULLWITHOUTSUNSETPolicyFee']")
    public static WebElement lbl_withoutsunset_glpolicyfee;
    
    @FindBy(xpath="//span[@id='lblFULLWITHOutSUNSETTotalGLPolPremium']")
    public static WebElement lbl_withoutsunset_totalglpolpremium;
    
    @FindBy(xpath="//span[@id='lblFULLWITHOUTSUNSETGrandTotal']")
    public static WebElement lbl_withoutsunset_grandtotal;
    
    @FindBy(xpath="//input[@id='butSave']")
    public static WebElement save_ratingws;
    
    @FindBy(xpath="//input[@id='rptrForms__ctl1_includeForm' and @type='checkbox']")
    public static WebElement qes_resConstruction_chkbx;
    
    @FindBy(xpath="//input[@id='btnSaveForms']")
    public static WebElement save_qes_ratingws;

}
