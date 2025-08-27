package com.LegacyApplication.PageMethods;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.LegacyApplication.ExcelReader.ExcelReader;
import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageLocators.AgencyMainMenuLocators;
import com.LegacyApplication.PageLocators.CommercialAutoLocators;
import com.LegacyApplication.PageLocators.GeneralLiabilityPageLocators;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;

public class AgencyPageMethods extends TestBase {
	public static final Logger log=Logger.getLogger(AutoRenewalBrokerFeeMethods.class.getName());
	public static JavascriptExecutor js;
	
	/*
	 * purpose:This method is click on the Marketing Heading
	 * @return NA
	*/
	public static void clickonMarketingLink()
	{   
		String agencylandingurl=driver.getCurrentUrl();
		GenericMethods.mouse_hover(AgencyMainMenuLocators.producertool_tab);
		GenericMethods.click_Element_Using_JS(AgencyMainMenuLocators.Marketing_heading_menu);
		try {
			if (driver.getCurrentUrl().contains(agencylandingurl)) {
				log.info("Taking to correct url");
			} else {
				log.info("Taking to wrong url");
			} 
		} catch (Exception e) 
		{
			System.out.println(e);
		}
	}
	
	/*
	 * purpose:This method is click on the Auto link form Forms & Action
	 * & validate Commerce West Auto Forms List - taking to PDF or Not 
	 * currently it is taking to wrong URL of main site except pdf link
	 * & it make Logout of the Application too
	 * @return NA
	*/
	 public static void formAndApplication_Auto_CommerceWestAutoFormsListLink()
	 {
		 GenericMethods.mouse_hover(AgencyMainMenuLocators.producertool_tab); 
		 GenericMethods.click_Element_Using_JS(AgencyMainMenuLocators.auto_link);
		 GenericMethods.click_Element_Using_JS(AgencyMainMenuLocators.commercewest_link);
		 try {
			if(driver.getCurrentUrl().contains(".pdf"))
		 {
			 log.info("Taking to correct url which shows PDF");
		 }else {
			 log.info("Taking to wrong url of Main site");
		 } 
		} catch (Exception e) {
			System.out.println(e);
		}
		 
	 }
	
	 /*
		 * purpose:This method is click on the InlandMarine link form Forms & Action
		 * & validate -Victory IM/Property Forms List - taking to PDF or Not 
		 * currently it is taking to wrong URL of main site except pdf link
		 * & it make Logout of the Application too
		 * @return NA
		*/
	 public static void formAndApplication_PropertyFormsList_Link()
	 {
		 GenericMethods.mouse_hover(AgencyMainMenuLocators.producertool_tab); 
		 GenericMethods.click_Element_Using_JS(AgencyMainMenuLocators.inlandmarine_link);
		 GenericMethods.click_Element_Using_JS(AgencyMainMenuLocators.victory_im_list_link);
		 try {
				if(driver.getCurrentUrl().contains(".pdf"))
			 {
				 log.info("Taking to correct url which shows PDF");
			 }else {
				 log.info("Taking to wrong url of Main site");
			 } 
			} catch (Exception e) {
				System.out.println(e);
			}
			 
	 }
	 
	 /*
		 * purpose:This method is click on LossRunRequest link from Underwriting service
		 * Direct click on submit button to verify unnecessary HTML text appear 
		 * Instead of showing Validation message
		 * @return NA
		*/
	 
	 public static void underwritingservices_lossrunRequest_Link()
	 { 
		 String htmlerrtext="<div class=\"alert text-danger\"><strong>Please correct your entries:</strong><br />- Policy Number is required.<br />- Applicant Name is               required.<br />- Loss Run Years Needed is required.</div> ";
		 GenericMethods.mouse_hover(AgencyMainMenuLocators.producertool_tab); 
		 GenericMethods.click_Element_Using_JS(AgencyMainMenuLocators.lossrun_link);
		 GenericMethods.click_Element_Using_JS(AgencyMainMenuLocators.submit_btn);
			 
	 }
	 
