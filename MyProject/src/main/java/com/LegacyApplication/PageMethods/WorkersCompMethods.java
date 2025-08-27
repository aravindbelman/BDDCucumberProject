package com.LegacyApplication.PageMethods;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.BtisNewUI.Locators.WCnewUILocators;
import com.LegacyApplication.ExcelReader.ExcelReader;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageLocators.AdminSubmissionPageLocators;
import com.LegacyApplication.PageLocators.BuildersRiskLocators;
import com.LegacyApplication.PageLocators.DefaultBrokerFeeLocators;
import com.LegacyApplication.PageLocators.GeneralLiabilityPageLocators;
import com.LegacyApplication.PageLocators.SubmissionPageLocators;
import com.LegacyApplication.PageLocators.WorkersCompLocators;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;

public class WorkersCompMethods extends TestBase {

	public static final Logger log=Logger.getLogger(WorkersCompMethods.class.getName());
	public static JavascriptExecutor js;

	/*
	 * Purpose: This method is used to click Victory Workers Comp link
	 * @param integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void click_victory_workers_comp()
	{
		WaitMethods.wait_for_element_present(WorkersCompLocators.workerscomp_tab);
		GenericMethods.click_Element_Using_JS(WorkersCompLocators.workerscomp_tab);
		WaitMethods.wait_for_element_present(WorkersCompLocators.victory_wc_link);
		GenericMethods.click_Element_Using_JS(WorkersCompLocators.victory_wc_link);
	}

	/*
	 * Purpose: This method is used fill Victory Workers Comp Rating Info
	 * @param integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void fill_VWC_rating_info(int row_num) throws IOException, InterruptedException
	{
		ExcelReader.set_excel_file(Locations.regression_dataFilePath, "VWC_Rating_Info");
		WaitMethods.wait_for_element_present(WorkersCompLocators.wc_application_quote_number);
		String wc_submission_id=GenericMethods.retrive_substring(":", WorkersCompLocators.wc_application_quote_number.getText());		
		ExcelReader.set_cell_data("WC_Submission_Id", row_num, wc_submission_id);
		GenericMethods.enter_text(WorkersCompLocators.wc_applicatnName_txtb, ExcelReader.get_row_data_from_col("Applicant Name", row_num), "Applicant Name");
		GenericMethods.enter_text(WorkersCompLocators.wc_dba_txtb, ExcelReader.get_row_data_from_col("DBA Name", row_num), "DBA Name");
		WorkersCompLocators.wc_effectivedate.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0, 1, 0, 0, 0));
		//WorkersCompLocators.wc_effectivedate.sendKeys(GenericMethods.update_custom_date("MM/dd/YYYY", GenericMethods.get_current_date(), 1));
		//GenericMethods.select_from_dropdown(WorkersCompLocators.wc_currentlapse_drpdwn, "visibletext", ExcelReader.get_row_data_from_col("Current Lapse in Coverage", row_num));
		GenericMethods.enter_text(WorkersCompLocators.wc_address_txtb, ExcelReader.get_row_data_from_col("Address", row_num), "Address");
		GenericMethods.enter_text(WorkersCompLocators.wc_city_txtb, ExcelReader.get_row_data_from_col("City", row_num), "City");
		GenericMethods.select_from_dropdown(WorkersCompLocators.wc_state_drpdwn, "visibletext", ExcelReader.get_row_data_from_col("State", row_num));
		GenericMethods.enter_text(WorkersCompLocators.wc_zip_txtb, ExcelReader.get_row_data_from_col("Zip Code", row_num), "Zip Code");
		GenericMethods.enter_text(WorkersCompLocators.wc_phone1_txtb, ExcelReader.get_row_data_from_col("Phone_AreaCode", row_num), "Phone Area Code");
		GenericMethods.enter_text(WorkersCompLocators.wc_phone2_txtb, ExcelReader.get_row_data_from_col("Phone_Prefix", row_num), "Phone Prefix");
		GenericMethods.enter_text(WorkersCompLocators.wc_phone3_txtb, ExcelReader.get_row_data_from_col("Phone Number", row_num), "Phone Number");
		//GenericMethods.enter_text(WorkersCompLocators.wc_fein_txtb, ExcelReader.get_row_data_from_col("Federal Employer ID No", row_num), "FEIN Number");
		WorkersCompLocators.wc_fein_txtb.sendKeys(GenericMethods.generate_random_integer(900000000, 100000000));
		GenericMethods.scroll_down();
		//GenericMethods.click_Element_Using_JS(WorkersCompLocators.wc_classification1_drpdwn);
		//=================================================================================
		WorkersCompLocators.wc_classification1.sendKeys(ExcelReader.get_row_data_from_col("Classification1_code", row_num));
		WaitMethods.wait_for_elements_present(WorkersCompLocators.wc_classification_list);WaitMethods.wait_in_seconds(5);
		GenericMethods.bootstrap_dropdown(WorkersCompLocators.wc_classification_list, ExcelReader.get_row_data_from_col("CLASSIFICATION1", row_num));
		//=====================================================================================
		
		GenericMethods.enter_text(WorkersCompLocators.wc_payroll0_txtb, ExcelReader.get_row_data_from_col("PAYROLL1", row_num), "Classification for Payroll1");
		GenericMethods.enter_text(WorkersCompLocators.wc_fulltimeemp0_txtb, ExcelReader.get_row_data_from_col("Number of Full Time Employees1", row_num), "Full time employee text box for Classification1");
		GenericMethods.enter_text(WorkersCompLocators.wc_parttimeemp0_txtb, ExcelReader.get_row_data_from_col("Number of Part Time Employees1", row_num), "Part time employee text box for Classification1");
		//GenericMethods.click_Element_Using_JS(WorkersCompLocators.wc_classification2_drpdwn);
		WorkersCompLocators.wc_classification2.sendKeys(ExcelReader.get_row_data_from_col("Classification2_code", row_num));
		WaitMethods.wait_for_elements_present(WorkersCompLocators.wc_classification_list);WaitMethods.wait_in_seconds(5);
		GenericMethods.bootstrap_dropdown(WorkersCompLocators.wc_classification_list, ExcelReader.get_row_data_from_col("CLASSIFICATION2", row_num));
		GenericMethods.enter_text(WorkersCompLocators.wc_payroll1_txtb, ExcelReader.get_row_data_from_col("PAYROLL2", row_num), "Classification for Payroll2");
		GenericMethods.enter_text(WorkersCompLocators.wc_fulltimeemp1_txtb, ExcelReader.get_row_data_from_col("Number of Full Time Employees2", row_num), "Full time employee text box for Classification2");
		GenericMethods.enter_text(WorkersCompLocators.wc_parttimeemp1_txtb, ExcelReader.get_row_data_from_col("Number of Part Time Employees2", row_num), "Part time employee text box for Classification2");
		GenericMethods.click_Element_Using_JS(WorkersCompLocators.wc_blanket_chkb);
		GenericMethods.click_Element_Using_JS(WorkersCompLocators.wc_rateit_btn);
	}

	/*
	 * Purpose: This method is used fill Victory Workers Comp Eligibility Information
	 * @param integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void fill_wc_eligibility_info() throws InterruptedException
	{
		//WC fill GENRAL QUESTIONS
		WaitMethods.wait_for_element_present(WorkersCompLocators.wc_ca_eleq1_rbtn);
		GenericMethods.click_Element_Using_JS(WorkersCompLocators.wc_ca_eleq1_rbtn);
		GenericMethods.click_Element_Using_JS(WorkersCompLocators.wc_ca_eleq2_rbtn);
		GenericMethods.click_Element_Using_JS(WorkersCompLocators.wc_ca_eleq3_rbtn);

		/*//WC fill Classification2 GENRAL QUESTIONS
		GenericMethods.click_Element_Using_JS(WorkersCompLocators.wc_ca_eleq1_0005_rbtn);
		GenericMethods.click_Element_Using_JS(WorkersCompLocators.wc_ca_eleq2_0005_rbtn);
		GenericMethods.click_Element_Using_JS(WorkersCompLocators.wc_ca_eleq3_0005_rbtn);
		GenericMethods.click_Element_Using_JS(WorkersCompLocators.wc_ca_eleq4_0005_rbtn);
		GenericMethods.click_Element_Using_JS(WorkersCompLocators.wc_ca_eleq5_0005_rbtn);
		GenericMethods.click_Element_Using_JS(WorkersCompLocators.wc_ca_eleq6_0005_rbtn);
		GenericMethods.click_Element_Using_JS(WorkersCompLocators.wc_ca_eleq7_0005_rbtn);
		 */
		//WC fill Classification1 GENRAL QUESTIONS
		GenericMethods.click_Element_Using_JS(WorkersCompLocators.wc_ca_eleq1_0035_rbtn);

