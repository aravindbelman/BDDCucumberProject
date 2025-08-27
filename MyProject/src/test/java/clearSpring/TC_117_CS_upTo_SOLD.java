package clearSpring;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.BtisNewUI.PageMethods.ClearSpring_UI_Methods;
import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageLocators.AutoRenewalBrokerFeeLocators;
import com.LegacyApplication.PageLocators.DefaultBrokerFeeLocators;
import com.LegacyApplication.PageMethods.AutoRenewalBrokerFeeMethods;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})

public class TC_117_CS_upTo_SOLD  extends TestBase{

	public static final Logger log= Logger.getLogger(TC_117_CS_upTo_SOLD.class.getName());

	@Test(enabled = true,priority=1)
	//To test QCS up to SOLD.
	// CO,AZ,NJ,MI,IL,AL,KS,MO,OK,TN,UT,OH

	public static void ts03_QCS_upTo_SOLD() throws IOException, InterruptedException, Exception, AWTException
	{	
		initialize_agency_environment("staging_environment","chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		//ClearSpring_UI_Methods.select_CS_Program();
		ClearSpring_UI_Methods.clearSpring_MarketPalce();
		ClearSpring_UI_Methods.applicantsInfo_page1_FillDetails(1,"different");
		//Employee_Yes,Subcontractor_Yes,ResedentialWork_Yes   OR
		//Employee_No,Subcontractor_No,ResedentialWork_No
		ClearSpring_UI_Methods.businessInfo_page2_FillDetails(1,"Employee_Yes","Subcontractor_Yes","ResedentialWork_Yes");
		//BusinessHistory_NO,BusinessHistory_YES
		ClearSpring_UI_Methods.insuranceInfo_page3_FillDetails(1,"BusinessHistory_NO");
		ClearSpring_UI_Methods.classifications_page4_FillDetails(1);
		ClearSpring_UI_Methods.pricingOptions_page5_FillDetails("compairYes",1);
		//UW or coverage
		ClearSpring_UI_Methods.eligibility_submit_page6("coverage");

		ClearSpring_UI_Methods.brokerFee_Enhancement_page7_FillDetails(1,"yes","assertValues_yes");
		WaitMethods.wait_in_seconds(5);
		ClearSpring_UI_Methods.verify_ThankYou(12);

		//====================

		WaitMethods.wait_for_page_load(10);
		GenericMethods.navigate_to_url(OR.getProperty("staging_Admin_Url"));
		WaitMethods.wait_for_page_load(5);
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_admin();

		AutoRenewalBrokerFeeMethods.save_ratingWorkSheet("new","Submission Id",12);
		GenericMethods.close_browser_window();
		AutoRenewalBrokerFeeMethods.change_status("Submission Id","Status_OkToBind",12);
		WaitMethods.wait_in_seconds(2);

		GenericMethods.navigate_to_url(OR.getProperty("staging_Agency_Url"));
		WaitMethods.wait_in_seconds(5);
		InitializeElements.initialize_elements();
		WaitMethods.wait_for_element_present(AutoRenewalBrokerFeeLocators.gotoSubmissions_button);
		AutoRenewalBrokerFeeLocators.gotoSubmissions_button.click();
		WaitMethods.wait_in_seconds(3);
		AutoRenewalBrokerFeeMethods.click_bindingDoc_link("Submission Id",12);
		GenericMethods.navigate_to_next_window();
		AutoRenewalBrokerFeeMethods.fill_bindingDoc_info("directbill",1);
			
		initialize_agency_environment("staging_environment","chrome_browser");
		GenericMethods.navigate_to_url(OR.getProperty("staging_Admin_Url"));
		WaitMethods.wait_for_page_load(5);
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_admin();

		AutoRenewalBrokerFeeMethods.change_status("Submission Id","Status _Sold",12);
		WaitMethods.wait_in_seconds(5);
		
		GenericMethods.click_Element(DefaultBrokerFeeLocators.changestatus_cancelbutton);
		
		AutoRenewalBrokerFeeMethods.toDisplay_policyNo("Submission Id", 12);
		WaitMethods.wait_in_seconds(5);
				
	}

}
