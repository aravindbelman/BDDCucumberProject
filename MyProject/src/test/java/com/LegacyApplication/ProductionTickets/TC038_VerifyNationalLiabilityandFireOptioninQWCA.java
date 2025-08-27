package com.LegacyApplication.ProductionTickets;

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
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})
public class TC038_VerifyNationalLiabilityandFireOptioninQWCA extends TestBase {
	
	public static final Logger log=Logger.getLogger(TC038_VerifyNationalLiabilityandFireOptioninQWCA.class.getName());
	
	@Test
	public static void verify_nationalLiability_and_fireOption() throws IOException, InterruptedException, AWTException
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
		
		WaitMethods.wait_in_seconds(5);
		WaitMethods.wait_for_page_load(10);
		GenericMethods.navigate_to_url(OR.getProperty("Admin_Url"));
		WaitMethods.wait_for_page_load(5);
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_admin();
		WorkersCompMethods.click_wc_submission("WC_Submission_Id", 1);
		GenericMethods.navigate_to_next_window();
		WaitMethods.wait_in_seconds(5);
		WorkersCompMethods.wc_change_status("WC_Submission_Id", "Status_Sold", 1);
		WorkersCompMethods.verify_value_in_carrierdrpdwn("National Liability and Fire");
	}

}
