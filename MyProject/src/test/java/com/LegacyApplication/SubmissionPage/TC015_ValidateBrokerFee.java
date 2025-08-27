package com.LegacyApplication.SubmissionPage;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.PageMethods.AdminSubmissionPageMethods;
import com.LegacyApplication.PageMethods.BrokerFeeInfo;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.TestBase.TestBase;

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})
public class TC015_ValidateBrokerFee extends TestBase {
	
	public static final Logger log=Logger.getLogger(TC015_ValidateBrokerFee.class.getName());
	
	@Test
	public void validate_broker_fee() throws InterruptedException, IOException, AWTException
	{
		log.info("<===========Started verifying broker fee details Test===========> ");
		initialize_chrome("Admin_Url");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_admin();
		AdminSubmissionPageMethods.search_submissionid("Renewal Submission Id",1);
		BrokerFeeInfo.change_status();
		BrokerFeeInfo.view_application_info();
		log.info("<===========Ended verifying broker fee details Test===========> ");
	}

}
