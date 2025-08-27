package StarUI;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.BtisNewUI.PageMethods.StarrUIMethods;
import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.WaitMethods;

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})

public class TC098_Submission_MultiplePaymentOptions extends TestBase
{
	public static final Logger log= Logger.getLogger(TC098_Submission_MultiplePaymentOptions.class.getName());
	
	//==================Pay Now Payement method==============
	@Test(priority = 1,enabled = true)
	public static void starr_PayNow_payement() throws IOException, InterruptedException, Exception, AWTException
	{
		initialize_agency_environment("environment","chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();		
		StarrUIMethods.LetsGetStarted(1,"Marine");
		StarrUIMethods.Personal_and_BusinessInfo(1,"same");
		StarrUIMethods.your_Operations_marineArtisan();
		StarrUIMethods.additionalDetail();
		StarrUIMethods.priceIndication(1);
		StarrUIMethods.addBrokerFee();
		StarrUIMethods.checkOutPage(1);
		
		WaitMethods.wait_in_seconds(3);
		StarrUIMethods.payNow_paymentMode();
		StarrUIMethods.paymentMod_Select();
		StarrUIMethods.payEzee(1);
		WaitMethods.wait_in_seconds(3);
		StarrUIMethods.finishPage(1);
		StarrUIMethods.click_policy_and_Review_Document_EditFinish("Quote_Number",1,"Marine");
	}
	
	//==================manualFinance Payement method==============
	
	@Test(priority = 2,enabled = true)
	public static void starr_manualFinance_payement() throws IOException, InterruptedException, Exception, AWTException
	{
		initialize_agency_environment("environment","chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();		
		StarrUIMethods.LetsGetStarted(1,"SmallMarine");
		StarrUIMethods.Personal_and_BusinessInfo(2,"same");
		StarrUIMethods.your_Operations_SmallmarineContractor();
		StarrUIMethods.additionalDetail();
		StarrUIMethods.priceIndication(1);
		StarrUIMethods.addBrokerFee();
		StarrUIMethods.checkOutPage(1);
		
		WaitMethods.wait_in_seconds(3);
		StarrUIMethods.manualFinance_paymentMode();
		StarrUIMethods.paymentMod_Select();
		StarrUIMethods.payEzee(1);
		WaitMethods.wait_in_seconds(3);
		StarrUIMethods.finishPage(1);
		StarrUIMethods.click_policy_and_Review_Document_EditFinish("Quote_Number",1,"SmallMarine");
	}
	
	//==================paperlessFinance Payement method==============
	
	@Test(priority = 3,enabled = true)
	public static void starr_paperlessFinance_payement() throws IOException, InterruptedException, Exception, AWTException
	{
		initialize_agency_environment("environment","chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();		
		StarrUIMethods.LetsGetStarted(1,"Marine");
		StarrUIMethods.Personal_and_BusinessInfo(1,"same");
		StarrUIMethods.your_Operations_marineArtisan();
		StarrUIMethods.additionalDetail();
		StarrUIMethods.priceIndication(1);
		StarrUIMethods.addBrokerFee();
		StarrUIMethods.checkOutPage(1);
		
		WaitMethods.wait_in_seconds(3);
		StarrUIMethods.paperlessFinance_paymentMode();
		StarrUIMethods.paymentMod_Select();
		StarrUIMethods.payEzee(1);
		StarrUIMethods.finishPage(1);
		StarrUIMethods.click_policy_and_Review_Document_EditFinish("Quote_Number",1,"Marine");
	}
}
