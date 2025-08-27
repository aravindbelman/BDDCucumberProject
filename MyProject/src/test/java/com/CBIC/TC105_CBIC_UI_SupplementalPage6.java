package com.CBIC;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.BtisNewUI.Locators.CBICLocators;
import com.BtisNewUI.PageMethods.CBIC_UI_Methods;
import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})

public class TC105_CBIC_UI_SupplementalPage6 extends TestBase{
	
	public static final Logger log= Logger.getLogger(TC105_CBIC_UI_SupplementalPage6.class.getName());
	@Test
	//To test Supplemental page 6
	
	public static void cbic_supplemental() throws IOException, InterruptedException, Exception, AWTException
	{
		initialize_agency_environment("staging_environment","chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();		
		
		CBIC_UI_Methods.cbic_Business_MailingAddress(1,"same");
		GenericMethods.click_Element_Using_JS(CBICLocators.save_contiunue_btn);
		WaitMethods.wait_in_seconds(2);
		
		CBIC_UI_Methods.cbic_Classification(1);
		GenericMethods.click_Element_Using_JS(CBICLocators.bi_save_contiunue_btn);
		WaitMethods.wait_in_seconds(5);
		
		CBIC_UI_Methods.cbic_BusinessInfo(1);
		GenericMethods.click_Element_Using_JS(CBICLocators.bi_save_contiunue_btn);
		WaitMethods.wait_in_seconds(2);
		
		CBIC_UI_Methods.cbic_InsuranceHistory(1);
		GenericMethods.click_Element_Using_JS(CBICLocators.bi_save_contiunue_btn);
		WaitMethods.wait_in_seconds(2);	
		
		CBIC_UI_Methods.cbic_pricing(1);
		GenericMethods.click_Element_Using_JS(CBICLocators.save_contiunue_btn);
		WaitMethods.wait_in_seconds(2);
		
		CBIC_UI_Methods.cbic_Supplemental(1);
		GenericMethods.click_Element_Using_JS(CBICLocators.bi_save_contiunue_btn);
		WaitMethods.wait_in_seconds(5);
		
		CBIC_UI_Methods.cbic_successPage(1);
	}

}