package com.LegacyApplication.PageMethods;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;

import com.LegacyApplication.ExcelReader.ExcelReader;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageLocators.GeneralLiabilityPageLocators;
import com.LegacyApplication.PageLocators.KraftLakeWholesalerLocators;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;

public class KraftLakeWholesalerMethods extends TestBase {
	
	public static final Logger log=Logger.getLogger(KraftLakeWholesalerMethods.class.getName());
	public static JavascriptExecutor js;
	
	public static void log_into_Karftlake() throws IOException
	{
		load_data();
		GenericMethods.enter_text(KraftLakeWholesalerLocators.kl_ownerscode_txtbox, OR.getProperty("Kraftlake_AgencyOwnerCode"), "Agency Owner Code");
		GenericMethods.click_Element_Using_JS(KraftLakeWholesalerLocators.kl_submit_btn);		
	}
	
	/*
	 * Purpose: This method is used to fill the comparative rater info for KraftLake wholesaler GL submission
	 * @param int row_number from excel
	 * @return NA
	 */
	public static void fill_kraftLake_GL_ratingInfo(int row_num) throws IOException, InterruptedException
	{	
		GenericMethods.click_Element_Using_JS(KraftLakeWholesalerLocators.kl_glsubmission_btn);
		ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QCR_Info");
		GenericMethods.select_from_dropdown(KraftLakeWholesalerLocators.kl_gl_submissiontype_drpdown, "visibletext", ExcelReader.get_row_data_from_col("Submission_Type", row_num));
		GenericMethods.enter_text(KraftLakeWholesalerLocators.kl_gl_applicantname_txtbox, ExcelReader.get_row_data_from_col("Applicant Name", row_num), "Applicant Name");
		GenericMethods.enter_text(KraftLakeWholesalerLocators.kl_gl_dbaname_txtbox, ExcelReader.get_row_data_from_col("DBA", row_num), "DBA Name");
		KraftLakeWholesalerLocators.kl_gl_proposeddate.clear();
		GenericMethods.enter_text(KraftLakeWholesalerLocators.kl_gl_proposeddate, GenericMethods.get_current_date(), "Proposed Effective Date");
		GenericMethods.select_from_dropdown(KraftLakeWholesalerLocators.kl_gl_state_drpdown, "visibletext", ExcelReader.get_row_data_from_col("State", row_num));
		GenericMethods.enter_text(KraftLakeWholesalerLocators.kl_gl_zip_txtbox, ExcelReader.get_row_data_from_col("Zip Code", row_num), "Zip Code");
		GenericMethods.click_Element_Using_JS(KraftLakeWholesalerLocators.kl_gl_nolicenceNeeded_chkbx);
		WaitMethods.wait_in_seconds(3);
		GenericMethods.select_from_dropdown(KraftLakeWholesalerLocators.kl_gl_limitofinsurance_drpdown, "visibletext", ExcelReader.get_row_data_from_col("Limits", row_num));
		GenericMethods.select_from_dropdown(KraftLakeWholesalerLocators.kl_gl_deductible_drpdwn, "value", ExcelReader.get_row_data_from_col("Deductible", row_num));
		GenericMethods.enter_text(KraftLakeWholesalerLocators.kl_gl_owners_activefield_txtbx, ExcelReader.get_row_data_from_col("Owners Active In Field", row_num), "Owners Active In Field");
		GenericMethods.enter_text(KraftLakeWholesalerLocators.kl_gl_subcontractingcost_txtbox, ExcelReader.get_row_data_from_col("Subcontracting Costs", row_num), "Subcontracting Costs");
		GenericMethods.enter_text(KraftLakeWholesalerLocators.kl_gl_grossrecipt_txtbox, ExcelReader.get_row_data_from_col("Receipts", row_num), "Gross Receipts");
		GenericMethods.select_from_dropdown(KraftLakeWholesalerLocators.kl_gl_class1_drpdown, "visibletext", ExcelReader.get_row_data_from_col("KraftLake_Classification-1", row_num));
		GenericMethods.enter_text(KraftLakeWholesalerLocators.kl_gl_percent1_txtbox, ExcelReader.get_row_data_from_col("KraftLake_Classification-1_Percentage", row_num), "Classification 1 Percentage");
		GenericMethods.click_Element_Using_JS(KraftLakeWholesalerLocators.k_gl_addclass_btn);
		if(!ExcelReader.get_row_data_from_col("KraftLake_Classification-2", row_num).equalsIgnoreCase("No"))
		{
			GenericMethods.select_using_action(KraftLakeWholesalerLocators.kl_gl_class2_drpdown, "visibletext", ExcelReader.get_row_data_from_col("KraftLake_Classification-2", row_num));
			GenericMethods.enter_text(KraftLakeWholesalerLocators.kl_gl_percent2_txtbox, ExcelReader.get_row_data_from_col("KraftLake_Classification-2_Percentage", row_num), "Classification 2 Percentage");
		}
		WaitMethods.wait_in_seconds(3);
		if(!ExcelReader.get_row_data_from_col("KraftLake_Classification-3", row_num).equalsIgnoreCase("No"))
		{
			GenericMethods.select_using_action(KraftLakeWholesalerLocators.kl_gl_class3_drpdown, "visibletext", ExcelReader.get_row_data_from_col("KraftLake_Classification-3", row_num));
			GenericMethods.enter_text(KraftLakeWholesalerLocators.kl_gl_percent3_txtbox, ExcelReader.get_row_data_from_col("KraftLake_Classification-3_Percentage", row_num), "Classification 3 Percentage");
		}
		WaitMethods.wait_in_seconds(3);
		if(!ExcelReader.get_row_data_from_col("KraftLake_Classification-4", row_num).equalsIgnoreCase("No"))
		{
			GenericMethods.select_using_action(KraftLakeWholesalerLocators.kl_gl_class4_drpdown, "visibletext", ExcelReader.get_row_data_from_col("KraftLake_Classification-4", row_num));
			GenericMethods.enter_text(KraftLakeWholesalerLocators.kl_gl_percent4_txtbox, ExcelReader.get_row_data_from_col("KraftLake_Classification-4_Percentage", row_num), "Classification 4 Percentage");
		}
		
		GenericMethods.select_from_dropdown(KraftLakeWholesalerLocators.kl_gl_businessexp_drpdwn, "visibletext", ExcelReader.get_row_data_from_col("Business Experience", row_num));
		if(GenericMethods.is_element_displayed(KraftLakeWholesalerLocators.kl_gl_creditavailable_chkbox).equalsIgnoreCase("true")&& ExcelReader.get_row_data_from_col("New Residential Structure", row_num).equalsIgnoreCase("yes"))
		{
		GenericMethods.click_Element_Using_JS(KraftLakeWholesalerLocators.kl_gl_creditavailable_chkbox);
		}
		GenericMethods.click_Element_Using_JS(KraftLakeWholesalerLocators.kl_gl_availiablepolicycredit_chkbox);
		GenericMethods.click_Element_Using_JS(KraftLakeWholesalerLocators.kl_gl_declinedbyarmerschkbox_chkbox);
		GenericMethods.click_Element_Using_JS(KraftLakeWholesalerLocators.kl_gl_rateitnow_btn);
	}
	
	/*
	 * Purpose: This method is used to fill the Price Indicator and Eligibility Info for Kraftlake WholeSaler GL submission
	 * @param NA
	 * @return NA
	 */
	public static void fill_kraftLake_GL_PIandEligibility_Info()
	{
		GenericMethods.click_Element_Using_JS(KraftLakeWholesalerLocators.kl_gl_pi_next_btn);
		GenericMethods.click_Element_Using_JS(KraftLakeWholesalerLocators.kl_gl_eleigibility_chkbox);
		GenericMethods.click_Element_Using_JS(KraftLakeWholesalerLocators.kl_gl_pi_next_btn);
	}
	
	/*
	 * Purpose: This method is used to fill the Price Indicator and Eligibility Info for Kraftlake WholeSaler GL submission
	 * @param NA
	 * @return NA
	 */
	public static void fill_kraftLake_GL_application_Info(int row_num) throws IOException, InterruptedException
	{
		AutoRenewalBrokerFeeMethods.fill_application_info(row_num);
		
	}


}
