package com.LegacyApplication.SubmissionPage;

import java.awt.AWTException;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.PageMethods.SubmissionPageMethods;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.InitializeElements.InitializeElements;

public class TC008_VerifyCommonEligibilityInfo extends TestBase {

	public static final Logger log=Logger.getLogger(TC008_VerifyCommonEligibilityInfo.class.getName());

    @Test
	public void verify_common_eligibility__information() throws IOException, AWTException, InterruptedException
	{
		log.info("<===========Started verifying common eligibility information Test===========> ");
		
		init_agency();
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency();
		HomePageMethods.select_agency_contact();
		SubmissionPageMethods.search_by_option(OR.getProperty("unsoldsubmissionid"));
		SubmissionPageMethods.view_submission_details();
		SubmissionPageMethods.verify_common_eligibility_elements();

		log.info("<===========Ended verifying common eligibility information Test===========> ");	

	}

}