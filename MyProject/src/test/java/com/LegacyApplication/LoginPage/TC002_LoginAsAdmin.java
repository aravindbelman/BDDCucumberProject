package com.LegacyApplication.LoginPage;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.TestBase.TestBase;

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})
public class TC002_LoginAsAdmin extends TestBase{

	public static final Logger log=Logger.getLogger(TC002_LoginAsAdmin.class.getName());
	
	@Test
	public void login_as_admin() throws IOException
	{
		log.info("<===========Started Verify Login as Admin Credentials Test===========> ");
		
		initialize_chrome("Admin_Url");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_admin();

		log.info("<===========Ended Verify Login as Agency Credentials Test===========> ");	
     }


}
