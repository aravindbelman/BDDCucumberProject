package com.LegacyApplication.PageMethods;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;

import org.testng.Assert;

import com.LegacyApplication.ExcelReader.ExcelReader;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageLocators.AdminSubmissionPageLocators;
import com.LegacyApplication.PageLocators.BondsLocators;
import com.LegacyApplication.PageLocators.GeneralLiabilityPageLocators;
import com.LegacyApplication.PageLocators.InlandMarineLocators;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;



public class BondsMethods extends TestBase {
	
	public static final Logger log=Logger.getLogger(BondsMethods.class.getName());
	public static JavascriptExecutor js;
	
	/*
	 * Purpose: This method is used to click Victory Express Bonds link
	 * @param integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void click_victory_express_bonds()
	{
		WaitMethods.wait_for_element_present(BondsLocators.bonds_button);
		GenericMethods.click_Element_Using_JS(BondsLocators.bonds_button);
		WaitMethods.wait_for_element_present(BondsLocators.victory_xpress_bondlink);
		GenericMethods.click_Element_Using_JS(BondsLocators.victory_xpress_bondlink);
	}
	
	/*
	 * Purpose: This method is used to click Victory Contractor Bonds link
	 * @param integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void click_rapid_bonds()
	{
		//WaitMethods.wait_for_element_present(BondsLocators.bonds_button);
		GenericMethods.click_Element_Using_JS(BondsLocators.bonds_button);
		GenericMethods.click_Element_Using_JS(BondsLocators.victory_xpress_bondlink);
	}
	
	/*
	 * Purpose: This method is used to click Victory Contractor Bonds link
	 * @param integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void click_victory_contractor_bonds()
	{
		//WaitMethods.wait_for_element_present(BondsLocators.bonds_button);
		GenericMethods.click_Element_Using_JS(BondsLocators.bonds_button);
		GenericMethods.click_Element_Using_JS(BondsLocators.vcb_link);
	}
	
	/*
	 * Purpose: This method is used to click Victory Contractor Bonds link
	 * @param integer (Row_number of Excel sheet)
	 * @return NA
	 */

