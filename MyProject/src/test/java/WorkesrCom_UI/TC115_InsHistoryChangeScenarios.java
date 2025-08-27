package WorkesrCom_UI;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.BtisNewUI.Locators.WCnewUILocators;
import com.BtisNewUI.PageMethods.WCnewUIMethods;
import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;

public class TC115_InsHistoryChangeScenarios extends TestBase
{
	public static final Logger log= Logger.getLogger(TC115_InsHistoryChangeScenarios.class.getName());


	//This method is to test Coverage History details along with Loss and Claim Details
	// with Employee Carrier Aftre Paymenet Plan - -Normaly take you to Payment BreakDown and Thank You page -- Verify that thing.

	@Test(enabled = true,priority=1)
	public static void ts01_employer_flow_verify_InsuranceThing()throws IOException, InterruptedException, Exception, AWTException
	{
		initialize_agency_environment("environment","chrome_browser");
		InitializeElements.initialize_elements();
		
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		
		WaitMethods.wait_in_seconds(20);
		WCnewUIMethods.Business_MailingAddress(2,"same");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		
		WCnewUIMethods.businessInfoPage2(1,"otherThenCA","Ex.No");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2); 

		WCnewUIMethods.fillDetailsCoveragePage_New(1);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.fill_with2claimCount_new(1);	
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);	

		WCnewUIMethods.classCode_fill(7,"single");	
		GenericMethods.click_Element(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.ownersAndOfficers(2);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.credit_Opp_Verify_AvaibalityOf_All_11_Questions();
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);

		WCnewUIMethods.CarrierOption("Amtrust&Employer");
		WaitMethods.wait_in_seconds(5);

		WCnewUIMethods.Additional_Info_Verify_AvaibalityOf_All_23_Questions("QuesNo");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(40);

		WCnewUIMethods.selectCarrier("Employer");
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.Sub_ClassCode("single");
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.Carrier_specific_Question_Verify("employerQuetions");
		WaitMethods.wait_in_seconds(10);

		WCnewUIMethods.employerCarrierPaymentPlan("Happy");
		GenericMethods.click_Element(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(50);

		WCnewUIMethods.paymentBreakDown_page("BrokerFee_YES");
		WaitMethods.wait_in_seconds(5);

		WCnewUIMethods.ThankYou_page();
		WaitMethods.wait_in_seconds(2);
	}
	
	//This method is to test Coverage History details along with Loss and Claim Details
	// with AMTrust Carrier Aftre Paymenet Plan -Normaly take you to Payment BreakDown and Thank You page -- Verify that thing.

	@Test(enabled = true,priority=2)
	public static void ts02_AMTrust_flow_verify_InsuranceThing()throws IOException, InterruptedException, Exception, AWTException
	{
		initialize_agency_environment("environment","chrome_browser");
		InitializeElements.initialize_elements();

		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		WaitMethods.wait_in_seconds(20);

		WCnewUIMethods.Business_MailingAddress(2,"same");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.businessInfoPage2(1,"otherThenCA","Ex.No");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.fillDetailsCoveragePage_New(1);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.fill_with2claimCount_new(1);	
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);	

		WCnewUIMethods.classCode_fill(4,"double");	
		GenericMethods.click_Element(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.ownersAndOfficers(2);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.credit_Opp_Verify_AvaibalityOf_All_11_Questions();
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);

		WCnewUIMethods.CarrierOption("Amtrust&Employer");
		WaitMethods.wait_in_seconds(5);

		WCnewUIMethods.Additional_Info_Verify_AvaibalityOf_All_23_Questions("QuesNo");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(40);

		WCnewUIMethods.selectCarrier("AMtrust");
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.Sub_ClassCode("double");
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.Carrier_specific_Question_Verify("AMTrutQuetions");
		WaitMethods.wait_in_seconds(10);	

		WCnewUIMethods.amTrustCarrierPaymentPlan("Happy");
		GenericMethods.click_Element(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(50);

		WCnewUIMethods.paymentBreakDown_page("BrokerFee_YES");
		WaitMethods.wait_in_seconds(5);

		WCnewUIMethods.ThankYou_page();
		WaitMethods.wait_in_seconds(2);
	}

	//BOI - Bind eligible False Condition test
	@Test(enabled = true,priority=3)
	public static void ts01_employer_flow_verify_InsuranceThing_BOI_test()throws IOException, InterruptedException, Exception, AWTException
	{
		initialize_agency_environment("environment","chrome_browser");
		InitializeElements.initialize_elements();

		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		WaitMethods.wait_in_seconds(20);

		WCnewUIMethods.Business_MailingAddress(2,"same");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.businessInfoPage2(1,"otherThenCA","Ex.No");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.fillDetailsCoveragePage_New(1);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.fill_with2claimCount_new(1);	
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);	

		WCnewUIMethods.classCode_fill(5,"double");	
		GenericMethods.click_Element(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.ownersAndOfficers(2);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.credit_Opp_Verify_AvaibalityOf_All_11_Questions();
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);

		WCnewUIMethods.CarrierOption("Amtrust&Employer");
		WaitMethods.wait_in_seconds(5);

		WCnewUIMethods.Additional_Info_Verify_AvaibalityOf_All_23_Questions("QuesNo");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(40);

		WCnewUIMethods.selectCarrier("Employer");
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.Sub_ClassCode("double");
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.Carrier_specific_Question_Verify("employerQuetions");
		WaitMethods.wait_in_seconds(10);

		WCnewUIMethods.employerCarrierPaymentPlan("Happy");
		GenericMethods.click_Element(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(50);

		WCnewUIMethods.paymentBreakDown_page("Bind_or_submitUW");
		WaitMethods.wait_in_seconds(5);
	}

}