		GenericMethods.click_Element_Using_JS(WorkersCompLocators.wc_elgques_continue_btn);		
	}

	/*
	 * Purpose: This method is used fill Victory Workers Comp Price Indicator Information
	 * @param integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void fill_wc_priceIndicator_info() throws InterruptedException
	{
		WaitMethods.wait_for_element_present(WorkersCompLocators.wc_priceindicator_nxt_btn);
		GenericMethods.click_Element_Using_JS(WorkersCompLocators.wc_priceindicator_nxt_btn);
	}

	/*
	 * Purpose: This method is used fill Victory Workers Comp application Information
	 * @param integer (Row_number of Excel sheet)
	 * @return NA
	 */
	public static void fill_wc_application_info(int row_num) throws InterruptedException, IOException
	{
		ExcelReader.set_excel_file(Locations.regression_dataFilePath, "VWC_Application_Info");
		WaitMethods.wait_for_element_present(WorkersCompLocators.wc_appLicenceNumber_txtb);
		GenericMethods.enter_text(WorkersCompLocators.wc_appLicenceNumber_txtb, ExcelReader.get_row_data_from_col("License Number", row_num), "Licence Number");
		GenericMethods.enter_text(WorkersCompLocators.wc_appwebsite_txtb, ExcelReader.get_row_data_from_col("Website", row_num), "Website");
		GenericMethods.click_Element_Using_JS(WorkersCompLocators.wc_samemailingadd_chkb);
		GenericMethods.enter_text(WorkersCompLocators.wc_contactFirstName_txtb, ExcelReader.get_row_data_from_col("Contact FirstName", row_num), "First Name of Contact");
		GenericMethods.enter_text(WorkersCompLocators.wc_contactLastName_txtb, ExcelReader.get_row_data_from_col("Contact LastName", row_num), "last Name of Contact");
		GenericMethods.select_from_dropdown(WorkersCompLocators.wc_typebusiness_drpdwn, "visibletext", ExcelReader.get_row_data_from_col("Type of Business", row_num));
		GenericMethods.select_from_dropdown(WorkersCompLocators.wc_yearbusiness_drpdwn, "visibletext", ExcelReader.get_row_data_from_col("Number of Years in Business", row_num));
		GenericMethods.enter_text(WorkersCompLocators.wc_ownername0_txtb, ExcelReader.get_row_data_from_col("Owner Name", row_num), "Owner Name");
		GenericMethods.enter_text(WorkersCompLocators.wc_ownertitle0_txtb, ExcelReader.get_row_data_from_col("Title/Relationship", row_num), "Title/Relationship");
		GenericMethods.enter_text(WorkersCompLocators.wc_ownerpercent0_txtb, ExcelReader.get_row_data_from_col("Title/Relationship", row_num), "Ownership_Percentage");
		GenericMethods.enter_text(WorkersCompLocators.wc_ownerpercent0_txtb, ExcelReader.get_row_data_from_col("Ownership_Percentage", row_num), "Ownership Percentage");
		GenericMethods.click_Element_Using_JS(WorkersCompLocators.wc_noinsurancecoverage_chkb);
		GenericMethods.enter_text(WorkersCompLocators.wc_description_txtb, ExcelReader.get_row_data_from_col("Description of Operations", row_num), "Description of Operations");
		GenericMethods.enter_text(WorkersCompLocators.wc_comments_txtb, ExcelReader.get_row_data_from_col("Comments", row_num), "Comments");
		GenericMethods.click_Element_Using_JS(WorkersCompLocators.wc_submit_to_underwriting_btn);
		WaitMethods.wait_in_seconds(20);
	}

	/*
	 * Purpose: This method is used to click on a Workers Comp Submission submission
	 * @param (String submission id, string status to be changed, int Row_number of Excel sheet)
	 * @return NA
	 */
	public static void click_wc_submission(String submission_id, int row_num) throws IOException, InterruptedException
	{
		load_data();
		ExcelReader.set_excel_file(Locations.regression_dataFilePath, "VWC_Rating_Info");
		WaitMethods.wait_in_seconds(5);
		AdminSubmissionPageLocators.submission_id_searchfield.clear();
		AdminSubmissionPageLocators.submission_id_searchfield.sendKeys(ExcelReader.get_row_data_from_col(submission_id, row_num));
		WaitMethods.wait_in_seconds(5);
		WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.search_button);
		GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.search_button);
		WaitMethods.wait_in_seconds(5);		
		WaitMethods.wait_in_seconds(3);
		WaitMethods.wait_for_element_present(AdminSubmissionPageLocators.submission_table_row);
		GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.submission_table_row);
		GenericMethods.click_Element_Using_JS(AdminSubmissionPageLocators.reviewSubmission_link);
		WaitMethods.wait_in_seconds(5);

	}

	/*
	 * Purpose: This method is used to change the status of a submission
	 * @param (String submission id, string status to be changed, int Row_number of Excel sheet)
	 * @return NA
	 */
	public static void wc_change_status(String submission_id,String status_tobe_changed, int row_num) throws InterruptedException, IOException
	{
		try
		{
			GenericMethods.click_Element_Using_JS(DefaultBrokerFeeLocators.changestatus_link);
			GenericMethods.navigate_to_next_window();
			WaitMethods.wait_in_seconds(3);

			//ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "QAA_Status");

			for(int i=0;i<WorkersCompLocators.changestatus_labels.size();i++)
			{
				String s=GenericMethods.get_text(WorkersCompLocators.changestatus_labels.get(i));
				int j=i+1;
				try
				{
					if(s.contains(ExcelReader.get_row_data_from_col(status_tobe_changed, row_num)))
					{
						driver.findElement(By.xpath("(//input[@name='radioStatus' and @type='radio'])[position()='"+j+"']")).click();
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
		//GenericMethods.click_Element_Using_JS(DefaultBrokerFeeLocators.changestatus_cancelbutton);
	}

	/*
	 * Purpose: This method is used to compare the values in carrier dropdown after changing status to sold in binding doc
	 * @param NA
	 * @return NA
	 */
	public static void select_a_state(int row_num) throws IOException
	{
		load_data();
		ExcelReader.set_excel_file(Locations.regression_dataFilePath,"VWC_Rating_Info");
		GenericMethods.select_from_dropdown(WorkersCompLocators.filterByState_drpdwn, "visibletext", ExcelReader.get_row_data_from_col("State", row_num));
	}

	/*
	 * Purpose: This method is used to select a state
	 * @param NA
	 * @return NA
	 */
	public static void verify_value_in_carrierdrpdwn(String text)
	{
		Assert.assertEquals(GenericMethods.compare_value_from_dropdown(WorkersCompLocators.selectCarrier_drpdwn, text), true);
	}

	/*
	 * Purpose: This method is used to verify the Workers Comp availability for different states
	 * @param NA
	 * @return NA
	 */
	public static void verify_tough_comp_availability() throws IOException, Exception
	{
		String[] state ={ "NV", "AZ", "CO", "NM", "TX", "OK", "LA", "MS", "TN","AL", "GA", "IL", "WI", "SC", "NC", "VA", "MD", "PA", "NJ", "NY", "DE","CA", "NY" , "FL","AR"};

		for (String item : state) 
		{
			Select s= new Select(WorkersCompLocators.filterByState_drpdwn);
			s.selectByVisibleText(item);
			WaitMethods.wait_in_seconds(2);
			WaitMethods.wait_for_element_present(WorkersCompLocators.workerscomp_tab);
			GenericMethods.click_Element_Using_JS(WorkersCompLocators.workerscomp_tab);
			if(WorkersCompLocators.toughcomp_integreted_uw.isDisplayed())
			{
				log.info("WorkersComp_ToughCompIntegratedUW is PRESENT for- " +item);
			}
			else
			{
				log.info("WorkersComp_ToughCompIntegratedUW is NOT PRESENT for- " +item);
			}
		}

	}

	/*
	 * Purpose: This method is used to verify the Workers Comp shift pixy availability
	 * @param NA
	 * @return NA
	 */
	public static void verify_wc_shiftpixy_availability() throws IOException, Exception
	{ 	
		String[] state ={"CA","NY","FL","AR"};

		for (String item : state) 
		{
			Select s= new Select(WorkersCompLocators.filterByState_drpdwn);
			s.selectByVisibleText(item);
			WaitMethods.wait_in_seconds(2);
			WaitMethods.wait_for_element_present(WorkersCompLocators.workerscomp_tab);
			GenericMethods.click_Element_Using_JS(WorkersCompLocators.workerscomp_tab);
			if(WorkersCompLocators.shiftPixy_wc_link.isDisplayed())
			{
				log.info("Workers Comp Shift Pixy PRESENT for- " +item);
			}
			else
			{
				log.info("Workers Comp Workers Comp Shift Pixy NOT PRESENT for- " +item);
			}
		}
	}

	/*
	 * Purpose: This method is used test ZIP code field Invalid data
	 * @param NA
	 * @return NA
	 */
	public static void verify_Wc_zipcode()
	{
		String expected_url="https://devao.amtrustgroup.com/ANANexus_UserTest/Questions.aspx";
		String actual_url=driver.getCurrentUrl();
		if(expected_url.equals(actual_url))
		{
			log.info("========================>Submission accepted with Invalid Zip Code<====================");
		}
		else
		{
			log.info("========================>Unable to proceed further please check the information<========================");
		}
	}


	/*
	 * get class codes List based on Stat
	 */
	public static void get_listClassCode_State(int row_num) throws IOException, InterruptedException
	{
		ExcelReader.set_excel_file(Locations.regression_dataFilePath, "VWC_Rating_Info");
		WaitMethods.wait_for_element_present(WorkersCompLocators.wc_application_quote_number);
		String wc_submission_id=GenericMethods.retrive_substring(":", WorkersCompLocators.wc_application_quote_number.getText());		
		ExcelReader.set_cell_data("WC_Submission_Id", row_num, wc_submission_id);
		GenericMethods.enter_text(WorkersCompLocators.wc_applicatnName_txtb, ExcelReader.get_row_data_from_col("Applicant Name", row_num), "Applicant Name");
		GenericMethods.enter_text(WorkersCompLocators.wc_dba_txtb, ExcelReader.get_row_data_from_col("DBA Name", row_num), "DBA Name");
		WorkersCompLocators.wc_effectivedate.sendKeys(GenericMethods.update_current_date("MM/dd/yyyy", 0, 0, 1, 0, 0, 0));
		//WorkersCompLocators.wc_effectivedate.sendKeys(GenericMethods.update_custom_date("MM/dd/YYYY", GenericMethods.get_current_date(), 1));
		//GenericMethods.select_from_dropdown(WorkersCompLocators.wc_currentlapse_drpdwn, "visibletext", ExcelReader.get_row_data_from_col("Current Lapse in Coverage", row_num));
		GenericMethods.enter_text(WorkersCompLocators.wc_address_txtb, ExcelReader.get_row_data_from_col("Address", row_num), "Address");
		GenericMethods.enter_text(WorkersCompLocators.wc_city_txtb, ExcelReader.get_row_data_from_col("City", row_num), "City");
		GenericMethods.select_from_dropdown(WorkersCompLocators.wc_state_drpdwn, "visibletext", ExcelReader.get_row_data_from_col("State", row_num));
		GenericMethods.enter_text(WorkersCompLocators.wc_zip_txtb, ExcelReader.get_row_data_from_col("Zip Code", row_num), "Zip Code");
		GenericMethods.enter_text(WorkersCompLocators.wc_phone1_txtb, ExcelReader.get_row_data_from_col("Phone_AreaCode", row_num), "Phone Area Code");
		GenericMethods.enter_text(WorkersCompLocators.wc_phone2_txtb, ExcelReader.get_row_data_from_col("Phone_Prefix", row_num), "Phone Prefix");
		GenericMethods.enter_text(WorkersCompLocators.wc_phone3_txtb, ExcelReader.get_row_data_from_col("Phone Number", row_num), "Phone Number");
		//GenericMethods.enter_text(WorkersCompLocators.wc_fein_txtb, ExcelReader.get_row_data_from_col("Federal Employer ID No", row_num), "FEIN Number");
		WorkersCompLocators.wc_fein_txtb.sendKeys(GenericMethods.generate_random_integer(900000000, 100000000));
		GenericMethods.scroll_down();

		ExcelReader.set_excel_file(Locations.regression_dataFilePath, "ListClassCodes");

		String[] state ={ "AL", "AR", "AZ", "CA", "CO", "CT", "DC", "DE", "FL","GA", "HI", "IA", "ID", "IN", "IL", "KS", "KY", "LA", "MA", "MD", "ME","MI", "MN" , "MO","MS", "MT", "NC", "NE", "NH", "NJ","NM", "NV" , "OK","OR", "PA", "RI", "SD", "TN", "TX","UT", "VA" , "VT","WI", "WV"};
		
		for (String item : state) 
		{
			Select st= new Select(WorkersCompLocators.wc_state0_drpdwn);
			st.selectByVisibleText(item);
			WaitMethods.wait_in_seconds(2);
			//String stateName=GenericMethods.get_selected_optn_frm_ele(WorkersCompLocators.wc_state0_drpdwn);
			//ExcelReader.set_cell_data("stateNames", row_num, stateName);

			GenericMethods.click_Element_Using_JS(WorkersCompLocators.wc_classification1_drpdwn);WaitMethods.wait_in_seconds(2);
			WaitMethods.wait_for_elements_present(WorkersCompLocators.wc_classCode_List);

			int count=WorkersCompLocators.wc_classCode_List.size();
			log.info(count);

			List<WebElement> list=  WorkersCompLocators.wc_classCode_List;

			for (WebElement ele : list)
			{
				// for every elements it will print the name using innerHTML
				System.out.println(ele.getAttribute("innerHTML"));
				//String 	codeList=ele.getAttribute("innerHTML");
				//ExcelReader.set_cell_data("ClassCodeNames", row_num, codeList);
			}
		}
	}
}
