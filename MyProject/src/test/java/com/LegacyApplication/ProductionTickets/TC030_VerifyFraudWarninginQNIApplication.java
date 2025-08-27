package com.LegacyApplication.ProductionTickets;
import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.PageMethods.InlandMarineMethods;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;


/*
 * Purpose: Create QNI submission & click on Binding doc & to verify Fradulent waring appear or Not
 */

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})
public class TC030_VerifyFraudWarninginQNIApplication extends TestBase {
	
	public static final Logger log= Logger.getLogger(TC030_VerifyFraudWarninginQNIApplication.class.getName());
	
	@Test
	public static void verify_fraud_warning_in_QNI() throws IOException, AWTException, InterruptedException
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
		
		InlandMarineMethods.click_QNI_bindingDoc_link("QNI_Submission_Id", 1);
		InlandMarineMethods.verify_fradulent_message(1);
	}

}
