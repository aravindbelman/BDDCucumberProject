package com.LegacyApplication.PageMethods;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.LegacyApplication.ExcelReader.ExcelReader;
import com.LegacyApplication.Locations.Locations;
import com.LegacyApplication.PageLocators.HomePageLocators;
import com.LegacyApplication.TestBase.TestBase;
import com.LegacyApplication.Utilities.GenericMethods;
import com.LegacyApplication.Utilities.WaitMethods;

public class HomePageMethods extends TestBase {

	public static final Logger log=Logger.getLogger(HomePageMethods.class.getName());

	// This method is used to login as Agency
	public static void login_as_agency(String excel_path, String sheet_name, String user_name, String password) throws AWTException, IOException 
	{
		load_data();
		WaitMethods.wait_for_page_load(10);
		ExcelReader.set_excel_file(excel_path, sheet_name);
	    //ExcelReader.set_excel_file(Locations.testDataFilePath, "Login_Info");
		HomePageLocators.homepagelogin.click();
		log.info("Clicked on Login tab and object is "+HomePageLocators.homepagelogin.toString());
		if(OR.getProperty("environment").equalsIgnoreCase("test")&& driver.getCurrentUrl().contains("test"))
		{
		HomePageLocators.agencyCode.sendKeys(ExcelReader.get_row_data_from_col(user_name, 1));
		log.info("Entered Agency Code and the object is "+HomePageLocators.agencyCode.toString());
		WaitMethods.wait_for_element_present(HomePageLocators.agencyPassword);
		HomePageLocators.agencyPassword.sendKeys(ExcelReader.get_row_data_from_col(password, 1));
		log.info("Entered Agency Password and the object is "+HomePageLocators.agencyPassword.toString());
		WaitMethods.wait_for_page_load(10);
		}
		else if(OR.getProperty("dev_environment").equalsIgnoreCase("dev")&& driver.getCurrentUrl().contains("dev"))
		{
		HomePageLocators.agencyCode.sendKeys(ExcelReader.get_row_data_from_col(user_name, 2));
		log.info("Entered Agency Code and the object is "+HomePageLocators.agencyCode.toString());
		WaitMethods.wait_for_element_present(HomePageLocators.agencyPassword);
		HomePageLocators.agencyPassword.sendKeys(ExcelReader.get_row_data_from_col(password, 2));
		log.info("Entered Agency Password and the object is "+HomePageLocators.agencyPassword.toString());
		WaitMethods.wait_for_page_load(10);
		}
		else if(OR.getProperty("staging_environment").equalsIgnoreCase("staging") && driver.getCurrentUrl().contains("staging"))
		{
		HomePageLocators.agencyCode.sendKeys(ExcelReader.get_row_data_from_col(user_name, 3));
		log.info("Entered Agency Code and the object is "+HomePageLocators.agencyCode.toString());
		WaitMethods.wait_for_element_present(HomePageLocators.agencyPassword);
		HomePageLocators.agencyPassword.sendKeys(ExcelReader.get_row_data_from_col(password, 3));
		log.info("Entered Agency Password and the object is "+HomePageLocators.agencyPassword.toString());
		WaitMethods.wait_for_page_load(10);
		}
		else if(OR.getProperty("production_environment").equalsIgnoreCase("production")&& driver.getCurrentUrl().contains("https://my.btisinc.com/"))
		{
		HomePageLocators.agencyCode.sendKeys(ExcelReader.get_row_data_from_col(user_name, 4));
		log.info("Entered Agency Code and the object is "+HomePageLocators.agencyCode.toString());
		WaitMethods.wait_for_element_present(HomePageLocators.agencyPassword);
		HomePageLocators.agencyPassword.sendKeys(ExcelReader.get_row_data_from_col(password, 4));
		log.info("Entered Agency Password and the object is "+HomePageLocators.agencyPassword.toString());
		WaitMethods.wait_for_page_load(10);
		}
		HomePageLocators.loginButton.click();
		log.info("Clicked on Login button and object is "+HomePageLocators.loginButton.toString());
		log.debug("Logged in successfully !!! ");
	}
	
		
	// This method is used to login as Agency
	//Parameters (username, Password, row_num)
	public static void login_as_agency(String excel_path, String sheet_name,String username, String password, int row_num) throws AWTException, IOException 
	{
		//ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "Agency_Info");
		ExcelReader.set_excel_file(excel_path, sheet_name);
		HomePageLocators.homepagelogin.click();
		log.info("Clicked on Login tab and object is "+HomePageLocators.homepagelogin.toString());
		HomePageLocators.agencyCode.sendKeys(ExcelReader.get_row_data_from_col(username, row_num));
		log.info("Entered Agency Code and the object is "+HomePageLocators.agencyCode.toString());
		WaitMethods.wait_for_element_present(HomePageLocators.agencyPassword);
		HomePageLocators.agencyPassword.sendKeys(ExcelReader.get_row_data_from_col(password, row_num));
		log.info("Entered Agency Password and the object is "+HomePageLocators.agencyPassword.toString());
		WaitMethods.wait_for_page_load(10);
		HomePageLocators.loginButton.click();
		log.info("Clicked on Login button and object is "+HomePageLocators.loginButton.toString());
		log.debug("Login  successfully !!! ");
	}

