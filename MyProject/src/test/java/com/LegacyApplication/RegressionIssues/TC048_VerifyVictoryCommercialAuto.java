package com.LegacyApplication.RegressionIssues;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageMethods.AutoRenewalBrokerFeeMethods;
import com.LegacyApplication.PageMethods.CommercialAutoMethods;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})
public class TC048_VerifyVictoryCommercialAuto extends TestBase {

	public static final Logger log=Logger.getLogger(TC048_VerifyVictoryCommercialAuto.class.getName());
	
	@Test
	public static void createQCA()throws IOException, AWTException, InterruptedException
	{
		initialize_agency_environment("environment", "chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		CommercialAutoMethods.click_victory_auto_comp();
		CommercialAutoMethods.fill_VCA_rating_info(1);
		CommercialAutoMethods.eligibilityQuestions();
		CommercialAutoMethods.fill_ca_application_info(1);
		WaitMethods.wait_in_seconds(3);
		GenericMethods.navigate_to_url(OR.getProperty("Admin_Url"));
		WaitMethods.wait_for_page_load(5);
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_admin();
		CommercialAutoMethods.commerciAuto_change_status("CA_Submission_Id","Status_OkToBind",1);
		WaitMethods.wait_in_seconds(3);
		CommercialAutoMethods.commerciAuto_change_status("CA_Submission_Id","Status _Sold",1);
			
	}
}
