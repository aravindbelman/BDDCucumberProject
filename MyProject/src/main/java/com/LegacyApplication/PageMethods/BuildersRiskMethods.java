package com.LegacyApplication.PageMethods;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;
import com.LegacyApplication.ExcelReader.ExcelReader;
import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageLocators.AdminSubmissionPageLocators;
import com.LegacyApplication.PageLocators.BuildersRiskLocators;
import com.LegacyApplication.PageLocators.DefaultBrokerFeeLocators;
import com.LegacyApplication.PageLocators.GeneralLiabilityPageLocators;
import com.LegacyApplication.PageLocators.SubmissionPageLocators;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;

public class BuildersRiskMethods extends TestBase {

	public static final Logger log=Logger.getLogger(BuildersRiskMethods.class.getName());
	public static JavascriptExecutor js;


	/*
	 * Purpose: This method is used to click on Builders Risk Program
	 * @param int row_number 
	 * @return NA
	 */
	public static void click_buildersrisk_program()
	{
		WaitMethods.wait_for_element_present(BuildersRiskLocators.buildersrisk_tab);
		GenericMethods.click_Element_Using_JS(BuildersRiskLocators.buildersrisk_tab);
		WaitMethods.wait_for_element_present(BuildersRiskLocators.brp_residentialandcommerciallink);
		GenericMethods.click_Element_Using_JS(BuildersRiskLocators.brp_residentialandcommerciallink);
	}
	
	public static void click_buildersrisk_program_AdminLogin()
	{
		WaitMethods.wait_for_element_present(BuildersRiskLocators.brp_BuilderRiskPrg);
		GenericMethods.click_Element_Using_JS(BuildersRiskLocators.brp_BuilderRiskPrg);
	}

