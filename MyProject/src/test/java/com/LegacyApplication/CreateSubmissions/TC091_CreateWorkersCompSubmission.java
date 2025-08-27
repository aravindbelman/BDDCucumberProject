package com.LegacyApplication.CreateSubmissions;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.PageMethods.WorkersCompMethods;
import com.LegacyApplication.TestBase.TestBase;

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})
public class TC091_CreateWorkersCompSubmission extends TestBase {

public static final Logger log=Logger.getLogger(TC091_CreateWorkersCompSubmission.class.getName());
	
	@Test
	public static void create_workerscomp_submission() throws IOException, InterruptedException, AWTException
	{
		initialize_agency_environment("environment", "chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		WorkersCompMethods.click_victory_workers_comp();
		WorkersCompMethods.fill_VWC_rating_info(1);
		WorkersCompMethods.fill_wc_eligibility_info();
		WorkersCompMethods.fill_wc_priceIndicator_info();
		WorkersCompMethods.fill_wc_application_info(1);
	}
	
	/*@Test
	public static void getClassCodesList() throws IOException, InterruptedException, AWTException
	{
		initialize_agency_environment("environment", "chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		WorkersCompMethods.click_victory_workers_comp();
		WorkersCompMethods.get_listClassCode_State(1);	
	}*/
}
