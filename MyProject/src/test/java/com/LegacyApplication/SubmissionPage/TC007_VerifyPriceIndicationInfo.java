package com.LegacyApplication.SubmissionPage;

import java.awt.AWTException;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.PageMethods.SubmissionPageMethods;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.InitializeElements.InitializeElements;

public class TC007_VerifyPriceIndicationInfo extends TestBase {

	public static final Logger log=Logger.getLogger(TC007_VerifyPriceIndicationInfo.class.getName());

    @Test
	public void verify_priceindicator_information() throws InterruptedException, IOException, AWTException
	{
		log.info("<===========Started verifying price indicator information Test===========> ");
		
		init_agency();
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency();
		HomePageMethods.select_agency_contact();
		SubmissionPageMethods.search_by_option(OR.getProperty("unsoldsubmissionid"));
		SubmissionPageMethods.view_submission_details();
		SubmissionPageMethods.verify_price_indicator_elements();

		log.info("<===========Ended verifying price indicator information Test===========> ");	

	}


}


