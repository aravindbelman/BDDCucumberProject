package com.LegacyApplication.CreateSubmissions;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageMethods.GeneralLiabilityMethods;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.TestBase.TestBase;

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})

public class TC092_programms_MarketPalce extends TestBase{
	public static final Logger log= Logger.getLogger(TC092_programms_MarketPalce.class.getName());
	
	/*
	 * Puerpose: This methid is used to Verify Class code & state 
	 * wise Availble Programms.
	 */
	@Test
	public static void verify_marketPalceasPerAvailableProgram_StateBased() throws IOException, InterruptedException, AWTException
	{
		initialize_agency_environment("environment", "chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();	
		GeneralLiabilityMethods.select_GL();
		GeneralLiabilityMethods.gl_program_stateWise_MarketPalce(1);
	}
}
