package com.LegacyApplication.CreateSubmissions;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.PageMethods.BuildersRiskMethods;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})
public class TC089_CreateGABRSubmission extends TestBase {
	
	public static final Logger log= Logger.getLogger(TC089_CreateGABRSubmission.class.getName());
	
	@Test
	public static void create_GABR_submission() throws IOException, InterruptedException, AWTException
	{
		initialize_admin_environment("dev_environment", "chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_admin();
		WaitMethods.wait_in_seconds(2);
		BuildersRiskMethods.click_buildersrisk_program_AdminLogin();
		BuildersRiskMethods.fill_br_rating_info(4);	
		WaitMethods.wait_in_seconds(3);
		WaitMethods.wait_for_page_load(5);	
		BuildersRiskMethods.fill_br_application_info(4);
		WaitMethods.wait_in_seconds(3);		
	}
}