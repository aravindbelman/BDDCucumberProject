package com.LegacyApplication.CreateSubmissions;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageMethods.AutoRenewalBrokerFeeMethods;
import com.LegacyApplication.PageMethods.GeneralLiabilityMethods;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})
public class TC036_CreateQESsubmission extends TestBase {
	
public static final Logger log= Logger.getLogger(TC036_CreateQESsubmission.class.getName());
	
	@Test
	public static void verify_running_outofpolicynumbers_QES() throws IOException, InterruptedException, AWTException
	{
		initialize_agency_environment("dev_environment", "chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		GeneralLiabilityMethods.select_GL();
		GeneralLiabilityMethods.gl_MarketPalce(1);
		AutoRenewalBrokerFeeMethods.fill_comparative_rater_info(4);
		AutoRenewalBrokerFeeMethods.fill_price_indicatorandeligibility_info(4);
		AutoRenewalBrokerFeeMethods.fill_application_info(1);	
		
		WaitMethods.wait_in_seconds(5);
		WaitMethods.wait_for_page_load(10);
		GenericMethods.navigate_to_url(OR.getProperty("Admin_Url"));
		WaitMethods.wait_for_page_load(5);
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_admin();
		AutoRenewalBrokerFeeMethods.save_ratingWorkSheet("new","Submission Id",4);
		GenericMethods.close_browser_window();
		AutoRenewalBrokerFeeMethods.change_status("Submission Id","Status_OkToBind",4);
		WaitMethods.wait_in_seconds(5);
		AutoRenewalBrokerFeeMethods.change_status("Submission Id","Status _Sold",4);
		WaitMethods.wait_in_seconds(5);
		
	}

}

