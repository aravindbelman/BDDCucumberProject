package com.LegacyApplication.LoginPage;

import java.awt.AWTException;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.TestBase.TestBase;

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})
public class TC001_LoginAsAgency extends TestBase 
{
	public static final Logger log=Logger.getLogger(TC001_LoginAsAgency.class.getName());

    @Test
	public void login_as_agency() throws IOException, AWTException
	{
		log.info("<===========Started Verify Login as agency Credentials Test===========> ");
		
		initialize_chrome("Agency_Url");
	    InitializeElements.initialize_elements();
	    HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");

		log.info("<===========Ended Verify Login as agency Credentials Test===========> ");	

	}

	


}
