package com.RegistrationProcess;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.BtisNewUI.PageMethods.RegistrationProcessMethods;
import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.TestBase.TestBase;


@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})

public class TC_111_registrationFlow extends TestBase {
	
	public static final Logger log= Logger.getLogger(TC_111_registrationFlow.class.getName());


	@Test
	//To test same Mailing and Business Address
	public static void workersCom_same_Address() throws IOException, InterruptedException, Exception, AWTException
	{
		initialize_agency_environment("environment","chrome_browser");
		InitializeElements.initialize_elements();
		driver.get("http://btis-afgl-demo.azurewebsites.net/welcome/");
		RegistrationProcessMethods.agencyInfoPage(1);
		RegistrationProcessMethods.contactInfoPage(1,"different");
		RegistrationProcessMethods.Errors_and_Omissions(1);
		RegistrationProcessMethods.agencyEligibility(1);
		RegistrationProcessMethods.uploadDoc();		
	}
}
