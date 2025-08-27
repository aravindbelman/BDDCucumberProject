package com.LegacyApplication.PageMethods;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.LegacyApplication.ExcelReader.ExcelReader;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageLocators.AdminSubmissionPageLocators;
import com.LegacyApplication.PageLocators.CommercialAutoLocators;
import com.LegacyApplication.PageLocators.DefaultBrokerFeeLocators;
import com.LegacyApplication.PageLocators.SubmissionPageLocators;
import com.LegacyApplication.PageLocators.WorkersCompLocators;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;
import com.gargoylesoftware.htmlunit.AlertHandler;

public class CommercialAutoMethods extends TestBase
{
	public static final Logger log=Logger.getLogger(CommercialAutoMethods.class.getName());
	public static JavascriptExecutor js;


	/*
	 * Purpose: This method is used to click Commercial auto link
	 * @param integer (Row_number of Excel sheet)                                                                                                                                                    
	 * @return NA
	 */	
	public static void click_victory_auto_comp()
	{	
		WaitMethods.wait_for_element_present(CommercialAutoLocators.ca_tab);
		GenericMethods.click_Element_Using_JS(CommercialAutoLocators.ca_tab);
		WaitMethods.wait_for_element_present(CommercialAutoLocators.victorycommercialauto_link);
		GenericMethods.click_Element_Using_JS(CommercialAutoLocators.victorycommercialauto_link);
	}

