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

public class TC071_VerifySubmissionStatus_AgencyBillAutoRenewalBetaCitizens_DirectBill extends TestBase {
	
	public static final Logger log=Logger.getLogger(TC071_VerifySubmissionStatus_AgencyBillAutoRenewalBetaCitizens_DirectBill.class.getName());
	
	@Test
	public void review_submissionStatus_SpecialAgency_DirectBill() throws Exception
	{
		log.info("<===========Started verifying submission status of special agency with Directbill as Payment Option Test===========> ");
		initialize_chrome("Agency_Url");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.GL_AR_TestData, "AR_Agency_Info","Agency_Username","Agency_Password",1);
		HomePageMethods.select_agency_contact();
		//AutoRenewalBrokerFeeMethods.setup_brokerfee("flat","same", 1);
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
		
		/*WaitMethods.wait_in_seconds(5);
		GenericMethods.navigate_to_url(OR.getProperty("Agency_Url"));
		WaitMethods.wait_in_seconds(5);
		InitializeElements.initialize_elements();
		WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.gotoSubmissions_button);
		AutoRenewalBrokerFeeLocators.gotoSubmissions_button.click();
		WaitMethods.wait_in_seconds(3);*/
		AutoRenewalBrokerFeeMethods.click_bindingDoc_link("Submission Id",1);
		GenericMethods.navigate_to_next_window();
		AutoRenewalBrokerFeeMethods.fill_bindingDoc_info("directbill",1);	
		/*GenericMethods.navigate_to_next_window();
		WaitMethods.wait_in_seconds(5);
	
		GenericMethods.navigate_to_url(OR.getProperty("Admin_Url"));*/
		AutoRenewalBrokerFeeMethods.change_status("Submission Id","Status _Sold",1);
		WaitMethods.wait_in_seconds(5);
		AutoRenewalBrokerFeeMethods.change_submission_renewal("Submission Id", 1);
		WaitMethods.wait_in_seconds(5);
		GenericMethods.close_browser_window();
		initialize_chrome("Admin_Url");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_admin();
		WaitMethods.wait_in_seconds(5);
	    AutoRenewalBrokerFeeMethods.verify_renewal_status("Renewal Submission Id", 1);
	    AutoRenewalBrokerFeeMethods.click_renewalLetter_link("Renewal Submission Id", 1);
	    //AutoRenewalBrokerFeeMethods.validate_nodefault_brokerFee("No Default BrokerFee Renewal Business", 1);
	    //GenericMethods.navigate_to_next_window();
	    AutoRenewalBrokerFeeMethods.verify_renewalLetter_paymentInfo("direct bill", 1);
	    AutoRenewalBrokerFeeMethods.verify_renewal_letter_info(1);
	    AutoRenewalBrokerFeeMethods.verify_important_renewalInfo(1);
	    AutoRenewalBrokerFeeMethods.verify_renewalLetter_paymentInfo("direct bill", 1);
	    WaitMethods.wait_in_seconds(2);
			
		log.info("<===========Completed verifying submission status of special agency with Directbill as Payment Option Test===========> ");
	
	}


}
