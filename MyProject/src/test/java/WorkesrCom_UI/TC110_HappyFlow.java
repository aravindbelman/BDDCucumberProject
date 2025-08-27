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

public class TC110_HappyFlow extends TestBase{
	public static final Logger log= Logger.getLogger(TC110_HappyFlow.class.getName());


	//Happy Flow to Test Employer Carrier with Single ClassCode.
	//Direct Bind -only No service Fee
	@Test(enabled = true,priority=1)

	public static void ts01_employer_flow_verify()throws IOException, InterruptedException, Exception, AWTException
	{
		initialize_agency_environment("environment","chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		//GenericMethods.navigate_to_url(OR.getProperty("wcDev"));
		WaitMethods.wait_in_seconds(20);
		WCnewUIMethods.Business_MailingAddress(2,"same");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		WCnewUIMethods.businessInfoPage2(1,"otherThenCA","Ex.No");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2); 
		WCnewUIMethods.coverageHistoryWithNOoption("empNo");
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.classCode_fill(5,"single");	
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

	//AMTrust Carrier
	//Happy Flow to Test AMTrust Carrier with Double ClassCode.
	//Direct Bind -only No service Fee

	@Test(enabled = true,priority=2)
	public static void ts02_AMTrust_flow_verify()throws IOException, InterruptedException, Exception, AWTException
	{	
		initialize_agency_environment("environment","chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		//GenericMethods.navigate_to_url(OR.getProperty("wcDev"));
		WaitMethods.wait_in_seconds(20);
		WCnewUIMethods.Business_MailingAddress(2,"same");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		WCnewUIMethods.businessInfoPage2(1,"otherThenCA","Ex.No");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		WCnewUIMethods.coverageHistoryWithNOoption("empNo");
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

	//============================================================================================================
	//AMTrust Carrier
	//Happy Flow to Test AMTrust Carrier with Double ClassCode.
	//to Taste Payment Gateway---upto Pay Now Button

	@Test(enabled = true,priority=3)
	public static void ts03_AMTrust_flow_verify_uptpPayNow()throws IOException, InterruptedException, Exception, AWTException
	{	
		initialize_agency_environment("environment","chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		//GenericMethods.navigate_to_url(OR.getProperty("wcDev"));
		WaitMethods.wait_in_seconds(20);
		WCnewUIMethods.Business_MailingAddress(2,"same");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		WCnewUIMethods.businessInfoPage2(1,"otherThenCA","Ex.No");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		WCnewUIMethods.coverageHistoryWithNOoption("empNo");
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

	//============================================================================================================
	//Pie Carrier
	//Happy Flow to Test Pie Carrier with Double ClassCode.
	//take it to Submit Underwriter Btn if Rate appear.

	@Test(enabled = true,priority=4)
	public static void ts04_Pie_flow_verify()throws IOException, InterruptedException, Exception, AWTException
	{	
		initialize_agency_environment("environment","chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		//GenericMethods.navigate_to_url(OR.getProperty("wcDev"));
		WaitMethods.wait_in_seconds(20);
		WCnewUIMethods.Business_MailingAddress(2,"same");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		WCnewUIMethods.businessInfoPage2(1,"otherThenCA","Ex.No");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		WCnewUIMethods.coverageHistoryWithNOoption("empNo");
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.classCode_fill(4,"double");	
		GenericMethods.click_Element(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.ownersAndOfficers(2);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.credit_Opp_Verify_AvaibalityOf_All_11_Questions();
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);

		WCnewUIMethods.CarrierOption("Pie");
		WaitMethods.wait_in_seconds(5);

		WCnewUIMethods.Additional_Info_Verify_AvaibalityOf_All_23_Questions("QuesNo");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(40);
		
		
		if(WCnewUILocators.priceIndiacationPage_Heading.isDisplayed()==true){
		WCnewUIMethods.selectCarrier("Pie");
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.verify_ThankuPage();
		WaitMethods.wait_in_seconds(2);
		}
		else if(WCnewUILocators.thankYou_page_txt.isDisplayed()==true)
		{
			WCnewUIMethods.verify_ThankuPage();
			WaitMethods.wait_in_seconds(2);
		}
	}
}

