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
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageLocators.AdminSubmissionPageLocators;
import com.LegacyApplication.PageLocators.CommercialAutoLocators;
import com.LegacyApplication.PageLocators.DefaultBrokerFeeLocators;
import com.LegacyApplication.PageLocators.GeneralLiabilityPageLocators;
import com.LegacyApplication.PageLocators.InlandMarineLocators;
import com.LegacyApplication.PageLocators.SubmissionPageLocators;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;

public class InlandMarineMethods extends TestBase {
	
	public static final Logger log=Logger.getLogger(InlandMarineMethods.class.getName());
	public static JavascriptExecutor js;
	

	/*
	 * Purpose: This method is used to click on Inland Marine Program
	 * @param int row_number 
	 * @return NA
	 */
	public static void click_victoryInlandmarine_program()
	{
		WaitMethods.wait_for_element_present(InlandMarineLocators.inland_marine_tab);
		GenericMethods.click_Element_Using_JS(InlandMarineLocators.inland_marine_tab);
		WaitMethods.wait_for_element_present(InlandMarineLocators.inland_marine_link);
		GenericMethods.click_Element_Using_JS(InlandMarineLocators.inland_marine_link);
	}
	
	/*
	 * Purpose: This method is used to fill the rating info of Inland Marine
	 * @param int row_number from excel
	 * @return NA
	 */
	public static void fill_InlandMarine_rating_info(int row_num) throws IOException, AWTException
	{
		ExcelReader.set_excel_file(Locations.regression_dataFilePath, "QNI_Rating_Info");
		WaitMethods.wait_for_element_present(InlandMarineLocators.vim_submission_type);
		GenericMethods.select_from_dropdown(InlandMarineLocators.vim_submission_type, "visibletext", ExcelReader.get_row_data_from_col("Submission_Type", row_num));
		WaitMethods.wait_for_element_present(InlandMarineLocators.vim_applicant_name);	
		GenericMethods.enter_text(InlandMarineLocators.vim_applicant_name, ExcelReader.get_row_data_from_col("Applicant_Name", row_num), "Applicant_Name");
		WaitMethods.wait_for_element_present(InlandMarineLocators.vim_proposed_effectivedate);
		InlandMarineLocators.vim_proposed_effectivedate.clear();
		InlandMarineLocators.vim_proposed_effectivedate.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0, 1, 0, 0, 0));
		WaitMethods.wait_for_element_present(InlandMarineLocators.vim_state);
		GenericMethods.select_from_dropdown(InlandMarineLocators.vim_state, "visibletext", ExcelReader.get_row_data_from_col("State", row_num));
		WaitMethods.wait_for_element_present(InlandMarineLocators.vim_optbasic_radio);
		GenericMethods.click_Element_Using_JS(InlandMarineLocators.vim_optbasic_radio);
		WaitMethods.wait_for_element_present(InlandMarineLocators.vim_rateitnow_btn);
		GenericMethods.click_Element_Using_JS(InlandMarineLocators.vim_rateitnow_btn);
		//....................>Filling Price Indicator Info<<.............................//
		WaitMethods.wait_for_element_present(SubmissionPageLocators.priceIndicator_submission_id);
		String qni_submission_id=SubmissionPageLocators.priceIndicator_submission_id.getText();
		//String renewal_submissionId=submission_id.concat("-1");
		//ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QCR_Info");
		//ExcelReader.set_data_in_cell(submission_id, row_num, col_num);
		//ExcelReader.setCellData(Locations.BrokerFeeDataFilePath, "QCR_Info", col_num,row_num, submission_id);
		ExcelReader.set_cell_data("QNI_Submission_Id", row_num, qni_submission_id);
		//ExcelReader.set_cell_data("Renewal Submission Id", row_num, renewal_submissionId);
		WaitMethods.wait_for_element_present(InlandMarineLocators.vim_terrorismDecline_radio);
		GenericMethods.click_Element_Using_JS(InlandMarineLocators.vim_terrorismDecline_radio);
		WaitMethods.wait_for_element_present(InlandMarineLocators.vim_priceIndicator_nextBtn);
		GenericMethods.click_Element_Using_JS(InlandMarineLocators.vim_priceIndicator_nextBtn);
		//....................>Filling Eligibility Questions Info<<.............................//
		WaitMethods.wait_for_elements_present(InlandMarineLocators.radiobtn_list_no);
		GenericMethods.click_list_of_webelements(InlandMarineLocators.radiobtn_list_no);
		WaitMethods.wait_for_element_present(InlandMarineLocators.vim_eligibitityQus_nextBtn);
		GenericMethods.click_Element_Using_JS(InlandMarineLocators.vim_eligibitityQus_nextBtn);
	}
	
	/*
	 * Purpose: This method is used to fill the Application info of Inland Marine
	 * @param int row_number from excel
	 * @return NA
	 */
	public static void fill_InlandMarine_application_info(int row_num) throws IOException, AWTException
	{
		ExcelReader.set_excel_file(Locations.regression_dataFilePath, "QNI_Application_Info");
		WaitMethods.wait_for_element_present(InlandMarineLocators.vim_applicationInfo_phyAddress);
		GenericMethods.enter_text(InlandMarineLocators.vim_applicationInfo_phyAddress, ExcelReader.get_row_data_from_col("Address", row_num), "Address");
		WaitMethods.wait_for_element_present(InlandMarineLocators.vim_applicationInfo_city);
		GenericMethods.enter_text(InlandMarineLocators.vim_applicationInfo_city, ExcelReader.get_row_data_from_col("City", row_num), "City");
		WaitMethods.wait_for_element_present(InlandMarineLocators.vim_applicationInfo_zipcode);
		GenericMethods.enter_text(InlandMarineLocators.vim_applicationInfo_zipcode, ExcelReader.get_row_data_from_col("Zip_Code", row_num), "Zip Code");
		GenericMethods.click_Element_Using_JS(InlandMarineLocators.vim_applicationInfo_sameMailingAddress_chkbx);
		GenericMethods.enter_text(InlandMarineLocators.vim_applicationInfo_contactName, ExcelReader.get_row_data_from_col("Contact_Name", row_num), "Contact Name");
		GenericMethods.enter_text(InlandMarineLocators.vim_applicationInfo_ofcPhnNum_area, ExcelReader.get_row_data_from_col("Office_Area", row_num), "Office Area");
		GenericMethods.enter_text(InlandMarineLocators.vim_applicationInfo_ofcPhnNum_prefix, ExcelReader.get_row_data_from_col("Office_Prefix", row_num), "Office Prefix");
		GenericMethods.enter_text(InlandMarineLocators.vim_applicationInfo_ofcPhnNum_phone, ExcelReader.get_row_data_from_col("Office_Phone", row_num), "Office Phone");
		GenericMethods.enter_text(InlandMarineLocators.vim_applicationInfo_celPhnum_area, ExcelReader.get_row_data_from_col("Cell_Area", row_num), "Cell Area");
		GenericMethods.enter_text(InlandMarineLocators.vim_applicationInfo_celPhnum_prefix, ExcelReader.get_row_data_from_col("Cell_Prefix", row_num), "Cell Prefix");
		GenericMethods.enter_text(InlandMarineLocators.vim_applicationInfo_celPhnum_phone, ExcelReader.get_row_data_from_col("Cell_Phone", row_num), "Cell Phone");
		WaitMethods.wait_for_element_present(InlandMarineLocators.vim_applicationInfo_businessType);
		GenericMethods.select_from_dropdown(InlandMarineLocators.vim_applicationInfo_businessType, "visibletext", ExcelReader.get_row_data_from_col("Business_Type", row_num));
		GenericMethods.select_from_dropdown(InlandMarineLocators.vim_applicationInfo_yearsInBusiness, "visibletext", ExcelReader.get_row_data_from_col("Years_In_Business", row_num));
		GenericMethods.select_from_dropdown(InlandMarineLocators.vim_applicationInfo_constructionExperience, "visibletext", ExcelReader.get_row_data_from_col("Construction_Experience", row_num));
		GenericMethods.enter_text(InlandMarineLocators.vim_applicationInfo_desctiptionOperations, ExcelReader.get_row_data_from_col("Operations_Description", row_num), "Description of Operations");
		GenericMethods.enter_text(InlandMarineLocators.vim_applicationInfo_currentPolExpDate, GenericMethods.get_current_date(), "Current Policy Expiration Date");
		GenericMethods.click_Element_Using_JS(InlandMarineLocators.vim_applicationInfo_submitToUnderwriting_btn);
	}
	
	/*
	 * Purpose: This method is to click on QNI binding doc link (Admin End)
	 * @param String submission id, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void click_QNI_bindingDoc_link(String submission_id,int row_num) throws InterruptedException, AWTException, IOException
	{
		try
		{
			GenericMethods.select_from_dropdown(GeneralLiabilityPageLocators.selectBy_drpDwn, "visibletext", OR.getProperty("selectby"));
			AdminSubmissionPageLocators.submission_id_searchfield.clear();
			ExcelReader.set_excel_file(Locations.regression_dataFilePath, "QNI_Rating_Info");
			AdminSubmissionPageLocators.submission_id_searchfield.sendKeys(ExcelReader.get_row_data_from_col(submission_id, row_num));
			WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.search_button);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.search_button);
			WaitMethods.wait_in_seconds(3);
			log.info("//===========================> Clicking on Binding Documents<=============================");
			WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.submission_table_row);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.submission_table_row);
			WaitMethods.wait_in_seconds(3);
			WaitMethods.wait_for_element_present(DefaultBrokerFeeLocators.bindingDocuments_link);
			GenericMethods.click_Element_Using_JS(DefaultBrokerFeeLocators.bindingDocuments_link);						
			WaitMethods.wait_in_seconds(3);
			GenericMethods.navigate_to_next_window();
			String s=DefaultBrokerFeeLocators.bindingDocPage_Heading.getText();
			if(s.equalsIgnoreCase("Victory Inland Marine Information to Request Binding of Coverage"))
			{					
				log.info("The Binding Doc. pgae get open");
			}else {
				log.info("The Binding Doc. pgae NOT get open");
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
	
		
	
	/*
	 * Purpose: This method is to click on QNI to verify Fradulent waring appear or Not
	 * @param String submission id, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void verify_fradulent_message(int row_num) throws InterruptedException, AWTException, IOException
	{
		GenericMethods.navigate_to_next_window();
		WaitMethods.wait_for_element_present(InlandMarineLocators.bindingdoc_pdf_application_link);
		GenericMethods.click_Element_Using_JS(InlandMarineLocators.bindingdoc_pdf_application_link);	
		GenericMethods.navigate_to_next_window();
		ExcelReader.set_excel_file(Locations.regression_dataFilePath, "QNI_Rating_Info");
		WaitMethods.wait_in_seconds(5);
		if(ExcelReader.get_row_data_from_col("State", row_num).equalsIgnoreCase("DC"))
		{
		GenericMethods.validate_text_in_pdf(ExcelReader.get_row_data_from_col("DC_Fraud_Warning", row_num));
		}
		else if(ExcelReader.get_row_data_from_col("State", row_num).equalsIgnoreCase("NY"))
		{
		GenericMethods.validate_text_in_pdf(ExcelReader.get_row_data_from_col("NY_Fraud_Warning", row_num));
		}
		else if(ExcelReader.get_row_data_from_col("State", row_num).equalsIgnoreCase("VT"))
		{
		GenericMethods.validate_text_in_pdf(ExcelReader.get_row_data_from_col("VT_Fraud_Warning", row_num));
		}
		log.info("===============>Fraud Warning Message has been verified successfully<==============");
	}
	
	
	/*
	 * Purpose: This method is used test ZIP code field Invalid data
	 * @param NA
	 * @return NA
	 */
	public static void verify_IM_zipcode()
	{
		String actual_url=driver.getCurrentUrl();log.info(actual_url);
		String expected_url="https://test.btisinc.com/QNI/General_BusinessInfo.aspx";                  
		if(expected_url.equals(actual_url))
		{
		 log.info("======================Unable to proceed further please check the information / validation Exists================");
		}
		else
		{
		 log.info("======================Submission accepted with Invalid Zip Code===========================");
		}
	}
	
	

	/*
	 * Purpose: This method is to change the status of a submission QNI
	 * @param (String QNI_Submission_Id, string status to be changed, int Row_number of Excel sheet)
	 * @return NA
	 */
	public static void InlandMarine_change_status(String QNI_Submission_Id,String status_tobe_changed, int row_num) throws InterruptedException, IOException
	{
		try
		{
			load_data();
			ExcelReader.set_excel_file(Locations.regression_dataFilePath,"QNI_Rating_Info");
			GenericMethods.navigate_to_next_window();
			AdminSubmissionPageLocators.submission_id_searchfield.clear();
			GenericMethods.enter_text(AdminSubmissionPageLocators.submission_id_searchfield, ExcelReader.get_row_data_from_col(QNI_Submission_Id, row_num), "Submission Id Search Field");
			//WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.search_button);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.search_button);	
			//WaitMethods.wait_in_seconds(3);
			//WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.submission_table_row);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.submission_table_row);
			GenericMethods.click_Element_Using_JS(DefaultBrokerFeeLocators.changestatus_link);
			WaitMethods.wait_in_seconds(3);

			ExcelReader.set_excel_file(Locations.regression_dataFilePath,"QNI_Status");

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

	
}
