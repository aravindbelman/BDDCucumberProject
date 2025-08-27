package com.LegacyApplication.ProductionTickets;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.PageMethods.WorkersCompMethods;
import com.LegacyApplication.TestBase.TestBase;


@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})
public class TC039_VerifyToughCompAvailability extends TestBase {
	
public static final Logger log=Logger.getLogger(TC039_VerifyToughCompAvailability.class.getName());
	
	@Test
	public static void verify_toughcomp_availability() throws IOException, InterruptedException, AWTException,Exception
	{
		initialize_agency_environment("environment", "chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		WorkersCompMethods.verify_tough_comp_availability();
	}
}
