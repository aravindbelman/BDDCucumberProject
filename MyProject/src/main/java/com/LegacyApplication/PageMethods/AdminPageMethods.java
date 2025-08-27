package com.LegacyApplication.PageMethods;

import java.io.IOException;

import org.apache.http.impl.conn.tsccm.WaitingThreadAborter;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.LegacyApplication.ExcelReader.ExcelReader;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageLocators.AdminPageLocators;
import com.LegacyApplication.PageLocators.AdminSubmissionPageLocators;
import com.LegacyApplication.PageLocators.AutoRenewalBrokerFeeLocators;
import com.LegacyApplication.PageLocators.GeneralLiabilityPageLocators;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;

public class AdminPageMethods extends TestBase {
	
	public static final Logger log=Logger.getLogger(WorkersCompMethods.class.getName());
	public static JavascriptExecutor js;
	

	/*
	 * Purpose: This method is used to verify the expiration date field of an agency
	 * @param integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void verify_expirationdatefield(int row_num) throws IOException, InterruptedException
	{
		WaitMethods.wait_in_seconds(5);
		GenericMethods.mouse_hover_and_click_using_actions(AdminPageLocators.adminTasks_tab, AdminPageLocators.agencyInfoEdit_link);
		/*GenericMethods.click_Element_Using_JS(AdminPageLocators.adminTasks_tab);
		GenericMethods.click_Element_Using_JS(AdminPageLocators.agencyInfoEdit_link);*/
		ExcelReader.set_excel_file(Locations.regression_dataFilePath, "Admin_TestData");
		GenericMethods.select_from_dropdown(AdminPageLocators.searchBy_drpdwm, "visibletext", ExcelReader.get_row_data_from_col("Search_By", row_num));
		GenericMethods.enter_text(AdminPageLocators.search_field, ExcelReader.get_row_data_from_col("Agency Code", row_num), "Search Agency");
		GenericMethods.click_Element_Using_JS(AdminPageLocators.search_btn);
		if(AdminPageLocators.agencyCode_row.getText().equalsIgnoreCase(ExcelReader.get_row_data_from_col("Agency Code", row_num)))
		{
			GenericMethods.click_Element_Using_JS(AdminPageLocators.agencyCode_row);
  		}
		GenericMethods.click_Element_Using_JS(AdminPageLocators.editAgency_link);
		GenericMethods.click_Element_Using_JS(AdminPageLocators.licenceExpiration_datePicker);
		GenericMethods.click_Element_Using_JS(AdminPageLocators.licenceExpiration_daySwitch);
		GenericMethods.click_Element_Using_JS(AdminPageLocators.licenceExpiration_monthSwitch);
		GenericMethods.click_Element_Using_JS(AdminPageLocators.licenceExpiration_yearSwitch);
		
		GenericMethods.select_date_from_datePicker(AdminPageLocators.licenseExpiration_year, AdminPageLocators.LicenseExpiration_month, AdminPageLocators.EoPolicyExpiration_day, ExcelReader.get_row_data_from_col("License_Expiration_Year", row_num), ExcelReader.get_row_data_from_col("License_Expiration_Month", row_num), ExcelReader.get_row_data_from_col("License_Expiration_Day", row_num));
		
		WaitMethods.wait_in_seconds(5);
		
		GenericMethods.click_Element_Using_JS(AdminPageLocators.EoPloicydate_datePicker);
		GenericMethods.click_Element_Using_JS(AdminPageLocators.EoPolicyExpiration_daySwitch);
		GenericMethods.click_Element_Using_JS(AdminPageLocators.EoPolicyExpiration_monthSwitch);
		GenericMethods.click_Element_Using_JS(AdminPageLocators.EoPolicyExpiration_yearSwitch);
		
		GenericMethods.select_date_from_datePicker(AdminPageLocators.EoPolicyExpiration_year, AdminPageLocators.EoPolicyExpiration_month, AdminPageLocators.EoPolicyExpiration_day, ExcelReader.get_row_data_from_col("EO_Policy_Expiration_Year", row_num), ExcelReader.get_row_data_from_col("EO_Policy_Expiration_Month", row_num), ExcelReader.get_row_data_from_col("EO_Policy_Expiration_Day", row_num));
	
