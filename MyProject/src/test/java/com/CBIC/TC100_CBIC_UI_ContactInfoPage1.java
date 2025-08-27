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
public class TC100_CBIC_UI_ContactInfoPage1 extends TestBase{
	
	public static final Logger log= Logger.getLogger(TC100_CBIC_UI_ContactInfoPage1.class.getName());
	
	@Test
	//To test same Mailing and Business Address
	public static void cbic_same_Address() throws IOException, InterruptedException, Exception, AWTException
	{
		initialize_agency_environment("staging_environment","chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		CBIC_UI_Methods.cbic_Business_MailingAddress(1,"same");
		GenericMethods.click_Element_Using_JS(CBICLocators.save_contiunue_btn);
		WaitMethods.wait_in_seconds(2);
		log.info("=============Create with Both Same Business and Mailing Address================");
	}
	
	@Test
	//To test with Different Mailing and Business Address
	public static void cbic_Diff_Address() throws IOException, InterruptedException, Exception, AWTException
	{
		initialize_agency_environment("staging_environment","chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		CBIC_UI_Methods.cbic_Business_MailingAddress(1,"different");
		GenericMethods.click_Element_Using_JS(CBICLocators.save_contiunue_btn);
		WaitMethods.wait_in_seconds(2);
		log.info("=============Create with Both Different Business and Mailing Address================");
	}
}