	public static void fill_VCB_rating_info(int row_num,String state) throws IOException, InterruptedException, AWTException,Throwable
	{
		ExcelReader.set_excel_file(Locations.regression_dataFilePath, "Bonds_Rating_Info");	
		if(state.equalsIgnoreCase("OR"))
		{
		GenericMethods.select_using_action(BondsLocators.vcb_state_drpdwn, "visibletext", ExcelReader.get_row_data_from_col("State", row_num));
		GenericMethods.click_Element_Using_JS(BondsLocators.vcb_applicantLicenceNo_rbtn);
		GenericMethods.click_Element_Using_JS(BondsLocators.vcb_residentialConstructionLicense_chkbx);
		GenericMethods.select_using_action(BondsLocators.vcb_residentialConstruction_drpdwn, "visibletext", ExcelReader.get_row_data_from_col("Type_of_Residential_Construction", row_num));
		/*GenericMethods.click_Element_Using_JS(BondsLocators.vcb_commercialConstructionLicense_chkbx);
		GenericMethods.select_using_action(BondsLocators.vcb_commercialConstruction_drpdwn, "value", ExcelReader.get_row_data_from_col("Type_of_Commercial_Construction", row_num));
		GenericMethods.click_Element_Using_JS(BondsLocators.vcb_publicWorksLicense_chkbx);
		GenericMethods.select_using_action(BondsLocators.vcb_publicWorks_drpdwn, "visibletext", ExcelReader.get_row_data_from_col("Public_Works", row_num));*/
		BondsLocators.vcb_effective_date.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0, 1, 0, 0, 0));
		GenericMethods.press_key_using_robot("tab");
		}
		else if(state.equalsIgnoreCase("CA"))
		{	
			GenericMethods.select_from_dropdown(BondsLocators.vcb_state_drpdwn,"visibletext", "CA");
			GenericMethods.enter_text(BondsLocators.BondInfo_LicenseNumber,"651371", "License Number");
			WaitMethods.wait_in_seconds(20);
			BondsLocators.vcb_effective_date.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0, 1, 0, 0, 0));
			GenericMethods.press_key_using_robot("tab");
		}
		else if(state.equalsIgnoreCase("WA"))
		{
			GenericMethods.select_from_dropdown(BondsLocators.vcb_state_drpdwn, "visibletext","WA");
			GenericMethods.click_Element_Using_JS(BondsLocators.vcb_applicantLicenceNo_rbtn);
			GenericMethods.select_from_dropdown(BondsLocators.vcb_residentialConstruction_drpdwn, "value", "30");
			BondsLocators.vcb_effective_date.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0, 1, 0, 0, 0));
			GenericMethods.press_key_using_robot("tab");
		}
		                          //....................>>        Fill Company Information    <<.............................//
		
		GenericMethods.enter_text(BondsLocators.vcb_company_name, ExcelReader.get_row_data_from_col("Company_Name", row_num), "Company_Name");
		GenericMethods.select_using_action(BondsLocators.vcb_company_type, "visibletext", ExcelReader.get_row_data_from_col("Company_Type", row_num));
		//GenericMethods.enter_text(BondsLocators.vcb_dba, ExcelReader.get_row_data_from_col("DBA", row_num), "DBA");
		GenericMethods.enter_text(BondsLocators.vcb_business_address, ExcelReader.get_row_data_from_col("Company_Address", row_num), "Company_Address");
		GenericMethods.enter_text(BondsLocators.vcb_busienss_city, ExcelReader.get_row_data_from_col("Company_City", row_num), "City");
		GenericMethods.select_using_action(BondsLocators.vcb_company_state_drpdwn, "visibletext", ExcelReader.get_row_data_from_col("Company_State", row_num));
		GenericMethods.enter_text(BondsLocators.vcb_zipcode, ExcelReader.get_row_data_from_col("Company_Zip_Code", row_num), "Zip Code");
		GenericMethods.enter_text(BondsLocators.vcb_business_phone, ExcelReader.get_row_data_from_col("Phone", row_num), "Phone Number");
		GenericMethods.enter_text(BondsLocators.vcb_business_fax, ExcelReader.get_row_data_from_col("Fax", row_num), "Fax Number");
		GenericMethods.enter_text(BondsLocators.vcb_email, ExcelReader.get_row_data_from_col("Email", row_num), "Email");
		
		                           //....................>>         Fill personal Information  <<.............................//
		
		GenericMethods.enter_text(BondsLocators.vcb_pi_firstname, ExcelReader.get_row_data_from_col("First_Name", row_num), "First Name");
		GenericMethods.enter_text(BondsLocators.vcb_pi_lastname, ExcelReader.get_row_data_from_col("Last_Name", row_num), "Last Name");
		GenericMethods.select_using_action(BondsLocators.vcb_suffix_drpdwn, "visibletext", ExcelReader.get_row_data_from_col("Suffix", row_num));
		GenericMethods.select_using_action(BondsLocators.vcb_suffix_drpdwn, "visibletext", ExcelReader.get_row_data_from_col("Suffix", row_num));
		GenericMethods.click_Element_Using_JS(BondsLocators.vcb_sameaddress_chkbx);
		GenericMethods.enter_text(BondsLocators.vcb_si_ssnnumber, ExcelReader.get_row_data_from_col("SSN", row_num), "SSN");
		GenericMethods.enter_text(BondsLocators.vcb_si_confirmssn, ExcelReader.get_row_data_from_col("SSN", row_num), "SSN");	
		GenericMethods.click_Element_Using_JS(BondsLocators.vcb_creditcheck_chkbox);
		GenericMethods.click_Element_Using_JS(BondsLocators.vcb_rateitnow_btn);
	}
	/*
	 * Purpose: This method just Temporary solution to create Bonds 
	 * It handle Server error pop up  & Refresh page
	 * Optional method Once it is get Stable Remove that Method
	 * @return NA
	 */
	public static void handle_Alert_and_refreshpage() throws Throwable
	{
		GenericMethods.accept_alert();
		GenericMethods.navigate_browser("refresh");WaitMethods.wait_in_seconds(2);
		GenericMethods.press_key_using_robot("enter");WaitMethods.wait_in_seconds(2);
		GenericMethods.click_Element_Using_JS(BondsLocators.vcb_rateitnow_btn);
	}
   
	/*
	 * Purpose: This method select Carrier Program
	 * & create Submission
	 * @return NA
	 */
	public static void comparatriverater_page_createsubmission()
	{
		//GenericMethods.click_Element_Using_JS(BondsLocators.compricing_amtrust_chkbx);
		GenericMethods.click_Element_Using_JS(BondsLocators.compricing_acna_chkbx);
		GenericMethods.click_Element_Using_JS(BondsLocators.compricing_acreatesubmission_btn);
	}

	/*
	 * Purpose: This method is used to verify Email Address after clicking Victory Express Bonds
	 * @param integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void verify_victoryez_email_address() throws IOException, InterruptedException
	{
		GenericMethods.navigate_to_next_window();
		GenericMethods.validate_text_in_pdf("E-Mail Address");
	}
	
	/*
	 * Purpose: This method is used to validate the Rapid bonds Verbiage
	 * @param integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void verify_rapid_bonds_verbiage() throws IOException, InterruptedException
	{
		GenericMethods.navigate_to_next_window();
		GenericMethods.validate_text_in_pdf("Rapid Bonds");
	}
	
	/*
	 * Purpose: This method is for Price Indicator page
	 * @return NA
	 */
	public static void priceIndicator() throws IOException, InterruptedException
	{
		GenericMethods.click_Element_Using_JS(BondsLocators.year1_radio_btn);
		GenericMethods.click_Element_Using_JS(BondsLocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		GenericMethods.click_Element_Using_JS(BondsLocators.next_btn);
	}
	
	public static void confirmMailg() throws IOException, InterruptedException
	{
		GenericMethods.click_Element_Using_JS(BondsLocators.next_btn);
		WaitMethods.wait_in_seconds(2);
	}
	
	/*
	 * Purpose: This method is for Price Indicator page
	 * @return NA
	 */
	public static void finalReview() throws IOException, InterruptedException
	{	
		GenericMethods.scroll_down_to_element(BondsLocators.bondIssue_btn);
		GenericMethods.click_Element_Using_JS(BondsLocators.bondIssue_btn);
		WaitMethods.wait_in_seconds(2);
	}
	
	/*
	 * Purpose: This method is for Bond Issuance checklist page
	 * @return NA
	 */
	public static void bondIssuance() throws IOException, InterruptedException
	{
		GenericMethods.click_Element_Using_JS(BondsLocators.chkReadyToIssue);
		WaitMethods.wait_in_seconds(2);
		GenericMethods.click_Element_Using_JS(BondsLocators.PaymentType_Agency);
		GenericMethods.click_Element_Using_JS(BondsLocators.imgIssueConfirm);
		WaitMethods.wait_in_seconds(2);
	}
	public static void getQuoteid()throws IOException, InterruptedException
	{
		String quote=BondsLocators.qbws_submssion_id.getText().trim();
		log.info(quote);
	}
	/*
	 * Purpose: This method is for Agent acknowledgement page
	 * @return NA
	 */
	public static void agentAcknowledgement() throws IOException, InterruptedException
	{	
		
		GenericMethods.click_Element_Using_JS(BondsLocators.imgIssueConfirmAck);
		WaitMethods.wait_in_seconds(2);
		getQuoteid();
		GenericMethods.click_Element_Using_JS(BondsLocators.imgGoHome);WaitMethods.wait_in_seconds(5000);
	}
	
	
}
