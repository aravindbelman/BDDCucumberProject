package clearSpring;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.BtisNewUI.Locators.ClearSpringLocators;
import com.BtisNewUI.PageMethods.ClearSpring_UI_Methods;
import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageLocators.AutoRenewalBrokerFeeLocators;
import com.LegacyApplication.PageLocators.DefaultBrokerFeeLocators;
import com.LegacyApplication.PageMethods.AutoRenewalBrokerFeeMethods;
import com.LegacyApplication.PageMethods.GeneralLiabilityMethods;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})
public class TC115_ClearSpringHappyFlow extends TestBase{

	public static final Logger log= Logger.getLogger(TC115_ClearSpringHappyFlow.class.getName());

	@Test(enabled = true,priority=1)
	//To test Submit QCS 
	// CO,AZ,NJ,MI,IL,AL,KS,MO,OK,TN,UT,OH
	//Its Colarado state upto submit
	public static void ts01_QCS_upTo_Submit() throws IOException, InterruptedException, Exception, AWTException
	{	
		
		initialize_agency_environment("staging_environment","chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		//ClearSpring_UI_Methods.select_CS_Program();
		ClearSpring_UI_Methods.clearSpring_MarketPalce();
		ClearSpring_UI_Methods.applicantsInfo_page1_FillDetails(3,"same");
				
		//Employee_Yes,Subcontractor_Yes,ResedentialWork_Yes   OR
		//Employee_No,Subcontractor_No,ResedentialWork_No
		ClearSpring_UI_Methods.businessInfo_page2_FillDetails(1,"Employee_Yes","Subcontractor_Yes","ResedentialWork_Yes");
		//BusinessHistory_NO,BusinessHistory_YES
		ClearSpring_UI_Methods.insuranceInfo_page3_FillDetails(1,"BusinessHistory_NO");
		ClearSpring_UI_Methods.classifications_page4_FillDetails(1);
		ClearSpring_UI_Methods.pricingOptions_page5_FillDetails("compairYes",2);
		//UW or coverage
		ClearSpring_UI_Methods.eligibility_submit_page6("coverage");
		ClearSpring_UI_Methods.brokerFee_Enhancement_page7_FillDetails(2,"yes","assertValues_yes");
		WaitMethods.wait_in_seconds(20);
		ClearSpring_UI_Methods.verify_ThankYou(1);	
	}	
}