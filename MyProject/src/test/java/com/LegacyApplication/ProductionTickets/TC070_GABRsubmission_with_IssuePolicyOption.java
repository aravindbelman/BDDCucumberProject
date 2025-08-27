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
 * 1st scenario: Verify GABR - Update TX referral counties 
 * and logic for residential project with less than 500,000 construction limit 
 */

/*
 * Instant policy issue option should be available on FINAL REVIEW page
 *  (I have reviewed all information in the application and verified 
 *  its accuracy and would like Builders & Tradesmen's Insurance Services to issue a policy for this account.)
 */

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})
public class TC070_GABRsubmission_with_IssuePolicyOption extends TestBase
{
	public static final Logger log= Logger.getLogger(TC070_GABRsubmission_with_IssuePolicyOption.class.getName());
	
	@Test(enabled=true)
	public static void gabr_SubmissionWith_IssuePolicyOption() throws IOException, InterruptedException, AWTException
	{
		initialize_admin_environment("environment", "chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_admin();
		WaitMethods.wait_in_seconds(2);
		BuildersRiskMethods.click_buildersrisk_program_AdminLogin();
		BuildersRiskMethods.fill_br_rating_info(3);	
		WaitMethods.wait_in_seconds(3);
		WaitMethods.wait_for_page_load(5);	
		BuildersRiskMethods.fill_br_application_info(3);
		WaitMethods.wait_in_seconds(3);	
		GenericMethods.press_key_using_robot("end");
		BuildersRiskMethods.check_Avaibility_Of_PolicyIssue_Option_IssuePolicy();			
	}
	
	/*@Test(enabled=false)
	public static void create_gabr_submissions() throws IOException, InterruptedException, AWTException
	{
		BuildersRixkMethods.create_buildersRisk_submissions(6);
	}

	}*/

}
