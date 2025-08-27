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

public class TC105_AdditionalInfo_Page8 extends TestBase{

	public static final Logger log= Logger.getLogger(TC105_AdditionalInfo_Page8.class.getName());

	@Test(enabled = true,priority=1)
	//To test Credit Opportunity page
	// Verify all Question appear or Not & If we choose YES addd text in it. Verify
	public static void ts01_additionalInfo_Page_verify()throws IOException, InterruptedException, Exception, AWTException
	{
		initialize_agency_environment("environment","chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		WCnewUIMethods.Business_MailingAddress(2,"same");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		WCnewUIMethods.businessInfoPage2(1,"forCA","Ex.No");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		WCnewUIMethods.coverageHistoryWithNOoption("empNo");
		WaitMethods.wait_in_seconds(2);
		WCnewUIMethods.classCode_fill(5,"double");	
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		WCnewUIMethods.ownersAndOfficers(2);
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
		
		WCnewUIMethods.credit_Opp_Verify_AvaibalityOf_All_11_Questions();
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
				
		WCnewUIMethods.CarrierOption("Other");
		
		WCnewUIMethods.Additional_Info_Verify_AvaibalityOf_All_23_Questions("QuesYes");
		GenericMethods.click_Element_Using_JS(WCnewUILocators.next_btn);
		WaitMethods.wait_in_seconds(2);
	}
}