		/*GenericMethods.enter_text(AdminPageLocators.agency_licenceExpiration_field,ExcelReader.get_row_data_from_col("License_Expiration", row_num), "License Expiration Field");
		GenericMethods.enter_text(AdminPageLocators.agency_licenceExpiration_field, "07/07/2002", "Expiration date field");
		WaitMethods.wait_in_seconds(10);
		GenericMethods.enter_text(AdminPageLocators.EoPolicy_Expiration_field,ExcelReader.get_row_data_from_col("EO_Policy_Expiration", row_num), "EO Policy Expiration Field");*/
		GenericMethods.click_Element_Using_JS(AdminPageLocators.save_button);
	}
	

	/*
	 * Purpose: This method is used to add an Master Agency
	 * @param NA
	 * @return NA
	 */
	public static void verify_add_masterAgency()
	{
		GenericMethods.mouse_hover_and_click_using_actions(AdminPageLocators.adminTasks_tab, AdminPageLocators.masterAgencies_link);
		String url1=driver.getCurrentUrl();
		GenericMethods.click_Element_Using_JS(AdminPageLocators.addNew_masterAgency_btn);	
		if(url1.equals(driver.getCurrentUrl()))
		{
		log.info("The user has been re-directed to the same page instead of Add new Master Agency Page");
		}
		else
		{
		log.info("There are no fields to add a new Master Agency");
		}
	}
	
	/*
	 * Purpose: This method is used to verify Manage Forms under the Admin
	 * @param integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void verify_manageForms(int row_num)
	{
		GenericMethods.mouse_hover_and_click_using_actions(AdminPageLocators.adminTasks_tab, AdminPageLocators.manageFormsList_link);
		GenericMethods.select_from_dropdown(AdminPageLocators.selectProgramName_dropdwn, "visibletext", ExcelReader.get_row_data_from_col("Select_Program1", row_num));
		GenericMethods.click_Element_Using_JS(AdminPageLocators.showAllForms_btn);
		GenericMethods.select_from_dropdown(AdminPageLocators.selectProgramName_dropdwn, "visibletext", ExcelReader.get_row_data_from_col("Select_Program2", row_num));
	}
	
	/*
	 * Purpose: This method is used to create a GL submission without email from Admin Side
	 * @param integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void create_GlSubmission_from_admin(int row_num) throws IOException, InterruptedException
	{
		GenericMethods.click_Element_Using_JS(AdminPageLocators.victoryGlProgram_link);
		ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QCR_Info");
		WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.state_info);
		GenericMethods.select_from_dropdown(GeneralLiabilityPageLocators.state_info, "visibletext", ExcelReader.get_row_data_from_col("State", row_num));
		GeneralLiabilityPageLocators.zip_code.sendKeys(ExcelReader.get_row_data_from_col("Zip Code", row_num));
		GenericMethods.accept_alert();
		WaitMethods.wait_in_seconds(3);
		GeneralLiabilityPageLocators.applicant_name.sendKeys(ExcelReader.get_row_data_from_col("Applicant Name", row_num));
		GeneralLiabilityPageLocators.dba.sendKeys(ExcelReader.get_row_data_from_col("DBA", row_num));
		/*WaitMethods.wait_in_seconds(3);	
		GenericMethods.press_key_using_robot("enter");
		WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.proposed_effective_date);
		GeneralLiabilityPageLocators.proposed_effective_date.clear();
		GenericMethods.accept_alert();
		WaitMethods.wait_in_seconds(3);
		GeneralLiabilityPageLocators.proposed_effective_date.sendKeys(GenericMethods.get_current_date());*/
		WaitMethods.wait_in_seconds(3);
		WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_limits);
		GenericMethods.select_using_action(GeneralLiabilityPageLocators.gl_limits, "visibletext", ExcelReader.get_row_data_from_col("Limits", row_num));
		WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_deductible);
		boolean breakIt = true;
		while (true) {
			breakIt = true;
			try {
				GenericMethods.select_using_action(GeneralLiabilityPageLocators.gl_deductible, "value", ExcelReader.get_row_data_from_col("Deductible", row_num));
				if(GenericMethods.is_element_present(GeneralLiabilityPageLocators.qes_okay_btn).equalsIgnoreCase("true"))
				{
				   GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.qes_okay_btn);	
				}
				WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_owners_activeinfield);
				GeneralLiabilityPageLocators.gl_owners_activeinfield.clear();
				GeneralLiabilityPageLocators.gl_owners_activeinfield.sendKeys(ExcelReader.get_row_data_from_col("Owners Active In Field", row_num));
				WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_select_class1);
				GenericMethods.select_using_action(GeneralLiabilityPageLocators.gl_select_class1, "visibletext", ExcelReader.get_row_data_from_col("Classification-1", row_num));
				//GenericMethods.select_random_value_from_dropdown(GeneralLiabilityPageLocators.gl_select_class1);
				WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_additionalclass_button);
				GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.gl_additionalclass_button);
				WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_additionalclass_button);
				GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.gl_additionalclass_button);
				WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_class_percentage1);
				GeneralLiabilityPageLocators.gl_class_percentage1.clear();
				WaitMethods.wait_in_seconds(3);
				GeneralLiabilityPageLocators.gl_class_percentage1.sendKeys(ExcelReader.get_row_data_from_col("Classification-1 Percentage", row_num));
				if(!ExcelReader.get_row_data_from_col("Classification-2", row_num).equalsIgnoreCase("No"))
				{
					WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_select_class2);
					GenericMethods.select_using_action(GeneralLiabilityPageLocators.gl_select_class2, "visibletext", ExcelReader.get_row_data_from_col("Classification-2", row_num));
					WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_class_percentage2);
					GeneralLiabilityPageLocators.gl_class_percentage2.clear();
					GeneralLiabilityPageLocators.gl_class_percentage2.sendKeys(ExcelReader.get_row_data_from_col("Classification-2 Percentage", row_num));
				}
				WaitMethods.wait_in_seconds(3);
				if(!ExcelReader.get_row_data_from_col("Classification-3", row_num).equalsIgnoreCase("No"))
				{
					WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_select_class3);
					GenericMethods.select_using_action(GeneralLiabilityPageLocators.gl_select_class3, "visibletext", ExcelReader.get_row_data_from_col("Classification-3", row_num));
					WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_class_percentage3);
					GeneralLiabilityPageLocators.gl_class_percentage3.clear();
					GeneralLiabilityPageLocators.gl_class_percentage3.sendKeys(ExcelReader.get_row_data_from_col("Classification-3 Percentage", row_num));
				}
				WaitMethods.wait_in_seconds(3);
				if(!ExcelReader.get_row_data_from_col("Classification-4", row_num).equalsIgnoreCase("No"))
				{
					WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_select_class4);
					GenericMethods.select_using_action(GeneralLiabilityPageLocators.gl_select_class4, "visibletext", ExcelReader.get_row_data_from_col("Classification-4", row_num));
					WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_class_percentage4);
					GeneralLiabilityPageLocators.gl_class_percentage4.clear();
					GeneralLiabilityPageLocators.gl_class_percentage4.sendKeys(ExcelReader.get_row_data_from_col("Classification-4 Percentage", row_num));
				}
				WaitMethods.wait_in_seconds(3);
				/*if(GenericMethods.is_element_present(GeneralLiabilityPageLocators.qes_okay_btn).equalsIgnoreCase("true"))
				{
					GeneralLiabilityPageLocators.qes_okay_btn.click();
				}
*/					WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_subcontracting_costs);
				GeneralLiabilityPageLocators.gl_subcontracting_costs.sendKeys(ExcelReader.get_row_data_from_col("Subcontracting Costs", row_num));
				WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_gross_receipts);
				GeneralLiabilityPageLocators.gl_gross_receipts.sendKeys(ExcelReader.get_row_data_from_col("Receipts", row_num));
				GenericMethods.select_from_dropdown(GeneralLiabilityPageLocators.gl_business_experience, "visibletext", ExcelReader.get_row_data_from_col("Business Experience", row_num));
				GenericMethods.select_from_dropdown(GeneralLiabilityPageLocators.gl_paid_loss, "visibletext", ExcelReader.get_row_data_from_col("past 3 year claims", row_num));
				if(GenericMethods.is_element_displayed(GeneralLiabilityPageLocators.gl_newResidentialStructure_chkbox).equalsIgnoreCase("true")&& ExcelReader.get_row_data_from_col("New Residential Structure", row_num).equalsIgnoreCase("yes"))
				{
					GeneralLiabilityPageLocators.gl_newResidentialStructure_chkbox.click();
				}
				if(ExcelReader.get_row_data_from_col("Inland Marine", row_num).equalsIgnoreCase("yes"))
				{
					WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_optionalInalndMarine_chkbox);
					GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.gl_optionalInalndMarine_chkbox);
				}
				WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_existingAmturstPolicy);
				GenericMethods.select_from_dropdown(GeneralLiabilityPageLocators.gl_existingAmturstPolicy, "visibletext", ExcelReader.get_row_data_from_col("Available Policy Credits", row_num));
				WaitMethods.wait_in_seconds(3);
				if(GenericMethods.is_element_present(GeneralLiabilityPageLocators.gl_SandRcredit_no).equalsIgnoreCase("true"))
				{
					GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.gl_SandRcredit_no);
				}
				WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_rateitnow_button);
				GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.gl_rateitnow_button);
				/*if(GenericMethods.is_element_present(GeneralLiabilityPageLocators.victory_admitted_chkbox).equalsIgnoreCase("true"))
				{
					log.info("General Liability options were visible");
				}
				else
				{
					WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_rateitnow_button);
					GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.gl_rateitnow_button);
				}*/

				
				if(ExcelReader.get_row_data_from_col("Submission_Prefix", row_num).equalsIgnoreCase("QAA"))
				{
					WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.victory_admitted_chkbox);
					if(GenericMethods.is_chekbox_selected(GeneralLiabilityPageLocators.verify_victory_admitted_chkbox).equalsIgnoreCase("false"));
					{
					GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.victory_admitted_chkbox);
					}
				}
				else if(ExcelReader.get_row_data_from_col("Submission_Prefix", row_num).equalsIgnoreCase("QAN"))
				{
					WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.victory_nonadmitted_chkbox);
					if(GenericMethods.is_chekbox_selected(GeneralLiabilityPageLocators.verify_victory_nonadmitted_chkbox).equalsIgnoreCase("false"));
					{
					GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.victory_nonadmitted_chkbox);	
					}
				}
				else if(ExcelReader.get_row_data_from_col("Submission_Prefix", row_num).equalsIgnoreCase("QAC"))
				{
					WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.victory_certified_chkbox);
					if(GenericMethods.is_chekbox_selected(GeneralLiabilityPageLocators.verify_victory_certified_chkbox).equalsIgnoreCase("false"));
					{
					GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.victory_certified_chkbox);
					}
				}
				else if(ExcelReader.get_row_data_from_col("Submission_Prefix", row_num).equalsIgnoreCase("QES"))
				{
					WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.create_qes_submission);
					GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.create_qes_submission);
				}
				GenericMethods.scroll_down();
				WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.create_submission_button);
				GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.create_submission_button); 
			} catch (Exception e) {
				if (e.getMessage().contains("element is not attached")) {
					breakIt = false;
				}
			}
			if (breakIt) {
				break;
			}
	}


		
}
	
	/*
	 * Purpose: This method is used to Verify Edit Button from Manage User Menu
	 * @param NA
	 * @return NA
	 */
	public static void editButton_manageUser() throws Exception
	{	
		GenericMethods.mouse_hover(AdminPageLocators.Users_menuLink);
		GenericMethods.click_Element_Using_JS(AdminPageLocators.ManageUser_SubmenuLink);
		WaitMethods.wait_in_seconds(2);
		GenericMethods.click_Element_Using_JS(AdminPageLocators.userlist_EditLogo);
		WaitMethods.wait_in_seconds(2);
		if(AdminPageLocators.userInfo_popUp_TitleText.isDisplayed())
		{
			log.info("Pass-The user has been re-directed to the Edit Users Account Details Popup");
		}
		else
		{
			log.info("Edit Button NOT-FUNCTIONAING");
		}
		
	}
}
