package com.LegacyApplication.ProductionTickets;

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

/*
 * HelixTkt No - 17595
 * 4th scenario: Verify GABR - TX referral counties and
 * logic for commercial project with more than 500,000 construction limit 
 */

/*
 *Instant policy issue option should not available on FINAL REVIEW page.
 */
@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})
public class TC086_GABRsubmission_withoutIssuePolicyOption55Com  extends TestBase {
	
	public static final Logger log= Logger.getLogger(TC086_GABRsubmission_withoutIssuePolicyOption55Com.class.getName());
	@Test
	public static void gabr_No_IssuePolicyOption_Commercial55() throws IOException, InterruptedException, AWTException
	{
		initialize_admin_environment("environment", "chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_admin();
		WaitMethods.wait_in_seconds(2);
		BuildersRiskMethods.click_buildersrisk_program_AdminLogin();
		BuildersRiskMethods.fill_br_rating_info(6);	
		WaitMethods.wait_in_seconds(3);
		WaitMethods.wait_for_page_load(5);	
		BuildersRiskMethods.fill_br_application_info(6);
		WaitMethods.wait_in_seconds(3);	
		GenericMethods.press_key_using_robot("end");
		BuildersRiskMethods.check_Avaibility_Of_PolicyIssue_Option_IssuePolicy();		
	}
}
