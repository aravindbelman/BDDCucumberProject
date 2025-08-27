package com.LegacyApplication.RegressionIssues;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageMethods.BuildersRiskMethods;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.ProductionTickets.TC032_VerifyGABRUpdateReferralCountiesAndLogic;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})
public class TC053_VerifyUnderwriterChecklistError_GABR extends TestBase {
	
public static final Logger log= Logger.getLogger(TC053_VerifyUnderwriterChecklistError_GABR.class.getName());
	
	@Test
	public static void verify_GABR_UnderWriterCheckListError_fromAdmin()throws InterruptedException, AWTException, IOException
	{
		initialize_agency_environment("environment", "chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();	
		BuildersRiskMethods.click_buildersrisk_program();
		BuildersRiskMethods.fill_br_rating_info(1);
		
		WaitMethods.wait_in_seconds(5);
		WaitMethods.wait_for_page_load(10);
		GenericMethods.navigate_to_url(OR.getProperty("Admin_Url"));
		WaitMethods.wait_for_page_load(5);
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_admin();
		
		BuildersRiskMethods.click_edit_or_finish_submission_link("BR_Submission_Id", 1);
		BuildersRiskMethods.fill_br_application_info(1);
		WaitMethods.wait_in_seconds(5);
		BuildersRiskMethods.clickon_finalReviewSubmit_toSubmitSubmission();
		
		WaitMethods.wait_in_seconds(5);
		WaitMethods.wait_for_page_load(5);
		GenericMethods.navigate_to_url(OR.getProperty("Admin_Url"));
		WaitMethods.wait_for_page_load(5);
				
		BuildersRiskMethods.click_UnderwriterChecklist_link("BR_Submission_Id",1);
		
	}

}
