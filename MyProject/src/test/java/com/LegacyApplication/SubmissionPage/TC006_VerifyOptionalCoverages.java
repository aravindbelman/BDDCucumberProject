package com.LegacyApplication.SubmissionPage;

import java.awt.AWTException;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.PageMethods.SubmissionPageMethods;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.InitializeElements.InitializeElements;

public class TC006_VerifyOptionalCoverages extends TestBase {

	public static final Logger log=Logger.getLogger(TC006_VerifyOptionalCoverages.class.getName());

    @Test
	public void verify_optional_coverages() throws InterruptedException, IOException, AWTException
	{
		log.info("<===========Started verifying optional coverages Test===========> ");
		
		init_agency();
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency();
		HomePageMethods.select_agency_contact();
		SubmissionPageMethods.search_by_option(OR.getProperty("unsoldsubmissionid"));
		SubmissionPageMethods.view_submission_details();
		SubmissionPageMethods.verify_optional_coverage();

		log.info("<===========Ended verifying optional coverages Test===========> ");	

	}


}
