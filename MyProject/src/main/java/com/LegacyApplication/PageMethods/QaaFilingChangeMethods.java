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
import com.LegacyApplication.PageLocators.AutoRenewalBrokerFeeLocators;
import com.LegacyApplication.PageLocators.DefaultBrokerFeeLocators;
import com.LegacyApplication.PageLocators.GeneralLiabilityPageLocators;
import com.LegacyApplication.PageLocators.SubmissionPageLocators;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;


public class QaaFilingChangeMethods extends TestBase {

	public static final Logger log=Logger.getLogger(QaaFilingChangeMethods.class.getName());
	public static JavascriptExecutor js;

	/*
	 * Purpose: This method is used to fill the comparative rater info for a submission
	 * @param int row_number from excel
	 * @return NA
	 */
	public static void fill_comparative_rater_info(String sheetname, String effective_date, int row_num) throws IOException, InterruptedException, AWTException
	{
		try
		{	
			ExcelReader.set_excel_file(Locations.qaaChangesFilePath, sheetname);
			WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.state_info);
			GenericMethods.select_from_dropdown(GeneralLiabilityPageLocators.state_info, "visibletext", ExcelReader.get_row_data_from_col("State", row_num));
			GeneralLiabilityPageLocators.zip_code.sendKeys(ExcelReader.get_row_data_from_col("Zip Code", row_num));
			GenericMethods.accept_alert();
			WaitMethods.wait_in_seconds(3);
			GeneralLiabilityPageLocators.applicant_name.sendKeys(ExcelReader.get_row_data_from_col("Applicant Name", row_num));
			GeneralLiabilityPageLocators.dba.sendKeys(ExcelReader.get_row_data_from_col("DBA", row_num));
			WaitMethods.wait_in_seconds(3);	
			GenericMethods.press_key_using_robot("enter");
			WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.proposed_effective_date);
			GeneralLiabilityPageLocators.proposed_effective_date.clear();
			GenericMethods.accept_alert();
			WaitMethods.wait_in_seconds(3);
			GeneralLiabilityPageLocators.proposed_effective_date.sendKeys(ExcelReader.get_row_data_from_col(effective_date, row_num));
			WaitMethods.wait_in_seconds(3);
			WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_limits);
			GenericMethods.select_using_action(GeneralLiabilityPageLocators.gl_limits, "visibletext", ExcelReader.get_row_data_from_col("Limits", row_num));
			WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_deductible);
			boolean breakIt = true;
			while (true) {
				breakIt = true;
				try {
					GenericMethods.select_using_action(GeneralLiabilityPageLocators.gl_deductible, "value", ExcelReader.get_row_data_from_col("Deductible", row_num));
					WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_owners_activeinfield);
					GeneralLiabilityPageLocators.gl_owners_activeinfield.clear();
					GeneralLiabilityPageLocators.gl_owners_activeinfield.sendKeys(ExcelReader.get_row_data_from_col("Owners Active In Field", row_num));
					WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_select_class1);
					GenericMethods.select_using_action(GeneralLiabilityPageLocators.gl_select_class1, "visibletext", ExcelReader.get_row_data_from_col("Classification-1", row_num));
					//GenericMethods.select_random_value_from_dropdown(GeneralLiabilityPageLocators.gl_select_class1);
					WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_subcontracting_costs);
					GeneralLiabilityPageLocators.gl_subcontracting_costs.sendKeys(ExcelReader.get_row_data_from_col("Subcontracting Costs", row_num));
					WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_gross_receipts);
					GeneralLiabilityPageLocators.gl_gross_receipts.sendKeys(ExcelReader.get_row_data_from_col("Receipts", row_num));
					GenericMethods.select_from_dropdown(GeneralLiabilityPageLocators.gl_business_experience, "visibletext", ExcelReader.get_row_data_from_col("Business Experience", row_num));
					GenericMethods.select_from_dropdown(GeneralLiabilityPageLocators.gl_paid_loss, "visibletext", ExcelReader.get_row_data_from_col("past 3 year claims", row_num));
					String SandR_Credit=ExcelReader.get_row_data_from_col("S&R Credit", row_num);
					if(SandR_Credit.equalsIgnoreCase("yes"))
					{
						WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_newResidentialStructure_chkbox);
						GeneralLiabilityPageLocators.gl_newResidentialStructure_chkbox.click();
						WaitMethods.wait_in_seconds(5);
						WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_existingAmturstPolicy);
						GenericMethods.select_from_dropdown(GeneralLiabilityPageLocators.gl_existingAmturstPolicy, "visibletext", ExcelReader.get_row_data_from_col("Available Policy Credits", row_num));
						WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_rateitnow_button);
						GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.gl_rateitnow_button);
						WaitMethods.wait_in_seconds(3);
					}
					else
					{
						WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_existingAmturstPolicy);
						GenericMethods.select_from_dropdown(GeneralLiabilityPageLocators.gl_existingAmturstPolicy, "visibletext", ExcelReader.get_row_data_from_col("Available Policy Credits", row_num));
						WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_rateitnow_button);
						GeneralLiabilityPageLocators.gl_rateitnow_button.click();
						if(GenericMethods.is_element_displayed(GeneralLiabilityPageLocators.decline_ASR)=="true")
						{
							WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.decline_ASR);
							GeneralLiabilityPageLocators.decline_ASR.click();
						}
					}

					if(GenericMethods.is_element_displayed(GeneralLiabilityPageLocators.victory_admitted_chkbox).equalsIgnoreCase("true"))
					{
						log.info("General Liability options were visible");
					}
					else
					{
						WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.gl_rateitnow_button);
						GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.gl_rateitnow_button);
					}

					String checked=GenericMethods.is_chekbox_selected(GeneralLiabilityPageLocators.verify_victory_admitted_chkbox);
					if(checked=="false")
					{
						GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.victory_admitted_chkbox);
						/*WaitMethods.fluent_wait(GeneralLiabilityPageLocators.victory_nonadmitted_chkbox);
    		    GenericMethods.click_Element_Using_JS(GeneralLiabilityPageLocators.victory_nonadmitted_chkbox);	*/
						/*WaitMethods.fluent_wait(GeneralLiabilityPageLocators.victory_certified_chkbox);
    	      	GeneralLiabilityPageLocators.victory_certified_chkbox.click();*/
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
		}catch(UnhandledAlertException exe)
		{
			log.info("Unhandled alert occured");
		}
		catch(ElementNotVisibleException exe)
		{
			log.info("Element not visible");
		}
		catch(NoSuchElementException exe)
		{
			log.info("unable to find the element in the web page");
		}
		catch(WebDriverException exe)
		{
			log.info("unable to find the element in the web page");
		}

	}

	/*
	 * Purpose: This method is to fill the price indicator and eligibility info while creating a submission
	 * @param (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void fill_price_indicatorandeligibility_info(String sheetname, int row_num) throws IOException, InterruptedException
	{
		ExcelReader.set_excel_file(Locations.qaaChangesFilePath, sheetname);
		String submission_id=SubmissionPageLocators.priceIndicator_submission_id.getText();
		String renewal_submissionId=submission_id.concat("-1");
		ExcelReader.set_cell_data("Submission Id", row_num, submission_id);
		ExcelReader.set_cell_data("Renewal Submission Id", row_num, renewal_submissionId);
		String occurence_form=ExcelReader.get_row_data_from_col("Coverage Option 1", row_num);
		try
		{
			if(occurence_form.equalsIgnoreCase("3"))
			{
				try
				{
					WaitMethods.wait_in_seconds(3);
					if(GenericMethods.is_element_displayed(SubmissionPageLocators.manifest_without_sunset_no).equalsIgnoreCase("true"))
					{
						String s=GenericMethods.is_element_displayed(SubmissionPageLocators.manifest_without_sunset_no);
						System.out.println(s);
						SubmissionPageLocators.manifest_without_sunset_no.click();
					}
					if(GenericMethods.is_element_displayed(SubmissionPageLocators.occurence_form_with_sunset_no).equalsIgnoreCase("true"))
					{
						String s=GenericMethods.is_element_displayed(SubmissionPageLocators.occurence_form_with_sunset_no);
						System.out.println(s);
						SubmissionPageLocators.occurence_form_with_sunset_no.click();
					}
					if(GenericMethods.is_element_displayed(SubmissionPageLocators.occurence_form_without_sunset_yes).equalsIgnoreCase("true"))
					{
						String s=GenericMethods.is_element_displayed(SubmissionPageLocators.occurence_form_without_sunset_yes);
						System.out.println(s);
						SubmissionPageLocators.occurence_form_without_sunset_yes.click();
					}
				}
				catch(ElementNotVisibleException e)
				{
					System.out.println("There is no rating criteria");
				}
				SubmissionPageLocators.priceIndicator_nextbtn.click();
				SubmissionPageLocators.eligibility_autofill_chkbox.click();
				WaitMethods.wait_in_seconds(5);
				SubmissionPageLocators.eligibilitypage_nxtbtn.click();
			}
		}
		catch(UnhandledAlertException exe)
		{
			log.info("Unhandled alert occured");
		}
		catch(ElementNotVisibleException exe)
		{
			log.info("Element not visible");
		}
		catch(NoSuchElementException exe)
		{
			log.info("unable to find the element in the web page");
		}
		catch(WebDriverException exe)
		{
			log.info("unable to find the element in the web page");
		}
	}

	/*
	 * Purpose: This method is to fill the application info while creating a submission
	 * @param (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void fill_application_info(String effective_date,int row_num) throws IOException, InterruptedException
	{
		try
		{
			ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QAA_app_info");
			SubmissionPageLocators.pri_street_address.sendKeys(ExcelReader.get_row_data_from_col("Street Address", row_num));
			SubmissionPageLocators.primary_city.sendKeys(ExcelReader.get_row_data_from_col("City", row_num));
			SubmissionPageLocators.same_as_primary_checkbox.click();
			SubmissionPageLocators.contact_name.sendKeys(ExcelReader.get_row_data_from_col("Contact Name", row_num));
			SubmissionPageLocators.signing_party.sendKeys(ExcelReader.get_row_data_from_col("Signing Party", row_num));
			SubmissionPageLocators.office_phno1.sendKeys(ExcelReader.get_row_data_from_col("office phone Area", row_num));
			SubmissionPageLocators.office_phno2.sendKeys(ExcelReader.get_row_data_from_col("office phone Prefix", row_num));
			SubmissionPageLocators.office_phno3.sendKeys(ExcelReader.get_row_data_from_col("office phone Phone", row_num));
			SubmissionPageLocators.email_address.sendKeys(ExcelReader.get_row_data_from_col("Email Address", row_num));
			GenericMethods.select_from_dropdown(SubmissionPageLocators.business_type, "visibletext", ExcelReader.get_row_data_from_col("Type of Business", row_num));
			//WaitMethods.wait_for_element_present(SubmissionPageLocators.theft_protection);
			//SubmissionPageLocators.theft_protection.sendKeys(ExcelReader.get_row_data_from_col("Individual Name for Theft Protection", row_num));
			WaitMethods.wait_for_element_present(SubmissionPageLocators.years_in_business);
			GenericMethods.select_using_action(SubmissionPageLocators.years_in_business, "visibletext", ExcelReader.get_row_data_from_col("Number of Years In Business", row_num));
			WaitMethods.wait_for_element_present(SubmissionPageLocators.construction_experience);
			GenericMethods.select_from_dropdown(SubmissionPageLocators.construction_experience, "visibletext", ExcelReader.get_row_data_from_col("Total Years Of Construction Experience", row_num));
			if(GenericMethods.is_element_present(SubmissionPageLocators.SubContarctorWork_concrete).equalsIgnoreCase("true"))
			{
				SubmissionPageLocators.SubContarctorWork_concrete.click();
			}
			ExcelReader.set_excel_file(Locations.qaaChangesFilePath, "States_Info");
			SubmissionPageLocators.current_gl_policy_expiration.clear();
			SubmissionPageLocators.current_gl_policy_expiration.sendKeys(ExcelReader.get_row_data_from_col(effective_date, row_num));
			ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QAA_app_info");
			SubmissionPageLocators.carrier_name.sendKeys(ExcelReader.get_row_data_from_col("Carrier Name", row_num));
			SubmissionPageLocators.industrial_strct_type.sendKeys(ExcelReader.get_row_data_from_col("Structure type Industrial", row_num));
			SubmissionPageLocators.new_construction_type.sendKeys(ExcelReader.get_row_data_from_col("Construction Type - New Construction", row_num));
			SubmissionPageLocators.service_and_repair_type.sendKeys(ExcelReader.get_row_data_from_col("Construction Type - Service & Repair", row_num));
			SubmissionPageLocators.last_12months_txtfield.sendKeys(ExcelReader.get_row_data_from_col("Last 12 Months", row_num));
			SubmissionPageLocators.second_year_prior.sendKeys(ExcelReader.get_row_data_from_col("2nd Year Prior", row_num));
			SubmissionPageLocators.third_year_prior.sendKeys(ExcelReader.get_row_data_from_col("3rd Year Prior", row_num));
			SubmissionPageLocators.description_of_operations.sendKeys(ExcelReader.get_row_data_from_col("Description Of Operations", row_num));
			SubmissionPageLocators.submit_button.click();
		}
		catch(UnhandledAlertException exe)
		{
			log.info("Unhandled alert occured");
		}
		catch(ElementNotVisibleException exe)
		{
			log.info("Element not visible");
		}
		catch(NoSuchElementException exe)
		{
			log.info("unable to find the element in the web page");
		}
		catch(WebDriverException exe)
		{
			log.info("unable to find the element in the web page");
		}
	}

	public static void save_ratingWorkSheet(String sheetname,String submission_id,int row_num, String effective_date) throws AWTException, IOException, InterruptedException
	{	
		try
		{
			load_data();
			ExcelReader.set_excel_file(Locations.qaaChangesFilePath, sheetname);
			WaitMethods.wait_in_seconds(5);
			AdminSubmissionPageLocators.submission_id_searchfield.sendKeys(ExcelReader.get_row_data_from_col(submission_id, row_num));
			WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.search_button);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.search_button);
			WaitMethods.wait_in_seconds(5);	
			AdminSubmissionPageMethods.view_submission_details();
			GenericMethods.navigate_to_next_window();
			if(GenericMethods.is_chekbox_selected(AdminSubmissionPageLocators.cbFullWithoutSunset_chkbx).equalsIgnoreCase("false"))
			{
				AdminSubmissionPageLocators.cbFullWithoutSunset_chkbx.click();
			}
			if(effective_date.equalsIgnoreCase("Proposed Effective Date 1"))
			{
				WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.gl_premium);
				String s1= GenericMethods.get_text(AutoRenewalBrokerFeeLocators.gl_premium);
				String premium_value=s1.substring(s1.lastIndexOf("$") + 1);
				ExcelReader.set_cell_data("Premium 1", row_num, premium_value);
				WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.gl_policy_fee);
				String s2= GenericMethods.get_text(AutoRenewalBrokerFeeLocators.gl_policy_fee);
				String gl_policy_fee=s2.substring(s2.lastIndexOf("$") + 1);
				ExcelReader.set_cell_data("Fee 1", row_num, gl_policy_fee);
				WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.total_gl_premiumandfees);
				String s3= GenericMethods.get_text(AutoRenewalBrokerFeeLocators.total_gl_premiumandfees);
				String total_fee=s3.substring(s3.lastIndexOf("$") + 1);
				ExcelReader.set_cell_data("Total 1", row_num, total_fee);
			}
			else if(effective_date.equalsIgnoreCase("Proposed Effective Date 2"))
			{
				WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.gl_premium);
				String s1= GenericMethods.get_text(AutoRenewalBrokerFeeLocators.gl_premium);
				String premium_value=s1.substring(s1.lastIndexOf("$") + 1);
				ExcelReader.set_cell_data("Premium 2", row_num, premium_value);
				WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.gl_policy_fee);
				String s2= GenericMethods.get_text(AutoRenewalBrokerFeeLocators.gl_policy_fee);
				String gl_policy_fee=s2.substring(s2.lastIndexOf("$") + 1);
				ExcelReader.set_cell_data("Fee 2", row_num, gl_policy_fee);
				WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.total_gl_premiumandfees);
				String s3= GenericMethods.get_text(AutoRenewalBrokerFeeLocators.total_gl_premiumandfees);
				String total_fee=s3.substring(s3.lastIndexOf("$") + 1);
				ExcelReader.set_cell_data("Total 2", row_num, total_fee);
			}
			WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.save_ratingws);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.save_ratingws);
			WaitMethods.wait_in_seconds(5);
		}
		catch(UnhandledAlertException exe)
		{
			log.info("Unhandled alert occured");
		}
		catch(ElementNotVisibleException exe)
		{
			log.info("Element not visible");
		}
		catch(NoSuchElementException exe)
		{
			log.info("unable to find the element in the web page");
		}
		catch(WebDriverException exe)
		{
			log.info("unable to find the element in the web page");
		}
	}

	/*
	 * Purpose: This method is to change the status of a submission
	 * @param (String submission id, string status to be changed, int Row_number of Excel sheet)
	 * @return NA
	 */
	public static void change_status(String sheetname,String submission_id,String status_tobe_changed, int row_num) throws InterruptedException, IOException
	{
		try
		{
			load_data();
			ExcelReader.set_excel_file(Locations.qaaChangesFilePath, sheetname);
			GenericMethods.navigate_to_next_window();
			WaitMethods.wait_in_seconds(5);
			AdminSubmissionPageLocators.submission_id_searchfield.clear();
			AdminSubmissionPageLocators.submission_id_searchfield.sendKeys(ExcelReader.get_row_data_from_col(submission_id, row_num));
			WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.search_button);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.search_button);
			WaitMethods.wait_in_seconds(5);		
			WaitMethods.wait_in_seconds(3);
			WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.submission_table_row);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.submission_table_row);
			GenericMethods.click_Element_Using_JS(DefaultBrokerFeeLocators.changestatus_link);
			WaitMethods.wait_in_seconds(3);

			ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QAA_Status");

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
		catch(UnhandledAlertException exe)
		{
			log.info("Unhandled alert occured");
		}
		catch(ElementNotVisibleException exe)
		{
			log.info("Element not visible");
		}
		catch(NoSuchElementException exe)
		{
			log.info("unable to find the element in the web page");
		}
		catch(WebDriverException exe)
		{
			log.info("unable to find the element in the web page");
		}
		log.info("The status has changed successfully");
		GenericMethods.click_Element_Using_JS(DefaultBrokerFeeLocators.changestatus_cancelbutton);
	}

	/*
	 * Purpose: This method is to click on binding doc link after changing the status of a submission
	 * @param String submission id, integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void click_bindingDoc_link(String sheetname,String submission_id,int row_num) throws InterruptedException, AWTException, IOException
	{
		try
		{
			WaitMethods.wait_for_element_present(GeneralLiabilityPageLocators.selectBy_drpDwn);
			ExcelReader.set_excel_file(Locations.qaaChangesFilePath, sheetname);
			GenericMethods.select_from_dropdown(GeneralLiabilityPageLocators.selectBy_drpDwn, "visibletext", OR.getProperty("selectby"));
			AdminSubmissionPageLocators.submission_id_searchfield.clear();
			AdminSubmissionPageLocators.submission_id_searchfield.sendKeys(ExcelReader.get_row_data_from_col(submission_id, row_num));
			WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.search_button);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.search_button);
			log.info("//===========================> Clicking on Binding Documents<=============================");
			WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.submission_table_row);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.submission_table_row);
			WaitMethods.wait_for_element_present(DefaultBrokerFeeLocators.bindingDocuments_link);
			GenericMethods.click_Element_Using_JS(DefaultBrokerFeeLocators.bindingDocuments_link);
			log.info("//===========================> Clicked on Binding Document Link<=============================");
		}
		catch(UnhandledAlertException exe)
		{
			log.info("Unhandled alert occured");
		}
		catch(ElementNotVisibleException exe)
		{
			log.info("Element not visible");
		}
		catch(NoSuchElementException exe)
		{
			log.info("unable to find the element in the web page");
		}
		catch(WebDriverException exe)
		{
			log.info("unable to find the element in the web page");
		}
	}

	public static void verify_premium(String sheetname,int row_num) throws IOException, InterruptedException
	{
		GenericMethods.navigate_to_next_window();
		WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.occurent_and_premium);
		String s1=GenericMethods.get_text(AutoRenewalBrokerFeeLocators.occurent_and_premium);
		System.out.println(s1);
		String premium = s1.substring(s1.lastIndexOf("$") + 1);
		System.out.println(premium);
		ExcelReader.set_excel_file(Locations.qaaChangesFilePath, sheetname);
		ExcelReader.set_cell_data("Premium", row_num, premium);
		WaitMethods.wait_in_seconds(5);

	}

	public static void vaildate_QAA_filing_changes(String sheet_name, int no_of_scenarios, String effective_date) throws IOException, AWTException, InterruptedException
	{
		ExcelReader.set_excel_file(Locations.qaaChangesFilePath, sheet_name);
		int Data_in_rows=ExcelReader.get_row_count()-1;
		if(no_of_scenarios>Data_in_rows)
		{
			System.out.println("No: os Scenarios should be less than or equal to "+Data_in_rows+" as the data is present only in "+Data_in_rows+" rows in the excel sheet");
		}
		else
		{
			try
			{
				for(int i=1; i<=no_of_scenarios; i++)
				{
					initialize_chrome("Agency_Url");
					InitializeElements.initialize_elements();
					AutoRenewalBrokerFeeMethods.select_agency(1);
					HomePageMethods.select_agency_contact(Locations.BrokerFeeDataFilePath, "Agency_Info", "Agency_Contact", 1);
					QaaFilingChangeMethods.fill_comparative_rater_info(sheet_name,effective_date, i);
					QaaFilingChangeMethods.fill_price_indicatorandeligibility_info(sheet_name,i);
					QaaFilingChangeMethods.fill_application_info(effective_date,1);
					WaitMethods.wait_in_seconds(5);
					GenericMethods.accept_alert();
					GenericMethods.navigate_to_url(OR.getProperty("Admin_Url"));
					WaitMethods.wait_for_page_load(5);
					InitializeElements.initialize_elements();
					HomePageMethods.login_as_admin();
					QaaFilingChangeMethods.save_ratingWorkSheet(sheet_name,"Submission Id",i, effective_date);
					GenericMethods.close_browser_window();
					QaaFilingChangeMethods.change_status(sheet_name,"Submission Id","Status_OkToBind",i);
					WaitMethods.wait_in_seconds(5);
					GenericMethods.navigate_to_url(OR.getProperty("Agency_Url"));
					WaitMethods.wait_in_seconds(5);
					InitializeElements.initialize_elements();
					/*AutoRenewalBrokerFeeMethods.select_agency(1);
			        HomePageMethods.select_agency_contact("Agency_Contact", 1);*/
					WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.gotoSubmissions_button);
					AutoRenewalBrokerFeeLocators.gotoSubmissions_button.click();
					QaaFilingChangeMethods.click_bindingDoc_link(sheet_name,"Submission Id",i);
					QaaFilingChangeMethods.verify_premium(sheet_name, i);
					closeBrowser();
				}
			}
			catch(UnhandledAlertException exe)
			{
				log.info("Unhandled alert occured");
			}
			catch(ElementNotVisibleException exe)
			{
				log.info("Element not visible");
			}
			catch(NoSuchElementException exe)
			{
				log.info("unable to find the element in the web page");
			}
			catch(WebDriverException exe)
			{
				log.info("unable to find the element in the web page");
			}

		}

	}
}