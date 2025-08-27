package com.LegacyApplication.RegressionIssues;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageLocators.AgencyMainMenuLocators;
import com.LegacyApplication.PageMethods.AgencyPageMethods;
import com.LegacyApplication.PageMethods.AutoRenewalBrokerFeeMethods;
import com.LegacyApplication.PageMethods.CommercialAutoMethods;
import com.LegacyApplication.PageMethods.GeneralLiabilityMethods;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})
public class TC049_VerifyAgencyMainMenuTkt extends TestBase{	
	
	public static final Logger log=Logger.getLogger(TC049_VerifyAgencyMainMenuTkt.class.getName());
	
	
	@Test(priority=0,enabled=true)
	public static void AgencyManiMenuTkts_Marketing_Link()throws Exception
	{
		initialize_agency_environment("environment", "chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		AgencyPageMethods.clickonMarketingLink();
		WaitMethods.wait_in_seconds(5);
	}
	
	@Test(priority=1,enabled=true)
	public static void AgencyManiMenuTkts_CommerceWestAutoList_Link()throws Exception
	{
		initialize_agency_environment("environment", "chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();	
		AgencyPageMethods.formAndApplication_Auto_CommerceWestAutoFormsListLink();
		WaitMethods.wait_in_seconds(5);
	}
	
	@Test(priority=2,enabled=true)
	public static void AgencyManiMenuTkts_PropertyFormsList_Link()throws Exception
	{	
		initialize_agency_environment("environment", "chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		AgencyPageMethods.formAndApplication_PropertyFormsList_Link();
		WaitMethods.wait_in_seconds(5);
	}
	
	@Test(priority=3,enabled=true)
	public static void AgencyManiMenuTkts_lossrunRequest_InvalidDataLink()throws Exception
	{	
		initialize_agency_environment("environment", "chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		AgencyPageMethods.underwritingservices_lossrunRequest_InvalidDataLink(1);
		WaitMethods.wait_in_seconds(5);
	}
		
	/*@Test(priority=4,enabled=true)
	public static void Create_QAA_upto_sold_RequestAI_VlaidInvalid()throws Exception
	{	
		initialize_agency_environment("environment", "chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		AutoRenewalBrokerFeeMethods.fill_comparative_rater_info(1);
		AutoRenewalBrokerFeeMethods.fill_price_indicatorandeligibility_info(1);
		AutoRenewalBrokerFeeMethods.fill_application_info(1);	
		
		WaitMethods.wait_in_seconds(5);
		WaitMethods.wait_for_page_load(10);
		GenericMethods.navigate_to_url(OR.getProperty("Admin_Url"));
		WaitMethods.wait_for_page_load(5);
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_admin();
		AutoRenewalBrokerFeeMethods.save_ratingWorkSheet("new","Submission Id",1);
		GenericMethods.close_browser_window();
		AutoRenewalBrokerFeeMethods.change_status("Submission Id","Status_OkToBind",1);
		WaitMethods.wait_in_seconds(5);
		AutoRenewalBrokerFeeMethods.change_status("Submission Id","Status _Sold",1);
		WaitMethods.wait_in_seconds(5);
		
		GenericMethods.close_browser_window();
		initialize_chrome("Agency_Url");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.BrokerFeeDataFilePath, "Agency_Info","Agency_Username", "Agency_Password", 5);
		HomePageMethods.select_agency_contact(Locations.BrokerFeeDataFilePath, "Agency_Info", "Agency_Contact", 1);
				
		AgencyPageMethods.requestAI_incomplete_Edit();
		AgencyPageMethods.ai_form_with_invalid_data();
	}*/	
}
