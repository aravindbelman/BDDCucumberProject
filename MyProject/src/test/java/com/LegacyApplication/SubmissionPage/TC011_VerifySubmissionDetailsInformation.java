package com.LegacyApplication.SubmissionPage;

import java.awt.AWTException;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.LegacyApplication.PageLocators.SubmissionPageLocators;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.PageMethods.SubmissionPageMethods;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.InitializeElements.InitializeElements;


public class TC011_VerifySubmissionDetailsInformation extends TestBase {

	public static final Logger log=Logger.getLogger(TC011_VerifySubmissionDetailsInformation.class.getName());

   @Test(priority=1)
	public void verify_unsold_submission_details_information() throws IOException, AWTException, InterruptedException
	{
		log.info("<===========Started verifying un-sold submission details information Test===========> ");
		
		init_agency();
		InitializeElements.initialize_elements();
        HomePageMethods.login_as_agency();
		HomePageMethods.select_agency_contact();
		SubmissionPageMethods.search_by_option(OR.getProperty("unsoldsubmissionid"));
		SubmissionPageMethods.verify_unsold_submission_details_info();

		log.info("                                                          ");  
		log.info("<===========Ended verifying submission details information Test===========> ");	

	}

	@Test(priority=2)
	public void verify_sold_submission_details_information() throws IOException, AWTException, InterruptedException
	{
		log.info("<===========Started verifying un-sold submission details information Test===========> ");

		SubmissionPageLocators.search.clear();
		SubmissionPageMethods.search_by_option(OR.getProperty("soldsubmissionid"));
		SubmissionPageMethods.verify_sold_submission_details_info();

		log.info("                                                          ");  
		log.info("<===========Ended verifying sold submission details information Test===========> ");	

	}


}