	/*
	 * Purpose: This method is used to fill the rating info of Builders Risk
	 * @param int row_number from excel
	 * @return NA
	 */
	@SuppressWarnings("unlikely-arg-type")
	public static void fill_br_rating_info(int row_num) throws IOException, InterruptedException, AWTException
	{
		ExcelReader.set_excel_file(Locations.regression_dataFilePath, "GABR_RatingInfo");
		WaitMethods.wait_for_element_present(BuildersRiskLocators.brp_submissionId);
		String brp_submission_id=BuildersRiskLocators.brp_submissionId.getText();
		//String renewal_submissionId=submission_id.concat("-1");
		//ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QCR_Info");
		//ExcelReader.set_data_in_cell(submission_id, row_num, col_num);
		//ExcelReader.setCellData(Locations.BrokerFeeDataFilePath, "QCR_Info", col_num,row_num, submission_id);
		ExcelReader.set_cell_data("BR_Submission_Id", row_num, brp_submission_id);
		WaitMethods.wait_for_element_present(BuildersRiskLocators.brp_applicantname);	
		GenericMethods.enter_text(BuildersRiskLocators.brp_applicantname, ExcelReader.get_row_data_from_col("Applicant_Name", row_num), "Applicant Name");
		GenericMethods.enter_text(BuildersRiskLocators.brp_dba, ExcelReader.get_row_data_from_col("DBA", row_num), "DBA");
		GenericMethods.select_from_dropdown(BuildersRiskLocators.brp_lengthofproject, "visibletext", ExcelReader.get_row_data_from_col("Length_of_Project", row_num));
		GenericMethods.enter_text(BuildersRiskLocators.brp_street_address, ExcelReader.get_row_data_from_col("Street_Address", row_num), "Street Address");
		GenericMethods.enter_text(BuildersRiskLocators.brp_city, ExcelReader.get_row_data_from_col("City", row_num), "City");
		GenericMethods.select_from_dropdown(BuildersRiskLocators.brp_state_drpdwn, "visibletext", ExcelReader.get_row_data_from_col("State", row_num));
		GenericMethods.enter_text(BuildersRiskLocators.brp_zipcode, ExcelReader.get_row_data_from_col("Zip_Code", row_num), " Zip Code");
		
		if (ExcelReader.get_row_data_from_col("State", row_num).equals("TX")) 
		{
			WaitMethods.wait_for_element_present(BuildersRiskLocators.brp_region);
			GenericMethods.select_from_dropdown(BuildersRiskLocators.brp_region, "visibletext", ExcelReader.get_row_data_from_col("Region", row_num));
		}
		
		//GenericMethods.select_from_dropdown(BuildersRiskLocators.brp_protection_class, "visibletext", ExcelReader.get_row_data_from_col("Protection_Class", row_num));
		GenericMethods.select_from_dropdown(BuildersRiskLocators.brp_structure_type, "visibletext", ExcelReader.get_row_data_from_col("Structure_Type", row_num));
		GenericMethods.select_from_dropdown(BuildersRiskLocators.brp_project_type, "visibletext", ExcelReader.get_row_data_from_col("Project_Type", row_num));
		GenericMethods.select_from_dropdown(BuildersRiskLocators.brp_construction_type, "visibletext", ExcelReader.get_row_data_from_col("Construction_Type", row_num));
		GenericMethods.enter_text(BuildersRiskLocators.brp_construction_limit, ExcelReader.get_row_data_from_col("Construction_Limit", row_num), "Construction Limit");
		log.info(GenericMethods.is_element_present(BuildersRiskLocators.brp_soft_costs));
		
		/*GenericMethods.press_key_using_robot("tab");
		GenericMethods.is_element_present(BuildersRiskLocators.brp_soft_costs);
		GenericMethods.select_from_dropdown(BuildersRiskLocators.brp_soft_costs, "visibletext", ExcelReader.get_row_data_from_col("Soft_Costs", row_num));
		*/				
		if (ExcelReader.get_row_data_from_col("Structure_Type", row_num).equalsIgnoreCase("Residential")) 
		{	
			//GenericMethods.press_key_using_robot("tab");
			//GenericMethods.press_key_using_robot("downArrow");
			//GenericMethods.select_from_dropdown(BuildersRiskLocators.brp_Residential_soft_costs, "visibletext", ExcelReader.get_row_data_from_col("Soft_Costs", row_num));		
			WaitMethods.wait_for_element_present(BuildersRiskLocators.brp_rateitnow_btn);
			GenericMethods.click_Element_Using_JS(BuildersRiskLocators.brp_rateitnow_btn);
		}
		else if(ExcelReader.get_row_data_from_col("Structure_Type", row_num).equalsIgnoreCase("Commercial")&& GenericMethods.convert_stingto_double(ExcelReader.get_row_data_from_col("Construction_Limit", row_num))<500000 )
		{
			GenericMethods.select_from_dropdown(BuildersRiskLocators.brp_Commercial_soft_costs, "value", ExcelReader.get_row_data_from_col("Soft_Costs", row_num));
			WaitMethods.wait_for_element_present(BuildersRiskLocators.brp_rateitnow_btn);
			GenericMethods.click_Element_Using_JS(BuildersRiskLocators.brp_rateitnow_btn);
		}	
		else if(ExcelReader.get_row_data_from_col("Structure_Type", row_num).equalsIgnoreCase("Commercial")&& GenericMethods.convert_stingto_double(ExcelReader.get_row_data_from_col("Construction_Limit", row_num))>=500000 )
		{
			WaitMethods.wait_in_seconds(2);
			GenericMethods.press_key_using_robot("tab");
			log.info(GenericMethods.is_element_present(BuildersRiskLocators.brp_Commercial_soft_costs_greaterConstructionLimit));
			GenericMethods.select_from_dropdown(BuildersRiskLocators.brp_Commercial_soft_costs_greaterConstructionLimit, "value", ExcelReader.get_row_data_from_col("Soft_Costs", row_num));
			WaitMethods.wait_for_element_present(BuildersRiskLocators.brp_rateitnow_btn);
			GenericMethods.click_Element_Using_JS(BuildersRiskLocators.brp_rateitnow_btn);			
		}			
	}

