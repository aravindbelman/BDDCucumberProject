package com.CBIC;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.BtisNewUI.Locators.CBIC_NewLocators;
import com.BtisNewUI.PageMethods.CBIC_New_UI_Methods;
import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})

public class TC119_CBIC_UI_New_preApp extends TestBase {
	public static final Logger log= Logger.getLogger(TC119_CBIC_UI_New_preApp.class.getName());
	
	@Test
	public static void cbic_UI() throws IOException, InterruptedException, Exception, AWTException
	{
		initialize_agency_environment("environment","chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();		
		
		CBIC_New_UI_Methods.cbic_Business_MailingAddress(1,"same");
		GenericMethods.click_Element_Using_JS(CBIC_NewLocators.save_contiunue_btn);
		WaitMethods.wait_in_seconds(2);
		
		CBIC_New_UI_Methods.cbic_Classification(1,"single");
		GenericMethods.click_Element_Using_JS(CBIC_NewLocators.bi_save_contiunue_btn);
		WaitMethods.wait_in_seconds(5);
		
		CBIC_New_UI_Methods.cbic_BusinessInfo(1,"normal");
		GenericMethods.click_Element_Using_JS(CBIC_NewLocators.bi_save_contiunue_btn);
		WaitMethods.wait_in_seconds(2);
		
		CBIC_New_UI_Methods.cbic_InsuranceHistory(1);
		GenericMethods.click_Element_Using_JS(CBIC_NewLocators.bi_save_contiunue_btn);
		WaitMethods.wait_in_seconds(10);
		
		CBIC_New_UI_Methods.cbic_pricing(1);
		GenericMethods.click_Element(CBIC_NewLocators.submitQuote_btn1);
		WaitMethods.wait_in_seconds(2);
		
		CBIC_New_UI_Methods.cbic_Supplemental("sub_No");
		GenericMethods.click_Element_Using_JS(CBIC_NewLocators.bi_save_contiunue_btn);
		WaitMethods.wait_in_seconds(5);
		
		CBIC_New_UI_Methods.cbic_generalQuestions();
		GenericMethods.click_Element_Using_JS(CBIC_NewLocators.submitQuote_btn);
		WaitMethods.wait_in_seconds(2);
		
		//class code 9111
		CBIC_New_UI_Methods.cbic_classCodeQuestionsfor_9111(2);
		WaitMethods.wait_in_seconds(2);
						
		GenericMethods.scroll_down_to_element(CBIC_NewLocators.submitQuote_btn);
		GenericMethods.click_Element_Using_JS(CBIC_NewLocators.submitQuote_btn);
		WaitMethods.wait_in_seconds(10);
				
		CBIC_New_UI_Methods.cbic_ID_status_QCGL("pdfNo");
		WaitMethods.wait_in_seconds(2);
		
		//ID for QCGL and refer us to UW_URL
		CBIC_New_UI_Methods.navigate_UW_URL();
		WaitMethods.wait_in_seconds(2);
		
		CBIC_New_UI_Methods.update_CBIC_submission("normal_flow");
		WaitMethods.wait_in_seconds(2);
		
		CBIC_New_UI_Methods.cbic_ID_status_QCGL("pdfYes");
		WaitMethods.wait_in_seconds(2);
		
		
	}
}
