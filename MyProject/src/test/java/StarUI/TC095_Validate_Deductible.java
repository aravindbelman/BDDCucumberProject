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



//This test is to perform or Validate Deductible Drop down - showing correct value or Not -depends on Gross Receipt value

@Listeners({com.LegacyApplication.CustomListner.ExecutionListner.class, com.LegacyApplication.CustomListner.Listner.class, com.LegacyApplication.CustomListner.RetryListner.class})
public class TC095_Validate_Deductible extends TestBase {

	public static final Logger log= Logger.getLogger(TC095_Validate_Deductible.class.getName());

	@Test
	public static void validate_deuctible() throws IOException, InterruptedException, Exception, AWTException
	{
		initialize_agency_environment("environment","chrome_browser");
		InitializeElements.initialize_elements();
		HomePageMethods.login_as_agency(Locations.testDataFilePath, "Login_Info","Username","Password");
		HomePageMethods.select_agency_contact();	
		StarrUIMethods.LetsGetStarted(1,"Marine");
		StarrUIMethods.deductible_dropdown_validate(10);
	}
}
