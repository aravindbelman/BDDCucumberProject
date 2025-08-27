package com.LegacyApplication.SubmissionPage;

import java.awt.AWTException;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.LegacyApplication.PageMethods.AdminSubmissionPageMethods;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.PageMethods.SubmissionPageMethods;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.Locations.Locations;

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})
public class TC008_VerifyCommonEligibilityInfo extends TestBase {

	public static final Logger log=Logger.getLogger(TC008_VerifyCommonEligibilityInfo.class.getName());

    @Test (priority=1)
	public void verify_common_eligibility__information() throws IOException, AWTException, InterruptedException
	{
		log.info("<===========Started verifying common eligibility information Test===========> ");
		
		initialize_chrome("Agency_Url");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		SubmissionPageMethods.search_by_option("Renewal Submission Id",1);
		SubmissionPageMethods.view_submission_details();
		SubmissionPageMethods.verify_common_eligibility_elements(1);

		log.info("<===========Ended verifying common eligibility information Test===========> ");	

	}
    
    @Test (priority=2)
   	public void verify_Admin_common_eligibility_information() throws IOException, AWTException, InterruptedException
   	{
   		log.info("<===========Started verifying Admin common eligibility information Test===========> ");
   		
   		initialize_chrome("Admin_Url");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_admin();
		AdminSubmissionPageMethods.search_submissionid("Renewal Submission Id",1);
		SubmissionPageMethods.view_submission_details();
   		SubmissionPageMethods.verify_common_eligibility_elements(3);

   		log.info("<===========Ended verifying Admin common eligibility information Test===========> ");	

   	}

}