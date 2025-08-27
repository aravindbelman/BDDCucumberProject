package com.LegacyApplication.AutoRenewBrokerFee;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageLocators.AutoRenewalBrokerFeeLocators;
import com.LegacyApplication.PageMethods.AutoRenewalBrokerFeeMethods;
import com.LegacyApplication.PageMethods.GeneralLiabilityMethods;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})
public class TC020_ValidateDifferentPercentageBrokerFeeForNewandRenewal extends TestBase {
	
	public static final Logger log=Logger.getLogger(TC020_ValidateDifferentPercentageBrokerFeeForNewandRenewal.class.getName());

	@Test
	public void setup_percentage_brokerfee() throws IOException, InterruptedException, AWTException
	{
		initialize_chrome("Agency_Url");
		InitializeElements.initialize_elements();
		AutoRenewalBrokerFeeMethods.select_agency(3);
		HomePageMethods.select_agency_contact();
		AutoRenewalBrokerFeeMethods.setup_brokerfee("percentage","different", 1);	
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
		GenericMethods.navigate_to_url(OR.getProperty("Agency_Url"));
		WaitMethods.wait_in_seconds(5);
		InitializeElements.initialize_elements();
		WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.gotoSubmissions_button);
		AutoRenewalBrokerFeeLocators.gotoSubmissions_button.click();
		WaitMethods.wait_in_seconds(3);
		AutoRenewalBrokerFeeMethods.click_bindingDoc_link("Submission Id",1);
		AutoRenewalBrokerFeeMethods.validate_percentage_brokerFee("new",1);
		AutoRenewalBrokerFeeMethods.update_brokerFee_value("percentage", "new", 1);
		AutoRenewalBrokerFeeMethods.verify_payment_option(3);
		AutoRenewalBrokerFeeMethods.fill_bindingDoc_info("AgencyFinance",1);
		AutoRenewalBrokerFeeMethods.verify_updated_brokerfee("Submission Id","Updated Percentage Broker Fee for New Business", 1);
		AutoRenewalBrokerFeeMethods.verify_payment_option(3);
		WaitMethods.wait_in_seconds(5);
		
		GenericMethods.navigate_to_url(OR.getProperty("Admin_Url"));
		AutoRenewalBrokerFeeMethods.change_status("Submission Id","Status _Sold",1);
		AutoRenewalBrokerFeeMethods.change_submission_renewal("Submission Id", 1);
		WaitMethods.wait_in_seconds(5);
		GenericMethods.navigate_browser("back");
		WaitMethods.wait_in_seconds(5);
		AutoRenewalBrokerFeeMethods.save_ratingWorkSheet("renewal", "Renewal Submission Id", 1);
		GenericMethods.close_browser_window();
		AutoRenewalBrokerFeeMethods.click_renewalLetter_link("Renewal Submission Id", 1);
		AutoRenewalBrokerFeeMethods.validate_percentage_brokerFee("renewal", 1);
		
		///////////////////////////////
		/*AutoRenewalBrokerFeeMethods.verify_renewalLetter_paymentInfo("agency finance", 1);
		GenericMethods.close_browser_window();
		AutoRenewalBrokerFeeMethods.click_renewalInfo_link("Renewal Submission Id", 1);*/
		
		AutoRenewalBrokerFeeMethods.verify_payment_option(3);
		AutoRenewalBrokerFeeMethods.validate_percentage_brokerFee("Renewal", 1);
		WaitMethods.wait_in_seconds(3);	
		GenericMethods.close_browser_window();
		AutoRenewalBrokerFeeMethods.change_status("Renewal Submission Id","Status_OkToBind",1);
		WaitMethods.wait_in_seconds(5);
		GenericMethods.navigate_to_url(OR.getProperty("Agency_Url"));
		WaitMethods.wait_in_seconds(5);
		InitializeElements.initialize_elements();
		WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.gotoSubmissions_button);
		AutoRenewalBrokerFeeLocators.gotoSubmissions_button.click();
		WaitMethods.wait_in_seconds(3);
		AutoRenewalBrokerFeeMethods.click_bindingDoc_link("Renewal Submission Id",1);
		AutoRenewalBrokerFeeMethods.validate_percentage_brokerFee("renewal", 1);
		AutoRenewalBrokerFeeMethods.update_brokerFee_value("percentage", "renewal", 1);
		AutoRenewalBrokerFeeMethods.verify_payment_option(3);
		AutoRenewalBrokerFeeMethods.fill_bindingDoc_info("AgencyFinance",1);
		AutoRenewalBrokerFeeMethods.verify_updated_brokerfee("Renewal Submission Id","Updated Percentage Broker Fee for Renewal Business", 1);
		AutoRenewalBrokerFeeMethods.verify_payment_option(3);
	}

}

