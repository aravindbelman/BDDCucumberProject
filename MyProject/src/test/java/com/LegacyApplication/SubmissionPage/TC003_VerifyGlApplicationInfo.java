package com.LegacyApplication.SubmissionPage;

import java.awt.AWTException;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.PageMethods.SubmissionPageMethods;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.InitializeElements.InitializeElements;

public class TC003_VerifyGlApplicationInfo extends TestBase  {

	public static final Logger log=Logger.getLogger(TC003_VerifyGlApplicationInfo.class.getName());

    @Test
	public void verify_GI_application_info() throws InterruptedException, IOException, AWTException
	{
		log.info("<===========Started Verify GI Application Info Test===========> ");
		
		init_agency();
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency();
		HomePageMethods.select_agency_contact();
		SubmissionPageMethods.search_by_option(OR.getProperty("unsoldsubmissionid"));
		SubmissionPageMethods.view_submission_details();
		SubmissionPageMethods.verify_submission_details_of_application_info();
		log.info("Data Matched Successfully");

		log.info("<===========Ended Verify GI Application Info Test===========> ");	

	}

	

}
