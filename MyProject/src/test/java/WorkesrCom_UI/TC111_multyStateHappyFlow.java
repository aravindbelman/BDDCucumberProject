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
	
public class TC111_multyStateHappyFlow extends TestBase{
	public static final Logger log= Logger.getLogger(TC111_multyStateHappyFlow.class.getName());
	
		//Happy Flow to Test Employer Carrier with Single ClassCode.
		//for States - (CA,TX,AZ,CO,GA,IL,OR,NJ,PA,MO,NV,TN,VA,OK,NC)
		//Direct Bind -only No service Fee
		@Test(enabled = true,priority=1)
		public static void ts01_employer_flow_verify()throws IOException, InterruptedException, Exception, AWTException
		{	
			initialize_agency_environment("environment","chrome_browser");
			InitializeElements.initialize_elements();
			HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
			HomePageMethods.select_agency_contact();	
			WCnewUIMethods.select_WC_Program();
			// Multi States address list method.
			WCnewUIMethods.Business_MailingAddressMultiState_Employer();
					
		}
		
		//AMTrust Carrier
		//Happy Flow to Test AMTrust Carrier with Double ClassCode.
		//for States - (CA,TX,AZ,CO,GA,IL,OR,NJ,PA,MO,NV,TN,VA,OK,NC)
		//Direct Bind -only No service Fee
		
		@Test(enabled = true,priority=2)
		public static void ts02_AMTrust_flow_verify()throws IOException, InterruptedException, Exception, AWTException
		{	
			initialize_agency_environment("environment","chrome_browser");
			InitializeElements.initialize_elements();
			HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
			HomePageMethods.select_agency_contact();
			WCnewUIMethods.select_WC_Program();
			// Multi States address list method.
			WCnewUIMethods.Business_MailingAddressMultiState_AMTrust();
					
		}
}
