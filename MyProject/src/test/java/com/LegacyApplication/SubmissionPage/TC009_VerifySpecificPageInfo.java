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
public class TC009_VerifySpecificPageInfo extends TestBase {

	public static final Logger log=Logger.getLogger(TC009_VerifySpecificPageInfo.class.getName());

	@Test (priority=1, enabled=false)
	public void verify_specific_eligibility__information() throws IOException, AWTException, InterruptedException
	{
		log.info("<===========Started verifying specific eligibility information Test===========> ");
        
		initialize_chrome("Agency_Url");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		SubmissionPageMethods.search_by_option("Renewal Submission Id",1);
		SubmissionPageMethods.view_submission_details();
		SubmissionPageMethods.verify_specific_eligibility_elements(1);

		log.info("<===========Ended verifying specific eligibility information Test===========> ");	

	}
	
	 @Test (priority=2, enabled=true)
	   	public void verify_Admin_specific_eligibility__information() throws IOException, AWTException, InterruptedException
	   	{
	   		log.info("<===========Started verifying Admin specific eligibility information Test===========> ");
	   		
	   		initialize_chrome("Admin_Url");
			InitializeElements.initialize_elements();
			HomePageMethods.login_as_admin();
			AdminSubmissionPageMethods.search_submissionid("Renewal Submission Id",1);
			SubmissionPageMethods.view_submission_details();
	   		SubmissionPageMethods.verify_specific_eligibility_elements(3);

	   		log.info("<===========Ended verifying Admin specific eligibility information Test===========> ");	

	   	}

}



