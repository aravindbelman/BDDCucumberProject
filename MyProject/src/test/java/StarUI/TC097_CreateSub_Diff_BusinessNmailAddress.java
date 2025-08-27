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

//This test is to create STARR marine submission with Different Valid Business Address state 
//and Invalid Mailing address state WI.
//This method is use to Verify It allow to create Submission with Above scenario.

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})
public class TC097_CreateSub_Diff_BusinessNmailAddress extends TestBase{
	public static final Logger log= Logger.getLogger(TC097_CreateSub_Diff_BusinessNmailAddress.class.getName());

	@Test
	public static void starr_submissionWithDifferentAddress() throws IOException, InterruptedException, Exception, AWTException
	{
		initialize_agency_environment("staging_environment","chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();		
		StarrUIMethods.LetsGetStarted(1,"Marine");
		StarrUIMethods.Personal_and_BusinessInfo(1,"different");
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

}
