package NEXT_GL_UI;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.BtisNewUI.Locators.NEXT_UI_locators;
import com.BtisNewUI.PageMethods.NextUImethods;
import com.LegacyApplication.InitializeElements.InitializeElements;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageMethods.HomePageMethods;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})

public class TC111_NextSubmission extends TestBase{
	
	public static final Logger log= Logger.getLogger(TC111_NextSubmission.class.getName());
	
	@Test
	public static void next_sbmission() throws IOException, InterruptedException, Exception, AWTException
	{
		initialize_agency_environment("staging_environment","chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();
		
		NextUImethods.nextLet_geta_quote(1);
		//NextUImethods.alertPop();
		
		NextUImethods.nexAbout_your_customer(1);
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.nxt_Btn);
		WaitMethods.wait_in_seconds(2);
		
		NextUImethods.nexAbout_the_company(1);
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.nxt_Btn);
		WaitMethods.wait_in_seconds(2);
		
		NextUImethods.nxtAbout_the_services(1);
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.nxt_Btn);
		WaitMethods.wait_in_seconds(5);
		
		NextUImethods.nxtAbout_the_services2(1);
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.nxt_Btn);
		WaitMethods.wait_in_seconds(2);
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.nxt_Btn);
		
		NextUImethods.nxtAbout_the_business_GC(1);
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.nxt_Btn);
		WaitMethods.wait_in_seconds(2);
		
		NextUImethods.nxtAbout_the_subcontracting_GC(1);
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.nxt_Btn);
		WaitMethods.wait_in_seconds(2);
		
		NextUImethods.nxtAbout_the_work_GC(1);
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.nxt_Btn);
		WaitMethods.wait_in_seconds(2);
		
		NextUImethods.nxtAbout_the_GC(1);
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.nxt_Btn);
		WaitMethods.wait_in_seconds(2);
		
		NextUImethods.nxtInsurance_Details_GC(1);
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.nxt_Btn);
		WaitMethods.wait_in_seconds(2);
		
		NextUImethods.nxtAbout_the_insuranceGC();
		GenericMethods.click_Element_Using_JS(NEXT_UI_locators.nxt_Btn);
		WaitMethods.wait_in_seconds(2);
		
		NextUImethods.nxtAbout_the_quote_GC();
		WaitMethods.wait_in_seconds(5);
		
		NextUImethods.nxtthe_quote_values_GC(1);
		WaitMethods.wait_in_seconds(2);
		
		NextUImethods.about_SummaryPAGE();
		WaitMethods.wait_in_seconds(2);
		
		NextUImethods.nxt_paymentPage_GC(1);
		WaitMethods.wait_in_seconds(2);
	}
}