	 /*
		 * purpose:This method is click on LossRunRequest link from Underwriting service
		 * Verify click on submit It submit with Invalid Data
		 * @return NA
		*/
	 public static void underwritingservices_lossrunRequest_InvalidDataLink(int row_num) throws IOException, Exception
	 {	
		 String fail="Invalid Data :";
		 String pass="Thank you for contacting us. You'll hear back from us shortly.";
		 GenericMethods.mouse_hover(AgencyMainMenuLocators.producertool_tab); 
		 GenericMethods.click_Element_Using_JS(AgencyMainMenuLocators.lossrun_link);
		 ExcelReader.set_excel_file(Locations.tls_dataFilePath,"LossRun_Info");
		 WaitMethods.wait_in_seconds(5);
		 GenericMethods.enter_text(AgencyMainMenuLocators.policyno_txtb,ExcelReader.get_row_data_from_col("PolicyNumber", row_num), "Applicant Name");
		 GenericMethods.enter_text(AgencyMainMenuLocators.applicantname_txtb,ExcelReader.get_row_data_from_col("ApplicantName", row_num), "Applicant Name");
		 GenericMethods.enter_text(AgencyMainMenuLocators.dba_txtb,ExcelReader.get_row_data_from_col("DBA", row_num), "DBA");
		 GenericMethods.enter_text(AgencyMainMenuLocators.lossrunyr_txtb,ExcelReader.get_row_data_from_col("LossRunYearsNeeded", row_num), "Loss Run Years Needed");
		 GenericMethods.click_Element_Using_JS(AgencyMainMenuLocators.submit_btn);
		 //Assert.assertEquals(fail, AgencyMainMenuLocators.success_text.getText());
		 //Assert.assertEquals(pass, AgencyMainMenuLocators.success_text.getText());
		 try {
				if(AgencyMainMenuLocators.success_text.getText().contains("Thank you for contacting us"))
			 {
				 log.info("Successfully create Loss Run Request");
			 }else {
				 log.info("With Invalid Data Still Allow to create Loss run Request");
			 } 
			} catch (Exception e) {
				System.out.println(e);
			}
			 
		
	 }
	 
