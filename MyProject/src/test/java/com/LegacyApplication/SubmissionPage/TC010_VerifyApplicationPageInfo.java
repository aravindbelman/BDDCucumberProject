package com.LegacyApplication.SubmissionPage;

import java.awt.AWTException;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.PageMethods.SubmissionPageMethods;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.InitializeElements.InitializeElements;

public class TC010_VerifyApplicationPageInfo extends TestBase 
{
	public static final Logger log=Logger.getLogger(TC010_VerifyApplicationPageInfo.class.getName());


	@Test
	public void verify_application_page_information() throws IOException, AWTException, InterruptedException
	{
		log.info("<===========Started verifying application page information Test===========> ");

		init_agency();
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency();
		HomePageMethods.select_agency_contact();
		SubmissionPageMethods.search_by_option(OR.getProperty("unsoldsubmissionid"));
		SubmissionPageMethods.view_submission_details();
		SubmissionPageMethods.verify_application_page_info();

		log.info("                                                          ");  
		log.info("<===========Ended verifying application page information Test===========> ");	

	}

	
}
