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

public class TC109_PaymentPageVerify  extends TestBase{
	public static final Logger log= Logger.getLogger(TC109_PaymentPageVerify.class.getName());

	//Employers Carrier
	//Payement plan page - Verify Based On Carrier and - Gross Value - Option chnages Verify.
	/*
	 * In Payment plan page for Employers only.
	 * 1    100% Down   :    0
	 * 2    30% Down + 3 Equal Installments :  1000
	 * 3    10% Down + 9 Equal Installments   :     2500
	 * 4    0% Down + Pay-As-You-Go    :    2500
	 */
	
	/*
	 * 0-1000  ==> 100% Down 
	 * 1001-2500 ==>100% Down & 30% Down + 3 Equal Installments
	 * 2501 < ====>100% Down & 30% Down  3 Equal Installments & 10% Down + 9 Equal Installments & 0% Down + Pay-As-You-Go
	 */
	@Test(enabled = true,priority=1)
	public static void ts01_employer_PayemnetPlan_verify()throws IOException, InterruptedException, Exception, AWTException
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
		
		WCnewUIMethods.classCode_fill(3,"single");	
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
		
		WCnewUIMethods.employerCarrierPaymentPlan("condition");
		WaitMethods.wait_in_seconds(2);
	}
	
	//AMTrust Carrier
	//Payement plan page - Verify Based On Carrier and - Gross Value - Option chnages Verify.

	@Test(enabled = true,priority=2)
	public static void ts02_AMTrust_PayemnetPlan_verify()throws IOException, InterruptedException, Exception, AWTException
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
		WCnewUIMethods.classCode_fill(3,"single");	
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

		WCnewUIMethods.Sub_ClassCode("single");
		WaitMethods.wait_in_seconds(2);

		WCnewUIMethods.Carrier_specific_Question_Verify("AMTrutQuetions");
		WaitMethods.wait_in_seconds(2);	
		
		WCnewUIMethods.amTrustCarrierPaymentPlan("condition");
		WaitMethods.wait_in_seconds(2);
	}

}