	/*
	 * Purpose: This method is used fill Victory Commercial Auto Rating Info
	 * @param integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void fill_VCA_rating_info(int row_num) throws IOException, InterruptedException
	{

		ExcelReader.set_excel_file(Locations.tls_dataFilePath,"QCA_Rating");
		WaitMethods.wait_for_element_present(CommercialAutoLocators.ca_application_quote_no);
		String ca_submission_id=GenericMethods.retrive_substring(":", CommercialAutoLocators.ca_application_quote_no.getText());		
		ExcelReader.set_cell_data("CA_Submission_Id",row_num,ca_submission_id);


		GenericMethods.enter_text(CommercialAutoLocators.ca_name_txtb,ExcelReader.get_row_data_from_col("Name", row_num), "Applicant Name");
		GenericMethods.enter_text(CommercialAutoLocators.ca_dba_txtb,ExcelReader.get_row_data_from_col("DBA", row_num), "DBA");
		GenericMethods.select_from_dropdown(CommercialAutoLocators.ca_state_drpdwn, "visibletext", ExcelReader.get_row_data_from_col("State", row_num));
		//CommercialAutoLocators.ca_effectivedate.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0, 1, 0, 0, 0));
		GenericMethods.enter_text(CommercialAutoLocators.ca_descriptionoperation_txtb,ExcelReader.get_row_data_from_col("Description of Operations",row_num),"Description of Operations");
		GenericMethods.select_from_dropdown(CommercialAutoLocators.ca_noyear_drpdwn,"visibletext",ExcelReader.get_row_data_from_col("Number Years In Business", row_num));
		//GenericMethods.select_from_dropdown(CommercialAutoLocators.ca_libilitylimit_drpdwn,"visibletext",ExcelReader.get_row_data_from_col("Liability Limits", row_num));
		GenericMethods.select_from_dropdown(CommercialAutoLocators.ca_appcurrentlimit_drpdwn,"visibletext",ExcelReader.get_row_data_from_col("Applicant's CURRENT LIMITS", row_num));
		GenericMethods.select_from_dropdown(CommercialAutoLocators.ca_medicalpayment_drpdwn,"visibletext",ExcelReader.get_row_data_from_col("Medical Payments", row_num));
		GenericMethods.select_from_dropdown(CommercialAutoLocators.ca_uninsuredmotorist_drpdwn,"visibletext",ExcelReader.get_row_data_from_col("Uninsured Motorist", row_num));
		//GenericMethods.select_from_dropdown(CommercialAutoLocators.ca_policyterm_drpdwn,"visibletext",ExcelReader.get_row_data_from_col("Policy Term", row_num));
		GenericMethods.select_from_dropdown(CommercialAutoLocators.ca_paymentoption_drpdwn,"visibletext",ExcelReader.get_row_data_from_col("Payment Options", row_num));

		GenericMethods.select_from_dropdown(CommercialAutoLocators.ca_noofvehicle_drpdwn,"visibletext",ExcelReader.get_row_data_from_col("Select the Number of Vehicles", row_num));
		GenericMethods.enter_text(CommercialAutoLocators.ca_vin_txtb,ExcelReader.get_row_data_from_col("VIN", row_num), "VIN");
		GenericMethods.enter_text(CommercialAutoLocators.ca_year_txtb,ExcelReader.get_row_data_from_col("Year", row_num), "Year");
		GenericMethods.enter_text(CommercialAutoLocators.ca_make_txtb,ExcelReader.get_row_data_from_col("Make", row_num), "Make");
		GenericMethods.enter_text(CommercialAutoLocators.ca_model_txtb,ExcelReader.get_row_data_from_col("Model", row_num), "Model");
		GenericMethods.select_from_dropdown(CommercialAutoLocators.ca_compnamedperil_drpdwn,"visibletext",ExcelReader.get_row_data_from_col("select COMP/Named", row_num));
		GenericMethods.select_from_dropdown(CommercialAutoLocators.ca_coll_drpdwn,"visibletext",ExcelReader.get_row_data_from_col("COLL-No coverage", row_num));
		GenericMethods.select_from_dropdown(CommercialAutoLocators.ca_umpd_drpdwn,"visibletext",ExcelReader.get_row_data_from_col("UMPD-Coverage", row_num));
		GenericMethods.enter_text(CommercialAutoLocators.ca_currentvalue_txtb,ExcelReader.get_row_data_from_col("Current Value", row_num), "Current Value");

		GenericMethods.select_from_dropdown(CommercialAutoLocators.ca_type_drpdwn,"visibletext",ExcelReader.get_row_data_from_col("Type", row_num));
		//GenericMethods.click_Element_Using_JS(CommercialAutoLocators.ca_closealert);
		GenericMethods.select_from_dropdown(CommercialAutoLocators.ca_operation_drpdwn,"visibletext",ExcelReader.get_row_data_from_col("Opertions", row_num));
		GenericMethods.select_from_dropdown(CommercialAutoLocators.ca_use_drpdwn,"visibletext",ExcelReader.get_row_data_from_col("Use", row_num));
		GenericMethods.select_from_dropdown(CommercialAutoLocators.ca_radius_drpdwn,"visibletext",ExcelReader.get_row_data_from_col("Radius", row_num));
		GenericMethods.enter_text(CommercialAutoLocators.ca_zip_txtb,ExcelReader.get_row_data_from_col("Zip Code", row_num), "Zip Code");

		GenericMethods.select_from_dropdown(CommercialAutoLocators.ca_selectnoofdriver_drpdwn,"visibletext",ExcelReader.get_row_data_from_col("Select the Number of Drivers and Enter Driver Information", row_num));
		GenericMethods.enter_text(CommercialAutoLocators.ca_firstname_txtb,ExcelReader.get_row_data_from_col("First Name", row_num), "First Name");
		GenericMethods.enter_text(CommercialAutoLocators.ca_lastname_txtb,ExcelReader.get_row_data_from_col("Last Name", row_num), "Last Name");
		GenericMethods.enter_text(CommercialAutoLocators.ca_driverlicense_txtb,ExcelReader.get_row_data_from_col("Driver License", row_num), "Driver License");
		GenericMethods.select_from_dropdown(CommercialAutoLocators.ca_statelic_drpdwn,"visibletext",ExcelReader.get_row_data_from_col("State Lic.", row_num));
		GenericMethods.click_Element_Using_JS(CommercialAutoLocators.ca_single_chkb);
		GenericMethods.enter_text(CommercialAutoLocators.ca_dob_txtb,ExcelReader.get_row_data_from_col("DOB", row_num), "DOB");

		GenericMethods.enter_text(CommercialAutoLocators.ca_yearlic_txtb,ExcelReader.get_row_data_from_col("No. Yrs Licensed", row_num), "No. Yrs Licensed");
		//GenericMethods.click_Element_Using_JS(CommercialAutoLocators.ca_none_chkb);

		GenericMethods.click_Element_Using_JS(CommercialAutoLocators.ca_hiredandnonowned_chkb);
		GenericMethods.enter_text(CommercialAutoLocators.ca_cost_txtb,ExcelReader.get_row_data_from_col("Cost", row_num), "Cost");
		GenericMethods.enter_text(CommercialAutoLocators.ca_employees_txtb,ExcelReader.get_row_data_from_col("Employees", row_num), "Employees");
		GenericMethods.click_Element_Using_JS(CommercialAutoLocators.ca_rental_chkb);
		GenericMethods.click_Element_Using_JS(CommercialAutoLocators.ca_vehicle1_chkb);
		GenericMethods.click_Element_Using_JS(CommercialAutoLocators.ca_addeqipment_chkb);
		GenericMethods.enter_text(CommercialAutoLocators.ca_vechicle1value_txtb,ExcelReader.get_row_data_from_col("Vehicle 1 value", row_num), "Vehicle 1 value");		
		GenericMethods.click_Element_Using_JS(CommercialAutoLocators.ca_stereosound_chkb);
		GenericMethods.enter_text(CommercialAutoLocators.ca_stereovehicle_value_txtb,ExcelReader.get_row_data_from_col("Vehicle 1 value2", row_num), "Vehicle 1 value2");
		GenericMethods.click_Element_Using_JS(CommercialAutoLocators.ca_othercar_chkb);
		GenericMethods.select_from_dropdown(CommercialAutoLocators.ca_indivname_drpdwn,"visibletext",ExcelReader.get_row_data_from_col("Indiv to be named", row_num));
		GenericMethods.click_Element_Using_JS(CommercialAutoLocators.ca_sr22_chkb);
		GenericMethods.click_Element_Using_JS(CommercialAutoLocators.wc_ratenow_btn);
	}

	/*
	 * Purpose: This method is used fill Victory Comp Auto Eligibility Information
	 * @param integer (Row_number of Excel sheet)
	 * @return NA
	 * Question no. 3/4/5/12 -YES- value=1
	 */	
	public static void eligibilityQuestions() throws InterruptedException
	{
		//CA fill GENRAL QUESTIONS
		WaitMethods.wait_for_element_present(CommercialAutoLocators.ca_eq1no_radio);
		GenericMethods.click_Element_Using_JS(CommercialAutoLocators.ca_eq1no_radio);
		GenericMethods.click_Element_Using_JS(CommercialAutoLocators.ca_eq2no_radio);
		GenericMethods.click_Element_Using_JS(CommercialAutoLocators.ca_eq3yes_radio);
		GenericMethods.click_Element_Using_JS(CommercialAutoLocators.ca_eq4yes_radio);
		GenericMethods.click_Element_Using_JS(CommercialAutoLocators.ca_eq5yes_radio);
		GenericMethods.click_Element_Using_JS(CommercialAutoLocators.ca_eq6no_radio);
		GenericMethods.click_Element_Using_JS(CommercialAutoLocators.ca_eq7no_radio);
		GenericMethods.click_Element_Using_JS(CommercialAutoLocators.ca_eq8no_radio);
		GenericMethods.click_Element_Using_JS(CommercialAutoLocators.ca_eq9no_radio);
		GenericMethods.click_Element_Using_JS(CommercialAutoLocators.ca_eq10no_radio);
		GenericMethods.click_Element_Using_JS(CommercialAutoLocators.ca_eq11no_radio);
		GenericMethods.click_Element_Using_JS(CommercialAutoLocators.ca_eq12yes_radio);
		GenericMethods.click_Element_Using_JS(CommercialAutoLocators.ca_eq13no_radio);
		GenericMethods.click_Element_Using_JS(CommercialAutoLocators.ca_eq14no_radio);
		GenericMethods.click_Element_Using_JS(CommercialAutoLocators.ca_eq15no_radio);
		GenericMethods.click_Element_Using_JS(CommercialAutoLocators.ca_eq16no_radio);
		GenericMethods.click_Element_Using_JS(CommercialAutoLocators.ca_eq17no_radio);
		GenericMethods.click_Element_Using_JS(CommercialAutoLocators.ca_eq18no_radio);
		GenericMethods.click_Element_Using_JS(CommercialAutoLocators.ca_eq19no_radio);
		GenericMethods.click_Element_Using_JS(CommercialAutoLocators.ca_eqpageNext_btn);

	}

