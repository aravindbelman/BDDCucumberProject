package com.LegacyApplication.ProductionTickets;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageMethods.AgencyPageMethods;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.TestBase.TestBase;

public class TC061_RegisterProducer_VerifyAffliationChanges extends TestBase {
	
	public static final Logger log=Logger.getLogger(TC061_RegisterProducer_VerifyAffliationChanges.class.getName());
	
	@Test
	public static void verify_affiliation_changes()throws Exception
	{
		initialize_agency_environment("environment", "chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		AgencyPageMethods.verify_affiliationChanges_producerRegistration();
	
	}

}
