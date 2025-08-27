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
public class TC006_VerifyOptionalCoverages extends TestBase {

	public static final Logger log=Logger.getLogger(TC006_VerifyOptionalCoverages.class.getName());

    @Test (priority=1)
	public void verify_optional_coverages() throws InterruptedException, IOException, AWTException
	{
		log.info("<===========Started verifying optional coverages Test===========> ");
		
		initialize_chrome("Agency_Url");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		SubmissionPageMethods.search_by_option("Renewal Submission Id",1);
		SubmissionPageMethods.view_submission_details();
		SubmissionPageMethods.verify_optional_coverage(1);

		log.info("<===========Ended verifying optional coverages Test===========> ");	

	}
    
    @Test (priority=2)
	public void verify_admin_optional_coverages() throws InterruptedException, IOException, AWTException
	{
		log.info("<===========Started verifying admin optional coverages Test===========> ");
		
		initialize_chrome("Admin_Url");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_admin();
		AdminSubmissionPageMethods.search_submissionid("Renewal Submission Id",1);
		SubmissionPageMethods.view_submission_details();
		SubmissionPageMethods.verify_optional_coverage(3);

		log.info("<===========Ended verifying admin optional coverages Test===========> ");	

	}


}
