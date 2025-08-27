package com.LegacyApplication.ProductionTickets;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageMethods.CommercialAutoMethods;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.RegressionIssues.TC050_VerifyApplicationpage_QCA;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.WaitMethods;

public class TC060_QCAvalidateCliamSectionField extends TestBase {
	
	public static final Logger log=Logger.getLogger(TC060_QCAvalidateCliamSectionField.class.getName());
	
	@Test
	public static void validate_claim_section()throws IOException, AWTException, InterruptedException
	{
		initialize_agency_environment("environment", "chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();	
		CommercialAutoMethods.click_victory_auto_comp();
		CommercialAutoMethods.fill_VCA_rating_info(1);
		CommercialAutoMethods.eligibilityQuestions();
		CommercialAutoMethods.verify_claimsSectionOption_QCA();
		WaitMethods.wait_in_seconds(10);
	}
}
