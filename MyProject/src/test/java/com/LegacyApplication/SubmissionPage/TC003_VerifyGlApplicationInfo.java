package com.LegacyApplication.SubmissionPage;

import java.awt.AWTException;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.LegacyApplication.PageMethods.AdminSubmissionPageMethods;
import com.LegacyApplication.PageMethods.AutoRenewalBrokerFeeMethods;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.PageMethods.SubmissionPageMethods;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.Locations.Locations;

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})
public class TC003_VerifyGlApplicationInfo extends TestBase  {

	public static final Logger log=Logger.getLogger(TC003_VerifyGlApplicationInfo.class.getName());

    @Test (priority=1, enabled=true)
	public void verify_GI_application_info() throws InterruptedException, IOException, AWTException
	{
		log.info("<===========Started Verify GI Application Info Test===========> ");
		
		initialize_chrome("Agency_Url");
		InitializeElements.initialize_elements();
		AutoRenewalBrokerFeeMethods.select_agency(3);
		HomePageMethods.select_agency_contact(Locations.BrokerFeeDataFilePath, "Agency_Info", "Agency_Contact", 1);
		SubmissionPageMethods.search_by_option("Renewal Submission Id",1);
		SubmissionPageMethods.view_submission_details();
		SubmissionPageMethods.verify_submission_details_of_application_info(1);
		log.info("Data Matched Successfully");

		log.info("<===========Ended Verify GI Application Info Test===========> ");	

	}
    
    @Test (priority=2, enabled=true)
   	public void verify__admin_GI_application_info() throws InterruptedException, IOException, AWTException
   	{
   		log.info("<===========Started Verify GI Application Info Test===========> ");
   		
   		initialize_chrome("Admin_Url");
   		InitializeElements.initialize_elements();
   		HomePageMethods.login_as_admin();
   		AdminSubmissionPageMethods.search_submissionid("Renewal Submission Id",1);
   		SubmissionPageMethods.view_submission_details();
   		SubmissionPageMethods.verify_submission_details_of_application_info(1);
   		log.info("Data Matched Successfully");

   		log.info("<===========Ended Verify GI Application Info Test===========> ");	

   	}

	

}
