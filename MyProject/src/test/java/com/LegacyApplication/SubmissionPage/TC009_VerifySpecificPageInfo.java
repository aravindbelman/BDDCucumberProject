package com.LegacyApplication.SubmissionPage;

import java.awt.AWTException;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.PageMethods.SubmissionPageMethods;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.InitializeElements.InitializeElements;

public class TC009_VerifySpecificPageInfo extends TestBase {

	public static final Logger log=Logger.getLogger(TC009_VerifySpecificPageInfo.class.getName());

	@Test
	public void verify_specific_eligibility__information() throws IOException, AWTException, InterruptedException
	{
		log.info("<===========Started verifying specific eligibility information Test===========> ");
        
		init_agency();
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency();
		HomePageMethods.select_agency_contact();
		SubmissionPageMethods.search_by_option(OR.getProperty("unsoldsubmissionid"));
		SubmissionPageMethods.view_submission_details();
		SubmissionPageMethods.verify_specific_eligibility_elements();

		log.info("<===========Ended verifying specific eligibility information Test===========> ");	

	}

}



