package com.LegacyApplication.ProductionTickets;

import java.awt.AWTException;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageMethods.AutoRenewalBrokerFeeMethods;
import com.LegacyApplication.PageMethods.BondsMethods;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.TestBase.TestBase;

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})

/*
 * Purpose: This method is used to click Victory Express Bonds link
 * This method is used to verify Email Address after clicking Victory Express Bonds 
 */


public class TC028_VerifyVictoryExpressEmailAddress extends TestBase {
	
public static final Logger log=Logger.getLogger(TC028_VerifyVictoryExpressEmailAddress.class.getName());

@Test
public void validate_emailaddress_field() throws IOException, InterruptedException, AWTException
{
	initialize_agency_environment("environment", "chrome_browser");
	InitializeElements.initialize_elements();
	HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
	HomePageMethods.select_agency_contact();	
	BondsMethods.click_victory_express_bonds();
	BondsMethods.verify_victoryez_email_address();
}
}
