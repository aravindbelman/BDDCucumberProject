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

//If Other is Not selected as Carrier.
//It Skip Accord Question(Additional Info page)
public class TC106_CarrierSelection_Page9 extends TestBase{

	public static final Logger log= Logger.getLogger(TC106_CarrierSelection_Page9.class.getName());

	//Select AMTrust as Carrier.
	@Test(enabled = true,priority=1)
	public static void ts01_carrierSelection_Page_verify_AMTrust()throws IOException, InterruptedException, Exception, AWTException
	{
		initialize_agency_environment("environment","chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		WCnewUIMethods.Business_MailingAddress(2,"same");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		WCnewUIMethods.businessInfoPage2(1,"otherThenCA","Ex.No");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		WCnewUIMethods.coverageHistoryWithNOoption("empNo");
		WaitMethods.wait_in_seconds(2);
		WCnewUIMethods.classCode_fill(5,"double");	
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		WCnewUIMethods.ownersAndOfficers(2);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		
		WCnewUIMethods.credit_Opp_Verify_AvaibalityOf_All_11_Questions();
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);

		WCnewUIMethods.CarrierOption("Amtrust&Employer");
		WaitMethods.wait_in_seconds(2);
		
		WCnewUIMethods.Additional_Info_Verify_AvaibalityOf_All_23_Questions("QuesNo");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(40);
		
		WCnewUIMethods.selectCarrier("AMtrust");
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.Sub_ClassCode("double");
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.Carrier_specific_Question_Verify("AMTrutQuetions");
		WaitMethods.wait_in_seconds(2);		
	}

	//Select Employeer as Carrier.
	@Test(enabled = true,priority=2)
	public static void ts02_carrierSelection_Page_verify_Employer()throws IOException, InterruptedException, Exception, AWTException
	{
		initialize_agency_environment("environment","chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		WCnewUIMethods.Business_MailingAddress(2,"same");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		WCnewUIMethods.businessInfoPage2(1,"otherThenCA","Ex.No");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2); 
		WCnewUIMethods.coverageHistoryWithNOoption("empNo");
		WaitMethods.wait_in_seconds(2);
		WCnewUIMethods.classCode_fill(5,"single");	
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		WCnewUIMethods.ownersAndOfficers(2);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		WCnewUIMethods.credit_Opp_Verify_AvaibalityOf_All_11_Questions();
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);

		WCnewUIMethods.CarrierOption("Amtrust&Employer");
		WaitMethods.wait_in_seconds(2);
		
		WCnewUIMethods.Additional_Info_Verify_AvaibalityOf_All_23_Questions("QuesNo");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(40);
		
		WCnewUIMethods.selectCarrier("Employer");
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.Sub_ClassCode("single");
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.Carrier_specific_Question_Verify("employerQuetions");
		WaitMethods.wait_in_seconds(2);		
	}
}
