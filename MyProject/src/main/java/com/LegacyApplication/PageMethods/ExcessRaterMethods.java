package com.LegacyApplication.PageMethods;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import com.LegacyApplication.ExcelReader.ExcelReader;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageLocators.CommercialAutoLocators;
import com.LegacyApplication.PageLocators.ExcessProgramRaterLocators;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;

import net.bytebuddy.description.type.TypeDescription.Generic;

public class ExcessRaterMethods {
	
	public static final Logger log=Logger.getLogger(ExcessRaterMethods.class.getName());
	public static JavascriptExecutor js;
	

	/*
	 * Purpose: This method is used to click Excess Rater link
	 * @param integer (Row_number of Excel sheet)                                                                                                                                                    
	 * @return NA
	 */
		
	public static void click_Excess()
	{	
		WaitMethods.wait_for_element_present(ExcessProgramRaterLocators.ex_tab);
		GenericMethods.click_Element_Using_JS(ExcessProgramRaterLocators.ex_tab);
		WaitMethods.wait_for_element_present(ExcessProgramRaterLocators.ex_link);
		GenericMethods.click_Element_Using_JS(ExcessProgramRaterLocators.ex_link);
	}
	
	/*
	 * Purpose: This method is used fill Excess Rater Rating Info
	 * @param integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void fill_QEXR_rating_info(int row_num) throws IOException, InterruptedException
	{
		ExcelReader.set_excel_file(Locations.tls_dataFilePath,"QEXR_RatingInfo");
		WaitMethods.wait_for_element_present(ExcessProgramRaterLocators.ex_application_quote_no);
		String ex_submission_id=GenericMethods.retrive_substring(":", ExcessProgramRaterLocators.ex_application_quote_no.getText());		
		ExcelReader.set_cell_data("ex_submission_id",row_num,ex_submission_id);
		
		GenericMethods.select_from_dropdown(ExcessProgramRaterLocators.ex_submissiontype_drpdwn,"visibletext",ExcelReader.get_row_data_from_col("SubmissionType", row_num));
		GenericMethods.enter_text(ExcessProgramRaterLocators.ex_applicantname_txtb,ExcelReader.get_row_data_from_col("ApplicantName", row_num), "Applicant Name");
		GenericMethods.enter_text(ExcessProgramRaterLocators.ex_dbaname_txtb,ExcelReader.get_row_data_from_col("DBA_Name", row_num), "DBA");
		ExcessProgramRaterLocators.ex_effectivedate.clear();
		ExcessProgramRaterLocators.ex_effectivedate.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0, 1, 0, 0, 0));
		GenericMethods.select_from_dropdown(ExcessProgramRaterLocators.ex_state_drpdwn,"visibletext",ExcelReader.get_row_data_from_col("State", row_num));
		GenericMethods.enter_text(ExcessProgramRaterLocators.ex_zip_txtb,ExcelReader.get_row_data_from_col("ZipCode", row_num), "ZipCode");
		GenericMethods.select_from_dropdown(ExcessProgramRaterLocators.ex_classtype_drpdwn,"visibletext",ExcelReader.get_row_data_from_col("ClassType", row_num));
		GenericMethods.select_from_dropdown(ExcessProgramRaterLocators.ex_classifaction_drpdwn,"visibletext",ExcelReader.get_row_data_from_col("Classification", row_num));
		GenericMethods.select_from_dropdown(ExcessProgramRaterLocators.ex_coveragelimit_drpdwn,"index",ExcelReader.get_row_data_from_col("Excess_Coverage_Limit", row_num));
		GenericMethods.select_from_dropdown(ExcessProgramRaterLocators.ex_coverageover_drpdwn,"visibletext",ExcelReader.get_row_data_from_col("Excess_Coverage_Over", row_num));
		GenericMethods.select_from_dropdown(ExcessProgramRaterLocators.ex_underlying_glLimits_drpdwn,"index",ExcelReader.get_row_data_from_col("Underlying_GL_Limits", row_num));
		GenericMethods.enter_text(ExcessProgramRaterLocators.ex_underlying_glPremium_txtb,ExcelReader.get_row_data_from_col("Underlying_GL_Premium", row_num), "Underlying_GL_Premium");
		GenericMethods.click_element_JS(ExcessProgramRaterLocators.ex_rateitnow_btn);
		WaitMethods.wait_in_seconds(3);
	}
		//Price Indicator page 
		public static void price_Indicator() {
		WaitMethods.wait_for_element_present(ExcessProgramRaterLocators.ex_priceindNext_btn);
		GenericMethods.click_element_JS(ExcessProgramRaterLocators.ex_priceindNext_btn);
		}
		
		//Eligibility page
		/*
		 * Purpose: This method is used fill Excess Rater Eligibility Information
		 * @param integer (Row_number of Excel sheet)
		 * @return NA
		 * Question no. Question no. 1/2/3/8 -YES- value=1
		 */
	    
		
		public static void eligibilityQuestions() throws InterruptedException
		{
			WaitMethods.wait_for_element_present(ExcessProgramRaterLocators.ex_eq1yes_radio);
			GenericMethods.click_Element_Using_JS(ExcessProgramRaterLocators.ex_eq1yes_radio);
			GenericMethods.click_Element_Using_JS(ExcessProgramRaterLocators.ex_eq2yes_radio);
			GenericMethods.click_Element_Using_JS(ExcessProgramRaterLocators.ex_eq3yes_radio);
			GenericMethods.click_Element_Using_JS(ExcessProgramRaterLocators.ex_eq4no_radio);
			GenericMethods.click_Element_Using_JS(ExcessProgramRaterLocators.ex_eq5no_radio);
			GenericMethods.click_Element_Using_JS(ExcessProgramRaterLocators.ex_eq6no_radio);
			GenericMethods.click_Element_Using_JS(ExcessProgramRaterLocators.ex_eq7no_radio);
			GenericMethods.click_Element_Using_JS(ExcessProgramRaterLocators.ex_eq8yes_radio);
			GenericMethods.click_Element_Using_JS(ExcessProgramRaterLocators.ex_eq9no_radio);
			GenericMethods.click_Element_Using_JS(ExcessProgramRaterLocators.ex_eq10no_radio);
			GenericMethods.click_Element_Using_JS(ExcessProgramRaterLocators.ex_eq11no_radio);
			GenericMethods.click_Element_Using_JS(ExcessProgramRaterLocators.ex_eq12no_radio);
			GenericMethods.click_Element_Using_JS(ExcessProgramRaterLocators.ex_eq13no_radio);
			
			GenericMethods.click_Element_Using_JS(ExcessProgramRaterLocators.ex_eleigibilityNext_btn);
		
		}
		
