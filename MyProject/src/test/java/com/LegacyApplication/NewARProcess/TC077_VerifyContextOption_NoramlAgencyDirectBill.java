package com.LegacyApplication.NewARProcess;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageMethods.AutoRenewalBrokerFeeMethods;
import com.LegacyApplication.PageMethods.GeneralLiabilityMethods;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;

public class TC077_VerifyContextOption_NoramlAgencyDirectBill extends TestBase {
	
	public static final Logger log=Logger.getLogger(TC077_VerifyContextOption_NoramlAgencyDirectBill.class.getName());
	
	
	@Test
	public void review_submissionStatus_NormalAgency_DirectBill() throws InterruptedException, IOException, AWTException
	{
		log.info("<===========Started verifying submission status of Normal Agency with Direct bill as payment option Test===========> ");
		initialize_chrome("Agency_Url");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.GL_AR_TestData, "AR_Agency_Info","Agency_Username","Agency_Password",4);
		HomePageMethods.select_agency_contact();
		GeneralLiabilityMethods.select_GL();
		GeneralLiabilityMethods.gl_MarketPalce(1);
		AutoRenewalBrokerFeeMethods.fill_comparative_rater_info(1);
		AutoRenewalBrokerFeeMethods.fill_price_indicatorandeligibility_info(1);
		AutoRenewalBrokerFeeMethods.fill_application_info(1);	
		
		WaitMethods.wait_in_seconds(5);
		WaitMethods.wait_for_page_load(10);
		GenericMethods.navigate_to_url(OR.getProperty("Admin_Url"));
		WaitMethods.wait_for_page_load(5);
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_admin();
		AutoRenewalBrokerFeeMethods.save_ratingWorkSheet("new","Submission Id",1);
		GenericMethods.close_browser_window();
		AutoRenewalBrokerFeeMethods.change_status("Submission Id","Status_OkToBind",1);
		WaitMethods.wait_in_seconds(5);
		
		AutoRenewalBrokerFeeMethods.click_bindingDoc_link("Submission Id",1);
		GenericMethods.navigate_to_next_window();
		AutoRenewalBrokerFeeMethods.fill_bindingDoc_info("directbill",1);	
		
		AutoRenewalBrokerFeeMethods.change_status("Submission Id","Status _Sold",1);
		WaitMethods.wait_in_seconds(3);
		AutoRenewalBrokerFeeMethods.change_submission_renewal("Submission Id", 1);
		WaitMethods.wait_in_seconds(5);
		GenericMethods.close_browser_window();
		initialize_chrome("Admin_Url");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_admin();
		WaitMethods.wait_in_seconds(5);   
	    AutoRenewalBrokerFeeMethods.Verify_ContextOption("Renewal Submission Id", 4);

	}
}
