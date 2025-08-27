package com.LegacyApplication.RegressionIssues;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.PageMethods.AdminPageMethods;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.WaitMethods;

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})
public class TC044_VerifyAddingNewMasterAgency extends TestBase {
	
	public static final Logger log=Logger.getLogger(TC044_VerifyAddingNewMasterAgency.class.getName());
	
	@Test
	public static void verify_add_new_masterAgency() throws IOException, InterruptedException
	{
		initialize_admin_environment("environment", "chrome_browser");
		WaitMethods.wait_for_page_load(5);
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_admin();
		AdminPageMethods.verify_add_masterAgency();	
	}

}
