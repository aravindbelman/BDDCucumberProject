package com.LegacyApplication.QAAFilingChanges;

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
import com.LegacyApplication.PageMethods.QaaFilingChangeMethods;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})
public class TC025_QAA_FilingChanges extends TestBase {
	
	public static final Logger log=Logger.getLogger(TC025_QAA_FilingChanges.class.getName());
	
	@Test (enabled=false)
	public static void vaildate_QAA_filing_changes_prior_effectivedate() throws IOException, AWTException, InterruptedException
	{
		initialize_chrome("Agency_Url");
		InitializeElements.initialize_elements();
		AutoRenewalBrokerFeeMethods.select_agency(1);
		HomePageMethods.select_agency_contact(Locations.BrokerFeeDataFilePath, "Agency_Info", "Agency_Contact", 1);
		AutoRenewalBrokerFeeMethods.setup_brokerfee("nodefault","same", 1);
		GeneralLiabilityMethods.select_GL();
		GeneralLiabilityMethods.gl_MarketPalce(1);
		QaaFilingChangeMethods.fill_comparative_rater_info("States_Info","Proposed Effective Date 1", 1);
		QaaFilingChangeMethods.fill_price_indicatorandeligibility_info("States_Info",1);
		QaaFilingChangeMethods.fill_application_info("Proposed Effective Date 1",1);
		WaitMethods.wait_in_seconds(5);
		GenericMethods.navigate_to_url(OR.getProperty("Admin_Url"));
		WaitMethods.wait_for_page_load(5);
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_admin();
		QaaFilingChangeMethods.save_ratingWorkSheet("States_Info","Submission Id",1,"Proposed Effective Date 1");
		GenericMethods.close_browser_window();
		QaaFilingChangeMethods.change_status("States_Info","Submission Id","Status_OkToBind",1);
		WaitMethods.wait_in_seconds(5);
		GenericMethods.navigate_to_url(OR.getProperty("Agency_Url"));
		WaitMethods.wait_in_seconds(5);
		InitializeElements.initialize_elements();
		WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.gotoSubmissions_button);
		AutoRenewalBrokerFeeLocators.gotoSubmissions_button.click();
		WaitMethods.wait_in_seconds(3);
		QaaFilingChangeMethods.click_bindingDoc_link("States_Info","Submission Id",1);
		QaaFilingChangeMethods.verify_premium("States_Info", 1);
	}
	
	@Test (enabled=false)
	public static void vaildate_QAA_filing_changes_oneffectivedate() throws IOException, AWTException, InterruptedException
	{
		initialize_chrome("Agency_Url");
		InitializeElements.initialize_elements();
		AutoRenewalBrokerFeeMethods.select_agency(1);
		HomePageMethods.select_agency_contact(Locations.BrokerFeeDataFilePath, "Agency_Info", "Agency_Contact", 1);
		AutoRenewalBrokerFeeMethods.setup_brokerfee("nodefault","same", 1);
		QaaFilingChangeMethods.fill_comparative_rater_info("States_Info","Proposed Effective Date 2", 1);
		QaaFilingChangeMethods.fill_price_indicatorandeligibility_info("States_Info",1);
		QaaFilingChangeMethods.fill_application_info("Proposed Effective Date 2",1);
		WaitMethods.wait_in_seconds(5);
		GenericMethods.navigate_to_url(OR.getProperty("Admin_Url"));
		WaitMethods.wait_for_page_load(5);
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_admin();
		QaaFilingChangeMethods.save_ratingWorkSheet("States_Info","Submission Id",1,"Proposed Effective Date 2");
		GenericMethods.close_browser_window();
		QaaFilingChangeMethods.change_status("States_Info","Submission Id","Status_OkToBind",1);
		WaitMethods.wait_in_seconds(5);
		GenericMethods.navigate_to_url(OR.getProperty("Agency_Url"));
		WaitMethods.wait_in_seconds(5);
		InitializeElements.initialize_elements();
		WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.gotoSubmissions_button);
		AutoRenewalBrokerFeeLocators.gotoSubmissions_button.click();
		WaitMethods.wait_in_seconds(3);
		QaaFilingChangeMethods.click_bindingDoc_link("States_Info","Submission Id",1);
		QaaFilingChangeMethods.verify_premium("States_Info", 1);
	}
	
	@Test (enabled=true)
	public static void verify_MI_info() throws IOException, AWTException, InterruptedException
	{
		QaaFilingChangeMethods.vaildate_QAA_filing_changes("States_Info", 6,"Proposed Effective Date 1" );
		QaaFilingChangeMethods.vaildate_QAA_filing_changes("States_Info", 6,"Proposed Effective Date 2" );
	}

}
