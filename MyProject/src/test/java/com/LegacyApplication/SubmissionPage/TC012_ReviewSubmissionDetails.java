package com.LegacyApplication.SubmissionPage;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.PageMethods.SubmissionPageMethods;
import com.LegacyApplication.TestBase.TestBase;

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})
public class TC012_ReviewSubmissionDetails extends TestBase {
	
	public static final Logger log=Logger.getLogger(TC012_ReviewSubmissionDetails.class.getName());
	
	@Test
	public void review_submission_details() throws InterruptedException, IOException, AWTException
	{
		log.info("<===========Started verifying review submission details Test===========> ");
		initialize_chrome("Agency_Url");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		SubmissionPageMethods.search_by_option("Renewal Submission Id",1);
		SubmissionPageMethods.verify_submisson_info(1,2);
		log.info("<===========Ended verifying review submission details Test===========> ");
	}

}