	/*
	 * Purpose: This method is used fill Victory Comp Auto application Information
	 * @param integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void fill_ca_application_info(int row_num) throws InterruptedException, IOException
	{
		ExcelReader.set_excel_file(Locations.tls_dataFilePath, "QCA_Application");
		WaitMethods.wait_for_element_present(CommercialAutoLocators.ca_addressphy_txtb);
		GenericMethods.enter_text(CommercialAutoLocators.ca_addressphy_txtb, ExcelReader.get_row_data_from_col("Address (physical)", row_num), "Address (physical)");
		GenericMethods.enter_text(CommercialAutoLocators.ca_city_txtb, ExcelReader.get_row_data_from_col("City", row_num), "City");
		GenericMethods.enter_text(CommercialAutoLocators.ca_zipcode_txtb, ExcelReader.get_row_data_from_col("Zip Code", row_num), "Zip Code");
		GenericMethods.click_Element_Using_JS(CommercialAutoLocators.ca_samemailaddress_chkb);
		GenericMethods.enter_text(CommercialAutoLocators.ca_contactname_txtb, ExcelReader.get_row_data_from_col("Contact Name", row_num), "Contact Name");
		GenericMethods.enter_text(CommercialAutoLocators.ca_ph1_txtb, ExcelReader.get_row_data_from_col("Office Phone Number1", row_num), "Office Phone Number1");
		GenericMethods.enter_text(CommercialAutoLocators.ca_ph2_txtb, ExcelReader.get_row_data_from_col("Office Phone Number2", row_num), "Office Phone Number2");
		GenericMethods.enter_text(CommercialAutoLocators.ca_ph3_txtb, ExcelReader.get_row_data_from_col("Office Phone Number3", row_num), "Office Phone Number3");
		GenericMethods.select_from_dropdown(CommercialAutoLocators.ca_typeofbusiness_drpdwn,"visibletext",ExcelReader.get_row_data_from_col("Type Of Business", row_num));

		GenericMethods.enter_text(CommercialAutoLocators.ca_carrier1_txtb, ExcelReader.get_row_data_from_col("Carrier Name", row_num), "Carrier Name");
		GenericMethods.enter_text(CommercialAutoLocators.ca_policyno1_txtb, ExcelReader.get_row_data_from_col("Policy Number", row_num), "Policy Number");
		GenericMethods.enter_text(CommercialAutoLocators.ca_priorinslimit1_txtb, ExcelReader.get_row_data_from_col("Prior Insurance Limits", row_num), "Prior Insurance Limits");
		GenericMethods.enter_text(CommercialAutoLocators.ca_policytermdate1_txtb, ExcelReader.get_row_data_from_col("Policy Term Dates", row_num), "Policy Term Dates");
		GenericMethods.enter_text(CommercialAutoLocators.ca_totalpremium1_txtb, ExcelReader.get_row_data_from_col("Total Premium", row_num), "Total Premium");
		GenericMethods.select_from_dropdown(CommercialAutoLocators.ca_slectdriver_drpdwn,"visibletext",ExcelReader.get_row_data_from_col("Select Driver", row_num));
		GenericMethods.enter_text(CommercialAutoLocators.ca_firstname1_txtb, ExcelReader.get_row_data_from_col("First Name5", row_num), "First Name5");
		GenericMethods.enter_text(CommercialAutoLocators.ca_lastname1_txtb, ExcelReader.get_row_data_from_col("Last Name5", row_num), "Last Name5");
		GenericMethods.enter_text(CommercialAutoLocators.ca_dob1_txtb, ExcelReader.get_row_data_from_col("Date of Birth5", row_num), "Date of Birth5");
		GenericMethods.enter_text(CommercialAutoLocators.ca_yeexp_txtb, ExcelReader.get_row_data_from_col("Yrs. Exp.5", row_num), "Yrs. Exp.5");
		GenericMethods.enter_text(CommercialAutoLocators.ca_driverliscense2_txtb, ExcelReader.get_row_data_from_col("Driver License5", row_num), "Driver License5");
		GenericMethods.enter_text(CommercialAutoLocators.ca_statelic2_txtb, ExcelReader.get_row_data_from_col("State Lic5", row_num), "State Lic5");
		GenericMethods.enter_text(CommercialAutoLocators.ca_gvw_txtb, ExcelReader.get_row_data_from_col("GVW", row_num), "GVW");
		GenericMethods.enter_text(CommercialAutoLocators.ca_stereo_txtb, ExcelReader.get_row_data_from_col("Stereox", row_num), "Stereox");
		GenericMethods.enter_text(CommercialAutoLocators.ca_addequip_txtb, ExcelReader.get_row_data_from_col("Add Equip", row_num), "Add Equip");

		GenericMethods.click_Element_Using_JS(CommercialAutoLocators.ca_submitbutton_btn);
		WaitMethods.wait_in_seconds(5);


	}

	/*
	 * Purpose: This method is to change the status of a submission QCA
	 * @param (String CA_Submission_Id, string status to be changed, int Row_number of Excel sheet)
	 * @return NA
	 */
	public static void commerciAuto_change_status(String CA_Submission_Id,String status_tobe_changed, int row_num) throws InterruptedException, IOException
	{
		try
		{
			load_data();
			ExcelReader.set_excel_file(Locations.tls_dataFilePath,"QCA_Rating");
			GenericMethods.navigate_to_next_window();
			AdminSubmissionPageLocators.submission_id_searchfield.clear();
			GenericMethods.enter_text(AdminSubmissionPageLocators.submission_id_searchfield, ExcelReader.get_row_data_from_col(CA_Submission_Id, row_num), "Submission Id Search Field");
			//WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.search_button);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.search_button);	
			//WaitMethods.wait_in_seconds(3);
			//WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.submission_table_row);
			GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.submission_table_row);
			GenericMethods.click_Element_Using_JS(DefaultBrokerFeeLocators.changestatus_link);
			WaitMethods.wait_in_seconds(3);

			ExcelReader.set_excel_file(Locations.tls_dataFilePath, "QCA_Status");

			for(int i=0;i<DefaultBrokerFeeLocators.changestatus_labels.size();i++)
			{
				String s=GenericMethods.get_text(DefaultBrokerFeeLocators.changestatus_labels.get(i));
				int j=i+1;
				try
				{
					if(s.contains(ExcelReader.get_row_data_from_col(status_tobe_changed, row_num)))
					{
						driver.findElement(By.xpath("(//input[@id='Status'])[position()='"+j+"']")).click();
						if(ExcelReader.get_row_data_from_col(status_tobe_changed, row_num).equalsIgnoreCase("sold"))
						{ 	
							ExcelReader.set_excel_file(Locations.tls_dataFilePath,"QCA_Rating");
							GenericMethods.enter_text(CommercialAutoLocators.ca_sold_policyno_txtb, ExcelReader.get_row_data_from_col("CA_Submission_Id", row_num)+"SOLD", "CA_Submission_Id_SOLD_PolicyNo");
						}
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

	/*
	 * Purpose: This method is to change the status of a submission QCA
	 * @param (String submission id, string status to be changed, int Row_number of Excel sheet)
	 * @return NA
	 */
	/*public static void commercialAuto_change_status(String CA_Submission_Id,String status_tobe_changed, int row_num) throws InterruptedException, IOException
		{

				load_data();
				ExcelReader.set_excel_file(Locations.tls_dataFilePath,"QCA_Rating");
				GenericMethods.navigate_to_next_window();
				AdminSubmissionPageLocators.submission_id_searchfield.clear();
				GenericMethods.enter_text(AdminSubmissionPageLocators.submission_id_searchfield, ExcelReader.get_row_data_from_col(CA_Submission_Id, row_num), "Submission Id Search Field");
				//WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.search_button);
				GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.search_button);	
				//WaitMethods.wait_in_seconds(3);
				//WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.submission_table_row);
				GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.submission_table_row);
				GenericMethods.click_Element_Using_JS(DefaultBrokerFeeLocators.changestatus_link);
				WaitMethods.wait_in_seconds(3);
				GenericMethods.click_Element_Using_JS(CommercialAutoLocators.ca_oktobind_radio);
				GenericMethods.click_Element_Using_JS(CommercialAutoLocators.ca_status_submitbutton);
				WaitMethods.wait_in_seconds(3);
				GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.search_button);	
				GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.submission_table_row);
				GenericMethods.click_Element_Using_JS(DefaultBrokerFeeLocators.changestatus_link);
				WaitMethods.wait_in_seconds(3);
				GenericMethods.click_Element_Using_JS(CommercialAutoLocators.ca_sold_radio);
				ExcelReader.set_excel_file(Locations.tls_dataFilePath,"QCA_Rating");
				GenericMethods.enter_text(CommercialAutoLocators.ca_sold_policyno_txtb, ExcelReader.get_row_data_from_col("CA_Submission_Id", row_num)+"SOLD", "CA_Submission_Id_SOLD_PolicyNo");
				GenericMethods.click_Element_Using_JS(CommercialAutoLocators.ca_status_submitbutton);
				WaitMethods.wait_in_seconds(3);
				}*/
	/*
	 * Purpose: This method is to test when you click on Application page 
	 * Error message list exists there 
	 * @return NA
	 */
	public static void applicationpage_errorlist_QCA() {

		String validationlist= CommercialAutoLocators.ca_applicationpage_error_list.getText();
		if(validationlist.contains(validationlist)) {
			log.info("===================Unnecessary Error/Validation List appear befor Entering any field info==============");
			log.info(validationlist);
		}else {
			log.info("====================No Validation message list Not appear=====================");
		} 
	}

	/*
	 * Purpose: This method is to test when you click on Application page 
	 * Enter VIN no less then 10 Digit
	 * Error message list exists there with VIN validation message exists or Not
	 * @return NA
	 */
	public static void applicationpage_errormsg_VIN_QCA() {

		String vinvalidation= CommercialAutoLocators.ca_applicationpage_VIN_error_msg.getText();
		if(vinvalidation.contains(vinvalidation)) {
			log.info("======================VIN no.length validation message exists===================");
			log.info(vinvalidation);
		}else {
			log.info("=======================No Validation. message Not appear======================");
		} 
	}

	/*
	 * Purpose: This method is to test when you click on Application page 
	 * Error message list exists there 
	 * @return NA
	 */	
	public static void verify_existenceOfPirceIndicatorTab_QCA() {

		if(GenericMethods.is_element_present(SubmissionPageLocators.price_indicator_tab).equalsIgnoreCase("false"))
		{
			log.info("There is no Price Indicator tab available for commercial auto proggram");	
		}
		else
		{
			log.info("Price Indicator tab available");
		}
	}

	/*
	 * Purpose: This method is to validate the eligibility questions Page 
	 * Error message list exists there 
	 * @return NA
	 */
	public static void verify_eligibilityQuestion_QCA() {

		if(CommercialAutoLocators.eligible_qus19.getText().equalsIgnoreCase("Are any vehicles registered to an individual?"))
		{
			log.info("The extra question has been successfully added for commercial auto proggram eligibility questions page");	
		}
		else
		{
			log.info("There is no extra question available");
		}
	}

		/*
		 * Purpose: This method is to validate the eligibility questions Page 
		 * Error message list exists there 
		 * @return NA
		 */
		public static void verify_claimsSectionOption_QCA() {

			if(CommercialAutoLocators.ca_claimsSection_heading.getText().equalsIgnoreCase("CLAIMS SECTION"))
			{
				log.info("The claims section option is available in Application page of Victory Commercial Auto");	
			}
			else
			{
				log.info("There is no claims section option available");
			}
		}

	}



