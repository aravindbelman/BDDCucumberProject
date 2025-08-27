package com.LegacyApplication.ProductionTickets;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.PageMethods.KraftLakeWholesalerMethods;
import com.LegacyApplication.TestBase.TestBase;

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})
public class TC041_CreatingKraftLakeWholesalerGLSubmission extends TestBase 
{
	
public static final Logger log=Logger.getLogger(TC041_CreatingKraftLakeWholesalerGLSubmission.class.getName());
	
	@Test
	public static void create_KraftLakeWholesaler_submission() throws IOException, InterruptedException, AWTException
	{
		initialize_chrome("Wholesaler_Url");
		InitializeElements.initialize_elements();
		KraftLakeWholesalerMethods.log_into_Karftlake();
		KraftLakeWholesalerMethods.fill_kraftLake_GL_ratingInfo(1);
		KraftLakeWholesalerMethods.fill_kraftLake_GL_PIandEligibility_Info();
		KraftLakeWholesalerMethods.fill_kraftLake_GL_application_Info(1);	
	}

}
