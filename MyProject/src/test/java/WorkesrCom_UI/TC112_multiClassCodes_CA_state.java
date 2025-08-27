package WorkesrCom_UI;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.BtisNewUI.PageMethods.WCnewUIMethods;
import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.TestBase.TestBase;

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})

public class TC112_multiClassCodes_CA_state extends TestBase {

	public static final Logger log= Logger.getLogger(TC112_multiClassCodes_CA_state.class.getName());

	//To Verify List of Class Codes with CA state
	//20 States Iterations we are going to Run 
	// for Employer Carriers.
	@Test(enabled = true,priority=1)
	public static void ts01_employer_flow_multiCalssCodes_verify()throws IOException, InterruptedException, Exception, AWTException
	{
		initialize_agency_environment("environment","chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();	
		WCnewUIMethods.select_WC_Program();
		// Multi  Class code CA States list method.
		WCnewUIMethods.multiClassCodes_CA_state_Employer(2);
	}




	//To Verify List of Class Codes with CA state
	//20 States Iterations we are going to Run 
	// for AMtrust Carriers.
	@Test(enabled = true,priority=2)
	public static void ts02_AMtrust_flow_multiCalssCodes_verify()throws IOException, InterruptedException, Exception, AWTException
	{
		initialize_agency_environment("environment","chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();	
		WCnewUIMethods.select_WC_Program();
		// Multi Class code CA States list method.
		WCnewUIMethods.multiClassCodes_CA_state_AMTrust(2);
	}

}
