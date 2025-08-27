package com.LegacyApplication.ProductionTickets;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageMethods.BondsMethods;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.WaitMethods;

public class TC068_ValidateEZBondsVerbageUpdatedToRapidBonds extends TestBase {
	
	public static final Logger log=Logger.getLogger(TC068_ValidateEZBondsVerbageUpdatedToRapidBonds.class.getName());
	
	@Test
	public static void verify_rapid_bonds_verbage() throws IOException, AWTException, InterruptedException
	{
		initialize_agency_environment("environment", "chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();	
		BondsMethods.click_rapid_bonds();
		BondsMethods.verify_rapid_bonds_verbiage();
		WaitMethods.wait_in_seconds(10);
	}

}
