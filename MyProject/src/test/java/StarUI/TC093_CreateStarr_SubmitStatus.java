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
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;


// This test is to test Starr with SUBMITTED status to test EDIT and Finish.

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})
public class TC093_CreateStarr_SubmitStatus extends TestBase {
	public static final Logger log= Logger.getLogger(TC093_CreateStarr_SubmitStatus.class.getName());
	@Test
	public static void starr_marineSubmission_Submit_status() throws IOException, InterruptedException, Exception, AWTException
	{
		initialize_agency_environment("staging_environment","chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		StarrUIMethods.LetsGetStarted(1,"Marine");
		StarrUIMethods.Personal_and_BusinessInfo(1,"same");
		StarrUIMethods.your_Operations_marineArtisan();
		
		StarrUIMethods.additionalDetail();
		StarrUIMethods.priceIndication(1);
		GenericMethods.close_browser_window();
		
		GenericMethods.navigate_to_next_window();
		StarrUIMethods.click_policy_and_Review_Document_EditFinish("Quote_Number",1,"Marine");
		WaitMethods.wait_in_seconds(5);	
		
		//=================================
		
		StarrUIMethods.payNow_paymentMode();
		StarrUIMethods.paymentMod_Select();
		StarrUIMethods.payEzee(1);
		WaitMethods.wait_in_seconds(3);
		StarrUIMethods.finishPage(1);
		
		//===========================================
		
		
		StarrUIMethods.verify_Submission_SOLD("Quote_Number", 1);
	}
}
