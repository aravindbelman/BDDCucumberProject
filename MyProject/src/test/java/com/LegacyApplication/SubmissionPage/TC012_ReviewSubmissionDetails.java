package com.LegacyApplication.SubmissionPage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.PageMethods.SubmissionPageMethods;
import com.LegacyApplication.TestBase.TestBase;

public class TC012_ReviewSubmissionDetails extends TestBase {
	
	public static final Logger log=Logger.getLogger(TC012_ReviewSubmissionDetails.class.getName());
	
	@Test
	public void review_submission_details() throws InterruptedException, IOException
	{
		log.info("<===========Started verifying review submission details Test===========> ");
		init_agency();
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency();
		HomePageMethods.select_agency_contact();
		SubmissionPageMethods.search_by_option(OR.getProperty("unsoldsubmissionid"));
		SubmissionPageMethods.verify_submisson_info();
	}

}