	//This method is used to login as admin
	public static void login_as_admin() 
	{
		HomePageLocators.adminusername.sendKeys(OR.getProperty("adminusername"));
		log.info("Entered Admin Login and the object is "+HomePageLocators.adminusername.toString());
		HomePageLocators.adminpassword.sendKeys(OR.getProperty("adminpassword"));
		log.info("Entered Agency Password and the object is "+HomePageLocators.agencyPassword.toString());
		HomePageLocators.adminloginbutton.click();
		log.info("Clicked on Login button and object is "+HomePageLocators.loginButton.toString());
		WaitMethods.wait_for_page_load(10);
		log.debug("Login  successfully !!! ");
	}

	// Method for selecting the agency contact
	public static void select_agency_contact() throws AWTException, InterruptedException {

		Select agyContact = new Select(HomePageLocators.contactinfo);
		List<WebElement> list = agyContact.getOptions();
		list.get(1).click();
		HomePageLocators.submitMobile.click();
		WaitMethods.wait_in_seconds(5);
		//GenericMethods.click_enter_using_robot();
		//GenericMethods.accept_alert();
	}
	
	//This method is used to select Agency_Contact
	public static void select_agency_contact(String excel_path, String sheet_name, String agency_contact, int row_num) throws AWTException, InterruptedException, IOException {
		
		//ExcelReader.set_excel_file(Locations.BrokerFeeDataFilePath, "Agency_Info");
		/*GenericMethods.select_from_dropdown(HomePageLocators.contactinfo, "value", ExcelReader.get_row_data_from_col(agency_contact, row_num));
		HomePageLocators.submitMobile.click();
		WaitMethods.wait_in_seconds(5);
		GenericMethods.click_enter_using_robot();*/
		
		ExcelReader.set_excel_file(excel_path, sheet_name);
		Select agyContact = new Select(HomePageLocators.contactinfo);
		List<WebElement> list = agyContact.getOptions();
		for(int i=0; i<list.size(); i++)
		{
			if(list.get(i).getText().equalsIgnoreCase(ExcelReader.get_row_data_from_col(agency_contact, row_num)))
			{
				list.get(i).click();
				log.info("The Agency Contact selected is " +list.get(i));
			}
			else
			{
				log.info("The specified Agency Contact is not available in the list, therefore choosing the default agency contact");
				list.get(1).click();
			}
		}
		HomePageLocators.submitMobile.click();
		WaitMethods.wait_in_seconds(5);
		GenericMethods.click_enter_using_robot();
}
	
}




