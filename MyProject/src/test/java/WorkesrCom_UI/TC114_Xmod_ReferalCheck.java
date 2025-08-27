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

public class TC114_Xmod_ReferalCheck extends TestBase {

	public static final Logger log= Logger.getLogger(TC114_Xmod_ReferalCheck.class.getName());

	//Referal Condition 2
	//BusinessInfo Page 2 Ex. Mod Value is greater then 0.00 
	//With AMtrust Carrier everting goes well -Submission No. Created too.
	//This ReferaL Condition
	@Test(enabled = true,priority=1)
	public static void ts01_exMod_referal_AMtrustverify()throws IOException, InterruptedException, Exception, AWTException
	{
		initialize_agency_environment("environment","chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		//GenericMethods.navigate_to_url(OR.getProperty("wcDev"));
		WCnewUIMethods.Business_MailingAddress(2,"same");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		//Ex Mod. Value. select 4th row in Excel
		WCnewUIMethods.businessInfoPage2(4,"otherThenCA","Ex.Yes");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.coverageHistoryWithNOoption("empNo");
		WaitMethods.wait_in_seconds(2);
		WCnewUIMethods.classCode_fill(4,"single");	
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.ownersAndOfficers(2);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.credit_Opp_Verify_AvaibalityOf_All_11_Questions();
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(20);

		WCnewUIMethods.CarrierOption("Amtrust&Employer");
		WaitMethods.wait_in_seconds(10);

		WCnewUIMethods.Additional_Info_Verify_AvaibalityOf_All_23_Questions("QuesNo");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(40);

		WCnewUIMethods.selectCarrier("AMtrust");
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.Sub_ClassCode("single");
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.Carrier_specific_Question_Verify("AMTrutQuetions");
		WaitMethods.wait_in_seconds(2);	

		WCnewUIMethods.amTrustCarrierPaymentPlan("Happy");
		GenericMethods.click_Element(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(30);

		WCnewUIMethods.paymentBreakDown_page("Bind_or_submitUW");
		WaitMethods.wait_in_seconds(5);
	}

	//BusinessInfo Page 2 Ex. Mod Value is greater then 0.00 
	//With Employer Carrier everting goes well -Submission No. Created too.
	//This ReferaL Condition 
	@Test(enabled = true,priority=2)
	public static void ts02_exMod_EmolyersVerify()throws IOException, InterruptedException, Exception, AWTException
	{
		initialize_agency_environment("environment","chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		//GenericMethods.navigate_to_url(OR.getProperty("wcDev"));
		WCnewUIMethods.Business_MailingAddress(2,"same");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		//Ex Mod. Value. select 4th row in Excel
		WCnewUIMethods.businessInfoPage2(4,"otherThenCA","Ex.Yes");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.coverageHistoryWithNOoption("empNo");
		WaitMethods.wait_in_seconds(2);
		WCnewUIMethods.classCode_fill(4,"double");	
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.ownersAndOfficers(2);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.credit_Opp_Verify_AvaibalityOf_All_11_Questions();
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(20);

		WCnewUIMethods.CarrierOption("Amtrust&Employer");
		WaitMethods.wait_in_seconds(10);

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
		WaitMethods.wait_in_seconds(30);

		WCnewUIMethods.paymentBreakDown_page("Bind_or_submitUW");
		WaitMethods.wait_in_seconds(5);
	}

	//===========================Not in Use=====================================
	//BusinessInfo Page 2 Ex. Mod Value is greater then 0.00 
	//With AMtrust Carrier everting goes well -Submission No. Created too.
	//This ReferaL Condition Removed. 
	@Test(enabled = false,priority=3)
	public static void ts02_exMod_referal_EmolyersVerify()throws IOException, InterruptedException, Exception, AWTException
	{
		initialize_agency_environment("environment","chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		//GenericMethods.navigate_to_url(OR.getProperty("wcDev"));
		WCnewUIMethods.Business_MailingAddress(2,"same");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		//Ex Mod. Value. select 4th row in Excel
		WCnewUIMethods.businessInfoPage2(4,"otherThenCA","Ex.Yes");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.coverageHistoryWithNOoption("empNo");
		WaitMethods.wait_in_seconds(2);
		WCnewUIMethods.classCode_fill(4,"double");	
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.ownersAndOfficers(2);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.credit_Opp_Verify_AvaibalityOf_All_11_Questions();
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(20);

		WCnewUIMethods.CarrierOption("Amtrust&Employer");
		WaitMethods.wait_in_seconds(10);

		WCnewUIMethods.Additional_Info_Verify_AvaibalityOf_All_23_Questions("QuesNo");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(40);

		WCnewUIMethods.selectCarrier("Employer");
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.Sub_ClassCode("double");
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.Carrier_specific_Question_Verify("employerQuetions");
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.employerCarrierPaymentPlan("Happy");
		GenericMethods.click_Element(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(50);

		WCnewUIMethods.paymentBreakDown_page("BrokerFee_YES");
		WaitMethods.wait_in_seconds(5);

		WCnewUIMethods.ThankYou_page_paymentRecPolicyPending();
		WaitMethods.wait_in_seconds(2);
	}

}