	/*
	 * Purpose: This method is to click on GABR Edit/Finish Submission 
	 * @param String submission id, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void click_edit_or_finish_submission_link(String submission_id,int row_num) throws InterruptedException, AWTException, IOException
	{
		ExcelReader.set_excel_file(Locations.regression_dataFilePath, "GABR_RatingInfo");
		WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.selectBy_drpDwn);
		GenericMethods.select_from_dropdown(GeneralLiabilityPageLocators.selectBy_drpDwn, "visibletext", OR.getProperty("selectby"));
		AdminSubmissionPageLocators.submission_id_searchfield.clear();
		AdminSubmissionPageLocators.submission_id_searchfield.sendKeys(ExcelReader.get_row_data_from_col(submission_id, row_num));
		WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.search_button);
		GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.search_button);
		WaitMethods.wait_in_seconds(3);
		log.info("//===========================> Clicking on Edit?Finish Submission <=============================");
		WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.submission_table_row);
		GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.submission_table_row);
		WaitMethods.wait_in_seconds(3);
		WaitMethods.wait_for_element_present(SubmissionPageLocators.edit_or_finish_submission);
		GenericMethods.click_Element_Using_JS(SubmissionPageLocators.edit_or_finish_submission);
		log.info("//===========================> Clicked on Edit?Finish Submission <=============================");
	}
	
	/*
	 * Purpose: SearchSubmission_Click_PolicyInvoiceOption_ViewPrint
	 * & then view Print -PDF new Window Verify
	 * @param String submission id, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void searchSubmission_Click_PolicyInvoiceOption_ViewPrint(String submission_id,int row_num) throws InterruptedException, AWTException, IOException
	{
		ExcelReader.set_excel_file(Locations.regression_dataFilePath, "GABR_RatingInfo");
		WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.selectBy_drpDwn);
		GenericMethods.select_from_dropdown(GeneralLiabilityPageLocators.selectBy_drpDwn, "visibletext", OR.getProperty("selectby"));
		AdminSubmissionPageLocators.submission_id_searchfield.clear();
		AdminSubmissionPageLocators.submission_id_searchfield.sendKeys(ExcelReader.get_row_data_from_col(submission_id, row_num));
		WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.search_button);
		GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.search_button);
		WaitMethods.wait_in_seconds(3);
		WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.submission_table_row);
		GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.submission_table_row);
		WaitMethods.wait_in_seconds(3);
		log.info("//===========================> Clicking on policyandInvoice Option <=============================");
		WaitMethods.wait_for_element_present(SubmissionPageLocators.policyandInvoice);
		GenericMethods.click_Element_Using_JS(SubmissionPageLocators.policyandInvoice);
		log.info("//===========================> Clicked on policyandInvoice Option <=============================");
		WaitMethods.wait_in_seconds(3);
		GenericMethods.navigate_to_next_window();
		GenericMethods.click_Element_Using_JS(SubmissionPageLocators.viewAndPrintPolicY_btn);
		log.info("//===========================> Clicked on View and Print Policy Button <=============================");
		WaitMethods.wait_in_seconds(3);
		GenericMethods.navigate_to_next_window();
		GenericMethods.validate_text_in_pdf("POLICYHOLDER");
		log.info("//===========================> PDF Opens in New window & Validate there Data<=============================");
	}
	
	/*
	 * Purpose: No Need to search Submission_ and Click_PolicyInvoiceOption
	 * Direct _ViewPrint
	 * & then view Print -PDF new Window Verify
	 * @return NA
	 */
	public static void Click_PolicyInvoiceOption_ViewPrint() throws InterruptedException, AWTException, IOException
	{	
		WaitMethods.wait_in_seconds(2);
		GenericMethods.navigate_to_next_window();
		GenericMethods.click_Element_Using_JS(SubmissionPageLocators.viewAndPrintPolicY_btn);
		log.info("//===========================> Clicked on View and Print Policy Button <=============================");
		WaitMethods.wait_in_seconds(3);
		GenericMethods.navigate_to_next_window();
		GenericMethods.validate_text_in_pdf("POLICYHOLDER");
		log.info("//===========================> PDF Opens in New window & Validate there Data<=============================");
		
	}

