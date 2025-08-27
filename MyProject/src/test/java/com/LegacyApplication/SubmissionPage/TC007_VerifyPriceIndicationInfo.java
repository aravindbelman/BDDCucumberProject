package com.LegacyApplication.SubmissionPage;

import java.awt.AWTException;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.LegacyApplication.PageMethods.AdminSubmissionPageMethods;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.PageMethods.SubmissionPageMethods;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageLocators.SubmissionPageLocators;

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.RetryListner.class, com.LegacyApplication.CustomListner.Listner.class})
public class TC007_VerifyPriceIndicationInfo extends TestBase {

	public static final Logger log=Logger.getLogger(TC007_VerifyPriceIndicationInfo.class.getName());

    @Test (priority=1, enabled=false)
	public void verify_priceindicator_information() throws InterruptedException, IOException, AWTException
	{
		log.info("<===========Started verifying price indicator information Test===========> ");
		// Getting error unable to retrieve data while executing through TestNG
		initialize_chrome("Agency_Url");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		SubmissionPageMethods.search_by_option("Renewal Submission Id",1);
		SubmissionPageMethods.view_submission_details();
		GenericMethods.click_Element_Using_JS(SubmissionPageLocators.btn_General_Liability);
		SubmissionPageMethods.verify_price_indicator_elements(1);

		log.info("<===========Ended verifying price indicator information Test===========> ");	

	}
    
    @Test (priority=2)
	public void verify_admin_priceindicator_information() throws InterruptedException, IOException, AWTException
	{
		log.info("<===========Started verifying Admin price indicator information Test===========> ");
		
		initialize_chrome("Admin_Url");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_admin();
		AdminSubmissionPageMethods.search_submissionid("Renewal Submission Id",1);
		SubmissionPageMethods.view_submission_details();
		SubmissionPageMethods.verify_price_indicator_elements(2);

		log.info("<===========Ended verifying Admin price indicator information Test===========> ");	

	}


}


