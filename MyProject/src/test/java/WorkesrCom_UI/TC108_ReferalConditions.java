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

public class TC108_ReferalConditions extends TestBase {
	public static final Logger log= Logger.getLogger(TC108_ReferalConditions.class.getName());

	//Referal Condition 1
	//Owners & Officers page
	//any Include refere submission to Thanku page. 
	@Test(enabled = true,priority=1)
	public static void ts01_Include_OwnersInfo_verify()throws IOException, InterruptedException, Exception, AWTException
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

		WCnewUIMethods.classCode_fill(2,"double");	
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		//Include as owner & Officer page select 1st in Excel
		WCnewUIMethods.ownersAndOfficers(1);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.credit_Opp_Verify_AvaibalityOf_All_11_Questions();
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.CarrierOption("Amtrust&Employer");
		WaitMethods.wait_in_seconds(5);

		WCnewUIMethods.Additional_Info_Verify_AvaibalityOf_All_23_Questions("QuesNo");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(30);

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

	//Referal Condition 1.2
	//This refer works only when Other is choose as Carrier But AmTrust & Employer - dont shows any Rate (Unavailabe) 
	//then we choose Other & verify ThankU message.
	//This method runs ONLY when both carriers are down.
	@Test(enabled = true,priority=8)
	public static void ts02_Include_OwnersInfo_verifyWith_Other()throws IOException, InterruptedException, Exception, AWTException
	{
		initialize_agency_environment("environment","chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		//GenericMethods.navigate_to_url(OR.getProperty("wcDev"));
		WCnewUIMethods.Business_MailingAddress(2,"same");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		WCnewUIMethods.businessInfoPage2(1,"otherThenCA","Ex.No");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		WCnewUIMethods.coverageHistoryWithNOoption("empNo");
		WaitMethods.wait_in_seconds(2);
		WCnewUIMethods.classCode_fill(2,"double");	
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.ownersAndOfficers(2);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.credit_Opp_Verify_AvaibalityOf_All_11_Questions();
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.CarrierOption("All3CarrierOption");
		WaitMethods.wait_in_seconds(10);

		WCnewUIMethods.Additional_Info_Verify_AvaibalityOf_All_23_Questions("QuesYes");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(30);

		WCnewUIMethods.selectCarrier("AM_Emp_unavail_Other");
		WaitMethods.wait_in_seconds(5);

		WCnewUIMethods.verify_ThankuPage();
		WaitMethods.wait_in_seconds(2);
	}




	//Referal Condition 4
	//Coverage Hisory Page 2 
	//If " having employee's working?" as YES choose option
	//That submission refered to Thanku page. 
	@Test(enabled = true,priority=5)
	public static void ts05_coverageHistory_ReferVerify()throws IOException, InterruptedException, Exception, AWTException
	{
		initialize_agency_environment("environment","chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		//GenericMethods.navigate_to_url(OR.getProperty("wcDev"));

		WCnewUIMethods.Business_MailingAddress(2,"same");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.businessInfoPage2(1,"otherThenCA","Ex.No");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		//Coverage History - Currently having Employee ? - Yes as Answer
		WCnewUIMethods.coverageHistoryWithNOoption("empYes");
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.classCode_fill(2,"double");	
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.ownersAndOfficers(2);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.credit_Opp_Verify_AvaibalityOf_All_11_Questions();
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.CarrierOption("Amtrust&Employer");
		WaitMethods.wait_in_seconds(5);

		WCnewUIMethods.Additional_Info_Verify_AvaibalityOf_All_23_Questions("QuesNo");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(30);

		WCnewUIMethods.selectCarrier("AMtrust");
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.Sub_ClassCode("double");
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.Carrier_specific_Question_Verify("AMTrutQuetions");
		WaitMethods.wait_in_seconds(10);	

		WCnewUIMethods.amTrustCarrierPaymentPlan("Happy");
		GenericMethods.click_Element(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(50);

		WCnewUIMethods.paymentBreakDown_page("Bind_or_submitUW");
		WaitMethods.wait_in_seconds(5);
	}

	//Referal Condition 6
	//Owner Officers page
	//Description Text box "Virus, Malware, Phishing, Spoofing, Hacking, Phreaking" "Construction
	//Roofing
	//Logistic
	//Trucking "Keywords will refer to Referal

	@Test(enabled = true,priority=7)
	public static void ts07_keyWord_ReferVerify()throws IOException, InterruptedException, Exception, AWTException
	{	
		initialize_agency_environment("environment","chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		//GenericMethods.navigate_to_url(OR.getProperty("wcDev"));

		WCnewUIMethods.Business_MailingAddress(2,"same");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.businessInfoPage2(1,"otherThenCA","Ex.No");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.coverageHistoryWithNOoption("empNo");
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.classCode_fill(2,"double");	
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);


		//Description field having Keywords
		WCnewUIMethods.ownersAndOfficers(4);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.credit_Opp_Verify_AvaibalityOf_All_11_Questions();
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.CarrierOption("Amtrust&Employer");
		WaitMethods.wait_in_seconds(5);

		WCnewUIMethods.Additional_Info_Verify_AvaibalityOf_All_23_Questions("QuesNo");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(30);

		WCnewUIMethods.selectCarrier("AMtrust");
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.Sub_ClassCode("double");
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.Carrier_specific_Question_Verify("AMTrutQuetions");
		WaitMethods.wait_in_seconds(10);	

		WCnewUIMethods.amTrustCarrierPaymentPlan("Happy");
		GenericMethods.click_Element(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(50);

		WCnewUIMethods.paymentBreakDown_page("Bind_or_submitUW");
		WaitMethods.wait_in_seconds(5);

	}

	//Referal Condition 3
	//BusinessInfo Page 1
	//If any additional address added 
	//That submission refered to Thanku page. 
	@Test(enabled = true,priority=4)
	public static void ts04_additional_Address_ReferVerify()throws IOException, InterruptedException, Exception, AWTException
	{
		initialize_agency_environment("environment","chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();

		//Additional Address refered to Thank You page
		WCnewUIMethods.Business_Mailing_Additional_Address(1,"different");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.businessInfoPage2(1,"otherThenCA","Ex.No");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.coverageHistoryWithNOoption("empNo");
		WaitMethods.wait_in_seconds(2);
		WCnewUIMethods.classCode_fill(2,"single");	
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.ownersAndOfficers(2);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.credit_Opp_Verify_AvaibalityOf_All_11_Questions();
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.CarrierOption("Amtrust&Employer");
		WaitMethods.wait_in_seconds(5);

		WCnewUIMethods.Additional_Info_Verify_AvaibalityOf_All_23_Questions("QuesNo");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(30);

		WCnewUIMethods.verify_ThankuPage();
		WaitMethods.wait_in_seconds(2);
	}
}
