package com.LegacyApplication.LoginPage;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.TestBase.TestBase;


public class TC001_LoginAsAgency extends TestBase 
{
	public static final Logger log=Logger.getLogger(TC001_LoginAsAgency.class.getName());

    @Test
	public void login_as_agency() throws IOException
	{
		log.info("<===========Started Verify Login as agency Credentials Test===========> ");

		init_agency();
	    InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency();

		log.info("<===========Ended Verify Login as agency Credentials Test===========> ");	

	}

	


}