	/*
	 * Purpose: This method is to fill the GABR application information (Admin side)
	 * @param String submission id, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void fill_br_application_info(int row_num) throws IOException, InterruptedException
	{
		ExcelReader.set_excel_file(Locations.regression_dataFilePath, "GABR_ApplicationInfo");
		WaitMethods.wait_for_element_present(BuildersRiskLocators.brp_application_tab);
		GenericMethods.click_Element_Using_JS(BuildersRiskLocators.brp_application_tab);
		
		//-------------------------->   Filling Eligibility Info  <----------------------//
		WaitMethods.wait_for_element_present(BuildersRiskLocators.br_elgiqutn1_optn_no);
		GenericMethods.click_Element_Using_JS(BuildersRiskLocators.br_elgiqutn1_optn_no);
		GenericMethods.click_Element_Using_JS(BuildersRiskLocators.br_elgiqutn2_optn_no);
		GenericMethods.click_Element_Using_JS(BuildersRiskLocators.br_elgiqutn3_optn_yes);
		GenericMethods.click_Element_Using_JS(BuildersRiskLocators.br_elgiqutn4_optn_no);
		GenericMethods.click_Element_Using_JS(BuildersRiskLocators.br_elgiqutn5_optn_no);
		GenericMethods.click_Element_Using_JS(BuildersRiskLocators.br_elgiqutn6_optn_no);
		GenericMethods.click_Element_Using_JS(BuildersRiskLocators.br_elgiqutn7_optn_no);
		GenericMethods.click_Element_Using_JS(BuildersRiskLocators.br_elgiqutn8_optn_no);
		GenericMethods.click_Element_Using_JS(BuildersRiskLocators.br_elgiqutn9_optn_no);
		GenericMethods.click_Element_Using_JS(BuildersRiskLocators.br_elgiqutn10_optn_no);
		
		if(ExcelReader.get_row_data_from_col("State", row_num).equals("TX"))
		{
		GenericMethods.click_Element_Using_JS(BuildersRiskLocators.br_elgiqutn11_optn_no);
		}
		
		//-------------------------->   Filling Project Info <----------------------//
		GenericMethods.enter_text(BuildersRiskLocators.br_application_fireScore_txtbox, ExcelReader.get_row_data_from_col("Wild Fire Score", row_num), "Wild Fire Score");
		
		ExcelReader.set_excel_file(Locations.regression_dataFilePath, "GABR_RatingInfo");
		WaitMethods.wait_in_seconds(2);
		if(ExcelReader.get_row_data_from_col("Structure_Type", row_num).equalsIgnoreCase("Residential"))
		{
			ExcelReader.set_excel_file(Locations.regression_dataFilePath, "GABR_ApplicationInfo");
			WaitMethods.wait_for_element_present(BuildersRiskLocators.br_application_noofUnits_drodown);
			GenericMethods.select_from_dropdown(BuildersRiskLocators.br_application_noofUnits_drodown, "visibletext", ExcelReader.get_row_data_from_col("Number of Units in Dwelling", 1));
		}
		
		WaitMethods.wait_in_seconds(2);
		ExcelReader.set_excel_file(Locations.regression_dataFilePath, "GABR_ApplicationInfo");
		GenericMethods.enter_text(BuildersRiskLocators.br_application_totalsquarefootage_txtbox, ExcelReader.get_row_data_from_col("Total Square Footage of Completed Project", row_num), " Total Square Footage of Completed Project");
		GenericMethods.select_from_dropdown(BuildersRiskLocators.br_application_noofstories_drodown, "visibletext", ExcelReader.get_row_data_from_col("Number of Stories", row_num));
		WaitMethods.wait_for_element_present(BuildersRiskLocators.br_application_anticipatedoccupancy_drodown);
		GenericMethods.select_from_dropdown(BuildersRiskLocators.br_application_anticipatedoccupancy_drodown, "visibletext", ExcelReader.get_row_data_from_col("What is the Anticipated Occupancy", row_num));
		GenericMethods.enter_text(BuildersRiskLocators.br_application_firehydrant_txtbox, ExcelReader.get_row_data_from_col("Distance to Nearest Fire Hydrant", row_num), "Distance to Nearest Fire Hydrant");
		GenericMethods.enter_text(BuildersRiskLocators.br_application_firestation_txtbox, ExcelReader.get_row_data_from_col("Distance to Nearest Fire Station", row_num), "Distance to Nearest Fire Station");
		GenericMethods.click_Element_Using_JS(BuildersRiskLocators.br_application_none_chckbox);
		//GenericMethods.click_Element_Using_JS(BuildersRiskLocators.br_application_Lights_checkbox);
		GenericMethods.enter_text(BuildersRiskLocators.br_application_description_txtbox, ExcelReader.get_row_data_from_col("Description", row_num), "Description of Project");
	    
		//-------------------------->   Filling Applicant Info <----------------------//
		GenericMethods.enter_text(BuildersRiskLocators.br_application_contactname_txtbox, ExcelReader.get_row_data_from_col("Insured Name", row_num), "Insured Name");
		//GenericMethods.enter_text(BuildersRiskLocators.br_application_dba_txtbox, ExcelReader.get_row_data_from_col("DBA", row_num), "DBA");
		GenericMethods.enter_text(BuildersRiskLocators.br_application_streetaddress_txtbox, ExcelReader.get_row_data_from_col("Street Address", row_num), "Street Address");
		GenericMethods.enter_text(BuildersRiskLocators.br_application_city_txtbox, ExcelReader.get_row_data_from_col("City", row_num), "City");
		GenericMethods.select_from_dropdown(BuildersRiskLocators.br_application_state_drpdwn, "visibletext", ExcelReader.get_row_data_from_col("State", row_num));
		GenericMethods.enter_text(BuildersRiskLocators.br_application_zip_txtbox, ExcelReader.get_row_data_from_col("Zip Code", row_num), "Zip Code");
		GenericMethods.enter_text(BuildersRiskLocators.br_application_contactname_txtbox, ExcelReader.get_row_data_from_col("Contact Name", row_num), "Contact Name");
		BuildersRiskLocators.br_application_contactphone_txtbox.sendKeys(ExcelReader.get_row_data_from_col("Contact Phone", row_num), "Contact Phone");
		GenericMethods.select_from_dropdown(BuildersRiskLocators.br_application_typebusiness_dropdwn, "visibletext", ExcelReader.get_row_data_from_col("Type of Business", row_num));
		GenericMethods.select_from_dropdown(BuildersRiskLocators.br_application_entity_dropdwn, "visibletext", ExcelReader.get_row_data_from_col("Type of Entity", row_num));
		
		//-------------------------->   Filling Contractor Info <----------------------//
		GenericMethods.enter_text(BuildersRiskLocators.br_application_contractorname_txtbox, ExcelReader.get_row_data_from_col("Contractor Name", row_num), "Contractor Name");
		GenericMethods.enter_text(BuildersRiskLocators.br_application_licenseno_txtbox, ExcelReader.get_row_data_from_col("Contractor License Number", row_num), "Contractor License Number");
		GenericMethods.select_from_dropdown(BuildersRiskLocators.br_application_contyeraexp_dropdwn, "visibletext", ExcelReader.get_row_data_from_col("Contractor Years of Experience", row_num));
		GenericMethods.enter_text(BuildersRiskLocators.br_application_contaddress_txtbox, ExcelReader.get_row_data_from_col("Contractor Address", row_num), "Contractor Address");
		GenericMethods.enter_text(BuildersRiskLocators.br_application_contcity_txtbox, ExcelReader.get_row_data_from_col("Contractor City", row_num), "Contractor City");
		GenericMethods.select_from_dropdown(BuildersRiskLocators.br_application_contststate_dropdwn, "visibletext", ExcelReader.get_row_data_from_col("Contractor State", row_num));
		GenericMethods.enter_text(BuildersRiskLocators.br_application_contzip_txtbox, ExcelReader.get_row_data_from_col("Contractor Zip Code", row_num), "Contractor Zip Code");
		GenericMethods.click_Element_Using_JS(BuildersRiskLocators.br_application_next_btn);
				
	}
	
	
	
	//This Method is to click on Price Indicator tab once again
	public static void again_clickon_priceIndicator_tab() throws InterruptedException, AWTException, IOException
	{
		WaitMethods.wait_in_seconds(5);
		GenericMethods.click_Element_Using_JS(BuildersRiskLocators.brp_priceIndicator_tab);
	}
	
	//This method is to hit Submit button at FinalReview page
	public static void clickon_finalReviewSubmit_toSubmitSubmission() throws InterruptedException, AWTException, IOException
	{
		WaitMethods.wait_in_seconds(5);
		GenericMethods.click_Element_Using_JS(BuildersRiskLocators.FinalReviewTab);
		GenericMethods.click_Element_Using_JS(BuildersRiskLocators.br_finalReview_submission_btn);
	}
	
	/*
	 * Purpose: This method is to verify Policy Issue Option
	 * on Final Review Page
	 * @return NA
	 */
	
