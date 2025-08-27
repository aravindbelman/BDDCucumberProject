package com.LegacyApplication.CreateSubmissions;

import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageMethods.BondsMethods;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.WaitMethods;

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})
public class TC047_CreateVoctoryContactorBondsSubmission extends TestBase {
	
	public static final Logger log=Logger.getLogger(TC047_CreateVoctoryContactorBondsSubmission.class.getName());
	
	@Test
	public static void submit_victory_contractor_bonds() throws Throwable
	{	
		initialize_agency_environment("staging_environment", "chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();	
		BondsMethods.click_victory_contractor_bonds();
		BondsMethods.fill_VCB_rating_info(4,"OR");
		WaitMethods.wait_in_seconds(5);
		//BondsMethods.handle_Alert_and_refreshpage();
		//WaitMethods.wait_in_seconds(5);
		BondsMethods.comparatriverater_page_createsubmission();
		WaitMethods.wait_in_seconds(5);
		BondsMethods.priceIndicator();
		BondsMethods.confirmMailg();
		BondsMethods.finalReview();
		BondsMethods.bondIssuance();
		BondsMethods.agentAcknowledgement();
	}

}
