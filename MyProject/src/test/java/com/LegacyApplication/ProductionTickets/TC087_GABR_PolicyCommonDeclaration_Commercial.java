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

/*HelixTkt No - 18459
 * For the commercial builders risk policies the afforded company is Great American Insurance Company
 */

/*
 * In the policy docs there is a page with header (POLICY COMMON DECLARATIONS).
 * it should show the insurance afforded company name as: Great American Insurance Company 
 */
@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})
public class TC087_GABR_PolicyCommonDeclaration_Commercial extends TestBase{

	public static final Logger log= Logger.getLogger(TC087_GABR_PolicyCommonDeclaration_Commercial.class.getName());
	@Test
	public static void gabr_PolicyCommonDeclaration_Commercial() throws IOException, InterruptedException, AWTException
	{
		initialize_admin_environment("environment", "chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_admin();
		WaitMethods.wait_in_seconds(2);
		BuildersRiskMethods.click_buildersrisk_program_AdminLogin();
		BuildersRiskMethods.fill_br_rating_info(7);	
		WaitMethods.wait_in_seconds(3);
		WaitMethods.wait_for_page_load(5);	
		BuildersRiskMethods.fill_br_application_info(7);
		WaitMethods.wait_in_seconds(3);	
		GenericMethods.press_key_using_robot("end");
		BuildersRiskMethods.check_Avaibility_Of_PolicyIssue_Option_IssuePolicy();
		WaitMethods.wait_in_seconds(5);
		//BuildersRixkMethods.searchSubmission_Click_PolicyInvoiceOption_ViewPrint("BR_Submission_Id", 7);
		BuildersRiskMethods.Click_PolicyInvoiceOption_ViewPrint();
		
	}

}
