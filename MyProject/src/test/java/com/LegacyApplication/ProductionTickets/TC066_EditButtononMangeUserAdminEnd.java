package com.LegacyApplication.ProductionTickets;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.PageMethods.AdminPageMethods;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.WaitMethods;

public class TC066_EditButtononMangeUserAdminEnd extends TestBase {
	
	public static final Logger log=Logger.getLogger(TC066_EditButtononMangeUserAdminEnd.class.getName());
	
	@Test
	public static void verify_EditButton_ManageUser_AdminEnd()throws Exception
	{
		initialize_admin_environment("environment", "chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_admin();
		WaitMethods.wait_in_seconds(2);
		AdminPageMethods.editButton_manageUser(); 
	}
}
