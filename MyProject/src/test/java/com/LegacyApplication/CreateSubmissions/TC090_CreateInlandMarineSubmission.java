package com.LegacyApplication.CreateSubmissions;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.PageMethods.InlandMarineMethods;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.WaitMethods;

public class TC090_CreateInlandMarineSubmission extends TestBase {
	
	public static final Logger log=Logger.getLogger(TC090_CreateInlandMarineSubmission.class.getName());
	
	@Test
	public static void create_QNI_Submission()throws Exception
	{
		initialize_agency_environment("dev_environment", "chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		InlandMarineMethods.click_victoryInlandmarine_program();
		InlandMarineMethods.fill_InlandMarine_rating_info(1);
		InlandMarineMethods.fill_InlandMarine_application_info(1);		
		WaitMethods.wait_in_seconds(5);
     }
}