	public static void check_Avaibility_Of_PolicyIssue_Option_IssuePolicy()throws InterruptedException, AWTException, IOException
	{
		WaitMethods.wait_in_seconds(5);
		if(GenericMethods.is_element_displayed(BuildersRiskLocators.br_policyIssue_detail).equalsIgnoreCase("true"))
		{
			log.info("Instant policy issue option Available on FINAL REVIEW page");
			GenericMethods.click_Element_Using_JS(BuildersRiskLocators.br_policyIssue_chkb);
			GenericMethods.click_Element_Using_JS(BuildersRiskLocators.br_policyIssue_btn);
			GenericMethods.click_Element_Using_JS(BuildersRiskLocators.br_policyIssue_popup_btn);
			WaitMethods.wait_in_seconds(3);
			log.info("Instant policy issued - SUCCESSFULLY");
		}
		else
		{
			log.info("Instant policy issue option NOT available on FINAL REVIEW page");
		}
		
	}
	
	/*
	 * Purpose: This method is to fill the GABR application information (Admin-side)
	 * & click on Underwriter checklist option to take into Server Error or Not
	 * @param String submission id, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void click_UnderwriterChecklist_link(String submission_id,int row_num) throws InterruptedException, AWTException, IOException
	{
		ExcelReader.set_excel_file(Locations.regression_dataFilePath, "GABR_RatingInfo");
		WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.selectBy_drpDwn);
		GenericMethods.select_from_dropdown(GeneralLiabilityPageLocators.selectBy_drpDwn, "visibletext", OR.getProperty("selectby"));
		AdminSubmissionPageLocators.submission_id_searchfield.clear();
		AdminSubmissionPageLocators.submission_id_searchfield.sendKeys(ExcelReader.get_row_data_from_col(submission_id, row_num));
		WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.search_button);
		GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.search_button);
		WaitMethods.wait_in_seconds(3);
		log.info("//===========================> Clicking on UnderwriterChecklist Link <=============================");
		WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.submission_table_row);
		GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.submission_table_row);
		WaitMethods.wait_in_seconds(3);
		WaitMethods.wait_for_element_present(SubmissionPageLocators.UnderWriterChekList_link);
		GenericMethods.click_Element_Using_JS(SubmissionPageLocators.UnderWriterChekList_link);
		log.info("//===========================> Clicked on UnderwriterChecklist Submission <=============================");
		GenericMethods.navigate_to_next_window();
		if(SubmissionPageLocators.underwriter_chklist_messagePage.getText().equalsIgnoreCase("Server Error in '/GABR' Application.")) {
			log.info("======================Serrver Error Present in UnderWriter check list option================");
		}else {
			log.info("==============Serrver Error Not Present in UnderWriter check list option - Working Fine==============");
		}
	}
	
	/*
	 * Purpose: This method is to fill the GABR application with Invalid ZIP information (Admin side)
	 * Still Allow to Submit Application
	 * @return NA
	 */
	public static void gabr_submissionWithInvalid_ZIP()
	{
		
	}
	
