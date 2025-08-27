package com.NewGIDirect;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.BtisNewUI.PageMethods.GlDirectMethods;
import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;
import com.gargoylesoftware.htmlunit.Page;

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})
public class TC_081_VerifyNewUIGl extends TestBase {
	
public static final Logger log=Logger.getLogger(TC_081_VerifyNewUIGl.class.getName());
	
	@Test
	public static void createQAA()throws  IOException, InterruptedException, Exception, AWTException
	{		
		initialize_firefox("DirectGL_Url");
		InitializeElements.initialize_elements();
		GlDirectMethods.get_your_price(1);
		GlDirectMethods.pre_qualifyRate(1);
		GlDirectMethods.about_you(1);
		GlDirectMethods.business_info(1);
		GlDirectMethods.insurance_history(1);
		GlDirectMethods.classifaction(1);
		
		GlDirectMethods.eligibilityPage();
		GlDirectMethods.coverage_options(1);
		GlDirectMethods.select_CoverageOption();
		GlDirectMethods.reviewPage();
		GlDirectMethods.buyYourPolicy(1);
		WaitMethods.wait_in_seconds(10);
		
	}

}
