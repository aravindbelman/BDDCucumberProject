package com.LegacyApplication.SubmissionPage;

import java.awt.AWTException;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.LegacyApplication.PageLocators.SubmissionPageLocators;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.PageMethods.SubmissionPageMethods;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.Locations.Locations;

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})
public class TC011_VerifySubmissionDetailsInformation extends TestBase {

	public static final Logger log=Logger.getLogger(TC011_VerifySubmissionDetailsInformation.class.getName());

   @Test(priority=1)
	public void verify_sold_and_unsold_submission_details_information() throws IOException, AWTException, InterruptedException
	{
		log.info("<===========Started verifying un-sold submission details information Test===========> ");
		
		initialize_chrome("Agency_Url");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		SubmissionPageMethods.search_by_option("Renewal Submission Id",1);
		SubmissionPageMethods.verify_unsold_submission_details_info(1);

		log.info("                                                          ");  
		log.info("<===========Ended verifying submission details information Test===========> ");	
		
		log.info("<===========Started verifying un-sold submission details information Test===========> ");

		SubmissionPageLocators.search.clear();
		SubmissionPageMethods.search_by_option("Renewal Submission Id",1);
		SubmissionPageMethods.verify_sold_submission_details_info(2);

		log.info("                                                          ");  
		log.info("<===========Ended verifying sold submission details information Test===========> ");	

	}


}
