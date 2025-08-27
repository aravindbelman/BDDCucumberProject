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
public class TC099_BusinessInfoPage2_WC extends TestBase{

	public static final Logger log= Logger.getLogger(TC099_BusinessInfoPage2_WC.class.getName());

	@Test(enabled = true,priority=1)
	//To test Crude Business Info page 2
	public static void ts01_businessInfo_Crude_Page2() throws IOException, InterruptedException, Exception, AWTException
	{
		initialize_agency_environment("environment","chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		WCnewUIMethods.Business_MailingAddress(2,"same");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		WCnewUIMethods.businessInfoPage2(1,"forCA","Ex.No");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		log.info("==============Successfully take you to Coverage History page===============");
	}

	@Test(enabled = true,priority=2)
	//To test Limits Drop down as per States in Business Info page 2
	public static void ts02_limits_page2() throws IOException, InterruptedException, Exception, AWTException
	{
		initialize_agency_environment("environment","chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		WCnewUIMethods.select_WC_Program();
		WCnewUIMethods.testLimits(13);
		log.info("===============Tested Limits avaibality with CA,CO,NV,FL,HI,KS,LA,MD,MS,TX,VT,WI==========");
	}

	@Test(enabled = false,priority=3)
	//Come back from Page 3 to page 1 & change Business address state -& Check Limits.
	//& check Next Button Disable until you select Limits. 
	public static void ts03_limits_Saved_Verify() throws IOException, InterruptedException, Exception, AWTException
	{

		initialize_agency_environment("environment","chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		WCnewUIMethods.select_WC_Program();
		
		WCnewUIMethods.Business_MailingAddressxx(3,"same");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		
		WCnewUIMethods.testSavedLimits_States_Change(2);
		WCnewUIMethods.businessInfoPage2(3,"otherThenCA","Ex.No");		
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		
		GenericMethods.click_Element_Using_JS(WCnewUILocators.back_btn);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.back_btn);
		
		//
		WCnewUIMethods.Business_MailingAddressxx(1,"same");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		
		WCnewUIMethods.testSavedLimits_States_Change(1);
		WCnewUIMethods.businessInfoPage2(1,"forCA","Ex.No");		
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.back_btn);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.back_btn);

		WCnewUIMethods.Business_MailingAddressxx(4,"same");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		WCnewUIMethods.testSavedLimits_States_Change(2);
		WCnewUIMethods.businessInfoPage2(3,"otherThenCA","Ex.No");		
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.back_btn);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.back_btn);


		WCnewUIMethods.Business_MailingAddressxx(1,"same");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		WCnewUIMethods.testSavedLimits_States_Change(1);

	}
	
	//Verfiy Validation message for all Fileds.
	@Test(enabled = true,priority=4)
	public static void ts04_page2Validatios_Test() throws IOException, InterruptedException, Exception, AWTException
	{
		initialize_agency_environment("environment","chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		WCnewUIMethods.Business_MailingAddress(1,"same");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		WCnewUIMethods.to_testPage2_Validations();
	}

}
