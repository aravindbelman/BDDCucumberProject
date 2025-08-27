package clearSpring;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.BtisNewUI.PageMethods.ClearSpring_UI_Methods;
import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.TestBase.TestBase;

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})

public class TC116_CS_multiState_HappyFlow extends TestBase {
	
	public static final Logger log= Logger.getLogger(TC116_CS_multiState_HappyFlow.class.getName());
	
	@Test(enabled = true,priority=1)
	//To test Submit QCS 
	// CO,AZ,NJ,MI,IL,AL,KS,MO,OK,TN,UT,OH
	//with NJ/AZ/MI  states uto Submit
	// IL and MO states
	public static void ts02_QCS_upTo_Submit_multiState() throws IOException, InterruptedException, Exception, AWTException
	{	
		initialize_agency_environment("staging_environment","chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		ClearSpring_UI_Methods.clearSpring_MarketPalce();
		ClearSpring_UI_Methods.applicantsInfo_page1_FillDetails_multiStates("same");	
	}
	
}
