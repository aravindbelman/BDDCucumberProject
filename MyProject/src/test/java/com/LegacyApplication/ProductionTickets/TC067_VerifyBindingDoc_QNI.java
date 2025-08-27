package com.LegacyApplication.ProductionTickets;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.PageMethods.InlandMarineMethods;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;

public class TC067_VerifyBindingDoc_QNI extends TestBase 
{
	public static final Logger log=Logger.getLogger(TC067_VerifyBindingDoc_QNI.class.getName());
	
	@Test
	public static void verify_BinidingDocfor_QNI()throws Exception
	{
		initialize_agency_environment("environment", "chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		InlandMarineMethods.click_victoryInlandmarine_program();
		InlandMarineMethods.fill_InlandMarine_rating_info(1);
		InlandMarineMethods.fill_InlandMarine_application_info(1);
		
		WaitMethods.wait_in_seconds(5);
		WaitMethods.wait_for_page_load(10);
		GenericMethods.navigate_to_url(OR.getProperty("Admin_Url"));
		WaitMethods.wait_for_page_load(5);
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_admin();
		
		InlandMarineMethods.InlandMarine_change_status("QNI_Submission_Id","Status_OkToBind",1);
		WaitMethods.wait_in_seconds(1);
				
		InlandMarineMethods.click_QNI_bindingDoc_link("QNI_Submission_Id", 1);
		GenericMethods.close_all_browser_windows();
		WaitMethods.wait_in_seconds(5);
				
		initialize_agency_environment("environment", "chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();	
		
		InlandMarineMethods.click_QNI_bindingDoc_link("QNI_Submission_Id", 1);
		WaitMethods.wait_in_seconds(5);
	}

}
