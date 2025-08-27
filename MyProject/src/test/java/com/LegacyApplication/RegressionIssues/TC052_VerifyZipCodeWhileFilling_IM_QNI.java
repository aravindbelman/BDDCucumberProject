package com.LegacyApplication.RegressionIssues;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.PageMethods.InlandMarineMethods;
import com.LegacyApplication.ProductionTickets.TC030_VerifyFraudWarninginQNIApplication;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.WaitMethods;
@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})
public class TC052_VerifyZipCodeWhileFilling_IM_QNI extends TestBase{

	public static final Logger log= Logger.getLogger(TC052_VerifyZipCodeWhileFilling_IM_QNI.class.getName());
	
	@Test
	public static void verify_zipcode_IM() throws IOException, InterruptedException, AWTException
	{	
	initialize_agency_environment("environment", "chrome_browser");
	InitializeElements.initialize_elements();
	HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");	
	HomePageMethods.select_agency_contact();
	InlandMarineMethods.click_victoryInlandmarine_program();
	InlandMarineMethods.fill_InlandMarine_rating_info(1);
	InlandMarineMethods.fill_InlandMarine_application_info(1);
	WaitMethods.wait_in_seconds(3);
	InlandMarineMethods.verify_IM_zipcode();
	WaitMethods.wait_in_seconds(5);
	}
	
}
