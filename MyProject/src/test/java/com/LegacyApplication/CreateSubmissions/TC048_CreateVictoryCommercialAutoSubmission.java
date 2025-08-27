package com.LegacyApplication.CreateSubmissions;

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
public class TC048_CreateVictoryCommercialAutoSubmission extends TestBase {

	public static final Logger log=Logger.getLogger(TC048_CreateVictoryCommercialAutoSubmission.class.getName());
	
	@Test
	public static void create_VictoryCommercialAuto()throws IOException, AWTException, InterruptedException
	{
		initialize_agency_environment("dev_environment", "firefox_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		CommercialAutoMethods.click_victory_auto_comp();
		CommercialAutoMethods.fill_VCA_rating_info(1);
		CommercialAutoMethods.eligibilityQuestions();
		CommercialAutoMethods.fill_ca_application_info(1);
		WaitMethods.wait_in_seconds(3);			
	}
}
