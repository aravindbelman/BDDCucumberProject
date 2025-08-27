package com.TestingPurpose;


import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.PageMethods.SubmissionPageMethods;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;


public class TestingPurpose extends TestBase {

	
	@Test
	public void verify_submission_details_information() throws IOException, AWTException, InterruptedException
	{
	 /*log.info("<===========Started verifying submission details information Test===========> ");
	 
	    PageFactory.initElements(driver, HomePageLocators.class);
	    PageFactory.initElements(driver, SubmissionPageLocators.class);
	    HomePageMethods.login_as_agency();
	    HomePageMethods.select_agency_contact();
	    SubmissionPageMethods.search_by_option(OR.getProperty("unsoldsubmissionid"));
	   String a= SubmissionPageLocators.application_status.getAttribute("innerHTML");
	   String s= SubmissionPageLocators.policy_no.getAttribute("innerHTML");
	   System.out.println("The attribute is " +s);
	   boolean isEmpty=s.trim().isEmpty();
	   System.out.println("The a value is "+isEmpty);
	   System.out.println("The attribute is " +a);
	   boolean isnotEmpty=a.trim().isEmpty();
	   System.out.println("The s value is "+isnotEmpty);
	    
	  log.info("                                                          ");  
	  log.info("<===========Ended verifying submission details information Test===========> ");	
		*/
		
		log.info("<===========Started verifying review submission details Test===========> ");
		init_agency();
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency();
		HomePageMethods.select_agency_contact();
		SubmissionPageMethods.search_by_option(OR.getProperty("unsoldsubmissionid"));
		SubmissionPageMethods.verify_submisson_info();
		GenericMethods.navigate_to_next_window();
		String s=driver.findElement(By.xpath("//span[@id='SubmissionID1_lblSubmissionIDValue']")).getText();
		System.out.println("The submision id is "+s);
	}
	
	
}
