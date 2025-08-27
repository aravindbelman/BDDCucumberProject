package com.LegacyApplication.SubmissionPage;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.PageMethods.BrokerFeeInfo;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.TestBase.TestBase;

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})
public class TC014_ValidateAgencyInfoDetails extends TestBase {
	
	public static final Logger log=Logger.getLogger(TC014_ValidateAgencyInfoDetails.class.getName());
	
	@Test
	public void validate_agency_info_details() throws InterruptedException, IOException, AWTException
	{
		log.info("<===========Started verifying agency information details Test===========> ");
		initialize_chrome("Admin_Url");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_admin();
		BrokerFeeInfo.select_agency();
		BrokerFeeInfo.validate_agency_info(1);
		log.info("<===========Ended verifying agency information details Test===========>");
    }
	
	@Test
	public void validate_more_info_details() throws InterruptedException, IOException, AWTException
	{
		log.info("<===========Started verifying more information details Test===========> ");
		InitializeElements.initialize_elements();
		BrokerFeeInfo.validate_more_info();
		log.info("<===========Ended verifying more information details Test===========>");
    }
}