	 /*
	  * purpose:This method create QAA-Sold then using that Submission no.
	  * ProducersTool - AI request option-
	  * Incomplete status AI request Not allow to Edit that - Request again it give Error message.
	  * @return NA
	 */
	 
	
	 //Search method to search QAA for AI
	 public static void search_ai_request(int row_num)throws Exception
	 {	
		
		GenericMethods.mouse_hover(AgencyMainMenuLocators.producertool_tab); 
		GenericMethods.click_Element_Using_JS(AgencyMainMenuLocators.additional_insured_link);
		ExcelReader.set_excel_file(Locations.tls_dataFilePath,"AI_NO");
		WaitMethods.wait_in_seconds(5);
		GenericMethods.select_from_dropdown(AgencyMainMenuLocators.select_activesoldPolicy_drpdwn,"index",ExcelReader.get_row_data_from_col("SEARCH ACTIVE POLICY", row_num));
		ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath,"QCR_Info");
		String Submission_Id=ExcelReader.get_string_cell_data(1,1);
	    AgencyMainMenuLocators.serchtext_txtb.sendKeys(Submission_Id);
		GenericMethods.click_Element_Using_JS(AgencyMainMenuLocators.searchgo_btn);
		WaitMethods.wait_in_seconds(5);
	 }
	 //This method is to fill AI request form for Option - EQUIPMENT RENTAL/LEASE
	 public static void fill_AI_request_form(int row_num) throws Exception
	 {	
		
		ExcelReader.set_excel_file(Locations.tls_dataFilePath,"AI_formsection");
		WaitMethods.wait_in_seconds(5);
		GenericMethods.select_from_dropdown(AgencyMainMenuLocators.whois_additional_insured_drpdwn,"visibletext",ExcelReader.get_row_data_from_col("whois_additional_insured_drpdwn", row_num));
		GenericMethods.enter_text(AgencyMainMenuLocators.lessorname_textb,ExcelReader.get_row_data_from_col("Lessor Name",row_num),"Lessor Name");
		GenericMethods.enter_text(AgencyMainMenuLocators.additional_insued_names_txtb,ExcelReader.get_row_data_from_col("additional insured names comma txtb",row_num),"additional insured names comma txtb");
		GenericMethods.enter_text(AgencyMainMenuLocators.lessor_add_street_txtb,ExcelReader.get_row_data_from_col("Lessor street",row_num),"Lessor street");
		GenericMethods.enter_text(AgencyMainMenuLocators.lessor_add_city_txtb,ExcelReader.get_row_data_from_col("Lessor City",row_num),"Lessor City");
		GenericMethods.select_from_dropdown(AgencyMainMenuLocators.lessor_add_state_drpdwn,"visibletext",ExcelReader.get_row_data_from_col("Lessor state", row_num));
		GenericMethods.enter_text(AgencyMainMenuLocators.lessor_add_zipcode_txtb,ExcelReader.get_row_data_from_col("Lessor zip",row_num),"Lessor zip");
		GenericMethods.enter_text(AgencyMainMenuLocators.specialInstuctions_txtb,ExcelReader.get_row_data_from_col("special instructions",row_num),"special instructions");
		
		//GenericMethods.click_Element_Using_JS(AgencyMainMenuLocators.airequest_submit_btn);
	    //GenericMethods.click_Element_Using_JS(AgencyMainMenuLocators.save_finish_btn);
	    //GenericMethods.click_Element_Using_JS(AgencyMainMenuLocators.clearform_btn);
	    //GenericMethods.click_Element_Using_JS(AgencyMainMenuLocators.cancel_btn);
	 }
   
	 public static void requestAI_incomplete_Edit() throws Exception
	 {		 	
		   search_ai_request(1);									
		   // search_ai_request(row_num, submission_id);
		    GenericMethods.click_Element_Using_JS(AgencyMainMenuLocators.serachresult_table_soldstatus);
		    GenericMethods.click_Element_Using_JS(AgencyMainMenuLocators.requestscheduled_context_option);
		    
		    fill_AI_request_form(1);
		    GenericMethods.click_Element_Using_JS(AgencyMainMenuLocators.save_finish_btn);
		    
		    if(AgencyMainMenuLocators.success_alert_msg.getText().contains("has been saved."))
		    {
		    	log.info("Save & Finish letter created");
		    }else {
		    	log.info("Save & Finish letter Not created");
		    }
		    
		    search_ai_request(1);
		    
		    GenericMethods.click_Element_Using_JS(AgencyMainMenuLocators.serachresult_table_soldstatus);
		    GenericMethods.click_Element_Using_JS(AgencyMainMenuLocators.viewcurrentai_context_option);
		    GenericMethods.click_Element_Using_JS(AgencyMainMenuLocators.incomplete_ststus_option);
		    GenericMethods.click_Element_Using_JS(AgencyMainMenuLocators.editai_context_option);
		 
		    if(AgencyMainMenuLocators.warning_msg.getText().contains("We have caught an error with this particular request and our techincal staff has been notified"))
		    {
		    	log.info("Error message appear - Not allow to edit Incomplete status submission to make complete");
		    }else {
		    	log.info("Error Not occur you can chane Incomplete AI request to Complete state");
		    }
		    
	 }
		  
		    /*
			  * purpose:This method create to show AI request form can accept Invalid data
			  * submit final AI request with Invalid data
			  * @return NA
			 */ 
		public static void ai_form_with_invalid_data() throws Exception
		    {	
				search_ai_request(1);
		    	//search_ai_request(row_num, submission_id);
			    GenericMethods.click_Element_Using_JS(AgencyMainMenuLocators.serachresult_table_soldstatus);
			    GenericMethods.click_Element_Using_JS(AgencyMainMenuLocators.requestscheduled_context_option);
			    
			    fill_AI_request_form(1);
			    GenericMethods.click_Element_Using_JS(AgencyMainMenuLocators.airequest_submit_btn);
			    if(AgencyMainMenuLocators.success_alert_msg.getText().contains("has been submitted."))
			    {
			    	log.info("submit final AI request with Invalid data");
			    }else {
			    	log.info("It will Not accept Invalid data");
			    }
			    
		    }
		
		/*
		  * purpose:This method is to validate the affiliation changes while registering as producer
		  * submit final AI request with Invalid data
		  * @return NA
		 */ 
	public static void verify_affiliationChanges_producerRegistration() throws Exception
	{
		GenericMethods.click_Element_Using_JS(AgencyMainMenuLocators.register_producer_tab);
		
		List<String> expected_affiliations = new ArrayList<String>();
		expected_affiliations.add("AAA/ACG Insurance");
		expected_affiliations.add("Allied");
		expected_affiliations.add("ASNOA");
		expected_affiliations.add("Combined Agents Of America");
		expected_affiliations.add("Farmers");
		expected_affiliations.add("ISU");
		expected_affiliations.add("Georgia Agency Partners");
		expected_affiliations.add("Insurors Group");
		expected_affiliations.add("Iroquois");
		expected_affiliations.add("Nationwide");
		expected_affiliations.add("Pacwest Alliance");
		expected_affiliations.add("PIA");
		expected_affiliations.add("PIIB");
		expected_affiliations.add("Renaissance Alliance");
		expected_affiliations.add("Horizon Agency Systems");
		expected_affiliations.add("Secure Risk");
		expected_affiliations.add("Smart Choice");
		expected_affiliations.add("United Agencies");
		expected_affiliations.add("United Valley");
		System.out.println(expected_affiliations);
		
		List<String> actual_affiliations=new ArrayList<String>();
		WaitMethods.wait_for_elements_present(AgencyMainMenuLocators.affiliation_list);
		for(WebElement choice: AgencyMainMenuLocators.affiliation_list)
		{
			actual_affiliations.add(choice.getText());
		}
		
		try{
		    Assert.assertEquals(expected_affiliations, actual_affiliations);
		    System.out.println("Both the lists were matching and all the affiliations exists");
		    
		}catch(Throwable e){
		    System.err.println("Lists are not equal. "+e.getMessage());
		}
	}

		
		    
	 }
	 
	 
	 
	 
	 
	 
	 
	
	 
	
	
	

