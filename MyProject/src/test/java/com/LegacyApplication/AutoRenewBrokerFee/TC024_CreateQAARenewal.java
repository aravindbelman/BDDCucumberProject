package com.LegacyApplication.AutoRenewBrokerFee;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.LegacyApplication.PageMethods.AutoRenewalBrokerFeeMethods;
import com.LegacyApplication.TestBase.TestBase;

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})
public class TC024_CreateQAARenewal extends TestBase {
	
	public static final Logger log=Logger.getLogger(TC024_CreateQAARenewal.class.getName());
	
	@Test
	public static void create_submission_and_renewal() throws IOException, InterruptedException, AWTException, ClassNotFoundException, SQLException, ParseException
	{
		AutoRenewalBrokerFeeMethods.create_submissions_and_renewal(1);
	}

}