	/*
	 * Purpose: This method create GABR submission with Issued Status
	 * Test Renewal Letter Error pop up
	 * @param String submission id, integer (Row_number of Excel sheet)
	 * @return NA	
	*/
	public static void gabr_issued_RenewalLetter(String submission_id,int row_num) throws InterruptedException, AWTException, IOException
	{			
		log.info("//===========================> Clicking on Renewal Letter Link <=============================");
		WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.submission_table_row);
		GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.submission_table_row);
		WaitMethods.wait_in_seconds(3);
		WaitMethods.wait_for_element_present(SubmissionPageLocators.RenewalLetter_link);
		GenericMethods.click_Element_Using_JS(SubmissionPageLocators.RenewalLetter_link);
		log.info("//===========================> Clicked on Renewal Letter link <=============================");
		GenericMethods.accept_alert_using_js();
		log.info("==Unnecessary Alert is Present===");
	   /* if(GenericMethods.isAlertPresent())
	    {  
	    	log.info("Unnecessary Alert is Present");
		}else {
			log.info("There is No Alert Present");
		}*/
	   		
	}
	
	/*
	 * Purpose: This method is to change the status of a submission GABR
	 * @param (String CA_Submission_Id, string status to be changed, int Row_number of Excel sheet)
	 * @return NA
	 */
	public static void GABR_change_status(String BR_Submission_Id,String status_tobe_changed, int row_num) throws InterruptedException, IOException
	{
		try
		{
			load_data();
			ExcelReader.set_excel_file(Locations.regression_dataFilePath,"GABR_RatingInfo");
			GenericMethods.navigate_to_next_window();
			AdminSubmissionPageLocators.submission_id_searchfield.clear();
			GenericMethods.enter_text(AdminSubmissionPageLocators.submission_id_searchfield, ExcelReader.get_row_data_from_col(BR_Submission_Id, row_num), "Submission Id Search Field");
			//WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.search_button);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.search_button);	
			//WaitMethods.wait_in_seconds(3);
			//WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.submission_table_row);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.submission_table_row);
			GenericMethods.click_Element_Using_JS(DefaultBrokerFeeLocators.changestatus_link);
			WaitMethods.wait_in_seconds(3);

			ExcelReader.set_excel_file(Locations.regression_dataFilePath,"gabr_Status");

			for(int i=0;i<DefaultBrokerFeeLocators.changestatus_labels.size();i++)
			{
				String s=GenericMethods.get_text(DefaultBrokerFeeLocators.changestatus_labels.get(i));
				int j=i+1;
				try
				{
					if(s.contains(ExcelReader.get_row_data_from_col(status_tobe_changed, row_num)))
					{
						driver.findElement(By.xpath("(//input[@id='Status'])[position()='"+j+"']")).click();
						DefaultBrokerFeeLocators.changestatus_submitbutton.click();
					}
				} 
				catch (Exception msg)
				{
					System.out.println("Waiting to change the status");
				}	
			}
		}
		catch(UnhandledAlertException | ElementNotVisibleException | NoSuchElementException exe)
		{
			log.debug("The exception was found "+exe.getClass().getCanonicalName());
		}
		catch(WebDriverException exe)
		{
			log.info("unable to find the element in the web page");
		}
		log.info("The status has changed successfully");
	}
	
	public static void create_buildersRisk_submissions(int num_of_submissions) throws IOException, InterruptedException, AWTException
	{
		ExcelReader.set_excel_file(Locations.regression_dataFilePath, "GABR_RatingInfo");
		int Data_in_rows=ExcelReader.get_row_count()-1;
		if(num_of_submissions>Data_in_rows)
		{
			System.out.println("No: of Submissions should be less than or equal to "+Data_in_rows+" as the data is present only in "+Data_in_rows+" rows in the excel sheet");
		}
		else
		{
			try
			{
				for(int i=1;i<=num_of_submissions; i++)
				{
					initialize_admin_environment("environment", "chrome_browser");
					InitializeElements.initialize_elements();
					HomePageMethods.login_as_admin();
					WaitMethods.wait_in_seconds(2);
					click_buildersrisk_program_AdminLogin();
					fill_br_rating_info(i);
					WaitMethods.wait_in_seconds(3);
					WaitMethods.wait_for_page_load(5);				
					fill_br_application_info(1);
					GenericMethods.press_key_using_robot("end");
					check_Avaibility_Of_PolicyIssue_Option_IssuePolicy();
					
					if(i<num_of_submissions)
					{
						closeBrowser();
					}
				}
				
			}
			catch(UnhandledAlertException | ElementNotVisibleException | NoSuchElementException exe)
			{
				log.debug("The exception was found "+exe.getClass().getCanonicalName());
			}
			catch(WebDriverException exe)
			{
				log.info("unable to find the element in the web page");
			}
			
		}
		
		 
	}

}
