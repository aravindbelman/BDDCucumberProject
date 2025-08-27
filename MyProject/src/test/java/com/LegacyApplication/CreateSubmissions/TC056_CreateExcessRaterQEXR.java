package com.LegacyApplication.CreateSubmissions;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageMethods.CommercialAutoMethods;
import com.LegacyApplication.PageMethods.ExcessRaterMethods;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.TestBase.TestBase;

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})
public class TC056_CreateExcessRaterQEXR extends TestBase {
	
	public static final Logger log=Logger.getLogger(TC056_CreateExcessRaterQEXR.class.getName());
	
	@Test
	public static void createQEXR()throws IOException, AWTException, InterruptedException
	{
		initialize_agency_environment("dev_environment", "chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();	
		ExcessRaterMethods.click_Excess();
		ExcessRaterMethods.fill_QEXR_rating_info(1);
		ExcessRaterMethods.price_Indicator();
		ExcessRaterMethods.eligibilityQuestions();
		ExcessRaterMethods.fill_excess_application_info(1);
	}
}
