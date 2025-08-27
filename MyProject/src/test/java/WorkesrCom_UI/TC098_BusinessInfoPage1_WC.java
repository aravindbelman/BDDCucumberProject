package WorkesrCom_UI;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.BtisNewUI.Locators.WCnewUILocators;
import com.BtisNewUI.PageMethods.WCnewUIMethods;
import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})
public class TC098_BusinessInfoPage1_WC extends TestBase{

	public static final Logger log= Logger.getLogger(TC098_BusinessInfoPage1_WC.class.getName());

	@Test(enabled = true,priority=1)
	//To test same Mailing and Business Address
	
	public static void ts01_workersCom_same_Address() throws IOException, InterruptedException, Exception, AWTException
	{
		initialize_agency_environment("environment","chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		//GenericMethods.navigate_to_url(OR.getProperty("wcDev"));
		WCnewUIMethods.Business_MailingAddress(2,"same");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		log.info("=============Create with Both Same Business and Mailing Address================");
	}

	@Test(enabled = true,priority=2)
	//To test Different Mailing and Business Address
	public static void ts02_workersCom_diff_Address() throws IOException, InterruptedException, Exception, AWTException
	{
		initialize_agency_environment("environment","chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		WCnewUIMethods.Business_MailingAddress(1,"different");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		log.info("==============Create with Both Different Business and Mailing Address================");
	}

	@Test(enabled = true,priority=3)
	//To test Business and Mailing ad Additional address which we Entered Save or Not when you come Back to same page
	public static void ts03_workersCom_Data_Verify() throws IOException, InterruptedException, Exception, AWTException
	{
		initialize_agency_environment("environment","chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		WCnewUIMethods.Business_Mailing_Additional_Address(1,"different");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.back_btn);
		WCnewUIMethods.verifyInf_Businees_Mailing_Additional_Address(1,"same");
		log.info("==============Data Verified in All 3 Business/Mailing/Additional Addresses================");
	}

	@Test(enabled = true,priority=4)
	//Page 1 Validation message exists or Not for ALL available Fields in PAGE 1
	public static void ts04_page1Validatios_Test() throws IOException, InterruptedException, Exception, AWTException
	{
		initialize_agency_environment("environment","chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		WCnewUIMethods.select_WC_Program();
		WCnewUIMethods.to_testPage1_Validations();
		WaitMethods.wait_in_seconds(2);
	}
	
	// This test is to Verify Duplicate validation exists or Not for Business Address & additional address & Next Button Disable. 
	@Test(enabled = true,priority=5)
	public static void ts05_duplicate_address_Test() throws IOException, InterruptedException, Exception, AWTException
	{
		initialize_agency_environment("environment","chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		WCnewUIMethods.select_WC_Program();
		WCnewUIMethods.duplicateAddress_validation(1,"same");
	}
}