		/*
		 * Purpose: This method is used fill Excess Rater application Information
		 * @param integer (Row_number of Excel sheet)
		 * @return NA
		 */
		
		public static void fill_excess_application_info(int row_num) throws InterruptedException, IOException
		{
			ExcelReader.set_excel_file(Locations.tls_dataFilePath,"QEXR_Application");
				
			GenericMethods.enter_text(ExcessProgramRaterLocators.ex_address_physical_txtb,ExcelReader.get_row_data_from_col("Address", row_num), "Address");
			GenericMethods.enter_text(ExcessProgramRaterLocators.ex_city_txtb,ExcelReader.get_row_data_from_col("City", row_num), "City");
			GenericMethods.click_element_JS(ExcessProgramRaterLocators.ex_sameasphysical_chkb);
			GenericMethods.select_from_dropdown(ExcessProgramRaterLocators.ex_typeofBusiness_drpdwn,"visibletext",ExcelReader.get_row_data_from_col("Type_of_Business", row_num));
			GenericMethods.select_from_dropdown(ExcessProgramRaterLocators.ex_yearinBusiness_drpdwn,"visibletext",ExcelReader.get_row_data_from_col("Years_in_Business", row_num));
			GenericMethods.enter_text(ExcessProgramRaterLocators.ex_noofEmployee_txtb,ExcelReader.get_row_data_from_col("Number_of_Employees", row_num), "Number_of_Employees");
			GenericMethods.enter_text(ExcessProgramRaterLocators.ex_subCont_cost_txtb,ExcelReader.get_row_data_from_col("Subcontracting_Costs", row_num), "Subcontracting_Costs");
			ExcessProgramRaterLocators.ex_subCont_cost_txtb.sendKeys(Keys.TAB);
			WaitMethods.wait_in_seconds(1);
			GenericMethods.enter_text(ExcessProgramRaterLocators.ex_type_of_subCont_work_txtb,ExcelReader.get_row_data_from_col("Type_of_Subcontracted_Work", row_num),"Type_of_Subcontracted_Work");
			GenericMethods.enter_text(ExcessProgramRaterLocators.ex_annualGross_Receipt_txtb,ExcelReader.get_row_data_from_col("Annual_Gross_Receipts", row_num), "Annual_Gross_Receipts");
			GenericMethods.enter_text(ExcessProgramRaterLocators.ex_gl_carrier_txtb,ExcelReader.get_row_data_from_col("Underlying_GL_Carrier", row_num), "Underlying_GL_Carrier");
			GenericMethods.enter_text(ExcessProgramRaterLocators.ex_gl_policyNo_txtb,ExcelReader.get_row_data_from_col("Underlying_GL_Policy_Number", row_num), "Underlying_GL_Policy_Number");
			ExcessProgramRaterLocators.ex_gl_expDate_txtb.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0, 1, 0, 0, 0));
			GenericMethods.select_from_dropdown(ExcessProgramRaterLocators.ex_project_aggregate_endorse_drpdwn,"visibletext",ExcelReader.get_row_data_from_col("Per_Project_Aggregate_Endorsement", row_num));
			GenericMethods.select_from_dropdown(ExcessProgramRaterLocators.ex_hire_nonHired_autoLimit_drpdwn,"index",ExcelReader.get_row_data_from_col("Hired&Non-Owned_Auto_Limit", row_num));
			GenericMethods.enter_text(ExcessProgramRaterLocators.ex_descriptionOperation_txtb,ExcelReader.get_row_data_from_col("Description_Of_Operations", row_num), "Description_Of_Operations");
			GenericMethods.click_element_JS(ExcessProgramRaterLocators.ex_submitUnderwriting_btn);
			WaitMethods.wait_in_seconds(3);					
		}
			
}


